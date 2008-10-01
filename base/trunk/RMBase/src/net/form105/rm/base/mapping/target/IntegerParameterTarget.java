package net.form105.rm.base.mapping.target;



import net.form105.rm.base.model.parameter.IntParameter;

import org.apache.log4j.Logger;

public class IntegerParameterTarget extends AbstractParameterTarget<IntParameter> {
	
	public static Logger logger = Logger.getLogger(IntegerParameterTarget.class);
	
	private IntParameter sParameter;
	
	public void setValue(String value) {
		try {
			sParameter.setParameterValue(new Integer(value));
		} catch (NumberFormatException nfe) {
			logger.error("NumberFormatException occurred: Value is "+value);
			throw nfe;
		}
	}
	
	public IntParameter getTargetObject() {
		return sParameter;
	}
	
	public IntParameter createTargetInstance() {
		IntParameter newParameter = new IntParameter();
		newParameter.setElementId(super.getElementId());
		newParameter.setName(super.getName());
		sParameter = newParameter;
		return newParameter;
	}
}
