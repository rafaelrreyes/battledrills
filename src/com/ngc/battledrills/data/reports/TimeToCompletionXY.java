/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.data.reports;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author dustin
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeToCompletionXY extends TaskXY {
    public TimeToCompletionXY(String x, String y, int roleId, String description) {
        super(x, y, roleId, description);
    }
}
