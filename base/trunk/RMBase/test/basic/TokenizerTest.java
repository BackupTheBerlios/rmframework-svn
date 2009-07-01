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
package basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;
import org.junit.Test;

public class TokenizerTest {

	private static Logger logger = Logger.getLogger(TokenizerTest.class);

	@Test
	public void createTokenizerByFile() {
		File file = new File("./config/log4j.properties");
		try {
			logger.info("Canonical path: " + file.getCanonicalPath());
			logger.info("Canonical file: " + file.getCanonicalFile());
			logger.info("Path: " + file.getPath());

			logger.info("Canonical parent path: " + file.getParentFile().getCanonicalPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		log4jFileEntries(file);
	}

	public List<File> log4jFileEntries(File log4jFile) {
		List<File> fileEntries = new ArrayList<File>();
		Properties log4jProps = new Properties();

		try {
			FileInputStream fiStream = new FileInputStream(log4jFile);
			log4jProps.load(fiStream);
			Set<Object> keys = log4jProps.keySet();
			for (Object object:keys) {
				String key = (String) object;
				StringBuffer sb = new StringBuffer(key.trim());
				int lastSlashIndex = sb.lastIndexOf(".");
				String lastEntry = sb.substring(lastSlashIndex + 1, sb.length());
				logger.info("lastEntry: "+lastEntry);
				if (lastEntry.equals("File")) {
					fileEntries.add(new File((String) log4jProps.get(key)));
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return fileEntries;
		} catch (IOException e) {
			e.printStackTrace();
			return fileEntries;
		}
		return fileEntries;
	}

}
