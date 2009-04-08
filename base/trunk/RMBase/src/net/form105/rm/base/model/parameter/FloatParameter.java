/*
* Copyright (c) 2008, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/

package net.form105.rm.base.model.parameter;

import java.math.BigDecimal;

import net.form105.rm.base.model.IXmlObjectLoadable;
import net.form105.xml.schema.model.ParameterDocument.Parameter;

import org.apache.xmlbeans.XmlObject;

/**
 *
 * @author hk
 */

public class FloatParameter extends AbstractParameter<BigDecimal> implements IXmlObjectLoadable<IParameter> {
    
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

    @Override
    public IParameter loadFromXml(XmlObject xmlObject) {
            Parameter parameter = (Parameter) xmlObject;
            this.setElementId(parameter.getId());
            this.setName(parameter.getName());
            BigDecimal floatValue = new BigDecimal(parameter.getValue());
            this.setParameterValue(floatValue);
            return this;
    }

    
    
}
