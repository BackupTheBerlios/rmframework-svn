/*
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */

package net.form105.rm.base.service;

import org.apache.log4j.Logger;

public abstract class AbstractService implements IService {
    
	private static final long serialVersionUID = 1L;

	protected static Logger logger = Logger.getLogger(AbstractService.class);

    private Exception[] exceptions;
    
    private IResult result = new ServiceResult();
    
    public IResult getResult() {
        return result;
    }
    
    public String getServiceName() {
        return getClass().getName();
    }
    
    public abstract void execute() throws Exception;
    
    public abstract IArgument getArgument();
    
    public Exception[] getExceptions() {
        return exceptions;
    }
    
    public void setExceptions(Exception[] exceptions) {
        this.exceptions = exceptions;
    }
    
    public void setResult(IResult result) {
        this.result = result;
    }
    
}
