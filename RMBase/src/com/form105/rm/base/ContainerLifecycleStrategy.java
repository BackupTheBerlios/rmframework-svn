/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.form105.rm.base;

import java.lang.reflect.Method;
import org.picocontainer.ComponentMonitor;
//import org.picocontainer.defaults.DefaultLifecycleStrategy;

/**
 *
 * @author Heiko Kundlacz
 */
public class ContainerLifecycleStrategy  {

    /*public ContainerLifecycleStrategy(ComponentMonitor monitor) {
        super(monitor);
    }
    private static Method start,  stop,  initialize,  dispose;

    {
        try {
            initialize = IStartable.class.getMethod("initialize", (Class[]) null);
            start = IStartable.class.getMethod("start", (Class[]) null);
            stop = IStartable.class.getMethod("stop", (Class[]) null);
            dispose = IStartable.class.getMethod("dispose", (Class[]) null);
        } catch (NoSuchMethodException e) {
        }
    }

    public void initialize(Object component) {
        if (component != null && component instanceof IStartable) {
            long str = System.currentTimeMillis();
            currentMonitor().invoking(initialize, component);
            try {
                ((IStartable) component).start();
                currentMonitor().invoked(initialize, component, System.currentTimeMillis() - str);
            } catch (RuntimeException cause) {
                currentMonitor().lifecycleInvocationFailed(initialize, component, cause); // may re-throw
            }
        }
    }
    
    public void start(Object component) {
        if (component != null && component instanceof IStartable) {
            long str = System.currentTimeMillis();
            currentMonitor().invoking(start, component);
            try {
                ((IStartable) component).start();
                currentMonitor().invoked(start, component, System.currentTimeMillis() - str);
            } catch (RuntimeException cause) {
                currentMonitor().lifecycleInvocationFailed(start, component, cause); // may re-throw
            }
        }
    }

    public void stop(Object component) {
        if (component != null && component instanceof IStartable) {
            long str = System.currentTimeMillis();
            currentMonitor().invoking(stop, component);
            try {
                ((IStartable) component).stop();
                currentMonitor().invoked(stop, component, System.currentTimeMillis() - str);
            } catch (RuntimeException cause) {
                currentMonitor().lifecycleInvocationFailed(stop, component, cause); // may re-throw
            }
        }
    }

    public void dispose(Object component) {
        if (component != null && component instanceof IStartable) {
            long str = System.currentTimeMillis();
            currentMonitor().invoking(dispose, component);
            try {
                ((IStartable) component).dispose();
                currentMonitor().invoked(dispose, component, System.currentTimeMillis() - str);
            } catch (RuntimeException cause) {
                currentMonitor().lifecycleInvocationFailed(dispose, component, cause); // may re-throw
            }
        }
    }

    public boolean hasLifecycle(Class type) {
        return IStartable.class.isAssignableFrom(type) || IStartable.class.isAssignableFrom(type);
    }*/
}


