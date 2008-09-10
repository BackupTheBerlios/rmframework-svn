package net.form105.rm.base.helper;

import java.io.File;

public class FileHelper {
	
	/**
	 * Append a file seperator to the end of a file identifier if it can't be found. Otherwise return the string
	 * unchanged.
	 * @param file
	 * @return
	 */
	public static String appendFileSeparator(String file) {
		if (! file.endsWith(File.separator)) {
			return file+File.separator;
		} else {
			return file;
		}
	}

}
