/*
 * DBContainer.java, Oct 13, 2007, 8:38:22 PM
 * 
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */

package net.form105.rm.base.service;

import java.io.Serializable;
import java.util.List;

public interface IResult<T> extends Serializable {

    public Exception getException();

    public void setException(Exception ex);

    public ResultStatus getStatus();

    public void setStatus(ResultStatus status);

    public List<T> getResultList();

    public void setResultList(List<T> resultList);

}
