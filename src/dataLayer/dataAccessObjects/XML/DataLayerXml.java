package dataLayer.dataAccessObjects.XML;

import dataLayer.dataAccessObjects.IDataLayer;
import dataLayer.dataAccessObjects.IVertragspartnerDao;
import dataLayer.dataAccessObjects.IWareDao;

public class DataLayerXml implements IDataLayer {
    private IWareDao wareDao;
    private IVertragspartnerDao vertragspartnerDao;

    public DataLayerXml() {
        wareDao = new WareDaoXml("src/datasets/Ware.xml");
        vertragspartnerDao = new VertragspartnerDaoXml();
    }

    public IVertragspartnerDao getVertragspartnerDao() {
        return vertragspartnerDao;
    }

    public IWareDao getWareDao() {
        return wareDao;
    }
}
