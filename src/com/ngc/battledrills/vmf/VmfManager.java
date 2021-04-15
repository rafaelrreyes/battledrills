/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.vmf;

import com.ngc.battledrills.manage.BattleDrillManager;
import com.ngc.battledrills.util.ConvenienceUtils.VmfType;

/**
 *
 * @author rafa
 */
public class VmfManager {
    
    private static VmfManager instance = null;
    
    private static class Types {
        public static final String MEDEVAC = "medevac";
    }
    
    private VmfManager() {}
    
    public static VmfManager getInstance() {
        if (null == instance) {
            instance = new VmfManager();
        }
        
        return instance;
    }
    
    /**
     * Decides what to do with the VMF message received from Vmf Manager.
     * @param message 
     */
    public void handleVmfMessage(VmfMessage message) {
        if (message.getMessageBody().getType().equalsIgnoreCase(Types.MEDEVAC)) {
            System.out.println("attempting to create vmf drill");
            BattleDrillManager bdManager = BattleDrillManager.getInstance();
            bdManager.createFromVmf(VmfType.MEDEVAC);
        } else {
            // TODO: we'll have to do something with this later
            System.out.println("Vmf Type is not supported by battle drills");
        }
    }
}

