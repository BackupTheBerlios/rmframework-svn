/*
 * Copyright (c) 2011, form105 Heiko Kundlacz
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
package net.form105.rm.server.ant.property;

import java.util.Properties;

public class AntPropertyObject implements IPropertyObject {
	
	private Properties properties;
	
	public AntPropertyObject(Properties properties) {
		this.properties = properties;
	}
	
	/* (non-Javadoc)
	 * @see net.form105.rm.server.ant.property.IPropertyObject#getProperties()
	 */
	public Properties getProperties() {
		return properties;
	}
	
	/* (non-Javadoc)
	 * @see net.form105.rm.server.ant.property.IPropertyObject#addProperty(java.lang.String, java.lang.String)
	 */
	public void addProperty(String key, String value) {
		properties.put(key, value);
	}
	
	/* (non-Javadoc)
	 * @see net.form105.rm.server.ant.property.IPropertyObject#getProperty(java.lang.String)
	 */
	public String getProperty(String key) {
		return properties.getProperty(key);
	}
	
	/* (non-Javadoc)
	 * @see net.form105.rm.server.ant.property.IPropertyObject#getAsString()
	 */
	public String getAsString() {
		StringBuilder sBuilder = new StringBuilder();
		for (Object object : properties.keySet()) {
			sBuilder.append("-D").append((String) object).append('=').append((String) properties.get(object)).append(' ');
		}
		return sBuilder.toString();
	}
	
	

}
