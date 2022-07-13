package Commands;

import dataLayer.dataAccessObjects.DataLayerManager;
import dataLayer.dataAccessObjects.IDataLayer;
import dataLayer.dataAccessObjects.IVertragspartnerDao;

public class CommandReadIDVertragspartner implements ICommand {
    private int id;

    public CommandReadIDVertragspartner(int id) {
        this.id = id;
    }

    @Override
    public void execute() {
        DataLayerManager dataLayerManager = DataLayerManager.getInstance();
        IDataLayer          dataLayer          = dataLayerManager.getDataLayer();
        IVertragspartnerDao vertragspartnerDao = dataLayer.getVertragspartnerDao();
        System.out.println(vertragspartnerDao.read(id));
    }
}
