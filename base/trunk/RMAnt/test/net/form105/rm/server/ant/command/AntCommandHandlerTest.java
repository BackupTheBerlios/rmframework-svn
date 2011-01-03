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
/**
 * 
 */
package net.form105.rm.server.ant.command;


import junit.framework.Assert;
import net.form105.rm.base.command.AbstractCallbackCommand;
import net.form105.rm.base.command.CommandEvent;
import net.form105.rm.base.exception.RMException;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

/**
 * The test should use the thread extensively. We use explicitely the AntCommandHandler in the threaded mode.
 * Threaded mode of AntCommandHandler reads available commands from a stack. It can execute a command for a 
 * group only, if one isn't running in the same group.
 * 
 * Testing the handler:
 * 1. Create commands (for different hotfolders and must be of type AbstractCommand (TestCommand) with 
 * 	group set -> group per hotfolder)
 * 2. Add them to the queue (group1 and group2)
 * 3. 
 * @author heikok
 *
 */
public class AntCommandHandlerTest {
	
	public static Logger logger = Logger.getLogger(AntCommandHandlerTest.class);
	
	

	AntCommandHandler handler;
	
	@Before
	public void setUp() throws Exception {
		handler = new AntCommandHandler();
		
		Thread thread = new Thread(handler);
		thread.start();	
	}
	
	@Test
	public void testAddToStack() throws Exception {
		for (int i = 0; i <= 100; i++) {
			handler.addToStack(new TestCommand("group1"));
			handler.addToStack(new TestCommand("group2"));
			
			System.out.println("add to stack: "+i);
		}
		
		Assert.assertEquals(201, handler.getCommandQueue().size());
		
		
	}
	
	public class TestCommand extends AbstractCallbackCommand {
		
		public TestCommand(String group) {
			setGroup(group);
			registerCommandListener(handler);
		}

		@Override
		public void execute() throws RMException {
			
			System.out.println("executed");
			
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			CommandEvent event = new CommandEvent(this);
			this.getCommandListener().finished(event);
		}
		
	}

}
