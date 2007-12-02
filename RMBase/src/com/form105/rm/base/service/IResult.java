/*
 * DBContainer.java, Oct 13, 2007, 8:38:22 PM
 * 
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */

package com.form105.rm.base.service;

import com.form105.rm.base.service.AbstractResult.Status;
import java.util.ArrayList;

public interface IResult {

    public Status getStatus();
    
    public void setStatus(Status status);
    
    public ArrayList getResultSet();

}
