package net.form105.rm.server.ant.command;

import net.form105.rm.base.command.AbstractCallbackCommand;
import net.form105.rm.base.command.CommandEvent;
import net.form105.rm.base.exception.RMException;
import net.form105.rm.server.ant.AntFlow;
import net.form105.rm.server.ant.hotfolder.HotfolderInboundObject;
import net.form105.rm.server.ant.workflow.WorkflowListener;

/**
 * A command for executing an ant flow. It implements an callback listener for informations about start and ending the
 * command which will be used as a callback.
 * @author heikok
 *
 */
public class AntExecutionCommand extends AbstractCallbackCommand {
	
	private String buildFilePath;
	private String incomingFilePath;
	private AntFlow antFlow;
	private WorkflowListener wfListener;
	private Thread threadCommand;
	private HotfolderInboundObject inObject;
	
	public CommandEvent event;

	
	/**
	 * 
	 * @param workflowId An id for the data model. 
	 * @param buildFilePath The build file to start
	 * @param incomingFilePath An incoming file. The path will be used as a property for ant (-d)
	 */
	public AntExecutionCommand(HotfolderInboundObject inboundObject) {
		this.inObject = inboundObject;
		this.incomingFilePath = inboundObject.getInboundFilenName();
		this.buildFilePath = inboundObject.getBuildFileName();
		wfListener = new WorkflowListener(inboundObject);
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
	
	

	
	public HotfolderInboundObject getInboundObject() {
		return inObject;
	}
	
	
}
