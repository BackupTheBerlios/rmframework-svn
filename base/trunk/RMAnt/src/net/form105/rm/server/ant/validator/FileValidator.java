package net.form105.rm.server.ant.validator;

import java.io.File;

import net.form105.rm.base.validator.IValidator;

/**
 * A file validator checks if a file is a normal file, and not a directory
 * @author heikok
 *
 */
public class FileValidator implements IValidator<File> {
	
	public Boolean isValid(File file) {
		return file.isFile();
	}

}
