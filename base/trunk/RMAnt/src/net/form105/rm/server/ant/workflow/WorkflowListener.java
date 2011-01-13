package net.form105.rm.server.ant.workflow;

import java.util.Hashtable;

import net.form105.rm.base.Agent;
import net.form105.rm.server.ant.hotfolder.HotfolderInboundObject;

import org.apache.log4j.Logger;
import org.apache.tools.ant.BuildEvent;
import org.apache.tools.ant.BuildListener;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.Target;
import org.apache.tools.ant.Task;

public class WorkflowListener implements BuildListener {

	public static Logger logger = Logger.getLogger(WorkflowListener.class);

	private String workflowId;
	private WorkflowManager wfManager;

	public WorkflowListener(HotfolderInboundObject inboundObject) {
		this.workflowId = inboundObject.getWorkflowId();
		wfManager = (WorkflowManager) Agent.getComponentById("workflowManager");
	}

	@Override
	public void buildFinished(BuildEvent event) {
		// logger.info("Build has been finished");
	}

	@Override
	public void buildStarted(BuildEvent event) {
		Project project = event.getProject();

		
		logger.info("Workflow id: "+workflowId);
		
		// logger.info("Project: "+myProject);
		
		Hashtable targetTable = project.getTargets();
		for (Object object : targetTable.keySet()) {
			logger.info("build started: " + object.toString());
		}
	}

	@Override
	public void messageLogged(BuildEvent event) {
		// logger.info("Message has been logged: "+event.getMessage());
	}

	@Override
	public void targetFinished(BuildEvent event) {
		logger.info("Target finished: "+event.getTarget());
	}

	@Override
	public void targetStarted(BuildEvent event) {
		logger.info("target started: "+event.getTarget().getName());
		
		Hashtable table = event.getProject().getTargets();
		for (Object object : table.keySet()) {
			logger.info(object);

		}

	}

	@Override
	public void taskFinished(BuildEvent event) {

	}

	@Override
	public void taskStarted(BuildEvent event) {
		Task task = event.getTask();
		//logger.info("Task started: "+task.getTaskName());
		//logger.info("Task hash: "+task.hashCode());
	}

}
