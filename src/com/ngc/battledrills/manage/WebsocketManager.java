/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.manage;

import com.ngc.battledrills.websocket.WebsocketNode;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author admin
 */
public class WebsocketManager {
    
    private static WebsocketManager instance = null;
    private static final List<String> types = Arrays.asList("toast");
    
    private WebsocketManager() { }
    
    public static WebsocketManager getInstance() {
        if (instance == null) {
            instance = new WebsocketManager();
        }
        
        return instance;
    }
    
    public static WebsocketNode createWebsocketByType(String type, String message) {
        WebsocketNode websocketNode = new WebsocketNode();
        try {
            if (isValidType(type)) {
                websocketNode.setType(type);
                websocketNode.setMessage(message);
            }           
        } catch (Exception e) {
            System.err.println("Exception occured when trying to create websocket object. Ensure type is valid.");
        }
        
        return websocketNode;
    }
    
    private static boolean isValidType(String type) {
        boolean isValid = false;
         
        for (int i = 0; i < types.size(); i++) {
            if (types.get(i).equals(type.toLowerCase())) {
                isValid = true;
                break;
            }
        }
        
        return isValid;
    }
    
    
}
