/*
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */

package net.form105.rm.base.service;

import java.io.Serializable;

public interface IService<T> extends Serializable {
    
    public void execute() throws Exception;
    
    public IResult<T> getResult();
    
    public void setResult(IResult<T> result);
    
    public String getServiceName();
    
    public Exception[] getExceptions();
    
    

}
