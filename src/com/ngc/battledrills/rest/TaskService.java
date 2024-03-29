/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.rest;

import com.ngc.battledrills.restparams.NoteRestParams;
import com.ngc.battledrills.restparams.StatusRestParams;
import com.ngc.battledrills.restparams.TaskRestParams;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ngc.battledrills.data.BattleDrill;
import com.ngc.battledrills.manage.BattleDrillManager;
import com.ngc.battledrills.exception.ItemNotFoundException;
import com.ngc.battledrills.manage.TaskManager;
import com.ngc.battledrills.data.Node;
import com.ngc.battledrills.data.Status;
import com.ngc.battledrills.data.Task;
import com.ngc.battledrills.data.TaskRepo;
import com.ngc.battledrills.manage.TaskTemplateManager;
import com.ngc.battledrills.manage.TemplateManager;
import com.ngc.battledrills.util.JsonUtils;
import com.ngc.battledrills.util.JacksonInjectableValues;
import java.security.InvalidParameterException;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Response;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author admin
 */
@Path("/task")
public class TaskService {
    
    @GET
    @Path("/metrics")
    @Produces("text/plain")
    public String getCurrentTaskMetrics() {
        try {
            return JsonUtils.writeValue(TaskManager.getTaskMetrics());
        } catch(JsonProcessingException j) {
            throw new WebApplicationException(j, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GET
    @Path("/test")
    @Produces("text/plain")
    public String test() throws JsonProcessingException {
        BattleDrillManager mgr = BattleDrillManager.getInstance();
        List<String> names = mgr.getActiveDrillNames().get("active");
        if (names.size() > 0) {
            String name = names.get(0);
            BattleDrill bd = mgr.getByName(name);
            Node root = bd.getRoot();
            Node child = root.getChildNodes().get(0);
            
            List<Task> tasks = child.getTasks();
            
            Task task = tasks.get(0);
            return JsonUtils.writeValue(task);
        }
        return "No tasks found";
    }
    
    @GET
    @Path("/{id}")
    @Produces("text/plain")
    public String getTaskById(@PathParam("id") String taskId) throws JsonProcessingException {
        if(StringUtils.isBlank(taskId)) {
            throw new WebApplicationException("ID parameter cannot be blank", Response.Status.BAD_REQUEST);
        }
        
        try {
            return JsonUtils.writeValue(TaskRepo.getTask(taskId));
        } catch(ItemNotFoundException i) {
            throw new WebApplicationException(i, Response.Status.BAD_REQUEST);
        }
    }
    
    @GET
    @Path("/billet/{billetId}")
    @Produces("text/plain")
    public String getTasksByBillet(@PathParam("billetId") int billetId) throws JsonProcessingException {
        if (billetId < 1) {
            throw new WebApplicationException("Billet ID parameter must be defined (role ID in database)", Response.Status.BAD_REQUEST);
        }
        
        return JsonUtils.writeValue(TaskRepo.getTasksByBillet(billetId));
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response addTask(TaskRestParams params) {
        
        if (params.getRoleId() < 1 || StringUtils.isBlank(params.getDrillId()) || null == params.getUser()) {
            throw new WebApplicationException("Role ID must be defined in roles DB. Drill ID, and user object parameters cannot be blank.", Response.Status.BAD_REQUEST);
        }  
        
        BattleDrillManager mgr = BattleDrillManager.getInstance();
        BattleDrill drill = mgr.getById(params.getDrillId());
        boolean isSuccessful = drill.addTaskToRole(params.getRoleId(), params.getDescription(), params.getUser());
        return isSuccessful ? Response.status(Response.Status.OK).build() : Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response editTask(TaskRestParams params) throws ItemNotFoundException {
        
        if (StringUtils.isBlank(params.getTaskId()) || params.getRoleId() < 1 || null == params.getUser()) {
            throw new WebApplicationException("Role ID must be defined in roles DB. Task ID, User, parameters cannot be blank.", Response.Status.BAD_REQUEST);
        }
        
        BattleDrillManager mgr = BattleDrillManager.getInstance();
        Task task = TaskRepo.getTask(params.getTaskId());
        BattleDrill drill = mgr.getById(task.getBattleDrillId());
        boolean isSuccessful = drill.updateTaskDescription(params.getRoleId(), params.getUser(), params.getTaskId(), params.getDescription());
        
        return isSuccessful ? Response.status(Response.Status.OK).build() : Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
    
    
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public void deleteTaskById(TaskRestParams params) throws JsonProcessingException {
        if (StringUtils.isBlank(params.getTaskId()) || null == params.getUser()) {
            throw new WebApplicationException("Task ID and user parameters cannot be blank", Response.Status.BAD_REQUEST);
        }
        
        try {
            TaskRepo.deleteTask(params.getTaskId(), params.getUser());
        } catch (ItemNotFoundException e ) {
            throw new WebApplicationException("Error when deleting task: " + params.getTaskId());
        }
    }
    
    @PUT
    @Path("/start/{id}")
    @Produces("text/plain")
    public void startTask(@PathParam("id") String taskId) {
        if (StringUtils.isBlank(taskId)) {
            throw new WebApplicationException("'id' parameter cannot be blank", Response.Status.BAD_REQUEST);
        }
        
        try {
            TaskManager.startTask(taskId);
        } catch(ItemNotFoundException | InvalidParameterException e) {
            throw new WebApplicationException(e, Response.Status.BAD_REQUEST);
        }
    }
    
    @PUT
    @Path("/stop/{id}")
    @Produces("text/plain")
    public void stopTask(@PathParam("id") String taskId) {
        if(StringUtils.isBlank(taskId)) {
            throw new WebApplicationException("'id' parameter cannot be blank", Response.Status.BAD_REQUEST);
        }
        
        try {
            TaskManager.stopTask(taskId);
        } catch(ItemNotFoundException | InvalidParameterException e) {
            throw new WebApplicationException(e, Response.Status.BAD_REQUEST);
        }
    }
    
    @PUT
    @Path("/note")
    @Produces("text/plain")
    public String addNote(NoteRestParams param) {
        try {
            Task task = TaskRepo.getTask(param.getTaskId());
            if (null != task) {
                task.addNote(param.getNote());
            }
        } catch (ItemNotFoundException | InvalidParameterException e) {
            throw new WebApplicationException(e, Response.Status.BAD_REQUEST);
        }
        
        try {
            return JsonUtils.writeValue(param.getNote());
        } catch(JsonProcessingException j) {
            throw new WebApplicationException(j, Response.Status.BAD_REQUEST);
        }
    }
    
    @POST
    @Path("/status")
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public String changeStatus(StatusRestParams params) {
        try {
            Task changedTask = TaskManager.changeTaskStatus(params.getTaskId(), params.getUser(), params.getStatus());
            return JsonUtils.writeValue(changedTask);
        } catch (ItemNotFoundException | InvalidParameterException | JsonProcessingException e) {
            throw new WebApplicationException(e, Response.Status.BAD_REQUEST);
        }
    }
    
}
