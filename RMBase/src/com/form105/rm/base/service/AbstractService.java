/*
 * DBContainer.java, Oct 13, 2007, 8:38:22 PM
 * 
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */

package com.form105.rm.base.service;

import org.apache.log4j.Logger;

public abstract class AbstractService implements IService {
    
    protected static Logger logger = Logger.getLogger(AbstractService.class);

    private Exception[] exceptions;
    private String serviceName;
    
    private IResult result;
    
    public IResult getResult() {
        return result;
    }
    
    public abstract String getServiceName();
    
    public Exception[] getExceptions() {
        return exceptions;
    }
    
    public void setExceptions(Exception[] exceptions) {
        this.exceptions = exceptions;
    }
    
}
