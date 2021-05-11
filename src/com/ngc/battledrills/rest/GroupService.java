/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.rest;

import com.ngc.battledrills.data.Group;
import com.ngc.battledrills.data.Role;
import com.ngc.battledrills.manage.GroupManager;
import com.ngc.battledrills.restparams.GroupParams;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author rafae
 */

@Path("/groups")
public class GroupService {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Group> getGroups() {
        GroupManager groupMgr = GroupManager.getInstance();
        return groupMgr.getGroupsList();
    }
    
    @GET
    @Path("/names")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getGroupnames() {
        GroupManager groupMgr = GroupManager.getInstance();
        return groupMgr.getGroupnames();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Group addGroup(GroupParams params) {
        
        if (StringUtils.isBlank(params.getName())) {
            throw new WebApplicationException("Name cannot be empty when creating a group. Please define name parameter and try again.");
        }
        
        Group group = null;
        
        try {
            GroupManager groupMgr = GroupManager.getInstance();
            group = groupMgr.addGroup(params.getName(), params.getRoles());
        } catch (Exception e) {
            System.err.println("Error occurred when adding new group.");
        }
        
        return group;
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Group editGroupnameById(GroupParams params) {
        if (StringUtils.isBlank(params.getName())) {
            throw new WebApplicationException("Name cannot be empty when editting a group. Please define a name parameter and try again.");
        }
        
        if (params.getId() < 1) {
            throw new WebApplicationException("ID cannot be empty when editting a group. Please define an ID parameter and try again.");
        }
        
        Group group = null;
        GroupManager groupMgr = GroupManager.getInstance();
        group = groupMgr.editGroupnameById(params.getId(), params.getName());
        
        return group;
    }
    
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteGroupById(GroupParams params) {
        if (params.getId() < 1) {
            throw new WebApplicationException("Error when deleting group: " + params.getId() + ". Id must be defined in database.");        
        }
        
        GroupManager groupMgr = GroupManager.getInstance();
        groupMgr.deleteGroupById(params.getId());
    }
    
    @POST
    @Path("/role")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> addRoleToGroupById(GroupParams params) {
        if (params.getGroupId() < 1 || params.getRoleId() < 1) {
            throw new WebApplicationException("Error when adding role to group. Must specify both group id and role id parameters.");
        }
        
        GroupManager groupMgr = GroupManager.getInstance();
        Map<String, Object> response = groupMgr.addRoleToGroupById(params.getGroupId(), params.getRoleId());
        
        return response;
    }
    
    @DELETE
    @Path("/role")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteRoleFromGroupById(GroupParams params) {
        if (params.getGroupId() < 1 || params.getRoleId() < 1) {
            throw new WebApplicationException("Error when deleting role from group. Must specify both group id and role id parameters.");
        }
        
        GroupManager groupMgr = GroupManager.getInstance();
        groupMgr.deleteRoleFromGroupById(params.getGroupId(), params.getRoleId());
    }
}
