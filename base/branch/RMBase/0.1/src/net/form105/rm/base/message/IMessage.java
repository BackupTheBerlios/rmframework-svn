package net.form105.rm.base.message;

import java.util.List;

/**
 * A message should implement this interface to provide some basic informations. The message is 
 * identified by a sender, an acceptor, a unique id and the content which is also called the body.
 * @author heiko
 *
 * @param <T>
 */
public interface IMessage<T> {
	
	/**
	 * Getting the sender id of the message
	 * @return
	 */
	public String getSender();
	
	/**
	 * Getting the identifier of an acceptor 
	 * @return
	 */
	public String getAcceptor();
	
	/**
	 * Each message will return a message id to identify it uniquely
	 * @return
	 */
	public String getMessageId();
	
	/**
	 * Getting the message content
	 * @return
	 */
	public List<T> getBody();

	/**
	 * Getting an id which identifies the type of a message. This is usually used for hashcodes to register
	 * a type of a message in a registry and is needed only for special purposes.
	 * @return
	 */
	public Object getTypeId();
}
