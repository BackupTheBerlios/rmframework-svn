package net.form105.rm.base.service;

import java.util.List;

/**
 *
 * @author hk
 */
public abstract class AbstractResult<T> implements IResult<T> {
    
	private static final long serialVersionUID = 1L;
	private ResultStatus status;
    private List<T> resultList;
    private Exception exception;

	/**
     * Get the status of the result
     * @return Current status
     */
    public ResultStatus getStatus() {
        return status;
    }
    
    /**
     * Set the status of the result
     * @param status Status of the result to set
     */
    public void setStatus(ResultStatus status) {
        this.status = status;
    }
    
    public List<T> getResultList() {
    	return resultList;
    }
    
    public void setResultList(List<T> resultList) {
    	this.resultList = resultList;
    }
    
    /**
     * If the result contains an exception there shouldn't be a result list. 
     * The exception should be used for remoting where an remote exception
     * can be transmitted to the client. Therefore it is important that the result
     * and the exceptions are remoteble.
     * @return
     */
    public Exception getException() {
		return exception;
	}

    /**
     * Setting an exception
     * @param exception
     */
	public void setException(Exception exception) {
		this.exception = exception;
	}
    
}
