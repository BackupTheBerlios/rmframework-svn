/*
* Copyright (c) 2008, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/
 
package com.form105.server.web.base;

import org.apache.wicket.markup.html.basic.Label;



public class Home extends TemplatePage {

    public Home() {
        
        add(new Label("myLabel", "this is a simple label"));
        setPageTitle("my First Application");

    }

    
    
}
