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
package net.form105.rm.base.integration;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import net.form105.rm.base.exception.RMException;
import net.form105.rm.server.i18n.BaseMessage;
import net.form105.xml.schema.model.ServerConfigDocument.ServerConfig.Inbound;

import org.apache.log4j.Logger;

/**
 * The serverInetAddress is the address of the local host (usually).
 * @author heiko
 *
 */
public class PlcInputServer implements Runnable {
	
	public static Logger logger = Logger.getLogger(PlcInputServer.class);
	
	private String id;
	private String alias;
	private int port;
	private String type;
	private String serverHostname;
	private int sizePendingQueue;
	
	private boolean running = false;
	private boolean connected = false;
	private ServerSocket serverSocket;
	
	private Thread thread;
	
	
	public PlcInputServer(Inbound inboundConfig) {
		this.id = inboundConfig.getId();
		this.alias = inboundConfig.getAlias();
		this.port = inboundConfig.getPort();
		this.type = inboundConfig.getType();
		//ip address or hostname of the server / localhost
		this.serverHostname = inboundConfig.getHost();
		this.sizePendingQueue = inboundConfig.getSizePendingQueue();
	}
	
	public void initialize() {
		serverSocket = createSocket();
		
	}


	@Override
	public void run() {
		while(running) {
			try {
				Socket socket = serverSocket.accept();
				connected = true;
				DataInputStream inputStream = new DataInputStream(socket.getInputStream());
				DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
				//dataStream.skip(dataStream.available());
				while (connected) {
					
					
					byte[] completeByte = new byte[132];
					
					inputStream.readFully(completeByte);
					logByteStream("input byte stream received: " , completeByte);
					
					logger.info("got new package !!");
					
					long start = System.currentTimeMillis();
					
//					for (int i = 0; i < completeByte.length; i++) {
//						logger.info("# byte"+i+": "+new Integer(completeByte[i]));
//					}
					
					byte[] ackByte = new byte[132];
					System.arraycopy(completeByte, 0, ackByte, 0, 12);
					ackByte[0] = (byte) ((2 >> 8) & 0xff);
					ackByte[1] = (byte) ((2 >> 0) & 0xff);
					
					logByteStream("quittierung: ", ackByte);
					
					outputStream.write(ackByte);
					outputStream.flush();
					
					byte[] idArray = new byte[6];
					idArray[0] = completeByte[13];
					idArray[1] = completeByte[15];
					idArray[2] = completeByte[16];
					idArray[3] = completeByte[17];
					idArray[4] = completeByte[18];
					idArray[5] = completeByte[19];
					BigInteger bigInt = new BigInteger(idArray);
					logger.info(bigInt.hashCode());
					
					long elapsed = System.currentTimeMillis() - start;
					logger.info("time elapsed: "+elapsed);
					
					
					
				}
				
			} catch (EOFException eofEx) {
				// connection closed by the client
				logger.error(eofEx, eofEx);
				
			} catch (IOException ioe) {
				logger.error(ioe, ioe);
			}
		}
		
		
	}
	
	private ServerSocket createSocket() {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(port, sizePendingQueue, InetAddress.getByName(serverHostname));
		} catch (UnknownHostException uhEx) {
			logger.error(uhEx, uhEx);
			RMException rmEx = new RMException(new BaseMessage(), "exception.network.unknownHost", new String[] {serverHostname}, uhEx);
			throw rmEx;
		} catch (IOException ioEx) {
			logger.error(ioEx, ioEx);
		}
		return serverSocket;
	}
	
	public void connect() {
		running = true;
		String threadName = alias+":" +serverHostname+":"+port;
		logger.info("Starting thread for inbound server :"+threadName);
		thread = new Thread(this, threadName);
		thread.start();
	}
	
	/**
	 * Helper to log a byte stream
	 * 
	 * @param byteArray
	 */
	protected void logByteStream(String label, byte[] byteArray) {
		if (true) {
			StringBuilder telegramString = new StringBuilder("");
			for (int i = 0; i < byteArray.length; i++) {
				if ((i % 12) == 0) {
					telegramString.append("/ ");
				}
				telegramString.append(byteArray[i]);
				telegramString.append(" ");
			}
			logger.info(label + telegramString);
		}
	}
	
	
	

}
