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

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import net.form105.rm.base.container.RMIServerContainer;

import org.apache.log4j.Logger;
import org.picocontainer.Startable;

public class RMICallbackServer extends UnicastRemoteObject implements ICallbackServer, Startable {

	private static final long serialVersionUID = 1586700339636394193L;

	public static Logger logger = Logger.getLogger(RMICallbackServer.class);

	private List<ICallbackClient> clientList = new ArrayList<ICallbackClient>();
	private RMIServerContainer serverContainer;
	private final String registryName = "callbackServer";

	public RMICallbackServer(RMIServerContainer serverContainer) throws RemoteException {
		super();
		this.serverContainer = serverContainer;
	}

	@Override
	public void registerForCallback(ICallbackClient callbackClientObject) {
		if (!clientList.contains(callbackClientObject)) {
			logger.info("Registering client for callbacks");
			clientList.add(callbackClientObject);
		} else {
			logger.error("A client has already registered");
		}

	}

	@Override
	public void unregisterForCallback(ICallbackClient callbackClientObject) {
		if (clientList.contains(callbackClientObject)) {
			logger.info("Unregistering client for callbacks");
			clientList.remove(callbackClientObject);
		} else {
			logger.error("A client isn't registered. Can't remove it from the callback list");
		}
	}

	@Override
	public String getName() throws RemoteException {
		return registryName;
	}

	@Override
	public void start() {
		try {
			serverContainer.getRegistry().rebind(getName(), this);
		} catch (RemoteException ex) {
			logger.error("Error in rebinding the RMICallbackServer to the registry", ex);
		}
	}

	@Override
	public void stop() {

	}

}
