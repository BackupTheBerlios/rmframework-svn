package com.form105.rm.web.base.component.filter;


/**
 * A filter for controls that requires an input as a criteria make a
 * decision if a object is selectable
 * @author Heiko Kundlacz
 *
 */
public abstract class AbstractInputFilter implements IViewFilter {
	
	private Object input;

	/**
	 * Getting the input 
	 * @return String
	 */
	public Object getInput() {
		return input;
	}

	/**
	 * Setting the input
	 * @param input
	 */
	public void setInput(Object input) {
		this.input = input;
	}

	public abstract String getId();

	public abstract String getName();

	public abstract boolean select(Object object);

}
