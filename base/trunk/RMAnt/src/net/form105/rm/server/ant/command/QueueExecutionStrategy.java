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

import java.util.Queue;

public class QueueExecutionStrategy<T> {

	private Queue<T> queue;

	public QueueExecutionStrategy(Queue<T> queue) {
		this.queue = queue;
	}

	public T pipeElement() {
		synchronized (queue) {
			T element = queue.poll();
			queue.add(element);
			return element;
		}
	}

	public T useElement() {
		T element = queue.poll();
		return element;

		// WorkflowContainer wfContainer = (WorkflowContainer)
		// AntAgent.getComponentById("workflows");
		// WorkflowByAttributeSelection selection = new
		// WorkflowByAttributeSelection(Globals.ATTRIBUTE_ID_HOTFOLDER,
		// container);
		// WorkflowByAttributeValueFilter filter = new
		// WorkflowByAttributeValueFilter();
		// DefaultFilterQuery<Workflow> query = new
		// DefaultFilterQuery<Workflow>(selection);
	}

}
