/*
 * Copyright (c) 2008, form105 Heiko Kundlacz
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.form105.rm.base.db.action;

import java.util.List;

import net.form105.rm.base.db.AbstractDBEntity;
import net.form105.rm.base.service.IResult;
import net.form105.rm.base.service.ResultStatus;

/**
 * A result for executing actions on a database connected via jdbc. The result
 * consists of three parts. An exception that has been thrown, a result list if 
 * a result is expected and a status for the state of the action that has been
 * executed.
 * @author heikok
 *
 */
public class JdbcResult implements IResult<AbstractDBEntity> {

	private static final long serialVersionUID = 1L;
	
	private Exception exception;
	private List<AbstractDBEntity> resultList;
	private ResultStatus status;

	@Override
	public Exception getException() {
		return exception;
	}

	@Override
	public List<AbstractDBEntity> getResultList() {
		return resultList;
	}

	@Override
	public ResultStatus getStatus() {
		return status;
	}

	@Override
	public void setException(Exception ex) {
		this.exception = ex;

	}

	@Override
	public void setResultList(List<AbstractDBEntity> resultList) {
		this.resultList = resultList;

	}

	@Override
	public void setStatus(ResultStatus status) {
		this.status = status;
	}

}
