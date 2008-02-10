/*
* Copyright (c) 2008, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/

package com.form105.server.web.base;

import org.apache.wicket.protocol.http.WebApplication;

/**
 *
 * @author Heiko Kundlacz
 */
public class BaseApplication extends WebApplication {

    @Override
    public Class getHomePage() {
        return Home.class;
    }
    
    

}
