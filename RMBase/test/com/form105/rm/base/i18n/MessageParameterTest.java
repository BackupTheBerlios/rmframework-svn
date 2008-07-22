/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.form105.rm.base.i18n;

import net.form105.rm.base.Container;
import net.form105.rm.base.container.GlobalLookupContainer;
import net.form105.rm.base.lookup.EntryLookupRegistry;
import net.form105.rm.i18n.ExceptionMessage;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.picocontainer.PicoContainer;
import sun.management.resources.agent;
import static org.junit.Assert.*;

/**
 *
 * @author heiko
 */
public class MessageParameterTest {
    
    public static Logger logger = Logger.getLogger(MessageParameterTest.class);
    
    

    public MessageParameterTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        
    }

    @After
    public void tearDown() {
    }


    @Test
    public void replaceStringByParameter() {
        PicoContainer container = Container.getContainer();
        GlobalLookupContainer lookupContainer = (GlobalLookupContainer) container.getComponent(GlobalLookupContainer.class);
        EntryLookupRegistry lookup = lookupContainer.getLookupRegistry();
        ExceptionMessage message = (ExceptionMessage) lookup.getContent(ExceptionMessage.class);
        String result = message.getMessage(ExceptionMessage.rm_exception_lookup_emptyEntryList, new String[] {"replacement", "test"});
        logger.info(result);
    }

}