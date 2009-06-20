package net.form105.web.equip.panel;

import net.form105.web.base.HomePage;
import net.form105.web.base.component.menu.AbstractMenuPanel;
import net.form105.web.base.model.navigation.DefaultNavigationItem;

public class MainMenuPanel extends AbstractMenuPanel {

    public MainMenuPanel(String id, String listId) {
        super(id, listId);
        addNavigationItem(new DefaultNavigationItem("navHome", HomePage.class, "menu.mainNav.home"));
    }

    private static final long serialVersionUID = 1L;

}
