package Kaufvertrag;

import Commands.CommandFactory;
import Commands.CommandQuit;
import Commands.ICommand;
import Commands.exception.BefehlUnbekanntException;
import Kaufvertrag.businessObjects.IWare;
import dataLayer.dataAccessObjects.DataLayerManager;
import dataLayer.dataAccessObjects.IDataLayer;
import dataLayer.dataAccessObjects.IWareDao;

import java.util.List;
import java.util.Scanner;

public class Datenbank {
    private DataLayerManager dataLayerManager = DataLayerManager.getInstance();
    private IDataLayer dataLayer = dataLayerManager.getDataLayer();
    private IWareDao wareDao = dataLayer.getWareDao();
    private List<IWare> wareList = wareDao.read();

    public void starten() throws BefehlUnbekanntException {
        System.out.println("Geben sie Help ein um die Befehlsliste anzuzeigen.");
        Scanner scannerZeile = new Scanner(System.in);
        boolean end          = false;

        while (!end) {
            System.out.print("> ");
            String input = scannerZeile.nextLine();
            try {
                ICommand command = CommandFactory.createCommand(input);
                command.execute();
                if (command instanceof CommandQuit) { end = true; }
            } catch (BefehlUnbekanntException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
