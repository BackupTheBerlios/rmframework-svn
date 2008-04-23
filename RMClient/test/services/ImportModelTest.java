/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.form105.rm.base.service.ServiceResult;
import com.form105.rm.base.service.common.ImportXMLService;
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
public class ImportModelTest extends RemoteTest {

    public ImportModelTest() {
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
    public void importModel() {

            ImportXMLService service = new ImportXMLService();
            ImportXMLService.ServiceArgument arg = service.getArgument();
            arg.modelName = "model.xml";
            ServiceResult result = executeService(service);
            

    }

}
