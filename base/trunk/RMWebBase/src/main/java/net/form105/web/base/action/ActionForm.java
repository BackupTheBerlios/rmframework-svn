package net.form105.web.base.action;

import org.apache.wicket.markup.html.form.Form;

public class ActionForm<T> extends Form<T> {
	
	private AbstractFormAction<T> action;

	private static final long serialVersionUID = 1L;
	
	public ActionForm(String id) {
		super(id);
	}
	
	public void setAction(AbstractFormAction<T> action) {
		this.action = action;
	}
	
	public AbstractFormAction<T> getAction() {
		return action;
	}
	
	
	
	

}
