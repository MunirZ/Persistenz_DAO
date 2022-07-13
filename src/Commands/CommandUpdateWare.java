package Commands;

import Kaufvertrag.businessObjects.IWare;
import dataLayer.dataAccessObjects.DataLayerManager;
import dataLayer.dataAccessObjects.IDataLayer;
import dataLayer.dataAccessObjects.IWareDao;

import java.io.IOException;

public class CommandUpdateWare implements ICommand {
    private int id;

    public CommandUpdateWare(int id) {
        this.id = id;
    }

    @Override
    public void execute() {
        DataLayerManager dataLayerManager = DataLayerManager.getInstance();
        IDataLayer       dataLayer        = dataLayerManager.getDataLayer();
        IWareDao         wareDao          = dataLayer.getWareDao();
        System.out.println("Gewählte Ware:\n" + wareDao.read(id) + "\n");
        try {
            IWare ware = CommandCreateWare.createWare();
            ware.setId(id);
            wareDao.update(ware);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
