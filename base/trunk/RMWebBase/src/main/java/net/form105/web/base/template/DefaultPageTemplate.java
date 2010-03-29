package net.form105.web.base.template;

import net.form105.web.base.component.mainNavigation.MainNavigationPanel;
import net.form105.web.base.page.BasePage;
import net.form105.web.base.type.EventType;

import org.apache.log4j.Logger;
import org.apache.wicket.ResourceReference;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.JavascriptPackageResource;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.resources.StyleSheetReference;
import org.apache.wicket.model.PropertyModel;

public class DefaultPageTemplate extends BasePage {
	
	public static Logger logger = Logger.getLogger(DefaultPageTemplate.class);

	String pageTitle = "*** Please set title ***";

	public DefaultPageTemplate() {
		
		add(new StyleSheetReference("cssDefaultPageTemplate", new ResourceReference(DefaultPageTemplate.class, "DefaultPageTemplate.css")));
		add(JavascriptPackageResource.getHeaderContribution("js/mootools-1.2.4-core-yc.js"));
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
	public void ajaxRequestReceived(AjaxRequestTarget target, Object modelObject, EventType type) {
		// by default do nothing
	}

}
