package net.form105.web.base.model.authorize;

/**
 * Classes implementing this interface provides a connection or implementing a user database with users and
 * passwords to authenticate against
 * @author hk
 *
 */
public interface IUserIntegration {
	
	/**
	 * Gets the password as a String from an plugged in authorization system. A unique userId is provided.
	 * @param userId
	 * @return
	 */
	public String getPassword(String userId);
	
	/**
	 * Checks if a user is available. Normally this is used to check if a user exists. Best practice before 
	 * checking the password is to execute this method. 
	 * @param userId
	 * @return
	 */
	public boolean isUserAvailable(String userId);

}
