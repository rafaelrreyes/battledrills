/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import java.time.LocalDateTime;
import java.time.ZoneId;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author admin
 */

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatMessage {
    
    private int senderId = 0;
    private int receiverId = 0;
    private String message = "";
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime timestamp = null;
    
    public ChatMessage() {
        this.timestamp = LocalDateTime.now();
    }
    
    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }
    
    public int getSenderId() {
        return this.senderId;
    }
    
    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }
    
    public int getReceiverId() {
        return this.receiverId;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public void setTimestamp(LocalDateTime timestamp)    {
        this.timestamp = timestamp;
    }
    
    public LocalDateTime getTimestamp()    {
        return this.timestamp;
    }
    
    public boolean isValid() {
        return this.senderId != 0 && this.receiverId != 0 && null != timestamp;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Sender ID: ").append(this.getSenderId()).append(System.lineSeparator());
        sb.append("Receiver ID: ").append(this.getReceiverId()).append(System.lineSeparator());
        sb.append("Message: ").append(this.getMessage()).append(System.lineSeparator());
        
        return sb.toString();
    }
}
