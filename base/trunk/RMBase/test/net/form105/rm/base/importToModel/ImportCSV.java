package net.form105.rm.base.importToModel;

import net.form105.rm.base.model.user.User;
import net.form105.rm.base.query.AbstractRemoteTest;
import net.form105.rm.server.service.CSVMapperService;

import org.apache.log4j.Logger;
import org.junit.Test;


public class ImportCSV extends AbstractRemoteTest<User> {

	public static Logger logger = Logger.getLogger(ImportCSV.class);
	

	@Test
	public void mapCSV() {
		CSVMapperService service = new CSVMapperService();
		CSVMapperService.ServiceArgument arg = service.getArgument();
		arg.sourceFile = "test.csv";
		arg.templateFile = "mapping_example.xml";
		doService(service);
	}
}
