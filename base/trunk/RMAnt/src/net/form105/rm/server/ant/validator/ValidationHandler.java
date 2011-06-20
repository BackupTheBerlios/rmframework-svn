package net.form105.rm.server.ant.validator;

import java.util.List;

import net.form105.rm.base.service.IResult;
import net.form105.rm.base.service.ResultStatus;
import net.form105.rm.base.validator.IInboundValidator;
import net.form105.rm.base.validator.ValidationResult;

public class ValidationHandler<T> {
	
	public IResult<T> runValidation(T object, List<IInboundValidator<T>> validationList) {
		
		for (IInboundValidator<T> validator : validationList) {
				IResult<T> result = validator.isValid(object);
				if (result.getStatus() == ResultStatus.FAIL) {
					return result;
				}
		}
		
		IResult<T> result =  new ValidationResult<T>();
		result.setStatus(ResultStatus.SUCCESS);
		return result;
	}

}
