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
package net.form105.rm.base.message;

import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Logger;
import org.picocontainer.Startable;

/**
 * The message queue has messages on the stack and processes them in its own thread
 * @author heiko
 *
 */
public class MessageQueue implements Startable, Runnable {
	
	public static Logger logger = Logger.getLogger(MessageQueue.class);
	
	private boolean running; 

	private LinkedBlockingQueue<IMessage> messageQueue;
	private Thread thread;
	
	
	@Override
	public void start() {
		running = true;
		
		thread = new Thread(this, "MessageQueue");
		thread.start();
		logger.info("MessageQueue has been started.");
		
	}

	@Override
	public void stop() {
		
		running = false;
		
	}

	@Override
	public void run() {
		while (running) {
			try {
				// take a message and delegate it to a service
				IMessage message = messageQueue.take();
			} catch (InterruptedException e) {
				logger.error(e,e);
			}
		}
		
	}
	
	

}
