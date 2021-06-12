/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.restparams;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.ngc.battledrills.data.Note;
import java.security.InvalidParameterException;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author admin
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class NoteRestParams {
    @JsonUnwrapped
    private Note note;
    private String taskId;
    
    // Needed for JSON deserialization
    private NoteRestParams(){}
    
    public NoteRestParams(Note note, String taskId)
    {
        Objects.requireNonNull(note);
        if(StringUtils.isBlank(taskId))
        {
            throw new InvalidParameterException("Unable to construct new note - taskId param cannot be blank");
        }
        
        this.note = note;
        this.taskId = taskId;
    }
    
    public Note getNote()
    {
        return note;
    }
    
    public String getTaskId()
    {
        return taskId;
    }
}
