/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.form105.rm.base.model.parameter;

/**
 *
 * @author heiko
 */
public interface IParameter {

    String getName();

    String getParameterId();

    String getValueAsString();

    void setName(String name);

    void setParameterId(String parameterId);

}
