/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.data;

import com.ngc.battledrills.comms.Notification;
import com.ngc.battledrills.comms.Notify;
import com.ngc.battledrills.comms.NotifyManager;
import com.ngc.battledrills.comms.NotifyTypes;
import com.ngc.battledrills.manage.BattleDrillManager;
import com.ngc.battledrills.exception.DuplicateItemException;
import com.ngc.battledrills.exception.ItemNotFoundException;
import com.ngc.battledrills.util.BattleDrillConstants;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author admin
 */
public class TaskRepo {
    private static final Map<String, Task> masterTasks = new ConcurrentHashMap<>(100);
    
    public static List<Task> getAllTasks()
    {
        return new ArrayList(masterTasks.values());
    }
    
    public static void deleteTasksByBattleDrill(String battleDrillName)
    {
        if(StringUtils.isBlank(battleDrillName))
        {
            throw new InvalidParameterException("Unable to delete task by battle drill - battleDrillName parameter cannot be empty");
        }
        
        List<String> toDelete = new ArrayList<>();
        for(Task task: masterTasks.values())
        {
            if(task.getBattleDrillName().equals(battleDrillName))
            {
                toDelete.add(task.getId());
            }
        }
        
        for(String id : toDelete)
        {
            masterTasks.remove(id);
        }
    }
    
    public static Task getTask(String taskId) throws ItemNotFoundException
    {
        if(masterTasks.containsKey(taskId) == false)
        {
            throw new ItemNotFoundException("Unable to get task with id: " + taskId + " - TaskId not found in task repository");
        }
        else
        {
            return masterTasks.get(taskId);
        }
    }
    
    public static void addTask(Task task) throws DuplicateItemException
    {
        Objects.requireNonNull(task);
        
        if(masterTasks.containsKey(task.getId()))
        {
            throw new DuplicateItemException("Task with id " + task.getId() + " has already been added to the task list");
        }
        
        masterTasks.put(task.getId(), task);
    }
    
    public static void editTaskDescription(Task task, String description) {
        Objects.requireNonNull(task);
        
        if (masterTasks.containsKey(task.getId())) {
            Task edittedTask = masterTasks.get(task.getId());
            String newDescription = "";
            if (null != description || !StringUtils.isBlank(description)) {
                newDescription = description;
            }
            
            edittedTask.setDescription(newDescription);
            masterTasks.replace(task.getId(), edittedTask);
        }
    }
    
    public static int size()
    {
        return masterTasks.size();
    }
    
    public static void addTasks(List<Task> tasks) throws DuplicateItemException
    {
        Objects.requireNonNull(tasks);
        
        // Cycle through the list twice; once to check if any IDs are duplicates, and if not, then add them all to the task repo
        for(Task task : tasks)
        {
            if(masterTasks.containsKey(task.getId()))
            {
                throw new DuplicateItemException("Task with id " + task.getId() + " has already been added to the task list");
            }
        }
        
        // Can use Java 8 Stream API to do this, but not worth the extra code complexity for what amounts to a very small number of tasks being added at a time
        for(Task task : tasks)
        {
            masterTasks.put(task.getId(), task);
        }
    }
    
    public static void updateTask(Task task) throws ItemNotFoundException
    {
        Objects.requireNonNull(task);
        
        if(masterTasks.containsKey(task.getId()) == false)
        {
            throw new ItemNotFoundException("Task with id " + task.getId() + " does not exist");
        }
        
        masterTasks.replace(task.getId(), task);
    }
    
    public static Map<String, List<Task>> getTasksByBillet(String billet)
    {
        Map<String, List<Task>> tasksByBillet = new LinkedHashMap<>();
        
        BattleDrillManager bdMgr = BattleDrillManager.getInstance();
        ArrayList<String> activeDrillNames = bdMgr.getActiveDrillNames().get("active");
        for(String bdName : activeDrillNames)
        {
            List<Task> tasks = bdMgr.getByName(bdName).getTasksByOwner(billet);
            if(null != tasks)
            {
                tasksByBillet.put(bdName, tasks);
            }
        }
        
        return tasksByBillet;
    }
    
    // The task needs to be deleted from both this current task list and the containing battle drill as well
    public static void deleteTask(String taskId) throws ItemNotFoundException
    {
        if(StringUtils.isBlank(taskId))
        {
            throw new InvalidParameterException("Unable to delete task - taskId parameter cannot be blank.");
        }
        
        if(masterTasks.containsKey(taskId))
        {
            if(masterTasks.containsKey(taskId) == false)
            {
                throw new ItemNotFoundException("Unable to delete task.  Task with id: " + taskId + " not found in task repo.");
            }
            
            Task task = masterTasks.get(taskId);
            String battleDrillName = task.getBattleDrillName();
            
            if(StringUtils.isBlank(battleDrillName))
            {
                throw new ItemNotFoundException("Unable to find battle drill that contains requested task to delete - The task does not have a valie battleDrillName parameter.  Task details: " + task);
            }
            
            BattleDrillManager mgr = BattleDrillManager.getInstance();
            BattleDrill battleDrill = mgr.getByName(battleDrillName);

            if (null != battleDrill)
            {
                boolean success = battleDrill.deleteTask(taskId);
                if(success)
                {          
                    battleDrill.dequeuePrioritizedTask(taskId);
                    masterTasks.remove(taskId);
                    mgr.saveBattleDrill(battleDrillName, false);
                }
            }
            else
            {
                throw new ItemNotFoundException("Unable to delete task - battle drill with name: " + battleDrillName + " not found.");
            }
        }
    }
}
