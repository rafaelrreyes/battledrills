/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.json;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import java.util.ArrayList;

/**
 *
 * @author rafae
 */
public class JsonFilterProvider {
    
    private final ArrayList<Filter> filters = new ArrayList<>();
    public JsonFilterProvider() {}
    
    /**
     * Container for filter id and props
     */
    private class Filter {
        String[] properties;
        String id;
        
        public Filter(String filterId, String[] properties) {
            this.id = filterId;
            this.properties = properties;
        }
        
        public String getId() {
            return this.id;
        }
        
        public String[] getProperties() {
            return this.properties;
        }
        
        public void setId(String id ) {
            this.id = id;
        }
        public void setProperties(String[] properties) {
            this.properties = properties;
        }
    }
    
    /**
     * Adds a filter by the given filterId, and properties.
     * @param filterId
     * @param properties 
     */
    public void addFilter(String filterId, String[] properties) {
        Filter filter = new Filter(filterId, properties);
        this.filters.add(filter);
    }
    
    /**
     * Gets all the filters added to the current provider and returns a SimpleFilterProperty object.
     * @return SimpleFilterProvider
     */
    public SimpleFilterProvider getAllFilters() {
        SimpleFilterProvider targetFilters = new SimpleFilterProvider();
        this.filters.forEach((filter) -> {
            targetFilters.addFilter(filter.getId(), SimpleBeanPropertyFilter.filterOutAllExcept(filter.getProperties()));
        });
        return targetFilters;
    }
}
