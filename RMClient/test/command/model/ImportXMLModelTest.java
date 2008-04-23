/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package command.model;

import services.*;
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
public class ImportXMLModelTest extends RemoteTest {

    public ImportXMLModelTest() {
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
        service.getArgument().modelName = "model.xml";
        
        ServiceResult result = executeService(service);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

}