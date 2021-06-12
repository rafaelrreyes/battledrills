/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.data.reports;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ngc.battledrills.manage.RolesManager;

/**
 *
 * @author dustin
 * @param <T>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class TaskXY<T> {
    private T x;
    private T y;
    private int roleId = 0;
    private String roleName = "";
    private String description = "";

    public TaskXY(T x, T y, int roleId, String description) {
        RolesManager mgr = RolesManager.getInstance();
        this.x = x;
        this.y = y;
        this.roleId = roleId;
        this.description = description;
        if (roleId == -1) {
            this.roleName = "";
        } else {
            this.roleName = mgr.getRolenameById(roleId);
        }
    }

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }

    public int getRoleId() {
        return this.roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
    
    public String getRoleName() {
        RolesManager mgr = RolesManager.getInstance();
        
        if (this.roleId == -1) {
            return "";
        }
        return mgr.getRolenameById(this.roleId);
    }
    
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Role ID: ").append(this.getRoleId()).append(System.lineSeparator());
        sb.append("Description: ").append(this.getDescription()).append(System.lineSeparator());
        sb.append("X: ").append(this.getX()).append(System.lineSeparator());
        sb.append("Y: ").append(this.getY()).append(System.lineSeparator());

        return sb.toString();
    }
}
