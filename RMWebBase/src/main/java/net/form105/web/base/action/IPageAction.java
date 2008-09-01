package net.form105.web.base.action;

import java.io.Serializable;

import net.form105.rm.base.service.IResult;

import org.apache.wicket.model.IModel;

/**
 * An Action which acts on a WebPage. The action has a name which can be delegated to a component. Usually a 
 * resource bundle name should be used. If there isn't a resource bundle name provided it should fall back
 * to a string provided by <code>getName()</code>
 * @author hk
 *
 */
public interface IPageAction extends Serializable {
	
	/**
	 * Each action has an id which will be used for future processing in the authentication
	 * management
	 */
	public String getId();
	
	/**
	 * The action that will be executed
	 */
	public IResult doAction();
	
	public IModel getModel();

}
