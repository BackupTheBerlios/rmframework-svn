/*
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */

package com.form105.rm.base.service;

import java.util.ArrayList;
import java.util.List;


public class ServiceResult extends AbstractResult {
    
    private List resultSet = new ArrayList();
    
    public ServiceResult() {
    }

    public List getResultSet() {
        return resultSet;
    }
    
    public void setResultSet(List resultList) {
        this.resultSet = resultList;
    }

  

}
