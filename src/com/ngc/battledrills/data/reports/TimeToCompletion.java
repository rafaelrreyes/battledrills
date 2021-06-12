/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.data.reports;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ngc.battledrills.data.BattleDrill;
import com.ngc.battledrills.manage.BattleDrillManager;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dustin
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeToCompletion {
    public String drillId = "";
    public String drillName = "";
    public String totalTime = ""; // total time to complete drill in HH:mm:ss format
    public List<TaskXY> dataPoints = new ArrayList<>();

    public TimeToCompletion(String drillId, String totalTime) {
        this.drillId = drillId;
        this.totalTime = totalTime;
    }

    public String getDrillId() {
        return drillId;
    }

    public void setDrillId(String drillId) {
        this.drillId = drillId;
    }
    
    public String getDrillName() {
        BattleDrillManager mgr = BattleDrillManager.getInstance();
        BattleDrill bd = mgr.getById(this.drillId);
        return bd.getName();
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
        sb.append("Drill ID: ").append(this.getDrillId()).append(System.lineSeparator());
        sb.append("Total Time: ").append(this.getTotalTime()).append(System.lineSeparator());
        sb.append("Data Points: ").append(this.getDataPoints()).append(System.lineSeparator());

        return sb.toString();
    }
}
