package net.form105.web.base.component.subMenu;

import net.form105.web.base.HomePage;
import net.form105.web.impl.page.TablePage;
import net.form105.web.impl.page.userManagement.UsersPage;

import org.apache.wicket.markup.html.link.BookmarkablePageLink;

public class ExampleMenuPanel extends SubMenuPanel {

	private static final long serialVersionUID = 1L;

	public ExampleMenuPanel(String id) {
		super(id);

		// add(createMenu());
		createMenu();
	}

	private void createMenu() {

		// final SuckerfishMenuPanel mb = new SuckerfishMenuPanel("menuBar");

		final SubMenuPanel.MenuItem mi = new SubMenuPanel.MenuItem(new BookmarkablePageLink(
				SubMenuPanel.LINK_ID, HomePage.class), "Home");
		addMenu(mi);

		final SubMenuPanel.MenuItem mi1_1 = new SubMenuPanel.MenuItem(new BookmarkablePageLink(
				SubMenuPanel.LINK_ID, UsersPage.class), "menu1_1");
		mi.addMenu(mi1_1);

		// Create a second menu without a link to the home page
		final SubMenuPanel.MenuItem mi2 = new SubMenuPanel.MenuItem("Home");
		addMenu(mi2);
		
		final SubMenuPanel.MenuItem mi5 = new SubMenuPanel.MenuItem(new BookmarkablePageLink(SubMenuPanel.LINK_ID, TablePage.class), "Table Page Demo");
		addMenu(mi5);
		

		final SubMenuPanel.MenuItem mi2_1 = new SubMenuPanel.MenuItem("Home");
		mi2.addMenu(mi2_1);
		final SubMenuPanel.MenuItem mi2_2 = new SubMenuPanel.MenuItem(new BookmarkablePageLink(SubMenuPanel.LINK_ID, UsersPage.class), "UserManagement with long text");
		mi2.addMenu(mi2_2);
		
		final SubMenuPanel.MenuItem mi3 = new SubMenuPanel.MenuItem(new BookmarkablePageLink(SubMenuPanel.LINK_ID, UsersPage.class), "UserManagement");
		
		
		addMenu(mi3);
		
	}

}
