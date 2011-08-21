package net.form105.rm.server.ant.hotfolder;

import java.util.EventObject;

/**
 * The hotfolder event is sent if new file has arrived in a hotfolder or a file has been removed
 * @author heikok
 *
 */
public class InboundEvent extends EventObject {
	
	private static final long serialVersionUID = 1806008446708913667L;
	
	private InboundObject hotfolderObject;

	/**
	 * 
	 * @param source The inbound object which triggers the flow.
	 */
	public InboundEvent(InboundObject source) {
		super(source);
		this.hotfolderObject = (InboundObject) source;
	}
	
	public InboundObject getInboundObject() {
		return hotfolderObject;
	}
	
	

}
