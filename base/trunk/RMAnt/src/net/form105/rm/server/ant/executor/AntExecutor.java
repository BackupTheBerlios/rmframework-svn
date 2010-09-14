package net.form105.rm.server.ant.executor;

import java.util.concurrent.Executor;

import net.form105.rm.server.ant.AntFlow;

import org.apache.log4j.Logger;

public class AntExecutor implements Executor {
	
	public static Logger logger = Logger.getLogger(AntExecutor.class);
	
	private String buildFileName;
	
	/**
	 * 
	 * @param buildFileName The complete path to the build file
	 */
	public AntExecutor(String buildFileName) {
		this.buildFileName = buildFileName;
	}

	@Override
	public void execute(Runnable command) {
		AntFlow aFlow = new AntFlow();
		aFlow.startAnt(new String[] {buildFileName}, null, null);
	}
}
