package net.form105.db.cayenne.mapping.auto;

import org.apache.cayenne.CayenneDataObject;

/**
 * Class _User was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _User extends CayenneDataObject {

    public static final String EMAIL_PROPERTY = "email";
    public static final String ID_PROPERTY = "id";
    public static final String LOGIN_PROPERTY = "login";
    public static final String NAME_PROPERTY = "name";
    public static final String PASSWD_PROPERTY = "passwd";
    public static final String USER_GROUP_ID_PROPERTY = "userGroupId";


    public void setEmail(String email) {
        writeProperty("email", email);
    }
    public String getEmail() {
        return (String)readProperty("email");
    }

    public void setId(Double id) {
        writeProperty("id", id);
    }
    public Double getId() {
        return (Double)readProperty("id");
    }

    public void setLogin(String login) {
        writeProperty("login", login);
    }
    public String getLogin() {
        return (String)readProperty("login");
    }

    public void setName(String name) {
        writeProperty("name", name);
    }
    public String getName() {
        return (String)readProperty("name");
    }

    public void setPasswd(String passwd) {
        writeProperty("passwd", passwd);
    }
    public String getPasswd() {
        return (String)readProperty("passwd");
    }

    public void setUserGroupId(Double userGroupId) {
        writeProperty("userGroupId", userGroupId);
    }
    public Double getUserGroupId() {
        return (Double)readProperty("userGroupId");
    }

}
