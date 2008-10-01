package net.form105.rm.base.command;

import net.form105.rm.base.exception.RMException;
import net.form105.rm.base.mapping.DefaultMapperControl;
import net.form105.rm.base.mapping.reader.CSVReader;
import net.form105.rm.server.mapping.CSVTemplate;

public class ImportCommand extends AbstractCommand {
	
	private final String id = "IMPORT_COMMAND";
	private String sourceFilename;
	private String templateFilename;
	
	public ImportCommand(String sourceFilename, String templateFilename) {
		this.sourceFilename = sourceFilename;
		this.templateFilename = templateFilename;
	}

	@Override
	public void execute() throws RMException {
		
		DefaultMapperControl control = new DefaultMapperControl();
		control.registerTemplate(new CSVTemplate(templateFilename));
		
		CSVReader reader = new CSVReader(sourceFilename, control);
		reader.importAll();
	}
	
	public String getId() {
		return id;
	}

}
