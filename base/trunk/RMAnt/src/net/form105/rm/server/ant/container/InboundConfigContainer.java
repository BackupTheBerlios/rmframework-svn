package net.form105.rm.server.ant.container;

import java.util.ArrayList;
import java.util.List;

import net.form105.rm.base.container.AbstractContainer;
import net.form105.rm.base.container.PropertiesContainer;
import net.form105.rm.server.ant.hotfolder.AbstractInboundReceiver;
import net.form105.rm.server.ant.hotfolder.HotfolderInboundReceiver;
import net.form105.rm.server.ant.hotfolder.HotfolderWorker;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.XPath;
import org.dom4j.io.SAXReader;
import org.picocontainer.Startable;

/**
 * The configuration for the hotfolders. Will be read in from a xml file. The
 * xml library used is dom4j.
 * 
 * @author heikok
 * 
 */
public class InboundConfigContainer extends AbstractContainer implements Startable {

	public static Logger logger = Logger.getLogger(InboundConfigContainer.class);

	private Document document;
	private PropertiesContainer propContainer;
	private HotfolderWorker worker;

	public InboundConfigContainer(PropertiesContainer propContainer, HotfolderWorker worker) {
		this.propContainer = propContainer;
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

	/**
	 * Read in inbounds structure from xml and create the inbound receiver objects. The receiver objects will be
	 * responsible for the incoming objects. The HotfolderWorker has a simple implementation. It is started here and
	 * should be accessible in a pico container.
	 * Simple validation is done by the isValid method from
	 * {@link HotfolderInboundReceiver}.
	 */
	public void initialize() {
		XPath hotfoldersSelector = DocumentHelper.createXPath("//inbounds");
		List<Element> hotfoldersElementList = hotfoldersSelector.selectNodes(document);
		Element element = hotfoldersElementList.get(0);
		XPath hotfolderSelector = DocumentHelper.createXPath("//inbound");
		List<Element> hotfolderElementList = hotfolderSelector.selectNodes(element);

		List<AbstractInboundReceiver> receivers = new ArrayList<AbstractInboundReceiver>();
		for (Element inboundElement : hotfolderElementList) {
			InboundConfiguration config = new InboundConfiguration();
			config.readXml(inboundElement);
			HotfolderInboundReceiver receiver = new HotfolderInboundReceiver(config);
			receivers.add(receiver);
		}
	}

	@Override
	public void start() {
		configure();
		initialize();
	}

	@Override
	public void stop() {

	}

}
