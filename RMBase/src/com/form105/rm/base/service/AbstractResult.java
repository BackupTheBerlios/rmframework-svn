/*
 * DBContainer.java, Oct 13, 2007, 8:38:22 PM
 * 
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */

package com.form105.rm.base.service;

import java.util.Collection;

/**
 *
 * @author hk
 */
public abstract class AbstractResult<T> implements IResult<T> {
    
	private static final long serialVersionUID = 1L;
	private Status status;
    private Collection<T> resultList;
    private Exception exception;

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
    
    public Collection<T> getResultList() {
    	return resultList;
    }
    
    public void setResultList(Collection<T> resultList) {
    	this.resultList = resultList;
    }
    
    /**
     * If the result contains an exception there shouldn't be a result list. 
     * The exception should be used for remoting where an remote exception
     * can be transmitted to the client. Therefore it is importend that the result
     * and the exceptions are remotable.
     * @return
     */
    public Exception getException() {
		return exception;
	}

    /**
     * Setting an exception
     * @param exception
     */
	public void setException(Exception exception) {
		this.exception = exception;
	}
    
}
