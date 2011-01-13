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
package net.form105.rm.server.ant.hotfolder;


import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import net.form105.rm.base.AbstractTest;
import net.form105.rm.base.Agent;
import net.form105.rm.server.ant.command.AntCommandHandler;
import net.form105.rm.server.ant.command.AntExecutionCommand;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class DefaultHotfolderListenerTest extends AbstractTest{
	
	@Mock private AntExecutionCommand mockExecCommand;
	@Mock private HotfolderInboundObject mockInboundObject;
	@Mock private AntCommandHandler mockCommandHandler;
	@Mock private DefaultHotfolderListener mockHotfolderListener;
	@Mock private HotfolderEvent mockHotfolderEvent;
	@Mock private Agent mockAgent;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		//super.setupContainer();
	}

	public void testFileArrived() {
		
		when(mockHotfolderEvent.getInboundObject()).thenReturn(mockInboundObject);
		
		mockHotfolderListener.fileArrived(mockHotfolderEvent);
		
		AntCommandHandler cHandler = (AntCommandHandler) Agent.getContainer("commandHandler");
		
		verify(mockHotfolderEvent, times(2)).getInboundObject();
		verify(mockCommandHandler).addToStack(any(AntExecutionCommand.class));
		
		
	}
	
	@Test
	public void testDefaultHotfolderListener() {
		DefaultHotfolderListener listener = (DefaultHotfolderListener) Agent.getComponentById("hotfolderListener");
	}

	@Test
	public void testFileRemoved() {
		
	}

}
