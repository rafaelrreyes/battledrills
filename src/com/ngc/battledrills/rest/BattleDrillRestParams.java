/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.ngc.battledrills.data.User;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author admin
 */
@JsonInclude(Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BattleDrillRestParams {
    private String type = ""; 
    private String name = "";
    private User user;
    private Map<String, String> location = new HashMap<>();

    private BattleDrillRestParams(){}
    
    public String getType()
    {
        return type;
    }
    
    public String getName()
    {
        return name;
    }
    
    @JsonProperty("user")
    public User getUser()
    {
        return user;
    }
    
    public Map<String, String> getLocation() {
        return location;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    
    @JsonProperty("user")
    public void setUser(User user)
    {
        this.user = user;
    }
    
    public void setLocation(Map<String, String> location) {
        this.location = location;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(type).append(System.lineSeparator());
        sb.append("Name: ").append(name).append(System.lineSeparator());
        sb.append("User: ").append(user).append(System.lineSeparator());
        sb.append("Location: (").append("Latitude: ").append(location.get("latitude"))
          .append(", Longitude: ").append(location.get("longitude")).append(")").append(System.lineSeparator());
           
        return sb.toString();
    }
}
