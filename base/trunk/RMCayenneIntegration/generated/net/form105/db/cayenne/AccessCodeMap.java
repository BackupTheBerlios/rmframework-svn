package net.form105.db.cayenne;

import net.form105.db.cayenne.auto._AccessCodeMap;

public class AccessCodeMap extends _AccessCodeMap {

    private static AccessCodeMap instance;

    private AccessCodeMap() {}

    public static AccessCodeMap getInstance() {
        if(instance == null) {
            instance = new AccessCodeMap();
        }

        return instance;
    }
}
