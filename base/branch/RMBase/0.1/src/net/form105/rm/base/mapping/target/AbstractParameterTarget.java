package net.form105.rm.base.mapping.target;

import net.form105.rm.base.mapping.ITarget;

public abstract class AbstractParameterTarget<T> implements ITarget<T> {
	
	private String elementId;
	private String name;
	
	public abstract void setValue(String value);
	
	public abstract T getTargetObject();
	
	public String getElementId() {
		return elementId;
	}

	public void setElementId(String elementId) {
		this.elementId = elementId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public abstract T createTargetInstance();
	
	

}
