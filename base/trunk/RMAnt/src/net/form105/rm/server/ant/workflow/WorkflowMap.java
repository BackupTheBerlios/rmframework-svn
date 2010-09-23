package net.form105.rm.server.ant.workflow;

import java.util.HashMap;
import java.util.Map;

public class WorkflowMap {
	
	private Map<String, Workflow> workflowMap = new HashMap<String, Workflow>();
	
	public WorkflowMap() {
		
	}
	
	public void addWorkflow(Workflow workflow) {
		workflowMap.put(workflow.getId(), workflow);
	}
	
	public void removeWorkflow(Workflow workflow) {
		workflowMap.remove(workflow.getId());
	}

}
