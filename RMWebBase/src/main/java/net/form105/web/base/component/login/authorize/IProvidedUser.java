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
	 * A human readable name of the user
	 * @return
	 */
	public String getLabel();
	
	/**
	 * The provided password
	 * @return
	 */
	public String getPassword();

}
