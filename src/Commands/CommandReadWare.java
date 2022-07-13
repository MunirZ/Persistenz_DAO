package Commands;

import Kaufvertrag.businessObjects.IWare;
import dataLayer.dataAccessObjects.DataLayerManager;
import dataLayer.dataAccessObjects.IDataLayer;
import dataLayer.dataAccessObjects.IWareDao;

public class CommandReadWare implements ICommand {
    @Override
    public void execute() {
        DataLayerManager dataLayerManager = DataLayerManager.getInstance();
        IDataLayer    dataLayer           = dataLayerManager.getDataLayer();
        IWareDao      wareDao             = dataLayer.getWareDao();
        for (IWare ware : wareDao.read()) {
            System.out.println(ware);
        }
    }
}
