/*
 * Copyright (c) 2008, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */
package com.form105.rm.base.model.image;

import java.io.Serializable;
import java.net.URL;
import javax.persistence.Entity;

@Entity
public class LinkedImage extends Image implements Serializable {

    private URL url;

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }
    
    
}
