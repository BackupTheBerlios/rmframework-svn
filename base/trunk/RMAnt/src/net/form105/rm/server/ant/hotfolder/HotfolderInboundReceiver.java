package net.form105.rm.server.ant.hotfolder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.form105.rm.base.validator.IInboundValidator;
import net.form105.rm.server.ant.config.ConfigParameterMap;
import net.form105.rm.server.ant.container.InboundConfiguration;

import org.apache.log4j.Logger;
import org.picocontainer.Startable;

import com.sun.tools.javac.code.Attribute.Array;

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
public class HotfolderInboundReceiver extends AbstractInboundReceiver implements IInboundHandler, Startable {

	public static Logger logger = Logger.getLogger(HotfolderInboundReceiver.class);

	private String hotfolderPathName;
	private Map<File, IInboundObject> trackContentMap = new HashMap<File, IInboundObject>();
	

	
	private String tempFolderPathName;
	
	private InboundConfiguration config;
	
	private boolean sendEvents = false;
	

	public HotfolderInboundReceiver(List<IInboundListener> inboundListenerList, List<IInboundValidator> validatorList, ConfigParameterMap paramMap) {
		super(inboundListenerList, validatorList, paramMap);
		getInbounds();
	}

	/**
	 * Compares the real content of the hotfolder with the tracked one. Sends
	 * events for added or removed files to the {@link IInboundListener}.
	 */
	public void prepareInboundObjects() {
		File hotFolder = new File(hotfolderPathName);
		File[] contentFiles = hotFolder.listFiles();
		for (File contentFile : contentFiles) {

			if (!trackContentMap.containsKey(contentFile) && !contentFile.isHidden()) {
				logger.info("Adding file for tracking: " + contentFile);
				String hotfolderName = config.getParameter("hotfolder");
				String tempHotfolderName = config.getParameter("tempHotfolder");
				HotfolderInboundObject inObject = new HotfolderInboundObject(contentFile, tempHotfolderName);
				inObject.setHotfolderName(hotfolderName);
				trackContentMap.put(contentFile, inObject);
				if (sendEvents)
					try {
						notifyInbound(inObject);
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
		}

		List<File> contentFileList = Arrays.asList(contentFiles);
		List<File> removeList = new ArrayList<File>();

		for (File trackFile : trackContentMap.keySet()) {
			if (!contentFileList.contains(trackFile)) {
				removeList.add(trackFile);
				if (sendEvents)
					try {
						notifyInboundClear(trackContentMap.get(trackFile));
					} catch (IOException e) {
						e.printStackTrace();
					}
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
