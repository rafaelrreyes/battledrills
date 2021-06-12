/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.rest;

import com.ngc.battledrills.restparams.RoleRestParams;
import com.ngc.battledrills.restparams.PositionRestParams;
import com.ngc.battledrills.restparams.OrderedDrillsRestParams;
import com.ngc.battledrills.restparams.BattleDrillRestParams;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.ngc.battledrills.data.BattleDrill;
import com.ngc.battledrills.manage.BattleDrillManager;
import com.ngc.battledrills.data.Node;
import com.ngc.battledrills.data.User;
import com.ngc.battledrills.exception.ItemNotFoundException;
import com.ngc.battledrills.exception.DuplicateItemException;
import com.ngc.battledrills.manage.TemplateManager;
import com.ngc.battledrills.util.JsonUtils;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author admin
 */
@Path("/battledrills")
public class BattleDrillService {
    @GET
    public String getBattleDrills(@QueryParam("type") String type) throws JsonProcessingException {
        BattleDrillManager manager = BattleDrillManager.getInstance();
        if (type == null) {
            return JsonUtils.writeValue(manager.getAllDrills());
        }
        switch (type) {
            case "active":
                return JsonUtils.writeValue(manager.getActiveDrills());
            case "completed":
                return JsonUtils.writeValue(manager.getCompletedDrills());
            default:
                throw new WebApplicationException("Drill type is unknown", Response.Status.BAD_REQUEST);
        }
    }
    
    @GET
    @Path("/battledrill/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getBattleDrillById(@PathParam("id") String id) throws JsonProcessingException {
        if (StringUtils.isBlank(id)) {
            throw new WebApplicationException("ID parameter cannot be blank", Response.Status.BAD_REQUEST);
        }

        BattleDrillManager manager = BattleDrillManager.getInstance();
        return JsonUtils.writeValue(manager.getById(id));
    }
    
    @POST
    @Path("/battledrill/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String editDrillNameById(@PathParam("id") String id, BattleDrillRestParams params) throws JsonProcessingException {
        if (StringUtils.isBlank(params.getName()) || StringUtils.isBlank(id)) {
            throw new WebApplicationException("Name and ID parameters cannot be blank", Response.Status.BAD_REQUEST);
        }
        
        BattleDrillManager manager = BattleDrillManager.getInstance();
        BattleDrill bd = manager.editDrillNameById(id, params.getName());
        return JsonUtils.writeValue(bd);
    }

    @DELETE
    @Path("/battledrill/{id}")
    public String deleteBattleDrillById(@PathParam("id") String id, User user) throws JsonProcessingException {
        if(StringUtils.isBlank(id) || user.isEmpty()) {
            throw new WebApplicationException("ID path parameter and user cannot be blank", Response.Status.BAD_REQUEST);
        }
        
        BattleDrillManager manager = BattleDrillManager.getInstance();
        manager.deleteBattleDrill(id, user); // not validated for allowed requestors as of now, but can later
        return JsonUtils.writeValue(manager.getAllDrills());
    }
    
    @GET
    @Path("/{id}/subtree/{roleId}")
    public String getSubtreeByRoleId(@PathParam("id") String id, @PathParam("roleId") int roleId) {
        if (StringUtils.isBlank(id) || roleId < 1) {
            throw new WebApplicationException("Parameters must contain a battle drill id and a role ID that is defined in roles DB.",
                    Response.Status.BAD_REQUEST);
        }

        BattleDrillManager manager = BattleDrillManager.getInstance();
        BattleDrill bd = manager.getById(id);
        if (null == bd) {
            throw new WebApplicationException(
                    "Unable to get subtree by role ID - battle drill with id " + id + " not found",
                    Response.Status.BAD_REQUEST);
        }

        try {
            Node subtree = bd.getSubtreeByRoleId(roleId);
            return JsonUtils.writeValue(subtree);
        } catch (JsonProcessingException j) {
            System.err.println("Unable to subtree by role ID: " + j);
            throw new WebApplicationException("Unable to get subtree by role ID", Response.Status.BAD_REQUEST);
        }
    }

    @PUT
    @Path("/start/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public String startBattleDrill(@PathParam("id") String id, User user) throws JsonProcessingException {
        if (StringUtils.isBlank(id) && user.isEmpty()) {
            throw new WebApplicationException("ID and User parameters cannot be blank", Response.Status.BAD_REQUEST);
        }

        try {
            BattleDrillManager manager = BattleDrillManager.getInstance();
            manager.startBattleDrill(id, user);
            return JsonUtils.writeValue(manager.getById(id));
        } catch (ItemNotFoundException b) {
            throw new WebApplicationException(b, Response.Status.BAD_REQUEST);
        }
    }

    @PUT
    @Path("/stop/{id}")
    public String stopBattleDrill(@PathParam("id") String id, User user) throws JsonProcessingException {
        if (StringUtils.isBlank(id) && user.isEmpty()) {
            throw new WebApplicationException("ID and User parameters cannot be blank", Response.Status.BAD_REQUEST);
        }
        try {
            BattleDrillManager manager = BattleDrillManager.getInstance();
            manager.stopBattleDrill(id, user);
            return JsonUtils.writeValue(manager.getById(id));
        } catch (ItemNotFoundException b) {
            throw new WebApplicationException(b, Response.Status.BAD_REQUEST);
        }
    }
    
        
    @POST
    @Path("/diagram/position")
    @Consumes(MediaType.APPLICATION_JSON)
    public void changeDiagramElementPosition(PositionRestParams params) {
        if (StringUtils.isBlank(params.getDrillId())
                || params.getRoleId() < 1
                || StringUtils.isBlank(params.getCoordinateType())) {
            throw new WebApplicationException("Parameters must contain a battle drill id, role ID of task owner, and a type", Response.Status.BAD_REQUEST);
        }
        
        BattleDrillManager manager = BattleDrillManager.getInstance();
        try {
            BattleDrill battleDrill = manager.getById(params.getDrillId());
            battleDrill.updateDiagramCoordinates(params.getRoleId(), params.getCoordinateType(), params.getX(), params.getY());
        } catch (Exception e) {
            throw new WebApplicationException(e, Response.Status.BAD_REQUEST);
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String createByType(BattleDrillRestParams params) {
        if (StringUtils.isBlank(params.getType()) 
            || StringUtils.isBlank(params.getName()) 
            || params.getUser().isEmpty()) {
            throw new WebApplicationException("Parameters must contain a battle drill type, name, and user (username, role, sessionId)",
                    Response.Status.BAD_REQUEST);
        }

        BattleDrillManager manager = BattleDrillManager.getInstance();
        try {
            BattleDrill battleDrill = manager.createByType(params);
            return JsonUtils.writeValue(battleDrill);
        } catch (DuplicateItemException | JsonProcessingException e) {
            throw new WebApplicationException(e, Response.Status.BAD_REQUEST);
        }
    }
    
    @POST
    @Path("/reorder")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateBattleDrillOrder(OrderedDrillsRestParams params) {
        // maybe check here if the creator of the action was sent and error if it wasn't
        if (params.getOrderedActiveDrills().isEmpty() && params.getOrderedCompletedDrills().isEmpty() && params.getUser().isEmpty()) 
        {
            throw new WebApplicationException("Parameters must contain an array of battle drill names and user",
                    Response.Status.BAD_REQUEST);
        }

        BattleDrillManager manager = BattleDrillManager.getInstance();
        try  {
            manager.updateBattleDrillOrder(params);
        } catch (Exception e) {
            throw new WebApplicationException(e, Response.Status.BAD_REQUEST);
        }
    }
    
    @POST
    @Path("/role")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response addRoleToDrill(RoleRestParams params) {
        
        if (params.getRoleId() < 1 || StringUtils.isBlank(params.getDrillId()) || null == params.getUser()) {
            throw new WebApplicationException("Error when adding role to drill. Role ID, drill ID, and user object must all be defined.", Response.Status.BAD_REQUEST);
        }
        
        BattleDrillManager mgr = BattleDrillManager.getInstance();
        BattleDrill drill = mgr.getById(params.getDrillId());
        boolean isSuccessful = drill.addRole(params.getRoleId(), params.getParentId());
        return isSuccessful ? Response.status(Response.Status.OK).build() : Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
    
    @PUT
    @Path("/role")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response editRoleOnDrill(RoleRestParams params) {
        
        if (params.getRoleId() < 1 || params.getNewRoleId() < 1 || StringUtils.isBlank(params.getDrillId()) || null == params.getUser()) {
            throw new WebApplicationException("Error when editting role on drill. Role ID, new role ID, drill ID, and user object must all be defined.", Response.Status.BAD_REQUEST);
        }
        
        BattleDrillManager mgr = BattleDrillManager.getInstance();
        BattleDrill drill = mgr.getById(params.getDrillId());
        boolean isSuccessful = drill.editRoleById(params.getRoleId(), params.getNewRoleId());
        return isSuccessful ? Response.status(Response.Status.OK).build() : Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
    
    @DELETE
    @Path("/role")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteRoleFromDrill(RoleRestParams params) {
        
        if (params.getRoleId() < 1 || StringUtils.isBlank(params.getDrillId()) || null == params.getUser()) {
            throw new WebApplicationException("Error when deleting role from drill. Role ID, drill ID, and user object must all be defined.", Response.Status.BAD_REQUEST);
        }
        
        BattleDrillManager mgr = BattleDrillManager.getInstance();
        BattleDrill drill = mgr.getById(params.getDrillId());
        boolean isSuccessful = drill.deleteRoleById(params.getRoleId());
        return isSuccessful ? Response.status(Response.Status.OK).build() : Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
}
