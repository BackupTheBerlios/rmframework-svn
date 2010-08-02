/*
* Copyright (c) 2008, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/

package net.form105.rm.base.model.parameter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author hk
 */

public class FloatParameter extends AbstractParameter<BigDecimal> implements Serializable {
    
	private static final long serialVersionUID = 1L;
	private BigDecimal parameterValue;
	
	public FloatParameter() {}

	public FloatParameter(BigDecimal decimal) {
		this.parameterValue = decimal;
	}
	
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
}
