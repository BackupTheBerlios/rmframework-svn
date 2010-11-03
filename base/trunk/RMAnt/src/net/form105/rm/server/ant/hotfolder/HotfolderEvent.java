package net.form105.rm.server.ant.hotfolder;

import java.util.EventObject;

/**
 * The hotfolder event is sent if new file has arrived in a hotfolder or a file has been removed
 * @author heikok
 *
 */
public class HotfolderEvent extends EventObject {
	
	private static final long serialVersionUID = 1806008446708913667L;
	
	private String hotfolderPathName;
	private String fileArrivedPathName;

	/**
	 * 
	 * @param source The file that has been arrived
	 * @param hotfolderPath Path to the hotfolder as a string
	 */
	public HotfolderEvent(Object source, String hotfolderPathName, String fileArrivedPathName) {
		super(source);
		this.hotfolderPathName = hotfolderPathName;
		this.fileArrivedPathName = fileArrivedPathName;
	}
	
	/**
	 * Get the path of the hotfolder where the event has been occurred
	 * @return The path of the hotfolder
	 */
	public String getHotfolderPath() {
		return hotfolderPathName;
	}
	
	/**
	 * Get the path of the file which triggered this flow
	 * @return
	 */
	public String getIncomingFilePath() {
		return fileArrivedPathName;
	}

}
