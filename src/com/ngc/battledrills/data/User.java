/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author admin
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private String sessionId = "";
    private String role = "";
    private String username = "";
    
    // Needed for JSON deserialization
    private User(){}
    
    public User(String sessionId, String role, String username) {
        this.sessionId = sessionId;
        this.role = role;
        this.username = username;
    }
    
    @JsonProperty("sessionId")
    public String getSessionId() {
        return sessionId;
    }
    
    @JsonProperty("role")
    public String getRole() {
        return role;
    }

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }
    
    @JsonProperty("sessionId")
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
    
    @JsonProperty("role")
    public void setRole(String role) {
        this.role = role;
    }
    
    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }
    
    /*
        Only checks for sessionId and role right now.
        Add check for username when we implement all of it.
    */
    @JsonIgnore
    public boolean isEmpty() {
        return StringUtils.isBlank(sessionId) || StringUtils.isBlank(role);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SessionId: ").append(getSessionId()).append(System.lineSeparator());
        sb.append("Role: ").append(getRole()).append(System.lineSeparator());
        sb.append("Username: ").append(getUsername()).append(System.lineSeparator());

        return sb.toString();
    }
}
