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
package net.form105.rm.base.util.helper;

import java.io.File;

import net.form105.rm.base.exception.FileNotFoundRMException;

public class FileHelper {

    /**
     * Get a file object by a {@link String} and check if the file exists. If it doesn't exist
     * it throws a {@link FileNotFoundRMException}.
     * @param file
     * @return
     */
    public static File getFile(String file) {
        File fileObject = new File(file);
        if (fileObject.exists()) {
            return fileObject;
        } else {
            throw new FileNotFoundRMException(file);
        }
    }

    /**
     * Append a file separator to the end of a file identifier if it can't be found. Otherwise return the string
     * unchanged.
     * @param file
     * @return
     */
    public static String appendFileSeparator(String file) {
        if (!file.endsWith(File.separator)) {
            return file + File.separator;
        } else {
            return file;
        }
    }

}
