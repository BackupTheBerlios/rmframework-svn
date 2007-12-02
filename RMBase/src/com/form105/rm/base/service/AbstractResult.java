/*
 * DBContainer.java, Oct 13, 2007, 8:38:22 PM
 * 
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */

package com.form105.rm.base.service;

/**
 *
 * @author Heiko Kundlacz
 */
public abstract class AbstractResult implements IResult {
    
    private Status status;
    
    public enum Status {
        SUCCESS,
        FAIL,
        UNDEFINED;
        
    }
    
    /**
     * Get the status of the result
     * @return Current status
     */
    public Status getStatus() {
        return status;
    }
    
    /**
     * Set the status of the result
     * @param status Status of the result to set
     */
    public void setStatus(Status status) {
        this.status = status;
    }
    

}
