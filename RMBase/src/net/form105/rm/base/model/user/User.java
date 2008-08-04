package net.form105.rm.base.model.user;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Represents a user which has some user data associated. 
 * @author heiko
 */
@Entity(name = "SystemUser")
public class User implements Serializable {

    @Id
    private Long oid;
    private String id;
	private String firstName;
    private String sirName;
    private String eMail;
    private String password;
    private String shortName;
    private boolean isAdmin = false;
    

	@OneToMany
    private Set<Group> groups = new HashSet<Group>();
    
    /**
     * Getting the shortname of a user. Normally used for an administrator or a default user
     * @return
     */
    public String getShortName() {
		return shortName;
	}

    /**
     * Setting a shortname for the given user. Normally used for an administrator or a default user
     * @param shortName
     */
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}


    /**
     * Getting the assigned groups of a user
     * @return
     */
    public Set<Group> getGroups() {
        return groups;
    }

    /**
     * Setting the groups assigned to a user
     * @param groups
     */
    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    /**
     * Getting the id of the user
     * @return
     */
    public Long getOid() {
        return oid;
    }

    /**
     * Setting the oid of the user. That's an internal id for hibernate
     * @param id
     */
    public void setOid(Long oid) {
        this.oid = oid;
    }
    
    /**
     * Getting the id of the user.
     * @return
     */
    public String getId() {
		return id;
	}

    /**
     * Setting the id of the user
     * @param id
     */
	public void setId(String id) {
		this.id = id;
	}

    /**
     * Setting the name of the user
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setting the name of the user
     * @param name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getting the sirname of the user
     * @return
     */
    public String getSirName() {
        return sirName;
    }

    /**
     * Setting the sirname of the user
     * @param sirName
     */
    public void setSirName(String sirName) {
        this.sirName = sirName;
    }

    /**
     * Getting the main email of the user
     * @return
     */
    public String getEMail() {
        return eMail;
    }

    /**
     * Setting the main email of the user
     * @param eMail
     */
    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    /**
     * Getting the password for the user
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setting the password for a user
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
}