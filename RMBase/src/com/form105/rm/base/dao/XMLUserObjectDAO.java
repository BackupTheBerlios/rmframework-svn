package com.form105.rm.base.dao;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Collection;

import org.apache.log4j.Logger;

import com.form105.rm.base.model.user.User;
import com.form105.rm.base.model.user.UserList;

public class XMLUserObjectDAO implements IBasicDao<User, String> {
	
	public static Logger logger = Logger.getLogger(XMLUserObjectDAO.class);
	
	private String persistanceFile;
	private XMLEncoder xmlEncoder;
	private XMLDecoder xmlDecoder;
	private UserList userList = new UserList();
	
	public XMLUserObjectDAO(String file) throws FileNotFoundException {
		this.persistanceFile = file;
		load();
	}

	@Override
	public synchronized void delete(User user) {
		userList.getUsers().remove(user.getId());
		write();
	}

	@Override
	public Collection<User> findAll() {
		return userList.getUsersAsList();
	}

	@Override
	public User findById(String id) {
		return userList.getUserById(id);
	}

	@Override
	public User merge(User object) {
		return null;
	}

	@Override
	public synchronized void save(User user) {
		userList.addUser(user.getId().toString(), user);
		write();
		
	}

	@Override
	public void saveOrUpdate(User user) {
		userList.addUser(user.getId().toString(), user);
		write();
	}

	@Override
	public void update(User user) {
		saveOrUpdate(user);
	}
	
	/**
	 * Save the users to a xml file by using java xml encoding functionality
	 */
	private void write() {
		try {
			xmlEncoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(persistanceFile)));
			xmlEncoder.writeObject(userList);
			xmlEncoder.close();
		} catch (FileNotFoundException e) {
			logger.error("Can't write to file "+persistanceFile+"! File not found.");
		}
	}
	
	/**
	 * Load the users from a xml file by using the java xml decoding functionality
	 */
	private void load() {
		try {
			xmlDecoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(persistanceFile)));
			userList = (UserList) xmlDecoder.readObject();
			xmlDecoder.close();
		} catch (FileNotFoundException e) {
			logger.error("Can't write to file "+persistanceFile+"! File not found.");
		}
	}

}
