/*
* Copyright (c) 2008, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/

package com.form105.server.web.base;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.PropertyModel;

/**
 *
 * @author heiko
 */
public class TemplatePage extends WebPage {
    
    private String pageTitle = "My Page Title";
    
    public TemplatePage() {
        add(new DefaultNavigationPanel("menue"));
        add(new Label("title", new PropertyModel(this, "pageTitle")));
    }
    

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }
    
    

}
