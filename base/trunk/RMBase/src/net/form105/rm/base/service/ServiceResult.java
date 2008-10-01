/*
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */

package net.form105.rm.base.service;

import java.util.ArrayList;
import java.util.List;


public class ServiceResult<T> extends AbstractResult<T> {
    
	private static final long serialVersionUID = 1L;
	private List<T> resultList = new ArrayList<T>();
    
    public ServiceResult() {
        setStatus(Status.UNDEFINED);
    }

    public List<T> getResultList() {
        return resultList;
    }
    
    public void setResultList(List<T> resultList) {
        this.resultList = resultList;
    }

  

}
