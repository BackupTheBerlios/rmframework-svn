package net.form105.rm.server.ant.workflow;

import org.apache.tools.ant.BuildListener;

public interface IWorkflowListener extends BuildListener {
	
	public String getWorkflowId();
	

}
