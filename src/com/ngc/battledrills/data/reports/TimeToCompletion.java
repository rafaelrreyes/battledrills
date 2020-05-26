/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.data.reports;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dustin
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeToCompletion {
    public String drillName = "";
    public String totalTime = ""; // total time to complete drill in HH:mm:ss format
    public List<TaskXY> dataPoints = new ArrayList<>();

    public TimeToCompletion(String drillName, String totalTime) {
        this.drillName = drillName;
        this.totalTime = totalTime;
    }

    public String getDrillName() {
        return drillName;
    }

    public void setDrillName(String drillName) {
        this.drillName = drillName;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    public List<TaskXY> getDataPoints() {
        return dataPoints;
    }

    public void setDataPoints(List<TaskXY> dataPoints) {
        this.dataPoints = dataPoints;
    }

    @JsonIgnore
    public void addDataPoint(TaskXY dataPoint) {
        this.dataPoints.add(dataPoint);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Drill Name: ").append(this.getDrillName()).append(System.lineSeparator());
        sb.append("Total Time: ").append(this.getTotalTime()).append(System.lineSeparator());
        sb.append("Data Points: ").append(this.getDataPoints()).append(System.lineSeparator());

        return sb.toString();
    }
}
