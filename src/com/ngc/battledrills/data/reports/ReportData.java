/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.data.reports;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.ngc.battledrills.data.Status;
import com.ngc.battledrills.data.Status.StatusTypes;
import com.ngc.battledrills.manage.RolesManager;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * POJO to hold task data for reports
 *
 * @author dustin
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReportData {
    private int roleId = 0;
    private String roleName = "";
    private String description = ""; // task description
    private List<Status> statuses = new ArrayList<>();

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime startTime = null;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime endTime = null;

    public ReportData() { }

    public ReportData(int roleId, String description, List<Status> status, LocalDateTime startTime) {
        this.roleId = roleId;
        this.description = description;
        this.statuses = status;
        this.startTime = startTime;
    }
    
    public int getRoleId() {
        return this.roleId;
    }
    
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
    
    public String getRoleName() {
        RolesManager mgr = RolesManager.getInstance();
        return mgr.getRolenameById(this.roleId);
    }
    
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Status> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<Status> statuses) {
        this.statuses = statuses;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    @JsonIgnore
    public Duration getTaskDuration() {
        if (endTime == null) {
            return null;
        } else {
            return Duration.between(startTime, endTime);
        }
    }

    @JsonIgnore
    public void setLastStatus(LocalDateTime endTime) {
        // don't know if we care to set overall task endtime here or no so won't for now
        // this also changes the endtime in the Task status (currentStatus) because they share the same status object
        statuses.get(statuses.size() - 1).setEndTime(endTime);
    }

    @JsonIgnore
    public List<Long> getTimeInStatuses() {
        // array of ordered time in each status state [pending, in progress, blocked]
        List<Long> allStatusTimes = new ArrayList<>(Arrays.asList(new Long(0), new Long(0), new Long(0)));
        for (Status status : this.statuses) {
            if (status.getStatus().equalsIgnoreCase(StatusTypes.COMPLETED)) {
                continue;
            }
            long diff = 0;
            if (status.getEndTime() == null) {
                diff = Duration.between(status.getStartTime(), LocalDateTime.now()).getSeconds();
            } else {
                diff = Duration.between(status.getStartTime(), status.getEndTime()).getSeconds();
            }
            if (status.getStatus().equalsIgnoreCase(StatusTypes.PENDING)) {
                allStatusTimes.set(0, Long.sum(allStatusTimes.get(0), diff));
            } else if (status.getStatus().equalsIgnoreCase(StatusTypes.IN_PROGRESS)) {
                allStatusTimes.set(1, Long.sum(allStatusTimes.get(1), diff));
            } else if (status.getStatus().equalsIgnoreCase(StatusTypes.BLOCKED)) {
                allStatusTimes.set(2, Long.sum(allStatusTimes.get(2), diff));
            }
        }
        return allStatusTimes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Role ID: ").append(this.getRoleId()).append(System.lineSeparator());
        sb.append("Description: ").append(this.getDescription()).append(System.lineSeparator());
        sb.append("Statuses: ").append(this.getStatuses()).append(System.lineSeparator());
        sb.append("Start Time: ").append(this.getStartTime()).append(System.lineSeparator());
        sb.append("End Time: ").append(this.getEndTime()).append(System.lineSeparator());

        return sb.toString();
    }
}
