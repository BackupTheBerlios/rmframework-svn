package net.form105.rm.server.ant.command;

import net.form105.rm.base.Agent;
import net.form105.rm.base.command.AbstractCallbackCommand;
import net.form105.rm.base.command.CommandEvent;
import net.form105.rm.base.exception.RMException;
import net.form105.rm.base.model.workflow.WorkflowManager;
import net.form105.rm.server.ant.AntFlow;
import net.form105.rm.server.ant.hotfolder.HotfolderInboundObject;
import net.form105.rm.server.ant.property.IPropertyObject;
import net.form105.rm.server.ant.workflow.AntBuildListener;

/**
 * A command for executing an ant flow. It implements an callback listener for informations about start and ending the
 * command which will be used as a callback.
 * @author heikok
 *
 */
public class AntExecutionCommand extends AbstractCallbackCommand {
	
	private String buildFilePath;
	private AntFlow antFlow;
	private AntBuildListener wfListener;
	private Thread threadCommand;
	private String buildId;
	
	public CommandEvent event;
	
	public IPropertyObject props;
	
	/**
	 * Constructor for the command with properties provided for ant. The PropertyObject contains the properties
	 * forwarded to ant. The buildFilePath is required to tell ant which build file to use. The id is a unique
	 * identifier to reference the build.
	 * @param props
	 */
	public AntExecutionCommand(IPropertyObject props, String buildFilePath, String buildId) {
		this.props = props;
		this.buildFilePath = buildFilePath;
		this.buildId = buildId;
	}

	public void executeAsThread() throws RMException {
		getCommandListener().started(new CommandEvent(this));
		threadCommand.start();
		getCommandListener().finished(new CommandEvent(this));
	}
	
	@Override
	public void execute() {
		antFlow = new AntFlow();
		antFlow.startAntFlow(new String[] { "-buildfile", buildFilePath, props.getAsString() }, null, null, wfListener);
	}
	
	/**
	 * Return the workflow listener
	 * @return
	 */
	public AntBuildListener getWorkflowListener() {
		return wfListener;
	}
	
	public String getBuildId() {
		return buildId;
	}
	
	
}
