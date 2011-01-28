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
package net.form105.rm.base.rmi;

import net.form105.rm.base.model.IAgentObject;

/**
 * The callback interface to notify clients by calling back. The agent object will be send by the individual
 * method which identifies the action.
 * @author heikok
 *
 */
public interface ICallbackClient {
	
	public abstract void update(IAgentObject agentObject);
	
	public abstract void add(IAgentObject agentObject);
	
	public abstract void remove(IAgentObject agentObject);

}
