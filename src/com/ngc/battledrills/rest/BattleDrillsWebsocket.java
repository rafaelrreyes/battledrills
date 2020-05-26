/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.rest;

import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ngc.battledrills.comms.Notify;
import com.ngc.battledrills.comms.NotifyManager;
import com.ngc.battledrills.comms.NotifyTypes;
import com.ngc.battledrills.data.ChatMessage;
import com.ngc.battledrills.data.User;
import com.ngc.battledrills.util.JacksonInjectableValues;
import java.util.HashMap;
import java.util.Map;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author admin
 */
@ServerEndpoint(value="/ws")
public class BattleDrillsWebsocket {
  
    @OnOpen
    public void onOpen(Session session) {
        BattleDrillsWebsocketService.initialize();
        BattleDrillsWebsocketService.addSession(session);
        System.out.println("Session added: " + session.getId());
        // Change this to be dynamic for role and username when a login system is implemented
        User user = new User(session.getId(), "role placeholder", "username placeholder");
        Notify.sendNotificationToSessionId(NotifyManager.createWebsocketNotification(NotifyTypes.OPERATION_TYPES.CREATE, user, null));
    }
    
    @OnClose
    public void onClose(Session session) {
        System.out.println("Session closed: " + session.getId());
        BattleDrillsWebsocketService.removeSession(session);
    }
    
    @OnMessage
    public void onMessage(String message, Session session) {
        if (session.isOpen()) {
            // eventually we can parse here later
            // chat message
            ChatMessage chatMessage = null;
            
            try {
                InjectableValues.Std inject = new InjectableValues.Std();
                inject.addValue(JacksonInjectableValues.NEW_TASK, true);
                chatMessage = new ObjectMapper().reader(inject).forType(ChatMessage.class).readValue(message);
                
                Notify.sendNotification(NotifyManager.createChatNotification(NotifyTypes.OPERATION_TYPES.CREATE, chatMessage));
            } catch (Exception e) {
                System.err.println(e);
                System.err.println("Unable to JSONify chat message");
            }
        }
    }
    
    @OnError
    public void onError(Session session, Throwable thr) {
        try {
            BattleDrillsWebsocketService.removeSession(session);
            System.out.println("Session closed: " + session.getId());
        } catch (Exception e) {
            
        }
    }
}
