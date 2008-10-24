/*
 * Copyright (c) 2008, form105 Heiko Kundlacz
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
package com.form105.rm.base.network;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class AbstractClientSocket {
	
	private Socket socket;
	
	public void send(String hostname, int port, byte[] outboundBytes) throws IOException {
		try {
			socket = new Socket(hostname, port);
			DataOutputStream outStream = new DataOutputStream(socket.getOutputStream());
			outStream.write(outboundBytes);
			outStream.flush();
			//outStream.close();
			//socket.close();
			System.out.println("package was sent");
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} 
		
	}
	
	public Socket open(String hostname, int port) {
		Socket socket = null;
		try {
			socket = new Socket(hostname, port);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return socket;
	}
	
	

}
