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
package net.form105.rm.server.ant.hotfolder;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple handler to access the hotfolders.
 * @author heikok
 *
 */
public class HotfolderHandler {
	
	private List<Hotfolder> hotfolderList = new ArrayList<Hotfolder>();
	
	public void addHotfolder(Hotfolder hf) {
		hotfolderList.add(hf);
	}
	
	public List<Hotfolder> getHotfolderList() {
		return hotfolderList;
	}
	
	public Hotfolder getHotfolderByName(String hotfolderPathName) {
		for (Hotfolder hotfolder : hotfolderList) {
			if (hotfolder.getHotfolder().equals(hotfolderPathName)) return hotfolder;
		}
		return new Hotfolder();
	}

}
