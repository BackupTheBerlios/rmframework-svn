package net.form105.web.base.action;

import net.form105.rm.base.dao.XMLUserObjectDAO;
import net.form105.rm.base.model.user.User;
import net.form105.rm.base.query.DefaultFilterQuery;
import net.form105.rm.base.query.LocalQueryHandler;
import net.form105.rm.base.service.IResult;
import net.form105.rm.server.filter.other.UserAuthorizationFilter;
import net.form105.rm.server.selection.FindAllDaoSelection;
import net.form105.web.base.component.login.authorize.DefaultUser;
import net.form105.web.base.component.login.authorize.IProvidedUser;
import net.form105.web.base.model.authorize.Authentication;

import org.apache.wicket.Page;

public class AuthenticationAction extends AbstractWebPageAction {
	
	private String userId;
	private String password;
	
	public AuthenticationAction(Page page, String userId, String password) {
		super(page);
		this.userId = userId;
		this.password = password;
	}
	
	public void doAction() {
		
		LocalQueryHandler<User> queryHandler = new LocalQueryHandler<User>();
		
		UserAuthorizationFilter<User> filter = new UserAuthorizationFilter<User>(userId, password);
		DefaultFilterQuery<User> query = new DefaultFilterQuery<User>(new FindAllDaoSelection(XMLUserObjectDAO.class), filter);
		queryHandler.executeQuery(query);
		IResult<User> result = queryHandler.getResult();
		
		if (result.getResultList().size() > 0) {
			User user = result.getResultList().get(0);
			IProvidedUser provUser = mapUser(user);
			getSession().setAuthentication(new Authentication(provUser));
		}
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
		return defaultUser;
	}

}
