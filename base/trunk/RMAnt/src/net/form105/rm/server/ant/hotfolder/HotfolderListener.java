package net.form105.rm.server.ant.hotfolder;

import java.util.EventListener;

/**
 * A listener which reacts on events from hotfolders. Implement this interface and register the object at the
 * {@link Hotfolder} instance.
 * @author heikok
 *
 */
public interface HotfolderListener extends EventListener {
	
	/**
	 * Event for files which has been added to hotfolder
	 * @param hotEvent The event object
	 */
	public void fileArrived(HotfolderEvent hotEvent);
	
	/**
	 * Event for files which was has been removed from the hotfolder
	 * @param hotEvent The event object
	 */
	public void fileRemoved(HotfolderEvent hotEvent);
}
