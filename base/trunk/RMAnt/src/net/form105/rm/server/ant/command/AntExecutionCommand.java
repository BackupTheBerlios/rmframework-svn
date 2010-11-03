package net.form105.rm.server.ant.command;

import net.form105.rm.base.command.AbstractCallbackCommand;
import net.form105.rm.base.command.CommandEvent;
import net.form105.rm.base.exception.RMException;
import net.form105.rm.server.ant.AntFlow;
import net.form105.rm.server.ant.workflow.WorkflowListener;

/**
 * A command for executing an ant flow. It implements an callback listener for informations about start and ending the
 * command.
 * @author heikok
 *
 */
public class AntExecutionCommand extends AbstractCallbackCommand implements Runnable {
	
	private String buildFilePath;
	private String incomingFilePath;
	private AntFlow antFlow;
	private WorkflowListener wfListener;
	private Thread threadCommand;
	
	private String workflowId;

	
	/**
	 * Construct 
	 * @param buildFilePath
	 */
	public AntExecutionCommand(String workflowId, String buildFilePath, String incomingFilePath) {
		this.buildFilePath = buildFilePath;
		this.workflowId = workflowId;
		wfListener = new WorkflowListener(workflowId);	
		
	}

	public void executeAsThread() throws RMException {
		getCommandListener().started(new CommandEvent(this));
		threadCommand.start();
		getCommandListener().finished(new CommandEvent(this));
	}
	
	@Override
	public void execute() {
		antFlow = new AntFlow();
		antFlow.startAntFlow(new String[] { "-buildfile", buildFilePath, "-DincomingFile="+incomingFilePath }, null, null, wfListener);
	}
	
	/**
	 * Return the workflow listener
	 * @return
	 */
	public WorkflowListener getWorkflowListener() {
		return wfListener;
	}
	
	@Override
	public void run() {
		antFlow = new AntFlow();
		antFlow.startAntFlow(new String[] { "-buildfile", buildFilePath }, null, null, wfListener);
	}
	
	public String getWorkflowId() {
		return workflowId;
	}
}
