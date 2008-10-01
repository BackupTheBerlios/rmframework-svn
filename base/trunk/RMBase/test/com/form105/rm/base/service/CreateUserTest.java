package com.form105.rm.base.service;

import net.form105.rm.base.model.user.User;
import net.form105.rm.server.service.CreateUserService;

import org.junit.Test;

import com.form105.rm.base.query.AbstractRemoteTest;

public class CreateUserTest extends AbstractRemoteTest<User> {
	
	public CreateUserTest() {
		super();
	}
	
	@Test
	public void createUsers() {
		
		CreateUserService service = new CreateUserService();
		CreateUserService.ServiceArgument arg = service.getArgument();
		
		User user = new User();
		user.setEMail("heiko.kundlacz@kaiser-ag.ch");
		user.setFirstName("Heiko");
		user.setSirName("Kundlacz");
		user.setShortName("heiko.kundlacz");
		user.setId(1001L);
		user.setPassword("12345");
		
		arg.user = user;
		
		doService(service);
	}

}
