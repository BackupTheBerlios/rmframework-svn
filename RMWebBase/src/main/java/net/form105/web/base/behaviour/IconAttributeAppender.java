package net.form105.web.base.behaviour;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.model.Model;

/**
 * Appender/behavior to add a class attribute to a markup. This should be used to add icons
 * via css definition.
 * This will result in the following markup after the appender is added to the markup:
 * 
 * <code><div wicket:id="" class="<classValue>" /></code>
 * @author heiko
 *
 */
public class IconAttributeAppender extends AttributeAppender {
	
	private static final long serialVersionUID = 1L;

	public IconAttributeAppender(String classValue) {
		super("class", true,  new Model(classValue), " ");
	}

}
