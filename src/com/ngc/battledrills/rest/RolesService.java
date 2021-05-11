/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.rest;

import com.ngc.battledrills.data.Role;
import com.ngc.battledrills.manage.RolesManager;
import com.ngc.battledrills.restparams.RoleParams;
import java.util.ArrayList;
import java.util.List;
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
@Path("/roles")
public class RolesService {
    
    @GET
    @Path("/permissions")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getPermissionTypes() {
        List<String> types = new ArrayList<>();
        types.add("admin");
        types.add("user");
        return types;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Role> getRoles() {
        RolesManager rolesMgr = RolesManager.getInstance();
        return rolesMgr.getRolesList();
    }
    
    @GET
    @Path("/names")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getRolenames() {
        RolesManager rolesMgr = RolesManager.getInstance();
        return rolesMgr.getRolenames();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Role addRole(RoleParams params) {
        
        if (StringUtils.isBlank(params.getName()) || StringUtils.isBlank(params.getPermission())) {
            throw new WebApplicationException("Name and permission cannot be empty when adding a new role. Please define and try again.");
        }   
        
        Role role = null;
        
        try {
            RolesManager rolesMgr = RolesManager.getInstance();
            role = rolesMgr.addRole(params.getName(), params.getPermission(), params.getGroups());
        } catch (Exception e) {
            System.err.println("Error occurred when adding new role.");
        }
        
        return role;
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Role editRoleProperties(RoleParams params) {
        
        if (null == params.getProperties()) {
            throw new WebApplicationException("Error when editting role: " + params.getId() + ". Map of param properties must be defined.");
        }
        
        if (params.getId() < 1) {
            throw new WebApplicationException("Error when editting role: " + params.getId() + ". Id must be defined in database.");        
        }
        
        RolesManager rolesMgr = RolesManager.getInstance();
        Role role = rolesMgr.editRoleProperties(params.getId(), params.getProperties());
        
        return role;
    }
    
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON) 
    public void deleteRoleById(RoleParams params) {
        
        if (params.getId() < 1) {
            throw new WebApplicationException("Error when deleting role: " + params.getId() + ". Id must be defined in database.");        
        }
        
        RolesManager rolesMgr = RolesManager.getInstance();
        rolesMgr.deleteRoleById(params.getId());
    }
}
