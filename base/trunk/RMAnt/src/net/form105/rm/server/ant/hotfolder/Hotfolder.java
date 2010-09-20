package net.form105.rm.server.ant.hotfolder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.form105.rm.base.Agent;
import net.form105.rm.base.validator.IValidator;
import net.form105.rm.server.ant.executor.AntRunner;
import net.form105.rm.server.ant.validator.ValidationHandler;

import org.apache.log4j.Logger;
import org.dom4j.Element;

import sun.awt.windows.ThemeReader;

public class Hotfolder implements Runnable {

	public static Logger logger = Logger.getLogger(Hotfolder.class);

	private String hotFolderPathName;
	private List<File> trackContentList = new ArrayList<File>();
	private List<IValidator<File>> validatorList = new ArrayList<IValidator<File>>();

	private List<HotfolderListener> eListenerList = new ArrayList<HotfolderListener>();

	private ValidationHandler<File> validationHandler = new ValidationHandler<File>();

	public Hotfolder() {

	}

	public Hotfolder(Element element) {
		initByXml(element);
	}

	/**
	 * Compares the real content of the hotfolder with the tracked one. Sends events for added or removed files
	 * to the {@link HotfolderListener}.
	 * event to a listener
	 */
	public void compareContent(boolean sendEvents) {
		File hotFolder = new File(hotFolderPathName);
		File[] contentFiles = hotFolder.listFiles();
		for (File contentFile : contentFiles) {

			if (!trackContentList.contains(contentFile) && !contentFile.isHidden()) {
				logger.info("Adding file to tracking: " + contentFile);
				trackContentList.add(contentFile);
				if (sendEvents) notifyFileArrived(contentFile);
			}
		}

		List<File> contentFileList = Arrays.asList(contentFiles);
		List<File> removeList = new ArrayList<File>();

		for (File trackFile : trackContentList) {
			if (!contentFileList.contains(trackFile)) {
				removeList.add(trackFile);
				if (sendEvents)  notifyFileRemoved(trackFile);
			}
		}

		for (File removeFile : removeList) {
			trackContentList.remove(removeFile);
			logger.info("Removing file from tracking: " + removeFile);
		}
	}

	@Override
	public void run() {

		while (true) {
			// TODO: validationHandler.runValidation(object, validationList)
			compareContent(true);
			try {
				Thread.sleep(500);
				logger.info("Thread running " + System.currentTimeMillis());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Add a validator to the hotfolder. The validator checks for environment
	 * and precondition of the hotfolder. The validator shouldn't be used for
	 * incoming file checks. TODO: add file as parameter
	 * 
	 * @param validator
	 */
	public void addValidator(IValidator<File> validator) {
		validatorList.add(validator);
	}

	@SuppressWarnings("unchecked")
	protected void initByXml(Element element) {
		Element filePathElement = element.element("path");
		this.hotFolderPathName = filePathElement.getStringValue();
		for (Element valElement : (List<Element>) element.elements("validator")) {
			String validatorId = valElement.getStringValue();
			// IValidator<File> validator = (IValidator<File>)
			// Agent.getComponentById(validatorId);
			IValidator<File> validator = (IValidator<File>) Agent.getComponentById(validatorId);
			addValidator(validator);
		}
		Element execElement = element.element("execution");
		String executorId = execElement.element("id").getStringValue();
		logger.info("Executor id: " + executorId);
		AntRunner antRunner = (AntRunner) Agent.getComponentById(executorId);
		this.addListener(antRunner);
		compareContent(false);

	}

	/**
	 * Checks if the kind of type of file
	 */
	protected boolean isValid() {
		File hotFolderFile = new File(hotFolderPathName);
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

	/**
	 * Get the path and filename of the hotfolder
	 * 
	 * @return the hotFolder as a {@link String}
	 */
	public String getHotfolder() {
		return hotFolderPathName;
	}

	/**
	 * Add a listener to the {@link Hotfolder} instance
	 * 
	 * @param listener
	 */
	public void addListener(HotfolderListener listener) {
		eListenerList.add(listener);
	}

	/**
	 * Remove a listener from the {@link Hotfolder} instance
	 * 
	 * @param listener
	 */
	public void removeListener(HotfolderListener listener) {
		eListenerList.remove(listener);
	}

	/**
	 * Create and send the events in case of file changes on the hotfolders.
	 * 
	 * @param file
	 *            The file which has been arrived
	 */
	public void notifyFileArrived(File file) {
		String filePathName = null;
		try {
			filePathName = file.getCanonicalPath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		HotfolderEvent event = new HotfolderEvent(filePathName, hotFolderPathName);
		for (HotfolderListener listener : eListenerList) {
			listener.fileArrived(event);
		}
	}

	/**
	 * Create and send the events in case of file changes on the hotfolders.
	 * 
	 * @param file
	 *            The file which has been removed
	 */
	public void notifyFileRemoved(File file) {
		String filePathName = null;
		try {
			filePathName = file.getCanonicalPath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		HotfolderEvent event = new HotfolderEvent(filePathName, hotFolderPathName);
		for (HotfolderListener listener : eListenerList) {
			listener.fileRemoved(event);
		}
	}

}
