package net.form105.rm.base.message;

import java.util.ArrayList;
import java.util.List;

/**
 * An abstract message which defines a sender and an acceptor by default from an constructor. 
 * The message id is set to the current time in milliseconds.
 * @author heiko
 *
 * @param <T>
 */
public abstract class AbstractMessage<T> implements IMessage<T> {
	
	private String sender;
	private String acceptor;
	private Long currentTime;
	
	private List<T> bodyList = new ArrayList<T>();
	
	/**
	 * A default constructor with a sender and an acceptor
	 * @param sender
	 * @param acceptor
	 */
	public AbstractMessage(String sender, String acceptor) {
		this.sender = sender;
		this.acceptor = acceptor;
		currentTime = System.currentTimeMillis();
	}
	
	@Override
	public List<T> getBody() {
		return bodyList;
	}
	
	@Override
	public String getSender() {
		return sender;
	}
	
	@Override
	public String getAcceptor() {
		return acceptor;
	}
	
	@Override
	public String getMessageId() {
		return currentTime.toString();
	}
	
	public void setBody(List<T> bodyList) {
		this.bodyList = bodyList;
	}
	

}
