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

import net.form105.rm.base.Agent;
import net.form105.rm.server.ant.container.HotfolderContainer;

import org.apache.log4j.Logger;

public class HotfolderWorker implements Runnable {
	
	public static Logger logger = Logger.getLogger(HotfolderWorker.class);

	private boolean running = true;

	public HotfolderWorker() {
	}

	@Override
	public void run() {
		while (running) {
			
			HotfolderContainer hfContainer = (HotfolderContainer) Agent.getComponentById("hotfolders");
			
			
			for (Hotfolder hotfolder : hfContainer.getHotfolderList()) {
				hotfolder.compareContent(true);
			}
			//logger.info("finished iterating hotfolders");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
