/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.comms;

import com.ngc.battledrills.data.User;
import static com.ngc.battledrills.manage.AttachmentManager.AttachmentTypes;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author rafae
 */
public class AttachmentNotification extends Notification {
    private String attachmentName = "";
    private String attachmentType = "";
    private String drillName = "";
    private Map<String, String> taskData = new HashMap<>();
    
    /**
     * When an attachment is uploaded, or deleted, creates a basic attachment notification object.
     * @param operationType
     * @param user
     * @param drillName 
     * @param taskData 
     * @param attachmentType 
     * @param attachmentName 
     */
    public AttachmentNotification(String operationType, User user, String drillName, Map<String, String> taskData, String attachmentType, String attachmentName) {
        super(NotifyTypes.OBJECT_TYPES.ATTACHMENT, operationType, user);
    
        if (StringUtils.isBlank(drillName)
                || StringUtils.isBlank(attachmentName) 
                || user.isEmpty() 
                || StringUtils.isBlank(attachmentType)
            ) {
            throw new InvalidParameterException("Unable to upload attachment - attachment name, attachment type, drill name, and user cannot be blank.");
        }
        
        if (null != taskData) {
            this.taskData.putAll(taskData);
        }
        this.attachmentType = attachmentType;
        this.attachmentName = attachmentName;
        this.drillName = drillName;
    }
    
    public Map<String, String> getTaskData() {
        return this.taskData;
    }
    
    public String getDrillName() {
        return this.drillName;
    }
    
    public String getAttachmentName() {
        return this.attachmentName;
    }
    
    public String getAttachmentType() {
        return this.attachmentType;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User: ").append(getUser()).append(System.lineSeparator());
        sb.append("ID: ").append(getAttachmentType().equals(AttachmentTypes.BATTLE_DRILL) ? getDrillName() : getTaskData().get("taskId")).append(System.lineSeparator());
        sb.append("Attachment name: ").append(getAttachmentName()).append(System.lineSeparator());
        sb.append("Attachment type: ").append(getAttachmentType()).append(System.lineSeparator());
        
        return sb.toString();
    }
}
