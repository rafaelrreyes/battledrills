/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import org.apache.commons.lang3.StringEscapeUtils;

/**
 *
 * @author Rafa
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Status {
    
    private String status = "";
    private LocalDateTime startTime = null;
    private LocalDateTime endTime = null;
    
    public Status() {
        this.status = StatusTypes.PENDING;
        this.startTime = LocalDateTime.now();
    }
    
    public static boolean isDefinedStatus(String status) {
        switch (status) {
            case StatusTypes.PENDING:
            case StatusTypes.IN_PROGRESS:
            case StatusTypes.BLOCKED:
            case StatusTypes.COMPLETED: 
                return true;
            default:
                return false;
        }
    }
    
    public void setStatus(String status) {
        if (isDefinedStatus(status)) {
            this.status = StringEscapeUtils.escapeJava(status);
        }
        
    }
    
    public String getStatus() {
        return this.status;
    }
    
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
    
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
    
    @JsonProperty("start")
    public long getStartTimeMillis() {
        if (this.startTime == null) {
            return -1;
        }
        
        ZoneId zoneId = ZoneId.systemDefault();
        long epoch = this.startTime.atZone(zoneId).toEpochSecond();
        return epoch;
    }
    
    @JsonProperty("end")
    public long getEndTimeMillis() {
        if (this.endTime == null) {
            return -1;
        }
        
        ZoneId zoneId = ZoneId.systemDefault();
        long epoch = this.endTime.atZone(zoneId).toEpochSecond();
        return epoch;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Status: ").append(status).append(System.lineSeparator());
        sb.append("Start time: ").append(startTime).append(System.lineSeparator());
        sb.append("End time: ").append(endTime).append(System.lineSeparator());
        return sb.toString();
    }
    
    public final class StatusTypes {
        public static final String PENDING = "pending";
        public static final String IN_PROGRESS = "in-progress";
        public static final String BLOCKED = "blocked";
        public static final String COMPLETED = "completed";
        
        private StatusTypes() {
            throw new AssertionError();
        }
    }
}
