/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.vmf;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 * @author rafa
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class VmfMessage {
    private VmfMessageBody messageBody;
    
    public VmfMessage() {}
    
    public VmfMessageBody getMessageBody() {
        return this.messageBody;
    }
    
    public void setMessageBody(VmfMessageBody messageBody) {
        this.messageBody = messageBody;
    }
}
