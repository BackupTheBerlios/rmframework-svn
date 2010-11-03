/*
 * Copyright (c) 2010, form105 Heiko Kundlacz
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

public abstract class AbstractHotfolderListener implements IHotfolderListener {

	
	
	@Override
	public abstract void fileArrived(HotfolderEvent hotEvent);
	
	@Override
	public abstract void fileRemoved(HotfolderEvent hotEvent);
	
	/**
	 * A file is always unique within a hotfolder and so is the timestamp of the last modification.
	 * The id is constructed of the hashcode of hotfolders path and this timestamp 
	 * @param hotEvent
	 * @return
	 */
	public String getId(HotfolderEvent hotEvent) {
		File file = new File(hotEvent.getIncomingFilePath());
		long modStamp = file.lastModified();
		long fileHashCode = hotEvent.getIncomingFilePath().hashCode();
		return fileHashCode + "_" + modStamp;
	}

}
