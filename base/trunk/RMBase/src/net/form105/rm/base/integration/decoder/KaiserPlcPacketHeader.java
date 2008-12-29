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

import org.apache.log4j.Logger;

public class KaiserPlcPacketHeader {
    
    public static Logger logger = Logger.getLogger(KaiserPlcPacketHeader.class);

    private PackageType packageType;

    private int packageNo;

    private PackageSourceSink packageSource;

    private PackageSourceSink packageSink;

    public enum PackageType {
        NONE(-1), EVENT(1), AKNOWLEDGE(2), ERROR(3), STATUS(4);

        private int intType;

        private PackageType(int intType) {
            this.intType = intType;
        }

        public int getType() {
            return intType;
        }

    }

    public enum PackageSourceSink {
        NONE(-1), SPS1(1), SPS2(2), SPS3(3), SPS4(4), PCO1(101), PCO2(102);

        int sourceSink;

        private PackageSourceSink(int sourceSink) {
            this.sourceSink = sourceSink;
        }

        public int getType() {
            return sourceSink;
        }

    }

    /**
     * @return the packageType
     */
    public PackageType getPackageType() {
        return packageType;
    }

    /**
     * @param packageType the packageType to set
     */
    public void setPackageType(int packageTypeValue) {
        packageType = getPackageType(packageTypeValue);
    }

    /**
     * @return the packageNo
     */
    public int getPackageNo() {
        return packageNo;
    }

    /**
     * @param packageNo the packageNo to set
     */
    public void setPackageNo(int packageNo) {
        this.packageNo = packageNo;
    }

    /**
     * @return the packageSource
     */
    public PackageSourceSink getPackageSource() {
        return packageSource;
    }

    /**
     * @param packageSource the packageSource to set
     */
    public void setPackageSource(int packageSourceValue) {
        packageSource = getPackageSourceSink(packageSourceValue);
    }

    /**
     * @return the packageSink
     */
    public PackageSourceSink getPackageSink() {
        return packageSink;
    }

    /**
     * @param packageSink the packageSink to set
     */
    public void setPackageSink(int packageSourceSinkValue) {
        this.packageSink = getPackageSourceSink(packageSourceSinkValue);
    }

    public PackageType getPackageType(int type) {
        for (PackageType packType : PackageType.values()) {
            if (packType.getType() == type)
                return packType;
        }
        return PackageType.NONE;
    }

    public PackageSourceSink getPackageSourceSink(int type) {
        for (PackageSourceSink source : PackageSourceSink.values()) {
            if (source.getType() == type)
                return source;
        }
        return PackageSourceSink.NONE;
    }

    public boolean isValid() {
        logger.debug("Check validation: "+packageSource +":"+packageSink+":"+packageType);
        return !(packageSource.equals(PackageSourceSink.NONE) || packageSink.equals(PackageSourceSink.NONE)
                || packageType.equals(PackageType.NONE));
    }

}
