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
package net.form105.rm.base.integration.configuration;

import org.apache.log4j.Logger;

public class CommandHeader {

    public static Logger logger = Logger.getLogger(CommandHeader.class);

    private String key1;

    private String key2;
    
    private String rawAddress;

    private int telegramType;

    private int sector;

    private int reserve = 0;

    private int dbNumber = 0;

    private int byteAddress;

    private int bitAddress;

    private int dataType;

    /**
     * Evals an address given by the configuration. The string is splitted in its tokens and
     * the variables are set according to the sector type (input, output, flag, datablock)
     * @param rawAddress
     * @return
     */
    public String[] evalRawAddress(String rawAddress) {
        //example M / 190.3 / 1 bit

        String[] addressList = rawAddress.split("[/]");
        String codedSector = addressList[0].trim();
        String parsedValue = "";

        try {
            logger.info("sector: "+addressList[0].trim());
            if (addressList[0].trim().startsWith("DB")) {
                
                sector = 4;
                parsedValue = rawAddress.split("[.]")[1];
                dbNumber = new Integer(parsedValue);
            } else if (codedSector.equals("E")) {
                sector = 2;
            } else if (codedSector.equals("A")) {
                sector = 3;
            } else if (codedSector.equals("M")) {
                sector = 4;
            }
            
            parsedValue = addressList[1].trim().split("[.]")[0];
            byteAddress = new Integer(parsedValue);
            
            parsedValue = addressList[1].trim().split("[.]")[1];
            bitAddress = new Integer(parsedValue);
            
            dataType = getDataType(addressList[2]);

        } catch (NumberFormatException nfex) {
            logger.error("Parsed number isn't an integer: " + parsedValue);
        }

        return addressList;

    }
    
    /**
     * The dataType token consists of a number and a unit. The possible unit values are
     * bit and byte. If bit is declared only 1 bit is allowed. 
     * @param dataTypeToken
     * @return
     */
    public int getDataType(String dataTypeToken) throws NumberFormatException {
        dataTypeToken = dataTypeToken.trim();
        logger.info("dataTypeToken: "+dataTypeToken);
        String dataTypeValue = dataTypeToken.split("[\\s]")[0];
        logger.info("dataTypeValue: "+dataTypeValue);
        int intValue = new Integer(dataTypeValue);
        int convertedValue = -1;
        if (dataTypeToken.equals("1 bit")) {
            convertedValue = 1;
        } else if (intValue < 5) {
            convertedValue = intValue * 8;
        } else {
            convertedValue = intValue + 50;
        }
        return convertedValue;
    }

    /**
     * @return the key1
     */
    public String getKey1() {
        return key1;
    }

    /**
     * @param key1 the key1 to set
     */
    public void setKey1(String key1) {
        this.key1 = key1;
    }

    /**
     * @return the key2
     */
    public String getKey2() {
        return key2;
    }

    /**
     * @param key2 the key2 to set
     */
    public void setKey2(String key2) {
        this.key2 = key2;
    }

    /**
     * @return the rawAddress
     */
    public String getRawAddress() {
        return rawAddress;
    }

    /**
     * @param rawAddress the rawAddress to set
     */
    public void setRawAddress(String rawAddress) {
        this.rawAddress = rawAddress;
    }

    /**
     * @return the telegramType
     */
    public int getTelegramType() {
        return telegramType;
    }

    /**
     * @param telegramType the telegramType to set
     */
    public void setTelegramType(int telegramType) {
        this.telegramType = telegramType;
    }

    /**
     * @return the sector
     */
    public int getSector() {
        return sector;
    }

    /**
     * @param sector the sector to set
     */
    public void setSector(int sector) {
        this.sector = sector;
    }

    /**
     * @return the reserve
     */
    public int getReserve() {
        return reserve;
    }

    /**
     * @param reserve the reserve to set
     */
    public void setReserve(int reserve) {
        this.reserve = reserve;
    }

    /**
     * @return the dbNumber
     */
    public int getDbNumber() {
        return dbNumber;
    }

    /**
     * @param dbNumber the dbNumber to set
     */
    public void setDbNumber(int dbNumber) {
        this.dbNumber = dbNumber;
    }

    /**
     * @return the byteAddress
     */
    public int getByteAddress() {
        return byteAddress;
    }

    /**
     * @param byteAddress the byteAddress to set
     */
    public void setByteAddress(int byteAddress) {
        this.byteAddress = byteAddress;
    }

    /**
     * @return the bitAddress
     */
    public int getBitAddress() {
        return bitAddress;
    }

    /**
     * @param bitAddress the bitAddress to set
     */
    public void setBitAddress(int bitAddress) {
        this.bitAddress = bitAddress;
    }

    /**
     * @return the dataType
     */
    public int getDataType() {
        return dataType;
    }

    /**
     * @param dataType the dataType to set
     */
    public void setDataType(int dataType) {
        this.dataType = dataType;
    }


}
