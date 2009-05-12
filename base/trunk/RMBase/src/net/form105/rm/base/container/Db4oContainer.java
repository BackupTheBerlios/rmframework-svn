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

import net.form105.rm.base.dao.db.IDbSelector;
import net.form105.rm.base.dao.db.SingleDBSelector;

import org.picocontainer.Startable;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.config.Configuration;

public class Db4oContainer implements Startable {
    
    private PropertiesContainer propertiesContainer;
    private Configuration configuration;
    private IDbSelector dbSelector;
    private String dboFile;
    
    public Db4oContainer(PropertiesContainer propertiesContainer) {
        this.propertiesContainer = propertiesContainer;
    }

    @Override
    public void start() {
        dboFile = propertiesContainer.getProperty("server.db4o.defaultPath");
    }

    @Override
    public void stop() {
        dbSelector.getObjectContainer().close();
    }
    
    /**
     * Get the db4o configuration
     * @return
     */
    public Configuration getConfiguration() {
        return configuration;
    }
    
    protected void config(Configuration dbConfig) {
        dbConfig.objectClass("net.form105.rm.base.model.Resource").cascadeOnDelete(true);
    }
    
    public ObjectContainer getDb4oContainer() {
        configuration = Db4o.newConfiguration();
        dbSelector = new SingleDBSelector(dboFile);
        return dbSelector.getObjectContainer();
    }

}
