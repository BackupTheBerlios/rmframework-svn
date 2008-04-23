/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.form105.rm.base.model.xml;

import com.form105.rm.base.model.Resource;
import com.form105.rm.base.model.parameter.IntParameter;
import com.form105.rm.base.model.parameter.StringParameter;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.dom4j.Element;

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
        List<Element> elements = parent.elements("parameter");
        processStringParameterChild(source, parent, elements);
        processIntParameterChild(source, parent, elements);
    }

    private void processStringParameterChild(Resource resource, Element parent, List<Element> elements) {
        logger.info("Loading string parameters: " + elements.size());
        for (Element element : elements) {
            if (element.attributeValue("type").equals("string")) {
                StringParameter sParameter = new StringParameter();
                if (sParameter instanceof IXmlLoadable) {
                    childList.add(sParameter);
                    sParameter.load(new StringParameterXMLConverter(), element);
                    resource.addParameter(sParameter);
                    logger.info("Parameter added");
                }
            }

        }
    }

    private void processIntParameterChild(Resource resource, Element parent,  List<Element> elements) {
        logger.info("Loading integer parameters: " + elements.size());
        for (Element element : elements) {
            IntParameter iParameter = new IntParameter();
            if (iParameter instanceof IXmlLoadable) {
                childList.add(iParameter);
                iParameter.load(new IntParameterXMLConverter(), element);
                resource.addParameter(iParameter);
            }

        }
    }
}
