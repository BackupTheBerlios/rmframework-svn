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

import org.junit.Test;

public class SendClientSocketTest extends AbstractClientSocket {

	@Test
	public void sendInteger1028() {
		byte[] intBytes = new byte[2];
		String s = "schwizeroergeli";

		int valueInt = 1029;

		intBytes[0] = (byte) ((valueInt >> 8) & 0xff);
		intBytes[1] = (byte) ((valueInt >> 0) & 0xff);

		Socket socket = open("192.168.1.141", 50005);
		DataOutputStream outStream;
		try {
			outStream = new DataOutputStream(socket.getOutputStream());
			for (int i = 0; i < 10; i++) {
				System.out.println("Send Date: "+i);
				outStream.write(intBytes);
				outStream.flush();
				Thread.sleep(1000);
			}
			
			outStream.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		/*
		 * for (int i = 0; i < 1000; i++) {
		 * 
		 * try { send("192.168.1.148", 50003, intBytes); } catch (IOException
		 * e1) { e1.printStackTrace(); } try {
		 * 
		 * Thread.sleep(1000); } catch (InterruptedException e) {
		 * e.printStackTrace(); } }
		 */
	}

}
