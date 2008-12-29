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

import net.form105.rm.base.integration.decoder.KaiserPlcPacketHeader;

import org.apache.log4j.Logger;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

public class KaiserPlcInboundHeaderDecoder extends CumulativeProtocolDecoder {
    
    public static Logger logger = Logger.getLogger(KaiserPlcInboundHeaderDecoder.class);
    
    private int savedPackageNo = 0;

    @Override
    protected boolean doDecode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {
        
        // getting the header
        if (in.remaining() >= 132) {
           
           KaiserPlcPacketHeader packetHeader = new KaiserPlcPacketHeader();
           packetHeader.setPackageType(in.get() << 8 | in.get());
           packetHeader.setPackageNo(in.get() << 8 | in.get());
           packetHeader.setPackageSource(in.get() << 8 | in.get());
           packetHeader.setPackageSink(in.get() << 8 | in.get());
           
           if (packetHeader.isValid()) {

               sendReceipt(session, in);
           } else {
               logger.warn("Got wrong packet header ... closing/clearing session!");
               session.close();
               return false;
           }
           
           out.write(in);
           return true;
        } else {
            return false;
        }
    }
    
    public void sendReceipt(IoSession session, IoBuffer in) {
        byte[] bytes = in.array();
        byte[] aknowledge = new byte[12];
        System.arraycopy(bytes, 0, aknowledge, 0, 12);
        session.write(aknowledge);
    }

}
