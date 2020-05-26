/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.util;

import com.ngc.battledrills.data.reports.TaskXY;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Comparator;

/**
 *
 * @author dustin
 */
public class CustomComparators {
    /**
     * Comparing X values to sort TreeSet correctly.
     *
     * X values in the form HH:mm:ss
     */
    public static Comparator<TaskXY> TimeToCompletion() {
        return (TaskXY a, TaskXY b) -> {
            LocalTime aLocalTime = LocalTime.parse(a.getX().toString());
            LocalTime bLocalTime = LocalTime.parse(b.getX().toString());
            return Math.toIntExact(Duration.between(bLocalTime, aLocalTime).getSeconds());
        };
    }

    /**
     * Comparing X values to sort TreeSet correctly.
     * Simple compare to sort by role alphabetically
     *
     * X values are role labels here (WO, CO, etc.)
     */
    public static Comparator<TaskXY> TaskStatusSummary() {
        return (TaskXY a, TaskXY b) -> {
            String roleA = a.getX().toString();
            String roleB = b.getX().toString();
            return String.CASE_INSENSITIVE_ORDER.compare(roleA, roleB);
        };
    }
}
