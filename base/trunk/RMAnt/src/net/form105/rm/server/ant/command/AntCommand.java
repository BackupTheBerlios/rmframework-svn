package net.form105.rm.server.ant.command;

import net.form105.rm.base.command.AbstractCommand;
import net.form105.rm.base.exception.RMException;

public class AntCommand extends AbstractCommand implements Runnable  {
	
	private String oid;
	
	public AntCommand(String oid) {
		this.oid = oid;
	}

	@Override
	public void run() {
		
	}

	@Override
	public void execute() throws RMException {
		
		
	}

	@Override
	public String getOid() {
		return oid;
	}

}
