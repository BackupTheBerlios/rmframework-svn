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
package net.form105.rm.base.message;

import net.form105.rm.base.integration.configuration.CommandHeader;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class MessageCommandTest {
    
    public static Logger logger = Logger.getLogger(MessageCommandTest.class);
    
    @Test
    public void evalAddress() {
        CommandHeader command = new CommandHeader();
        String[] fieldList = command.evalRawAddress("M / 190.3 / 1 bit");
        
        logger.info("bit address: "+command.getBitAddress());
        logger.info("byte address: "+command.getByteAddress());
        logger.info("dataType: "+command.getDataType());
        logger.info("dbNumber: "+command.getDbNumber());
        logger.info("key1: "+command.getKey1());
        logger.info("key2: "+command.getKey2());
        logger.info("reserve: "+command.getReserve());
        logger.info("sector: "+command.getSector());
        logger.info("telegram type: "+command.getTelegramType());
        
        Assert.assertTrue(fieldList.length == 3);
    }

}
