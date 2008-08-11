package net.form105.web.base.page;

import net.form105.web.base.type.AjaxEventType;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebPage;

public abstract class BasePage extends WebPage {
	
	/**
	 * This method is invoked if an ajax event has fired. It is often necessary that object from the page
	 * are required. So this is the best place to handle events.
	 * @param target The target to assign components to
	 * @param modelObject The object that an event is invoked on. E.g. the model object of a table row
	 * @param type The type of event that has fired
	 */
	public abstract void ajaxRequestReceived(AjaxRequestTarget target, Object modelObject, AjaxEventType type);

}
