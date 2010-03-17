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

import java.util.ArrayList;
import java.util.List;

import net.form105.rm.base.exception.ReadDaoNotFoundException;

import org.apache.log4j.Logger;

public class AbstractMasterDao<T> {

	public static Logger logger = Logger.getLogger(AbstractMasterDao.class);

	private List<AbstractDao<T>> daoList = new ArrayList<AbstractDao<T>>();
	private AbstractDao<T> readDao;

	public void register(AbstractDao<T> dao) {
		daoList.add(dao);
	}

	public void unregister(IDao<T> dao) {
		int foundIndex = -1;
		for (IDao<T> regDao : daoList) {
			if (dao.getClass().equals(regDao.getClass())) {
				foundIndex = daoList.indexOf(regDao);
				break;
			}
		}
		if (foundIndex > 0) {
			daoList.remove(foundIndex);
		} else {
			logger.warn("Can't unregister object: " + dao.toString());
		}
	}
	
	protected List<AbstractDao<T>> getDaoList() {
		return daoList;
	}
	
	protected AbstractDao<T> getReadDao() {
		if (daoList.size() == 1) return daoList.get(0);
		if (readDao == null) {
			throw new ReadDaoNotFoundException();
		}
		return readDao;
	}

}
