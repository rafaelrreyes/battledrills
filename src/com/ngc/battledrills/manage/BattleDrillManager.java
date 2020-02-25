/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.manage;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.ngc.battledrills.data.BattleDrill;
import com.ngc.battledrills.BattleDrillsConfig;
import static com.ngc.battledrills.BattleDrillsConfig.DEFAULT_JSON_WRITER;
import com.ngc.battledrills.comms.Notification;
import com.ngc.battledrills.comms.Notify;
import com.ngc.battledrills.comms.NotifyManager;
import com.ngc.battledrills.comms.NotifyTypes;
import com.ngc.battledrills.exception.ItemNotFoundException;
import com.ngc.battledrills.exception.DuplicateItemException;
import com.ngc.battledrills.rest.BattleDrillRestParams;
import com.ngc.battledrills.data.TaskRepo;
import com.ngc.battledrills.data.User;
import com.ngc.battledrills.rest.OrderedDrillsRestParams;
import com.ngc.battledrills.template.BattleDrillTemplate;
import com.ngc.battledrills.util.ConvenienceUtils.VmfType;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidParameterException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author admin
 */
public class BattleDrillManager {
    // Todo - should make BattleDrillRepo objects to hold the CRUD operations, and this manager class would just manage them
    private static final Map<String, BattleDrill> activeBattleDrills = new HashMap<>();
    private static final Map<String, BattleDrill> completedBattleDrills = new HashMap<>();
    private static final ArrayList<String> orderedActiveBattleDrills = new ArrayList<String>();
    private static final ArrayList<String> orderedCompletedBattleDrills = new ArrayList<String>();

    private BattleDrillManager()
    {
        loadAll();
    }
    
    public static BattleDrillManager getInstance() {
        return BattleDrillManagerFactory.instance;
    } 
    
    private static class BattleDrillManagerFactory {
        // Lazy initialize the BattleDrillManager singleton
        private static final BattleDrillManager instance = new BattleDrillManager();
    }
    
    private void loadAll()
    {
        loadActiveDrills();
        loadCompletedDrills();
        loadOrderedDrills();
    }
    
    private void loadActiveDrills()
    {
        try
        {
            File dir = new File(BattleDrillsConfig.getActiveBattleDrillsDir());
            File[] files = dir.listFiles((d, name) -> name.endsWith(".json"));
            
            for(File file : files)
            {
                String fileContents = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
                BattleDrill battleDrill = loadFromJson(fileContents);
                activeBattleDrills.put(battleDrill.getName(), battleDrill);
            }
        }
        catch(IOException i)
        {
            System.err.println("DIANA unable to load template: " + i);
        }
    }
    
    // Diana - consider not storing the full objects, but only storing their names and then loading from the file if someone requests the full details
    private void loadCompletedDrills()
    {
        try
        {
            File dir = new File(BattleDrillsConfig.getCompletedBattleDrillsDir());
            File[] files = dir.listFiles((d, name) -> name.endsWith(".json"));
            
            for(File file : files)
            {
                String fileContents = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
                BattleDrill battleDrill = loadFromJson(fileContents);
                completedBattleDrills.put(battleDrill.getName(), battleDrill);
            }
        }
        catch(IOException i)
        {
            System.err.println("DIANA unable to load template: " + i);
        }
    }
    
    private void loadOrderedDrills()
    {
        try 
        {
            File orderedActiveDrillFile = new File(getOrderedDrillsFilename());
            if (orderedActiveDrillFile.isFile() && orderedActiveDrillFile.canRead()) {
                String json = FileUtils.readFileToString(orderedActiveDrillFile, StandardCharsets.UTF_8);
                ObjectMapper mapper = new ObjectMapper();
                HashMap<String, ArrayList<String>> drills = mapper.readValue(json, new TypeReference<HashMap<String, ArrayList<String>>>(){});
                for(String drillName : drills.get("active")) {
                    orderedActiveBattleDrills.add(drillName);
                }

                for(String drillName : drills.get("completed")) {
                    orderedCompletedBattleDrills.add(drillName);
                }
            }
        } 
        catch (IOException i) 
        {
            System.err.println("DUSTIN unable to load ordered drills: " + i);
        }
       
    }
    
    private BattleDrill loadFromJson(String json) throws IOException
    {
        // Injectable value tells the battle drill whether this is a brand new drill being created, or if it's just being loaded from a JSON file
        // This is needed because brand new battle drills have sub-components that need to generate their own unique IDs upon creation the first time (ie: task IDs)
        InjectableValues inject = new InjectableValues.Std().addValue(boolean.class, false);
            
        BattleDrill battleDrill = new ObjectMapper().reader(inject)
        .forType(BattleDrill.class)
        .readValue(json);
        
        return battleDrill;
    }
    
    public Map<String, ArrayList<String>> getAllDrillNames() {
        Map<String, ArrayList<String>> battleDrills = new HashMap<>();
        battleDrills.put("active", orderedActiveBattleDrills);
        battleDrills.put("completed", orderedCompletedBattleDrills);
        return battleDrills;
    }
    
    public void deleteBattleDrill(String battleDrillName, User user)
    {
        if(StringUtils.isBlank(battleDrillName))
        {
            throw new InvalidParameterException("Unable to delete battle drill - battleDrillName parameter cannot be empty");
        }
        
        if(activeBattleDrills.containsKey(battleDrillName))
        {
            activeBattleDrills.remove(battleDrillName);
            orderedActiveBattleDrills.remove(battleDrillName);
            TaskRepo.deleteTasksByBattleDrill(battleDrillName);
            File battleDrillFile = new File(getFullFilename(battleDrillName, false));
            battleDrillFile.delete();
            saveOrderedDrills();
        }
        else if(completedBattleDrills.containsKey(battleDrillName))
        {
            completedBattleDrills.remove(battleDrillName);
            orderedCompletedBattleDrills.remove(battleDrillName);
            TaskRepo.deleteTasksByBattleDrill(battleDrillName);
            File battleDrillFile = new File(getFullFilename(battleDrillName, true));
            battleDrillFile.delete();
            saveOrderedDrills();
        }
        else // If the battle drill wasn't found, just log the message
        {
            System.err.println("Unable to delete battle drill - battle drill with name " + battleDrillName + " not found.");
            return;
        }
        Notification drillNotification = NotifyManager.createDrillNotification(NotifyTypes.OPERATION_TYPES.DELETE, user, getAllDrillNames(), battleDrillName);
        Notify.sendNotificationToAllExcluding(drillNotification);
        Notify.sendNotification(NotifyManager.createToastNotification(NotifyTypes.OPERATION_TYPES.DELETE, drillNotification));
    }
    
    public Map<String, ArrayList<String>> getCompletedDrillNames()
    {
        Map<String, ArrayList<String>> battleDrills = new HashMap<>();
        battleDrills.put("completed", orderedCompletedBattleDrills);
        return battleDrills;
    }
    
    public List<BattleDrill> getCompletedDrills()
    {
        return new ArrayList(completedBattleDrills.values());
    }
    
    public Map<String, ArrayList<String>> getActiveDrillNames()
    {
        Map<String, ArrayList<String>> battleDrills = new HashMap<>();
        battleDrills.put("active", orderedActiveBattleDrills);
        return battleDrills;
    }
    
    public List<BattleDrill> getActiveDrills()
    {
        return new ArrayList(activeBattleDrills.values());
    }
    
    public void createFromVmf(VmfType vmfType)
    {
        if(null == vmfType)
        {
            throw new InvalidParameterException("Unable to create Battle Drill from VMF Message - the vmfType parameter cannot be null.");
        }
        
        switch(vmfType)
        {
            case MEDEVAC:
                System.out.println("DIANA creating new battle drill for MEDEVAC Vmf Message");
                // Todo - implement creation of unique name and create new drill
                ZoneId zoneId = ZoneId.systemDefault();
                long nowMillis = LocalDateTime.now().atZone(zoneId).toEpochSecond();
                String battleDrillName = "vmf_medevac_" + nowMillis;
                int maxAttempts = 10;
                int attempt = 0;
                while(activeBattleDrills.containsKey(battleDrillName) || attempt++ >= maxAttempts)
                {
                    nowMillis = LocalDateTime.now().atZone(zoneId).toEpochSecond();
                    battleDrillName = "vmf_medevac_" + nowMillis;
                }
                
                if(activeBattleDrills.containsKey(battleDrillName) == false)
                {
                    try
                    {
                        // need to figure out and create location object by parsing vmf message
                        // but for now defaulting it to San Diego Lat Long
                        HashMap<String, String> location = new HashMap<String, String>();
                        location.put("latitude", "32.7157");
                        location.put("longitude", "117.1611");
                        User vmf = new User("VMF", "VMF", "VMF");
                        this.createByType("medevac", battleDrillName, vmf, location);
                    }
                    catch(DuplicateItemException d)
                    {
                        System.err.println("Unable to create battle drill for MEDEVAC VMF message - unable to generate a unique name for new battle drill.");
                    }
                }
                else
                {
                    System.err.println("Unable to create battle drill for MEDEVAC VMF message - unable to generate a unique name for new battle drill.");
                }
                
                break;
            default:
                System.err.println("Unable to create Battle Drill from VMF Message - unhandled vmftype: " + vmfType);
        }
    }
    
    public BattleDrill createByType(String type, String name, User user, Map<String, String> location) throws DuplicateItemException
    {
        if(activeBattleDrills.containsKey(name))
        {
            throw new DuplicateItemException("Battle drill with name: " + name + " already exists");
        }
        
        TemplateManager manager = TemplateManager.getInstance();
        BattleDrillTemplate template = manager.getByType(type);
        BattleDrill battleDrill = null;
        
        if(null == template)
        {
            System.err.println("BattleDrillManager::createByType - Unable to find template with type: " + type);
            return null;
        }
        
        // Clone the template object into a new Battle Drill instance
        try
        {
            String templateJson = DEFAULT_JSON_WRITER.writeValueAsString(template);
            InjectableValues inject = new InjectableValues.Std().addValue(boolean.class, true);
            battleDrill = new ObjectMapper().reader(inject)
            .forType(BattleDrill.class)
            .readValue(templateJson);
            
            battleDrill.setName(name);
            battleDrill.setCreatorName(user.getRole()); // change this to username later, maybe add another key for role
            battleDrill.setLocation(location);
            saveBattleDrill(battleDrill, false);
            
            //websocket
            Notification drillNotification = NotifyManager.createDrillNotification(NotifyTypes.OPERATION_TYPES.CREATE, user, name);
            Notify.sendNotificationToAllExcluding(drillNotification);
            Notify.sendNotification(NotifyManager.createToastNotification(NotifyTypes.OPERATION_TYPES.CREATE, drillNotification));
        }
        catch(Exception e)
        {
            System.err.println("DIANA unable to create battle drill from template: " + e);
            return null;
        }
        
        if(null != battleDrill)
        {
            activeBattleDrills.put(battleDrill.getName(), battleDrill);
            orderedActiveBattleDrills.add(name);
            saveOrderedDrills();
            System.out.println("Successfully created battle drill: " + battleDrill);
        }
        
        return battleDrill;
    }
    
    public void startBattleDrill(String name) throws ItemNotFoundException
    {
        if(activeBattleDrills.containsKey(name) == false)
        {
            throw new ItemNotFoundException("Unable to start battle drill with name: " + name + " - active battle drill list does not contain a battle drill with this name");
        }
        
        BattleDrill bd = activeBattleDrills.get(name);
        if(null != bd)
        {
            bd.start();
        }
    }
    
    public void stopBattleDrill(String name) throws ItemNotFoundException
    {
        if(activeBattleDrills.containsKey(name) == false)
        {
            throw new ItemNotFoundException("Unable to stop battle drill with name: " + name + " - active battle drill list does not contain a battle drill with this name");
        }
        
        BattleDrill bd = activeBattleDrills.get(name);
        if(null != bd)
        {
            bd.stop();
            try
            {
                archiveCompletedBattleDrill(bd);
            }
            catch(Exception e)
            {
                System.err.println("Unable to archive completed battle drill: " + bd.getName() + ", error is: " + e);
            }
        }
    }
    
    private void archiveCompletedBattleDrill(BattleDrill battleDrill) throws JsonProcessingException
    {
        String bdName = battleDrill.getName();
        activeBattleDrills.remove(bdName);
        orderedActiveBattleDrills.remove(bdName);
        
        String contents = DEFAULT_JSON_WRITER.writeValueAsString(battleDrill);
        
        File sourceFile = new File(getFullFilename(bdName, false));
        File destinationFile = new File(getFullFilename(bdName, true));
        
        // A completed battle drill already exists with this name.  Generate a unique name by adding an integer value to the end.
        if(completedBattleDrills.containsKey(bdName) && destinationFile.exists())
        {
            int i = 0;
            String newName = bdName;
            while(destinationFile.exists())
            {
                newName = bdName + "_" + i++;
                destinationFile = new File(getFullFilename(newName, true));
            }
            
            battleDrill.setName(newName);
        }
        
        try
        {
            FileUtils.writeStringToFile(destinationFile, contents, StandardCharsets.UTF_8);
            completedBattleDrills.put(battleDrill.getName(), battleDrill);
            orderedCompletedBattleDrills.add(battleDrill.getName());
            saveOrderedDrills();
            
            if(sourceFile.exists())
            {
                sourceFile.delete();
            }
        }
        catch(IOException ioe)
        {
            System.err.println("Unable to move battle drill into completed folder: " + bdName + ", error is: " + ioe);
        }
    }
    
    public void updateBattleDrillOrder(User user, ArrayList<String> active, ArrayList<String> completed)
    {
        // Either active or completed will be empty (front-end passes only one list, either active or completed)
        if (!active.isEmpty())
        {
            orderedActiveBattleDrills.clear();
            orderedActiveBattleDrills.addAll(active);
        }
        else if (!completed.isEmpty())
        {
            orderedCompletedBattleDrills.clear();
            orderedCompletedBattleDrills.addAll(completed);
        }
        saveOrderedDrills();
        Notification drillNotification = NotifyManager.createDrillNotification(NotifyTypes.OPERATION_TYPES.REORDER, user, getAllDrillNames());
        Notify.sendNotificationToAllExcluding(drillNotification);
        Notify.sendNotification(NotifyManager.createToastNotification(NotifyTypes.OPERATION_TYPES.CREATE, drillNotification));
    }
    
    public BattleDrill getByName(String name, boolean isActive)
    {
        return (isActive)?activeBattleDrills.get(name):completedBattleDrills.get(name);
    }
    
    public BattleDrill getByName(String name)
    {
        if(activeBattleDrills.containsKey(name))
        {
            return activeBattleDrills.get(name);
        }
        else if(completedBattleDrills.containsKey(name))
        {
            return completedBattleDrills.get(name);
        }
        else
        {
            return null;
        }
    }
    
    public BattleDrill createByType(BattleDrillRestParams params) throws DuplicateItemException       
    {
        return createByType(params.getType(), params.getName(), params.getUser(), params.getLocation());
    }
    
    public void updateBattleDrillOrder(OrderedDrillsRestParams params)
    {
        updateBattleDrillOrder(params.getUser(), params.getOrderedActiveDrills(), params.getOrderedCompletedDrills());
    }
    
    private void saveOrderedDrills() 
    {
        try
        {  
            // Manually create two entries into a json object and write them to a file as a json string
            ObjectMapper mapper = new ObjectMapper();
            JsonNode drill = mapper.createObjectNode();
            ArrayNode activeDrills = mapper.valueToTree(orderedActiveBattleDrills);
            ArrayNode completedDrills = mapper.valueToTree(orderedCompletedBattleDrills);
            ((ObjectNode) drill).set("active", activeDrills);
            ((ObjectNode) drill).set("completed", completedDrills);


            String contents = DEFAULT_JSON_WRITER.writeValueAsString(drill);
            String fullname = getOrderedDrillsFilename();
            File file = FileUtils.getFile(fullname);
            FileUtils.writeStringToFile(file, contents, StandardCharsets.UTF_8);
        }
        catch(Exception e)
        {
            System.err.println("Unable to save ordered drills, error is: " + e);
        }
    }
    
    private void saveBattleDrill(BattleDrill bd, boolean isCompleted)
    {
        try
        {
            String contents = DEFAULT_JSON_WRITER.writeValueAsString(bd);
            String fullname = getFullFilename(bd.getName(), isCompleted);
            File file = FileUtils.getFile(fullname);
            FileUtils.writeStringToFile(file, contents, StandardCharsets.UTF_8);
        }
        catch(Exception e)
        {
            System.err.println("Unable to save new battle drill " + bd.getName() + ", error is: " + e);
        }
    }
    
    public void saveBattleDrill(String battleDrillName, boolean isCompleted) throws ItemNotFoundException
    {
        if(StringUtils.isBlank(battleDrillName))
        {
            throw new InvalidParameterException("Unable to save battle drill - battleDrillName parameter cannot be blank");
        }
        
        BattleDrill bd = getByName(battleDrillName);
        if(null == bd)
        {
            throw new ItemNotFoundException("Unable to save battle drill with name: " + battleDrillName + " - battle drill with that name not found");
        }
        
        try
        {
            String contents = DEFAULT_JSON_WRITER.writeValueAsString(bd);
            String fullname = getFullFilename(bd.getName(), isCompleted);
            File file = FileUtils.getFile(fullname);
            FileUtils.writeStringToFile(file, contents, StandardCharsets.UTF_8);
        }
        catch(Exception e)
        {
            System.err.println("Unable to save battle drill " + bd.getName() + ", error is: " + e);
        }
    }
    
    public String getFullFilename(String battleDrillName, boolean isCompleted)
    {
        String fullname = (isCompleted)?BattleDrillsConfig.getCompletedBattleDrillsDir():BattleDrillsConfig.getActiveBattleDrillsDir();
        return fullname + "/" + battleDrillName + ".json";
    }
    
    public String getOrderedDrillsFilename()
    {
        return BattleDrillsConfig.getOrderedBattleDrillsDir() + "/orderedBattleDrills.json";
    }
}
