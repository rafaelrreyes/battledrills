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
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.ngc.battledrills.manage.RolesManager;
import java.security.InvalidParameterException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import org.apache.commons.lang3.StringUtils;
import com.ngc.battledrills.util.JsonUtils;

/**
 *
 * @author rafae
 */
@JsonFilter(JsonUtils.DefinedFilters.ATTACHMENT_FILTER)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Attachment {
    private String name = "";
    private String type = "";
    private String uploader = "";
    private int uploaderId = 0;
    private LocalDateTime lastModified = null;
    
    public Attachment() {
        this.lastModified = LocalDateTime.now();
    };
   
    public Attachment(String name, String type, String uploader) {
        
        // check for all default required params
        if (StringUtils.isBlank(name) || StringUtils.isBlank(type) || StringUtils.isBlank(uploader)) {
            throw new InvalidParameterException("Attachments must include a name, type, and uploader.");
        }
        
        this.lastModified = LocalDateTime.now();
        this.name = name;
        this.type = type;
        this.uploader = uploader;
    }
    
    public String getFilename() {
        return this.name;
    }
    
    public void setFilename(String name) {
        this.name = name;
    }
    
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public int getUploaderId() {
        return this.uploaderId;
    }
    
    public void setUploaderId(int uploaderId) {
        this.uploaderId = uploaderId;
    }
    
    public String getUploader() {
        RolesManager mgr = RolesManager.getInstance();
        return mgr.getRolenameById(this.uploaderId);
    }
    
    public void setUploader(String uploader) {
        this.uploader = uploader;
    }
    
    @JsonIgnore
    public LocalDateTime getLastModified() {
        return this.lastModified;
    }
    
    // TODO is this really in seconds or milliseconds?
    public long getLastModifiedEpoch() {
        if (lastModified == null) {
            return -1;
        }
        
        ZoneId zoneId = ZoneId.systemDefault();
        return this.lastModified.atZone(zoneId).toEpochSecond();
    }
    
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Attachment name: ").append(this.name).append(System.lineSeparator());
        sb.append("Attachment type: ").append(this.type).append(System.lineSeparator());
        sb.append("Attachment uploader: ").append(this.uploader).append(System.lineSeparator());
        sb.append("Attachment uploader ID: ").append(this.uploaderId).append(System.lineSeparator());
        sb.append("Last Modified: ").append(this.lastModified).append(System.lineSeparator());
        return sb.toString();
    }
}
