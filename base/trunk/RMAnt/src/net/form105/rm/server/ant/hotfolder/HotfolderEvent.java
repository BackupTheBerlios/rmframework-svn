package net.form105.rm.server.ant.hotfolder;

import java.util.EventObject;

/**
 * The hotfolder event is sent if new file has arrived in a hotfolder or a file has been removed
 * @author heikok
 *
 */
public class HotfolderEvent extends EventObject {
	
	private static final long serialVersionUID = 1806008446708913667L;
	
	private String hotfolderPath;

	/**
	 * 
	 * @param source The file that has been arrived
	 * @param hotfolderPath Path to the hotfolder as a string
	 */
	public HotfolderEvent(Object source, String hotfolderPath) {
		super(source);
		this.hotfolderPath = hotfolderPath;
	}
	
	/**
	 * Get the path of the hotfolder where the event has been occurred
	 * @return The path of the hotfolder
	 */
	public String getHotfolderPath() {
		return hotfolderPath;
	}

}
