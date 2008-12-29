/*
* Copyright (c) 2008, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/

package net.form105.rm.base.model.parameter;

import javax.persistence.Entity;

import net.form105.xml.schema.model.ParameterDocument.Parameter;

import org.apache.xmlbeans.XmlObject;

/**
 *
 * @author hk
 */

@Entity
public class StringParameter extends AbstractParameter<String> {

    private static final long serialVersionUID = 1L;

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

    public IParameter loadFromXml(XmlObject xmlObject) {
        Parameter parameter = (Parameter) xmlObject;
        this.setElementId(parameter.getId());
        this.setName(parameter.getName());
        this.setParameterValue(parameter.getValue());
        return this;
    }

}
