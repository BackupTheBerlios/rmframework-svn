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
import com.form105.rm.base.service.persistence.UpdateSchemaService;
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
public class UpdateSchemaTest extends RemoteTest {

    public UpdateSchemaTest() {
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
    public void updateSchema() {

            UpdateSchemaService service = new UpdateSchemaService();
            UpdateSchemaService.ServiceArgument arg = service.getArgument();
            arg.schemaName = "TestSchema";
            executeService(service);

    }

}
