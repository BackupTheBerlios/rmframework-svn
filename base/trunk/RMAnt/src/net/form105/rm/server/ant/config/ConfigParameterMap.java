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
package net.form105.rm.server.ant.config;

import java.util.HashMap;
import java.util.Map;

public class ConfigParameterMap {
	
	private Map<String, ConfigParameter> parameterMap;
	
	public ConfigParameterMap() {
		parameterMap = new HashMap<String, ConfigParameter>();
	}
	
	/**
	 * Adding a parameter to the map
	 * @param parameter
	 */
	public void addParameter(ConfigParameter parameter) {
		parameterMap.put(parameter.getKey(), parameter);
	}
	
	/**
	 * Get a parameter value by its key.
	 * @param key
	 * @return
	 */
	public String getParameter(String key) {
		return parameterMap.get(key).getKey();
	}

}
