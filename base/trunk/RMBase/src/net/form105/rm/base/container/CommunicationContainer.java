/*
 * Copyright (c) 2008, form105 Heiko Kundlacz
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
package net.form105.rm.base.container;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import net.form105.rm.base.Container;
import net.form105.rm.base.exception.RMException;
import net.form105.rm.base.integration.PlcInputServer;
import net.form105.rm.server.i18n.BaseMessage;
import net.form105.xml.schema.model.ServerConfigDocument;
import net.form105.xml.schema.model.ServerConfigDocument.ServerConfig.Inbound;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;

/**
 * The communication container starts the basic communication and registers all network servers in the communication
 * handler.
 * @author heiko
 *
 */
public class CommunicationContainer extends AbstractContainer {
	
	public static Logger logger = Logger.getLogger(CommunicationContainer.class);
	
	private Properties properties;
	private String configDir;
	private final String serverConfigFilename = "serverConfig.xml";
	private ServerConfigDocument configDocument;
	private Inbound[] inbounds;
	
	public CommunicationContainer(PropertiesContainer propContainer) {
		this.properties = propContainer.getProperties();
		
	}
	
	
	public void initialize() {
		configDir = Container.getInstance().getConfiguration().getConfigurationDirectory();
		// Loading serverConfig
		String configFile = configDir + serverConfigFilename;
		logger.info("Loading server config file: "+configFile);
		
		try {
			configDocument = ServerConfigDocument.Factory.parse(new File(configDir+serverConfigFilename));
		} catch (XmlException e) {
			logger.error(e,e);
		} catch (IOException ex) {
			RMException rmEx = new RMException(new BaseMessage(), "exception.fileNotFound", new String[] {configFile}, ex);
			throw rmEx;
		}
		
		inbounds = configDocument.getServerConfig().getInboundArray();
		
	}
	
	

	@Override
	public void start() {
		initialize();
		for (Inbound inbound : inbounds) {
			PlcInputServer inputServer = new PlcInputServer(inbound);
			inputServer.initialize();
			inputServer.connect();
			
		}
		
	}

	@Override
	public void stop() {
		
	}
	
	

}