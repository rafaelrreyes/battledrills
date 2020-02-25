/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.comms;

import com.ngc.battledrills.data.User;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 *
 * @author admin
 */
public abstract class Notification {
    private String objectType = "";
    private String operationType = "";
    private User user;
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
    
    public long getTimestamp() {
        if(this.timestamp == null)
        {
            return -1;
        }
        ZoneId zoneId = ZoneId.systemDefault(); // or: ZoneId.of("Europe/Oslo");
        long epoch = this.timestamp.atZone(zoneId).toEpochSecond();
        return epoch;
    }
}
