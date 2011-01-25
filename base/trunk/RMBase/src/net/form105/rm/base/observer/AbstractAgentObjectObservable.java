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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;

import net.form105.rm.base.model.IAgentObject;

import org.apache.log4j.Logger;

public abstract class AbstractAgentObjectObservable <T extends IAgentObject> extends Observable implements IAgentObjectObservable<T> {

	public static Logger logger = Logger.getLogger(AbstractAgentObjectObservable.class);
	
	private List<IAgentObjectObserver<T>> observerList = Collections.synchronizedList(new ArrayList<IAgentObjectObserver<T>>());
	
	/* (non-Javadoc)
	 * @see net.form105.rm.base.observer.IAgentObjectObservable#addObserver(net.form105.rm.base.observer.IAgentObjectObserver)
	 */
	public void addObserver(IAgentObjectObserver<T> observer) {
		if (! observerList.contains(observer)) {
			observerList.add(observer);
		} else {
			logger.warn("Observer has been already registered: "+observer);
		}
	}
	
	/* (non-Javadoc)
	 * @see net.form105.rm.base.observer.IAgentObjectObservable#removeObserver(net.form105.rm.base.observer.IAgentObjectObserver)
	 */
	public void removeObserver(IAgentObjectObserver<T> observer) {
		if (observerList.contains(observer)) {
			observerList.remove(observer);
		} else {
			logger.warn("Observer can't be removed from the observer list: "+observer);
		}
	}
	
	/* (non-Javadoc)
	 * @see net.form105.rm.base.observer.IAgentObjectObservable#notifyAdd(T)
	 */
	public void notifyAdd(T agentObject) {
		for (IAgentObjectObserver<T> observer : observerList) {
			observer.added(agentObject);
		}
	}
	
	/* (non-Javadoc)
	 * @see net.form105.rm.base.observer.IAgentObjectObservable#notifyRemove(T)
	 */
	public void notifyRemove(T agentObject) {
		for (IAgentObjectObserver<T> observer : observerList) {
			observer.removed(agentObject);
		}
	}
	
	/* (non-Javadoc)
	 * @see net.form105.rm.base.observer.IAgentObjectObservable#notifyUpdate(T)
	 */
	public void notifyUpdate(T agentObject) {
		for (IAgentObjectObserver<T> observer : observerList) {
			observer.updated(agentObject);
		}
	}
	
}
