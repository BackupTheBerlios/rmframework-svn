package net.form105.rm.base.mapping.target;



import java.math.BigDecimal;

import net.form105.rm.base.model.parameter.FloatParameter;

public class FloatParameterTarget extends AbstractParameterTarget<FloatParameter> {
	
	private FloatParameter sParameter;
	
	public void setValue(String value) {
		sParameter.setParameterValue(new BigDecimal(value));
	}
	
	public FloatParameter getTargetObject() {
		return sParameter;
	}
	
	public FloatParameter createTargetInstance() {
		FloatParameter newParameter = new FloatParameter();
		newParameter.setElementId(super.getElementId());
		newParameter.setName(super.getName());
		sParameter = newParameter;
		return newParameter;
	}
}
