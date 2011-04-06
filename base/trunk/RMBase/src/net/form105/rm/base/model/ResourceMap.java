/*
* Copyright (c) 2008, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/

package net.form105.rm.base.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.dom4j.Element;

public class ResourceMap  implements Serializable {
    
    public List<Resource> fromDom(Element rootNode) {
        
        rootNode.selectNodes("/resource");
        
        
        return new ArrayList<Resource>();
    }
    
    
    
    

}
