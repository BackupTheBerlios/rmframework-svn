/*
* Copyright (c) 2008, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/

package net.form105.rm.base.model.image;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class BinaryImage extends ImageData implements Serializable {
    
    private byte imageAsByte[];

    public byte[] getImageAsByte() {
        return imageAsByte;
    }

    public void setImageAsByte(byte[] imageAsByte) {
        this.imageAsByte = imageAsByte;
    }

}
