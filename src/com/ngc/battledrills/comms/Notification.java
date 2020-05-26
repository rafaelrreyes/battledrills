/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.comms;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.ngc.battledrills.data.User;
import java.time.LocalDateTime;

/**
 *
 * @author admin
 */
public abstract class Notification {
    private String objectType = "";
    private String operationType = "";
    private User user;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private final LocalDateTime timestamp;
    
    public Notification(String objectType, String operationType, User user) {
        this.objectType = objectType;
        this.operationType = operationType;
        this.timestamp = LocalDateTime.now();
        this.user = user;
    }
    
    public String getObjectType() {
        return this.objectType;
    }
    
    public String getOperationType() {
        return this.operationType;
    }
    
    public User getUser() { 
        return this.user;
    }
    
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
