/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.comms;

import com.ngc.battledrills.data.Note;
import com.ngc.battledrills.data.User;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author admin
 */
public class NoteNotification extends Notification {
    private String drillName = "";
    private Note note;
    private Map<String, String> taskData = new HashMap<>();
    
    public NoteNotification(String operationType, User user, String drillName, Map<String, String> taskData, Note payload) {
        super(NotifyTypes.OBJECT_TYPES.NOTE, operationType, user);
        this.drillName = drillName;
        this.note = payload;
        this.taskData.putAll(taskData);
    }
    
    public String getDrillName() {
        return this.drillName;
    }
    
    public Map<String, String> getTaskData() {
        return this.taskData;
    }
    
    public Note getNote() {
        return this.note;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User: ").append(getUser()).append(System.lineSeparator());
        sb.append("Drill Name: ").append(getDrillName()).append(System.lineSeparator());
        sb.append("Task Data: ").append(getTaskData()).append(System.lineSeparator());
        sb.append("Note: ").append(getNote()).append(System.lineSeparator());
        sb.append("Object Type: ").append(getObjectType()).append(System.lineSeparator());
        sb.append("Operation Type: ").append(getOperationType()).append(System.lineSeparator());

        return sb.toString();
    }
}
