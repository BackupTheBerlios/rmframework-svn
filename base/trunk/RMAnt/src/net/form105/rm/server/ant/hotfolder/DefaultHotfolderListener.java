package net.form105.rm.server.ant.hotfolder;

import net.form105.rm.base.Agent;
import net.form105.rm.server.ant.command.AntCommandHandler;
import net.form105.rm.server.ant.command.AntExecutionCommand;

/**
 * The default listener if a file arrives in a hotfolder.
 * @author heikok
 *
 */
public class DefaultHotfolderListener extends AbstractHotfolderListener {

	@Override
	public void fileArrived(HotfolderEvent hotfolderEvent) {
		HotfolderInboundObject inboundObject = (HotfolderInboundObject) hotfolderEvent.getInboundObject();
		
		handleCommand(getId(hotfolderEvent), inboundObject);
	}
	
	@Override
	public void fileRemoved(HotfolderEvent hotEvent) {
		
	}
	
	private void handleCommand(String workflowId, HotfolderInboundObject inboundObject) {
		AntExecutionCommand execCommand = new AntExecutionCommand(workflowId, inboundObject);
		execCommand.setGroup(inboundObject.getBuildTempFolderName());
		AntCommandHandler cHandler = (AntCommandHandler) Agent.getContainer("commandHandler");
		cHandler.addToStack(execCommand);
	}
}
