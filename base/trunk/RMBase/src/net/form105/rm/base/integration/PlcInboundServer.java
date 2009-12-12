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

import net.form105.rm.base.integration.protocol.codec.PlcServerCodecFactory;
import net.form105.rm.base.integration.protocol.codec.ProtocolDecoderType;
import net.form105.rm.base.integration.protocol.codec.ProtocolEncoderType;
import net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Inbound;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

public class PlcInboundServer {
    
    public static Logger logger = Logger.getLogger(PlcInboundServer.class);

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

        acceptor = new NioSocketAcceptor();
        acceptor.getFilterChain().addLast("logger", new LoggingFilter());
        acceptor.getFilterChain().addLast("header", new ProtocolCodecFilter(new PlcServerCodecFactory(true, false)));
        ProtocolCodecFilter contentFilter = new ProtocolCodecFilter(ProtocolEncoderType.KaiserContentDecoder.getCoder(), ProtocolDecoderType.KaiserContentDecoder.getCoder());
        acceptor.getFilterChain().addLast("content", contentFilter);
        
        acceptor.setHandler(new PlcIoHandler());
        connect();
        logger.info("PlcInboundServer is listening on port: "+port);
        
//        IoServiceManager serviceManager = new IoServiceManager( acceptor );
//
//        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
//        ObjectName name = new ObjectName("mina.example.http.server:type=IoServiceManager");
//        mbs.registerMBean(acceptor, name);

    }

    public void connect() {

        try {
            acceptor.bind(new InetSocketAddress(port));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
