package net.form105.db.cayenne.dao;

import java.util.Collections;
import java.util.List;

import net.form105.db.cayenne.Serials;

import org.apache.cayenne.DataObjectUtils;
import org.apache.cayenne.ObjectId;
import org.apache.cayenne.exp.Expression;
import org.apache.cayenne.query.ObjectIdQuery;
import org.apache.cayenne.query.SelectQuery;

/**
 * Gives access to the Serials object defined by cayenne. Data context can be accessed by the abstract class
 * @author heikok
 *
 */
public class SerialDao extends AbstractCayenneDao<Serials> {

	@Override
	public void delete(Serials object) {
		getContext().deleteObject(object);
		getContext().commitChanges();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Serials> findAll() {
		SelectQuery query = new SelectQuery(Serials.class);
		List<Serials> list = getContext().performQuery(query);
		return list;
	}

	@Override
	public Serials findById(Long id) {
		ObjectId objectId = new ObjectId("Serials", Serials.UID_PK_COLUMN, id);
		ObjectIdQuery query = new ObjectIdQuery(objectId);
		List<Serials> list = getContext().performQuery(query);
		Serials serial = (Serials) DataObjectUtils.objectForQuery(getContext(), query);
		return serial;
	}
	
	public List<Serials> findByJob(String jobId) {
		Expression qual = Expression.fromString("jobId = $jobId");
		qual = qual.expWithParameters(Collections.singletonMap("jobId", jobId));
		SelectQuery query = new SelectQuery(Serials.class, qual);
		List<Serials> list = getContext().performQuery(query);
		return list;
	}

	@Override
	public Serials merge(Serials object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Serials object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveOrUpdate(Serials object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Serials object) {
		// TODO Auto-generated method stub
		
	}
	
	// TODO: Is there a criterion object to do finds
}
