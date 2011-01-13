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

import net.form105.rm.base.AbstractTest;
import net.form105.rm.base.command.AbstractCallbackCommand;
import net.form105.rm.base.command.CommandEvent;
import net.form105.rm.base.command.ICommand;
import net.form105.rm.base.exception.RMException;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;


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
public class AntCommandHandlerTest extends AbstractTest {
	
	public static Logger logger = Logger.getLogger(AntCommandHandlerTest.class);
	
	@Mock private AntExecutionCommand command;
	@Mock private IExecutionStrategy strategy;
	private AntCommandHandler handler;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		//super.setupContainer();
		
	}
	
	@Test
	public void testCommandExecution() throws Exception {
		handler = new AntCommandHandler(strategy);
		when(strategy.isExecutable(any(ICommand.class))).thenReturn(true);
		
		// add to stack
		handler.execute(command);
		
		// execute command
		handler.singleRun();
		verify(strategy).isExecutable(any(Object.class));
		//Thread.sleep(500);
		verify(command).execute();
	}
	
	@Test
	public void testCommandStackedOnQueue() {
		handler = new AntCommandHandler(strategy);
		when(strategy.isExecutable(any(ICommand.class))).thenReturn(false);
		// add to stack
		handler.execute(command);
		// execute command
		handler.singleRun();
		verify(strategy).isExecutable(any(Object.class));
		verify(command, never()).execute();
		
	}
	

}
