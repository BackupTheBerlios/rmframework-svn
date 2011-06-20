/*
 * Copyright (c) 2011, form105 Heiko Kundlacz
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
package net.form105.rm.server.ant.hotfolder;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class CreateTempEnvironmentListener extends AbstractHotfolderListener {

	@Override
	public void objectArrived(IInboundObject inObject) {
	
		HotfolderInboundObject hfObject = (HotfolderInboundObject) inObject;
		
		File buildSourceDir = new File(hfObject.getHotfolderName() + File.separator + "build");
		File buildTargetDir = new File(hfObject.getTempFolderUniqueName());
		
		File inboundFile = hfObject.getInboundFile();
		
		
		try {
			FileUtils.copyDirectory(buildSourceDir, buildTargetDir);
			FileUtils.copyFileToDirectory(inboundFile, buildTargetDir);
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

	@Override
	public void objectRemoved(IInboundObject hotEvent) {
		// Do nothing

	}

}
