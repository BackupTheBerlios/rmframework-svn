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
package net.form105.rm.base.integration.protocol.codec;

import org.apache.log4j.Logger;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

public class KaiserPlcInboundReceiptEncoder implements ProtocolEncoder {
    
    public static Logger logger = Logger.getLogger(KaiserPlcInboundReceiptEncoder.class);

    public void dispose(IoSession session) throws Exception {
        

    }

    public void encode(IoSession session, Object message, ProtocolEncoderOutput out) throws Exception {
        byte[] inMessage = (byte[]) message;
        inMessage[1] = 2;
        out.write(IoBuffer.wrap(inMessage));
    }

}
