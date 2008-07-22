package net.form105.rm.base.selection;

import java.util.Collection;

/**
 * Abstract implementation of a selection
 * @author heiko
 *
 * @param <T>
 */
public abstract class AbstractSelection<T> implements ISelection<T> {
	
	public abstract Collection<T> select();

}
