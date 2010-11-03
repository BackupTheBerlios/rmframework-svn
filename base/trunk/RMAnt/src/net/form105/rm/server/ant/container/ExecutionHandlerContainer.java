package net.form105.rm.server.ant.container;

import net.form105.rm.server.ant.command.AntCommandHandler;

import org.picocontainer.Startable;

public class ExecutionHandlerContainer implements Startable {

	private AntCommandHandler eHandler;
	
	@Override
	public void start() {
		eHandler = new AntCommandHandler();
		eHandler.start();
		
	}

	@Override
	public void stop() {
		eHandler.stop();
		
	}
	
	public AntCommandHandler getHandler() {
		return eHandler; 
	}

}
