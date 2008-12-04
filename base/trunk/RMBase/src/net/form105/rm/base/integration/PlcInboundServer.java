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
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import net.form105.rm.base.Container;
import net.form105.rm.base.exception.RMException;
import net.form105.rm.base.integration.protocol.validator.IByteIdentifier;
import net.form105.rm.base.integration.protocol.validator.IProtocolValidator;
import net.form105.rm.server.i18n.BaseMessage;
import net.form105.xml.schema.model.ServerConfigDocument.ServerConfig.Inbound;

import org.apache.log4j.Logger;

/**
 * The serverInetAddress is the address of the local host (usually).
 * 
 * @author heiko
 * 
 */
public class PlcInboundServer implements Runnable {

	public static Logger logger = Logger.getLogger(PlcInboundServer.class);

	private String id;
	private String alias;
	private int port;
	private String type;
	private String serverHostname;
	private int sizePendingQueue;
	private int packetSize;

	private IByteIdentifier contentIdentifier;

	private boolean running = false;
	private boolean connected = false;
	private ServerSocket serverSocket;

	private Thread thread;

	private IProtocolValidator validator;

	public PlcInboundServer(Inbound inboundConfig) {
		this.id = inboundConfig.getId();
		this.alias = inboundConfig.getAlias();
		this.port = inboundConfig.getPort();
		this.type = inboundConfig.getType();
		this.packetSize = inboundConfig.getPacketSize();
		// ip address or hostname of the server / localhost
		this.serverHostname = inboundConfig.getHost();
		this.sizePendingQueue = inboundConfig.getSizePendingQueue();
		this.validator = (IProtocolValidator) Container.getFactoryContainer().getComponent(inboundConfig.getValidatorKey());
		this.contentIdentifier = (IByteIdentifier) Container.getFactoryContainer().getComponent(inboundConfig.getContentIdentifier());
	}

	public void initialize() {
		serverSocket = createSocket();

	}

	@Override
	public void run() {
		while (running) {
			try {
				logger.info("Server Socket is bound: " + serverSocket.isBound());
				logger.info("Server Socket buffer size: " + serverSocket.getReceiveBufferSize());
				Socket socket = serverSocket.accept();
				connected = true;
				DataInputStream inputStream = new DataInputStream(socket.getInputStream());
				DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
				// dataStream.skip(dataStream.available());

				logger.info("Server Socket is bound: " + serverSocket.isBound());
				while (connected) {

					byte[] completeByte = new byte[packetSize];

					inputStream.readFully(completeByte);
					logByteStream("input byte stream received: ", completeByte);

					long start = System.currentTimeMillis();

					boolean headerIsValid = validator.isValid(completeByte);

					if (headerIsValid) {
						// create the packetContent
						int contentLength = packetSize - validator.getHeaderLength();
						byte[] contentPacket = new byte[contentLength];
						System.arraycopy(completeByte, validator.getHeaderLength() - 1, contentPacket, 0, contentLength);

						// send acknowledgement

						// check if a template exist and if so, create a message
						// and put it on the messageQueue
						// the hashcode of the contentHeader must match the
						// template hashCode
						
						// Create a message and send it to the message controller
						
						

					}

					long elapsed = System.currentTimeMillis() - start;
					logger.info("time elapsed: " + elapsed);
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
			RMException rmEx = new RMException(new BaseMessage(), "exception.network.unknownHost",
					new String[] { serverHostname }, uhEx);
			throw rmEx;
		} catch (IOException ioEx) {
			logger.error("Error connecting to socket on " + serverHostname + ":" + port);
			logger.error(ioEx, ioEx);
		}
		return serverSocket;
	}

	/**
	 * Starts a new thread for each input server
	 */
	public void connect() {
		running = true;
		String threadName = alias + ":" + serverHostname + ":" + port;
		logger.info("Starting thread for inbound server :" + threadName);
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
