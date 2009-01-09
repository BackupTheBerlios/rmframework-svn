package com.form105;

import junit.framework.TestCase;
import net.form105.web.base.Application;
import net.form105.web.base.HomePage;

import org.apache.wicket.util.tester.WicketTester;


/**
 * Simple test using the WicketTester
 */
public class TestHomePage extends TestCase
{
	private WicketTester tester;

	@Override
	public void setUp()
	{
		tester = new WicketTester(new Application());
	}

	public void testRenderMyPage()
	{
		//start and render the test page
		tester.startPage(HomePage.class);

		//assert rendered page class
		tester.assertRenderedPage(HomePage.class);

		//assert rendered label component
		tester.assertLabel("message", "If you see this message wicket is properly configured and running");
	}
}
