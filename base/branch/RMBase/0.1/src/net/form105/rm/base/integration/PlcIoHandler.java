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

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

public class PlcIoHandler implements IoHandler {
    
    public static Logger logger = Logger.getLogger(PlcIoHandler.class);

    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        // TODO Auto-generated method stub

    }

    public void messageReceived(IoSession session, Object message) throws Exception {
        logger.info("message received: "+message);

    }

    public void messageSent(IoSession session, Object message) throws Exception {
        // TODO Auto-generated method stub

    }

    public void sessionClosed(IoSession session) throws Exception {
        // TODO Auto-generated method stub

    }

    public void sessionCreated(IoSession session) throws Exception {
        // TODO Auto-generated method stub

    }

    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        // TODO Auto-generated method stub

    }

    public void sessionOpened(IoSession session) throws Exception {
        // TODO Auto-generated method stub

    }

}
