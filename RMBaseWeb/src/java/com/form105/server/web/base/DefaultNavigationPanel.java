/*
 * Copyright (c) 2008, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */
package com.form105.server.web.base;

import com.form105.server.web.base.navigation.NavigationItem;
import com.form105.server.web.base.navigation.NavigationMap;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.ResourceModel;

/**
 *
 * @author heiko
 */
public class DefaultNavigationPanel extends TemplateNavigationPanel {

    protected static Logger logger = Logger.getLogger(DefaultNavigationPanel.class);
    NavigationMap navMap = new NavigationMap();

    public DefaultNavigationPanel(String id) {
        super(id);

        add(new Label("mdMenu", "Master Data"));


        logger.info(navMap);


        ArrayList<NavigationItem> nameList = new ArrayList<NavigationItem>();
        nameList.add(new NavigationItem("navAdress", AddressPage.class, "menu.section.masterData.item.address"));
        nameList.add(new NavigationItem("navAdress1", AddressPage.class, "menu.section.masterData.item.address"));

        MenuListView listView = new MenuListView("navList", nameList);
        add(listView);
    }

    public class MenuListView extends ListView {

        public MenuListView(String id, List<NavigationItem> dataList) {
            super(id, dataList);
        }

        @Override
        protected void populateItem(ListItem item) {
            NavigationItem navItem = (NavigationItem) item.getModelObject();
            ResourceModel rModel = new ResourceModel(navItem.getResourceKey());
            item.add(new BookmarkablePageLink("item", navItem.getNavClass()).add(new Label("navLabel", rModel)));
        }
    }
}
