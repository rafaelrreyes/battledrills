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
 * @param <T>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class TaskXY<T> {
    private T x;
    private T y;
    private String owner = "";
    private String description = "";

    public TaskXY(T x, T y, String owner, String description) {
        this.x = x;
        this.y = y;
        this.owner = owner;
        this.description = description;
    }

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Owner: ").append(this.getOwner()).append(System.lineSeparator());
        sb.append("Description: ").append(this.getDescription()).append(System.lineSeparator());
        sb.append("X: ").append(this.getX()).append(System.lineSeparator());
        sb.append("Y: ").append(this.getY()).append(System.lineSeparator());

        return sb.toString();
    }
}
