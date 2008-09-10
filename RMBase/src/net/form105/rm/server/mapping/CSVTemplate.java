package net.form105.rm.server.mapping;

import java.util.List;

import net.form105.rm.base.Container;
import net.form105.rm.base.ContainerConfiguration;
import net.form105.rm.base.helper.FileHelper;
import net.form105.rm.base.helper.UniqueIdHelper;
import net.form105.rm.base.mapping.IField;
import net.form105.rm.base.model.ParameterizedElement;
import net.form105.rm.base.model.Resource;
import net.form105.rm.base.util.xml.XMLLoader;

import org.dom4j.Document;
import org.dom4j.Element;

/**
 * A template csv lines. A line will be mapped to a @see Resource
 * @author hk
 *
 */
public class CSVTemplate implements ITemplate {
	
	private final String id = "CSV_TEMPLATE";
	private Document xmlDocument;
	private ITemplateSequence templateSequence;
	private ParameterizedElement pElement;
	
	
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
	
	private String getTemplateFile(String templateFileName) {
		ContainerConfiguration conConfiguration = Container.getInstance().getConfiguration();
		
		String path = FileHelper.appendFileSeparator(conConfiguration.getConfiguration().getImportPath());
		return path+templateFileName;
	}
	
	private ParameterizedElement createParameterizedElement() {
		//XPath xpathSelector = DocumentHelper.createXPath("/mapping/field");
		//List<Element> elements = xpathSelector.selectNodes(rootElement);
		
		ParameterizedElement pElement = new ParameterizedElement() {};
		
		Element rootElement = xmlDocument.getRootElement();
		// resource or order
		String baseType = rootElement.valueOf("/mapping/object/base");
		String idPrefix = rootElement.valueOf("/mapping/object/id/prefix");
		String idStartNumberType = rootElement.valueOf("/mapping/object/id/startNumber");
		String type = rootElement.valueOf("/mapping/object/type");
		String name = rootElement.valueOf("/mapping/object/name");
		
		String department = rootElement.valueOf("/mapping/object/devision");
		
		if (baseType.equals("resource")) {
			pElement = new Resource();
		} else if (type.equals("order")) {
			
		}
		
		pElement.setElementId(idPrefix+UniqueIdHelper.getId());
		pElement.setName(name);
		pElement.setType(type);
		return pElement;
	}
	
	public ParameterizedElement getParameterizedElement() {
		return pElement;
	}

}
