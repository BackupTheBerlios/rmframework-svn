package net.form105.web.base.action;

import net.form105.web.base.ApplicationSession;

import org.apache.wicket.Page;

public abstract class AbstractWebPageAction {
	
	private ApplicationSession session;
	
	public AbstractWebPageAction(Page page) {
		session = (ApplicationSession) page.getSession();
	}
	
	public abstract void doAction();
	
	public ApplicationSession getSession() {
		return session;
	}

}
