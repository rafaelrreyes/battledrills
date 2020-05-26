/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.rest;

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
    private String drillName;
    private String taskId;
    private String reportType;
    private List<String> compareDrillNames;

    public String getDrillName() {
        return this.drillName;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public String getReportType() {
        return this.reportType;
    }

    public List<String> getCompareDrillNames() {
        return this.compareDrillNames;
    }

    public void setDrillName(String drillName) {
        this.drillName = drillName;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public void setCompareDrillNames(List<String> compareDrillNames) {
        this.compareDrillNames = compareDrillNames;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Drill name: ").append(this.drillName).append(System.lineSeparator());
        sb.append("Task Id: ").append(this.taskId).append(System.lineSeparator());
        sb.append("Report Type: ").append(this.reportType).append(System.lineSeparator());
        sb.append("Compare Drill Names: ").append(this.compareDrillNames).append(System.lineSeparator());
        return sb.toString();
    }
}
