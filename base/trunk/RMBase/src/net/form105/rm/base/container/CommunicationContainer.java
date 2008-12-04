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

import java.util.Properties;

import net.form105.rm.base.integration.PlcInboundServer;
import net.form105.rm.base.integration.protocol.validator.KaiserContentIdentifier;
import net.form105.xml.schema.model.ServerConfigDocument.ServerConfig.Inbound;

import org.apache.log4j.Logger;

/**
 * The communication container starts the basic communication and registers all network servers in the communication
 * handler. The configuration is required which provides messageTemplates and the server configuration.
 * @author heiko
 *
 */
public class CommunicationContainer extends AbstractContainer {
	
	public static Logger logger = Logger.getLogger(CommunicationContainer.class);
	
	private Properties properties;
	private String configDir;
	private final String serverConfigFilename = "serverConfig.xml";
	private CommunicationConfigurationContainer configContainer;
	
	private Inbound[] inbounds;
	
	
	
	
	
	public CommunicationContainer(PropertiesContainer propContainer, CommunicationConfigurationContainer configContainer) {
		this.properties = propContainer.getProperties();
		this.configContainer = configContainer;
		
	}
	
	
	public void initialize() {
		
	}
	
	

	@Override
	public void start() {
		initialize();
		
		inbounds = configContainer.getServerConfig().getServerConfig().getInboundArray();
		
		for (Inbound inbound : inbounds) {
			PlcInboundServer inputServer = new PlcInboundServer(inbound);
			inputServer.initialize();
			inputServer.connect();
			
		}
		
	}

	@Override
	public void stop() {
		
	}
}