package net.form105.rm.base.message;

/**
 * Notification to use if a message arrives in the system.
 * @author heiko
 *
 */
public interface IMessageNotification {
	
	/**
	 * Notify will be called if a message arrives in the system. The keys should be provided and
	 * the message itself.
	 * @param key1
	 * @param key2
	 */
	public void notify(String key1, String key2, IMessage message);
	
	/**
	 * Getting a name for notification
	 * @return
	 */
	public String getNotificationName();

}
