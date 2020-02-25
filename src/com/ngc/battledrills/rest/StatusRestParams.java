/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ngc.battledrills.data.Status;
import com.ngc.battledrills.data.User;

/**
 *
 * @author Rafa
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StatusRestParams {
    private String taskId;
    private User user; // user who changed the status, sessionId for now
    private Status currentStatus;
        
    public String getTaskId() {
        return this.taskId;
    }
    
    @JsonProperty("user")
    public User getUser() {
        return this.user;
    }
    
    public Status getCurrentStatus() {
        return this.currentStatus;
    }
    
    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
    
    @JsonProperty("user")
    public void setUser(User user) {
        this.user = user;
    }
    
    public void setCurrentStatus(Status currentStatus) {
        this.currentStatus = currentStatus;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TaskID: ").append(this.taskId).append(System.lineSeparator());
        sb.append("User: ").append(this.user).append(System.lineSeparator());
        sb.append("Current Status: ").append(this.currentStatus).append(System.lineSeparator());
        return sb.toString();
    }
}
