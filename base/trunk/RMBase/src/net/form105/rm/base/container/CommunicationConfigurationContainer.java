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
import java.util.HashMap;

import net.form105.rm.base.Container;
import net.form105.rm.base.exception.RMException;
import net.form105.rm.base.integration.PlcMessageTemplate;
import net.form105.rm.server.i18n.BaseMessage;
import net.form105.xml.schema.model.PlcMessagesDocument;
import net.form105.xml.schema.model.ServerConfigDocument;
import net.form105.xml.schema.model.PlcMessagesDocument.PlcMessages;
import net.form105.xml.schema.model.PlcMessagesDocument.PlcMessages.PlcMessage;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;

/**
 * Configures the plc message templates and the configuration for the plc
 * servers.
 * 
 * @author hk
 * 
 */
public class CommunicationConfigurationContainer extends AbstractContainer {

	public static Logger logger = Logger.getLogger(CommunicationConfigurationContainer.class);

	private String configDir;
	private final String serverConfigFilename = "serverConfig.xml";
	private static String plcConfigFileName = "plcMessages.xml";
	private ServerConfigDocument messageConfigDocument;
	private String plcMessageConfigFile;
	private PropertiesContainer propContainer;
	
	private HashMap<Integer, PlcMessageTemplate> templateRegistry = new HashMap<Integer, PlcMessageTemplate>(); 

	private boolean configured;

	public CommunicationConfigurationContainer(PropertiesContainer propContainer) {
		this.propContainer = propContainer;
		
	}

	/**
	 * @return the isConfigured
	 */
	public boolean isConfigured() {
		return configured;
	}

	/**
	 * @param isConfigured
	 *            the isConfigured to set
	 */
	public void setConfigured(boolean configured) {
		this.configured = configured;
	}

	public void initialize() {
		
		setConfigured(propContainer.getProperty("server.communication").equalsIgnoreCase("on"));
		
		if (! configured) {
			return;
		}
		
		configDir = Container.getInstance().getConfiguration().getConfigurationDirectory();
		// Loading serverConfig
		String configFile = configDir + serverConfigFilename;
		logger.info("Loading communication server config file: " + configFile);

		try {
			messageConfigDocument = ServerConfigDocument.Factory.parse(new File(configDir + serverConfigFilename));
		} catch (XmlException e) {
			logger.error(e, e);
		} catch (IOException ex) {
			RMException rmEx = new RMException(new BaseMessage(), "exception.fileNotFound",
					new String[] { configFile }, ex);
			throw rmEx;
		}

		plcMessageConfigFile = configDir + plcConfigFileName;
	}

	@Override
	public void start() {
		initialize();

	}

	@Override
	public void stop() {
		configDir = Container.getInstance().getConfiguration().getConfigurationDirectory();
	}

	/**
	 * Getting the configuration of the plc messages from the xmlHelper schema and register them in the 
	 * hashmap
	 * 
	 * @return The document containing the configuration
	 */
	public PlcMessagesDocument readPlcMessageConfiguration() {

		try {
			PlcMessagesDocument plcMessageConfigDocument = PlcMessagesDocument.Factory.parse(new File(
					plcMessageConfigFile));
			PlcMessages messages = plcMessageConfigDocument.getPlcMessages();

			for (PlcMessage message : messages.getPlcMessageArray()) {
				PlcMessageTemplate template = new PlcMessageTemplate(message);
				templateRegistry.put(template.getHashcode(), template);
			}
			return plcMessageConfigDocument;
		} catch (XmlException e) {
			logger.error(e, e);
			return null;
		} catch (IOException ex) {
			RMException rmEx = new RMException(new BaseMessage(), "exception.fileNotFound", new String[] { plcMessageConfigFile }, ex);
			throw rmEx;
		}
	}

}
