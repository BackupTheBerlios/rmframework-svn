package net.form105.rm.server.ant.hotfolder;

import java.io.File;
import java.util.List;

import net.form105.rm.base.validator.IInboundValidator;
import net.form105.rm.server.ant.container.InboundConfiguration;

public abstract class AbstractInboundReceiver {

	private List<IInboundValidator> validatorList;
	private List<IInboundListener> eListenerList;
	private InboundConfiguration config;


	public AbstractInboundReceiver(InboundConfiguration config) {
		this.config = config;
		eListenerList = config.getConfiguredListeners();
		validatorList = config.getValidators();
	}
	
	public abstract void  prepareInboundObjects();
	
	/**
	 * Add a listener to the {@link HotfolderInboundReceiver} instance
	 * 
	 * @param listener
	 */
	public void addListener(IInboundListener listener) {
		eListenerList.add(listener);
	}
	
	

	/**
	 * Remove a listener from the {@link HotfolderInboundReceiver} instance
	 * 
	 * @param listener
	 */
	public void removeListener(IInboundListener listener) {
		eListenerList.remove(listener);
	}
	
	/**
	 * Add a validator to the inboundReceiver. The validator checks for environment
	 * and precondition of the incoming object.
	 * 
	 * @param validator
	 */
	public void addValidator(IInboundValidator<File> validator) {
		validatorList.add(validator);
	}
	
	/**
	 * Remove a validator to the inboundReceiver. The validator checks for environment
	 * and precondition of the incoming object.
	 * 
	 * @param validator
	 */
	public void removeValidator(IInboundValidator<File> validator) {
		validatorList.remove(validator);
	}
	
	/**
	 * Create and send the events in case of file changes on the hotfolders.
	 * 
	 * @param file
	 *            The file which has been arrived
	 */
	public void notifyInbound(InboundObject inboundObject) {
		if (eListenerList.size() > 0) {
			InboundEvent event = new InboundEvent(inboundObject);
			for (IInboundListener listener : eListenerList) {
				listener.objectArrived(inboundObject);
			}
		}
	}

	/**
	 * Create and send the events in case of file changes on the hotfolders.
	 * 
	 * @param file
	 *            The file which has been removed
	 */
	public void notifyInboundClear(InboundObject inboundObject) {
		InboundEvent event = new InboundEvent(inboundObject);
		for (IInboundListener listener : eListenerList) {
			listener.objectRemoved(inboundObject);
		}
	}
	
	protected InboundConfiguration getConfiguration() {
		return config;
	}

}
