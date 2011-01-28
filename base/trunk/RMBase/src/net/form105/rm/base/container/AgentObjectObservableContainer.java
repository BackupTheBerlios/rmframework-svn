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
package net.form105.rm.base.container;

import net.form105.rm.base.observer.AbstractAgentObjectObservable;

/**
 * A container which holds the observables for the model objects and is registered as a pico container
 * @author heikok
 *
 */
public class AgentObjectObservableContainer extends AbstractContainer {
	
	@SuppressWarnings("unchecked")
	private AbstractAgentObjectObservable[] observables;
	
	@SuppressWarnings("unchecked")
	public AgentObjectObservableContainer(AbstractAgentObjectObservable[] observables) {
		this.observables = observables;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void start() {
		for (AbstractAgentObjectObservable observable : observables) {
			logger.info("Starting observable: "+observable.getClass().getSimpleName());
		}
	}

	@Override
	public void stop() {

	}

}
