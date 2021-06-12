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
public class RoleRestParams {
    private User user;
    private int roleId;
    private String drillId;
    private int newRoleId;
    private int parentId;
    
    public RoleRestParams() {}
    
    @JsonProperty("newRoleId")
    public int getNewRoleId() {
        return newRoleId;
    }

    public void setNewRoleId(int newRoleId) {
        this.newRoleId = newRoleId;
    }
    
    @JsonProperty("parentId")
    public int getParentId() {
        return parentId;
    }

    public void setParent(int parentId) {
        this.parentId = parentId;
    }
    
    @JsonProperty("user")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @JsonProperty("roleId")
    public int getRoleId() {
        return this.roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @JsonProperty("drillId")
    public String getDrillId() {
        return drillId;
    }

    public void setDrillId(String drillId) {
        this.drillId = drillId;
    }
}
