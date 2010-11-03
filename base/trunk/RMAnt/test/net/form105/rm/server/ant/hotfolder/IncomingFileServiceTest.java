/*
 * Copyright (c) 2010, form105 Heiko Kundlacz
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.form105.rm.server.ant.hotfolder;


import net.form105.rm.base.query.AbstractRemoteTest;
import net.form105.rm.server.ant.service.FileArrivedService;

import org.junit.Before;
import org.junit.Test;

/**
 * A test for starting a build process by simulating a file arrival. The files must exist:
 * arrivedFilePath: The file which arrives
 * hotfolderPath: The path to the hotfolder, which must include a build.xml
 * The build.xml is the one which will be executed.
 * @author heikok
 *
 */
public class IncomingFileServiceTest extends AbstractRemoteTest<String>{

	FileArrivedService service;
	
	@Before
	public void setUp() throws Exception {
		service = new FileArrivedService();
		FileArrivedService.ServiceArgument arg = service.getArgument();
		arg.arrivedFilePath = "/Users/heikok/temp/hotfolder/1/J392216.xml";
		arg.hotfolderPath = "/Users/heikok/temp/hotfolder/1";
	}
	
	@Test
	public void testFileArrived() {
		doService(service);
	}
	
}
