/*
 * BackgroundThread.java, Oct 28, 2007, 4:58:11 PM
 * 
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */

package net.form105.rm.base;

import org.apache.log4j.Logger;

public class BackgroundThread implements Runnable {

	private static Logger logger = Logger.getLogger(BackgroundThread.class);
	private boolean running = false;

	public void run() {
		running = true;
		while (running) {
			try {
				Thread.sleep(Long.MAX_VALUE);
			} catch (InterruptedException ex) {
				logger.error("Thread interrupted. ", ex);
			}
		}
		logger.info("Main thread stopped ...");

	}

	public void stop() {
			running = false;
			this.notify();
		

	}

}
