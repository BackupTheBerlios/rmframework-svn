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
package net.form105.rm.server.ant.container;

import java.util.Collection;

import net.form105.rm.base.container.AbstractContainer;
import net.form105.rm.base.container.PropertiesContainer;
import net.form105.rm.server.ant.hotfolder.Hotfolder;
import net.form105.rm.server.ant.hotfolder.HotfolderMap;

/**
 * A simple handler to access the hotfolders. Currently this is used for integration with remote tests.
 * @author heikok
 *
 */
public class HotfolderContainer extends AbstractContainer {
	
	private HotfolderMap hotfolderMap;
	
	public HotfolderContainer(PropertiesContainer propContainer) {
		
	}
	
	public void addHotfolder(Hotfolder hf) {
		hotfolderMap.addHotfolder(hf);
	}
	
	public Collection<Hotfolder> getHotfolderList() {
		return hotfolderMap.getHotfolderList();
	}
	
	public Hotfolder getHotfolderByName(String hotfolderPathName) {
		return hotfolderMap.getHotfolder(hotfolderPathName);
	}

	public void start() {
		hotfolderMap = new HotfolderMap();
	}

	public void stop() {
		
	}
}
