package net.form105.rm.base.query;

import java.rmi.RemoteException;

import net.form105.rm.base.Container;
import net.form105.rm.base.ContainerConfiguration;
import net.form105.rm.base.config.SimpleClientConfiguration;
import net.form105.rm.base.container.RMIClientContainer;
import net.form105.rm.base.query.IQuery;
import net.form105.rm.base.query.IQueryHandler;
import net.form105.rm.base.service.IResult;
import net.form105.rm.base.service.IService;
import net.form105.rm.base.service.IServiceHandler;
import net.form105.rm.base.service.ServiceResult;
import net.form105.rm.base.service.ResultStatus;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;

public class AbstractRemoteTest<T> {

    public static Logger logger = Logger.getLogger(AbstractRemoteTest.class);

    private static RMIClientContainer clientContainer;

    public AbstractRemoteTest() {

    }

    @BeforeClass
    public static void setupContainer() {
        logger.info("Configure Container and start ...");
        ContainerConfiguration configuration = new ContainerConfiguration(new SimpleClientConfiguration());
        Container.getInstance().load(configuration);
        clientContainer = (RMIClientContainer) Container.getContainer().getComponent(RMIClientContainer.class);
    }

    protected IQueryHandler getQueryHandler() {
        return clientContainer.getQueryHandler();
    }

    protected IServiceHandler getServiceHandler() {
        return clientContainer.getServiceHandler();
    }

    protected IResult<T> doService(IService service) {
        try {
            getServiceHandler().executeService(service);
            return getServiceHandler().getResult();
        } catch (RemoteException re) {
            logger.error(re, re);
            ServiceResult<T> result = new ServiceResult<T>();
            result.setStatus(ResultStatus.FAIL);
            return result;
        }
    }

    protected IResult<T> doQuery(IQuery<T> query) {
        try {
            IResult<T> result = getQueryHandler().executeQuery(query);
            return result;
        } catch (Exception re) {
            logger.error(re, re);
            return null;
        }
    }

}
