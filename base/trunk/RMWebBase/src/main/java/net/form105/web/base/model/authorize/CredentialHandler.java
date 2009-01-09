package net.form105.web.base.model.authorize;

import java.util.ArrayList;

import net.form105.web.base.component.login.authorize.IProvidedUser;

/**
 * Provides a list of UserIntegration. A user can be checked against each integration and returns successful
 * if the userIntegration password an the password of the provided user matches. There can be multiple
 * integration 
 * @author hk
 *
 */
public class CredentialHandler {
	
	private ArrayList<IUserIntegration> integrationList = new ArrayList<IUserIntegration>();
	
	/**
	 * checks the user against the provided userIntegrations from the integrationList.
	 * @param providedUser The user to check for the password
	 * @return Success if the password matches
	 */
	public boolean checkUser(IProvidedUser providedUser) {
		for (IUserIntegration integration : integrationList) {
			String providedUsername = providedUser.getUserId();
			String password = providedUser.getPassword();
			
			if (! integration.isUserAvailable(providedUsername)) {
				return false;
			}
			
			if (password.equals(integration.getPassword(providedUsername))) {
				return true;
			}
			
		}
		
		return false;
	}

}
