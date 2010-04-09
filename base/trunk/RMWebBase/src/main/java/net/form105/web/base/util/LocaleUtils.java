package net.form105.web.base.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

public class LocaleUtils {

    private static final Set<String> countries;

    static {
        final Locale[] locales = Locale.getAvailableLocales();
        countries = new TreeSet<String>();
        for(final Locale locale : locales) {
            countries.add(locale.getDisplayCountry());
        }
    }

    public static String[] getCountryNamesMatching(String query) {
        List<String> list = new ArrayList<String>();
        for (final String country : countries) {
            if (country.toUpperCase().startsWith(query.toUpperCase())) {
                list.add(country);
            }
        }
        return list.toArray(new String[list.size()]);
    }

}
