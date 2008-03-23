/*
* Copyright (c) 2008, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/

package com.form105.rm.base.model.parameter;

import com.form105.rm.base.model.xml.IXmlConverter;
import javax.persistence.Entity;
import org.dom4j.Element;

/**
 *
 * @author heiko
 */

@Entity
public class StringParameter extends AbstractParameter<String> implements IXmlConverter {
    
    private String parameterValue;

    public String getParameterValue() {
        return parameterValue;
    }

    @Override
    public void setParameterValue(String value) {
        this.parameterValue = value;
    }

    @Override
    public String getValueAsString() {
        return parameterValue;
    }

    public void fromDom(Element element) {
        String elementId = element.attributeValue("id");
        String value = element.attributeValue("value");
        setElementId(elementId);
        setParameterValue(value);
        
    }
    
}
