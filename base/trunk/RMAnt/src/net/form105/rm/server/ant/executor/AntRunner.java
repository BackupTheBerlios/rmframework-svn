package net.form105.rm.server.ant.executor;

import net.form105.rm.server.ant.AntFlow;

public class AntRunner implements Runnable {

	private String buildFileName;
	private AntFlow antFlow;

	public AntRunner(String buildFile) {
		this.buildFileName = buildFileName;
	}

	@Override
	public void run() {
		antFlow = new AntFlow();
		antFlow.startAnt(new String[] { buildFileName }, null, null);
		// Getting listener?
	}

	
}
