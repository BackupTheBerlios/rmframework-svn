package net.form105.rm.server.ant.container;

import java.util.List;

import net.form105.rm.base.Agent;
import net.form105.rm.base.container.AbstractContainer;
import net.form105.rm.base.container.PropertiesContainer;
import net.form105.rm.server.ant.hotfolder.CreateTempEnvironmentListener;
import net.form105.rm.server.ant.hotfolder.CreateWorkflowHotfolderListener;
import net.form105.rm.server.ant.hotfolder.DefaultHotfolderListener;
import net.form105.rm.server.ant.hotfolder.HotfolderInboundReceiver;
import net.form105.rm.server.ant.hotfolder.HotfolderWorker;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.XPath;
import org.dom4j.io.SAXReader;
import org.picocontainer.PicoContainer;

/**
 * The configuration for the hotfolders. Will be read in from a xml file. The xml library used is dom4j. 
 * @author heikok
 *
 */
public class InboundConfigContainer extends AbstractContainer {

	public static Logger logger = Logger.getLogger(InboundConfigContainer.class);
	
	private Document document;
	private PropertiesContainer propContainer;
	private HotfolderContainer hfContainer;

	public InboundConfigContainer(PropertiesContainer propContainer, HotfolderContainer hfContainer) {
		this.propContainer = propContainer;
		this.hfContainer = hfContainer;
	}

	/**
	 * Initializes xml reader and loads the root element of the xml document
	 */
	private void configure() {
		SAXReader xmlReader = new SAXReader();
	    try {
			this.document = xmlReader.read(propContainer.getProperty("hotfolder.configFile"));
			document.getRootElement();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
	
	public void readConfig() {
		
		XPath inboundsSelector = DocumentHelper.createXPath("/inbounds/inbound");
		List<Node> inboundNodes = (List<Node>) inboundsSelector.selectNodes(document); 
		
		for (Node node : inboundNodes) {
			InboundConfiguration config = new InboundConfiguration();
			config.readXml(node);
			IInboundHandler inboundHandler= Agent.getComponentById(node.valueOf("@type"));
			
		}
	}
	
	/**
	 * Read in hotfolder structure from xml and create the hotfolder objects. Simple validation is done
	 * by the isValid method from {@link HotfolderInboundReceiver}.  
	 */
	public void initialize() {
		// get configuration
		
		
		XPath hotfoldersSelector = DocumentHelper.createXPath("//inbounds");
		List<Element> hotfoldersElementList = hotfoldersSelector.selectNodes(document);
		for (Element element : hotfoldersElementList) {
			XPath hotfolderSelector = DocumentHelper.createXPath("//inbound");
			List<Element> hotfolderElementList = hotfolderSelector.selectNodes(element);
			
			
			HotfolderWorker worker = new HotfolderWorker();
			
			for (Element hfElement : hotfolderElementList) {
				HotfolderInboundReceiver hFolder = new HotfolderInboundReceiver(hfElement, tempBuildFolder);
				hFolder.addListener(new CreateWorkflowHotfolderListener());
				hFolder.addListener(new CreateTempEnvironmentListener());
				DefaultHotfolderListener hfListener = (DefaultHotfolderListener) Agent.getComponentById("hotfolderListener");
				hFolder.addListener(hfListener);
				
				if (hFolder.isValid()) {
					hfContainer.addHotfolder(hFolder);
				} else {
					logger.error("Hotfolder doesn't exist: "+hFolder.getHotfolder());
				}
			}
			
			Thread hotfolderThread = new Thread(worker);
			hotfolderThread.start();
		}
	}

	@Override
	public void start() {
		
		configure();
		initializeHotFolders();
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}
	
	public void getInboundHandler() {
		
	}

}
