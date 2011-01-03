package net.form105.rm.server.ant.hotfolder;

import java.io.File;

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
		String buildFilePath = hotfolderEvent.getHotfolderPath() + File.separator + "build.xml";
		String incomingFilePath = hotfolderEvent.getIncomingFilePath();
		handleCommand(getId(hotfolderEvent), buildFilePath, incomingFilePath);
	}
	
	@Override
	public void fileRemoved(HotfolderEvent hotEvent) {
		
	}
	
	private void handleCommand(String workflowId, String buildFilename, String incomingFilePath) {
		
		AntExecutionCommand execCommand = new AntExecutionCommand(workflowId, buildFilename, incomingFilePath);
		execCommand.setGroup(incomingFilePath);
		AntCommandHandler cHandler = (AntCommandHandler) Agent.getContainer("commandHandler");
		cHandler.addToStack(execCommand);
	}
}
