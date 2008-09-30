package net.form105.web.impl.form;

import net.form105.rm.base.model.user.User;
import net.form105.rm.base.service.LocalServiceHandler;
import net.form105.rm.base.service.Status;
import net.form105.rm.server.service.UpdateUserService;
import net.form105.web.base.component.behavior.FocusOnLoadBehavior;
import net.form105.web.base.component.form.AbstractForm;
import net.form105.web.base.type.EventType;

import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.validation.validator.EmailAddressValidator;

public class EditUserForm extends AbstractForm {
	private static final long serialVersionUID = 1L;

	public EditUserForm(String name, IModel model, EventType eventType) {
		super(name, new CompoundPropertyModel(model), eventType);
		
		TextField userId = new TextField("id");
		userId.setLabel(new Model("userId"));
		userId.add(new FocusOnLoadBehavior());
		userId.add(addReadonlyAttribute());
		add(userId);

		TextField email = new TextField("eMail");
		email.setLabel(new Model("userEmail"));
		email.add(EmailAddressValidator.getInstance());
		email.add(addReadonlyAttribute());
		email.setRequired(true);
		add(email);

		TextField sirName = new TextField("sirName");
		sirName.setLabel(new Model("userSirName"));
		sirName.add(addReadonlyAttribute());
		sirName.setRequired(true);
		add(sirName);

		TextField firstName = new TextField("firstName");
		firstName.setLabel(new Model("userFirstName"));
		firstName.add(addReadonlyAttribute());
		firstName.setRequired(true);
		add(firstName);

		TextField shortName = new TextField("shortName");
		shortName.setLabel(new Model("userShortName"));
		shortName.add(addReadonlyAttribute());
		shortName.setRequired(true);
		add(shortName);
		
		
	}
	
	protected void onSubmit() {
		User user = (User) getModelObject();
		
		LocalServiceHandler<User> handler = new LocalServiceHandler<User>();
		UpdateUserService uService = new UpdateUserService();
		UpdateUserService.ServiceArgument arg = uService.getArgument();
		arg.id = user.getId();
		arg.firstName = user.getFirstName();
		arg.email = user.getEMail();
		arg.isAdmin = user.isAdmin();
		arg.name = user.getSirName();
		arg.password = user.getPassword();
		arg.shortName = user.getShortName();
		handler.executeService(uService);
		if (handler.getResult().getStatus() == Status.FAIL) {
			// add message to a panel -> model window
			
		}
	}
	
	

}
