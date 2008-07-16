package net.form105.web.base.template;

import net.form105.web.base.component.mainNavigation.MainNavigationPanel;

import org.apache.log4j.Logger;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.PropertyModel;

public class DefaultMainTemplate extends WebPage<Void> {
	
	public static Logger logger = Logger.getLogger(DefaultMainTemplate.class);

	String pageTitle = "*** Please set title ***";

	public DefaultMainTemplate() {
		add(new Label<String>("title", new PropertyModel<String>(this, "pageTitle")));
		add(new MainNavigationPanel("panel.mainNavigation"));
		logger.info(this.getClass().getSimpleName());
		//add(new StyleSheetReference("styleSheet", this.getClass(), "HomePage.css"));
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

}
