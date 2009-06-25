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

import java.net.InetSocketAddress;
import java.net.SocketAddress;

import org.apache.log4j.Logger;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.future.IoFutureListener;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoEventType;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.logging.LogLevel;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.junit.Test;

public class KaiserPlcClient extends IoHandlerAdapter {
    
    public static Logger logger = Logger.getLogger(KaiserPlcClient.class);
    
    private IoSession session;

    @Test
    public void connect() {
        NioSocketConnector connector = new NioSocketConnector();
        connector.setHandler(this);
        LoggingFilter logFilter = new LoggingFilter();
        logFilter.setLogLevel(IoEventType.MESSAGE_SENT, LogLevel.DEBUG);
        connector.getFilterChain().addLast("logger", logFilter);
        SocketAddress remoteAddress = new InetSocketAddress("localhost", 50005);
        ConnectFuture cFuture = connector.connect(remoteAddress);
        cFuture.awaitUninterruptibly();
        
        cFuture.addListener(new IoFutureListener<ConnectFuture>() {

            public void operationComplete(ConnectFuture future) {
                if (future.isConnected()) {
                    session = future.getSession();
                    logger.info("opened connection to server");
                    try {
                        sendMessage();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    //future.getSession().close();
                } else {
                    logger.info("Can't connect to socket on localhost:50005 !");
                } 
            }
            
        });
        logger.info("finished");

    }

    public void messageReceived(IoSession session, Object message) throws Exception {
        IoBuffer buffer = (IoBuffer) message;
        logger.info("receivedMessage");
        
    }
    
    public void sendMessage() throws InterruptedException {
        
        byte[] sendByte = new byte[132];
        // packageType
        sendByte[0] = 0;
        sendByte[1] = 1;
        // packageNo
        sendByte[2] = (byte) 514 >> 8 & 0xff;
        sendByte[3] = (byte) 514 >> 0 & 0xff;
        // packageSource
        sendByte[4] = 0;
        sendByte[5] = 1;
        // packageSink
        sendByte[6] = (byte) 101 >> 8 & 0xff;
        sendByte[7] = (byte) 101 >> 0 & 0xff;
        // packageEnd
        sendByte[8] = (byte) 0xFFFFFFFF >> 24;
        sendByte[9] = (byte) 0xFFFFFFFF >> 16;
        sendByte[10] = (byte) 0xFFFFFFFF >> 8;
        sendByte[11] = (byte) 0xFFFFFFFF >> 0;
        
        for (int i = 12; i < 132; i++) {
            sendByte[i] = 0;
        }
        
//        sendByte[12] = (byte) 0xFFFFFFFF >> 24;
//        sendByte[13] = (byte) 0xFFFFFFFF >> 16;
//        sendByte[14] = (byte) 0xFFFFFFFF >> 8;
//        sendByte[15] = (byte) 0xFFFFFFFF >> 0;
        
        
        
        
        IoBuffer buffer = IoBuffer.allocate(132);
        buffer.put(sendByte);
        buffer.flip();
        logger.info("write buffer");
        session.write(buffer);

    }
    
    

}
