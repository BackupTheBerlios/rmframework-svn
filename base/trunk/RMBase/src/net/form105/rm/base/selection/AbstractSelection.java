package net.form105.rm.base.selection;

import java.io.Serializable;
import java.util.List;

import net.form105.rm.base.model.AgentObject;

/**
 * Abstract implementation of a selection
 * @author heiko
 *
 * @param <T>
 */
public abstract class AbstractSelection<T> implements ISelection<T>, Serializable {

	private static final long serialVersionUID = 1L;

	public abstract List<T> select();

}
