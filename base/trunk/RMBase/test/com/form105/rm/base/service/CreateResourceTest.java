package com.form105.rm.base.service;

import net.form105.rm.base.model.Resource;
import net.form105.rm.base.model.user.User;
import net.form105.rm.server.service.CreateResourceService;

import org.junit.Test;

import com.form105.rm.base.query.AbstractRemoteTest;

public class CreateResourceTest extends AbstractRemoteTest<User> {
	
	public CreateResourceTest() {
		super();
	}
	
	@Test
	public void createResource() {
		
		CreateResourceService service = new CreateResourceService();
		CreateResourceService.ServiceArgument arg = service.getArgument();
		
		Resource resource = new Resource();
		resource.setElementId("id001");
		resource.setName("Resource with id001");
		resource.setType("simpleType");
		
		arg.resource = resource;
		
		doService(service);
	}

}
