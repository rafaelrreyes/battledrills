/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.comms;

import com.ngc.battledrills.data.User;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author admin
 */
public class TaskNotification extends Notification {
    private Map<String, String> taskData = new HashMap<>();
    private String noteId = "";
    private String drillName = "";
    private String edittedKey = "";
    
    /**
     * This is when a task gets a status change.
     * @param operationType
     * @param edittedKey
     * @param user
     * @param drillName
     * @param taskData
     * @param noteId
     */
    public TaskNotification(String operationType, String edittedKey, User user, String drillName, Map<String, String> taskData, String noteId) {
        super(NotifyTypes.OBJECT_TYPES.TASK, operationType, user);
        if(taskData.isEmpty() || StringUtils.isBlank(operationType) || StringUtils.isBlank(edittedKey))
        {
            throw new InvalidParameterException("Unable to create TaskNotification - taskId, edittedKey, and operationType parameters cannot be blank");
        }
        this.edittedKey = edittedKey;
        this.taskData.putAll(taskData);
        this.noteId = noteId;
        this.drillName = drillName;
    }
    
    public Map<String, String> getTaskData() {
        return this.taskData;
    }
    
    public String getNoteId() {
        return this.noteId;
    }
    
    public String getDrillName() {
        return this.drillName;
    }
    
    public String getEdittedKey() {
        return this.edittedKey;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User: ").append(getUser()).append(System.lineSeparator());
        sb.append("Task Data: ").append(getTaskData()).append(System.lineSeparator());
        sb.append("NoteId: ").append(getNoteId()).append(System.lineSeparator());
        sb.append("Drill Name: ").append(getDrillName()).append(System.lineSeparator());
        sb.append("Object Type: ").append(getObjectType()).append(System.lineSeparator());
        sb.append("Operation Type: ").append(getOperationType()).append(System.lineSeparator());
        sb.append("Editted Key: ").append(getEdittedKey()).append(System.lineSeparator());

        return sb.toString();
    }
    
}
