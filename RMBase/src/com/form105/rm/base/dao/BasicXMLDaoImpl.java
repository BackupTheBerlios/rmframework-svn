/*
* Copyright (c) 2008, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/

package com.form105.rm.base.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.criterion.Criterion;

/**
 * Implemenation for accessing transient model objects loaded from xml
 * 
 * @author Heiko Kundlacz
 */
public class BasicXMLDaoImpl implements BasicDao {

    public Object findById(Serializable id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void save(Object object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void update(Object object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void saveOrUpdate(Object object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object merge(Object object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void delete(Object object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
