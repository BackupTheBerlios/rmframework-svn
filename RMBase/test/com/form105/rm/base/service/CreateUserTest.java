package com.form105.rm.base.service;

import net.form105.rm.service.CreateUserService;

import org.junit.Test;

import com.form105.rm.base.query.AbstractRemoteTest;

public class CreateUserTest extends AbstractRemoteTest {
	
	public CreateUserTest() {
		super();
	}
	
	@Test
	public void createUsers() {
		
		CreateUserService service = new CreateUserService();
		CreateUserService.ServiceArgument arg = service.getArgument();
		
		arg.id = "1001";
		arg.email = "heiko.kundlacz@kaiser-ag.ch";
		arg.firstName = "Heiko";
		arg.name = "Kundlacz";
		arg.shortName = "hk";
		
		doService(service);
	}

}
