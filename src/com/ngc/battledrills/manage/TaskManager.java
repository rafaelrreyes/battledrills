/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.manage;

import com.ngc.battledrills.comms.Notify;
import com.ngc.battledrills.comms.TaskNotification;
import com.ngc.battledrills.data.BattleDrill;
import com.ngc.battledrills.data.Owner;
import com.ngc.battledrills.data.Status;
import com.ngc.battledrills.exception.ItemNotFoundException;
import com.ngc.battledrills.data.Task;
import com.ngc.battledrills.data.TaskRepo;
import com.ngc.battledrills.data.User;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author admin
 */
public class TaskManager {
    private TaskManager(){}
    
    public static Map<String, Owner> getTaskMetrics()
    {
        BattleDrillManager mgr = BattleDrillManager.getInstance();
        Map<String, Owner> metrics = new HashMap<>();
        List<BattleDrill> activeDrills = mgr.getActiveDrills();
        
        // For each active battle drill, obtain a map of owners/billets and their associated tasks.
        // If this owner/billet has not been recorded yet, createa a new Owner opbject and add the tasks from each battle drill to it
        // If this owner/billet has already been recorded, add the tasks for the current battle drill loop value to the existing Owner object
        for(BattleDrill bd : activeDrills)
        {
            Map<String, List<Task>> tasksXowner = bd.getTasksXOwner(); // Map<Owner_Billet, List<Task>>
            
            for(String ownerName : tasksXowner.keySet())
            {
                // Only add the battle drill entry to this owner's list if there are actually tasks assigned to this owner in the battle drill
                if(tasksXowner.get(ownerName).size() > 0) 
                {
                    if(metrics.containsKey(ownerName)) // It we have already recorded this owner/billet for another battle drill, add to the existing Owner object
                    {
                        Owner o = metrics.get(ownerName);
                        o.addTasks(bd.getName(), tasksXowner.get(ownerName));
                    }
                    else // The owner/billet hasn't been recorded yet for any battle drills, so we'll create one here
                    {
                        Owner o = new Owner(ownerName);
                        o.addTasks(bd.getName(), tasksXowner.get(ownerName));
                        metrics.put(ownerName, o);
                    }
                }
            }
        }
        return metrics;
    }
    
    
    public static void startTask(String taskId) throws ItemNotFoundException
    {
        if(StringUtils.isBlank(taskId))
        {
            throw new InvalidParameterException("Unable to start task - taskId parameter cannot be blank");
        }
        
        Task task = TaskRepo.getTask(taskId);
        task.start();
    }
    
    public static void stopTask(String taskId) throws ItemNotFoundException
    {
        if(StringUtils.isBlank(taskId))
        {
            throw new InvalidParameterException("Unable to stop task - taskId parameter cannot be blank");
        }
        
        Task task = TaskRepo.getTask(taskId);
        task.stop();
    }
    
    /**
     * Targets a task by id then changes its status.
     * @param taskId
     * @param user
     * @param newStatus
     * @throws ItemNotFoundException
     * @return Task
     */
    public static Task changeTaskStatus(String taskId, User user, String newStatus) throws ItemNotFoundException {

        if (StringUtils.isBlank(taskId)) {
            throw new InvalidParameterException("Unable to change task status - taskId parameter cannot be blank");
        }
        
        Task targetTask = TaskRepo.getTask(taskId);
        return targetTask.changeCurrentStatus(user, newStatus);
    }
    
    public static String staticToString()
    {
        StringBuilder sb = new StringBuilder();
        
        for(Task task : TaskRepo.getAllTasks())
        {
            sb.append(task).append(System.lineSeparator());
        }
        
        return sb.toString();
    }
}
