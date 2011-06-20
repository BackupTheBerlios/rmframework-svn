package net.form105.rm.server.ant.hotfolder;

import java.util.EventListener;

/**
 * A listener which reacts on events from inbound object. Implement this interface and register the object at the
 * {@link HotfolderInboundReceiver} instance.
 * @author heikok
 *
 */
public interface IInboundListener extends EventListener {
	
	/**
	 * Event for files if an inbound object has been arrived
	 * @param hotEvent The event object
	 */
	public void objectArrived(IInboundObject inboundObject);
	
	/**
	 * Event for inbounds if the object has been removed from the queue
	 * @param hotEvent The event object
	 */
	public void objectRemoved(IInboundObject inboundObject);
	
}
