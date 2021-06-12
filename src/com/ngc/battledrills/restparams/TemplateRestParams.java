/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.restparams;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ngc.battledrills.data.User;
import com.ngc.battledrills.template.BattleDrillTemplate;
import java.util.ArrayList;

/**
 *
 * @author rafae
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TemplateRestParams {
    private String type;
    private String drillId;
    private User user;
    private ArrayList<String> templatesToDelete;
    private String template;
    private String taskDescription;

    public TemplateRestParams() {}
    
    @JsonProperty("template")
    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }
    
    
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    @JsonProperty("drillId")
    public String getDrillId() {
        return this.drillId;
    }
    
    public void setDrillId(String drillId) {
        this.drillId = drillId;
    }
    
    @JsonProperty("templates")
    public void setTemplatesToDelete(ArrayList<String> templatesToDelete) {
        this.templatesToDelete = templatesToDelete;
    }
    
    public ArrayList<String> getTemplatesToDelete() {
        return this.templatesToDelete;
    }

    @JsonProperty("user")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    @JsonProperty("taskDescription")
    public String getTaskDescription() {
        return this.taskDescription;
    }
    
    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }
    
    
}
