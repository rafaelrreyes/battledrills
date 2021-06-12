/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.restparams;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

/**
 *
 * @author dustin
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReportsRestParams {
    private String drillId;
    private String taskId;
    private String reportType;
    private List<String> compareDrillIds;

    public String getDrillId() {
        return this.drillId;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public String getReportType() {
        return this.reportType;
    }

    public List<String> getCompareDrillIds() {
        return this.compareDrillIds;
    }

    public void setDrillId(String drillId) {
        this.drillId = drillId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public void setCompareDrillIds(List<String> compareDrillIds) {
        this.compareDrillIds = compareDrillIds;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Drill ID: ").append(this.drillId).append(System.lineSeparator());
        sb.append("Task Id: ").append(this.taskId).append(System.lineSeparator());
        sb.append("Report Type: ").append(this.reportType).append(System.lineSeparator());
        sb.append("Compare Drill IDs: ").append(this.compareDrillIds).append(System.lineSeparator());
        return sb.toString();
    }
}
