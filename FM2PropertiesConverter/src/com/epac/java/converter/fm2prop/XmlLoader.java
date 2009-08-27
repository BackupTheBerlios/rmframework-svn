package com.epac.java.converter.fm2prop;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

@SuppressWarnings("unchecked")
public class XmlLoader {
	
	private Document document;
	private Element rootElement;
	
	public XmlLoader (String file) throws DocumentException, FileNotFoundException {
		SAXReader reader = new SAXReader();
		FileInputStream iStream = new FileInputStream(file);

        document = reader.read(iStream);
        rootElement = document.getRootElement();
	}
	
	public SectionHandler parseXml(SectionHandler sectionHandler) {
		
		List rowElements = rootElement.elements("Row");
		for (Object rowObject : rowElements) {
			Element rowElement = (Element) rowObject;
			List entryElements = rowElement.elements();
			
			String propertyId = null;
			String propertyValue = null;
			String section = null;
			for (Object entryObject : entryElements) {

				Element entryElement = (Element) entryObject;
				Attribute attribute = entryElement.attribute("Name");
				
				if (attribute.getStringValue().equals("PropertyId")) {
					propertyId = entryElement.attribute("Value").getStringValue();
				} else if (attribute.getStringValue().equals("PropertyValue")) {
					propertyValue = entryElement.attribute("Value").getStringValue();
				} else if (attribute.getStringValue().equals("Section")) {
					section = entryElement.attribute("Value").getStringValue();
				}
				
				
			}
			//System.out.println(propertyId + ":" + propertyValue +":"+section);
			PropertyEntry propEntry = new PropertyEntry(section, propertyId, propertyValue);
			sectionHandler.addPropertyEntryBySection(propEntry);
		}
		
		return sectionHandler;
	}
}
