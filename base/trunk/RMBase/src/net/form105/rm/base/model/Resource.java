/*
* Copyright (c) 2008, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/

package net.form105.rm.base.model;

import org.apache.log4j.Logger;


public class Resource extends ParameterizedElement {
    
    public static Logger logger = Logger.getLogger(Resource.class);

    private static final long serialVersionUID = 1L;

    public Resource() {
    }
    
    public Resource(String elementId, String name, String type) {
    	setElementId(elementId);
    	setName(name);
    	setType(type);
    }
}
