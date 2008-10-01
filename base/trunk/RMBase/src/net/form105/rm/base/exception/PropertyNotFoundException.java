package net.form105.rm.base.exception;

public class PropertyNotFoundException extends Exception {

	/**
     * Creates a new instance of <code>PropertyNotFoundException</code> without detail message.
     */
    public PropertyNotFoundException() {
    }
    
    
    /**
     * Constructs an instance of <code>PropertyNotFoundException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public PropertyNotFoundException(String msg) {
        super(msg);
    }
	
}
