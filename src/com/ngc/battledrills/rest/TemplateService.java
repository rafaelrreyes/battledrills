/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.rest;

import com.ngc.battledrills.restparams.TemplateRestParams;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.ngc.battledrills.data.Task;
import com.ngc.battledrills.exception.DuplicateItemException;
import com.ngc.battledrills.exception.ItemNotFoundException;
import com.ngc.battledrills.manage.TaskTemplateManager;
import com.ngc.battledrills.manage.TemplateManager;
import com.ngc.battledrills.template.BattleDrillTemplate;
import com.ngc.battledrills.util.JsonUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author rafae
 */
@Path("/templates")
public class TemplateService {
    
    @GET
    @Path("/{type}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getTemplate(@PathParam("type") String type) throws JsonProcessingException {
        if (StringUtils.isBlank(type)) {
            throw new WebApplicationException("Type parameter cannot be blank.", Response.Status.BAD_REQUEST);
        }
        
        TemplateManager manager = TemplateManager.getInstance();
        BattleDrillTemplate template = manager.getByType(type);
        return JsonUtils.writeValue(template);
    }
    
    @GET
    public String getTypes() throws JsonProcessingException {
        TemplateManager manager = TemplateManager.getInstance();
        Map<String, Object> types = manager.getTypes();
        return JsonUtils.writeValue(types);
    }
    
    @POST
    @Path("/save_template")
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveAsTemplate(TemplateRestParams params) throws JsonProcessingException {
        if (StringUtils.isBlank(params.getTemplate())) {
            throw new WebApplicationException("Unable to save battle drill template - the template cannot be blank");
        }
        
        TemplateManager manager = TemplateManager.getInstance();
        manager.saveTemplate(params.getTemplate());
    }
    
    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveTemplate(TemplateRestParams params) throws ItemNotFoundException, JsonProcessingException {
        
        if (StringUtils.isEmpty(params.getType()) || StringUtils.isEmpty(params.getDrillId()) || null == params.getUser()) {
            throw new WebApplicationException("Unable to save battle drill template - templateType, drillName and user cannot be blank");
        }
        
        TemplateManager manager = TemplateManager.getInstance();
        manager.saveTemplate(params.getType(), params.getDrillId(), params.getUser());
    }
    
    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createTemplate(TemplateRestParams params) throws DuplicateItemException, IOException {
        if (StringUtils.isEmpty(params.getType()) || null == params.getUser()) {
            throw new WebApplicationException("Unable to create new battle drill template - templateType and user cannot be blank");
        }
        
        TemplateManager manager = TemplateManager.getInstance();
        manager.createTemplate(params.getType(), params.getUser());
    }
    
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteTemplate(TemplateRestParams params) throws IOException {
        
        if (StringUtils.isEmpty(params.getType()) || null == params.getUser()) {
            throw new WebApplicationException("Unable to delete battle drill template - templateType and user cannot be blank");
        }
        
        TemplateManager manager = TemplateManager.getInstance();
        manager.deleteTemplate(params.getType(), params.getUser());
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/multiple")
    public void revertTemplates(TemplateRestParams params) throws IOException {
        if (params.getTemplatesToDelete().isEmpty() || null == params.getUser()) {
            throw new WebApplicationException("Unable to delete battle drill templates - templates cannot be empty and user cannot be blank");
        }
        
        TemplateManager manager = TemplateManager.getInstance();
        manager.deleteTemplates(params.getTemplatesToDelete(), params.getUser());
    }
    
    @POST
    @Path("/revert")
    @Consumes(MediaType.APPLICATION_JSON)
    public void revertTemplate(TemplateRestParams params) throws IOException {
        
        if (StringUtils.isEmpty(params.getType()) || null == params.getUser()) {
            throw new WebApplicationException("Unable to delete battle drill template - templateType and user cannot be blank");
        }
        
        TemplateManager manager = TemplateManager.getInstance();
        manager.revertTemplate(params.getType(), params.getUser());
    }
    
    @GET
    @Path("/tasks")
    public String getTaskTemplatesData() throws JsonProcessingException {
        // need to instantiate template manager to load tasks first if it hasnt yet
        TemplateManager.getInstance();
        TaskTemplateManager mgr = TaskTemplateManager.getInstance();
        return JsonUtils.writeValue(mgr.getTaskTemplatesData());
    }
    
    @GET
    @Path("/tasks/{type}")
    public String getTaskTemplatesByType(@PathParam("type") String type) throws JsonProcessingException {
        // need to instantiate template manager to load tasks first if it hasnt yet
        TemplateManager.getInstance();
        TaskTemplateManager mgr = TaskTemplateManager.getInstance();
        return JsonUtils.writeValue(mgr.getTaskTemplatesData().get(type));
    }
    
    @POST
    @Path("/tasks/role/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getTasksTemplateByRoleId(@PathParam("id") int id, TemplateRestParams params) throws JsonProcessingException {
        if (StringUtils.isBlank(params.getType()) || id < 1) {
            throw new WebApplicationException("Unable to get tasks by role ID and template type. Role ID must be defined in role DB and template type must be defined.");
        }
        
        TemplateManager mgr = TemplateManager.getInstance();
        return JsonUtils.writeValue(mgr.getTasksByRoleId(params.getType(), id));
    }
    
    
    @POST
    @Path("/tasks")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addTaskToFavorites(TemplateRestParams params) {
        
        if (StringUtils.isBlank(params.getTaskDescription())) {
            throw new WebApplicationException("Unable to add tasks to favorites templates. Task description parameter must be specified.");
        }
        
        TemplateManager.getInstance();
        TaskTemplateManager mgr = TaskTemplateManager.getInstance();
        mgr.addToFavorites(params.getTaskDescription());
    }
    
    @DELETE
    @Path("/tasks")
    @Consumes(MediaType.APPLICATION_JSON)
    public void removeTaskFromFavorites(TemplateRestParams params) {
        if (StringUtils.isBlank(params.getTaskDescription())) {
            throw new WebApplicationException("Unable to add tasks to favorites templates. Task description parameter must be specified.");
        }
        
        TemplateManager.getInstance();
        TaskTemplateManager mgr = TaskTemplateManager.getInstance();
        mgr.removeFromFavorites(params.getTaskDescription()); 
    }
}
