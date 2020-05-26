/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.comms;

import com.ngc.battledrills.data.ChatMessage;
import com.ngc.battledrills.data.Note;
import com.ngc.battledrills.data.User;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author admin
 */
public class NotifyManager {
    
    private static NotifyManager instance = null;
    
    private NotifyManager() { }
    
    public static NotifyManager getInstance() {
        if (instance == null) {
            instance = new NotifyManager();
        }
        
        return instance;
    }
    
    /**
     * Factory helper to create a drill notification based on operationType.
     * This is when a drill is created or started
     *
     * @param operationType
     * @param user
     * @param payload
     * @return DrillNotification
     */
    public static Notification createDrillNotification(String operationType, User user, String payload) {
        if (!isValidNotification(operationType)) {
            return null;
        }
        
        return new DrillNotification(operationType, user, payload);
    }
    
    /**
     * Factory helper to create a drill notification based on operationType.
     * This is when drills are reordered
     * @param operationType
     * @param user
     * @param payload 
     * @return DrillNotification
     */
    public static Notification createDrillNotification(String operationType, User user, Map<String, ArrayList<String>> payload) {
        if (!isValidNotification(operationType)) {
            return null;
        }
        
        return new DrillNotification(operationType, user, payload);
    }
    
    /**
     * Factory helper to create a notification based on operationType.
     * This is when drills are deleted
     * @param operationType
     * @param user
     * @param payload
     * @param drillName
     * @return DrillNotification
     */
    public static Notification createDrillNotification(String operationType, User user, Map<String, ArrayList<String>> payload, String drillName) {
        if (!isValidNotification(operationType)) {
            return null;
        }
                
        return new DrillNotification(operationType, user, payload, drillName);
    }
    
    /**
     * Factory helper to create a notification based on operationType.
     * This is when tasks receive an update, ie. status update/change
     * @param operationType
     * @param edittedKey
     * @param user
     * @param drillName
     * @param taskData
     * @param noteId
     * @return TaskNotification
     */
    public static Notification createTaskNotification(String operationType, String edittedKey, User user, String drillName, Map<String, String> taskData, String noteId) {
        if (!isValidNotification(operationType)) {
            return null;
        }
        
        return new TaskNotification(operationType, edittedKey, user, drillName, taskData, noteId);
    }
    
    public static Notification createTaskNotification(String operationType, User user, Map<String, String> taskData, String drillName) {
        if (!isValidNotification(operationType)) {
            return null;
        }
        
        return new TaskNotification(operationType, user, drillName, taskData);
    }
    
    /**
     * Wrapper for creating a chat notification based on operationType.
     * @param operationType
     * @param payload
     * @return ChatNotification
     */
    public static Notification createChatNotification(String operationType, ChatMessage payload) {
        if (!isValidNotification(operationType)) {
            return null;
        }
        return new ChatNotification(operationType, payload);
    }
    
    /**
     * Wrapper for creating a note notification.
     * @param operationType
     * @param user
     * @param drillName
     * @param taskData
     * @param payload
     * @return NoteNotification
     */
    public static Notification createNoteNotification(String operationType, User user, String drillName, Map<String, String> taskData, Note payload) {
        if (!isValidNotification(operationType)) {
            return null;
        }
        
        return new NoteNotification(operationType, user, drillName, taskData, payload);
    }
    
    /**
     * Wrapper for creating an attachment notification.
     * @param operationType
     * @param user
     * @param id
     * @param attachmentType
     * @param attachmentName
     * @return 
     */
    public static Notification createAttachmentNotification(String operationType, User user, String drillName, Map<String, String> taskData, String attachmentType, String attachmentName) {
        if (!isValidNotification(operationType)) {
            return null;
        }
        
        return new AttachmentNotification(operationType, user, drillName, taskData, attachmentType, attachmentName);
    }
    
    /**
     * Wrapper for creating a web socket notification.
     * @param operationType
     * @param user
     * @param data
     * @return WebsocketNotification
     */
    public static Notification createWebsocketNotification(String operationType, User user, Map<String, String> data) {
        if (!isValidNotification(operationType)) {
            return null;
        }
        
        return new WebsocketNotification(operationType, user, data);
    }
    
    /**
     * Wrapper for creating a web socket notification.
     * @param operationType
     * @param notification
     * @return ToastNotification
     */
    public static Notification createToastNotification(String operationType, Notification notification) {
        if (!isValidNotification(operationType)) {
            return null;
        }
        
        return new ToastNotification(operationType, notification);
    }
    
    /**
     * Checks to see if the parameter type exists in the defined set.
     * @param operationType
     * @return boolean
     */
    public static boolean isValidNotification(String operationType) { 
        boolean isOperationValid = false;
        
        for (int i = 0; i < NotifyTypes.VALID_OPERATION_TYPES.size(); i++) {
            if (NotifyTypes.VALID_OPERATION_TYPES.get(i).equals(operationType.toLowerCase())) {
                isOperationValid = true;
                break;
            }
        }
        
        return isOperationValid;
    }
}
