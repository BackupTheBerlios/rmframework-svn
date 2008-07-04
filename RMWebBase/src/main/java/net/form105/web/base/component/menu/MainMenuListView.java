package net.form105.web.base.component.menu;



import java.util.List;

import net.form105.web.base.model.navigation.INavigationItem;

import org.apache.log4j.Logger;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.ResourceModel;

public class MainMenuListView extends ListView<INavigationItem> {

	private static final long serialVersionUID = 1L;
	protected static Logger logger = Logger.getLogger(MainMenuListView.class);
	
	public MainMenuListView(String id, List<INavigationItem> dataList) {
        super(id, dataList);
    }
	
	
	@Override
	protected void populateItem(ListItem item) {
		INavigationItem navItem = (INavigationItem) item.getModelObject();
        ResourceModel rModel = new ResourceModel(navItem.getResourceKey());
        BookmarkablePageLink pageLink = new BookmarkablePageLink("navigationItem", navItem.getNavTargetClass());
        item.add(new BookmarkablePageLink("navigationItem", navItem.getNavTargetClass()).add(new Label("navigationLabel", rModel)));
	}

}
