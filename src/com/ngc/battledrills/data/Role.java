/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author rafae
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Role {
    private int id;
    private String name;
    private String permission;
    
    private Role() {}
    
    public Role(int id, String name, String permission) {
        // TODO: self assign ID
        this.id = id;
        this.name = name;
        this.permission = permission;
    }
    
    @JsonProperty("id")
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    @JsonProperty("name")
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @JsonProperty("permission")
    public String getPermission() {
        return this.permission;
    }
    
    public void setPermission(String permission) {
        this.permission = permission;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(getId()).append(System.lineSeparator());
        sb.append("Name: ").append(getName()).append(System.lineSeparator());
        sb.append("Permission: ").append(getPermission()).append(System.lineSeparator());
        
        return sb.toString();
    }
}
