package net.form105.web.base.component.subMenu;

import net.form105.web.base.component.border.BorderedPanel;

import org.apache.log4j.Logger;
import org.apache.wicket.Page;
import org.apache.wicket.ResourceReference;
import org.apache.wicket.markup.html.resources.StyleSheetReference;
import org.apache.wicket.markup.repeater.RepeatingView;

public class SubMenuPanel extends BorderedPanel {
	
	public static Logger logger = Logger.getLogger(SubMenuPanel.class);
	
	private static final long serialVersionUID = 1L;
	
	private Class<? extends Page> pageClass;
	
	RepeatingView menu;

	/**
	 * Constructs a panel for a menu.
	 * @param id The id of the panel
	 * @param menuId The id of the repeating component (RepeatingView)
	 */
	public SubMenuPanel(String id, String menuId, Class<? extends Page> pageClass) {
		super(id);
		
		add(new StyleSheetReference("cssSubMenuPanel", new ResourceReference(SubMenuPanel.class, "SubMenuPanel.css")));
		this.pageClass = pageClass;
		menu = new RepeatingView(menuId);
		add(menu);
		
		
	
		
	}
	
	public void addMenuEntry(String resourceKey, Class<? extends Page> targetClass) {
		menu.add(new MenuEntryPanel(menu.newChildId(), resourceKey, targetClass, pageClass));
	}
	
}
