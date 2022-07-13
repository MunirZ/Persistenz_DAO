package dataLayer.dataAccessObjects;

import Kaufvertrag.businessObjects.IVertragspartner;

public interface IDataLayer {
    public IVertragspartnerDao getVertragspartnerDao();
    public IWareDao getWareDao();
}
