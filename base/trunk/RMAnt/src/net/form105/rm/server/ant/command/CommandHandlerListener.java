package net.form105.rm.server.ant.command;

import net.form105.rm.base.command.CommandEvent;
import net.form105.rm.base.command.ICommandListener;

public class CommandHandlerListener implements ICommandListener {
	
	public CommandHandlerListener() {
		
	}

	@Override
	public void finished(CommandEvent event) {
		event.getSource();
		
	}

	@Override
	public void started(CommandEvent event) {
		
	}

}
