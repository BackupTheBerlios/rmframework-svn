package net.form105.db.cayenne.mapping.auto;

import org.apache.cayenne.CayenneDataObject;

/**
 * Class _Country was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _Country extends CayenneDataObject {

    public static final String CODE_PROPERTY = "code";
    public static final String ID_PROPERTY = "id";
    public static final String NAME_PROPERTY = "name";
    public static final String REGION_PROPERTY = "region";


    public void setCode(String code) {
        writeProperty("code", code);
    }
    public String getCode() {
        return (String)readProperty("code");
    }

    public void setId(Double id) {
        writeProperty("id", id);
    }
    public Double getId() {
        return (Double)readProperty("id");
    }

    public void setName(String name) {
        writeProperty("name", name);
    }
    public String getName() {
        return (String)readProperty("name");
    }

    public void setRegion(String region) {
        writeProperty("region", region);
    }
    public String getRegion() {
        return (String)readProperty("region");
    }

}
