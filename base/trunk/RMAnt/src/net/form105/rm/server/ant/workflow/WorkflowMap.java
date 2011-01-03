package net.form105.rm.server.ant.workflow;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import net.form105.rm.server.ant.model.Workflow;

/**
 * The workflow encapsulates the workflows in a map and gives access to the individual workflows by their
 * ids. 
 * @author heikok
 *
 */
public class WorkflowMap {
	
	private Map<String, Workflow> workflowMap = new HashMap<String, Workflow>();
	
	public WorkflowMap() {
		
	}
	
	/**
	 * Adds a workflow to the map
	 * @param workflow
	 */
	public void addWorkflow(Workflow workflow) {
		workflowMap.put(workflow.getId(), workflow);
	}
	
	/**
	 * Removes a workflow from the map
	 * @param workflow
	 */
	public void removeWorkflow(Workflow workflow) {
		workflowMap.remove(workflow.getId());
	}
	
	/**
	 * Get a workflow by its id.
	 * @param id
	 * @return
	 */
	public Workflow getWorkflowById(String id) {
		return workflowMap.get(id);
	}
	
	public Collection<Workflow> getAllWorkflows() {
		return workflowMap.values();
	}

}
