package net.form105.web.base.action;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.model.IModel;

public class ActionSubmitLink<T> extends SubmitLink {
	
	private static final long serialVersionUID = 1L;
	
	private IPageAction<T> action;

	public ActionSubmitLink(String id, IModel model, Form form, IPageAction<T> action) {
		super(id, form);
		this.action = action;
	}
	
	public void onSubmit() {
		
		action.doAction();
	}

	
	
	

}
