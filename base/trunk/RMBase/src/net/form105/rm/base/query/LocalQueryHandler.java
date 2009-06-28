package net.form105.rm.base.query;

import java.util.ArrayList;
import java.util.Collection;

import net.form105.rm.base.service.IResult;
import net.form105.rm.base.service.ResultStatus;

public class LocalQueryHandler implements IQueryHandler {
    
    

    public <T> IResult<T> executeQuery(IQuery<T> query) {

        IResult<T> result = null;
        
        try {
            Collection<T> queryResult = query.execute();
            result = query.getQueryResult();
            result.setResultList(new ArrayList(queryResult));
        } catch (Exception ex) {
            result = new QueryResult<T>();
            result.setException(ex);
            result.setStatus(ResultStatus.FAIL);
        }
        return result;

    }

}
