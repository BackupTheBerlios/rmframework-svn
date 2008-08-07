package net.form105.web.base.template;

import net.form105.web.base.component.menu.AbstractMenuPanel;
import net.form105.web.base.component.subMenu.SubMenuPanel;

/**
 * The body template consists of a menu and a part which is the real content of the page. 
 * @author hk
 *
 */
public abstract class AbstractBodyTemplate extends DefaultMainTemplate {
	
	private SubMenuPanel menuPanel;
	
	public AbstractBodyTemplate() {
		super();
	}
	
	public AbstractBodyTemplate(SubMenuPanel menuPanel) {
		this.menuPanel = menuPanel;
		add(menuPanel);
	}
	
	

}
