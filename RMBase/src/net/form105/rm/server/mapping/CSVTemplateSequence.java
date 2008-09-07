package net.form105.rm.server.mapping;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import net.form105.rm.base.mapping.IField;
import net.form105.rm.base.mapping.ITarget;
import net.form105.rm.base.mapping.MapperControl;
import net.form105.rm.base.mapping.SimpleField;
import net.form105.rm.base.util.xml.XMLLoader;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.XPath;

public class CSVTemplateSequence implements ITemplateSequence {

	public static Logger logger = Logger.getLogger(CSVTemplateSequence.class);
	private final String id = "CSV_SEQUENCE_TEMPLATE";
	private Document document;
	private Element rootElement;
	private MapperControl control;
	
	
	/* (non-Javadoc)
	 * @see net.form105.rm.server.mapping.ITemplateSequence#getId()
	 */
	public String getId() {
		return id;
	}

	public CSVTemplateSequence(String mappingFileName) {
		XMLLoader xmlLoader = new XMLLoader(mappingFileName);
		document = xmlLoader.parseFile();

	}

	/**
	 * Creates a List of the template fields
	 * @return
	 */
	public List<IField> createTemplateFields() {
		rootElement = document.getRootElement();
		XPath xpathSelector = DocumentHelper.createXPath("/mapping/field");
		List<Element> elements = xpathSelector.selectNodes(rootElement);
		
		ArrayList<IField> fieldSequence = new ArrayList();
		
		for (Element fieldElement : elements) {
			SimpleField field = new SimpleField(resolveField(fieldElement));
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
	private ITarget<?> resolveField(Element fieldElement) {

		List<Element> methodElements = fieldElement.elements();
		String className = fieldElement.attributeValue("class");
		Object targetObject = getObjectByClassName(className);

		for (Element element : methodElements) {
			String methodName = element.getName();
			String methodValue = element.getStringValue();
			
			setValueByMethod(targetObject, methodName, methodValue);
		}
		
		return ITarget.class.cast(targetObject);
	}

	/**
	 * Gets an object by the class attribute of the xml field definition. The object is retrieved by
	 * reflection.
	 * @param className
	 * @return
	 */
	private Object getObjectByClassName(String className) {
		Object targetObject = null;

		try {
			Class<?> clazz = Class.forName(className);
			targetObject = clazz.newInstance();
			if (!(targetObject instanceof ITarget)) {
				logger.error("The mapping target isn't instance of ITarget");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return targetObject;
	}

	/**
	 * Sets the default values of the introspected class and sets the default values
	 * @param targetObject
	 * @param methodName
	 * @param methodValue
	 */
	private void setValueByMethod(Object targetObject, String methodName, String methodValue) {
		Class<?>[] types = new Class[] { String.class };
		Method method;

		try {
			method = targetObject.getClass().getMethod(methodName, types);
			method.invoke(targetObject, methodValue);

		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

	}
	
	/* (non-Javadoc)
	 * @see net.form105.rm.server.mapping.ITemplateSequence#getSequence()
	 */
	public List<IField> getSequence() {
		return createTemplateFields();
	}
	
	public void register() {
		control.registerTemplate(this);
	}
	
	public void unregister() {
		control.unregisterTemplate(this);
	}
}
