package net.form105.web.impl.action;

import net.form105.rm.base.model.user.User;
import net.form105.rm.base.service.IResult;
import net.form105.rm.base.service.LocalServiceHandler;
import net.form105.rm.server.service.DeleteUserService;
import net.form105.web.base.action.AbstractFormAction;
import net.form105.web.base.component.table.DataTablePanel;

import org.apache.log4j.Logger;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.form.Form;

public class RemoveUserAction extends AbstractFormAction<User> {
	
	public static Logger logger = Logger.getLogger(RemoveUserAction.class);
	
	public RemoveUserAction(MarkupContainer markup, Form form, String name) {
		super(markup, form, name);
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

	@SuppressWarnings("unchecked")
	@Override
	public IResult doAction() {
		DataTablePanel<User> tablePanel = (DataTablePanel<User>) getMarkupContainer();
		tablePanel.getDataProvider().removeInput(context);
		
		LocalServiceHandler<User> handler = new LocalServiceHandler<User>();
		DeleteUserService service = new DeleteUserService();
		DeleteUserService.ServiceArgument arg = service.getArgument();
		arg.id = getContext().getId();
		handler.executeService(service);
		return handler.getResult();
	}


	private void refresh() {
		logger.info("Markup: "+getMarkupContainer());
	}
	

}
