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
package net.form105.rm.base.integration.decoder;

public class KaiserPlcContentHeader {
    
    private int telegramType;
    private int sector;
    private int dbNo;
    private int byteAddress;
    private int bitAddress;
    private int dataType;
    private int value;
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
     * @return the dbNo
     */
    public int getDbNo() {
        return dbNo;
    }
    /**
     * @param dbNo the dbNo to set
     */
    public void setDbNo(int dbNo) {
        this.dbNo = dbNo;
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
    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }
    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
    }

}
