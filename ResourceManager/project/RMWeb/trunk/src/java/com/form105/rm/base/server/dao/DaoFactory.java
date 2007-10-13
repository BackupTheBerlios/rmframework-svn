/**
 * 
 * @author Sebastian Hennebrueder
 * created Feb 14, 2006
 * copyright 2006 by http://www.laliluna.de
 */
package com.form105.rm.base.server.dao;

import com.form105.rm.base.server.handler.InitSessionFactory;



/**
 * @author hennebrueder
 * 
 */
public class DaoFactory {

	

	private DaoFactory() {
		
	}

	public static CategoryDao  getArticleDao() {
		return new CategoryDao(InitSessionFactory.getInstance());
	}

}
