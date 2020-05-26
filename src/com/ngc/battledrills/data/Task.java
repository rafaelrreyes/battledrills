/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.data;

import com.ngc.battledrills.data.reports.ReportData;
import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.ngc.battledrills.comms.Notification;
import com.ngc.battledrills.comms.Notify;
import com.ngc.battledrills.comms.NotifyManager;
import com.ngc.battledrills.comms.NotifyTypes;
import com.ngc.battledrills.exception.ItemNotFoundException;
import com.ngc.battledrills.manage.BattleDrillManager;
import com.ngc.battledrills.util.JsonUtils;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.apache.commons.lang3.StringUtils;
import static com.ngc.battledrills.manage.AttachmentManager.AttachmentTypes;
import com.ngc.battledrills.manage.ReportsManager;
import com.ngc.battledrills.util.JacksonInjectableValues;

/**
 *
 * @author admin
 */
@JsonFilter(JsonUtils.DefinedFilters.TASK_FILTER)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Task {
    private String id = "";
    
    private String description = "";
    private LocalDateTime startTime = null;
    private LocalDateTime endTime = null;
    private List<Note> notes = null;
    private Status currentStatus = null;
    private List<Attachment> attachments = new ArrayList<>();
    
    public static class EditableKeys {
        public static final String DESCRIPTION = "description";
        public static final String STATUS = "status";
    }

    @JacksonInject(JacksonInjectableValues.NEW_TASK)
    protected boolean newTask = false; // When the battle drill is new, we need to generate new IDs for each task.  Otherwise, just load the IDs from the stored JSON
    
    @JsonBackReference
    public Node parent; // Stores a reference to the parent node.  Useful for traversing backwards to find the root battle drill name.
    
    public Task()
    {
        this.id = UUID.randomUUID().toString();
        this.currentStatus = new Status();
    }
    
    @JsonProperty("attachments")
    public List<Attachment> getAttachments() {
        return this.attachments;
    }
    
    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }
    
    @JsonIgnore
    public boolean addAttachment(Attachment attachment, User user) throws ItemNotFoundException {
        this.attachments.add(attachment);
        // create a new Note and add to the notes of this task
        Note statusNote = new Note(user, attachment.getFilename());
        statusNote.setType(Note.NoteTypes.AUTO_GENERATED);
        statusNote.setAutoType(Note.AutoGenTypes.ATTACHMENT_UPLOAD);
        addNote(statusNote);
        
        // send attachment upload notification
        Notification attachmentNotification = 
                NotifyManager.createAttachmentNotification(NotifyTypes.OPERATION_TYPES.CREATE, user, getBattleDrillName(), getTaskData(), AttachmentTypes.TASK, attachment.getFilename());
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
     * Deletes an attachment from current task then returns true if successful.
     * @param fileName
     * @return 
     */
    @JsonIgnore
    public boolean deleteAttachment(String fileName, User user) throws ItemNotFoundException {
        boolean isDeleted = false;
        
        // search and destroy
        for (int i = 0; i < this.attachments.size(); i++) {
            if (this.attachments.get(i).getFilename().equals(fileName)) {
                this.attachments.remove(i);
                Note statusNote = new Note(user, fileName);
                statusNote.setType(Note.NoteTypes.AUTO_GENERATED);
                statusNote.setAutoType(Note.AutoGenTypes.ATTACHMENT_DELETE);
                addNote(statusNote);
                // send attachment delete notification
                Notification attachmentNotification = 
                        NotifyManager.createAttachmentNotification(NotifyTypes.OPERATION_TYPES.DELETE, user, getBattleDrillName(), getTaskData(), AttachmentTypes.TASK, fileName);
                Notify.sendNotificationToAllExcluding(attachmentNotification);
                Notify.sendNotification(NotifyManager.createToastNotification(NotifyTypes.OPERATION_TYPES.DELETE, attachmentNotification));
                isDeleted = true;
                
                break;
            }
        }
        return isDeleted;
    }
    
    @JsonIgnore
    public String getBattleDrillName()
    {
        return (null != parent)?parent.getBattleDrillName():"";
    }
    
    public String getOwner()
    {
        return (null != parent)?parent.getOwner():"";
    }
    
    /**
     * Changes the current tasks status while moving the old status to previousStatus container.
     * @param user
     * @param status
     * @throws ItemNotFoundException
     * @return Task
     */
    public Task changeCurrentStatus(User user, String status) throws ItemNotFoundException {
        BattleDrillManager bdMgr = BattleDrillManager.getInstance();
        String bdName = getBattleDrillName();
        LocalDateTime currDateTime = LocalDateTime.now();
        // start battle drill if task status is changed and the battle drill hasn't been started
        if (this.currentStatus.getStatus().equalsIgnoreCase(Status.StatusTypes.PENDING)
                && !bdMgr.isBattleDrillStarted(bdName)) {
            currDateTime = bdMgr.startBattleDrill(bdName, user);
            Notification drillNotification = NotifyManager.createDrillNotification(NotifyTypes.OPERATION_TYPES.START, user, bdName);
            // send specifically to user who changed status since startBattleDrill sends to everyone but user who changed
            Notify.sendNotificationToSessionId(drillNotification);
        }

        // if status was completed, but changed back to a non completed state, end time must be set back to null, to return -1
        if (!status.equalsIgnoreCase(Status.StatusTypes.COMPLETED)) {
            this.setEndTime(null);
        }
        
        // if the new state of the task is Completed, then the task is finished and can be given an end time
        if (status.equalsIgnoreCase(Status.StatusTypes.COMPLETED)) {
            this.setEndTime(LocalDateTime.now());
        }
        // changing currentStatus to newStatus update and adding old to array for history
        // set newStatus start time to now
        // then set endtime of current status to now
        // add current status to the battledrill's report
        // then set currentStatus to new incoming status
        this.currentStatus.setEndTime(currDateTime);

        Status newStatus = new Status();
        newStatus.setStatus(status);
        newStatus.setStartTime(currDateTime);

        ReportsManager rMgr = ReportsManager.getInstance();
        String drillName = getBattleDrillName();
        int numCompleted = rMgr.getReport(drillName).getNumCompletedTasks();

        // new state is COMPLETED, so set the task's endTime in reportData
        if (newStatus.getStatus().equalsIgnoreCase(Status.StatusTypes.COMPLETED)) {
            rMgr.getReport(drillName).setTaskEndTime(this.id, newStatus.getStartTime());
            rMgr.getReport(drillName).setNumCompletedTasks(++numCompleted);
        } else if (this.currentStatus.getStatus().equalsIgnoreCase(Status.StatusTypes.COMPLETED)) {
            // set the overall task end time back to null when task is changed from COMPLETED to something else
            rMgr.getReport(drillName).setTaskEndTime(this.id, null);
            rMgr.getReport(drillName).setNumCompletedTasks(--numCompleted);
        }

        rMgr.getReport(drillName).addStatus(this.id, newStatus);
        rMgr.saveReport(rMgr.getReport(drillName));

        setCurrentStatus(newStatus);

        // create a new Note and add to the notes of this task
        String automatedNoteStatusText = newStatus.getStatus().toUpperCase();
        Note statusNote = new Note(user, automatedNoteStatusText);
        statusNote.setType(Note.NoteTypes.AUTO_GENERATED);
        statusNote.setAutoType(Note.AutoGenTypes.STATUS_CHANGE);
        addNote(statusNote);
        
        // send task edit notification
        Notification taskNotification = NotifyManager.createTaskNotification(NotifyTypes.OPERATION_TYPES.EDIT, Task.EditableKeys.STATUS, user, getBattleDrillName(), getTaskData(), statusNote.getId());
        Notify.sendNotificationToAllExcluding(taskNotification);
        Notify.sendNotification(NotifyManager.createToastNotification(NotifyTypes.OPERATION_TYPES.CREATE, taskNotification));

        // final task was set to COMPLETE
        if (numCompleted == rMgr.getReport(drillName).getNumTasks()) {
            bdMgr.stopBattleDrill(drillName, user);
            Notification drillNotification = NotifyManager.createDrillNotification(NotifyTypes.OPERATION_TYPES.STOP, user, bdName);
            // send specifically to user who changed status since stopBattleDrill sends to everyone but user who changed
            Notify.sendNotificationToSessionId(drillNotification);
        }

        return this;
    }
    
    @JsonProperty("currentStatus")
    private void setCurrentStatus(Status status) {
            this.currentStatus = status;
    }
    
    public Status getCurrentStatus() {
        return this.currentStatus;
    }
    
    // Only used for JSON serialization
    private void setNotes(List<Note> notes)
    {
        if(null != notes)
        {
            this.notes = notes;
        }
    }
    
    public List<Note> getNotes()
    {
        return this.notes;
    }
    
    public void addNote(Note note) throws ItemNotFoundException
    {
        if(null == notes)
        {
            notes = new ArrayList<>();
        }
        
        System.out.println("DIANA adding note to task, battleDrillName is: " + getBattleDrillName());

        notes.add(note);
        if (!note.getType().equals(Note.NoteTypes.AUTO_GENERATED)) {
            Notification noteNotification = NotifyManager.createNoteNotification(NotifyTypes.OPERATION_TYPES.CREATE, note.getUser(), getBattleDrillName(), getTaskData(), note);
            Notify.sendNotificationToAllExcluding(noteNotification);
            Notify.sendNotification(NotifyManager.createToastNotification(NotifyTypes.OPERATION_TYPES.CREATE, noteNotification));
        }
        BattleDrillManager mgr = BattleDrillManager.getInstance();
        mgr.saveBattleDrill(getBattleDrillName(), false);
    }
    
    public Note getNote(String noteId)
    {
        for(Note note : notes)
        {
            if(note.getId().equals(noteId))
            {
                return note;
            }
        }
        return null;
    }
    
    public void deleteNote(String noteId)
    {
        Note temp = null;
        
        for(Note note : notes)
        {
            if(note.getId().equals(noteId))
            {
                temp = note;
                break;
            }
        }
        
        if(null != temp)
        {
            notes.remove(temp);
        }
    }
    
    public void updateNote(Note updatedNote)
    {
        for(Note note : notes)
        {
            if(note.getId().equals(updatedNote.getId()))
            {
                note.setNoteText(updatedNote.getNoteText());
                note.setTimestamp(LocalDateTime.now());
                
                Notification noteNotification = NotifyManager.createNoteNotification(NotifyTypes.OPERATION_TYPES.EDIT, note.getUser(), getBattleDrillName(), getTaskData(), note);
                Notify.sendNotificationToAllExcluding(noteNotification);
                Notify.sendNotification(NotifyManager.createToastNotification(NotifyTypes.OPERATION_TYPES.EDIT, noteNotification));
                break;
            }
        }
    }
    
    // Needed for loading from stored JSON data - not intended to change after creation
    @JsonProperty("taskId")
    private void setId(String id)
    {
        // Use the auto-generated ID from the constructor if this is a brand new task in a new battle drill.  
        // Otherwise, load the value that was serialized via JSON
        if (newTask) {
            return;
        }
        
        if(StringUtils.isBlank(id) == false)
        {
            this.id = id;
        }
    }
    
    public String getId()
    {
        return this.id;
    }
    
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    public String getDescription()
    {
        return this.description;
    }

    public Map<String, String> getTaskData() {
        Map<String, String> taskData  = new HashMap<>();
        taskData.put("taskId", getId());
        taskData.put("taskDescription", getDescription());
        taskData.put("currentStatus", getCurrentStatus().getStatus().toUpperCase());
        return taskData;
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

    @JsonProperty("start")
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
    
    @JsonProperty("end")
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
    
    @JsonIgnore
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
    
    public void start()
    {
       startTime = LocalDateTime.now();
    }
    
    //DIANA needs a stop type
    public void stop()
    {
        endTime = LocalDateTime.now();
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(this.id).append(System.lineSeparator());
        sb.append("Battle Drill Name: ").append(this.getBattleDrillName()).append(System.lineSeparator());
        sb.append("Description: ").append(this.description).append(System.lineSeparator());
        sb.append("Start time: ").append(this.getStartTimeMillis()).append(System.lineSeparator());
        sb.append("End Time: ").append(this.getEndTimeMillis()).append(System.lineSeparator());
        sb.append("Status: ").append(this.getCurrentStatus()).append(System.lineSeparator());
        sb.append("Duration: ").append(this.getElapsedTimeInSeconds()).append(System.lineSeparator());
        
        if(null != notes)
        {
            sb.append("Notes: ").append(System.lineSeparator());
            for(Note note : notes)
            {
                sb.append("--------------------------------------------------------------------").append(System.lineSeparator());
                sb.append(note).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
