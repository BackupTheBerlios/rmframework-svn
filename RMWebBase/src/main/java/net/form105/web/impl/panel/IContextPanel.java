package net.form105.web.impl.panel;

import org.apache.wicket.markup.html.panel.Panel;

public interface IContextPanel {
	
	public abstract Panel getContext();
	
	public abstract void setContext(Panel contextPanel);

}
