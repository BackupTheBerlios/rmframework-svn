package net.form105.rm.server.i18n;

import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;

/**
 *
 * @author heiko
 */
public abstract class AbstractMessage implements I18nMessage {

    public static Logger logger = Logger.getLogger(AbstractMessage.class);

    /**
     * Getting a value by a key from the resource bundle provided in the
     * subclass
     * @param key
     * @return
     */
    public String getMessage(String key) {
        return getBundle().getString(key);
    }

    /**
     * Uses the key to find a value in the resource bundle. This method should
     * be used if parameters are provided. Each index of the parameters array
     * should match a literal of the form {index} where index is number 
     * in the range of 0 and 9.
     * @param key
     * @param parameters
     * @return
     */
    public String getMessage(String key, String[] parameters) {
        String value = getBundle().getString(key);
        for (int i = 0; i < parameters.length; i++) {
            Pattern p = Pattern.compile("\\w*\\{["+i+"]\\}");
            Matcher m = p.matcher(value);
            value = m.replaceFirst(parameters[i]);
        }
        return value;
    }

    public abstract ResourceBundle getBundle();
}
