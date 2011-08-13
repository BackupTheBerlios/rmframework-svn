package net.form105.rm.server.ant.validator;

import java.util.List;

import net.form105.rm.base.service.IResult;
import net.form105.rm.base.service.ResultStatus;
import net.form105.rm.base.validator.IInboundValidator;
import net.form105.rm.base.validator.ValidationResult;

public abstract class AbstractValidationHandler<T> {

	private List<IInboundValidator<T>> validatorList;

	public void addValidator(IInboundValidator<T> validator) {
		validatorList.add(validator);
	}

	public void removeValidator(IInboundValidator<T> validator) {
		validatorList.remove(validator);
	}

	protected IResult<T> validate(T object) {

		for (IInboundValidator<T> validator : validatorList) {
			IResult<T> result = validator.isValid(object);
			if (result.getStatus() == ResultStatus.FAIL) {
				return result;
			}
		}

		IResult<T> result = new ValidationResult<T>();
		result.setStatus(ResultStatus.SUCCESS);
		
		result.setResultList(new ArrayList())
		return result;
	}
	
	/**
	 * This runs the validation and should return true if the object is valid. Otherwise it returns false. A default implementation 
	 * validate can be used. 
	 * @param object
	 * @return
	 * @throws RMValidationException
	 */
	public abstract boolean runValidation(T object) throws RM;

}
