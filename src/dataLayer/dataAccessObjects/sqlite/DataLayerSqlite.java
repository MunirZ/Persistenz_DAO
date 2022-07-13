package dataLayer.dataAccessObjects.sqlite;

import dataLayer.dataAccessObjects.IDataLayer;
import dataLayer.dataAccessObjects.IVertragspartnerDao;
import dataLayer.dataAccessObjects.IWareDao;

import java.sql.Connection;

public class DataLayerSqlite implements IDataLayer {
    private IVertragspartnerDao vertragspartnerDao;
    private IWareDao wareDao;
    private ConnectionManager dbCon;

    public DataLayerSqlite() {
        dbCon = new ConnectionManager();
        wareDao = new WareDaoSqlite(dbCon);
        vertragspartnerDao = new VertragspartnerDaoSqlite(dbCon);
    }

    public IVertragspartnerDao getVertragspartnerDao() {
        return vertragspartnerDao;
    }

    public IWareDao getWareDao() {
        return wareDao;
    }
}
