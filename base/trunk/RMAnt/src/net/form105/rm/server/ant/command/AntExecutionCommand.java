package net.form105.rm.server.ant.command;

import net.form105.rm.base.Agent;
import net.form105.rm.base.command.AbstractCallbackCommand;
import net.form105.rm.base.command.CommandEvent;
import net.form105.rm.base.exception.RMException;
import net.form105.rm.base.query.DefaultFilterQuery;
import net.form105.rm.base.query.LocalQueryHandler;
import net.form105.rm.base.service.IResult;
import net.form105.rm.base.service.ResultStatus;
import net.form105.rm.server.ant.AntFlow;
import net.form105.rm.server.ant.Globals;
import net.form105.rm.server.ant.container.WorkflowContainer;
import net.form105.rm.server.ant.model.Workflow;
import net.form105.rm.server.ant.selection.WorkflowByAttributeSelection;
import net.form105.rm.server.ant.workflow.WorkflowListener;

/**
 * A command for executing an ant flow. It implements an callback listener for informations about start and ending the
 * command which will be used as a callback.
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
	public CommandEvent event;

	
	/**
	 * 
	 * @param workflowId An id for the data model. 
	 * @param buildFilePath The build file to start
	 * @param incomingFilePath An incoming file. The path will be used as a property for ant (-d)
	 */
	public AntExecutionCommand(String workflowId, String buildFilePath, String incomingFilePath) {
		this.incomingFilePath = incomingFilePath;
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
	
	public boolean reRun() {
		WorkflowContainer container = (WorkflowContainer) Agent.getComponentById("workflows");
		WorkflowByAttributeSelection selection = new WorkflowByAttributeSelection(Globals.ATTRIBUTE_ID_HOTFOLDER, container);
		DefaultFilterQuery<Workflow> query = new DefaultFilterQuery<Workflow>(selection);

		LocalQueryHandler queryHandler = new LocalQueryHandler();
		IResult<Workflow> result = queryHandler.executeQuery(query);
		if (result.equals(ResultStatus.FAIL)) {
			logger.error("Sorting out. Error in query");
		}
		if (result.getResultList().size() >=1) return true;
		return false;
	}
}
