/*
* Copyright (c) 2008, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/

package com.form105.server.web.base;

import java.util.List;
import org.apache.log4j.Logger;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;

/**
 *
 * @author heiko
 */
public class TemplateNavigationPanel extends Panel {
    
    protected Logger logger = Logger.getLogger(TemplateNavigationPanel.class);
    
    public TemplateNavigationPanel(String id) {
        super(id);
    }

    
}
