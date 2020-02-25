/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.template;

import com.ngc.battledrills.data.Node;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author admin
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_EMPTY)
public class BattleDrillTemplate {
    private String type = "";
    private String permission = "";
    
    @JsonManagedReference
    protected Node root;
    
    public BattleDrillTemplate(){}
    
    public void setType(String type)
    {
        this.type = type;
    }
    
    public String getType()
    {
        return this.type;
    }
    
    public String getName()
    {
        return this.type;
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
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(this.type).append(System.lineSeparator());
        sb.append("Permission: ").append(this.permission).append(System.lineSeparator());
        sb.append("--------------------------- TREE ------------------------------------").append(System.lineSeparator());
        sb.append(this.root).append(System.lineSeparator());

        return sb.toString();
    }
}
