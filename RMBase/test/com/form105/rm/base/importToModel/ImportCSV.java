package com.form105.rm.base.importToModel;

import net.form105.rm.base.model.user.User;
import net.form105.rm.server.service.CSVMapperService;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.form105.rm.base.query.AbstractRemoteTest;

public class ImportCSV extends AbstractRemoteTest<User> {

	public static Logger logger = Logger.getLogger(ImportCSV.class);
	

	@Test
	public void createUsers() {
		CSVMapperService service = new CSVMapperService();
		CSVMapperService.ServiceArgument arg = service.getArgument();
		arg.file = "import/mapping_example.xml";
		doService(service);
	}
}
