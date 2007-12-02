/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.form105.rm.base.container;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.picocontainer.Startable;

/**
 *
 * @author heiko
 */
public class PropertiesContainer extends AbstractContainer implements Startable {
    
    private FileInputStream fiStream;
    private Properties properties;

    public void start() {
        FileInputStream fiStream = null;
        try {
            setProperties(new Properties(System.getProperties()));
            fiStream = new FileInputStream("config/server.properties.xml");
            getProperties().loadFromXML(fiStream);
            for (Object o : getProperties().keySet()) {
                String s = (String) o;
                logger.info(s);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PropertiesContainer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException iex) {
            
        } finally {
            try {
                fiStream.close();
            } catch (IOException ex) {
                Logger.getLogger(PropertiesContainer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void stop() {
        try {
                fiStream.close();
            } catch (IOException ex) {
                Logger.getLogger(PropertiesContainer.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

}
