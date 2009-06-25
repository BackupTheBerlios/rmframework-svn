package net.form105.rm.base.mapping.target;



import java.math.BigDecimal;

import net.form105.rm.base.model.parameter.FloatParameter;

import org.apache.log4j.Logger;

public class FloatParameterTarget extends AbstractParameterTarget<FloatParameter> {
	
	public static Logger logger = Logger.getLogger(FloatParameterTarget.class);
	
	private FloatParameter sParameter;
	
	public void setValue(String value) {
		try {
			sParameter.setParameterValue(new BigDecimal(value));
		} catch (NumberFormatException nfe) {
			logger.error("NumberFormatException occurred: Value is "+value);
		}
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
