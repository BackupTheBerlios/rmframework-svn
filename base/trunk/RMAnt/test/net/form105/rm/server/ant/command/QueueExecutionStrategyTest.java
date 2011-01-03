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
package net.form105.rm.server.ant.command;

import java.util.concurrent.ConcurrentLinkedQueue;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class QueueExecutionStrategyTest {
	
	private QueueExecutionStrategy<String> strategy = null;
	private ConcurrentLinkedQueue<String> queue ;
	
	@Before
	public void setUp() {
		
		queue = new ConcurrentLinkedQueue<String>();
		
		for (int i = 0; i < 50; i++) {
			queue.add(new String("a"+i));
		}
		strategy = new QueueExecutionStrategy<String>(queue);
			
	}

	@Test
	public void testPipeElement() {
		strategy.pipeElement();
		Assert.assertEquals(true, queue.contains("a"+1));
		String element;
		int i = 0;
		for (String s : queue) {
			
			element = queue.poll();
			if (i == 0) {
				Assert.assertEquals("a"+1, element);
			}
			if (i == 49) {
				Assert.assertEquals("a"+0, element);
			}
			i++;
		}
	}

	@Test
	public void testUseElement() {
		int startSize = queue.size();
		strategy.useElement();
		Assert.assertEquals(startSize - 1, queue.size());
		
	}
}
