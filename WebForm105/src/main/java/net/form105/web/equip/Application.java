package net.form105.web.equip;

import org.apache.wicket.protocol.http.WebApplication;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 * 
 * @see wicket.myproject.Start#main(String[])
 */
public class Application extends WebApplication
{    
    /**
     * Constructor
     */
	public Application()
	{
	}
	
	/**
	 * @see wicket.Application#getHomePage()
	 */
	public Class getHomePage()
	{
		return HomePage.class;
	}

}
