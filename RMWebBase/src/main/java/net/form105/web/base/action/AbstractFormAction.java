package net.form105.web.base.action;

import net.form105.rm.base.service.IResult;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;

/**
 * 
 * @author heiko
 *
 * @param <T> The context to act on by the doAction method. E.g. To delete a user the action must work
 * on a context which is the user.
 */
public abstract class AbstractFormAction<T> implements IModelAction {

	private static final long serialVersionUID = 1L;
	private Form form;
	private IModel model;
	private T context;
	
	public AbstractFormAction(Form form, IModel model) {
		this.form = form;
		this.model = model;
		if (form instanceof ActionForm) {
			ActionForm<T> actionForm = (ActionForm<T>) form;
			actionForm.setAction(this);
		}
	}

	@Override
	public IModel getModel() {
		return model;
	}

	@Override
	public abstract IResult<Void> doAction();


	@Override
	public abstract String getId();
	
	public Form getForm() {
		return form;
	}
	
	public T getContext() {
		return context;
	}
	
	public void setContext(T context) {
		this.context = context;
	}
	
	
	
}
