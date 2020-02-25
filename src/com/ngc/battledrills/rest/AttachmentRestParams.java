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
public class AttachmentRestParams {
    private String id;
    private String type;
    private User user;
    private String filename;
    
    // this POJO is strictly needed for the @DELETE request due to needing to parse the user as json
    public AttachmentRestParams() {}
    
    public void setId(String id) {
        this.id = id;
    }
    
     @JsonProperty("id")
    public String getId() {
        return this.id;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
     @JsonProperty("type")
    public String getType() {
        return this.type;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
     @JsonProperty("user")
    public User getUser() {
        return this.user;
    }
    
    public void setFilename(String filename) {
        this.filename = filename;
    }
    
    @JsonProperty("filename")
    public String getFilename() {
        return this.filename;
    }
}
