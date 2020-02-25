/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ngc.battledrills.data.User;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderedDrillsRestParams {
    private User user; // person requesting the reorder
    private ArrayList<String> orderedActiveDrills = new ArrayList<>();
    private ArrayList<String> orderedCompletedDrills = new ArrayList<>();
    
    @JsonProperty("user")
    public User getUser() {
        return user;
    }

    public ArrayList<String> getOrderedActiveDrills() {
        return orderedActiveDrills;
    }
    
    public ArrayList<String> getOrderedCompletedDrills() {
        return orderedCompletedDrills;
    }
        
    @JsonProperty("user")
    public void setUser(User user) {
        this.user = user;
    }
            
    public void setOrderedActiveDrills(ArrayList<String> orderedActiveDrills) {
        this.orderedActiveDrills = orderedActiveDrills;
    }
    
    public void setOrderedCompletedDrills(ArrayList<String> orderedCompletedDrills) {
        this.orderedCompletedDrills = orderedCompletedDrills;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User: ").append(user).append(System.lineSeparator());
        sb.append("Ordered Active Drill Names: ").append(orderedActiveDrills).append(System.lineSeparator());
        sb.append("Ordered Completed Drill Names: ").append(orderedCompletedDrills).append(System.lineSeparator());
           
        return sb.toString();
    }
}
