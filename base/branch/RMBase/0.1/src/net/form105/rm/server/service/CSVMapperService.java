package net.form105.rm.server.service;

import net.form105.rm.base.command.CommandHandler;
import net.form105.rm.base.command.ImportCommand;
import net.form105.rm.base.model.Resource;
import net.form105.rm.base.service.AbstractService;
import net.form105.rm.base.service.IArgument;

public class CSVMapperService extends AbstractService {
	
	private static final long serialVersionUID = 1L;
	private ServiceArgument argument = new ServiceArgument();

	public class ServiceArgument implements IArgument {
		private static final long serialVersionUID = 1L;
		public String sourceFile;
		public String templateFile;
	}

	@Override
	public void execute() throws Exception {
		
		CommandHandler<Resource> cHandler = new CommandHandler<Resource>();
		ImportCommand command = new ImportCommand(argument.sourceFile, argument.templateFile);
		cHandler.execute(command);
		
	}

	@Override
	public ServiceArgument getArgument() {
		return argument;
	}
}
