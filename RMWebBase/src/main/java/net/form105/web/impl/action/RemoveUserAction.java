package net.form105.web.impl.action;

import net.form105.rm.base.model.user.User;
import net.form105.rm.base.service.IResult;
import net.form105.rm.base.service.LocalServiceHandler;
import net.form105.rm.server.service.DeleteUserService;
import net.form105.web.base.action.AbstractFormAction;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;

public class RemoveUserAction extends AbstractFormAction<User> {
	
	public RemoveUserAction(Form form, String name) {
		super(form, name);
	}

	private static final long serialVersionUID = 1L;
	private final String id = "REMOVE_USER_ACTION";
	private User context;

	@Override
	public String getId() {
		return id;
	}
	
	@Override
	public User getContext() {
		return context;
	}

	@Override
	public void setContext(User context) {
		this.context = context;
		
	}

	@Override
	public IResult doAction() {
		LocalServiceHandler<User> handler = new LocalServiceHandler<User>();
		DeleteUserService service = new DeleteUserService();
		DeleteUserService.ServiceArgument arg = service.getArgument();
		arg.id = getContext().getId();
		handler.executeService(service);
		return handler.getResult();
	}


	

}
