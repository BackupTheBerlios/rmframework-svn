package net.form105.web.base.action;

import net.form105.rm.base.service.IResult;
import net.form105.web.base.ApplicationSession;

import org.apache.wicket.Page;

public abstract class AbstractWebPageAction<T> implements IPageAction<T> {
	
	private ApplicationSession session;
	private IResult<T> result = new DefaultActionResult<T>();
	
	public AbstractWebPageAction(Page page) {
		session = (ApplicationSession) page.getSession();
	}
	
	public abstract IResult<T> doAction();
	
	public ApplicationSession getSession() {
		return session;
	}
	
	public IResult<T> getResult() {
		return result;
	}
	
	protected void setResult(IResult<T> result) {
		this.result = result;
	}

}
