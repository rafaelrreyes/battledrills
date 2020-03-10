/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ngc.battledrills.data.BattleDrill;
import com.ngc.battledrills.manage.BattleDrillManager;
import static com.ngc.battledrills.BattleDrillsConfig.DEFAULT_JSON_WRITER;
import com.ngc.battledrills.data.Node;
import com.ngc.battledrills.data.User;
import com.ngc.battledrills.exception.ItemNotFoundException;
import com.ngc.battledrills.exception.DuplicateItemException;
import com.ngc.battledrills.manage.TemplateManager;
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
    public String getBattleDrillNames(@QueryParam("type") String type) throws JsonProcessingException {
        BattleDrillManager manager = BattleDrillManager.getInstance();
        if (type == null) {
            return DEFAULT_JSON_WRITER.writeValueAsString(manager.getAllDrillNames());
        }
        switch (type) {
            case "active":
                return DEFAULT_JSON_WRITER.writeValueAsString(manager.getActiveDrillNames());
            case "completed":
                return DEFAULT_JSON_WRITER.writeValueAsString(manager.getCompletedDrillNames());         
            default:
                throw new WebApplicationException("Drill type is unknown", Response.Status.BAD_REQUEST);
        }
    }
    
    @GET
    @Path("/battledrill/{name}")
    @Produces("application/json")
    public String getBattleDrillByName(@PathParam("name") String name) throws JsonProcessingException {
        if (StringUtils.isBlank(name)) {
            throw new WebApplicationException("Name parameter cannot be blank", Response.Status.BAD_REQUEST);
        }

        BattleDrillManager manager = BattleDrillManager.getInstance();
        return DEFAULT_JSON_WRITER.writeValueAsString(manager.getByName(name));
    }

    @DELETE
    @Path("/battledrill/{name}")
    public String deleteBattleDrillByName(@PathParam("name") String name, User user) throws JsonProcessingException {
        if(StringUtils.isBlank(name) || user.isEmpty()) {
            throw new WebApplicationException("Name path parameter and user cannot be blank", Response.Status.BAD_REQUEST);
        }
        
        BattleDrillManager manager = BattleDrillManager.getInstance();
        manager.deleteBattleDrill(name, user); // not validated for allowed requestors as of now, but can later
        return DEFAULT_JSON_WRITER.writeValueAsString(manager.getAllDrillNames());
    }
    
    @GET
    @Path("/{name}/subtree/{owner}")
    public String getSubtreeByOwner(@PathParam("name") String name, @PathParam("owner") String owner) {
        if (StringUtils.isBlank(name) || StringUtils.isBlank(owner)) {
            throw new WebApplicationException("Parameters must contain a battle drill name and a subtree owner",
                    Response.Status.BAD_REQUEST);
        }

        BattleDrillManager manager = BattleDrillManager.getInstance();
        BattleDrill bd = manager.getByName(name);
        if (null == bd) {
            throw new WebApplicationException(
                    "Unable to get subtree by owner - battle drill with name " + name + " not found",
                    Response.Status.BAD_REQUEST);
        }

        try {
            Node subtree = bd.getSubtreeByOwner(owner);
            return DEFAULT_JSON_WRITER.writeValueAsString(subtree);
        } catch (JsonProcessingException j) {
            System.err.println("Unable to subtree by owner: " + j);
            throw new WebApplicationException("Unable to get subtree by owner", Response.Status.BAD_REQUEST);
        }
    }

    @GET
    @Path("/types")
    public String getTypes() throws JsonProcessingException {
        TemplateManager manager = TemplateManager.getInstance();
        List<String> types = manager.getTypes();
        return DEFAULT_JSON_WRITER.writeValueAsString(types);
    }

    @PUT
    @Path("/start/{name}")
    public String startBattleDrill(@PathParam("name") String name) throws JsonProcessingException {
        if (StringUtils.isBlank(name)) {
            throw new WebApplicationException("Name parameter cannot be blank", Response.Status.BAD_REQUEST);
        }

        try {
            BattleDrillManager manager = BattleDrillManager.getInstance();
            manager.startBattleDrill(name);
            return DEFAULT_JSON_WRITER.writeValueAsString(manager.getByName(name));
        } catch (ItemNotFoundException b) {
            throw new WebApplicationException(b, Response.Status.BAD_REQUEST);
        }
    }

    @PUT
    @Path("/stop/{name}")
    public String stopBattleDrill(@PathParam("name") String name) throws JsonProcessingException {
        if (StringUtils.isBlank(name)) {
            throw new WebApplicationException("Name parameter cannot be blank", Response.Status.BAD_REQUEST);
        }
        try {
            BattleDrillManager manager = BattleDrillManager.getInstance();
            manager.stopBattleDrill(name);
            return DEFAULT_JSON_WRITER.writeValueAsString(manager.getByName(name));
        } catch (ItemNotFoundException b) {
            throw new WebApplicationException(b, Response.Status.BAD_REQUEST);
        }
    }
    
        
    @POST
    @Path("/diagram/position")
    @Consumes(MediaType.APPLICATION_JSON)
    public void changeDiagramElementPosition(PositionRestParams params) {
        if (StringUtils.isBlank(params.getBattleDrillName())
                || StringUtils.isBlank((params.getOwner()))
                || StringUtils.isBlank(params.getCoordinateType())) {
            throw new WebApplicationException("Parameters must contain a battle drill name, task owner, and a type", Response.Status.BAD_REQUEST);
        }
        
        BattleDrillManager manager = BattleDrillManager.getInstance();
        try {
            BattleDrill battleDrill = manager.getByName(params.getBattleDrillName());
            battleDrill.updateDiagramCoordinates(params.getOwner(), params.getCoordinateType(), params.getX(), params.getY());
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
            return DEFAULT_JSON_WRITER.writeValueAsString(battleDrill);
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
        try 
        {
            manager.updateBattleDrillOrder(params);
        } catch (Exception e) 
        {
            throw new WebApplicationException(e, Response.Status.BAD_REQUEST);
        }
    }
    
    @POST
    @Path("/owner")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response addOwnerToDrill(OwnerRestParams params) {
        
        if(StringUtils.isBlank(params.getOwner()) || StringUtils.isBlank(params.getDrillName()) || null == params.getUser()) {
            throw new WebApplicationException("Error when adding owner. Owner, drill name, and user object must all be defined.", Response.Status.BAD_REQUEST);
        }
        
        BattleDrillManager mgr = BattleDrillManager.getInstance();
        BattleDrill drill = mgr.getByName(params.getDrillName());
        boolean isSuccessful = drill.addOwner(params.getOwner(), params.getParent());
        return isSuccessful ? Response.status(Response.Status.OK).build() : Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
    
    @PUT
    @Path("/owner")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response editOwnerOnDrill(OwnerRestParams params) {
        
        if(StringUtils.isBlank(params.getOwner()) || StringUtils.isBlank(params.getNewOwner()) || StringUtils.isBlank(params.getDrillName()) || null == params.getUser()) {
            throw new WebApplicationException("Error when adding owner. Owner, drill name, and user object must all be defined.", Response.Status.BAD_REQUEST);
        }
        
        BattleDrillManager mgr = BattleDrillManager.getInstance();
        BattleDrill drill = mgr.getByName(params.getDrillName());
        boolean isSuccessful = drill.editOwner(params.getOwner(), params.getNewOwner());
        return isSuccessful ? Response.status(Response.Status.OK).build() : Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
    
    @DELETE
    @Path("/owner")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteOwnerFromDrill(OwnerRestParams params) {
        
        if(StringUtils.isBlank(params.getOwner()) || StringUtils.isBlank(params.getDrillName()) || null == params.getUser()) {
            throw new WebApplicationException("Error when adding owner. Owner, drill name, and user object must all be defined.", Response.Status.BAD_REQUEST);
        }
        
        BattleDrillManager mgr = BattleDrillManager.getInstance();
        BattleDrill drill = mgr.getByName(params.getDrillName());
        boolean isSuccessful = drill.deleteOwner(params.getOwner());
        return isSuccessful ? Response.status(Response.Status.OK).build() : Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
}
