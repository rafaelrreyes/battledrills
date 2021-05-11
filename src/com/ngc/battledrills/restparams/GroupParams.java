/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.restparams;

import java.util.ArrayList;

/**
 *
 * @author rafae
 */
public class GroupParams {
    private int id;
    private int roleId;
    private int groupId;
    private String name;
    private ArrayList<Integer> roles;
    
    public GroupParams() {}
    
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
    
    public ArrayList<Integer> getRoles() {
        return this.roles;
    }
    
    public void setRoles(ArrayList<Integer> roles) {
        this.roles = roles;
    }
}
