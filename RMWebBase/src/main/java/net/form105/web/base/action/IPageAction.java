package net.form105.web.base.action;

import net.form105.rm.base.service.IResult;

/**
 * An Action which acts on a WebPage
 * @author hk
 *
 */
public interface IPageAction<T> {
	
	/**
	 * Each action has an id which will be used for future processing in the authentication
	 * management
	 */
	public String getId();
	
	/**
	 * The action that will be executed
	 */
	public IResult<T> doAction();
	
	

}
