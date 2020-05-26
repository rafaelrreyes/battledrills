/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.data.reports;

import java.util.List;

/**
 *
 * @author dustin
 */
public class TaskStatusSummaryXY extends TaskXY {
    public TaskStatusSummaryXY(String x, List<Long> y, String owner, String description) {
        super(x, y, owner, description);
    }
}
