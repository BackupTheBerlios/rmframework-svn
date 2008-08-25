package net.form105.web.base.action;

public interface IContextAction<T> extends IPageAction<T> {
	
	public T getContext();
	
	public void setContext(T context);

}
