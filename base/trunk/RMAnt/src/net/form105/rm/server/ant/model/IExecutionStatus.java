package net.form105.rm.server.ant.model;

/**
 * Implements an execution status to an object.
 * @author heikok
 *
 */
public interface IExecutionStatus {
	
	/**
	 * Updates the state 
	 * @param state
	 */
	public void updateState(ExecutionState state);
	
	/**
	 * Returns the execution state of the object
	 * @return
	 */
	public ExecutionState getState();

}
