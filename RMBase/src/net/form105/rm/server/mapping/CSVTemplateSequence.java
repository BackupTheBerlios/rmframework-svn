package net.form105.rm.server.mapping;

import java.util.ArrayList;
import java.util.List;

import net.form105.rm.base.helper.ReflectionHelper;
import net.form105.rm.base.mapping.IField;
import net.form105.rm.base.mapping.ITarget;
import net.form105.rm.base.mapping.SimpleField;
import net.form105.rm.base.model.parameter.IParameter;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.XPath;

public class CSVTemplateSequence implements ITemplateSequence {

	public static Logger logger = Logger.getLogger(CSVTemplateSequence.class);
	private final String id = "CSV_TEMPLATE";
	private Element rootElement;
	private List<IField> fieldList;
	
	
	/* (non-Javadoc)
	 * @see net.form105.rm.server.mapping.ITemplateSequence#getId()
	 */
	public String getId() {
		return id;
	}

	public CSVTemplateSequence(Document document) {
		rootElement = document.getRootElement();
		fieldList = createTemplateFields();

	}

	/**
	 * Creates a List of the template fields
	 * @return
	 */
	public List<IField> createTemplateFields() {
		XPath xpathSelector = DocumentHelper.createXPath("/mapping/field");
		List<Element> elements = xpathSelector.selectNodes(rootElement);
		
		ArrayList<IField> fieldSequence = new ArrayList<IField>();
		
		for (Element fieldElement : elements) {
			ITarget<IParameter> target = resolveField(fieldElement);
			target.createTargetInstance();
			SimpleField field = new SimpleField(target);
			
			fieldSequence.add(field);
		}
		return fieldSequence;
	}

	/**
	 * Takes a xml element which defines the field an creates the target which is the object a setValue
	 * method is provided for the direct mapping of values
	 * @param fieldElement
	 * @return
	 */
	private ITarget<IParameter> resolveField(Element fieldElement) {

		List<Element> methodElements = fieldElement.elements();
		String className = fieldElement.attributeValue("class");
		Object targetObject = ReflectionHelper.getObjectByClassName(className);

		for (Element element : methodElements) {
			String methodName = element.getName();
			String methodValue = element.getStringValue();
			
			ReflectionHelper.setStringValueByMethod(targetObject, methodName, methodValue);
		}
		
		return ITarget.class.cast(targetObject);
	}


	/* (non-Javadoc)
	 * @see net.form105.rm.server.mapping.ITemplateSequence#getSequence()
	 */
	@Override
	public List<IField> getSequenceAsList() {
		return fieldList;
	}
	
}
