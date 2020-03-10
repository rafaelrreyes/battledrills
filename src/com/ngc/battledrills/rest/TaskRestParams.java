/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.rest;

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
    private String owner;
    private String description;
    private String taskId;
    private String drillName;
    
    public TaskRestParams() {}
    
    
    public void setDrillName(String name) {
        this.drillName = name;
    }
    
    @JsonProperty("drillName")
    public String getDrillName() {
        return this.drillName;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    @JsonProperty("user")
    public User getUser() {
        return this.user;
    }
    
    public void setOwner(String owner) {
        this.owner = owner;
    }
    
    @JsonProperty("owner")
    public String getOwner() {
        return this.owner;
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
