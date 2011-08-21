package net.form105.rm.server.ant.validator;

import java.util.List;

import net.form105.rm.base.exception.RMValidationException;
import net.form105.rm.base.service.IResult;
import net.form105.rm.base.service.ResultStatus;
import net.form105.rm.base.validator.IInboundValidator;
import net.form105.rm.base.validator.SimpleSuccessResult;

public abstract class AbstractValidationHandler<T> {

	private List<IInboundValidator<T>> validatorList;

	public void addValidator(IInboundValidator<T> validator) {
		validatorList.add(validator);
	}

	public void removeValidator(IInboundValidator<T> validator) {
		validatorList.remove(validator);
	}

	protected IResult<T> validate(T object) throws RMValidationException{

		for (IInboundValidator<T> validator : validatorList) {
			IResult<T> result = validator.isValid(object);
			if (result.getStatus() == ResultStatus.FAIL) {
				throw new RMValidationException("Validation failed for Validator: "+validator.getClass().getCanonicalName());
			}
		}
		return new SimpleSuccessResult<T>();
	}
	
	/**
	 * This runs the validation and should return true if the object is valid. Otherwise it returns false. A default implementation 
	 * validate can be used. 
	 * @param object
	 * @return
	 * @throws RMValidationException
	 */
	public abstract boolean runValidation(T object) throws RMValidationException;

}
