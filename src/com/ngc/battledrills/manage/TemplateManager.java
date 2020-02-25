/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.manage;

import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ngc.battledrills.data.BattleDrill;
import com.ngc.battledrills.BattleDrillsConfig;
import com.ngc.battledrills.template.BattleDrillTemplate;
import static com.ngc.battledrills.BattleDrillsConfig.MAPPER;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author admin
 */
public class TemplateManager {
    private static final Map<String, BattleDrillTemplate> templates = new HashMap<>();
    
    private TemplateManager()
    {
        loadAll();
    }
    
    public static TemplateManager getInstance() {
        return TemplateManagerFactory.instance;
    } 
    
    private static class TemplateManagerFactory {
        // Lazy initialize the TemplateManager singleton
        private static final TemplateManager instance = new TemplateManager();
    }
    
    public BattleDrillTemplate getByType(String type)
    {
        return templates.get(type);
    }
    
    public List<String> getTypes()
    {
        return new ArrayList(templates.keySet());
    }
    
    private void loadAll()
    {
        try
        {
            File dir = new File(BattleDrillsConfig.getTemplateDir());
            File[] files = dir.listFiles((d, name) -> name.endsWith(".json"));
            
            for(File file : files)
            {
                String fileContents = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
                BattleDrillTemplate template = loadFromJson(fileContents);
                templates.put(template.getType(), template);
            }
        }
        catch(IOException i)
        {
            System.err.println("DIANA unable to load template: " + i);
        }
    }
    
    private BattleDrillTemplate loadFromJson(String json) throws IOException
    {
        InjectableValues inject = new InjectableValues.Std().addValue(boolean.class, false);
            
        BattleDrillTemplate template = new ObjectMapper().reader(inject)
        .forType(BattleDrillTemplate.class)
        .readValue(json);
        
        return template;
    }
}