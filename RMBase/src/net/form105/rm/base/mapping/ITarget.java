package net.form105.rm.base.mapping;

public interface ITarget<T> {
	
	public void setValue(String value);
	
	public T getTargetObject();
	
	public T createTargetInstance();

}
