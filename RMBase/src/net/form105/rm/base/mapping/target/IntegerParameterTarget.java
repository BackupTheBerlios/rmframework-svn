package net.form105.rm.base.mapping.target;



import net.form105.rm.base.model.parameter.IntParameter;

public class IntegerParameterTarget extends AbstractParameterTarget<IntParameter> {
	
	private IntParameter sParameter;
	
	public void setValue(String value) {
		sParameter.setParameterValue(new Integer(value));
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
