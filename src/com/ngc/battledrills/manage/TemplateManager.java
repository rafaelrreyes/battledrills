/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.manage;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ngc.battledrills.BattleDrillsConfig;
import com.ngc.battledrills.data.BattleDrill;
import com.ngc.battledrills.data.Node;
import com.ngc.battledrills.data.Task;
import com.ngc.battledrills.data.User;
import com.ngc.battledrills.exception.DuplicateItemException;
import com.ngc.battledrills.template.BattleDrillTemplate;
import com.ngc.battledrills.exception.ItemNotFoundException;
import com.ngc.battledrills.json.JsonFilterProvider;
import com.ngc.battledrills.util.JsonUtils;
import com.ngc.battledrills.util.JacksonInjectableValues;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author admin
 */
public class TemplateManager {
    private static final Map<String, BattleDrillTemplate> default_templates = new HashMap<>();
    private static final Map<String, BattleDrillTemplate> custom_templates = new HashMap<>();
    private static final Map<String, String> overwritten_templates = new HashMap<>();
    
    private TemplateManager(){
        loadAllTemplates();
    }
    
    public static TemplateManager getInstance() {
        return TemplateManagerFactory.instance;
    } 
    
    private static class TemplateManagerFactory {
        // Lazy initialize the TemplateManager singleton
        private static final TemplateManager instance = new TemplateManager();
    }
    
    public BattleDrillTemplate getByType(String type)
    {
        // if there exists a customized version of this drill, pull from that container instead of default templates
        // this is for cases where admins prefer to use customized drill over default, IE, saving a IED Discovered customized over default.
        if (custom_templates.containsKey(type)) {
            return custom_templates.get(type);
        }
        
        return default_templates.get(type);
    }
    
    public HashMap<String, Object> getTypes() {
        HashMap<String, Object> types = new HashMap<>();
        types.put("default", new ArrayList(default_templates.keySet()));
        
        // we only want to return to the client the custom drills that arent overwritten default templates
        Map<String, BattleDrillTemplate> filteredCustomTemplates = new HashMap<>();
        for (Map.Entry<String, BattleDrillTemplate> entry : custom_templates.entrySet()) {
            if(!overwritten_templates.containsKey(entry.getKey())) {
                filteredCustomTemplates.put(entry.getKey(), entry.getValue());
            }
        }
        types.put("overwritten", overwritten_templates);
        types.put("custom", new ArrayList(filteredCustomTemplates.keySet()));
        
        return types;
    }
    
    private void loadAllTemplates() {
        // load all default and custom templates into their respective containers
        try {
            File defaultDirectory = new File(BattleDrillsConfig.getTemplateDir());
            File customDirectory = new File(BattleDrillsConfig.getCustomTemplateDir());
            File[] defaultFiles = defaultDirectory.listFiles((d, name) -> name.endsWith(".json"));
            File[] customFiles = customDirectory.listFiles((d, name) -> name.endsWith(".json"));
            
            for(File file : defaultFiles) {
                String fileContents = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
                BattleDrillTemplate template = loadFromJson(fileContents, false);
                loadTaskRecursive(template.getRoot());
                default_templates.put(template.getType(), template);
            }
            
            for (File file : customFiles) {
                String fileContents = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
                BattleDrillTemplate template = loadFromJson(fileContents, false);
                custom_templates.put(template.getType(), template);
            }
            
            for (Map.Entry<String, BattleDrillTemplate> entry : custom_templates.entrySet()) {
                if (default_templates.containsKey(entry.getKey())) {
                    overwritten_templates.put(entry.getKey(), entry.getKey());
                }
            }
        }
        catch(IOException i)
        {
            System.err.println("Unable to load template into runtime containers: " + i);
        }
    }
    
    private void loadTaskRecursive(Node node) {
        // if the current node has tasks, add to templates list
        if (node.getTasks().size() > 0) {
            node.getTasks().forEach((task) -> {
                TaskTemplateManager.getInstance().addTaskTemplate(task.getDescription());
            });
        }
        
        // go thru each child of the current node and load task templates recursively
        if (node.getChildNodes().size() > 0) {
            node.getChildNodes().forEach((currentNode) -> {
                loadTaskRecursive(currentNode);
            });
        }
    }
    
    private BattleDrillTemplate loadFromJson(String json, boolean isSaveTemplate) throws IOException {
        InjectableValues.Std inject = new InjectableValues.Std();
        inject.addValue(JacksonInjectableValues.NEW_TASK, false);
        inject.addValue(JacksonInjectableValues.SAVE_AS_TEMPLATE, isSaveTemplate);
        BattleDrillTemplate template = new ObjectMapper().reader(inject).forType(BattleDrillTemplate.class).readValue(json);
        
        return template;
    }
    
    /**
     * Creates a new custom battle drill template that does not exist yet.
     * @param templateType
     * @param user
     * @throws JsonProcessingException
     * @throws DuplicateItemException
     * @throws IOException 
     */
    public void createTemplate(String templateType, User user) throws JsonProcessingException, DuplicateItemException, IOException {
        String formattedType = getFormattedType(templateType);
        
        // need to make sure this templateType isn't already defined as a default template or custom template
        if (custom_templates.containsKey(formattedType) || default_templates.containsKey(formattedType)) {
            throw new WebApplicationException(
                Response.status(Response.Status.CONFLICT)
                    .entity("Template already exists.")
                    .type("text/plain")
                    .build()
            );
        }
        
        BattleDrillTemplate newTemplate = new BattleDrillTemplate();
        newTemplate.setType(formattedType);
        
        String templateJson = JsonUtils.writeValue(newTemplate);
        
        // save the template as a .json file in custom templates folder
        File file = FileUtils.getFile(BattleDrillsConfig.getCustomTemplateDir() + formattedType + ".json");
        FileUtils.writeStringToFile(file, templateJson, StandardCharsets.UTF_8);
        
        // put the template in the templates container
        custom_templates.put(formattedType, newTemplate);

    }
    
    /**
     * Saves a template using the entire sent from client. Serializes the entire object by using a JSON filter.
     * @param template
     * @throws JsonProcessingException 
     */
    public void saveTemplate(String template) throws JsonProcessingException {
        // need to remove all properties not needed in a drill template
        try {
            JsonFilterProvider jsonFilterProvider = new JsonFilterProvider();
            jsonFilterProvider.addFilter(JsonUtils.DefinedFilters.BATTLE_DRILL_TEMPLATE_FILTER, new String[] {"type", "attachments", "data", "participants"});
//            jsonFilterProvider.addFilter(JsonUtils.DefinedFilters.BATTLE_DRILL_FILTER, new String[] {"type", "attachments", "data", "participants"});
            jsonFilterProvider.addFilter(JsonUtils.DefinedFilters.TASK_FILTER, new String[] {"description"});
            jsonFilterProvider.addFilter(JsonUtils.DefinedFilters.NODE_FILTER, new String[] {"title", "self_coordinates", "tasks_coordinates", "tasks", "children"});
            
            BattleDrillTemplate templateObject = loadFromJson(template, true);
            // filter out unnecessary properties of template
            String templateJson = JsonUtils.writeValueWithFilters(templateObject, jsonFilterProvider.getAllFilters());
            
            // save the template as a .json file in bd templates folder
            File file = FileUtils.getFile(BattleDrillsConfig.getCustomTemplateDir() + templateObject.getType() + ".json");
            FileUtils.writeStringToFile(file, templateJson, StandardCharsets.UTF_8);
            
            // When a default template is being overwritten
            if (default_templates.containsKey(templateObject.getType())) {
                overwritten_templates.put(templateObject.getType(), templateObject.getType());
            }
            
            // in all cases, put the template in custom templates container
            custom_templates.put(templateObject.getType(), templateObject);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    /**
     * Saves a template, whether that means overwriting an existing one or creating a new one.
     * @param templateType
     * @param drillId
     * @throws ItemNotFoundException
     * @throws JsonProcessingException 
     */
    public void saveTemplate(String templateType, String drillId, User user) throws ItemNotFoundException, JsonProcessingException {
        
        String formattedType = getFormattedType(templateType);
        
        // get the battle drill
        BattleDrillManager bdManager = BattleDrillManager.getInstance();
        BattleDrill drill = bdManager.getById(drillId);
        
        // need to turn the drill into a template, meaning remove all properties not needed in a drill template
        
        if (null == drill) {
            throw new ItemNotFoundException("Unable to save battle drill template with name: " + formattedType + " - battleDrill not found");
        }
        
        try {            
            JsonFilterProvider jsonFilterProvider = new JsonFilterProvider();
            jsonFilterProvider.addFilter(JsonUtils.DefinedFilters.BATTLE_DRILL_TEMPLATE_FILTER, new String [] {"type", "attachments", "data", "participants"});
            jsonFilterProvider.addFilter(JsonUtils.DefinedFilters.BATTLE_DRILL_FILTER, new String[] {"type", "attachments", "data", "participants"} );
            jsonFilterProvider.addFilter(JsonUtils.DefinedFilters.TASK_FILTER, new String[] {"description"});
            jsonFilterProvider.addFilter(JsonUtils.DefinedFilters.NODE_FILTER, new String[] {"roleId", "self_coordinates", "tasks_coordinates", "tasks", "children"});
            
            // change type temporarily
            String typeHolder = drill.getType();
            drill.setType(formattedType);
            String templateJson = JsonUtils.writeValueWithFilters(drill, jsonFilterProvider.getAllFilters());
            BattleDrillTemplate newTemplate = loadFromJson(templateJson, true);

            // change type back after writing template
            drill.setType(typeHolder);
            
            // save the template as a .json file in bd templates folder
            File file = FileUtils.getFile(BattleDrillsConfig.getCustomTemplateDir() + formattedType + ".json");
            FileUtils.writeStringToFile(file, templateJson, StandardCharsets.UTF_8);

            // When a default template is being overwritten
            if (default_templates.containsKey(formattedType)) {
                overwritten_templates.put(formattedType, formattedType);
            }
                    
            // put the template in the templates container
            custom_templates.put(formattedType, newTemplate);
            
            // TODO notification
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    /**
     * Deletes a custom template while also removing json file from filesystem.
     * @param templateType
     * @param user 
     */
    public void deleteTemplate(String templateType, User user) throws IOException {
        String formattedType = getFormattedType(templateType);
        removeCustomTemplate(formattedType);
        
        // TODO notification
    }
    
    /**
     * Deletes multiple templates while also removing json files from filesystem.
     * @param templates
     * @param user 
     */
    public void deleteTemplates(ArrayList<String> templates, User user) {
        for (int i = templates.size() - 1; i > 0; i--) {
            String formattedType = getFormattedType(templates.get(i));
            removeCustomTemplate(formattedType);
        }
        templates.forEach((templateType) -> {
            String formattedType = getFormattedType(templateType);
            removeCustomTemplate(formattedType);
        });
        
        // TODO notification
    }
    
    /**
     * Reverts a overwritten default template back to its factory form.
     * @param templateType
     * @param user 
     */
    public void revertTemplate(String templateType, User user) {
        String formattedType = getFormattedType(templateType);
            
        if (overwritten_templates.containsKey(formattedType)) {
            removeCustomTemplate(formattedType);
            overwritten_templates.remove(formattedType);
            
            // TODO notification
        }
        
        // TODO maybe we can return a new object here on response instead of chaining
    }
    
    public List<Task> getTasksByRoleId(String drillType, int roleId) {
        BattleDrillTemplate template = getByType(drillType);
        List<Task> targetTasks = template.getTasksByRoleId(roleId);
        return targetTasks;
    }
    
    private void removeCustomTemplate(String type) {
        if (custom_templates.containsKey(type)) {
            custom_templates.remove(type);
            
            try {
                Files.deleteIfExists(Paths.get(BattleDrillsConfig.getCustomTemplateDir() + type + ".json"));
            } catch (IOException ex) {
                System.out.println("Error when attempting to remove template: " + type + " from file system.");
            }
        }
    }
    
    private String getFormattedType(String templateType) {
        return templateType.replaceAll("\\s+", "_").toLowerCase();   
    }
}