/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.restparams;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ngc.battledrills.data.User;

/**
 *
 * @author rafae
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskRestParams {
    private User user;
    private int roleId;
    private String description;
    private String taskId;
    private String drillId;
    
    public TaskRestParams() {}
    
    
    public void setDrillId(String drillId) {
        this.drillId = drillId;
    }
    
    @JsonProperty("drillId")
    public String getDrillId() {
        return this.drillId;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    @JsonProperty("user")
    public User getUser() {
        return this.user;
    }
    
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
    
    @JsonProperty("roleId")
    public int getRoleId() {
        return this.roleId;
    }
    
    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
    
     @JsonProperty("taskId")
    public String getTaskId() {
        return this.taskId;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
     @JsonProperty("description")
    public String getDescription() {
        return this.description;
    }
}
