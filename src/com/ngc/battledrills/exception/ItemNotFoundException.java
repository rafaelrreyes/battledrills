/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.exception;

/**
 *
 * @author admin
 */
public class ItemNotFoundException extends Exception{
    public ItemNotFoundException(String errorMessage)
    {
        super(errorMessage);
    }
}
