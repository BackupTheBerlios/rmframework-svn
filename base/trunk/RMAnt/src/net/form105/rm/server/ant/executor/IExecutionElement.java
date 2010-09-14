package net.form105.rm.server.ant.executor;

import net.form105.rm.base.service.IResult;

/**
 * An execution element which can be executed in the execution handler. It has simply only one execution method.
 * @author heikok
 *
 * @param <T>
 */
public interface IExecutionElement<T> {
	
	public IResult<T> execute();

}
