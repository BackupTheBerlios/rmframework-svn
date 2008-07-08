/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.form105.rm.base.container;

import com.form105.rm.base.Agent;
import org.picocontainer.Startable;

/**
 *
 * @author heiko
 */
public class ModeContainer extends AbstractContainer implements Startable {

    private ModeContainer.mode currentMode;
    private final String MODE_KEY = "server.operation.mode";
    
    public enum mode {
        
        MEMORY("memory"),
        DB("db"),
        DUAL("dual");
        
        private String id;
        
        private mode(String id) {
            this.id = id;
        }
        
    }
    
    public ModeContainer(PropertiesContainer properties) {
    	super();
        String modeName = Agent.getRMProperty(MODE_KEY);
        setCurrentMode(mode.valueOf(modeName.toUpperCase()));
    }
    
    public ModeContainer.mode getCurrentMode() {
        return currentMode;
    }
    
    public void setCurrentMode(ModeContainer.mode mode) {
        this.currentMode = mode;
    }

    public void start() {
        if (getCurrentMode() == mode.MEMORY) {
            // register trainsient DAO to the Lookup
        }
    }

    public void stop() {
        
    }
    
}
