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
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

public class KaiserPlcInboundContentHeaderDecoder implements ProtocolDecoder {
    public static Logger logger = Logger.getLogger(KaiserPlcInboundContentHeaderDecoder.class);

    public void decode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {
        
        if (in.remaining() >= 12) {
            logger.info("greater than 12");
        }
        
        
        
        out.write(in);
    }

    public void dispose(IoSession session) throws Exception {
        // TODO Auto-generated method stub

    }

    public void finishDecode(IoSession session, ProtocolDecoderOutput out) throws Exception {
        // TODO Auto-generated method stub

    }

}
