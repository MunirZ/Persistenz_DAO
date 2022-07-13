package Commands;

import dataLayer.dataAccessObjects.DataLayerManager;
import dataLayer.dataAccessObjects.IDataLayer;
import dataLayer.dataAccessObjects.IWareDao;

public class CommandReadIDWare implements ICommand {
    private int id;

    public CommandReadIDWare(int id) {
        this.id = id;
    }

    @Override
    public void execute() {
        DataLayerManager dataLayerManager = DataLayerManager.getInstance();
        IDataLayer        dataLayer        = dataLayerManager.getDataLayer();
        IWareDao          wareDao          = dataLayer.getWareDao();
        System.out.println(wareDao.read(id));
    }
}
