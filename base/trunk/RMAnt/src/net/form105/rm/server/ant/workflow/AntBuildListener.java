package net.form105.rm.server.ant.workflow;

import java.util.Hashtable;

import net.form105.rm.base.model.ExecutionState;
import net.form105.rm.base.model.workflow.Task;
import net.form105.rm.base.model.workflow.Workflow;
import net.form105.rm.base.model.workflow.WorkflowManager;
import net.form105.rm.server.ant.hotfolder.HotfolderInboundObject;

import org.apache.log4j.Logger;
import org.apache.tools.ant.BuildEvent;
import org.apache.tools.ant.BuildListener;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.Target;


public class AntBuildListener implements BuildListener {

	public static Logger logger = Logger.getLogger(AntBuildListener.class);

	private WorkflowManager wfManager;
	private HotfolderInboundObject inboundObject;


	public AntBuildListener(WorkflowManager wfManager, HotfolderInboundObject inboundObject) {
		this.inboundObject = inboundObject;
		this.wfManager = wfManager;
		
	}

	@Override
	public void buildFinished(BuildEvent event) {
		Workflow workflow = wfManager.getWorkflowById(inboundObject.getWorkflowId());
		workflow.updateState(ExecutionState.Finished);
	}

	/**
	 * Mapping all targets as tasks to a workflow
	 */
	@Override
	public void buildStarted(BuildEvent event) {
		
		Workflow workflow = wfManager.getWorkflowById(inboundObject.getWorkflowId());
		
		Project project = event.getProject();

		Hashtable targetTable = project.getTargets();
		for (Object object : targetTable.values()) {
			Target target = (Target) object;
			String name = target.getName();
			String description = target.getDescription();
			Task task = new Task(workflow, name, description);
			wfManager.addTask(workflow, task);
		}
		
		// finally change state
		workflow.updateState(ExecutionState.Started);
	}

	@Override
	public void messageLogged(BuildEvent event) {
		// logger.info("Message has been logged: "+event.getMessage());
	}

	@Override
	public void targetFinished(BuildEvent event) {
		Workflow workflow = wfManager.getWorkflowById(inboundObject.getWorkflowId());
		Target target = event.getTarget();
		Task task = wfManager.getTaskById(workflow.getElementId(), target.getName());
		task.setFinishTime();
		task.updateState(ExecutionState.Finished);
	}

	@Override
	public void targetStarted(BuildEvent event) {
		Workflow workflow = wfManager.getWorkflowById(inboundObject.getWorkflowId());
		Target target = event.getTarget();
		Task task = wfManager.getTaskById(workflow.getElementId(), target.getName());
		task.setStartTime();
		task.updateState(ExecutionState.Started);
	}

	@Override
	public void taskFinished(BuildEvent event) {
			
	}

	@Override
	public void taskStarted(BuildEvent event) {
		
	}

}
