/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.form105.rm.base.model.xml;

import com.form105.rm.base.model.parameter.IntParameter;
import org.dom4j.Element;

/**
 * A converter to convert the xml element <code>parameter</code> to a 
 * IntParameter 
 * @author heiko
 */
public class IntParameterXMLConverter implements IXmlConverter<IntParameter> {

    public IntParameter convert(IntParameter result, Element element) {
        
        if (result == null) {
            result = new IntParameter();
        }
        
        String elementId = element.attributeValue("id");
        String name = element.attributeValue("name");
        String sValue = element.attributeValue("value");
        
        result.setElementId(elementId);
        result.setName(name);
        result.setParameterValue(new Integer(sValue));
        return result;
        
    }

    public void processChilds(IntParameter source, Element parent) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

 

}
