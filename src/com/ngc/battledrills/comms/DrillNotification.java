/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.comms;

import com.ngc.battledrills.data.User;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author admin
 */
public class DrillNotification extends Notification {
    private String drillName = "";    
    private Map<String, ArrayList<String>> orderedBattleDrills = new HashMap<>();
    
    /**
     * This is when a drill is created
     * Since each DrillNotification operation is a different constructor, the constructor handles giving the operationType.
     * @param operationType
     * @param user
     * @param payload
     */
    public DrillNotification(String operationType, User user, String payload) {
        super(NotifyTypes.OBJECT_TYPES.DRILL, operationType, user);
        if (StringUtils.isBlank(payload) || user.isEmpty()) {
            throw new InvalidParameterException("Unable to create DrillNotification - drillName and user parameters cannot be blank");
        }
        
        this.drillName = payload;
    }
    
    /**
     * This is when drills are reordered
     * Since each DrillNotification operation is a different constructor, the constructor handles giving the operationType.
     * @param operationType
     * @param user
     * @param payload
     */
    public DrillNotification(String operationType, User user, Map<String, ArrayList<String>> payload) {
        super(NotifyTypes.OBJECT_TYPES.DRILL, operationType, user);
        if (payload.isEmpty() || user.isEmpty()) {
            throw new InvalidParameterException("Unable to create DrillNotification - payload and user parameters cannot be blank");
        }
        this.orderedBattleDrills = payload;
    }

    /**
     * This is when a drill is deleted
     * Since each DrillNotification operation is a different constructor, the constructor handles giving the operationType.
     * @param operationType
     * @param user
     * @param payload
     * @param drillName
     */
    public DrillNotification(String operationType, User user, Map<String, ArrayList<String>> payload, String drillName) {
        super(NotifyTypes.OBJECT_TYPES.DRILL, operationType, user);
        if (payload.isEmpty() || StringUtils.isBlank(drillName) || user.isEmpty()) {
            throw new InvalidParameterException("Unable to create DrillNotification - payload, drillName, and user parameters cannot be blank");
        }
        this.drillName = drillName;
        this.orderedBattleDrills = payload;
    }
    
    public String getDrillName() {
        return this.drillName;
    }
    
    public Map<String, ArrayList<String>> getOrderedBattleDrills() {
        return this.orderedBattleDrills;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User: ").append(getUser()).append(System.lineSeparator());
        sb.append("Drill Name: ").append(getDrillName()).append(System.lineSeparator());
        sb.append("Ordered Battle Drills: ").append(getOrderedBattleDrills()).append(System.lineSeparator());
        sb.append("Object Type: ").append(getObjectType()).append(System.lineSeparator());
        sb.append("Operation type: ").append(getOperationType()).append(System.lineSeparator());
        
        return sb.toString();
    }
}
