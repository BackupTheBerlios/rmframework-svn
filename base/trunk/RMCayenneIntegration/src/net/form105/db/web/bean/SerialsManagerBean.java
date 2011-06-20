package net.form105.db.web.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import net.form105.db.cayenne.Serials;
import net.form105.db.query.SerialsByJobQuery;
import net.form105.rm.base.query.LocalQueryHandler;
import net.form105.rm.base.service.IResult;

import org.apache.log4j.Logger;

@ManagedBean (name="serialsManager")
@RequestScoped
public class SerialsManagerBean {
	
	public static Logger logger = Logger.getLogger(SerialsManagerBean.class);
	
	private List<Serials> serials;
	private String jobId;
	
	public SerialsManagerBean() {
		
	}
	
	//@PostConstruct
	public void create() {
		
	}
	
	public void executeQuery() {
		SerialsByJobQuery query = new SerialsByJobQuery(jobId);
		LocalQueryHandler queryHandler = new LocalQueryHandler();
		IResult<Serials> serialsResult = queryHandler.executeQuery(query);
		serials = serialsResult.getResultList();
		logger.info("Query result size: " + serials.size());
	}
	
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	
	public String getJobId() {
		return jobId;
	}
	
	
	
	public List<Serials> getSerials() {
		if (serials == null) {
			serials = new ArrayList<Serials>();
		}
		
		logger.info("Found serials: "+serials.size());
		
		return serials;
	}
	
	
}
