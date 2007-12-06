/*
 * DBContainer.java, Oct 13, 2007, 8:38:22 PM
 * 
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */

package com.form105.rm.base.service;

import com.form105.rm.base.exception.RMException;
import java.io.Serializable;

public interface IService extends Serializable {
    
    public void execute() throws RMException;
    
    public IResult getResult();
    
    public String getName();
    
    public Exception[] getExceptions();

}
