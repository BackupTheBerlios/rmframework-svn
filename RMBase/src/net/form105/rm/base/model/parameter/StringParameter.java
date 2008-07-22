/*
* Copyright (c) 2008, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/

package net.form105.rm.base.model.parameter;

import javax.persistence.Entity;

import net.form105.rm.base.model.xml.IXmlConverter;
import net.form105.rm.base.model.xml.IXmlLoadable;

import org.dom4j.Element;

/**
 *
 * @author heiko
 */

@Entity
public class StringParameter extends AbstractParameter<String> implements IXmlLoadable {
    
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

    public StringParameter load(IXmlConverter converter, Element element) {
        converter.convert(this, element);
        return this;
    }
    
}
