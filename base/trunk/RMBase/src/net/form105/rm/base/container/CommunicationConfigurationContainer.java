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
import net.form105.rm.base.integration.IMessageTemplate;
import net.form105.rm.server.i18n.BaseI18NMessage;
import net.form105.xml.schema.model.ComElementsDocument;
import net.form105.xml.schema.model.ServerConfigDocument;
import net.form105.xml.schema.model.ComElementsDocument.ComElements;
import net.form105.xml.schema.model.ComElementsDocument.ComElements.Key;

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
	private static String plcConfigFileName = "plc.xml";
	private ServerConfigDocument serverConfigDocument;
	private String plcMessageConfigFile;
	private PropertiesContainer propContainer;
	
	
	
	private HashMap<Integer, IMessageTemplate> templateRegistry = new HashMap<Integer, IMessageTemplate>(); 

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

	/**
	 * Loading the xml configuration for the plc message templates.
	 */
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
			serverConfigDocument = ServerConfigDocument.Factory.parse(new File(configDir + serverConfigFilename));
		} catch (XmlException e) {
			logger.error(e, e);
		} catch (IOException ex) {
			RMException rmEx = new RMException(new BaseI18NMessage(), "exception.fileNotFound",
					new String[] { configFile }, ex);
			throw rmEx;
		}

		plcMessageConfigFile = configDir + plcConfigFileName;
		
		readPlcMessageConfiguration();
	}

	public void start() {
		initialize();

	}

	public void stop() {
		configDir = Container.getInstance().getConfiguration().getConfigurationDirectory();
	}

	/**
	 * Getting the configuration of the plc messages from the xmlHelper schema and register them in the 
	 * hashmap
	 * 
	 * @return The document containing the configuration
	 */
	public void readPlcMessageConfiguration() {

		try {
		    
		    ComElementsDocument comElementsDocument = ComElementsDocument.Factory.parse(new File(plcMessageConfigFile));
		    ComElements elements = comElementsDocument.getComElements();
		    
		    
		    
		    for (Key key : elements.getKeyArray()) {
		        logger.info(key.getK1()+":"+key.getK2());
		    }
			/*PlcMessagesDocument plcMessageConfigDocument = PlcMessagesDocument.Factory.parse(new File(
					plcMessageConfigFile));
			PlcMessages messages = plcMessageConfigDocument.getPlcMessages();

			for (PlcMessage message : messages.getPlcMessageArray()) {
				PlcMessageTemplate template = new PlcMessageTemplate(message);
				templateRegistry.put(template.getHashcode(), template);
			}*/
		} catch (XmlException e) {
			logger.error(e, e);
		} catch (IOException ex) {
			RMException rmEx = new RMException(new BaseI18NMessage(), "exception.fileNotFound", new String[] { plcMessageConfigFile }, ex);
			throw rmEx;
		}
	}
	
	/**
	 * Adding a template to the plc message registry
	 * @param template
	 */
	public void addTemplate(IMessageTemplate template) {
		templateRegistry.put(template.getHashcode(), template);
	}
	
	/**
	 * Getting a template by its hashcode
	 * @param hashcode The hashcode of the template
	 * @return
	 */
	public IMessageTemplate getTemplate(Integer hashcode) {
		return templateRegistry.get(hashcode);
	}
	
	public ServerConfigDocument getServerConfig() {
		return serverConfigDocument;
	}

}
