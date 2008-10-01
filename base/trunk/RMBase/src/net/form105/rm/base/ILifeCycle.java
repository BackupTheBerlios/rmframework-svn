/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.form105.rm.base;

import net.form105.rm.base.command.ResultType;

/**
 *
 * @author heiko
 */
public interface ILifeCycle {
    
    public ResultType init();
    
    public ResultType start();
    
    public ResultType stop();

}
