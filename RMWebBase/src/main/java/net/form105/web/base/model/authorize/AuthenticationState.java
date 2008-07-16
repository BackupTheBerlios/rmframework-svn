package net.form105.web.base.model.authorize;

import java.io.Serializable;

/**
 * Simple enumeration for definition of states which can be used to define a users authorization state 
 * @author hk
 *
 */
public enum AuthenticationState implements Serializable {
	AUTHORIZED,
	NOTAUTHORIZED;
}
