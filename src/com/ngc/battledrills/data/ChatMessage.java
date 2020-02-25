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
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
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
    
    private String sender = "";
    private String target = "";
    private String message = "";
    private LocalDateTime timestamp = null;
    
    public ChatMessage() {
        this.timestamp = LocalDateTime.now();
    }
    
    public void setSender(String sender) {
        this.sender = sender;
    }
    
    public String getSender() {
        return this.sender;
    }
    
    public void setTarget(String target) {
        this.target = target;
    }
    
    public String getTarget() {
        return this.target;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    public void setTimestamp(LocalDateTime timestamp)
    {
        this.timestamp = timestamp;
    }
    
    @JsonIgnore // Only for internal use - getTimestampMillis is used for communicating with the front end application
    public LocalDateTime getTimestamp()
    {
        return this.timestamp;
    }
    
    public long getTimestampMillis()
    {
        if(this.timestamp == null)
        {
            return -1;
        }
        ZoneId zoneId = ZoneId.systemDefault(); // or: ZoneId.of("Europe/Oslo");
        long epoch = this.timestamp.atZone(zoneId).toEpochSecond();
        return epoch;
    }
    
    public boolean isValid() {
        return !(StringUtils.isBlank(sender) || StringUtils.isBlank(target) || StringUtils.isBlank(message) || timestamp == null);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Sender: ").append(this.getSender()).append(System.lineSeparator());
        sb.append("Target: ").append(this.getTarget()).append(System.lineSeparator());
        sb.append("Message: ").append(this.getMessage()).append(System.lineSeparator());
        
        return sb.toString();
    }
}
