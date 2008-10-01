/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.form105.rm.base;

/**
 *
 * @author heiko
 */
public interface IStartable {
    
    /**
     * Initialize this component. Called 
     */
    void initialize();
    
    /**
     * Start this component. Called after initialize at the begin of the lifecycle. It can be called again after a stop.
     */
    void start();

    /**
     * Stop this component. Called near the end of the lifecycle. It can be called again after a further start.
     */
    void stop();
    
    /**
     * Sets the container in an dispose state.
     */
    void dispose();

}
