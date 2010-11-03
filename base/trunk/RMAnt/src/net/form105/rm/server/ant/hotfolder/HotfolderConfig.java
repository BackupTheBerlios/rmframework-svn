package net.form105.rm.server.ant.hotfolder;

import java.util.List;

import net.form105.rm.server.ant.AntAgent;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.XPath;
import org.dom4j.io.SAXReader;

/**
 * The configuration for the hotfolders. Will be read in from a xml file. The xml library used is dom4j. 
 * @author heikok
 *
 */
public class HotfolderConfig {

	public static Logger logger = Logger.getLogger(HotfolderConfig.class);
	private String configFile;
	private Document document;

	public HotfolderConfig(String configFile) {
		this.configFile = configFile;
		this.configure();
		initializeHotFolders();
	}

	/**
	 * Initializes xml reader and loads the root element of the xml document
	 */
	private void configure() {
		SAXReader xmlReader = new SAXReader();
	    try {
			this.document = xmlReader.read(configFile);
			document.getRootElement();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Read in hotfolder structure from xml and create the hotfolder objects. Simple validation is done
	 * by the isValid method from {@link Hotfolder}.  
	 */
	private void initializeHotFolders() {
		// get configuration
		XPath hotfoldersSelector = DocumentHelper.createXPath("//hotfolders");
		List<Element> hotfoldersElementList = hotfoldersSelector.selectNodes(document);
		for (Element element : hotfoldersElementList) {
			XPath hotfolderSelector = DocumentHelper.createXPath("//hotfolder");
			List<Element> hotfolderElementList = hotfolderSelector.selectNodes(element);
			
			HotfolderMap hfMap = new HotfolderMap();
			HotfolderWorker worker = new HotfolderWorker(hfMap);
			
			for (Element hfElement : hotfolderElementList) {
				Hotfolder hFolder = new Hotfolder(hfElement);
				hFolder.addListener(new CreateWorkflowHotfolderListener());
				hFolder.addListener(new DefaultHotfolderListener());
				if (hFolder.isValid()) {
					hfMap.addHotfolder(hFolder);
				} else {
					logger.error("Hotfolder doesn't exist: "+hFolder.getHotfolder());
				}
			}
			
			Thread hotfolderThread = new Thread(worker);
			hotfolderThread.start();
		}
	}
}
