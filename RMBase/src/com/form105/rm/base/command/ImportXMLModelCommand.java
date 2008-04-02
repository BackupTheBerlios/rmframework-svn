/*
* Copyright (c) 2008, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/

package com.form105.rm.base.command;

import com.form105.rm.base.exception.RMException;
import com.form105.rm.base.model.xml.XMLModelLoader;

/**
 *
 * @author heiko
 */
public class ImportXMLModelCommand extends AbstractCommand {
    
    private String filePath;
    
    public ImportXMLModelCommand(String filePath) {
        this.filePath = filePath;
    }

    public void execute() throws RMException {
        XMLModelLoader loader = new XMLModelLoader("config/model.xml");
        loader.init();
        loader.load();
        loader.stop();
    }

}
