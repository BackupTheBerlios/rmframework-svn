package net.form105.rm.base.query;

import java.util.ArrayList;
import java.util.Collection;

import net.form105.rm.base.service.IResult;
import net.form105.rm.base.service.ResultStatus;

public class LocalQueryHandler<T> implements IQueryHandler<T> {

	private QueryResult<T> result = new QueryResult<T>();

	public void executeQuery(IQuery<T> query) {

		try {
			Collection<T> queryResult = query.execute();
			result.setResultList(new ArrayList<T>(queryResult));
		} catch (Exception ex) {
			result.setException(ex);
			result.setStatus(ResultStatus.FAIL);
		}

	}

	public IResult<T> getResult() {
		return result;
	}
}
