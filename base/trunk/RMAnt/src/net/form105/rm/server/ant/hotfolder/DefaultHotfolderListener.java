package net.form105.rm.server.ant.hotfolder;

import net.form105.rm.base.command.ICommandHandler;
import net.form105.rm.server.ant.command.AntExecutionCommand;
import net.form105.rm.server.ant.property.AntPropertyObject;

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
	public void objectArrived(InboundObject inboundObject) {
		HotfolderInboundObject hfIObject = (HotfolderInboundObject) inboundObject;
		handleCommand(hfIObject);
	}
	
	@Override
	public void objectRemoved(InboundObject hotEvent) {
		
	}
	
	private void handleCommand(HotfolderInboundObject inboundObject) {
		AntPropertyObject props = new AntPropertyObject();
		AntExecutionCommand execCommand = new AntExecutionCommand(props, inboundObject.getBuildFileName(), inboundObject.getId());
		commandHandler.execute(execCommand);
	}
}
