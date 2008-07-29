package net.form105.web.base.component.login.authorize;

/**
 * An interface representing a user which is identified by an id. The label is a human readable name that can
 * be used in components. The interface is a placeholder which should wrapped around a real user object.
 * @author Heiko Kundlacz
 *
 */
public interface IProvidedUser {
	
	/**
	 * A unique identification for a user
	 * @return
	 */
	public String getUserId();
	
	/**
	 * A human readable name of the user, which should be used for labels
	 * @return
	 */
	public String getLabel();
	
	/**
	 * The provided password
	 * @return
	 */
	public String getPassword();
	
	/**
	 * Set a unique user id
	 * @param userId
	 */
	public void setUserId(String userId);

	/**
	 * Set a password
	 * @param password
	 */
	public void setPassword(String password);

	/**
	 * Set a label for the user
	 * @param label
	 */
	public void setLabel(String label);

}
