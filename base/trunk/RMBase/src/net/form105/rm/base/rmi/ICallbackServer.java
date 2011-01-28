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

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface ICallbackServer extends Remote {
	
	/**
	 * This method registers a client on the server for callback operation
	 * @param callbackClientObject The reference to the client. This object is registered on the server
	 */
	public void registerForCallback(ICallbackClient callbackClientObject) throws RemoteException;

	/**
	 * This method unregisters the client on the server. 
	 * @param callbackClientObject The reference to the client. This object will be unregistered on the server 
	 */
	public void unregisterForCallback(ICallbackClient callbackClientObject) throws RemoteException;
	
	/**
	 * Getting the name with which we register the callback server in the registry
	 * @return The name of the server for registration
	 */
	public String getName();
	
}
