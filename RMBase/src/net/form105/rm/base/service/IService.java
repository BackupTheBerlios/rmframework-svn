/*
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */

package net.form105.rm.base.service;

import java.io.Serializable;

public interface IService extends Serializable {
    
    public void execute() throws Exception;
    
    public IResult getResult();
    
    public String getServiceName();
    
    public Exception[] getExceptions();
    
    

}
