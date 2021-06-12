/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.rest;

import com.ngc.battledrills.restparams.ReportsRestParams;
import com.fasterxml.jackson.core.JsonProcessingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import com.ngc.battledrills.data.reports.ReportTypes;
import com.ngc.battledrills.data.reports.TaskStatusSummary;
import com.ngc.battledrills.data.reports.TimeToCompletion;
import com.ngc.battledrills.manage.ReportsManager;
import com.ngc.battledrills.util.JsonUtils;
import java.util.List;
import javax.ws.rs.core.Response;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author dustin
 */
@Path("/reports")
public class ReportsService {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getReports(ReportsRestParams params) {
        if (StringUtils.isBlank(params.getDrillId())
                || StringUtils.isBlank((params.getReportType()))) {
            throw new WebApplicationException("Parameters must contain a battle drill ID and report type", Response.Status.BAD_REQUEST);
        }
        ReportsManager rMgr = ReportsManager.getInstance();
        try {
            String response = "";
            if (params.getReportType().equalsIgnoreCase(ReportTypes.TimeToCompletion)) {
                List<TimeToCompletion> ttcDatasets = rMgr.getTimeToCompletion(params.getDrillId(), params.getCompareDrillIds());
                if (ttcDatasets == null) {
                    return Response.status(400, "Error: Report not found for " + params.getDrillId()).build();
                }
                response = JsonUtils.writeValue(ttcDatasets);
            } else if (params.getReportType().equalsIgnoreCase(ReportTypes.TaskStatusSummary)) {
                TaskStatusSummary tss = rMgr.getTaskStatusSummary(params.getDrillId());
                response = JsonUtils.writeValue(tss);
            }

            return Response.ok(response).build();
        } catch (JsonProcessingException jpe) {
            System.err.println("Unable process JSON for reports: " + jpe);
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
