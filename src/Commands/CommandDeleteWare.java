package Commands;

import dataLayer.dataAccessObjects.DataLayerManager;
import dataLayer.dataAccessObjects.IDataLayer;
import dataLayer.dataAccessObjects.IWareDao;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class CommandDeleteWare implements ICommand {
    private int id;

    public CommandDeleteWare(int id) {
        this.id = id;
    }

    @Override
    public void execute() {
        DataLayerManager dataLayerManager = DataLayerManager.getInstance();
        IDataLayer         dataLayer        = dataLayerManager.getDataLayer();
        IWareDao           wareDao          = dataLayer.getWareDao();
        System.out.println("Ware mit id = " + id + " wurde aus der Datenbank entfernt.");
        try {
            wareDao.delete(id);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}
