/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.form105.rm.base.container;

import net.form105.rm.base.Agent;

import org.picocontainer.Startable;

/**
 *
 * @author hk
 */
public class ModeContainer extends AbstractContainer implements Startable {

	private PropertiesContainer propertiesContainer;
    private ModeContainer.Mode currentMode;
    private final String MODE_KEY = "server.operation.mode";
    
    public enum Mode {
        
        MEMORY("memory"),
        DBSingle("db"),
        DBMulti("dbmulti"),
        DUAL("dual");
        
        private String id;
        
        private Mode(String id) {
            this.id = id;
        }
        
    }
    
    public ModeContainer(PropertiesContainer properties) {
    	super();
    	this.propertiesContainer = properties;
        
    }
    
    public ModeContainer.Mode getCurrentMode() {
        return currentMode;
    }
    
    public void setCurrentMode(ModeContainer.Mode mode) {
        this.currentMode = mode;
    }

    public void start() {
    	String modeName = Agent.getRMProperty(MODE_KEY);
        setCurrentMode(Mode.valueOf(modeName.toUpperCase()));
        if (getCurrentMode() == Mode.MEMORY) {
            // register trainsient DAO to the Lookup
        }
    }

    public void stop() {
        
    }
    
}
