package net.form105.rm.server.ant.hotfolder;

import java.util.EventObject;

public class HotfolderEvent extends EventObject {
	
	private static final long serialVersionUID = 1806008446708913667L;
	
	private String hotfolderPath;

	public HotfolderEvent(Object source, String hotfolderPath) {
		super(source);
		this.hotfolderPath = hotfolderPath;
	}
	
	public String getHotfolderPath() {
		return hotfolderPath;
	}

}
