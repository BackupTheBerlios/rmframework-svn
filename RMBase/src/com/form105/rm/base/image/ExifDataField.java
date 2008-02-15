/*
* Copyright (c) 2008, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/

package com.form105.rm.base.image;

/**
 * Consists of the minimum portion of a exif field. The fields are identified by a id which is represented by a hex and a decimal number.
 * @author Heiko Kundlacz
 */
public class ExifDataField {
    private String hexId;
    private Integer decId;
    private String description;
    private String directoryName;
    private String value;

    public String getHexId() {
        return hexId;
    }

    public void setHexId(String hexId) {
        this.hexId = hexId;
    }

    public Integer getDecId() {
        return decId;
    }

    public void setDecId(Integer decId) {
        this.decId = decId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirectoryName() {
        return directoryName;
    }

    public void setDirectoryName(String directoryName) {
        this.directoryName = directoryName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
