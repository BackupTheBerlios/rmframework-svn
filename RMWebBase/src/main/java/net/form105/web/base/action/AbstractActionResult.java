package net.form105.web.base.action;

import java.util.List;

import net.form105.rm.base.service.IResult;
import net.form105.rm.base.service.Status;

public abstract class AbstractActionResult<T> implements IResult<T> {

	private static final long serialVersionUID = 1L;
	
	private Exception exception;
	private Status status;
	private List<T> resultList;
	
	public Exception getException() {
		return exception;
	}
	
	public void setException(Exception ex) {
		this.exception = ex;
	}

    public Status getStatus() {
    	return status;
    }
    
    public void setStatus(Status status) {
    	this.status = status;
    }
    
    public List<T> getResultList() {
		return resultList;
    }
    
    public void setResultList(List<T> resultList) {
    	this.resultList = resultList;
    }
	
	

}
