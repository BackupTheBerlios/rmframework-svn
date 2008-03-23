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
public class IntParameter extends AbstractParameter<Integer> implements IXmlConverter {
    
    private Integer parameterValue;

    public Integer getParameterValue() {
        return parameterValue;
    }

    @Override
    public void setParameterValue(Integer value) {
        this.parameterValue = value;
    }

    @Override
    public String getValueAsString() {
        return parameterValue.toString();
    }

    public void fromDom(Element element) {
        String elementId = element.attributeValue("id");
        String stringValue = element.attributeValue("value");
        
        Integer value = Integer.parseInt(stringValue);
        
        setElementId(elementId);
        setParameterValue(value);
        
    }
    
}
