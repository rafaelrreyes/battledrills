/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.data;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ngc.battledrills.comms.Notification;
import com.ngc.battledrills.comms.Notify;
import com.ngc.battledrills.comms.NotifyManager;
import com.ngc.battledrills.comms.NotifyTypes;
import com.ngc.battledrills.exception.ItemNotFoundException;
import com.ngc.battledrills.manage.BattleDrillManager;
import com.ngc.battledrills.data.reports.ReportData;
import com.ngc.battledrills.exception.DuplicateItemException;
import com.ngc.battledrills.manage.ReportsManager;
import com.ngc.battledrills.template.BattleDrillTemplate;
import com.ngc.battledrills.util.JacksonInjectableValues;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import org.apache.commons.lang3.StringUtils;
import com.ngc.battledrills.util.JsonUtils;
/**
 *
 * @author admin
 */
@JsonFilter(JsonUtils.DefinedFilters.NODE_FILTER)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Node {
    private String owner = "";
    private final Map<String, Integer> selfCoordinates = new HashMap<String, Integer>();
    private final Map<String, Integer> tasksCoordinates = new HashMap<String, Integer>();

    public class NodeConstants {
        public static final String SELF = "self";
        public static final String TASKS = "tasks";
    }
            
    @JacksonInject(JacksonInjectableValues.SAVE_AS_TEMPLATE)
    protected boolean saveAsTemplate = false;
    
    @JsonManagedReference
    public List<Task> tasks = new ArrayList<>();

    @JsonBackReference(value="node")
    public Node parent;

    @JsonManagedReference(value="node")
    private List<Node> children = new ArrayList<>();

    @JsonBackReference
    private BattleDrillTemplate bdroot;

    public Node(){}

    @JsonProperty("title")
    public void setOwner(String owner)
    {
        this.owner = owner;
    }

    public String getOwner()
    {
        return this.owner;
    }

    /**
     * Sets the self coordinates when new drill is created using json template.
     * @param coordinates 
     */
    @JsonProperty("self_coordinates")
    public void setSelfCoordinates(Map<String, Integer> coordinates)
    {
        if (coordinates.containsKey("x") && coordinates.containsKey("y")) {
            this.selfCoordinates.put("x", coordinates.get("x"));
            this.selfCoordinates.put("y", coordinates.get("y"));
        }
    }

    public Map<String, Integer> getSelfCoordinates() {
        return this.selfCoordinates;
    }

    /**
     * Sets the tasks coordinates when new drill is created using json template.
     * @param coordinates 
     */
    @JsonProperty("tasks_coordinates")
    public void setTasksCoordinates(Map<String, Integer> coordinates)
    {
        if (coordinates.containsKey("x") && coordinates.containsKey("y")) {
            this.tasksCoordinates.put("x", coordinates.get("x"));
            this.tasksCoordinates.put("y", coordinates.get("y"));
        }
    }

    public Map<String, Integer> getTasksCoordinates() {
        return this.tasksCoordinates;
    }
    
    /**
     * Updates the self coordinates of the current node.
     * @param x
     * @param y 
     */
    public void updateSelfCoordinates(int x, int y) {
        this.selfCoordinates.put("x", x);
        this.selfCoordinates.put("y", y);
    }

     /**
     * Updates the self coordinates of the current node.
     * @param x
     * @param y 
     */
    public void updateTasksCoordinates(int x, int y) {
        this.tasksCoordinates.put("x", x);
        this.tasksCoordinates.put("y", y);
    }
    
    @JsonIgnore
    public String getBattleDrillName()
    {
        if(null != bdroot)
        {
            return bdroot.getName();
        }
        else if(null != parent)
        {
            return parent.getBattleDrillName();
        }
        else
        {
            return "";
        }
    }
    
    public void setBattleDrillName(String battleDrillName) {
        bdroot = new BattleDrillTemplate();
        bdroot.setName(battleDrillName);
    }

    @JsonProperty("tasks")
    public void setTasks(List<Task> tasks)
    {
        this.tasks = tasks;
        if (!saveAsTemplate) {
                    
        }
        try
        {
            TaskRepo.addTasks(tasks);
//            this.tasks = tasks;
        }
        catch(DuplicateItemException d)
        {
            System.err.println("Unable to set tasks for owner " + getOwner() + " - duplicate task being added: " + d);
        }
    }
    
    public void emptyTasks() throws ItemNotFoundException {
        deleteFromTaskRepo(this.getTasks());
        this.tasks.clear();
    }
    
    public void emptyChildren() throws ItemNotFoundException {
        
        if (null != this.children || this.children.size() > 0) {
            for (int i = 0; i < this.children.size(); i++) {
                Node childNode = this.children.get(i);
                if (null != childNode.getTasks() || childNode.getTasks().size() > 0) {
                    deleteFromTaskRepo(childNode.getTasks());
                }
                
                // need to do a deep remove of childrens tasks from task repo
                childNode.emptyChildren();
            }
        
        }

        this.children.clear();
    }
    
    public void deleteFromTaskRepo(List<Task> tasks) throws ItemNotFoundException {
         List<String> taskIdsToRemove = new ArrayList<>();
        
        // need to create a temporary array that holds the task ID's to remove, actually invoking the deleteTask in this first loop doesn't work 
        for (int i = 0; i < tasks.size(); i++) {

            String taskId = tasks.get(i).getId();
            taskIdsToRemove.add(taskId);
        }
        
        // clear all task repo corresponding tasks as well
        for (String taskId : taskIdsToRemove) {
            TaskRepo.deleteTask(taskId, null);
        }
    }
    
    /**
     * Add a new task to this node. 
     * @param description
     * @param coordinates
     * @return  
     */
    @JsonIgnore
    public boolean addNewTask(String description, Map<String, Integer> coordinates) {
        try {
            Task newTask = new Task();
   
            // set description if it is defined by user
            if (!StringUtils.isBlank(description)) {
                newTask.setDescription(description);
            } else {
                newTask.setDescription("---");
            }
            
            // set the parent of the new task to the caller (aka node)
            newTask.parent = this;
            TaskRepo.addTask(newTask);
            this.tasks.add(newTask);
			
            // Update report with new task
            ReportsManager rMgr = ReportsManager.getInstance();
            Report report = rMgr.getReport(this.getBattleDrillName());
            // drill is created at this point, report should already be created

            // check if drill started
            BattleDrillManager bdMgr = BattleDrillManager.getInstance();
            BattleDrill drill = bdMgr.getByName(this.getBattleDrillName());
            if (drill.getStartTime() != null) {
                LocalDateTime startTime = LocalDateTime.now();
                newTask.getCurrentStatus().setStartTime(startTime);
                List<Status> statuses = new ArrayList<>();
                statuses.add(newTask.getCurrentStatus());
                ReportData data = new ReportData(newTask.getOwner(), newTask.getDescription(), statuses, startTime);
                if (report.getReportData(newTask.getId()) == null) {
                    report.setReportData(newTask.getId(), data);
                    report.setNumTasks(report.getNumTasks() + 1);
                }
                
                rMgr.saveReport(report);
            }
            // only need to set the coordinates if they are set
            if (!coordinates.isEmpty()) {
                this.setTasksCoordinates(coordinates);
            }
            
            BattleDrillManager mgr = BattleDrillManager.getInstance();
            mgr.saveBattleDrill(newTask.parent.getBattleDrillName(), false);
            return true;
        } catch (DuplicateItemException | ItemNotFoundException e) {
            throw new WebApplicationException("Error when adding a new task.");
        }
    }
    
    /**
     * Updates a task description within this node by its id.
     * @param taskId
     * @param user
     * @param description 
     * @return boolean
     */
    @JsonIgnore
    public boolean updateTaskDescriptionById(String taskId, User user, String description) {
        
        try {
            Task task = TaskRepo.getTask(taskId);
            TaskRepo.editTaskDescription(task, description);
            // TODO can have report modification here if we want to track task modifications
            
            // find task in this node that matches, and edit it by replacing it with the new task
            for (int i = 0; i < this.tasks.size(); i++) {
                
                if (this.tasks.get(i).getId().equals(taskId)) {
                    this.tasks.set(i, task);
                }
            }
            
            // create notification using user obj
            // send task edit notification
            String automatedNoteText = task.getDescription();
            Note descriptionNote = new Note(user, automatedNoteText);
            descriptionNote.setType(Note.NoteTypes.AUTO_GENERATED);
            descriptionNote.setAutoType(Note.AutoGenTypes.TASK_DESCRIPTION_EDIT);
            Notification taskNotification = NotifyManager.createTaskNotification(NotifyTypes.OPERATION_TYPES.EDIT, Task.EditableKeys.DESCRIPTION, user, getBattleDrillName(), task.getTaskData(), descriptionNote.getId());
            Notify.sendNotificationToAllExcluding(taskNotification);
            Notify.sendNotification(NotifyManager.createToastNotification(NotifyTypes.OPERATION_TYPES.EDIT, taskNotification));
            
            BattleDrillManager mgr = BattleDrillManager.getInstance();
            mgr.saveBattleDrill(getBattleDrillName(), false);
            return true;
        } catch (ItemNotFoundException e) {
            throw new WebApplicationException("Error when attempting to update a task description", Response.Status.BAD_REQUEST);
        }
    }
    
    /**
     * Edits owner name then saves it to database.
     * @param newOwner
     * @return boolean
     */
    public boolean editOwnerAndSave(String newOwner) {
        try {
            this.setOwner(newOwner);
            BattleDrillManager mgr = BattleDrillManager.getInstance();
            mgr.saveBattleDrill(getBattleDrillName(), false);
            return true;
        } catch(ItemNotFoundException e) {
            throw new WebApplicationException("Error when attempting to edit owner title.");
        }
    }

    public List<Task> getTasks()
    {
        return this.tasks;
    }

    @JsonProperty("children")
    public void setChildNodes(List<Node> children)
    {
        this.children = children;
    }
    
    /**
     * Adds a new child node to this current node.
     * @param node 
     */
    public void addChildNode(Node node){
        this.children.add(node);
    }

    public List<Node> getChildNodes()
    {
        return this.children;
    }

    // Traverse the tree to get the tasks for all owners/billets
    @JsonIgnore
    public void getTasksForAllOwners(Map<String, List<Task>> ownerXtasks)
    {
        String owner = this.getOwner();
        if(ownerXtasks.containsKey(owner))
        {
            List<Task> mytasks = ownerXtasks.get(owner);
            mytasks.addAll(tasks);
        }
        else
        {
            ownerXtasks.put(owner, tasks);
        }

        for(Node child : children)
        {
            child.getTasksForAllOwners(ownerXtasks);
        }
    }

    @JsonIgnore
    public void startAllTasks(LocalDateTime startTime) {
        ReportsManager rMgr = ReportsManager.getInstance();
        // drill is created at this point, report should already be created
        Report report = rMgr.getReport(this.getBattleDrillName());
        report.setStartTime(startTime);

        tasks.forEach((task) -> {
            task.getCurrentStatus().setStartTime(startTime);
            List<Status> statuses = new ArrayList<>();
            statuses.add(task.getCurrentStatus());
            ReportData data = new ReportData(task.getOwner(), task.getDescription(), statuses, startTime);
            if (report.getReportData(task.getId()) == null) {
                report.setReportData(task.getId(), data);
            }
        });

        children.forEach((child) -> {
            child.startAllTasks(startTime);
        });
        rMgr.saveReport(report);
    }

    // Traverse the tree to get the tasks owned by the requested owner/billet
    public List<Task> getTasksByOwner(String owner)
    {
        Node match = null;
        for(Node child : children)
        {
            if(child.getOwner().equalsIgnoreCase(owner))
            {
                match = child;
                break;
            }
        }

        if(null != match)
        {
            return match.getTasks();
        }
        else // If the node matching the owner was not found, pass the find request to child nodes
        {
            for(Node child : children)
            {
                match = child.getSubtreeByOwner(owner);
                if(null != match)
                {
                    break;
                }
            }
        }

        return (match == null)?null:match.getTasks();
    }

    // Traverse the tree to get the subtree owned by the requested owner
    public Node getSubtreeByOwner(String owner)
    {
        Node match = null;
        for(Node child : children)
        {
            if(child.getOwner().equalsIgnoreCase(owner))
            {
                match = child;
                break;
            }
        }

        if(null != match)
        {
            return match;
        }
        else // If the node matching the owner was not found, pass the find request to child nodes
        {
            for(Node child : children)
            {
                match = child.getSubtreeByOwner(owner);
                if(null != match)
                {
                    break;
                }
            }
        }

        return match;
    }

    // Traverse the tree to delete the requested task
    public boolean deleteTask(String taskId, User user)
    {
        boolean success = false;
        Task toDelete = null;

        // First check if the task is in this node's task list.  If so, delete it and return successful
        for(Task task : tasks)
        {
            if(task.getId().equals(taskId))
            {
                toDelete = task;
                break;
            }
        }

        // If the task was found in this node's task list, delete it and record success
        if(null != toDelete)
        {
            tasks.remove(toDelete);
            success = true;

            ReportsManager rMgr = ReportsManager.getInstance();
            Report report = rMgr.getReport(this.getBattleDrillName());
            report.deleteReportData(taskId);
            report.setNumTasks(report.getNumTasks() - 1);
            
            // create notification using user obj
            // send task edit notification
            if (null != user) {
                Notification taskNotification = NotifyManager.createTaskNotification(NotifyTypes.OPERATION_TYPES.DELETE, user, toDelete.getTaskData(), getBattleDrillName());
                Notify.sendNotificationToAllExcluding(taskNotification);
                Notify.sendNotification(NotifyManager.createToastNotification(NotifyTypes.OPERATION_TYPES.DELETE, taskNotification));
            }
        }
        else // If the task was not found, pass the delete request to child nodes, and return immediately if the task is successfully deleted in a descendant of this node
        {
            for(Node child : children)
            {
                success = child.deleteTask(taskId, user);
                if(success == true)
                {
                    break;
                }
            }
        }

        return success;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Owner: ").append(this.owner).append(System.lineSeparator());

        if (selfCoordinates.containsKey("x") && selfCoordinates.containsKey("y")) {
            sb.append("Self coordinates: { x: " + selfCoordinates.get("x") + ", y: " + selfCoordinates.get("y") + " }").append(System.lineSeparator());
        }

        if (tasksCoordinates.containsKey("x") && tasksCoordinates.containsKey("y")) {
            sb.append("Tasks coordinates: { x: " + tasksCoordinates.get("x") + ", y: " + tasksCoordinates.get("y") + " }").append(System.lineSeparator());
        }

        if(tasks != null && tasks.size() > 0)
        {
            sb.append("Tasks: ").append(System.lineSeparator());
            for(Task task : tasks)
            {
                sb.append(task).append(System.lineSeparator());
            }
        }

        if(children != null && children.size() > 0)
        {
            sb.append("Children: ").append(System.lineSeparator());
            for(Node node : children)
            {
                sb.append(node).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
