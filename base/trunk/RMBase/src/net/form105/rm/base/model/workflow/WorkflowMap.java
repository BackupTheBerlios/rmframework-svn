package net.form105.rm.base.model.workflow;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


import org.picocontainer.Startable;

/**
 * The workflow encapsulates the workflows in a map and gives access to the individual workflows by their
 * ids. 
 * @author heikok
 *
 */
public class WorkflowMap implements Startable {
	
	private Map<String, Workflow> workflowMap = new HashMap<String, Workflow>();
	
	public WorkflowMap() {
		
	}
	
	/**
	 * Adds a workflow to the map
	 * @param workflow
	 */
	public void addWorkflow(Workflow workflow) {
		workflowMap.put(workflow.getElementId(), workflow);
	}
	
	/**
	 * Removes a workflow from the map
	 * @param workflow
	 */
	public void removeWorkflow(Workflow workflow) {
		workflowMap.remove(workflow.getElementId());
	}
	
	/**
	 * Get a workflow by its id.
	 * @param id
	 * @return
	 */
	public Workflow getWorkflowById(String id) {
		return workflowMap.get(id);
	}
	
	/**
	 * Getting all existing workflows
	 * @return Collection of workflows
	 */
	public Collection<Workflow> getAllWorkflows() {
		return workflowMap.values();
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

}
