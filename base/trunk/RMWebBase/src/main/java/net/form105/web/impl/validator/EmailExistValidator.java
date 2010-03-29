package net.form105.web.impl.validator;

import java.util.List;

import net.form105.rm.base.Agent;
import net.form105.rm.base.container.UserManagementContainer;
import net.form105.rm.base.dao.XMLUserObjectDAO;
import net.form105.rm.base.model.user.User;
import net.form105.rm.base.query.FindAllDaoQuery;
import net.form105.rm.base.query.LocalQueryHandler;

import org.apache.log4j.Logger;
import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.validator.AbstractValidator;

/**
 * Validates the email of an user against the backend for existance. If the email-address already exist
 * an error message will be thrown got by the resource key "error.validation.emailExist".
 * 
 * @author hk
 *
 * @param <T> The user to validate
 */
public class EmailExistValidator<T extends User> extends AbstractValidator {

	private static final long serialVersionUID = 1L;
	public static Logger logger = Logger.getLogger(EmailExistValidator.class);
	

	@Override
	protected void onValidate(IValidatable validatable) {
		String value = (String) validatable.getValue();
		LocalQueryHandler qHandler = new LocalQueryHandler();
		UserManagementContainer userContainer = (UserManagementContainer) Agent.getContainer("userMgmt");
		FindAllDaoQuery<User> query = new FindAllDaoQuery<User>(userContainer.getUserObjectDao());
		qHandler.executeQuery(query);
		
		List<User> userList = query.getQueryResult().getResultList();
		//check for an existing user
		for (User backendUser : userList) {
			if (backendUser.getEMail().equals(value)) {
				error(validatable);
				return;
			}
		}
	}
	
	protected String resourceKey() {
		return "error.validation.emailExist";
	}
}
