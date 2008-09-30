package net.form105.web.base.model.filter;

import java.io.Serializable;

/**
 * 
 * @author heiko
 *
 * @param <O> The output object (the value)
 * @param <I> The input object
 */
public interface IValue<O, I> extends Serializable {
	
	public O getValue(I object);

}
