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
package net.form105.rm.base;

import org.picocontainer.DefaultPicoContainer;

/**
 * A simple container that works like a factory. Containers can be added and new instances can be
 * retrieved by a class name
 * @author heiko
 * TODO: Create a LifecycleStrategy for network interfaces
 */
public class FactoryContainer {
	
	private static FactoryContainer instance;
	private static DefaultPicoContainer container;
	
	static {
        instance = new FactoryContainer();
        instance.initialize();
    }
	
	private void initialize() {
        container = new DefaultPicoContainer();
    }
	
	public FactoryContainer getInstance() {
		return instance;
	}
	
	public void addClass(String className) {
		container.addComponent(className);
	}
	
	public <T> T getObjectInstance(Class<T> clazz) {
		T object = container.getComponent(clazz);
		return object;
	}
	
	

}
