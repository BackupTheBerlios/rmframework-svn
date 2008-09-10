package net.form105.rm.base.auth;

import java.io.Serializable;

/**
 * An identy is a certificate which associates a user and an organization to differentiate actions
 * and commands from each other. The identity should be bound to services and commands.
 * @author hk
 *
 */
public abstract class AbstractIdentity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String mandate;
	
	public AbstractIdentity(Long id, String mandate) {
		this.id = id;
		this.mandate = mandate;
	}
	
	public Long getId() {
		return id;
	}

	public String getMandate() {
		return mandate;
	}

	
	
	

}
