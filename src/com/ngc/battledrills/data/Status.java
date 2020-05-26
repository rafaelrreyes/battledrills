/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.data;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import java.time.LocalDateTime;
import java.time.ZoneId;
import org.apache.commons.lang3.StringEscapeUtils;
import com.ngc.battledrills.util.JsonUtils;
/**
 *
 * @author Rafa
 */

@JsonFilter(JsonUtils.DefinedFilters.STATUS_FILTER)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Status {
    private String status = "";
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime startTime = null;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime endTime = null;
    
    public Status() {
        this.status = StatusTypes.PENDING;
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
    
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
    
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
    
    public LocalDateTime getStartTime() {
        return startTime;
    }
    
    public LocalDateTime getEndTime() {
        return endTime;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Status: ").append(status).append(System.lineSeparator());
        sb.append("Start time: ").append(startTime).append(System.lineSeparator());
        sb.append("End time: ").append(endTime).append(System.lineSeparator());
        return sb.toString();
    }
    
    public static final class StatusTypes {
        public static final String PENDING = "pending";
        public static final String IN_PROGRESS = "in-progress";
        public static final String BLOCKED = "blocked";
        public static final String COMPLETED = "completed";
        
        private StatusTypes() {
            throw new AssertionError();
        }
    }
}
