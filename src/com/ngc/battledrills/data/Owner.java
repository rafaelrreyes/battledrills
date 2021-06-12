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
    private int billetId = 0;
    private Map<String, List<Task>> tasksByBattleDrill; // BattleDrill x Tasks
    
    public Owner(int billetId) {
        if (billetId < 1) {
            throw new InvalidParameterException("Unable to construct Owner - billet ID parameter must be defined in roles.");
        }
        
        this.billetId = billetId;
        tasksByBattleDrill = new HashMap<>();
    }
    
    public void addTasksToDrillById(String drillId, List<Task> tasks) {
        if (tasksByBattleDrill.containsKey(drillId)) {
            List<Task> existingTasks = tasksByBattleDrill.get(drillId);
            existingTasks.addAll(tasks);
        } else {
            tasksByBattleDrill.put(drillId, tasks);
        }
    }
    
    @JsonIgnore
    public int getBilletId() {
        return this.billetId;
    }
    
    @JsonAnyGetter
    public Map<String, List<Task>> getTasksByDrillIDs() {
        return tasksByBattleDrill;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.billetId).append(System.lineSeparator());
        for (String drillId : tasksByBattleDrill.keySet()) {
            sb.append(drillId).append(System.lineSeparator());
            sb.append(tasksByBattleDrill.get(drillId));
        }
        
        return sb.toString();
    }
    
}
