package net.form105.rm.base.query;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collection;

import net.form105.rm.base.service.IResult;
import net.form105.rm.base.service.ResultStatus;

import org.apache.log4j.Logger;

public class RMIQueryHandler extends UnicastRemoteObject implements IQueryHandler {

    public static Logger logger = Logger.getLogger(RMIQueryHandler.class);

    private static final long serialVersionUID = 1L;

    private final String name = "QueryHandler";

    public RMIQueryHandler() throws RemoteException {
        super();
    }

    public <T> IResult<T> executeQuery(IQuery<T> query) throws RemoteException {

        IResult<T> result = query.getQueryResult();
        try {
            Collection<T> queryResult = query.execute();
            result.setResultList(new ArrayList<T>(queryResult));
            result.setStatus(ResultStatus.SUCCESS);
        } catch (Exception ex) {
            logger.error(ex, ex);
            result.setException(ex);
            result.setStatus(ResultStatus.FAIL);
        }
        return result;

    }

    /**
     * Getting the name of this query handler. This query handler is used in the rmi registry 
     * by the provided name
     * @return
     */
    public String getName() {
        return name;
    }

}
