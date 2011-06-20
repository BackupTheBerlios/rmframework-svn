package net.form105.rm.server.ant.validator;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

import net.form105.rm.base.exception.FileNotFoundRMException;
import net.form105.rm.base.exception.RMException;
import net.form105.rm.base.service.IResult;
import net.form105.rm.base.service.ResultStatus;
import net.form105.rm.base.validator.IInboundValidator;
import net.form105.rm.base.validator.ValidationResult;

/**
 * Checks for a build file with the name build.xml in the hotfolder. For starting a process this file is required.
 * 
 * @author heikok
 * 
 */
public class BuildFileValidator implements IInboundValidator<File> {
	
	private final String fileName = "build.xml";
	private File hotfolder;

	@Override
	public IResult<File> isValid(final File hotfolder) {
		this.hotfolder = hotfolder;
		final ValidationResult<File> result = new ValidationResult<File>();
		String[] fileArray = hotfolder.list(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
					for (File file : dir.listFiles()) {
						if ( hotfolder.getName().equalsIgnoreCase(fileName)) {
							result.setStatus(ResultStatus.SUCCESS);
						}	
					}
				return false;
			}
		});
		
		
		if (fileArray.length == 0) {
			result.setStatus(ResultStatus.FAIL);
		} else {
			result.setStatus(ResultStatus.SUCCESS);
		}
		return result;
	}
	
	protected RMException setException() {
		RMException rmEx = null;
		try {
			rmEx = new FileNotFoundRMException(hotfolder.getCanonicalPath()+File.separator+fileName);
			return rmEx;
		} catch (IOException ioe) {
			rmEx = new RMException("IOException occured", ioe);
			return rmEx;
		}
	}
}
