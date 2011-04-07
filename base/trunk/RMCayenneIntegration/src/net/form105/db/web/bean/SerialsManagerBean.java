package net.form105.db.web.bean;

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
	
	public SerialsManagerBean() {
		SerialsByJobQuery query = new SerialsByJobQuery("J197765");
		LocalQueryHandler queryHandler = new LocalQueryHandler();
		IResult<Serials> serialsResult = queryHandler.executeQuery(query);
		serials = serialsResult.getResultList();
		logger.info("Query result size: " + serials.size());
	}
	
	//@PostConstruct
	public void create() {
		
	}
	
	
	
	public List<Serials> getSerials() {
		SerialsByJobQuery query = new SerialsByJobQuery("J197765");
		LocalQueryHandler queryHandler = new LocalQueryHandler();
		IResult<Serials> serialsResult = queryHandler.executeQuery(query);
		serials = serialsResult.getResultList();
		return serials;
	}
	
	
}
