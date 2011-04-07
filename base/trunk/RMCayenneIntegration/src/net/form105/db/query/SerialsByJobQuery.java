package net.form105.db.query;
import java.util.List;

import net.form105.db.cayenne.Serials;
import net.form105.db.cayenne.dao.SerialDao;
import net.form105.rm.base.query.AbstractQuery;

/**
 * A query which returns the serials of a specified job id.
 * @author heikok
 *
 */
public class SerialsByJobQuery extends AbstractQuery<Serials> {
	
	private static final long serialVersionUID = -6655420507221694690L;
	
	private SerialDao serialDao;
	private String jobId;
	
	public SerialsByJobQuery(String jobId) {
		this.jobId = jobId;
		serialDao = new SerialDao();
	}

	@Override
	public List<Serials> execute() {
		List<Serials> serials = serialDao.findByJob(jobId);
		return serials;
	}

}
