package net.form105.web.base.action;

import net.form105.rm.base.dao.XMLUserObjectDAO;
import net.form105.rm.base.model.user.User;
import net.form105.rm.base.query.DefaultFilterQuery;
import net.form105.rm.base.query.LocalQueryHandler;
import net.form105.rm.base.service.IResult;
import net.form105.rm.base.service.Status;
import net.form105.rm.server.filter.other.UserAuthorizationByEmailFilter;
import net.form105.rm.server.selection.FindAllDaoSelection;
import net.form105.web.base.component.login.authorize.DefaultUser;
import net.form105.web.base.component.login.authorize.IProvidedUser;
import net.form105.web.base.model.authorize.Authentication;

import org.apache.log4j.Logger;
import org.apache.wicket.model.IModel;

public class AuthenticationAction extends AbstractWebPageAction<User> {
	
	public static Logger logger = Logger.getLogger(AuthenticationAction.class);
	
	private final String id = "authenticationAction";
	
	private String userId;
	private String password;
	
	public AuthenticationAction(String userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}
	
	public String getId() {
		return id;
	}
	
	public IResult doAction() {
		
		LocalQueryHandler<User> queryHandler = new LocalQueryHandler<User>();
		
		UserAuthorizationByEmailFilter<User> filter = new UserAuthorizationByEmailFilter<User>(userId, password);
		DefaultFilterQuery<User> query = new DefaultFilterQuery<User>(new FindAllDaoSelection(XMLUserObjectDAO.class), filter);
		queryHandler.executeQuery(query);
		//setResult(queryHandler.getResult());
		
		IResult<User> queryResult = queryHandler.getResult();
		
		if (queryResult.getResultList().size() > 0) {
			logger.info("Got user: "+queryResult.getResultList().get(0).getEMail());
			User user = queryResult.getResultList().get(0);
			IProvidedUser provUser = mapUser(user);
			getSession().setAuthentication(new Authentication(provUser));
			
			// Set Result to success
			getResult().setStatus(Status.SUCCESS);
		} else {
			getResult().setStatus(Status.FAIL);
		}
		
		return getResult();
	}
	
	/**
	 * The IProvidedUser is the one used by the web system.
	 * @param user The user got by the user authentication system
	 * @return The provided user
	 */
	public IProvidedUser mapUser(User user) {
		DefaultUser defaultUser = new DefaultUser();
		defaultUser.setUserId(user.getShortName());
		defaultUser.setLabel(user.getEMail());
		defaultUser.setRoles(user.getRoles());
		return defaultUser;
	}

	@Override
	public IModel getModel() {
		return null;
	}

}
