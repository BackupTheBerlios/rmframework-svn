package net.form105.db.cayenne.mapping;

import net.form105.db.cayenne.mapping.auto._InaMap;

public class InaMap extends _InaMap {

    private static InaMap instance;

    private InaMap() {}

    public static InaMap getInstance() {
        if(instance == null) {
            instance = new InaMap();
        }

        return instance;
    }
}
