package net.form105.db.cayenne.base;
import java.util.List;

import net.form105.db.cayenne.Serials;
import net.form105.db.cayenne.container.CayenneContainer;
import net.form105.db.cayenne.dao.SerialDao;
import net.form105.rm.base.Agent;
import net.form105.rm.base.Container;
import net.form105.rm.base.ContainerConfiguration;
import net.form105.rm.base.config.SimpleConfiguration;

import org.apache.cayenne.access.DataContext;
import org.apache.log4j.Logger;


/**
 * Starter class for the Cayenne integration project. Starts with the simple configuration feature
 * @author heikok
 *
 */
public class CayenneIntegrationAgent extends Agent {
	
	public static Logger logger = Logger.getLogger(CayenneIntegrationAgent.class);

	/**
	 * @param args 
	 */
	public static void main(String[] args) {
		ContainerConfiguration configuration = new ContainerConfiguration(new SimpleConfiguration());
        Container.getInstance().load(configuration);
        
        CayenneContainer container = (CayenneContainer) getComponentById("cayenne");
        DataContext context = container.getContext();
        
        //Serials serial = (Serials) DataObjectUtils.objectForPK(context, Serials.class, 106364);
        
        //logger.info("Serials: " +serial.getA_test_Field());
        //System.out.println("Starting query");
        //SerialDao serialDao = new SerialDao();
        //Serials serial = serialDao.findById(72024L);
        //System.out.println(serial.getJobId());
        //List<Serials> serials = serialDao.findByJob("J197765");
        //System.out.println(serials.size());
	}
}
