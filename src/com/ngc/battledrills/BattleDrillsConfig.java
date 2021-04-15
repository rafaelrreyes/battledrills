/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 *
 * @author admin
 */
public class BattleDrillsConfig {
    public static boolean devMode = true;
    private static final String CONTEXT = "../webapps/battledrills/";
    private static final String DEV_CONTEXT  = "C:/h/C2PCWebApp/webapps/battledrills/";
    private static final String TEMPLATE_DIR = "secure/data/battle_drill_templates/";
    private static final String CUSTOM_TEMPLATE_DIR = "secure/data/custom_templates/";
    private static final String FILE_DIR = "secure/data/files/";
    private static final String BATTLE_DRILLS_DIR = "secure/data/battle_drills/";
    private static final String DATA_DIR = "secure/data/";
    private static final String ROLES_FILE = "secure/data/roles.json";
    private static final String BATTLE_DRILLS_REPORTS_DIR = "secure/data/battle_drills/reports/";
    private static final String IED_DISCOVERED_TEMPLATE = "ied_discovered.json";
    private static final String CONFIG_FILE = "conf.json";
    private static final String ASSASSINATION_IRAQI_OFFICIAL_TEMPLATE = "assassination_of_iraqi_government_official.json";
    
    public static final String getConfigFileLocation()
    {
        String runningContext = (devMode)?DEV_CONTEXT:CONTEXT;
        return runningContext + DATA_DIR + CONFIG_FILE;
    }

    public static final String getReportsDir() {
        String runningContext = (devMode) ? DEV_CONTEXT : CONTEXT;
        return runningContext + BATTLE_DRILLS_REPORTS_DIR;
    }

    public static final String getFileDir() {
        String runningContext = (devMode)?DEV_CONTEXT:CONTEXT;
        return runningContext + FILE_DIR;
    }
    
    public static final String getTemplateDir() {
        String runningContext = (devMode)?DEV_CONTEXT:CONTEXT;
        return runningContext + TEMPLATE_DIR;
    }
    
    public static final String getCustomTemplateDir() {
        String runningContext = (devMode) ? DEV_CONTEXT : CONTEXT;
        return runningContext + CUSTOM_TEMPLATE_DIR;
    }
    
    public static final String getActiveBattleDrillsDir()
    {
        String runningContext = (devMode)?DEV_CONTEXT:CONTEXT;
        return runningContext + BATTLE_DRILLS_DIR;
    }
    
    public static final String getRolesFile() {
        String runningContext = devMode ? DEV_CONTEXT : CONTEXT;
        return runningContext + ROLES_FILE;
    }
    
    public static final String getCompletedBattleDrillsDir() {
        String baseDir = getActiveBattleDrillsDir();
        return baseDir + "/completed";
    }
    
    public static final String getOrderedBattleDrillsDir() {
        String baseDir = getActiveBattleDrillsDir();
        return baseDir + "/ordered";
    }
    
    public static final String getIedDiscoveredTemplate() {
        String templateDir = getTemplateDir();
        return templateDir + IED_DISCOVERED_TEMPLATE;
    }
    
    public static final String getAssassinationIraqiOfficialTemplate() {
        String templateDir = getTemplateDir();
        return templateDir + ASSASSINATION_IRAQI_OFFICIAL_TEMPLATE;
    }
}
