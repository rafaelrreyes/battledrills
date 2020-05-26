/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.manage;

import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ngc.battledrills.BattleDrillsConfig;
import com.ngc.battledrills.data.Report;
import com.ngc.battledrills.data.reports.ReportData;
import com.ngc.battledrills.data.reports.TaskStatusSummary;
import com.ngc.battledrills.data.reports.TaskStatusSummaryXY;
import com.ngc.battledrills.data.reports.TimeToCompletionXY;
import com.ngc.battledrills.data.reports.TimeToCompletion;
import com.ngc.battledrills.data.reports.TaskXY;
import com.ngc.battledrills.util.ConvenienceUtils;
import com.ngc.battledrills.util.CustomComparators;
import com.ngc.battledrills.util.JacksonInjectableValues;
import com.ngc.battledrills.util.JsonUtils;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author dustin
 */
public class ReportsManager {
    private static ReportsManager instance;

    private final Map<String, Report> allReports = new HashMap<>();

    private ReportsManager() {
        loadAllReports();
    }

    public static ReportsManager getInstance() {
        if (instance == null) {
            instance = new ReportsManager();
        }
        return instance;
    }

    private void loadAllReports() {
        try {
            File dir = new File(BattleDrillsConfig.getReportsDir());
            File[] files = dir.listFiles((d, name) -> name.endsWith(".json"));

            for (File file : files) {
                String fileContents = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
                Report report = loadFromJson(fileContents);
                allReports.put(report.getDrillName(), report);
            }
        } catch (IOException i) {
            System.err.println("DUSTIN unable to load template: " + i);
        }
    }

    private Report loadFromJson(String json) throws IOException {
        // Injectable value tells the battle drill whether this is a brand new drill being created, or if it's just being loaded from a JSON file
        // This is needed because brand new battle drills have sub-components that need to generate their own unique IDs upon creation the first time (ie: task IDs)
        InjectableValues.Std inject = new InjectableValues.Std();
        inject.addValue(JacksonInjectableValues.NEW_TASK, false);
        Report report = new ObjectMapper().reader(inject).forType(Report.class).readValue(json);

        return report;
    }

    public Report createInitialReport(String drillName, int numTasks) {
        Report initReport = new Report(drillName, numTasks);
        saveReport(initReport);
        allReports.put(drillName, initReport);
        return initReport;
    }

    public void saveReport(Report report) {
        try {
            String contents = JsonUtils.writeValue(report);
            String fullname = getFullFilename(report.getDrillName());
            File file = FileUtils.getFile(fullname);
            FileUtils.writeStringToFile(file, contents, StandardCharsets.UTF_8);
        } catch (Exception e) {
            System.err.println("Unable to save new report " + report.getDrillName() + ", error is: " + e);
        }
    }

    public void addReport(String drillName, Report report) {
        allReports.put(drillName, report);
    }

    public Report getReport(String drillName) {
        return allReports.get(drillName);
    }

    public List<TimeToCompletion> getTimeToCompletion(String drillName, List<String> compareDrillNames) {
        compareDrillNames.add(0, drillName);
        List<TimeToCompletion> ttcDatasets = new ArrayList<>();
        for (int i = 0; i < compareDrillNames.size(); i++) {
            String name = compareDrillNames.get(i);
            Report drillReport = getReport(name);
            if (drillReport == null) {
                System.out.println("REPORT DOESN'T EXIST");
                return null;
            }
            Duration totalTime = drillReport.getDrillDuration();
            String totalTimeString = "N/A";
            // incomplete drill, endTime is null, leave string as N/A
            if (totalTime != null) {
                totalTimeString = ConvenienceUtils.durationToHHmmss(totalTime);
            }

            int numTasks = drillReport.getNumTasks();
            TimeToCompletion ttc = new TimeToCompletion(name, totalTimeString);
            TimeToCompletionXY initZero = new TimeToCompletionXY("00:00:00", "0", "", "");
            ttc.addDataPoint(initZero);
            for (ReportData data : drillReport.getData().values()) {
                Duration x = data.getTaskDuration();
                if (x != null) {
                    String xTimeString = ConvenienceUtils.durationToHHmmss(x);
                    TimeToCompletionXY xy = new TimeToCompletionXY(xTimeString, "", data.getOwner(), data.getDescription());
                    ttc.addDataPoint(xy);
                }
            }

            ttc.getDataPoints().sort(CustomComparators.TimeToCompletion());

            double num = 0;
            for (TaskXY point : ttc.getDataPoints()) {
                double percentComp = (num * 100) / numTasks;
                BigDecimal roundedPercent = new BigDecimal(Double.toString(percentComp));
                roundedPercent = roundedPercent.setScale(2, RoundingMode.HALF_UP);
                point.setY(String.valueOf(roundedPercent.doubleValue()));
                num++;
            }
            ttcDatasets.add(ttc);
        }

        return ttcDatasets;
    }

    public TaskStatusSummary getTaskStatusSummary(String drillName) {
        Report drillReport = getReport(drillName);
        if (drillReport == null) {
            System.out.println("REPORT DOESN'T EXIST");
        } else {
            TaskStatusSummary tss = new TaskStatusSummary();
            for (ReportData data : drillReport.getData().values()) {
                List<Long> times = data.getTimeInStatuses();
                TaskStatusSummaryXY tssXY = new TaskStatusSummaryXY(data.getOwner(), times, data.getOwner(), data.getDescription());
                tss.addDataEntry(tssXY);
            }
            tss.getData().sort(CustomComparators.TaskStatusSummary());
            return tss;
        }
        return null;
    }

    public String getFullFilename(String reportName) {
        String fullname = BattleDrillsConfig.getReportsDir();
        return fullname + "/" + reportName + ".json";
    }
}
