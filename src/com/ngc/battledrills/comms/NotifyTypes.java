/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.comms;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author admin
 */
public class NotifyTypes {
    //public static final List<String> VALID_OBJECT_TYPES = Arrays.asList("drill", "task", "note", "chat");
    public static final List<String> VALID_OPERATION_TYPES
            = Arrays.asList("create", "start", "stop", "edit", "delete", "reorder", "read");
    
    public static class OBJECT_TYPES {
        public static final String DRILL = "drill";
        public static final String TASK = "task";
        public static final String NOTE = "note";
        public static final String CHAT = "chat";
        public static final String WEBSOCKET = "websocket";
        public static final String TOAST = "toast";
        public static final String ATTACHMENT = "attachment";
    }
    
    public static class OPERATION_TYPES {
        public static final String CREATE = "create";
        public static final String START = "start";
        public static final String STOP = "stop";
        public static final String EDIT = "edit";
        public static final String DELETE = "delete";
        public static final String REORDER = "reorder";
        public static final String READ = "read";
    }
}
