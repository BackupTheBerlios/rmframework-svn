package net.form105.rm.server.ant.hotfolder;

import java.util.EventObject;

/**
 * The hotfolder event is sent if new file has arrived in a hotfolder or a file has been removed
 * @author heikok
 *
 */
public class HotfolderEvent extends EventObject {
	
	private static final long serialVersionUID = 1806008446708913667L;
	
	private IInboundObject hotfolderObject;

	/**
	 * 
	 * @param source The inbound object which triggers the flow.
	 */
	public HotfolderEvent(IInboundObject source) {
		super(source);
		this.hotfolderObject = (IInboundObject) source;
	}
	
	public IInboundObject getInboundObject() {
		return hotfolderObject;
	}
	
	

}
