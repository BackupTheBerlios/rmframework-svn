package net.form105.rm.server.ant.validator;

import java.io.File;

import net.form105.rm.base.service.IResult;
import net.form105.rm.base.service.ResultStatus;
import net.form105.rm.base.validator.IInboundValidator;
import net.form105.rm.base.validator.ValidationResult;

/**
 * A file validator checks if a file is a normal file, and not a directory
 * @author heikok
 *
 */
public class RealFileValidator implements IInboundValidator<File> {
	
	public IResult<File> isValid(File hotfolder) {
		
		ValidationResult<File> result = new ValidationResult<File>();
		if (hotfolder.isFile()) {
			result.setStatus(ResultStatus.SUCCESS);
		} else {
			result.setStatus(ResultStatus.FAIL);
		}
		return result;
	}

}
