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
package net.form105.rm.server.ant.service;


import net.form105.rm.base.service.AbstractService;
import net.form105.rm.base.service.IArgument;
import net.form105.rm.server.ant.AntAgent;
import net.form105.rm.server.ant.container.HotfolderContainer;
import net.form105.rm.server.ant.hotfolder.HotfolderInboundReceiver;

import org.apache.log4j.Logger;

/**
 * Used for testing purposes
 * @author heikok
 *
 */
public class FileArrivedService extends AbstractService {

	private static final long serialVersionUID = 3344224917021024307L;
	
	public static Logger logger = Logger.getLogger(FileArrivedService.class);
	
	ServiceArgument argument = new ServiceArgument();

	@Override
	public void execute() throws Exception {
		ServiceArgument arg = (ServiceArgument) getArgument();
		HotfolderContainer hfHandler = (HotfolderContainer) AntAgent.getComponentById("hotfolders");
		HotfolderInboundReceiver hotfolder = hfHandler.getHotfolderByName(arg.hotfolderPath);
		hotfolder.notifyFileArrived(arg.hotfolderPath, arg.arrivedFilePath);
		logger.info("Hotfolder path: "+arg.hotfolderPath);
		logger.info("File path arrived: "+arg.arrivedFilePath);
	}

	@Override
	public ServiceArgument getArgument() {
		return argument;
	}
	
	

    public class ServiceArgument implements IArgument {
		private static final long serialVersionUID = -3451189066869409400L;
		public String arrivedFilePath;
        public String hotfolderPath;
    }

}
