/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.comms;

/**
 *
 * @author admin
 */
public class ToastNotification extends Notification {
    private boolean toast = false; // true=create toast front-end
    private Notification notification; // pass the notification's data that needs to create a toast
        
    public ToastNotification(String operationType, Notification notification) {
        // ToastNotification is just used to tell the front-end to create a toast and passes the notification data
        // doesn't need "user" as of right now
        super(NotifyTypes.OBJECT_TYPES.TOAST, operationType, null);

        this.toast = true;
        this.notification = notification;
    }
    
    public boolean getToast() {
        return this.toast;
    }
    
    public Notification getNotification() {
        return this.notification;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User: ").append(getUser()).append(System.lineSeparator());
        sb.append("Toast: ").append(getToast()).append(System.lineSeparator());
        sb.append("Object Type: ").append(getObjectType()).append(System.lineSeparator());
        sb.append("Operation Type: ").append(getOperationType()).append(System.lineSeparator());
        sb.append("Notification: ").append(getNotification()).append(System.lineSeparator());
        return sb.toString();
    }
}
