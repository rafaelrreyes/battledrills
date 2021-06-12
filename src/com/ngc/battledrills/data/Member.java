/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.data;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author rafael
 */
public class Member {
    
    private int id;
    private String name;
    
    public Member() {}
    
    public Member(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    @JsonProperty("id")
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    @JsonProperty("name")
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
}
