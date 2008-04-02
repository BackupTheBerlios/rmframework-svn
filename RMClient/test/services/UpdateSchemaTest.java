/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.form105.rm.base.service.ServiceResult;
import com.form105.rm.base.service.persistence.UpdateSchemaService;
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
            arg.schemaName = "APP1";
            ServiceResult result = executeService(service);
            

    }

}
