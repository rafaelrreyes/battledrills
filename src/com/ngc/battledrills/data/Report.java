/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.data;

import com.ngc.battledrills.data.reports.ReportData;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.ngc.battledrills.util.ConvenienceUtils;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dustin
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Report {
    private String drillId = "";
    private int numTasks = 0;
    private int numCompletedTasks = 0;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime startTime = null;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime endTime = null;

    // Map of taskId to all info (description, statuses)
    private Map<String, ReportData> data = new HashMap<>();

    public Report() {}

    public Report(String drillId, int numTasks) {
        this.drillId = drillId;
        this.numTasks = numTasks;
    }

    public String getDrillId() {
        return drillId;
    }

    public void setDrillId(String drillId) {
        this.drillId = drillId;
    }

    public Map<String, ReportData> getData() {
        return data;
    }

    public int getNumTasks() {
        return numTasks;
    }

    public int getNumCompletedTasks() {
        return numCompletedTasks;
    }

    public void setNumCompletedTasks(int numCompletedTasks) {
        this.numCompletedTasks = numCompletedTasks;
    }

    public void setNumTasks(int numTasks) {
        this.numTasks = numTasks;
    }

    public void setData(Map<String, ReportData> data) {
        this.data = data;
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

    @JsonIgnore
    public void deleteReportData(String taskId) {
        if (this.data.containsKey(taskId)) {
            this.data.remove(taskId);
        }
    }
    
    @JsonIgnore
    public void setReportData(String taskId, ReportData data) {
        this.data.put(taskId, data);
    }

    @JsonIgnore
    public ReportData getReportData(String taskId) {
        return data.get(taskId);
    }

    @JsonIgnore
    public void addStatus(String taskId, Status status) {
        getReportData(taskId).getStatuses().add(status);
    }

    @JsonIgnore
    public void setTaskEndTime(String taskId, LocalDateTime endTime) {
        getReportData(taskId).setEndTime(endTime);
    }

    @JsonIgnore
    public long getStartTimeSeconds() {
        return ConvenienceUtils.localDateTimeToSeconds(startTime);
    }

    @JsonIgnore
    public long getEndTimeSeconds() {
        return ConvenienceUtils.localDateTimeToSeconds(endTime);
    }

    @JsonIgnore
    public void setAllTaskEndTimes(LocalDateTime endTime) {
        for (ReportData value : data.values()) {
            value.setLastStatus(endTime);
        }
    }

    @JsonIgnore
    public Duration getDrillDuration() {
        if (endTime == null) {
            return null;
        } else {
            return Duration.between(startTime, endTime);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Drill ID: ").append(this.getDrillId()).append(System.lineSeparator());
        sb.append("Num Tasks: ").append(this.getNumTasks()).append(System.lineSeparator());
        sb.append("Num Completed Tasks: ").append(this.getNumCompletedTasks()).append(System.lineSeparator());
        sb.append("Start Time: ").append(this.getStartTime()).append(System.lineSeparator());
        sb.append("End Time: ").append(this.getEndTime()).append(System.lineSeparator());
        sb.append("Data: ").append(this.getData()).append(System.lineSeparator());

        return sb.toString();
    }
}
