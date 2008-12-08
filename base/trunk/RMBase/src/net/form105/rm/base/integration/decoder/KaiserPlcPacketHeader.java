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

public class KaiserPlcPacketHeader {
    
    private int packageType;
    private int packageNo;
    private int packageSource;
    private int packageSink;
    /**
     * @return the packageType
     */
    public int getPackageType() {
        return packageType;
    }
    /**
     * @param packageType the packageType to set
     */
    public void setPackageType(int packageType) {
        this.packageType = packageType;
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
    public int getPackageSource() {
        return packageSource;
    }
    /**
     * @param packageSource the packageSource to set
     */
    public void setPackageSource(int packageSource) {
        this.packageSource = packageSource;
    }
    /**
     * @return the packageSink
     */
    public int getPackageSink() {
        return packageSink;
    }
    /**
     * @param packageSink the packageSink to set
     */
    public void setPackageSink(int packageSink) {
        this.packageSink = packageSink;
    }

}
