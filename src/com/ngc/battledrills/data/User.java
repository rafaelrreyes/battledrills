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
    private String name = "";
    private int id = 0;
    private String username = "";
    
    // Needed for JSON deserialization
    private User(){}
    
    public User(String sessionId, int id, String name, String username) {
        this.sessionId = sessionId;
        this.id = id;
        this.name = name;
        this.username = username;
    }
    
    @JsonProperty("sessionId")
    public String getSessionId() {
        return sessionId;
    }
    
    @JsonProperty("name")
    public String getName() {
        return this.name;
    }

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }
    
    @JsonProperty("sessionId")
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
    
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }
    
    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }
    
    @JsonProperty("id")
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    /*
        Only checks for sessionId and role right now.
        Add check for username when we implement all of it.
    */
    @JsonIgnore
    public boolean isEmpty() {
        return StringUtils.isBlank(sessionId) || id < 1 || name.equals("");
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SessionId: ").append(getSessionId()).append(System.lineSeparator());
        sb.append("ID: ").append(getId()).append(System.lineSeparator());
        sb.append("Name: ").append(getName()).append(System.lineSeparator());
        sb.append("Username: ").append(getUsername()).append(System.lineSeparator());

        return sb.toString();
    }
}
