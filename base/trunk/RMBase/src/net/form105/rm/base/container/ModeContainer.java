/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.form105.rm.base.container;

import net.form105.rm.base.lookup.ILookup;

import org.picocontainer.Startable;

/**
 * The mode container defines the mode the server is started by. This means that
 * this class defines if the server works with transient model objects or
 * without. This is the basic configuration for the db and transient containers.
 * 
 * The mode is set by a server property: server.operation.mode The values of the
 * property that are accepted are the enum Mode objects
 * 
 * @author hk
 */
public class ModeContainer extends AbstractContainer implements Startable {

	private PropertiesContainer propertiesContainer;
	private ModeContainer.Mode currentMode;
	private final String MODE_KEY = "server.operation.mode";
	private ILookup lookup;

	public enum Mode {

		MEMORY("memory", true, false), 
		DBSINGLE("dbsingle", false, true), 
		DBMULTI("dbmulti", false, true), 
		DUAL("dual", true, true);

		private String id;
		private boolean isTransient;
		private boolean hasDBSupport;

		private Mode(String id, boolean isTransient, boolean hasDBSupport) {
			this.id = id;
			this.isTransient = isTransient;
			this.hasDBSupport = hasDBSupport;
		}

		public boolean hasDbSupport() {
			return hasDBSupport;
		}

		public boolean getTransient() {
			return isTransient;
		}

		public String getId() {
			return id;
		}

	}

	public ModeContainer(PropertiesContainer properties, LookupContainer lookupContainer) {
		super();
		this.propertiesContainer = properties;
		lookup = lookupContainer.getGlobalLookup();

	}

	public ModeContainer.Mode getCurrentMode() {
		return currentMode;
	}

	public void setCurrentMode(ModeContainer.Mode mode) {
		this.currentMode = mode;
	}

	public void start() {
		String modeName = propertiesContainer.getProperty(MODE_KEY);
		setCurrentMode(Mode.valueOf(modeName.toUpperCase()));

		
	}

	public void stop() {
		
	}

	

}
