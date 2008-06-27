package net.form105.web.base.template;

import net.form105.web.base.component.menu.MainMenuPanel;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.PropertyModel;

public class DefaultMainTemplate extends WebPage<Void> {

	String pageTitle = "*** Please set title ***";

	public DefaultMainTemplate() {
		add(new Label("title", new PropertyModel<String>(this, "pageTitle")));
		add(new MainMenuPanel("menu"));
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
