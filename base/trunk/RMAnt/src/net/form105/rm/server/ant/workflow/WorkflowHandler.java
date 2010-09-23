package net.form105.rm.server.ant.workflow;

import java.util.HashMap;
import java.util.Map;

public class WorkflowHandler {
	
	private Map<String, IWorkflowListener> workflowMap = new HashMap<String, IWorkflowListener>();

	
	
	
	
	public void addListener(IWorkflowListener listener) {
		workflowMap.put(listener.getWorkflowId(), listener);
	}
	
	public void removeListener(IWorkflowListener listener) {
		workflowMap.remove(listener);
	}
	
	
}
