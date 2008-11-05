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

import java.math.BigInteger;

import net.form105.xml.schema.model.PlcMessagesDocument.PlcMessages.PlcMessage;

import org.apache.log4j.Logger;

/**
 * The message template consists of the generated hashcode an the xml configuration. Each message that
 * can be arrived should be defined in the xml configuration (usually config/plcMessages.xml). 
 * @author hk
 */
public class PlcMessageTemplate implements IMessageTemplate {

	public static Logger logger = Logger.getLogger(PlcMessageTemplate.class);

	private PlcMessage messageData;
	private int hashcode;

	public PlcMessageTemplate(PlcMessage messageData) {
		this.messageData = messageData;
		createHashcode();
	}

	/**
	 * 
	 * @param plcMessage
	 */
	public Integer getHashcode() {
		return hashcode;
	}

	/**
	 * Getting the message which is defined in a xml file. The PlcMessage is the representation of the entry
	 * of the xml configuration. The xml fields can be accessed by the PlcMessage.
	 * @return
	 */
	public PlcMessage getPlcMessage() {
		return messageData;
	}

	private int createHashcode() {

		byte[] identIntSequence = new byte[8];

		identIntSequence[7] = (new Integer(messageData.getType())).byteValue();
		identIntSequence[6] = (new Integer(messageData.getSector())).byteValue();
		identIntSequence[5] = 0; // reserve
		identIntSequence[4] = (new Integer(messageData.getAddress().getDb())).byteValue(); // baustein

		Integer integerByteAddress = messageData.getAddress().getByte();
		identIntSequence[3] = (byte) ((integerByteAddress >> 8) & 0xff);
		identIntSequence[2] = (byte) ((integerByteAddress >> 0) & 0xff);
		identIntSequence[1] = (new Integer(messageData.getAddress().getBit())).byteValue();
		identIntSequence[0] = messageData.getDataType(); // datatype

		BigInteger bInteger = new BigInteger(identIntSequence);
		int hashcode = bInteger.hashCode();
		logger.info("Hashcode of the dataSequence is: " + hashcode);
		return hashcode;
	}

}
