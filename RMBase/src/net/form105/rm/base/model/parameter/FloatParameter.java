/*
* Copyright (c) 2008, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/

package net.form105.rm.base.model.parameter;

import java.math.BigDecimal;

import javax.persistence.Entity;

import net.form105.rm.base.model.xml.IXmlConverter;
import net.form105.rm.base.model.xml.IXmlLoadable;

import org.dom4j.Element;

/**
 *
 * @author hk
 */

@Entity
public class FloatParameter extends AbstractParameter<BigDecimal> implements IXmlLoadable<FloatParameter> {
    
	private static final long serialVersionUID = 1L;
	private BigDecimal parameterValue;

    public BigDecimal getParameterValue() {
        return parameterValue;
    }

    @Override
    public void setParameterValue(BigDecimal value) {
        this.parameterValue = value;
    }

    @Override
    public String getValueAsString() {
        return parameterValue.toEngineeringString();
    }

    public void fromDom(Element element) {
        String elementId = element.attributeValue("id");
        String value = element.attributeValue("value");
        BigDecimal decimalValue = new BigDecimal(value);
        setElementId(elementId);
        setParameterValue(decimalValue);
        
    }

    public FloatParameter load(IXmlConverter converter, Element element) {
        converter.convert(this, element);
        return this;
    }
    
}
