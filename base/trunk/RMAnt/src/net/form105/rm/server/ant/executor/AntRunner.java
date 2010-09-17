package net.form105.rm.server.ant.executor;

import java.io.File;

import net.form105.rm.server.ant.AntFlow;
import net.form105.rm.server.ant.hotfolder.HotfolderEvent;
import net.form105.rm.server.ant.hotfolder.HotfolderListener;

import org.apache.log4j.Logger;

public class AntRunner implements Runnable, HotfolderListener {
	
	public static Logger logger = Logger.getLogger(AntRunner.class);

	private String buildFileName;
	private AntFlow antFlow;

	@Override
	public void run() {
		logger.info("Starting ant with build file: "+buildFileName);
		antFlow = new AntFlow();
		antFlow.startAntFlow(new String[] { "-buildfile", buildFileName }, null, null);
		// Getting listener?
	}

	@Override
	public void fileArrived(HotfolderEvent hotEvent) {
		buildFileName = hotEvent.getHotfolderPath() + File.separator + "build.xml";
		Thread thread = new Thread(this);
		thread.start();
		
	}

	@Override
	public void fileRemoved(HotfolderEvent hotEvent) {
		String fileName = (String) hotEvent.getSource();
		logger.info("File removed from the hotfolder: "+fileName);
		
	}
	
	public void setBuildFileName(String buildFileName) {
		this.buildFileName = buildFileName;
	}
	
	public String getBuildFileName() {
		return buildFileName;
	}

	
}
