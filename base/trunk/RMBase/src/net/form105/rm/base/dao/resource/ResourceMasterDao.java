/*
 * Copyright (c) 2008, form105 Heiko Kundlacz
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.form105.rm.base.dao.resource;

import java.util.List;

import javax.jcr.Credentials;
import javax.jcr.LoginException;
import javax.jcr.Node;
import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;

import net.form105.rm.base.model.Resource;

/**
 * If this class will be constructed it is always necessary to define one of the registered
 * daos as a read dao. If only one exists, only this will be used as the read dao.
 * @author heikok
 *
 */
public class ResourceMasterDao extends AbstractMasterDao<Resource> implements IDao<Resource> {
	
	private Repository repos;
	private Node rootNode;
	
	public ResourceMasterDao(Repository repository) {
		this.repos = repository;
		Credentials credentials = new SimpleCredentials("admin", "admin".toCharArray());
		Session session = getSession(credentials);
		initialize(session);
	}

	@Override
	public void delete(Resource object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Resource> findAll() {
		return getReadDao().findAll();
	}

	@Override
	public Resource findByElementId(String elementId) {
		return getReadDao().findByElementId(elementId);
	}

	@Override
	public Resource findById(Long id) {
		return getReadDao().findById(id);
	}

	@Override
	public void save(Resource object) {
		for (AbstractDao<Resource> dao : getDaoList()) {
			dao.save(object);
		}
	}

	@Override
	public void saveOrUpdate(Resource object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Resource object) {
		// TODO Auto-generated method stub
		
	}
	
	private Session getSession(Credentials credentials) {
		Session session = null;
		try {
			session = repos.login(credentials);
			
		} catch (LoginException e) {
			e.printStackTrace();
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
		return session;
	}
	
	public void initialize(Session session) {
		try {
			
			rootNode = session.getRootNode();
			
			Node agentNode = rootNode.addNode("Agent");
			agentNode.addNode("Resources");
			agentNode.addNode("Orders");
			agentNode.addNode("Workflows");
			session.save();
			
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
	}
	
	
	
	

}
