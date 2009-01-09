package net.form105.rm.base.message;

import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Logger;


/**
 * The default message handler receives messages and forwards them to a responsible notification registry. The message is
 * identified by the sender and the acceptor which are the keys for the registration map.
 * @author heiko
 *
 */
public class DefaultMessageHandler implements Runnable {
	
	public static Logger logger = Logger.getLogger(DefaultMessageHandler.class);
	
	private boolean runState = true;
	
	private LinkedBlockingQueue<IMessage<?>> messageQueue = new LinkedBlockingQueue<IMessage<?>>();
	
	private HashMap<Class<?>, IMessageNotificationRegistry> notificationMap = new HashMap<Class<?>, IMessageNotificationRegistry>();

	@Override
	public void run() {
		while (runState) {
			try {
				// take the message
				IMessage<?> message = messageQueue.take();
				// ret the responsible registry for the type of message
				IMessageNotificationRegistry registry = notificationMap.get(message.getClass());
				IMessageNotification notification = registry.getNotification(message.getSender(), message.getAcceptor());
				// send message to the notification
				logger.info("Notify the registry:"+notification.getNotificationName());
				notification.notify(message.getSender(), message.getSender(), message);
			} catch (InterruptedException e) {
				logger.error("MessageQueue interrupt exception!", e);
			}
		}
	}
	
	/**
	 * Adding a message to the message queue to associate a registry for notification
	 * @param message
	 */
	public void addMessage(IMessage<?> message) {
		try {
			messageQueue.put(message);
		} catch (InterruptedException e) {
			logger.error("MessageQueue interrupt exception!", e);
		}
	}
	
	public void addMessageResolver(Class<?> clazz, IMessageNotificationRegistry registry) {
		notificationMap.put(clazz, registry);
	}
	
	public void removeMessageResolver(Class<?> clazz) {
		notificationMap.remove(clazz);
	}
}
