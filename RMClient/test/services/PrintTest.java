/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import com.form105.rm.base.Container;
import com.form105.rm.base.service.IResult;
import com.form105.rm.base.service.IServiceHandler;
import com.form105.rm.base.service.RMIServiceHandler;
import com.form105.rm.base.service.common.PrintService;
import com.form105.rm.client.container.RMIClientContainer;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author heiko
 */
public class PrintTest {

    public PrintTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void print() {
        try {
            RMIClientContainer container = (RMIClientContainer) Container.getInstance().getComponentInstance(RMIClientContainer.class);
            IServiceHandler sHandler = container.getServiceHandler();
            PrintService pService = new PrintService();
            PrintService.ServiceArgument arg = pService.getArgument();
            arg.name = "Name_of_Print";
            sHandler.executeService(pService);
            
                    
        } catch (RemoteException ex) {
            Logger.getLogger(PrintTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

}