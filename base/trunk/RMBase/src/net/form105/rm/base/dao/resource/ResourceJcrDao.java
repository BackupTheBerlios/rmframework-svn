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
import javax.jcr.PropertyIterator;
import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;
import javax.jcr.query.Query;
import javax.jcr.query.QueryManager;
import javax.jcr.query.QueryResult;

import net.form105.rm.base.model.Resource;

import org.apache.log4j.Logger;

public class ResourceJcrDao extends AbstractDao<Resource> {

	public static Logger logger = Logger.getLogger(ResourceJcrDao.class);

	private boolean readDao = false;
	private Repository repos;
	private Credentials credentials;

	/**
	 * Defaults to readDao = false
	 */
	public ResourceJcrDao(Repository repository) {
		this(false);
		this.repos = repository;
		credentials = new SimpleCredentials("admin", "admin".toCharArray());
		initialize(getSession(credentials));

	}

	public ResourceJcrDao(boolean isReadDao) {
		this.readDao = isReadDao;
	}

	@Override
	public void delete(Resource object) {

	}

	@Override
	public List<Resource> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resource findByElementId(String elementId) {

		return null;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Resource findById(Long id) {
		Node rn = getRootNode();
		try {
			QueryManager qm = this.getSession(credentials).getWorkspace().getQueryManager();
			Query query = qm.createQuery("Resources/Resource[@id="+id+"]", Query.XPATH);
			QueryResult result = query.execute();
			Node firstNode = result.getNodes().nextNode();
			PropertyIterator iter = firstNode.getProperties();
			for (Object object : iter) {
				
			}
			
			String uuid = firstNode.getIdentifier();
			
		} catch (RepositoryException re) {
			logger.error("Repository Error: Can't get QueryManager");
		}
		 
		
		return null;
	}

	@Override
	public void save(Resource object) {

	}

	@Override
	public void saveOrUpdate(Resource object) {

	}

	@Override
	public void update(Resource object) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isReadDao() {
		return readDao;
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

	private Node getRootNode() {
		Node rn = null;
		try {
			Session session = getSession(credentials);
			rn = session.getRootNode();
		} catch (RepositoryException re) {
			logger.error("Repository Error: Can't get root node");
		}
		return rn;

	}
	
	public void initialize(Session session) {
		try {
			
			Node agentNode = session.getRootNode().addNode("Agent");
			agentNode.addNode("Resources");
			agentNode.addNode("Orders");
			agentNode.addNode("Workflows");
			session.save();
			
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
	}

}
