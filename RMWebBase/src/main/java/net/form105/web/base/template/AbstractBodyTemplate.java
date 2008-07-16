package net.form105.web.base.template;

import net.form105.web.base.component.menu.AbstractMenuPanel;

/**
 * The body template consists of a menu and a part which is the real content of the page. 
 * @author hk
 *
 */
public abstract class AbstractBodyTemplate extends DefaultMainTemplate {
	
	private AbstractMenuPanel menuPanel;
	
	public AbstractBodyTemplate() {
		super();
	}
	
	public AbstractBodyTemplate(AbstractMenuPanel menuPanel) {
		this.menuPanel = menuPanel;
		add(menuPanel);
	}
	
	/**
	 * Returns the sub-MenuPanel which holds the menu of content
	 * @return
	 */
	public AbstractMenuPanel getSubMenuPanel() {
		return menuPanel;
	}

}
