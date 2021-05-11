/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.restparams;

import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author rafae
 */
public class RoleParams {
    private int id;
    private int roleId;
    private int groupId;
    private String name;
    private String permission;
    private ArrayList<Integer> groups;
    private Map<String, String> properties;
    
    public RoleParams() {}
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getRoleId() {
        return this.roleId;
    }
    
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
    
    public int getGroupId() {
        return this.groupId;
    }
    
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getPermission() {
        return this.permission;
    }
    
    public void setPermission(String permission) {
        this.permission = permission;
    }
    
    public ArrayList<Integer> getGroups() {
        return this.groups;
    }
    
    public void setGroups(ArrayList<Integer> groups) {
        this.groups = groups;
    }
    
    public Map<String, String> getProperties() {
        return this.properties;
    }
    
    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }
}
