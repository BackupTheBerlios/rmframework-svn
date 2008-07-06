package com.form105.base.user;

import java.io.FileNotFoundException;

import junit.framework.TestCase;

import org.apache.log4j.Logger;

import com.form105.rm.base.dao.XMLUserObjectDAO;
import com.form105.rm.base.model.user.User;

public class WriteUserTest extends TestCase {
	
	public static Logger logger = Logger.getLogger(WriteUserTest.class);

	public void testAddUserToXML() {
		
		User user = new User();
		user.setId(11111L);
		user.setName("Heiko");
		user.setSirName("Kundlacz");
		user.setEMail("heiko.kundlacz@gmx.net");
		user.setPassword("heiko25");

		try {
			XMLUserObjectDAO dao = new XMLUserObjectDAO("users.xml");
			dao.save(user);
		} catch (FileNotFoundException e) {
			logger.info("File not found");
			e.printStackTrace();
		}
		
	}

	/*public void testGetUserFromXML() {
		XMLDecoder decoder;
		try {
			decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("users.xml")));
			UserList userList = (UserList) decoder.readObject();
			decoder.close();
			User user = (User) userList.getUsers().get("heiko.kundlacz@gmx.net");
			logger.info(user.getUser()+":"+user.getPassword());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		

	}*/

}
