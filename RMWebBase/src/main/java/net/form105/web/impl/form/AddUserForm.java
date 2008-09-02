package net.form105.web.impl.form;

import net.form105.rm.base.helper.UniqueIdHelper;
import net.form105.rm.base.model.user.User;
import net.form105.rm.base.service.LocalServiceHandler;
import net.form105.rm.base.service.Status;
import net.form105.rm.server.service.UpdateUserService;
import net.form105.web.base.component.form.AbstractForm;
import net.form105.web.base.type.EventType;
import net.form105.web.impl.validator.EmailExistValidator;

import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.validation.validator.EmailAddressValidator;

/**
 * A form to add a user to the user list. The user must have a unique eMail address.
 * @author heiko
 *
 */
public class AddUserForm extends AbstractForm {

	private static final long serialVersionUID = 1L;

	public AddUserForm(String id, IModel model, EventType eventType) {
		super(id, new CompoundPropertyModel(model), eventType);
		
		User user = (User) model.getObject();
		
		TextField email = new TextField("eMail");
		email.setLabel(new ResourceModel("label.email"));
		email.add(EmailAddressValidator.getInstance());
		email.add(new EmailExistValidator<User>());
		email.add(addReadonlyAttribute());
		email.setRequired(true);
		add(email);

		TextField sirName = new TextField("sirName");
		sirName.setLabel(new ResourceModel("label.sirName"));
		sirName.add(addReadonlyAttribute());
		sirName.setRequired(true);
		add(sirName);

		TextField firstName = new TextField("firstName");
		firstName.setLabel(new ResourceModel("label.firstName"));
		firstName.add(addReadonlyAttribute());
		firstName.setRequired(true);
		add(firstName);

		TextField shortName = new TextField("shortName");
		shortName.setLabel(new ResourceModel("label.shortName"));
		shortName.add(addReadonlyAttribute());
		shortName.setRequired(true);
		add(shortName);
	}
	
	protected void onSubmit() {
		User user = (User) getModelObject();
		LocalServiceHandler<User> handler = new LocalServiceHandler<User>();
		UpdateUserService uService = new UpdateUserService();
		UpdateUserService.ServiceArgument arg = uService.getArgument();
		arg.id = UniqueIdHelper.getId();
		arg.firstName = user.getFirstName();
		arg.email = user.getEMail();
		arg.isAdmin = user.isAdmin();
		arg.name = user.getSirName();
		arg.password = user.getPassword();
		arg.shortName = user.getShortName();
		handler.executeService(uService);
		if (handler.getResult().getStatus() == Status.FAIL) {
		}
	}
	
	

}
