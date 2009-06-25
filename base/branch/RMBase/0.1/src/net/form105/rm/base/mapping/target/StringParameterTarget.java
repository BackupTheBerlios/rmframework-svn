package net.form105.rm.base.mapping.target;



import net.form105.rm.base.model.parameter.StringParameter;

public class StringParameterTarget extends AbstractParameterTarget<StringParameter> {
	
	private StringParameter sParameter;
	
	public void setValue(String value) {
		sParameter.setParameterValue(value);
	}
	
	public StringParameter getTargetObject() {
		return sParameter;
	}
	
	public StringParameter createTargetInstance() {
		StringParameter newParameter = new StringParameter();
		newParameter.setElementId(super.getElementId());
		newParameter.setName(super.getName());
		sParameter = newParameter;
		return newParameter;
	}
}
