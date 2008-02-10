/*
 * RMBaseWeb.java
 *
 * Created on January 20, 2008, 6:00 PM
 */
 
package com.form105.server.web.base;           

import org.apache.wicket.protocol.http.WebApplication;
/** 
 *
 * @author heiko
 * @version 
 */

public class RMBaseWeb extends WebApplication {

    public RMBaseWeb() {
    }

    public Class getHomePage() {
        return Home.class;
    }
}
