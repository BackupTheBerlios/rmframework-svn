/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.form105.rm.base.model.xml;

import com.form105.rm.base.model.parameter.StringParameter;
import org.dom4j.Element;

/**
 * A converter to convert the xml element <code>parameter</code> to a 
 * StringParameter 
 * @author heiko
 */
public class StringParameterXMLConverter implements IXmlConverter<StringParameter> {

    public StringParameter convert(StringParameter result, Element element) {
        
        if (result == null) {
            result = new StringParameter();
        }
        
        String elementId = element.attributeValue("id");
        String name = element.attributeValue("name");
        String value = element.attributeValue("value");
        
        result.setElementId(elementId);
        result.setName(name);
        result.setParameterValue(value);
        return result;
        
    }

    public void processChilds(StringParameter parameter, Element parent) {
       
    }

 

}
