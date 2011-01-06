package net.form105.rm.server.ant.workflow;

import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.apache.tools.ant.BuildEvent;
import org.apache.tools.ant.BuildListener;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.Target;
import org.apache.tools.ant.Task;

public class WorkflowListener implements BuildListener {

	public static Logger logger = Logger.getLogger(WorkflowListener.class);

	private String buildId;

	private boolean firstTargetStarted = false;
	private String workflowId;
	

	public WorkflowListener(String workflowId) {
		this.workflowId = workflowId;
	}

	@Override
	public void buildFinished(BuildEvent event) {
		// logger.info("Build has been finished");
	}

	@Override
	public void buildStarted(BuildEvent event) {
		Project project = event.getProject();
		
		
		
		//AddWorkflowCommand wfCommand = new AddWorkflowCommand(Integer.toString(project.hashCode()), project.getName());
		// get the existing workflow and modify it. 
		// a workflow has already been created at file arrival

		
		
		
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
		Target target = event.getTarget();
		// logger.info("Target has been finished: "+target.getName());
	}

	@Override
	public void targetStarted(BuildEvent event) {
		
		firstTargetStarted = false;
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
		// logger.info("Task started: "+task.getTaskName());
		// logger.info("Task hash: "+task.hashCode());
	}

}
