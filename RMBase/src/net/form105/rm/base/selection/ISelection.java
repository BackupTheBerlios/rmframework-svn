package net.form105.rm.base.selection;

import java.util.Collection;

/**
 * The selection is a List of objects by a generic type T. Usually the selections are used by queries. The result of a query is
 * often determined by the selection which is the basic set.
 * @author heiko
 *
 * @param <T> Type of objects selected
 */
public interface ISelection<T> {
	
	/**
	 * The operation which returns a list of objects which are the selected objects.
	 * @return
	 */
	public Collection<T> select();

}
