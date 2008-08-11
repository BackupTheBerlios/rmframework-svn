package net.form105.web.base.template;

import net.form105.web.base.component.mainNavigation.MainNavigationPanel;
import net.form105.web.base.page.BasePage;
import net.form105.web.base.type.AjaxEventType;

import org.apache.log4j.Logger;
import org.apache.wicket.ResourceReference;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.resources.StyleSheetReference;
import org.apache.wicket.model.PropertyModel;

public class DefaultMainTemplate extends BasePage {
	
	public static Logger logger = Logger.getLogger(DefaultMainTemplate.class);

	String pageTitle = "*** Please set title ***";

	public DefaultMainTemplate() {
		
		add(new StyleSheetReference("cssDefaultMainTemplate", new ResourceReference(DefaultMainTemplate.class, "DefaultMainTemplate.css")));
		
		add(new Label("title", new PropertyModel(this, "pageTitle")));
		add(new MainNavigationPanel("panel.mainNavigation"));
		
	}

	/**
	 * Sets the pageTitle
	 * 
	 * @return
	 */
	public String getPageTitle() {
		return pageTitle;
	}

	/**
	 * Getting the pageTitle
	 * 
	 * @param pageTitle
	 */
	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

	@Override
	public void ajaxRequestReceived(AjaxRequestTarget target, Object modelObject, AjaxEventType type) {
		// by default do nothing
	}

}
