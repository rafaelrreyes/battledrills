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
import com.ngc.battledrills.comms.Notification;
import com.ngc.battledrills.comms.Notify;
import com.ngc.battledrills.comms.NotifyManager;
import com.ngc.battledrills.comms.NotifyTypes;
import com.ngc.battledrills.data.Report;
import com.ngc.battledrills.exception.ItemNotFoundException;
import com.ngc.battledrills.exception.DuplicateItemException;
import com.ngc.battledrills.restparams.BattleDrillRestParams;
import com.ngc.battledrills.data.TaskRepo;
import com.ngc.battledrills.data.User;
import com.ngc.battledrills.restparams.OrderedDrillsRestParams;
import com.ngc.battledrills.template.BattleDrillTemplate;
import com.ngc.battledrills.util.ConvenienceUtils.VmfType;
import com.ngc.battledrills.util.JsonUtils;
import com.ngc.battledrills.util.JacksonInjectableValues;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidParameterException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
    private static final ArrayList<Map<String, String>> orderedActiveBattleDrills = new ArrayList<Map<String, String>>();
    private static final ArrayList<Map<String, String>> orderedCompletedBattleDrills = new ArrayList<Map<String, String>>();

    private BattleDrillManager() {
        loadAll();
    }
    
    public static BattleDrillManager getInstance() {
        return BattleDrillManagerFactory.instance;
    } 
    
    private static class BattleDrillManagerFactory {
        // Lazy initialize the BattleDrillManager singleton
        private static final BattleDrillManager instance = new BattleDrillManager();
    }
    
    private void loadAll() {
        loadActiveDrills();
        loadCompletedDrills();
        loadOrderedDrills();
    }
    
    private void loadActiveDrills() {
        try {
            File dir = new File(BattleDrillsConfig.getActiveBattleDrillsDir());
            File[] files = dir.listFiles((d, drill) -> drill.endsWith(".json"));
            
            for(File file : files) {
                String fileContents = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
                BattleDrill battleDrill = loadFromJson(fileContents);
                activeBattleDrills.put(battleDrill.getId(), battleDrill);
            }
        }
        catch(IOException i)
        {
            System.err.println("DIANA unable to load template: " + i);
        }
    }
    
    // Diana - consider not storing the full objects, but only storing their names and then loading from the file if someone requests the full details
    private void loadCompletedDrills() {
        try {
            File dir = new File(BattleDrillsConfig.getCompletedBattleDrillsDir());
            File[] files = dir.listFiles((d, drill) -> drill.endsWith(".json"));
            
            for(File file : files) {
                String fileContents = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
                BattleDrill battleDrill = loadFromJson(fileContents);
                completedBattleDrills.put(battleDrill.getId(), battleDrill);
            }
        } catch(IOException i) {
            System.err.println("DIANA unable to load template: " + i);
        }
    }
    
    private void loadOrderedDrills() {
        try {
            File orderedActiveDrillFile = new File(getOrderedDrillsFilename());
            if (orderedActiveDrillFile.isFile() && orderedActiveDrillFile.canRead()) {
                String json = FileUtils.readFileToString(orderedActiveDrillFile, StandardCharsets.UTF_8);
                ObjectMapper mapper = new ObjectMapper();
                HashMap<String, ArrayList<Map<String, String>>> drills = mapper.readValue(json, new TypeReference<HashMap<String, ArrayList<Map<String, String>>>>(){});
                for (Map<String, String> drill : drills.get("active")) {
                    Map<String, String> targetDrill = new HashMap<>();
                    targetDrill.put("id", drill.get("id"));
                    targetDrill.put("name", drill.get("name"));
                    orderedActiveBattleDrills.add(drill);
                }

                for (Map<String, String> drill : drills.get("completed")) {
                    Map<String, String> targetDrill = new HashMap<>();
                    targetDrill.put("id", drill.get("id"));
                    targetDrill.put("name", drill.get("name"));
                    orderedCompletedBattleDrills.add(drill);
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
        InjectableValues.Std inject = new InjectableValues.Std();

        inject.addValue(JacksonInjectableValues.SAVE_AS_TEMPLATE, false);
        inject.addValue(JacksonInjectableValues.NEW_TASK, false);
        BattleDrill battleDrill = new ObjectMapper().reader(inject).forType(BattleDrill.class).readValue(json);
        
        return battleDrill;
    }
    
    public Map<String, ArrayList<String>> getAllDrillNames() {
        Map<String, ArrayList<String>> drillNames = new HashMap<>();
        ArrayList<String> activeDrillNames = new ArrayList<>();
        ArrayList<String> completedDrillNames = new ArrayList<>();
        
        // extract names from ordered drills and place into map consisting of
        // "active" and "completed" drill names
        orderedActiveBattleDrills.forEach((orderedActiveDrill) -> {
            activeDrillNames.add(orderedActiveDrill.get("name"));
        });
        
        orderedCompletedBattleDrills.forEach((orderedCompletedDrill) -> {
            completedDrillNames.add(orderedCompletedDrill.get("name"));
        });
        
        drillNames.put("active", activeDrillNames);
        drillNames.put("completed", completedDrillNames);
        return drillNames;
    }
    
    public Map<String, ArrayList<Map<String, String>>> getAllDrills() {
        Map<String, ArrayList<Map<String, String>>> battleDrills = new HashMap<>();
        battleDrills.put("active", orderedActiveBattleDrills);
        battleDrills.put("completed", orderedCompletedBattleDrills);
        return battleDrills;
    }
    
    public Map<String, ArrayList<String>> getAllDrillIds() {
        Map<String, ArrayList<String>> drillIds = new HashMap<>();
        ArrayList<String> activeDrillIds = new ArrayList<>();
        ArrayList<String> completedDrillIds = new ArrayList<>();
        
        // extract names from ordered drills and place into map consisting of
        // "active" and "completed" drill ids
        orderedActiveBattleDrills.forEach((orderedActiveDrill) -> {
            activeDrillIds.add(orderedActiveDrill.get("id"));
        });
        
        orderedCompletedBattleDrills.forEach((orderedCompletedDrill) -> {
            completedDrillIds.add(orderedCompletedDrill.get("id"));
        });
        
        drillIds.put("active", activeDrillIds);
        drillIds.put("completed", completedDrillIds);
        return drillIds;
    }
    
    public void deleteBattleDrill(String drillId, User user) {
        if (StringUtils.isBlank(drillId)) {
            throw new InvalidParameterException("Unable to delete battle drill - drill ID parameter cannot be empty");
        }
        
        if (!activeBattleDrills.containsKey(drillId) && !completedBattleDrills.containsKey(drillId)) {
            System.err.println("Unable to delete battle drill - battle drill with id: " + drillId + " not found.");
            return;
        }
        
        if (activeBattleDrills.containsKey(drillId)) {
            activeBattleDrills.remove(drillId);
            Iterator<Map<String,String>> iterator = orderedActiveBattleDrills.iterator();
            while (iterator.hasNext()) {
                Map<String, String> orderedActiveDrill = iterator.next();
                if (orderedActiveDrill.containsKey("id") && orderedActiveDrill.get("id").equals(drillId)) {
                    iterator.remove();
                }
            }
            
        } else if(completedBattleDrills.containsKey(drillId)) {
            completedBattleDrills.remove(drillId);
            Iterator<Map<String,String>> iterator = orderedCompletedBattleDrills.iterator();
            while (iterator.hasNext()) {
                Map<String, String> orderedCompletedDrill = iterator.next();
                if (orderedCompletedDrill.containsKey("id") && orderedCompletedDrill.get("id").equals(drillId)) {
                    iterator.remove();
                }
            }
        }
        
        // delete tasks associated with battle drill and update
        TaskRepo.deleteTasksByBattleDrill(drillId);
        File battleDrillFile = new File(getFullFilename(drillId, false));
        battleDrillFile.delete();
        saveOrderedDrills();
        
        
        // TODO: update notification to account for drill ids
//        Notification drillNotification = NotifyManager.createDrillNotification(NotifyTypes.OPERATION_TYPES.DELETE, user, getAllDrillNames(), battleDrillName);
//        Notify.sendNotificationToAllExcluding(drillNotification);
//        Notify.sendNotification(NotifyManager.createToastNotification(NotifyTypes.OPERATION_TYPES.DELETE, drillNotification));
    }
    
    public Map<String, ArrayList<String>> getCompletedDrillNames() {
        Map<String, ArrayList<String>> completedDrills = new HashMap<>();
        ArrayList<String> completedDrillNames = new ArrayList<>();
        orderedCompletedBattleDrills.forEach((orderedCompleteDrill) -> {
            completedDrillNames.add(orderedCompleteDrill.get("name"));
        });
        completedDrills.put("completed", completedDrillNames);
        return completedDrills;
    }
    
    public Map<String, ArrayList<String>> getCompletedDrillIds() {
        Map<String, ArrayList<String>> completedDrills = new HashMap<>();
        ArrayList<String> completedDrillIds = new ArrayList<>();
        orderedCompletedBattleDrills.forEach((orderedCompleteDrill) -> {
            completedDrillIds.add(orderedCompleteDrill.get("id"));
        });
        completedDrills.put("completed", completedDrillIds);
        return completedDrills;
    }
    
    public List<BattleDrill> getCompletedDrills() {
        return new ArrayList(completedBattleDrills.values());
    }
    
    public Map<String, ArrayList<String>> getActiveDrillNames() {
        Map<String, ArrayList<String>> activeDrills = new HashMap<>();
        ArrayList<String> activeDrillNames = new ArrayList<>();
        orderedActiveBattleDrills.forEach((orderedActiveDrill) -> {
            activeDrillNames.add(orderedActiveDrill.get("name"));
        });
        activeDrills.put("completed", activeDrillNames);
        return activeDrills;
    }
    
    public List<BattleDrill> getActiveDrills() {
        return new ArrayList(activeBattleDrills.values());
    }
    
    // TODO drill id changes
    public void createFromVmf(VmfType vmfType) {
        if (null == vmfType) {
            throw new InvalidParameterException("Unable to create Battle Drill from VMF Message - the vmfType parameter cannot be null.");
        }
        
        switch(vmfType) {
            case MEDEVAC:
                // Todo - implement creation of unique name and create new drill
                ZoneId zoneId = ZoneId.systemDefault();
                long nowMillis = LocalDateTime.now().atZone(zoneId).toEpochSecond();
                String generatedDrillName = "vmf_medevac_" + nowMillis;


                try {
                    // need to figure out and create location object by parsing vmf message
                    // but for now defaulting it to San Diego Lat Long
                    HashMap<String, String> location = new HashMap<String, String>();
                    location.put("latitude", "32.7157");
                    location.put("longitude", "117.1611");
                    User vmf = new User("VMF", -1, "VMF", "VMF");
                    this.createByType(-1, "medevac", generatedDrillName, true, vmf, location);
                } catch(DuplicateItemException d) {
                    System.err.println("Unable to create battle drill for MEDEVAC VMF message - unable to generate a unique name for new battle drill.");
                }
                
                break;
            default:
                System.err.println("Unable to create Battle Drill from VMF Message - unhandled vmftype: " + vmfType);
        }
    }
    
    public BattleDrill createByType(int creatorId, String type, String name, boolean start, User user, Map<String, String> location) throws DuplicateItemException {
        
        TemplateManager manager = TemplateManager.getInstance();
        BattleDrillTemplate template = manager.getByType(type);
        BattleDrill battleDrill = null;
        
        if (null == template) {
            System.err.println("BattleDrillManager::createByType - Unable to find template with type: " + type);
            return null;
        }

        // Clone the template object into a new Battle Drill instance
        try {
            String templateJson = JsonUtils.writeValue(template);
            InjectableValues.Std inject = new InjectableValues.Std();
            inject.addValue(JacksonInjectableValues.NEW_TASK, true);
            inject.addValue(JacksonInjectableValues.SAVE_AS_TEMPLATE, false);
            battleDrill = new ObjectMapper().reader(inject).forType(BattleDrill.class).readValue(templateJson);

            battleDrill.setName(name);
            battleDrill.setCreatorId(creatorId);
            battleDrill.setCreatorName(user.getName()); // change this to username later, maybe add another key for role
            battleDrill.setLocation(location);
            
            // get the id of the newly created drill
            String drillId = battleDrill.getId();

            ReportsManager rMgr = ReportsManager.getInstance();
            rMgr.createInitialReport(drillId, battleDrill.getNumTasks());

            activeBattleDrills.put(drillId, battleDrill);
            Map<String, String> orderedActiveDrill = new HashMap<>();
            orderedActiveDrill.put("id", drillId);
            orderedActiveDrill.put("name", name);
            orderedActiveBattleDrills.add(orderedActiveDrill);
            saveOrderedDrills();

            if (start) {
                // startBattleDrill saves to file itself
                startBattleDrill(drillId, user);
            } else {
                saveBattleDrill(drillId, false);
            }
            // TODO: update notifications to use drill ids
//            Notification drillNotification = NotifyManager.createDrillNotification(NotifyTypes.OPERATION_TYPES.CREATE, user, name);
//            Notify.sendNotificationToAllExcluding(drillNotification);
//            Notify.sendNotification(NotifyManager.createToastNotification(NotifyTypes.OPERATION_TYPES.CREATE, drillNotification));
//            System.out.println("Successfully created battle drill: " + battleDrill);
        } catch (Exception e) {
            System.err.println("DIANA unable to create battle drill from template: " + e);
        }
        
        return battleDrill;
    }

    public boolean isBattleDrillStarted(String drillId) throws ItemNotFoundException {
        if (activeBattleDrills.containsKey(drillId) == false) {
            throw new ItemNotFoundException("Unable to check battle drill with id: " + drillId + " - active battle drill list does not contain a battle drill with this drillId");
        }

        BattleDrill bd = activeBattleDrills.get(drillId);
        return null != bd && bd.getStartTime() != null;
    }

    public LocalDateTime startBattleDrill(String drillId, User user) throws ItemNotFoundException {
        if (activeBattleDrills.containsKey(drillId) == false) {
            throw new ItemNotFoundException("Unable to start battle drill with drillId: " + drillId + " - active battle drill list does not contain a battle drill with this drillId");
        }
        
        BattleDrill bd = activeBattleDrills.get(drillId);
        if (null != bd) {
            // dont need to set report startTime here because bd.start() calls startAllTasks which sets it
            LocalDateTime time = bd.start();
            saveBattleDrill(drillId, false);
            // TODO:
//            Notification drillNotification = NotifyManager.createDrillNotification(NotifyTypes.OPERATION_TYPES.START, user, name);
//            Notify.sendNotificationToAllExcluding(drillNotification);
//            Notify.sendNotification(NotifyManager.createToastNotification(NotifyTypes.OPERATION_TYPES.START, drillNotification));
            return time;
        }
        return null;
    }
    
    public void stopBattleDrill(String drillId, User user) throws ItemNotFoundException    {
        if(activeBattleDrills.containsKey(drillId) == false) {
            throw new ItemNotFoundException("Unable to stop battle drill with drillId: " + drillId + " - active battle drill list does not contain a battle drill with this drillId");
        }
        
        BattleDrill bd = activeBattleDrills.get(drillId);
        if (null != bd) {
            ReportsManager rMgr = ReportsManager.getInstance();
            Report rep = rMgr.getReportByDrillId(drillId);
            LocalDateTime endTime = bd.stop();
            rep.setAllTaskEndTimes(endTime);
            rep.setEndTime(endTime);
            rMgr.saveReport(rep);
            try {
                archiveCompletedBattleDrill(bd);
//                TODO:
//                Notification drillNotification = NotifyManager.createDrillNotification(NotifyTypes.OPERATION_TYPES.STOP, user, name);
//                Notify.sendNotificationToAllExcluding(drillNotification);
//                Notify.sendNotification(NotifyManager.createToastNotification(NotifyTypes.OPERATION_TYPES.STOP, drillNotification));
            } catch(Exception e) {
                System.err.println("Unable to archive completed battle drill: " + bd.getId() + ", error is: " + e);
            }
        }
    }
    
    private void archiveCompletedBattleDrill(BattleDrill battleDrill) throws JsonProcessingException {
        String bdName = battleDrill.getName();
        String drillId = battleDrill.getId();
        activeBattleDrills.remove(drillId);
        
        Iterator<Map<String,String>> iterator = orderedActiveBattleDrills.iterator();
        while (iterator.hasNext()) {
            Map<String, String> orderedActiveDrill = iterator.next();
            if (orderedActiveDrill.containsKey("id") && orderedActiveDrill.get("id").equals(drillId)) {
                iterator.remove();
            }
        }
       
        
        String contents = JsonUtils.writeValue(battleDrill);
        
        File sourceFile = new File(getFullFilename(drillId, false));
        File destinationFile = new File(getFullFilename(drillId, true));
        
        // A completed battle drill already exists with this id.  Generate a unique name by adding an integer value to the end.
        if (completedBattleDrills.containsKey(drillId) && destinationFile.exists()) {
            int i = 0;
            String newName = bdName;
            while (destinationFile.exists()) {
                newName = bdName + "_" + i++;
                destinationFile = new File(getFullFilename(newName, true));
            }
            
            battleDrill.setName(newName);
        }
        
        try {
            FileUtils.writeStringToFile(destinationFile, contents, StandardCharsets.UTF_8);
            completedBattleDrills.put(battleDrill.getId(), battleDrill);
            Map<String, String> orderedCompletedDrill = new HashMap<>();
            orderedCompletedDrill.put("id", drillId);
            orderedCompletedDrill.put("name", bdName);
            orderedCompletedBattleDrills.add(orderedCompletedDrill);
            saveOrderedDrills();
            
            if (sourceFile.exists()) {
                sourceFile.delete();
            }
        } catch(IOException ioe) {
            System.err.println("Unable to move battle drill into completed folder: " + bdName + ", error is: " + ioe);
        }
    }
    
    public void updateBattleDrillOrder(User user, ArrayList<Map<String, String>> active, ArrayList<Map<String, String>> completed) {
        // Either active or completed will be empty (front-end passes only one list, either active or completed)
        if (!active.isEmpty()) {
            orderedActiveBattleDrills.clear();
            orderedActiveBattleDrills.addAll(active);
        } else if (!completed.isEmpty()) {
            orderedCompletedBattleDrills.clear();
            orderedCompletedBattleDrills.addAll(completed);
        }
        saveOrderedDrills();
//        Notification drillNotification = NotifyManager.createDrillNotification(NotifyTypes.OPERATION_TYPES.REORDER, user, getAllDrillNames());
//        Notify.sendNotificationToAllExcluding(drillNotification);
//        Notify.sendNotification(NotifyManager.createToastNotification(NotifyTypes.OPERATION_TYPES.CREATE, drillNotification));
    }
    
    public BattleDrill editDrillNameById(String drillId, String newName) {
        BattleDrill bd = getById(drillId);
        bd.setName(newName);
        
        if (null != activeBattleDrills.get(drillId)) {
            activeBattleDrills.get(drillId).setName(newName);
            orderedActiveBattleDrills.forEach((orderedActiveDrill) -> {
                if (orderedActiveDrill.get("id").equals(drillId)) {
                    orderedActiveDrill.replace("name", newName);
                }
            });
            saveBattleDrill(bd, false);
        } else {
            completedBattleDrills.get(drillId).setName(newName);
            orderedCompletedBattleDrills.forEach((orderedCompletedDrill) -> {
                if (orderedCompletedDrill.get("id").equals(drillId)) {
                    orderedCompletedDrill.replace("name", newName);
                }
            });
            saveBattleDrill(bd, true);
        }
        saveOrderedDrills();
        return bd;
    }
    
    public BattleDrill getByName(String name, boolean isActive) {
        return (isActive) ? activeBattleDrills.get(name) : completedBattleDrills.get(name);
    }
    
    public BattleDrill getById(String id, boolean isActive) {
        return (isActive) ? activeBattleDrills.get(id) : completedBattleDrills.get(id);
    }
    
    public BattleDrill getById(String id) {
        if (activeBattleDrills.containsKey(id)) {
            return activeBattleDrills.get(id);
        } else if (completedBattleDrills.containsKey(id)) {
            return completedBattleDrills.get(id);
        } else {
            return null;
        }
    }
    
    public BattleDrill getByName(String name) {
        if(activeBattleDrills.containsKey(name)) {
            return activeBattleDrills.get(name);
        } else if(completedBattleDrills.containsKey(name)) {
            return completedBattleDrills.get(name);
        } else {
            return null;
        }
    }
    
    public BattleDrill createByType(BattleDrillRestParams params) throws DuplicateItemException {
        return createByType(params.getCreatorId(), params.getType(), params.getName(), params.getStart(), params.getUser(), params.getLocation());
    }
    
    public void updateBattleDrillOrder(OrderedDrillsRestParams params) {
        updateBattleDrillOrder(params.getUser(), params.getOrderedActiveDrills(), params.getOrderedCompletedDrills());
    }
    
    private void saveOrderedDrills() {
        try {  
            // Manually create two entries into a json object and write them to a file as a json string
            ObjectMapper mapper = new ObjectMapper();
            JsonNode drill = mapper.createObjectNode();
            ArrayNode activeDrills = mapper.valueToTree(orderedActiveBattleDrills);
            ArrayNode completedDrills = mapper.valueToTree(orderedCompletedBattleDrills);
            ((ObjectNode) drill).set("active", activeDrills);
            ((ObjectNode) drill).set("completed", completedDrills);

            String contents = JsonUtils.writeValue(drill);
            String fullname = getOrderedDrillsFilename();
            File file = FileUtils.getFile(fullname);
            FileUtils.writeStringToFile(file, contents, StandardCharsets.UTF_8);
        } catch(Exception e) {
            System.err.println("Unable to save ordered drills, error is: " + e);
        }
    }
    
    private void saveBattleDrill(BattleDrill bd, boolean isCompleted) {
        try {
            String contents = JsonUtils.writeValue(bd);
            String fullname = getFullFilename(bd.getId(), isCompleted);
            File file = FileUtils.getFile(fullname);
            FileUtils.writeStringToFile(file, contents, StandardCharsets.UTF_8);
        } catch(Exception e) {
            System.err.println("Unable to save new battle drill " + bd.getId() + ", error is: " + e);
        }
    }
    
    public void saveBattleDrill(String drillId, boolean isCompleted) throws ItemNotFoundException {
        if (StringUtils.isBlank(drillId)){
            throw new InvalidParameterException("Unable to save battle drill - drillId parameter cannot be blank");
        }
        
        BattleDrill bd = getById(drillId);
        if (null == bd) {
            throw new ItemNotFoundException("Unable to save battle drill with drillId: " + drillId + " - battle drill with that drillId not found");
        }
        
        try {
            String contents = JsonUtils.writeValue(bd);
            String fullname = getFullFilename(bd.getId(), isCompleted);
            File file = FileUtils.getFile(fullname);
            FileUtils.writeStringToFile(file, contents, StandardCharsets.UTF_8);
        } catch(Exception e) {
            System.err.println("Unable to save battle drill " + bd.getId() + ", error is: " + e);
        }
    }
    
    public String getFullFilename(String drillId, boolean isCompleted) {
        String fullname = (isCompleted) ? BattleDrillsConfig.getCompletedBattleDrillsDir() : BattleDrillsConfig.getActiveBattleDrillsDir();
        return fullname + "/" + drillId + ".json";
    }
    
    public String getOrderedDrillsFilename() {
        return BattleDrillsConfig.getOrderedBattleDrillsDir() + "/orderedBattleDrills.json";
    }
}
