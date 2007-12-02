/*
 * DBContainer.java, Oct 13, 2007, 8:38:22 PM
 * 
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */

package com.form105.rm.base.service;

import java.util.ArrayList;


public class ServiceResult extends AbstractResult {
    
    private IService service;
    private ArrayList resultSet = new ArrayList();
    
    public ServiceResult(IService service) {
        this.service = service;
    }

    public ArrayList getResultSet() {
        return resultSet;
    }

  

}
