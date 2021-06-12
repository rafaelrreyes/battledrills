/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.manage;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ngc.battledrills.BattleDrillsConfig;
import com.ngc.battledrills.util.JsonUtils;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author bestdoodledad
 */
public class TaskTemplateManager {
    
    private static final Set<String> taskTemplates = new HashSet<String>();
    private static final Set<String> taskFavorites = new HashSet<String>();
    
    private static TaskTemplateManager instance;
    
    private TaskTemplateManager() {
        loadFavoritedTasks();
    }
    
    public static TaskTemplateManager getInstance() {
        if (null == instance) {
            instance = new TaskTemplateManager();
        }
        
        return instance;
    }
    
    public void loadFavoritedTasks() {
        try {
            File favoritesFile = new File(BattleDrillsConfig.getTaskFavoritesFile());
            String fileContents = FileUtils.readFileToString(favoritesFile);
            Map<String, Set<String>> favoritedTasks = new ObjectMapper().readValue(fileContents, new TypeReference<Map<String, Set<String>>>() {});
            taskFavorites.addAll(favoritedTasks.get("favorites"));
            
        } catch (Exception e) {
            System.err.println("Error when loading favorited tasks from json file." + e);
        }
    }
    
    public void addTaskTemplate(String taskDescription) {
        taskTemplates.add(taskDescription);
    }
    
    public Set<String> getTaskTemplates() {
        return this.taskTemplates;
    }
    
    public void addToFavorites(String favoritedTask) {
        taskFavorites.add(favoritedTask);
        updateJsonFile();
    }
    
    public boolean removeFromFavorites(String unfavoritedTask) {
        boolean isRemoved = false;
        if (taskFavorites.contains(unfavoritedTask)) {
            isRemoved = taskFavorites.remove(unfavoritedTask);
            updateJsonFile();
        }
        
        return false;
    }
    
    public Map<String, List<String>> getTaskTemplatesData() {
        Map<String, List<String>> responseData = new HashMap<>();
        List<String> listedFavorites = new ArrayList<>(taskFavorites);
        responseData.put("favorites", listedFavorites);
        
        // sort task templates
        List<String> sortedTaskTemplates = new ArrayList<>(taskTemplates);
        Collections.sort(sortedTaskTemplates);
        responseData.put("templates", sortedTaskTemplates);
        return responseData;
    }
    
    public void updateJsonFile() {
        try {
            Map<String, Set<String>> fileData = new HashMap<>();
            fileData.put("favorites", taskFavorites);
            File file = FileUtils.getFile(BattleDrillsConfig.getTaskFavoritesFile());
            FileUtils.writeStringToFile(file, JsonUtils.writeValue(fileData), StandardCharsets.UTF_8);
        } catch(Exception e) {
            System.err.println("Error when updating task favorites template json file.");
        }
    }
}
