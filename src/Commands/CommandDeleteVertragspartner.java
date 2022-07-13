package Commands;

import dataLayer.dataAccessObjects.DataLayerManager;
import dataLayer.dataAccessObjects.IDataLayer;
import dataLayer.dataAccessObjects.IVertragspartnerDao;

public class CommandDeleteVertragspartner implements ICommand {
    private int id;

    public CommandDeleteVertragspartner(int id) {
        this.id = id;
    }

    @Override
    public void execute() {
        DataLayerManager dataLayerManager      = DataLayerManager.getInstance();
        IDataLayer          dataLayer          = dataLayerManager.getDataLayer();
        IVertragspartnerDao vertragspartnerDao = dataLayer.getVertragspartnerDao();
        System.out.println("Vertragspartner mit id = " + id + " wurde aus der Datenbank entfernt.");
        vertragspartnerDao.delete(id);
    }
}
