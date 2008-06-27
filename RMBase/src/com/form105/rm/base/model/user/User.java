package com.form105.rm.base.model.user;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Represents a user which can be identified by its main email address. 
 * @author heiko
 */
@Entity(name = "SystemUser")
public class User implements Serializable {

    @Id
    private Long id;
    private String name;
    private String sirName;
    private String eMail;
    private String password;
    @OneToMany
    private Set<Group> groups = new HashSet<Group>();

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
    public Long getId() {
        return id;
    }

    /**
     * Setting the id of the user
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Setting the name of the user
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Getting the name of the user
     * @param name
     */
    public void setName(String name) {
        this.name = name;
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
}