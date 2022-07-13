package Commands;

import Kaufvertrag.businessObjects.IVertragspartner;
import dataLayer.dataAccessObjects.DataLayerManager;
import dataLayer.dataAccessObjects.IDataLayer;
import dataLayer.dataAccessObjects.IVertragspartnerDao;

public class CommandReadVertragspartner implements ICommand {
    @Override
    public void execute() {
        DataLayerManager    dataLayerManager   = DataLayerManager.getInstance();
        IDataLayer          dataLayer          = dataLayerManager.getDataLayer();
        IVertragspartnerDao vertragspartnerDao = dataLayer.getVertragspartnerDao();
        for (IVertragspartner partner : vertragspartnerDao.read()) {
            System.out.println(partner);
        }
    }
}