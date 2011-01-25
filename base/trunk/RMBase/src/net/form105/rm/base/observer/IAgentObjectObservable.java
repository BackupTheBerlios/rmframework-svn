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
package net.form105.rm.base.observer;

import net.form105.rm.base.model.IAgentObject;
import net.form105.rm.base.model.workflow.Workflow;

/**
 * The observable interface for the observer pattern. The observable works on {@link IAgentObject}. 
 * Currently a change in the model is only delegated to the top model objects like {@link Workflow}.
 * An observer can be added by addObserver method an removed with the removeObserver method. Only three
 * simple operations are delegated to the observer: add, remove and update.
 * @author heikok
 *
 * @param <T>
 */
public interface IAgentObjectObservable<T extends IAgentObject> {

	public abstract void addObserver(IAgentObjectObserver<T> observer);

	public abstract void removeObserver(IAgentObjectObserver<T> observer);

	public abstract void notifyAdd(T agentObject);

	public abstract void notifyRemove(T agentObject);

	public abstract void notifyUpdate(T agentObject);

}