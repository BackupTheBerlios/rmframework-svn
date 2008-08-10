package net.form105.web.impl.panel;

import org.apache.wicket.markup.html.panel.Panel;

public class ContextPanel extends Panel {
	
	private Panel context;

	private static final long serialVersionUID = 1L;
	
	public ContextPanel(String id) {
		super(id);
	}
	
	public void setContext(Panel context) {
		this.context = context;
	}
	
	public Panel getContext() {
		return context;
	}
	
	

}
