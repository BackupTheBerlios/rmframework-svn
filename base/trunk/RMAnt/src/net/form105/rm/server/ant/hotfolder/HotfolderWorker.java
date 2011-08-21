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

import org.apache.log4j.Logger;
import org.picocontainer.Startable;

public class HotfolderWorker implements Runnable, Startable {
	
	public static Logger logger = Logger.getLogger(HotfolderWorker.class);

	private boolean running = true;
	private List<AbstractInboundReceiver> receivers = new ArrayList<AbstractInboundReceiver>();
	

	@Override
	public void run() {
		while (running) {
			
			for (AbstractInboundReceiver receiver : receivers) {
				receiver.prepareInboundObjects();
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
	
	public synchronized void addReceiver(AbstractInboundReceiver receiver) {
		receivers.add(receiver);
	}

	@Override
	public void start() {
		Thread thread = new Thread(this);
		thread.start();
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}
	
	

}
