/*
* Copyright (c) 2008, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/

package net.form105.rm.base.model.parameter;


/**
 * A parameter represents a double value
 * @author hk
 */

public class DoubleParameter extends AbstractParameter<Double> {

    private static final long serialVersionUID = 1L;

    private Double parameterValue;
    
    public DoubleParameter(String id, String name, Double value) {
    	setElementId(id);
    	setName(name);
    	setParameterValue(value);
    }

    public Double getParameterValue() {
        return parameterValue;
    }

    @Override
    public void setParameterValue(Double value) {
        this.parameterValue = value;
    }

    @Override
    public String getValueAsString() {
        return parameterValue.toString();
    }

}
