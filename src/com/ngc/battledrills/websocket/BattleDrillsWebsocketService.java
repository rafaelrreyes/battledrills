/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.websocket;

import com.ngc.battledrills.data.User;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import javax.websocket.Session;
/**
 *
 * @author admin
 */
public class BattleDrillsWebsocketService {
    
    private static BattleDrillsWebsocketService instance = null;
    
    private static Map<String, Session> sessions = new HashMap<String, Session>();
    
    public static void connectToVmfManagerApp() {
        try {
            final BattleDrillsClientWebsocket vmfWebsocket = new BattleDrillsClientWebsocket();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    private BattleDrillsWebsocketService () {
        // connect to vmf manager app once the battle drills websocket gets initialized
//        connectToVmfManagerApp();
    }
    
    public static BattleDrillsWebsocketService initialize() {
         if (instance == null) {
             instance = new BattleDrillsWebsocketService();
         }
         
         return instance;
    }
    
    public static void addSession(Session session) {
        if (session == null) {
            throw new IllegalArgumentException("Session cannot be null.");
        } else {
            sessions.put(session.getId(), session);
        }
    }
    
    public static int getSessionsAmount() {
        return sessions.size();
    }
    
    public static void removeSession(Session session) {
        if (session == null) {
            throw new IllegalArgumentException("Session cannot be null.");
        } else {
            sessions.remove(session.getId());
        }
    }
    
    /**
     * Sends message in JSON string format to all open client sessions.
     * @param message 
     */
    public static void broadcast(String message) {
        try {
            for (String key : sessions.keySet()) {
                Session currentSession = sessions.get(key);
                if (currentSession.isOpen()) {
                    currentSession.getBasicRemote().sendText(message);
                }
            }
        } catch (IOException e) {
            
        }
    }
    
    /**
     * Sends message in JSON string format to a specific SessionId
     * This will probably be changed to a specific username when the system is in place
     * @param user 
     * @param message
     */
    public static void broadcastToSessionId(User user, String message) {
        try {
            Session currentSession = sessions.get(user.getSessionId());
            if (currentSession.isOpen()) {
                currentSession.getBasicRemote().sendText(message);
            }
        } catch (IOException e) {
            
        }
    }
    
    /**
     * Sends message in JSON string format to all open sessions except for the one who created the notification
     * This will probably be changed to a specific username when the system is in place
     * @param user 
     * @param message
     */
    public static void broadcastToAllExcluding(User user, String message) {
        try {
            for (String key : sessions.keySet()) {
                Session currentSession = sessions.get(key);
                if (currentSession.isOpen() && !currentSession.equals(sessions.get(user.getSessionId()))) {
                    currentSession.getBasicRemote().sendText(message);
                }
            }
        } catch (IOException e) {
            
        }
    }
}
