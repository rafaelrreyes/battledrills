/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills;

import com.ngc.battledrills.data.BattleDrill;
import com.ngc.battledrills.manage.BattleDrillManager;
import com.ngc.battledrills.comms.Notification;
import com.ngc.battledrills.comms.Notify;
import com.ngc.battledrills.comms.NotifyManager;
import com.ngc.battledrills.comms.NotifyTypes;
import com.ngc.battledrills.rest.BattleDrillService;
import com.ngc.battledrills.manage.TemplateManager;
import com.ngc.battledrills.rest.TaskService;
import com.ngc.battledrills.data.Node;
import com.ngc.battledrills.data.Note;
import com.ngc.battledrills.data.Status;
import com.ngc.battledrills.data.Task;
import com.ngc.battledrills.data.TaskRepo;
import com.ngc.battledrills.data.User;
import com.ngc.battledrills.exception.ItemNotFoundException;
import com.ngc.battledrills.manage.AttachmentManager;
import com.ngc.battledrills.manage.TaskManager;
import com.ngc.battledrills.restparams.BattleDrillRestParams;
import com.ngc.battledrills.restparams.NoteRestParams;
import com.ngc.battledrills.restparams.OrderedDrillsRestParams;
import com.ngc.battledrills.util.JsonUtils;
import com.ngc.battledrills.restparams.ReportsRestParams;
import com.ngc.battledrills.rest.ReportsService;
import com.ngc.battledrills.restparams.StatusRestParams;
import com.ngc.battledrills.vmf.VmfManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
public class BattleDrillsMain {
    
    public BattleDrillsMain(){}
    
    public static void main(String[] args) throws ItemNotFoundException {
//        BattleDrillsConfig.devMode = true;
//        AttachmentManager fm = AttachmentManager.getInstance();
//        String drillName = "345";
//        fm.createDrillDirectory(drillName);
//        String fileName = "a (1).pdf";
//        String extension = fileName.substring(fileName.lastIndexOf("."), fileName.length());
//        
        BattleDrillManager mgr = BattleDrillManager.getInstance();
          TaskRepo.getAllTasks();
          Task task = TaskRepo.getTask("4e0bc58b-2813-4f53-982a-c2de282f4d4e");
          TaskRepo.editTaskDescription(task, "rafa");
//          System.out.println(task.toString());
          mgr.saveBattleDrill("222", false);
//          task.setDescription("testing");
//          System.out.println(task.toString());
//        String newName = fileName.substring(0, fileName.lastIndexOf("."));
//        if (newName.length() <= 2) {
//            newName = newName.concat("(1)");
//        } else if (newName.charAt(newName.length() - 3) != '(' && newName.charAt(newName.length() - 1) != ')') {
//
//            newName = newName.concat("(1)");
//        } else {
//            int newNumber = Character.getNumericValue(newName.substring(newName.length() - 3, newName.length()).toCharArray()[1]);
//            newName = newName.substring(0, newName.length() - 3).concat("(" + (++newNumber) + ")");
//        }
//        BattleDrillManager mgr = BattleDrillManager.getInstance();
//        TaskRepo.getAllTasks();
//        Task targetTask = TaskRepo.getTask("46befa90-79a1-4357-9af8-70f356aff277");
//        
//        String associatedBattleDrill = targetTask.getBattleDrillName();
//        System.out.println(associatedBattleDrill);
//        System.out.println(newName.concat(extension));
        //BattleDrillsConfig.devMode = true;
        //System.out.println("test");
        //testDeleteBattleDrill();
        //testGetSubtreeByOwner();
//        testGetTaskById();
        //testAddNote();
        //testGetTask();
        //testUpdateBattleDrill();
//        testGetNames();
       
        //rafael
        //testVmf();
//        testGetTasksByBillet();
        //testTasksXBillet();
        //testCreateTemplate();
        //testOrderDrills();
        //testCreateDrillWithLocation();
//        testSetTaskStatus();
        testReports();
        
    }

    public static void testReports() {
        BattleDrillManager bMgr = BattleDrillManager.getInstance();

        ReportsService service = new ReportsService();
        BattleDrillService bdService = new BattleDrillService();
        //System.out.println(bMgr.getByName("IEDD1", false));
        try {
//            User user = new User("sessionId", "CO", "Dustin");
//            BattleDrill bd = bMgr.getByName("dustin_test");
//            if (null == bd) {
//                BattleDrillRestParams p = new BattleDrillRestParams();
//                p.setLocation(getTestLocation());
//                p.setName("dustin_test");
//                p.setUser(user);
//                p.setType("tactical_maneuver");
//                bdService.createByType(p);
//                bd = bMgr.getByName("dustin_test");
//            }
//            bdService.startBattleDrill(bd.getName());
//            Thread.sleep(2000);
//            Node root = bd.getRoot();
//            Node child = root.getChildNodes().get(0);
//            List<Task> tasks = child.getTasks();
//            Task task = tasks.get(0);
//            String taskId = task.getId();
//
//            TaskService taskService = new TaskService();
//            StatusRestParams srp = new StatusRestParams();
//            Status s = new Status();
//            s.setStatus("completed");
//            srp.setCurrentStatus(s);
//            srp.setTaskId(taskId);
//            srp.setUser(user);
//            String taskString = taskService.changeStatus(srp);
//            bdService.stopBattleDrill(bd.getName());
//            System.out.println(taskString);

            System.out.println("_________________________________________________________ START TEST ___________________________________________________________");
            ReportsRestParams params = new ReportsRestParams();
            params.setDrillId("WCD1");
            service.getReports(params);
        } catch (Exception e) {
            System.err.println("Dustin - unable to test: " + e);
        }
    }
    
    private static void testSetTaskStatus() {
        BattleDrillManager mgr = BattleDrillManager.getInstance();
        
        String testTaskId = "991444f5-73db-45fb-85b8-464e807e32cd";
        User user = new User("sessionId", 15, "WO", "Dustin");

        
        try {
            Task testTask = TaskRepo.getTask(testTaskId); // print out default status
            System.out.println("Task: " + testTask.toString());
//            System.out.println("New Status: " + newStatus.toString());
            TaskManager.changeTaskStatus(testTaskId, user, Status.StatusTypes.COMPLETED);
            
            // print out new task
//            System.out.println("New Task: " + TaskRepo.getTask(testTaskId));
        } catch (ItemNotFoundException e ) {
            e.printStackTrace();
        }
        
        
    }
    
    private static HashMap<String, String> getTestLocation() {
        // test location San Diego
        HashMap<String, String> testLocation  = new HashMap<String, String>();
        testLocation.put("latitude", "32.7157");
        testLocation.put("longitude", "117.1611");
        testLocation.put("altitude", "5000");
        testLocation.put("tilt", "50");
        
        return testLocation;
    }
    
    private static void testCreateDrillWithLocation() {
        BattleDrillManager mgr = BattleDrillManager.getInstance();
        try {
            System.out.println(getTestLocation());
            User user = new User("sessionId", 2, "XO", "Dustin");
            BattleDrill bd = mgr.createByType(1, "assassination_of_iraqi_government_official", "assassination 1", false, user, getTestLocation());
            System.out.println("Test Battle Drill with location: " + bd.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void testCreateTemplate()
    {
        //TemplateManager mgr = TemplateManager.getInstance();
        
        //System.out.println("DIANA loaded templates: " + mgr.getTypes());
        BattleDrillManager mgr = BattleDrillManager.getInstance();
        try
        {
            User user = new User("sessionId", 1, "CO", "Dustin");
            BattleDrill bd = mgr.createByType(1, "assassination_of_iraqi_government_official", "dianatestload3", false, user, getTestLocation());
            System.out.println("Diana battle drill: " + bd);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
    
    public static void testTasksXBillet()
    {
        try
        {
//            String data = DEFAULT_JSON_WRITER.writeValueAsString(TaskManager.getTaskMetrics());
            String data = JsonUtils.writeValue(TaskManager.getTaskMetrics());
            System.out.println(data);
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
    }
    
    public static void testGetTasksByBillet()
    {
//        System.out.println("here");
//        String billet = "WO";
//        Map<String, Object> tasks = TaskRepo.getTasksByBillet(billet);
//        
//        for (String drillId : tasks.keySet())
//        {
//            System.out.println("Battle Drill Name: " + bdName);
//            System.out.println(tasks.get(bdName));
//        }
    }
    
    public static void testVmf()
    {
//        VmfManager vmfMgr = new VmfManager();
//        vmfMgr.startKMessageMonitor();
    }
    
    public static void testDeleteBattleDrill()
    {
        BattleDrillManager mgr = BattleDrillManager.getInstance();
        TemplateManager tmgr = TemplateManager.getInstance();
        try
        {
            Map<String, Object> types = tmgr.getTypes();
            System.out.println("DIANA TYPES: ");
            System.out.println(types);
            
            User user = new User("sessionId", 1, "CO", "Dustin");
            mgr.createByType(1, "ied_discovered", "dianatest2", false, user, getTestLocation());
                    
            List<String> names = mgr.getActiveDrillNames().get("active");
            System.out.println("Diana names");
            System.out.println(names);
            int count = TaskRepo.size();
            System.out.println("DIANA TASKS: " + count);
            System.out.println(TaskManager.staticToString());
            
        }
        catch(Exception e)
        {
            System.err.println("DIANA error: " + e);
        }
    }
    
    public static void testGetSubtreeByOwner()
    {
        BattleDrillManager bdManager = BattleDrillManager.getInstance();
        try
        {
            BattleDrill bd = bdManager.getByName("ToT Test1");
            Node tree = bd.getSubtreeByRoleId(12);
            System.out.println("DIANA TREE");
            System.out.println(tree);
            
        }
        catch(Exception e)
        {
            System.err.println("DIANA error: " + e);
        }
    }
    
    public static void testGetTaskById()
    {
        BattleDrillManager bdManager = BattleDrillManager.getInstance();
        try
        {
            /*System.out.println("DIANA TASKS IN REPO: ");
            List<Task> tasks = TaskRepo.getAllTasks();
            for(Task task : tasks)
            {
                System.out.println(task);
            }*/
                
            
            Task task = TaskRepo.getTask("991444f5-73db-45fb-85b8-464e807e32cd");
            System.out.println(task.toString());
        }
        catch(Exception e)
        {
            System.err.println("DIANA error: " + e);
        }
        
    }
    
    public static void testAddNote()
    {
        BattleDrillManager bdManager = BattleDrillManager.getInstance();
        
        try
        {
            List<String> names = bdManager.getActiveDrillNames().get("active");
            if(names.size() > 0)
            {
                String name = names.get(0);
                System.out.println("DIANA name: " + name);
                BattleDrill bd = bdManager.getByName(name);
                
                Node root = bd.getRoot();
                Node child = root.getChildNodes().get(0);
            
                List<Task> tasks = child.getTasks();
                Task task = tasks.get(0);
                
                System.out.println("DIANA task: ");
                System.out.println(task);
                
                User user = new User("sessionId", 2, "XO", "Dustin");
                Note note = new Note(user, "Testing note4");
                //Note note2 = new Note("diana", "Testing note5");
                //Note note3 = new Note("sonya", "Testing note6");
                //task.addNote(note);
                //task.addNote(note2);
                //task.addNote(note3);
                
                
                TaskService tService = new TaskService();
                NoteRestParams params = new NoteRestParams(note, task.getId());
                String diana = JsonUtils.writeValue(params);
//                String diana = DEFAULT_JSON_WRITER.writeValueAsString(params);
                System.out.println("DIANA REST PARAMS");
                System.out.println(diana);
                tService.addNote(params);
                
                System.out.println("DIANA task:");
                System.out.println(task);
                
            }
            
        }
        catch(Exception e)
        {
            System.err.println("Test Add Note Error: ");
            e.printStackTrace();
        }
    }
    
    public static void testGetTask()
    {
        BattleDrillManager bdManager = BattleDrillManager.getInstance();
        try
        {
            User user = new User("sessionId", 1, "CO", "Dustin");
            BattleDrill bd = bdManager.createByType(1, "ied_discovered", "dianatest1", false, user, getTestLocation());
            Node root = bd.getRoot();
            Node child = root.getChildNodes().get(0);
            
            List<Task> tasks = child.getTasks();
            
            System.out.println("DIANA num tasks: " + tasks.size());
            Task task = tasks.get(0);
            String taskId = task.getId();
            
            TaskService taskService = new TaskService();
            String taskString = taskService.getTaskById(taskId);
            System.out.println("DIANA GOT TASK!");
            System.out.println(taskString);
            
        }
        catch(Exception e)
        {
            System.err.println("DIANA ERROR testGetTask: " + e);
        }
    }
    
    public static void testGetNames()
    {
//        BattleDrillService service = new BattleDrillService();
//        BattleDrillManager manager = BattleDrillManager.getInstance();
//        System.out.println("DIANA names: ");
//        try
//        {
//            manager.getAllDrillNames();
//            System.out.println(service.getBattleDrillNames(null));
//            
//            System.out.println(service.getBattleDrillByName("dianatest2"));
//        }
//        catch(Exception e)
//        {
//            System.err.println(e);
//        }
    }
    
    public static void testNotification() {
        User user = new User("sessionId", 1, "XO", "Dustin");
        Note note = new Note(user, "hello");
        String taskId = "8ee99806-885c-4c2c-a232-9f1b5997e804";
        Map<String, String> taskData = new HashMap<>();
        taskData.put("taskId", taskId);
        taskData.put("taskDescription", "Notify the people of this task");
        taskData.put("currentStatus", "BLOCKED");
        
        Notification testNotification = NotifyManager.createNoteNotification(NotifyTypes.OPERATION_TYPES.CREATE, user, "IED Discovered", taskData, note);
        Notify.sendNotification(testNotification);
    }
    
    public static void testChatNotification() {
//        INotification testChatNotification = NotifyManager.createChatNotification(NotifyTypes.OBJECT_TYPES.CHAT, NotifyTypes.OPERATION_TYPES.CREATE, "{"sender":"WO","target":"S-3","timestamp":"10:06am","message":"testing"}");
    }
    
    public static void testUpdateBattleDrill()
    {
        
        TemplateManager manager = TemplateManager.getInstance();
        BattleDrillManager bdManager = BattleDrillManager.getInstance();
        BattleDrillService service = new BattleDrillService();
        try
        {
            /*int diana = 0;
            if(diana < 1)
            {
             return;   
            }*/


//String types = service.getTypes();
            //System.out.println(types);
            
            //Template template = manager.getByType("intelligence_alert_of_impending_attack");
            //System.out.println(template);
            User user = new User("sessionId", 1, "CO", "Dustin");
            System.out.println("_________________________________________________________ START TEST ___________________________________________________________");
            BattleDrill bd = bdManager.createByType(1, "ied_discovered", "dianatest3", false, user, getTestLocation());
            
            /*int diana = 0;
            if(diana < 1)
            {
             return;   
            }*/
            
            
            bd.start();
            Thread.sleep(3000);
            System.out.println(bd);
            Thread.sleep(3000);
            BattleDrill b2 = bdManager.getByName("dianatest2");
            System.out.println("DIANA AFTER WAITING!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println(b2);
            
            //System.out.println("REST RESULT: ");
            //System.out.println(json);
        }
        catch(Exception e)
        {
            System.err.println("Diana - unable to test: " + e);
        }
    }
    
    public static void testOrderDrills() {
        BattleDrillManager bdManager = BattleDrillManager.getInstance();
        BattleDrillService service = new BattleDrillService();
        try
        {
//            System.out.println("___________________________ ALL DRILLS START __________________________");
//            System.out.println(bdManager.getAllDrillNames());
//            System.out.println("______________________________ ADD DRILLS _____________________________");
//            User user = new User("sessionId", "CO", "Dustin");
//            bdManager.createByType("ied_discovered", "dustinTest1", false, user, getTestLocation());
//            bdManager.createByType("ied_discovered", "dustinTest2", false, user, getTestLocation());
//            bdManager.createByType("ied_discovered", "dustinTest3", false, user, getTestLocation());
//            System.out.println(bdManager.getAllDrillNames());
//            
//            ArrayList<String> active = new ArrayList<String>();
//            active.add("dustinTest2");
//            active.add("dustinTest1");
//            active.add("dustinTest3");
//            ArrayList<String> completed = new ArrayList<String>();
//            OrderedDrillsRestParams odrp = new OrderedDrillsRestParams();
//            odrp.setOrderedActiveDrills(active);
//            odrp.setOrderedCompletedDrills(completed);
//            
//            service.updateBattleDrillOrder(odrp);
//            System.out.println("____________________________ REORDER DRILLS ___________________________");
//            System.out.println(bdManager.getAllDrillNames());
        }
        catch(Exception e)
        {
            System.err.println("Dustin - unable to test: " + e);
        }
    }
    
}
