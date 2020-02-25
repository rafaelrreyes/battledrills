/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.comms;

import com.ngc.battledrills.data.User;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author admin
 */
public class WebsocketNotification extends Notification {
    private Map<String, String> data = new HashMap<>();
    
    public WebsocketNotification(String operationType, User user, Map<String, String> data) {
        super(NotifyTypes.OBJECT_TYPES.WEBSOCKET, operationType, user);
        if (data != null) {
            this.data.putAll(data);
        }
    }
    
    public Map<String, String> getData() {
        return this.data;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User: ").append(getUser()).append(System.lineSeparator());
        sb.append("Data: ").append(getData()).append(System.lineSeparator());
        sb.append("Object Type: ").append(getObjectType()).append(System.lineSeparator());
        sb.append("Operation Type: ").append(getOperationType()).append(System.lineSeparator());

        return sb.toString();
    }
}
