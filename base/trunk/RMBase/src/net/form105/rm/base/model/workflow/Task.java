package net.form105.rm.base.model.workflow;

import net.form105.rm.base.model.AgentObject;
import net.form105.rm.base.model.ExecutionState;



public class Task extends AgentObject {
	
	private static final long serialVersionUID = -8116310993139291901L;
	
	private long startTime;
	private long finishTime;
	
	private Workflow parent;
	
	private ExecutionState state = ExecutionState.NotStarted;
	
	public Task(Workflow parent, String id, String name) {
		this.parent = parent;
		this.updateState(ExecutionState.NotStarted);
		super.setElementId(id);
		super.setName(name);
	}
	
	/**
	 * State update
	 */
	public void updateState(ExecutionState state) {
		this.state = state;
	}
	
	public ExecutionState getState() {
		return state;
	}
	
	public long getStartTime() {
		return startTime;
	}
	
	public void setStartTime() {
		startTime = System.currentTimeMillis();
	}
	
	public long getFinishTime() {
		return finishTime;
	}
	
	public void setFinishTime() {
		finishTime = System.currentTimeMillis();
		state = ExecutionState.Finished;
	}
	
	public Workflow getParent() {
		return parent;
	}
}
