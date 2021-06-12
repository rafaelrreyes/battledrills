/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.comms;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ngc.battledrills.websocket.BattleDrillsWebsocketService;
import com.ngc.battledrills.util.JsonUtils;

/**
 *
 * @author admin
 */
public class Notify {
    public Notify() {}
    
    public static void sendNotification(Notification notification) {
        try {
//            BattleDrillsWebsocketService.broadcast(DEFAULT_JSON_WRITER.writeValueAsString(notification));
            BattleDrillsWebsocketService.broadcast(JsonUtils.writeValue(notification));
        } catch (JsonProcessingException e ) {
            System.err.println("Error when attempting to broadcast websocket");
        }
    }
    
    public static void sendNotificationToSessionId(Notification notification) {
        try {
            BattleDrillsWebsocketService.broadcastToSessionId(notification.getUser(), JsonUtils.writeValue(notification));
        } catch (JsonProcessingException e ) {
            System.err.println("Error when attempting to broadcast websocket to specific sessionId");
        }
    }
    
    public static void sendNotificationToAllExcluding(Notification notification) {
        try {
            BattleDrillsWebsocketService.broadcastToAllExcluding(notification.getUser(), JsonUtils.writeValue(notification));
        } catch (JsonProcessingException e ) {
            System.err.println("Error when attempting to broadcast websocket to all except one sessionId");
        }
    }
}
 