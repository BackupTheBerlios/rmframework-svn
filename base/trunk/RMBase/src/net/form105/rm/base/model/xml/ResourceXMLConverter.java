/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.form105.rm.base.model.xml;

import java.util.ArrayList;
import java.util.List;

import net.form105.rm.base.model.Resource;
import net.form105.rm.base.model.parameter.IntParameter;
import net.form105.rm.base.model.parameter.StringParameter;

import org.apache.log4j.Logger;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.XPath;

/**
 *
 * @author heiko
 */
public class ResourceXMLConverter implements IXmlConverter<Resource> {

    public static Logger logger = Logger.getLogger(ResourceXMLConverter.class);
    private Resource resource;
    private List<IXmlLoadable> childList = new ArrayList<IXmlLoadable>();

    public Resource convert(Resource resource, Element element) {
        this.resource = resource;
        String id = element.attributeValue("id");
        String name = element.attributeValue("name");
        String type = element.attributeValue("type");

        resource.setElementId(id);
        resource.setName(name);
        resource.setType(type);

        processChilds(resource, element);

        return resource;
    }

    public void processChilds(Resource source, Element parent) {
        processStringParameterChild(source, parent);
        processIntParameterChild(source, parent);
    }

    private void processStringParameterChild(Resource resource, Element parent) {
    	XPath xpathSelector = DocumentHelper.createXPath("//parameter[@type='string']");
        List<Element> elements = xpathSelector.selectNodes(parent);
        for (Element element : elements) {
        	StringParameter sParameter = new StringParameter();
        	sParameter.load(new StringParameterXMLConverter(), element);
        	resource.addParameter(sParameter);
        }

    }

    private void processIntParameterChild(Resource resource, Element parent) {

    	XPath xpathSelector = DocumentHelper.createXPath("//parameter[@type='int']");
        List<Element> elements = xpathSelector.selectNodes(parent);
        for (Element element : elements) {
        	IntParameter sParameter = new IntParameter();
        	sParameter.load(new IntParameterXMLConverter(), element);
        	resource.addParameter(sParameter);
        }
    }
}
