package net.form105.rm.server.model;

import net.form105.rm.server.model.auto._RMMap;

public class RMMap extends _RMMap {

    private static RMMap instance;

    private RMMap() {}

    public static RMMap getInstance() {
        if(instance == null) {
            instance = new RMMap();
        }

        return instance;
    }
}
