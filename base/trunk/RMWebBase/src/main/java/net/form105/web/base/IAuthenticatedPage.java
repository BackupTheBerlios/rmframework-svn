package net.form105.web.base;

/**
 * This interface should be implemented by pages that requires Authentication. The {@link Application} checks in its 
 * <code>init()<code> method if a user has logged in. And if not, the user will be forwarded to a defined page, usually
 * the login page.
 * @author hk
 *
 */
public interface IAuthenticatedPage {

}
