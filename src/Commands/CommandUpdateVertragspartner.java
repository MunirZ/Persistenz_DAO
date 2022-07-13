package Commands;

import Kaufvertrag.businessObjects.IVertragspartner;
import dataLayer.dataAccessObjects.DataLayerManager;
import dataLayer.dataAccessObjects.IDataLayer;
import dataLayer.dataAccessObjects.IVertragspartnerDao;

import java.io.IOException;

public class CommandUpdateVertragspartner implements ICommand {
    private int id;

    public CommandUpdateVertragspartner(int id) {
        this.id = id;
    }

    @Override
    public void execute() {
        DataLayerManager    dataLayerManager   = DataLayerManager.getInstance();
        IDataLayer          dataLayer          = dataLayerManager.getDataLayer();
        IVertragspartnerDao vertragspartnerDao = dataLayer.getVertragspartnerDao();
        System.out.println("Gewählter Vertragspartner:\n" + vertragspartnerDao.read(id) + "\n" );
        try {
            IVertragspartner vertragspartner = CommandCreateVertragspartner.createVertragspartner();
            vertragspartner.setId(id);
            vertragspartnerDao.update(vertragspartner);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
