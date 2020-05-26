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
public class TaskStatusSummary {
    private List<TaskXY> data = new ArrayList<>();

    public TaskStatusSummary() {

    }

    public List<TaskXY> getData() {
        return data;
    }

    public void setData(List<TaskXY> data) {
        this.data = data;
    }

    @JsonIgnore
    public void addDataEntry(TaskXY dataPoint) {
        this.data.add(dataPoint);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Data: ").append(this.getData()).append(System.lineSeparator());

        return sb.toString();
    }
}
