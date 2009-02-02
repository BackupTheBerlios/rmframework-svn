package net.form105.rm.server.mapping;

import java.util.List;

import net.form105.rm.base.Container;
import net.form105.rm.base.ContainerConfiguration;
import net.form105.rm.base.helper.UniqueIdHelper;
import net.form105.rm.base.mapping.IField;
import net.form105.rm.base.model.ParameterizedElement;
import net.form105.rm.base.model.Resource;
import net.form105.rm.base.util.helper.FileHelper;
import net.form105.rm.base.util.xml.XMLLoader;

import org.dom4j.Document;
import org.dom4j.Element;

/**
 * The template reads a xml file which defines some global variables for a parameterized element. 
 * The xml elements are read by xPath expressions. From here a template sequence will be build by
 * generating a list of @see IField. This sequence will also be generated out of the xml template
 * definition file. 
 * @author hk
 *
 */
public class CSVTemplate implements ITemplate {
	
	private final String id = "CSV_TEMPLATE";
	private Document xmlDocument;
	private ITemplateSequence templateSequence;
	private ParameterizedElement pElement;
	
	private String idPrefix;
	
	/**
	 * Instantiates the template and takes a filename as a parameter. The path
	 * to the template file is prepared from the import path of the application
	 * configuration.
	 * @param templateFileName
	 */
	public CSVTemplate(String templateFileName) {
		XMLLoader xmlLoader = new XMLLoader(getTemplateFile(templateFileName));
		xmlDocument = xmlLoader.parseFile();
		templateSequence = new CSVTemplateSequence(xmlDocument);
		pElement = createParameterizedElement();
	
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public List<IField> getSequence() {
		return templateSequence.getSequenceAsList();
	}
	
	/**
	 * Prepares the complete path to the import folder where the template file resides.
	 * @param templateFileName
	 * @return
	 */
	private String getTemplateFile(String templateFileName) {
		ContainerConfiguration conConfiguration = Container.getInstance().getConfiguration();
		
		String path = FileHelper.appendFileSeparator(conConfiguration.getConfiguration().getImportPath());
		return path+templateFileName;
	}
	
	/**
	 * Creates the @see ParameterizedElement where the parameters will appended to.
	 * @return
	 */
	private ParameterizedElement createParameterizedElement() {
		//XPath xpathSelector = DocumentHelper.createXPath("/mapping/field");
		//List<Element> elements = xpathSelector.selectNodes(rootElement);
		
		ParameterizedElement pElement = new ParameterizedElement() {};
		
		Element rootElement = xmlDocument.getRootElement();
		// resource or order
		String baseType = rootElement.valueOf("/mapping/object/base");
		idPrefix = rootElement.valueOf("/mapping/object/id/prefix");
		String type = rootElement.valueOf("/mapping/object/type");
		String name = rootElement.valueOf("/mapping/object/name");
		
		if (baseType.equals("resource")) {
			pElement = new Resource();
		} else if (type.equals("order")) {
			
		}
		
		
		pElement.setName(name);
		pElement.setType(type);
		return pElement;
	}
	
	public ParameterizedElement getParameterizedElement() {
		pElement.setElementId(idPrefix+"_"+UniqueIdHelper.getId());
		return pElement;
	}

}
