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

import java.util.HashMap;
import java.util.Map;

import net.form105.rm.base.Container;
import net.form105.rm.base.util.helper.FileHelper;
import net.form105.xml.schema.model.ConnectionPoolDocument;
import net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Outbound;
import net.form105.xml.schema.model.ServerConfigDocument.ServerConfig.Inbound;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;
import org.picocontainer.Startable;

public class ConnectionPoolContainer implements Startable {
    
    public static Logger logger = Logger.getLogger(ConnectionPoolContainer.class);
    
    private Map<String, Inbound> inboundMap = new HashMap<String, Inbound>();
    private Map<String, Outbound> outboundMap = new HashMap<String, Outbound>();
    
    private final String CONNECTIONPOOL_FILE = "serverConfig.xml";

    public void start() {
        

    }

    public void stop() {
    	logger.info("Stopping container: "+getClass().getCanonicalName());
    }
    
    private void loadXmlConfiguration() {
        String configDir = Container.getInstance().getConfiguration().getConfigurationDirectory();
        String file = FileHelper.appendFileSeparator(configDir) + CONNECTIONPOOL_FILE;
        
        ConnectionPoolDocument poolDocument;
        try {
            poolDocument = ConnectionPoolDocument.Factory.parse(FileHelper.appendFileSeparator(configDir) + CONNECTIONPOOL_FILE);
            
        } catch (XmlException e) {
            logger.error(e, e);
        } 
    }

}
