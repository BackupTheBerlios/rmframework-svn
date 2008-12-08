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

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;

import net.form105.xml.schema.model.ServerConfigDocument.ServerConfig.Inbound;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

public class PlcInboundServer {
    
    private String id;
    private String alias;
    private int port;
    private String type;
    private String serverHostname;
    private int sizePendingQueue;
    private int packetSize;

    private boolean running = false;
    private boolean connected = false;
    private ServerSocket serverSocket;

    private Thread thread;

    
    private IoAcceptor acceptor;

    public PlcInboundServer(Inbound inboundConfig) {
            this.id = inboundConfig.getId();
            this.alias = inboundConfig.getAlias();
            this.port = inboundConfig.getPort();
            this.type = inboundConfig.getType();
            this.packetSize = inboundConfig.getPacketSize();
            // ip address or hostname of the server / localhost
            this.serverHostname = inboundConfig.getHost();
            this.sizePendingQueue = inboundConfig.getSizePendingQueue();
    }
    
    public void initialize() {
        
        IoAcceptor acceptor = new NioSocketAcceptor();
        
        
        SocketAddress socketAddress = new InetSocketAddress(port);
        
        acceptor.getFilterChain().addLast( "logger", new LoggingFilter() );

        
        try {
            acceptor.bind(socketAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }

        
    }
    
    public void connect() {
        
        try {
            acceptor.bind(new InetSocketAddress(port));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
