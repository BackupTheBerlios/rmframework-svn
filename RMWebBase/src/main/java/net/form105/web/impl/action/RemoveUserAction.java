package net.form105.web.impl.action;

import net.form105.rm.base.model.user.User;
import net.form105.rm.base.service.IResult;
import net.form105.rm.base.service.LocalServiceHandler;
import net.form105.rm.server.service.DeleteUserService;
import net.form105.web.base.action.IContextAction;

public class RemoveUserAction implements IContextAction<User> {
	
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
	public IResult<User> doAction() {
		LocalServiceHandler<User> handler = new LocalServiceHandler<User>();
		DeleteUserService service = new DeleteUserService();
		DeleteUserService.ServiceArgument arg = service.getArgument();
		arg.id = getContext().getId();
		handler.executeService(service);
		return handler.getResult();
	}

	

}
