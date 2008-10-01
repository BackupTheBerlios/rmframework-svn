package net.form105.rm.base.mapping;

public abstract class AbstractField implements IField {
	
	private Object content;
	private String valueMethod;
	private ITarget target;
	
	public AbstractField(ITarget target) {
		this.target = target;
		
	}

	@Override
	public ITarget getTarget() {
		return target;
	}

	@Override
	public void setValue(String value) {
		target.setValue(value);
	}
	
	
}
