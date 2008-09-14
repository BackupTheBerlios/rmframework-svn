package net.form105.rm.base.container;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import net.form105.rm.base.dao.IBasicDao;
import net.form105.rm.base.dao.resource.AbstractResourceDao;
import net.form105.rm.base.dao.resource.ResourceMapDao;

import org.picocontainer.Startable;

public class TransientContainer implements Startable {
	
	private ModeContainer modeContainer;
	private GlobalLookupContainer lookupContainer;
	
	private List<IBasicDao<?,?>> daoList = new ArrayList<IBasicDao<?,?>>();
	
	public TransientContainer(ModeContainer modeContainer, GlobalLookupContainer lookupContainer) {
		this.modeContainer = modeContainer;
		this.lookupContainer = lookupContainer;
	}

	@Override
	public void start() {
		// register the transient daos
		if (supported()) {
			ResourceMapDao resourceMapDao = new ResourceMapDao();
			lookupContainer.getLookupRegistry().addEntry(AbstractResourceDao.class, resourceMapDao);
			daoList.add(resourceMapDao);	
		}

	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}
	
	public boolean supported() {
		return modeContainer.getCurrentMode().getTransient();
	}
	
	public List<IBasicDao<?,?>> getTransientDaoList() {
		return daoList;
	}

}
