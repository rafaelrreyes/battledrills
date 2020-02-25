/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.data;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author admin
 */
public class Owner {
    private String billet = "";
    private Map<String, List<Task>> tasksByBattleDrill; // BattleDrill x Tasks
    
    public Owner(String billet)
    {
        if(StringUtils.isBlank(billet))
        {
            throw new InvalidParameterException("Unable to construct Owner - billet parameter cannot be empty");
        }
        this.billet = billet;
        tasksByBattleDrill = new HashMap<>();
    }
    
    public void addTasks(String battleDrillName, List<Task> tasks)
    {
        if(tasksByBattleDrill.containsKey(battleDrillName))
        {
            List<Task> existingTasks = tasksByBattleDrill.get(battleDrillName);
            existingTasks.addAll(tasks);
        }
        else
        {
            tasksByBattleDrill.put(battleDrillName, tasks);
        }
    }
    
    @JsonIgnore
    public String getBillet()
    {
        return billet;
    }
    
    @JsonAnyGetter
    public Map<String, List<Task>> getTasksXOwner()
    {
        return tasksByBattleDrill;
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(billet).append(System.lineSeparator());
        for(String battleDrillName : tasksByBattleDrill.keySet())
        {
            sb.append(battleDrillName).append(System.lineSeparator());
            sb.append(tasksByBattleDrill.get(battleDrillName));
        }
        
        return sb.toString();
    }
    
}
