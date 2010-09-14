package net.form105.rm.server.ant.hotfolder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.form105.rm.base.Agent;
import net.form105.rm.base.validator.IValidator;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.XPath;
import org.dom4j.io.SAXReader;

public class HotfolderConfig {

	public static Logger logger = Logger.getLogger(HotfolderConfig.class);
	private String configFile;
	private Document document;
	private List<Hotfolder> hotfoldersList = new ArrayList<Hotfolder>();

	public HotfolderConfig(String configFile) {
		this.configFile = configFile;
		this.configure();
		initializeHotFolders();
	}

	private void configure() {
		
		SAXReader xmlReader = new SAXReader();
	    try {
			this.document = xmlReader.read(configFile);
			document.getRootElement();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
	private void initializeHotFolders() {
		// get configuration
		XPath hotfoldersSelector = DocumentHelper.createXPath("//hotfolders");
		List<Element> hotfoldersElementList = hotfoldersSelector.selectNodes(document);
		for (Element element : hotfoldersElementList) {
			XPath hotfolderSelector = DocumentHelper.createXPath("//hotfolder");
			List<Element> hotfolderElementList = hotfolderSelector.selectNodes(element);
			
			for (Element hfElement : hotfolderElementList) {
				Hotfolder hFolder = new Hotfolder(hfElement);
				if (hFolder.isValid()) {
					Thread hotfolderThread = new Thread(hFolder);
					hotfolderThread.start();
					
				} else {
					logger.error("Hotfolder doesn't exist: "+hFolder.getFolder());
				}
			}
		}
	}
}
