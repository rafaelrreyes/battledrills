/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 * @author admin
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PositionRestParams {
    private String battleDrillName;
    private String owner;
    private String coordinateType;
    private int x;
    private int y;
    
    public String getBattleDrillName() {
        return this.battleDrillName;
    }
    
    public String getOwner() {
        return this.owner;
    }
    
    public String getCoordinateType() {
        return this.coordinateType;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Drill name: ").append(this.battleDrillName).append(System.lineSeparator());
        sb.append("Owner: ").append(this.owner).append(System.lineSeparator());
        sb.append("Coordinate Type: ").append(this.coordinateType).append(System.lineSeparator());
        sb.append("x: ").append(this.x).append(" , y: " ).append(this.y);
        return sb.toString();
    }
}
