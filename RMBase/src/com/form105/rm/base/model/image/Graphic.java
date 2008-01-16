/*
* Copyright (c) 2008, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/

package com.form105.rm.base.model.image;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Graphic {
    
    @Id
    private Long oid;
    
    
    @OneToMany
    private Set<ImageSource> imageSources = new HashSet<ImageSource>();

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Set<ImageSource> getImageSources() {
        return imageSources;
    }

    public void setImageSources(Set<ImageSource> imageSources) {
        this.imageSources = imageSources;
    }

}
