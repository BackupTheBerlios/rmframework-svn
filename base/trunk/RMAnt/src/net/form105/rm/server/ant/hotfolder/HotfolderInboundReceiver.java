package net.form105.rm.server.ant.hotfolder;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.form105.rm.server.ant.container.InboundConfiguration;

import org.apache.log4j.Logger;

/**
 * The hotfolder is a configurable directory which reacts on files that will be
 * dropped in and removed from the directory. Listeners can be added to get be
 * notified by events of removing and adding files. Validators can be added to
 * check for the environment of the folder. These validators shouldn't be use
 * for the files that are dropped in. They should be used to validate the folder
 * at startup.
 * 
 * @author heikok
 * 
 */
public class HotfolderInboundReceiver extends AbstractInboundReceiver {

	public static Logger logger = Logger
			.getLogger(HotfolderInboundReceiver.class);

	private String hotfolderPathName;
	private Map<File, InboundObject> trackContentMap = new HashMap<File, InboundObject>();


	private boolean sendEvents = false;

	public HotfolderInboundReceiver(InboundConfiguration config) {
		super(config);
	}

	/**
	 * Compares the real content of the hotfolder with the tracked one. Sends
	 * events for added or removed files to the {@link IInboundListener}.
	 */
	public void prepareInboundObjects() {
		File hotFolder = new File(hotfolderPathName);
		File[] contentFiles = hotFolder.listFiles();
		for (File contentFile : contentFiles) {

			if (!trackContentMap.containsKey(contentFile)
					&& !contentFile.isHidden()) {
				logger.info("Adding file for tracking: " + contentFile);
				String hotfolderName = getConfiguration().getParameter("hotfolder");
				String tempHotfolderName = getConfiguration().getParameter("tempHotfolder");
				HotfolderInboundObject inObject = new HotfolderInboundObject(
						contentFile, tempHotfolderName);
				inObject.setHotfolderName(hotfolderName);
				trackContentMap.put(contentFile, inObject);
				if (sendEvents)
					notifyInbound(inObject);

			}
		}

		List<File> contentFileList = Arrays.asList(contentFiles);
		List<File> removeList = new ArrayList<File>();

		for (File trackFile : trackContentMap.keySet()) {
			if (!contentFileList.contains(trackFile)) {
				removeList.add(trackFile);
				if (sendEvents) notifyInboundClear(trackContentMap.get(trackFile));
			}
		}

		for (File removeFile : removeList) {
			trackContentMap.remove(removeFile);
			logger.info("Removing file from tracking: " + removeFile);
		}
	}

	/**
	 * Check if it is a real file
	 */
	public boolean isValid() {
		File hotFolderFile = new File(hotfolderPathName);
		if (hotFolderFile.isFile()) {
			logger.error("Hotfolder is a file");
			return false;
		}
		if (!hotFolderFile.exists()) {
			logger.error("Hotfolder doesn't exist");
			return false;
		}
		return true;
	}

}
