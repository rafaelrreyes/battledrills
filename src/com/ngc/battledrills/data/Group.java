/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ngc.battledrills.manage.GroupManager;
import com.ngc.battledrills.manage.RolesManager;
import java.util.ArrayList;

/**
 *
 * @author rafae
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Group {
    private int id;
    private String name;
    private ArrayList<Integer> roles = new ArrayList<Integer>();
    private ArrayList<String> roleNames;
    
    private Group() {}
    
    public Group(int id, String name, ArrayList<Integer> roles) {
        this.id = id;
        this.name = name;
        this.roles = roles;
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
    
    @JsonProperty("roles")
    public ArrayList<Integer> getRoles() {
        return this.roles;
    }

    public void setRoles(ArrayList<Integer> roles) {
        this.roles = roles;
    }
    
    @JsonProperty("roleNames") 
    public ArrayList<String> getRoleNames() {
        ArrayList<String> mappedRolesNames = new ArrayList<>();
        RolesManager roleMgr = RolesManager.getInstance();
        
        this.roles.forEach((roleId) -> {
            mappedRolesNames.add(roleMgr.getRolesMap().get(roleId).getName());
        });
        return mappedRolesNames;
    }
    
    public void setRoleNames(ArrayList<String> roleNames) {
        this.roleNames = roleNames;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(getId()).append(System.lineSeparator());
        sb.append("Name: ").append(getName()).append(System.lineSeparator());
        
        return sb.toString();
    }
}
