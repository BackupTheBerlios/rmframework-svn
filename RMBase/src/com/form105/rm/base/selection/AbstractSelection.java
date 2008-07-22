package com.form105.rm.base.selection;

import java.util.List;

/**
 * Abstract implementation of a selection
 * @author heiko
 *
 * @param <T>
 */
public abstract class AbstractSelection<T> implements ISelection<T> {
	
	public abstract List<T> select();

}
