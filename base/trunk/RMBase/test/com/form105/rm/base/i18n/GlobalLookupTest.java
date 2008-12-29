package com.form105.rm.base.i18n;


import java.util.Collection;
import java.util.List;

import net.form105.rm.base.Container;
import net.form105.rm.base.ContainerConfiguration;
import net.form105.rm.base.config.SimpleConfiguration;
import net.form105.rm.base.container.LookupContainer;
import net.form105.rm.base.dao.XMLUserObjectDAO;
import net.form105.rm.base.lookup.ILookup;
import net.form105.rm.base.model.user.User;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * Checks the creation of a
 * @author HK
 *
 */
public class GlobalLookupTest {
	
	public static Logger logger = Logger.getLogger(GlobalLookupTest.class);
	
	private String xmlFile;
	private XMLUserObjectDAO userDAO;
	private LookupContainer lookupContainer;
	private User user;

	@Before
	public void setUp() throws Exception {

	}

    @Test
    public void getLookupList() {
    	
    	user = new User();
        user.setEMail("heiko.kundlacz@gmx.net");
        user.setId(System.nanoTime());
        user.setSirName("Kundlacz");
        user.setFirstName("Heiko");
    	
    	SimpleConfiguration configuration = new SimpleConfiguration();
    	ContainerConfiguration containerConfig= new ContainerConfiguration(configuration);
    	
    	Container.getInstance().load(containerConfig);
    	
        lookupContainer = Container.getContainer().getComponent(LookupContainer.class);
    	
        ILookup lookup = lookupContainer.getGlobalLookup();
        xmlFile = "users.xml";
        userDAO = new XMLUserObjectDAO(xmlFile);
        lookup.addEntry(XMLUserObjectDAO.class, userDAO);
        
        List<XMLUserObjectDAO> list = (List<XMLUserObjectDAO>) lookup.getEntryAsList(XMLUserObjectDAO.class);
        userDAO.save(user);
        Assert.assertEquals(list.get(0), userDAO);
        XMLUserObjectDAO dao = (XMLUserObjectDAO) lookup.getEntry(XMLUserObjectDAO.class).getFirstItem();
        Collection<User> users = dao.findAll();
        for (User user : users) {
        	logger.info(user.getId());
        	logger.info(user.getFirstName());
        	logger.info(user.getSirName());
        	logger.info(user.getEMail());
        }
    }

}
