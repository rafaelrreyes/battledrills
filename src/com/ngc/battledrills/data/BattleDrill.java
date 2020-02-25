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
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.ngc.battledrills.comms.Notification;
import com.ngc.battledrills.comms.Notify;
import com.ngc.battledrills.comms.NotifyManager;
import com.ngc.battledrills.comms.NotifyTypes;
import com.ngc.battledrills.manage.AttachmentManager;
import com.ngc.battledrills.template.BattleDrillTemplate;
import java.security.InvalidParameterException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author admin
 */
@JsonInclude(Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BattleDrill extends BattleDrillTemplate{
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
        return (root.getOwner().equalsIgnoreCase(owner))?root.getTasks():root.getTasksByOwner(owner);
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
    public boolean deleteTask(String taskId)
    {
        if(StringUtils.isBlank(taskId))
        {
            throw new InvalidParameterException("Unable to delete task - taskId parameter cannot be blank");
        }
        Node root = this.getRoot();
        return root.deleteTask(taskId);
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
        Node root = this.getRoot();
        Node targetNode;
        
        // case for root owner, in most cases CO or Convoy Commander
        if (root.getOwner().equalsIgnoreCase(owner)){
            targetNode = root;
        } else {
            targetNode = root.getSubtreeByOwner((owner));
        }
        
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
    }
    
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
    
    @JsonProperty("location")
    public Map<String, String> getLocation() {
        return this.location;
    }
    
    public void start()
    {
       startTime = LocalDateTime.now();
    }
    
    public void stop()
    {
        endTime = LocalDateTime.now();
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
