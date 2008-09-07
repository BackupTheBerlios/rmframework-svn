package net.form105.rm.server.service;

import net.form105.rm.base.service.AbstractService;
import net.form105.rm.base.service.IArgument;
import net.form105.rm.server.mapping.CSVTemplateSequence;
import net.form105.rm.server.mapping.ITemplateSequence;

public class CSVMapperService extends AbstractService {
	
	private static final long serialVersionUID = 1L;
	private ServiceArgument argument = new ServiceArgument();

	public class ServiceArgument implements IArgument {
		private static final long serialVersionUID = 1L;
		public String file;
	}

	@Override
	public void execute() throws Exception {
		ITemplateSequence reader = new CSVTemplateSequence(argument.file);
		//reader.doImport();
	}

	@Override
	public ServiceArgument getArgument() {
		return argument;
	}
}
