/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.comms;

import com.ngc.battledrills.data.ChatMessage;
import java.security.InvalidParameterException;

/**
 *
 * @author admin
 */
public class ChatNotification extends Notification {
    private ChatMessage message;
    
    public ChatNotification(String operationType, ChatMessage payload) {
        // User for chat notifications isn't used because we aren't doing toasts with them as of right now, 
        // but is needed for abstract class constructor so we pass null
        super(NotifyTypes.OBJECT_TYPES.CHAT, operationType, null);
        System.out.println(payload.getReceiverId() + " " + payload.getSenderId()+ " " + payload.getMessage());
        if (!payload.isValid()) {
            throw new InvalidParameterException("Unable to send chat notification - message parameters cannot be blank");
        }
        
        this.message = payload;
    }
    
    public ChatMessage getMessage() {
        return this.message;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Sender ID: ").append(getMessage().getSenderId()).append(System.lineSeparator());
        sb.append("Receiver ID: ").append(getMessage().getReceiverId()).append(System.lineSeparator());
        sb.append("Message: ").append(getMessage().getMessage()).append(System.lineSeparator());
        sb.append("Object type: ").append(getObjectType()).append(System.lineSeparator());
        sb.append("Operation type: ").append(getOperationType()).append(System.lineSeparator());
        
        return sb.toString();
    }
}
