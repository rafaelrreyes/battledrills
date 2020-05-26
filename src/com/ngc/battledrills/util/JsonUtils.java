/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.ngc.battledrills.data.BattleDrill;
import com.ngc.battledrills.json.JsonFilterProvider;
 
/**
 *
 * @author rafae
 */
public class JsonUtils {

    public static class DefaultDataView {};
    public static final ObjectMapper MAPPER;
    public static final ObjectWriter DEFAULT_JSON_WRITER;
    
    static {
        MAPPER = new ObjectMapper();
        MAPPER.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        DEFAULT_JSON_WRITER = MAPPER.writerWithView(DefaultDataView.class);
    }
 
    public static final class DefinedFilters {
        public static final String BATTLE_DRILL_TEMPLATE_FILTER = "battleDrillTemplateFilter";
        public static final String BATTLE_DRILL_FILTER = "battleDrillFilter";
        public static final String NODE_FILTER = "nodeFilter";
        public static final String TASK_FILTER = "taskFilter";
        public static final String NOTE_FILTER = "noteFilter";
        public static final String STATUS_FILTER = "statusFilter";
        public static final String ATTACHMENT_FILTER = "attachmentFilter";
    }
    
    /**
     * Serializes the object with the given single filter.
     * @param obj
     * @param filter
     * @return
     * @throws JsonProcessingException 
     */
    public static String writeValueWithFilter(Object obj, FilterProvider filter) throws JsonProcessingException {
        return MAPPER.writer(filter).writeValueAsString(obj);
    }
    
    /**
     * Serializes the object with the given variable filters.
     * @param obj
     * @param filterProvider
     * @return
     * @throws JsonProcessingException 
     */
    public static String writeValueWithFilters(Object obj, SimpleFilterProvider filterProvider) throws JsonProcessingException {
        return MAPPER.writer(filterProvider).writeValueAsString(obj);
    }
    
    /**
     * Serializes the object with no filtered properties. This should be used for all cases unless filtering is required.
     * @param obj
     * @return
     * @throws JsonProcessingException 
     */
    public static String writeValue(Object obj) throws JsonProcessingException {
        // we need to trick the writer into using empty filters so it doesnt error out when seeing @JsonFilter annotations
        FilterProvider allFilters = new SimpleFilterProvider()
            .addFilter(DefinedFilters.BATTLE_DRILL_TEMPLATE_FILTER, SimpleBeanPropertyFilter.serializeAllExcept())
            .addFilter(DefinedFilters.BATTLE_DRILL_FILTER, SimpleBeanPropertyFilter.serializeAllExcept())
            .addFilter(DefinedFilters.NODE_FILTER, SimpleBeanPropertyFilter.serializeAllExcept())
            .addFilter(DefinedFilters.TASK_FILTER, SimpleBeanPropertyFilter.serializeAllExcept())
            .addFilter(DefinedFilters.NOTE_FILTER, SimpleBeanPropertyFilter.serializeAllExcept())
            .addFilter(DefinedFilters.STATUS_FILTER, SimpleBeanPropertyFilter.serializeAllExcept())
            .addFilter(DefinedFilters.ATTACHMENT_FILTER, SimpleBeanPropertyFilter.serializeAllExcept());
       
        return MAPPER.writer(allFilters).writeValueAsString(obj);
    }
}
