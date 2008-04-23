/*
* Copyright (c) 2008, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/

package services;

import com.form105.rm.base.Container;
import com.form105.rm.base.service.IService;
import com.form105.rm.base.service.IServiceHandler;
import com.form105.rm.base.service.ServiceResult;
import com.form105.rm.base.service.Status;
import com.form105.rm.client.container.RMIClientContainer;
import java.rmi.RemoteException;
import org.apache.log4j.Logger;


/**
 *
 * @author heiko
 */
public class RemoteTest {
    
    private static Logger logger = Logger.getLogger(RemoteTest.class);
    
    protected ServiceResult executeService(IService service) {
        try {

            RMIClientContainer container = (RMIClientContainer) Container.getInstance().getComponent(RMIClientContainer.class);
            IServiceHandler sHandler = container.getServiceHandler();
          

            sHandler.executeService(service);
            return sHandler.getResult();
        } catch (RemoteException ex) {
            logger.error(ex);
            ServiceResult result = new ServiceResult();
            result.setStatus(Status.FAIL);
            return result;
        }
    }

}
