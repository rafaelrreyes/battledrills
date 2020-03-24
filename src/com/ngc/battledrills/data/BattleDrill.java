/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.ngc.battledrills.comms.Notification;
import com.ngc.battledrills.comms.Notify;
import com.ngc.battledrills.comms.NotifyManager;
import com.ngc.battledrills.comms.NotifyTypes;
import com.ngc.battledrills.exception.ItemNotFoundException;
import com.ngc.battledrills.manage.AttachmentManager;
import com.ngc.battledrills.manage.BattleDrillManager;
import com.ngc.battledrills.template.BattleDrillTemplate;
import com.ngc.battledrills.util.BattleDrillConstants;
import java.security.InvalidParameterException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author admin
 */
@JsonInclude(Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BattleDrill extends BattleDrillTemplate {
    private String name;
    private String creatorName;
    private LocalDateTime startTime = null;
    private LocalDateTime endTime = null;
    private Map<String, String> location = new HashMap<>();
    private List<Attachment> attachments = new ArrayList<>();
    
    public BattleDrill(){}

    @JsonProperty("attachments")
    public List<Attachment> getAttachments() {
        return this.attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }
    
    /**
     * Adds an attachment to current battle drill then returns true if successful.
     * @param attachment
     * @param user
     * @return 
     */
    @JsonIgnore
    public boolean addAttachment(Attachment attachment, User user) {
        this.attachments.add(attachment);
        
         // send attachment upload notification
        Notification attachmentNotification = 
                NotifyManager.createAttachmentNotification(NotifyTypes.OPERATION_TYPES.CREATE, user, getName(), null, AttachmentManager.AttachmentTypes.BATTLE_DRILL, attachment.getFilename());
        Notify.sendNotificationToAllExcluding(attachmentNotification);
        Notify.sendNotification(NotifyManager.createToastNotification(NotifyTypes.OPERATION_TYPES.CREATE, attachmentNotification));
        return true;
    }
    
    /**
     * Gets the attachment by its name, return null otherwise.
     * @param fileName
     * @return 
     */
    @JsonIgnore
    public Attachment getAttachmentByName(String fileName) {
        Attachment targetAttachment = null;
        for (Attachment attachment : this.attachments) {
            if (attachment.getFilename().equals(fileName)) {
                targetAttachment = attachment;
                break;
            }
        }
        
        return targetAttachment;
    }
    
    /**
     * Deletes an attachment from current battle drill then returns true if successful.
     * @param fileName
     * @param user
     * @return 
     */
    @JsonIgnore
    public boolean deleteAttachment(String fileName, User user) {
        boolean isDeleted = false;
        
        // search and destroy
        for (int i = 0; i < this.attachments.size(); i++) {
            if (this.attachments.get(i).getFilename().equals(fileName)) {
                this.attachments.remove(i);
                
                 // send attachment delete notification
                Notification attachmentNotification = 
                        NotifyManager.createAttachmentNotification(NotifyTypes.OPERATION_TYPES.DELETE, user, getName(), null, AttachmentManager.AttachmentTypes.BATTLE_DRILL, fileName);
                Notify.sendNotificationToAllExcluding(attachmentNotification);
                Notify.sendNotification(NotifyManager.createToastNotification(NotifyTypes.OPERATION_TYPES.DELETE, attachmentNotification));
                isDeleted = true;
                break;
            }
        }
        return isDeleted;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setCreatorName(String creatorName)
    {
        this.creatorName = creatorName;
    }
    
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    public void setStartTime(LocalDateTime startTime)
    {
        this.startTime = startTime;
    }
    
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    public void setEndTime(LocalDateTime endTime)
    {
        this.endTime = endTime;
    }
    
    @Override
    public String getName()
    {
        return this.name;
    }
    
    public String getCreatorName()
    {
        return this.creatorName;
    }
    
    @JsonIgnore
    public Node getSubtreeByOwner(String owner)
    {
        if(StringUtils.isBlank(owner))
        {
            throw new InvalidParameterException("Unable to get subtree by owner - owner parameter cannot be blank");
        }
        
        Node root = this.getRoot();
        return (root.getOwner().equalsIgnoreCase(owner))?root:root.getSubtreeByOwner(owner);
    }
    
    @JsonIgnore
    public List<Task> getTasksByOwner(String owner)
    {
        if(StringUtils.isBlank(owner))
        {
            throw new InvalidParameterException("Unable to get tasks by owner - owner parameter cannot be blank");
        }
        
        Node root = this.getRoot();
        return (null == root ? null : (root.getOwner().equalsIgnoreCase(owner))?root.getTasks():root.getTasksByOwner(owner));
    }
    
    // Returns a list of all tasks grouped by the tasks' owner
    @JsonIgnore
    public Map<String, List<Task>> getTasksXOwner()
    {
        Map<String, List<Task>> tasksXOwner = new HashMap<>();
        root.getTasksForAllOwners(tasksXOwner);
        return tasksXOwner;
    }
    
    public long getStartTimeMillis()
    {
        if(startTime == null)
        {
            return -1;
        }
        ZoneId zoneId = ZoneId.systemDefault(); // or: ZoneId.of("Europe/Oslo");
        long epoch = startTime.atZone(zoneId).toEpochSecond();
        return epoch;
    }
    
    public long getEndTimeMillis()
    {
        if(endTime == null)
        {
            return -1;
        }
        ZoneId zoneId = ZoneId.systemDefault(); // or: ZoneId.of("Europe/Oslo");
        long epoch = endTime.atZone(zoneId).toEpochSecond();
        return epoch;
    }
    
    @JsonProperty("duration")
    public long getElapsedTimeInSeconds()
    {
        if(startTime == null)
        {
            return 0;
        }
        
        if(endTime == null)
        {
            return Duration.between(startTime, LocalDateTime.now()).getSeconds();
        }
        else
        {
            return Duration.between(startTime, endTime).getSeconds();
        }
    }
    
    // @return a boolean value indicating whether or not the task was found and deleted.  A false value indicates the task was not found in this battle drill
    public boolean deleteTask(String taskId, User user)
    {
        if (StringUtils.isBlank(taskId))
        {
            throw new InvalidParameterException("Unable to delete task - taskId parameter cannot be blank");
        }
        Node root = this.getRoot();
        return root.deleteTask(taskId, user);
    }
    
    /**
     * Updates a battle drills target node x, y coordinates by the owner name and type.
     * Type can be "self" or "task".
     * @param owner
     * @param coordinateType
     * @param x
     * @param y
     * @throws java.lang.Exception
     */
    public void updateDiagramCoordinates(String owner, String coordinateType, int x, int y) throws Exception {
        Node targetNode = getNodeByOwner(owner);
        switch (coordinateType) {
            case Node.NodeConstants.SELF:
                targetNode.updateSelfCoordinates(x, y);
                break;
            case Node.NodeConstants.TASKS:
                targetNode.updateTasksCoordinates(x, y);
                break;
            default:
                throw new Exception("Coordinate type must be one of the following: self, tasks");
        }
        
        // TODO
        BattleDrillManager mgr = BattleDrillManager.getInstance();
        mgr.saveBattleDrill(this.getName(), false);
    }
    
    /**
     * Updates the description of a task embedded within this drill. Looks up the target owner node and then updates its target task.
     * @param owner
     * @param user
     * @param taskId
     * @param description 
     * @return boolean
     */
    public boolean updateTaskDescription(String owner, User user, String taskId, String description) {
        Node targetNode = getNodeByOwner(owner);
        return targetNode.updateTaskDescriptionById(taskId, user, description);
    }
    
    /**
     * Adds a new task to an owner by their name.
     * @param owner
     * @param description
     * @param user
     * @return boolean
     */
    public boolean addTaskToOwner(String owner, String description, User user) {

        try {
            Node targetNode = getNodeByOwner(owner);
            Map<String, Integer> coordinates = new HashMap<>();
            
            // only set the coordinates if it the first task being added
            if (targetNode.getTasks().isEmpty()) {
                coordinates.put("x", targetNode.getSelfCoordinates().get("x"));
                coordinates.put("y", targetNode.getSelfCoordinates().get("y") + BattleDrillConstants.DEFAULT_DIAGRAM_Y_COORDINATE_OFFSET);
            }
            
            // TODO perform notification here
            return targetNode.addNewTask(description, coordinates);
        } catch (Exception e) {
            throw new WebApplicationException("Error when trying to find owner of name: " + owner + ". That owner does not exist.");
        }
        
    }
    
    /**
     * Adds a new owner to this drill.
     * @param owner
     * @param parent
     * @return boolean
     */
    public boolean addOwner(String owner, String parent) {
        
        // create the new owner
        Node newNode = new Node();
        Map<String, Integer> coordinates = new HashMap<>();
        newNode.setOwner(owner);
        
        // this owner is being added as a child to another node
        if (null != parent || !StringUtils.isBlank(parent)) {
        
            Node parentNode = getNodeByOwner(parent);
            
            // Place new owner node directly under its parent in diagram
            coordinates.put("x", parentNode.getSelfCoordinates().get("x"));
            coordinates.put("y", parentNode.getSelfCoordinates().get("y") + BattleDrillConstants.DEFAULT_DIAGRAM_Y_COORDINATE_OFFSET);
            newNode.setSelfCoordinates(coordinates);
            
            // add the new node to the children of parent
            parentNode.addChildNode(newNode);

            
            // set the parent of the new node
            newNode.parent = parentNode;
            
        // this is the new root node
        } else {
            // Default new root node in "middle" of diagram
            coordinates.put("x", BattleDrillConstants.DEFAULT_DIAGRAM_ROOT_X_COORDINATE);
            coordinates.put("y", BattleDrillConstants.DEFAULT_DIAGRAM_ROOT_Y_COORDINATE);
            newNode.setSelfCoordinates(coordinates);
            newNode.setBattleDrillName(this.getName());
            this.setRoot(newNode);
        }
        
        super.addParticipant(owner);
        
        // save to database
        try {
            BattleDrillManager mgr = BattleDrillManager.getInstance();
            mgr.saveBattleDrill(this.getName(), false);
        } catch (ItemNotFoundException ex) {
            throw new WebApplicationException("Error when adding new owner.");
        }
        
        return true;
    }
    
    /**
     * Edits a current owner to a new title.
     * @param owner
     * @param newOwner
     * @return 
     */
    public boolean editOwner(String owner, String newOwner) {
        Node targetNode = getNodeByOwner(owner);
        return targetNode.editOwnerAndSave(newOwner);
    }
    
    /**
     * 
     * @param owner
     * @return 
     */
    public boolean deleteOwner(String owner) {
        // deleting an owner should also delete their task and subgroups, otherwise, we may want to set the deleted owner's owner to the childs (mending open wound)
        try {
            Node targetNode = getNodeByOwner(owner);
            
            // delete all participants under this owner from participants data structure
            recursiveDeleteParticipant(targetNode);
            
            // delete self from participants data structure
            super.deleteParticipant(owner);
            
            // empty all tasks and children data structures
            targetNode.emptyTasks();
            targetNode.emptyChildren();
            
            // loop through the parent of this owner and delete its pointer to this node
            Node parentNode = targetNode.parent;
            
            // check if this is not the root
            if (null != parentNode) {
                for (int i = 0; i < parentNode.getChildNodes().size(); i++) {
                    if (parentNode.getChildNodes().get(i).getOwner().equalsIgnoreCase(owner)) {
                        parentNode.getChildNodes().remove(i);
                    }
                }
            } else {
                super.emptyParticipants();
                this.setRoot(null);
            }
            
            BattleDrillManager mgr = BattleDrillManager.getInstance();
            mgr.saveBattleDrill(getName(), false);
            return true;
        } catch (ItemNotFoundException ex) {
            throw new WebApplicationException("Error when attempting to delete owner");
        }
    }
    
    /**
     * Deletes all owners under the parameter node (subordinates) from the participants data structure.
     * @param node 
     */
    public void recursiveDeleteParticipant(Node node) {
        if (node.getChildNodes() == null || node.getChildNodes().isEmpty()) {
            super.deleteParticipant(node.getOwner());
        } else {
            node.getChildNodes().forEach((childNode) -> {
                recursiveDeleteParticipant(childNode);
            });
        }
    }
    
    /**
     * Sets the location latitude and longitude of this drill.
     * @param location 
     */
    public void setLocation(Map<String, String> location) {
        if (StringUtils.isBlank(location.get("latitude")) 
            || StringUtils.isBlank(location.get("longitude"))) {
            // should we make altitude and tilt (for cesium) required?
            throw new InvalidParameterException("Unable to set location - both latitude and longitude cannot be blank");
        }

        this.location.put("latitude", location.get("latitude"));
        this.location.put("longitude", location.get("longitude"));
        
        if (location.containsKey("altitude") && !StringUtils.isBlank(location.get("altitude"))) {
            this.location.put("altitude", location.get("altitude"));
        }
        
        if (location.containsKey("tilt") && !StringUtils.isBlank(location.get("tilt"))) {
            this.location.put("tilt", location.get("tilt"));
        }
    }
    
    /**
     * Helper to get the node by the owner name.
     * @param owner
     * @return Node
     */
    private Node getNodeByOwner(String owner) {
        Node rootNode = this.getRoot();
        return rootNode.getOwner().equalsIgnoreCase(owner) ? rootNode : rootNode.getSubtreeByOwner(owner);
    }
    
    @JsonProperty("location")
    public Map<String, String> getLocation() {
        return this.location;
    }
    
    public void start() throws ItemNotFoundException
    {
       startTime = LocalDateTime.now();
       Node rootNode = this.getRoot();
       
       BattleDrillManager mgr = BattleDrillManager.getInstance();
       mgr.saveBattleDrill(this.getName(), false);
    }
    
    public void stop() throws ItemNotFoundException
    {
        endTime = LocalDateTime.now();
        BattleDrillManager mgr = BattleDrillManager.getInstance();
        mgr.saveBattleDrill(this.getName(), false);
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(this.getName()).append(System.lineSeparator());
        sb.append("Type: ").append(this.getType()).append(System.lineSeparator());
        sb.append("Creator Name: ").append(this.getCreatorName()).append(System.lineSeparator());
        sb.append("Location: (").append("Latitude: ").append(location.get("latitude"))
          .append(", Longitude: ").append(location.get("longitude")).append(")").append(System.lineSeparator());
        sb.append("Permission: ").append(this.getPermission()).append(System.lineSeparator());
        sb.append("Start time: ").append(this.getStartTimeMillis()).append(System.lineSeparator());
        sb.append("End Time: ").append(this.getEndTimeMillis()).append(System.lineSeparator());
        sb.append("Duration: ").append(this.getElapsedTimeInSeconds()).append(System.lineSeparator());
        sb.append("--------------------------- TREE ------------------------------------").append(System.lineSeparator());
        sb.append(this.getRoot()).append(System.lineSeparator());

        return sb.toString();
    }
    
}
