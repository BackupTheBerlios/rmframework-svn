package net.form105.rm.base.message;

import java.util.HashMap;

public class NetMasterMessageNotificationRegistry implements IMessageNotificationRegistry {
	
	private HashMap<KeyPair, IMessageNotification> notificationMap = new HashMap<KeyPair, IMessageNotification>();
	
	/* (non-Javadoc)
	 * @see com.kaiser.rsp.server.integration.IMessageNotification#register(java.lang.String, java.lang.String, com.kaiser.rsp.server.message.IMessageNotification)
	 */
	public void register(String key1, String key2, IMessageNotification notification) {
		KeyPair commandKey = new KeyPair(key1, key2);
		notificationMap.put(commandKey, notification);
	}
	
	/* (non-Javadoc)
	 * @see com.kaiser.rsp.server.integration.IMessageNotification#unregister(java.lang.String, java.lang.String)
	 */
	public void unregister(String key1, String key2) {
		notificationMap.remove(new KeyPair(key1, key2));
	}
	
	/* (non-Javadoc)
	 * @see com.kaiser.rsp.server.integration.IMessageNotification#getNotification(java.lang.String, java.lang.String)
	 */
	public IMessageNotification getNotification(String key1, String key2) {
		return notificationMap.get(new KeyPair(key1, key2));
	}
}
