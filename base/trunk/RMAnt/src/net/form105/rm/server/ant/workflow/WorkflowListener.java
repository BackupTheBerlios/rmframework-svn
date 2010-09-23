package net.form105.rm.server.ant.workflow;

import org.apache.log4j.Logger;
import org.apache.tools.ant.BuildEvent;
import org.apache.tools.ant.BuildListener;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.Target;
import org.apache.tools.ant.Task;

public class WorkflowListener implements BuildListener {
	
	public static Logger logger = Logger.getLogger(WorkflowListener.class);
	
	private String buildId;
	
	public WorkflowListener(String buildId) {
		
	}

	@Override
	public void buildFinished(BuildEvent event) {
		logger.info("Build has been finished");

	}

	@Override
	public void buildStarted(BuildEvent event) {
		logger.info("Build has been started");
		Project project = event.getProject();
		project.getTargets();
		
	}

	@Override
	public void messageLogged(BuildEvent event) {
		logger.info("Message has been logged: "+event.getMessage());
	}

	@Override
	public void targetFinished(BuildEvent event) {
		Target target = event.getTarget();
		logger.info("Target has been finished: "+target.getName());
	}

	@Override
	public void targetStarted(BuildEvent event) {
		Target target = event.getTarget();
		logger.info("Target has been finished: "+target.getName());
	}

	@Override
	public void taskFinished(BuildEvent event) {
		Task task = event.getTask();
		logger.info("Task finished: "+task.getTaskName());
		
	}

	@Override
	public void taskStarted(BuildEvent event) {
		Task task = event.getTask();
		logger.info("Task started: "+task.getTaskName());
	}

}
