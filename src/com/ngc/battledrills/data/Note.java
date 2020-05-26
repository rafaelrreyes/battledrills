/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.data;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import java.security.InvalidParameterException;
import java.time.LocalDateTime;
import java.util.UUID;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;
import com.ngc.battledrills.util.JsonUtils;

/**
 *
 * @author admin
 */
@JsonFilter(JsonUtils.DefinedFilters.NOTE_FILTER)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Note {
    private String noteText = "";
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime timestamp = null;
    private User user; // role for right now
    private String id = "";
    private String type = "";
    private String autoType = "";
    
    public static class NoteTypes {
        public static final String USER_GENERATED = "user";
        public static final String AUTO_GENERATED = "auto";
    }
    
    public static class AutoGenTypes {
        public static final String STATUS_CHANGE = "status";
        public static final String ATTACHMENT_UPLOAD = "attachment_upload";
        public static final String ATTACHMENT_DELETE = "attachment_delete";
        public static final String TASK_DESCRIPTION_EDIT ="task_description_edit";
    }
    
    // Used for JSON deserialization - not intended for external use
    private Note()
    {
        this.id = UUID.randomUUID().toString();
        this.timestamp = LocalDateTime.now();
        this.type = NoteTypes.USER_GENERATED;
    }
    
    public Note(User user, String text)
    {
        if(user.isEmpty())
        {
            throw new InvalidParameterException("Unable to create note - user parameter cannot be blank");
        }
        this.id = UUID.randomUUID().toString();
        this.timestamp = LocalDateTime.now();
        
        // Allowing blanks here for future capabilities that might allow users to add files and other attachments that are not text notes
        if(null == text)
        {
            text = "";
        }
        
        this.type = NoteTypes.USER_GENERATED;
        this.noteText = StringEscapeUtils.escapeJava(text);
        this.user = user;
    }
    
    public void setNoteText(String noteText)
    {
        // Allowing blanks here for future capabilities that might allow users to add files and other attachments that are not text notes
        if(null == noteText)
        {
            noteText = "";
        }
        
        this.noteText = StringEscapeUtils.escapeJava(noteText);
    }
    
    public String getNoteText()
    {
        return noteText;
    }
    
    public String getId()
    {
        return id;
    }
    
    // Needed for loading from stored JSON data - not intended to change after creation
    private void setId(String id)
    {
        if(StringUtils.isBlank(id) == false)
        {
            this.id = id;
        }
    }
    
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getAutoType() {
        return this.autoType;
    }
    public void setAutoType(String autoType) {
        this.autoType = autoType;
    }
    
    public void setTimestamp(LocalDateTime timestamp)    {
        this.timestamp = timestamp;
    }
    
    public LocalDateTime getTimestamp()    {
        return timestamp;
    }
    
    public void setUser(User user)
    {
        if(user.isEmpty())
        {
            throw new InvalidParameterException("Unable to set user - user parameter cannot be blank");
        }
        this.user = user;
    }
    
    public User getUser()
    {
        return user;
    }
    
   @Override
   public String toString()
   {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id).append(System.lineSeparator());
        sb.append("Timestamp: ").append(timestamp).append(System.lineSeparator());
        sb.append("User: ").append(user).append(System.lineSeparator());
        sb.append("Type: ").append(type).append(System.lineSeparator());
        sb.append("Text: ").append(noteText).append(System.lineSeparator());
        sb.append("Autogen Type: " ).append(autoType).append(System.lineSeparator());

        return sb.toString();
   }
}

