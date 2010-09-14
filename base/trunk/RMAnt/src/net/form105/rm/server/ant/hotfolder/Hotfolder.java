package net.form105.rm.server.ant.hotfolder;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.form105.rm.base.Agent;
import net.form105.rm.base.validator.IValidator;
import net.form105.rm.server.ant.AntAgent;
import net.form105.rm.server.ant.executor.AntRunner;

import org.apache.log4j.Logger;
import org.dom4j.Element;

public class Hotfolder implements Runnable {

	public static Logger logger = Logger.getLogger(Hotfolder.class);

	private File hotFolder;
	private List<File> trackContentList = new ArrayList<File>();
	private List<IValidator<File>> validatorList = new ArrayList<IValidator<File>>();
	
	private AntRunner antRunner;

	public Hotfolder() {

	}

	public Hotfolder(Element element) {
		initByXml(element);
	}

	/**
	 * Compares the real content of the hotfolder with the tracked one Sends an
	 * event to a listener
	 */
	public void compareContent() {
		File[] contentFiles = hotFolder.listFiles();
		for (File contentFile : contentFiles) {
			
			if (!trackContentList.contains(contentFile) && !contentFile.isHidden()) {
				logger.info("Adding file to tracking: " + contentFile);
				trackContentList.add(contentFile);
			}
		}

		List<File> contentFileList = Arrays.asList(contentFiles);
		List<File> removeList = new ArrayList<File>();

		for (File trackFile : trackContentList) {
			if (!contentFileList.contains(trackFile)) {
				removeList.add(trackFile);
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
			compareContent();
			try {
				Thread.sleep(500);
				logger.info("Thread running "+System.currentTimeMillis());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void addValidator(IValidator<File> validator) {
		validatorList.add(validator);
	}

	protected void initByXml(Element element) {
		Element filePathElement = element.element("path");
		this.hotFolder = new File(filePathElement.getStringValue());
		for (Element valElement : (List<Element>) element.elements("validator")) {
			String validatorId = valElement.getStringValue();
			IValidator<File> validator = (IValidator<File>) Agent.getComponentById(validatorId);
			addValidator(validator);
		}
		Element execElement = element.element("executor");
		String executorId = execElement.element("id").getStringValue();
		antRunner = (AntRunner) AntAgent.getContainer(executorId);
	}
	
	/**
	 * Checks if the kind of type of file
	 */
	protected boolean isValid() {
		
		if (hotFolder.isFile()) {
			logger.error("Hotfolder is a file");
			return false;
		}
		if (! hotFolder.exists()) {
			logger.error("Hotfolder doesn't exist");
			return false;
		}
		return true;
	}

	/**
	 * @return the hotFolder
	 */
	public File getFolder() {
		return hotFolder;
	}

}
