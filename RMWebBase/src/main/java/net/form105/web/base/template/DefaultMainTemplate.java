package net.form105.web.base.template;

import net.form105.web.base.component.subMenu.SubMenuPanel;
import net.form105.web.base.type.EventType;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.panel.Panel;

/**
 * According to the yaml specification this is the template for the main with css id #main.
 * This template provide the menu and the context part which is declared in the subclassed 
 * page implementation.
 * 
 * Id for menuPanel: panel.subNavigation
 * @author hk
 *
 */
public abstract class DefaultMainTemplate extends DefaultPageTemplate {
	

	protected Panel contextPanel;
	
	public DefaultMainTemplate(Panel menuPanel, Panel contextPanel) {
		this.contextPanel = contextPanel;
		add(menuPanel);
		add(contextPanel);
	}
	
	public Panel getContextPanel() {
		return this.contextPanel;
	}
	
	public abstract void ajaxRequestReceived(AjaxRequestTarget target, Object modelObject, EventType type);
	
}
