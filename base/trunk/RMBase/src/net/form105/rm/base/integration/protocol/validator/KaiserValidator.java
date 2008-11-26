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
package net.form105.rm.base.integration.protocol.validator;

import net.form105.rm.base.exception.RMException;
import net.form105.rm.base.exception.RMIntegrationException;
import net.form105.rm.base.integration.protocol.PacketConstants;
import net.form105.rm.server.i18n.BaseMessage;

import org.apache.log4j.Logger;

/**
 * The packet header sent by kaiser should have the following sequence
 * byte 0 - 1: packetType (controlEvent = 1)
 * byte 2 - 3: packetNo
 * byte 4 - 5: packetSource (sps1=0, sps2=2, sps3=3, sps4=4)
 * byte 6 - 7: packageSink
 * 
 * @author hk
 *
 */
public class KaiserValidator implements IProtocolValidator {
	
	public static Logger logger = Logger.getLogger(KaiserValidator.class);
	
	private int packetId;

	@Override
	public boolean isValid(byte[] header) throws RMException {
		
		int packetType = (header[0] << 8) | (header[1] & 0xFF << 0);
		int packetNumber = (header[2] << 8) | (header[3] & 0xFF << 0);
		int packetSource = (header[4] << 8) | (header[5] & 0xFF << 0);
		int packetSink = (header[6] << 8) | (header[7] & 0xFF << 0);
		int packetEnd = (header[8] & 0xFF << 24) | (header[9] & 0xFF << 16) | (header[10] & 0xFF << 8) | (header[11] & 0xFF << 0);
		
		if (packetId == packetNumber) {
			throw new RMIntegrationException(new BaseMessage(), "exception.network.repeatedPacketNumber", new String[]{ new Integer(packetNumber).toString()});
		}
		
		if ((packetType != PacketConstants.PacketType_Control) && (packetType != PacketConstants.PacketType_ErrorMessage) 
				&& packetType != PacketConstants.PacketType_StatusMessage) {
			throw new RMIntegrationException(new BaseMessage(), "exception.network.invalidPacketType", new String[]{ new Integer(packetType).toString()});
		}
		
		if ( packetSource != PacketConstants.PacketSource_Plc1 &&
				packetSource != PacketConstants.PacketSource_Plc2 && 
				packetSource != PacketConstants.PacketSource_Plc3 &&
				packetSource != PacketConstants.PacketSource_Plc4 ) {
			throw new RMIntegrationException(new BaseMessage(), "exception.network.invalidPacketSource", new String[]{ new Integer(packetSource).toString()});
		}
		
		if (packetSink != PacketConstants.PacketSource_RM1 && packetSink != PacketConstants.PacketSource_RM2) {
			throw new RMIntegrationException(new BaseMessage(), "exception.network.invalidPacketSink", new String[]{ new Integer(packetSink).toString()});
		}
		
		if (packetEnd != PacketConstants.PacketEnd) {
			throw new RMIntegrationException(new BaseMessage(), "exception.network.invalidPacketEnd", new String[]{ new Integer(packetEnd).toString()});
		}
		
		return true;
	}
	
	/**
	 * Get the amount of bytes the header is build of
	 * @return
	 */
	public int getHeaderLength() {
		return 12;
	}

	@Override
	public int getPacketId() {
		return packetId;
	}

}
