/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.template;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ngc.battledrills.data.Node;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ngc.battledrills.data.Task;
import java.util.ArrayList;
import java.util.List;
import com.ngc.battledrills.util.JsonUtils;
import java.security.InvalidParameterException;

/**
 *
 * @author admin
 */
@JsonFilter(JsonUtils.DefinedFilters.BATTLE_DRILL_TEMPLATE_FILTER)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_EMPTY)
public class BattleDrillTemplate {
    private String type = "";
    private String permission = "";
    private String name = "";
    private String id = "";
    private List<Integer> participants = new ArrayList<>();
    
    @JsonManagedReference
    protected Node root;
    
    public BattleDrillTemplate(){}
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getType() {
        return this.type;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getId() {
        return this.id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }

    @JsonProperty("data")
    public void setRoot(Node root)
    {
        this.root = root;
    }
    
    public Node getRoot()
    {
        return this.root;
    }
    
    public void setPermission(String permission)
    {
        this.permission = permission;
    }
    
    public String getPermission()
    {
        return this.permission;
    }
    
    @JsonIgnore
    public List<Task> getTasksByRoleId(int roleId) {
        if (roleId < 1) {
            throw new InvalidParameterException("Unable to get tasks by role ID - role ID parameter must be defined in DB");
        }
        
        Node root = this.getRoot();
        return null == root ? null : ( root.getRoleId() == roleId ? root.getTasks() : root.getTasksByRoleId(roleId));
    }
        
    @JsonProperty("participants")
    public void setParticipants(List<Integer> participants) {
        this.participants = participants;
    }
    
    public List<Integer> getParticipants() {
        return this.participants;
    }
    
    @JsonIgnore
    public void emptyParticipants() {
        this.participants.clear();
    }
    
    @JsonIgnore
    public void addParticipant(int participantId) {
        this.participants.add(participantId);
    }
    
    @JsonIgnore
    public void deleteParticipant(int participantId) {
        for (int i = 0; i < this.participants.size(); i++) {
            if (this.participants.get(i) == participantId) {
                this.participants.remove(i);
            }
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(this.type).append(System.lineSeparator());
        sb.append("Permission: ").append(this.permission).append(System.lineSeparator());
        sb.append("--------------------------- TREE ------------------------------------").append(System.lineSeparator());
        sb.append(this.root).append(System.lineSeparator());

        return sb.toString();
    }
}
