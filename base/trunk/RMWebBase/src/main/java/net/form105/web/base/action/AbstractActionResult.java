package net.form105.web.base.action;

import java.util.List;

import net.form105.rm.base.service.IResult;
import net.form105.rm.base.service.ResultStatus;

public abstract class AbstractActionResult<T> implements IResult<T> {

	private static final long serialVersionUID = 1L;
	
	private Exception exception;
	private ResultStatus status;
	private List<T> resultList;
	
	public Exception getException() {
		return exception;
	}
	
	public void setException(Exception ex) {
		this.exception = ex;
	}

    public ResultStatus getStatus() {
    	return status;
    }
    
    public void setStatus(ResultStatus status) {
    	this.status = status;
    }
    
    public List<T> getResultList() {
		return resultList;
    }
    
    public void setResultList(List<T> resultList) {
    	this.resultList = resultList;
    }
	
	

}
