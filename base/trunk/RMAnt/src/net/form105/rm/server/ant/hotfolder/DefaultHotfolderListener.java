package net.form105.rm.server.ant.hotfolder;

import net.form105.rm.base.Agent;
import net.form105.rm.base.command.ICommandHandler;
import net.form105.rm.server.ant.command.AntCommandHandler;
import net.form105.rm.server.ant.command.AntExecutionCommand;

/**
 * The default listener if a file arrives in a hotfolder.
 * @author heikok
 *
 */
public class DefaultHotfolderListener extends AbstractHotfolderListener {
	
	private ICommandHandler<Object> commandHandler;
	
	public DefaultHotfolderListener(ICommandHandler commandHandler) {
		this.commandHandler = commandHandler;
	}

	@Override
	public void fileArrived(HotfolderEvent hotfolderEvent) {
		HotfolderInboundObject inboundObject = (HotfolderInboundObject) hotfolderEvent.getInboundObject();
		
		handleCommand(inboundObject);
	}
	
	@Override
	public void fileRemoved(HotfolderEvent hotEvent) {
		
	}
	
	private void handleCommand(HotfolderInboundObject inboundObject) {
		AntExecutionCommand execCommand = new AntExecutionCommand(inboundObject);
		execCommand.setGroup(inboundObject.getBuildTempFolderName());
		commandHandler.execute(execCommand);
	}
}
