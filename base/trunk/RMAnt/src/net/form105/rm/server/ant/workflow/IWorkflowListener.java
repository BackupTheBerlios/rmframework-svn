package net.form105.rm.server.ant.workflow;

import org.apache.tools.ant.BuildListener;

public interface IWorkflowListener extends BuildListener {
	
	/**
	 * Representation of the buildStarted method.
	 */
	public void workflowStarted();
	
	/**
	 * Representation of the buildFinished method.
	 */
	public void workflowEnded();
	

}
