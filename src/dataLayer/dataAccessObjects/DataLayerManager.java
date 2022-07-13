package dataLayer.dataAccessObjects;

import dataLayer.dataAccessObjects.XML.DataLayerXml;
import dataLayer.dataAccessObjects.sqlite.DataLayerSqlite;

public class DataLayerManager {
    private static DataLayerManager instance;
    private static IDataLayer dataLayer;
    private static String persistenceType;

    private DataLayerManager() {}

    public static DataLayerManager getInstance() {
        if (instance == null) {
            instance        = new DataLayerManager();
            persistenceType = instance.readPersistenceType();
            if (persistenceType.equals("xml")) {
                dataLayer = new DataLayerXml();
            } else {
                dataLayer = new DataLayerSqlite();
            }
        }
        return instance;
    }

    public IDataLayer getDataLayer() {
        return dataLayer;
    }

    private String readPersistenceType() {
        return "";
    }
}
