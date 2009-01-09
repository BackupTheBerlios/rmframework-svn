package net.form105.web.base.component.behavior;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.AbstractBehavior;
import org.apache.wicket.markup.html.IHeaderResponse;

/**
 * A behavior which sets the focus on a component. The focus is set by a JavaScript
 * @author heiko
 *
 */
public class FocusOnLoadBehavior extends AbstractBehavior {

	private static final long serialVersionUID = 1L;
	private Component component;

	public void bind(Component component) {
		this.component = component;
		component.setOutputMarkupId(true);
	}

	public void renderHead(IHeaderResponse iHeaderResponse) {
		super.renderHead(iHeaderResponse);
		iHeaderResponse.renderOnLoadJavascript("document.getElementById('" + component.getMarkupId() + "').focus()");
	}

	public boolean isTemporary() {
		// remove the behavior after component has been rendered
		return true;
	}
}
