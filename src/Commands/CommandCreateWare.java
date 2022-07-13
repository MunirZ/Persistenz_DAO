package Commands;

import Kaufvertrag.businessObjects.IWare;
import dataLayer.businessObjects.Ware;
import dataLayer.dataAccessObjects.DataLayerManager;
import dataLayer.dataAccessObjects.IDataLayer;
import dataLayer.dataAccessObjects.IWareDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class CommandCreateWare implements ICommand {
    @Override
    public void execute() {
        IWare ware = null;
        try {
            ware = createWare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DataLayerManager dataLayerManager = DataLayerManager.getInstance();
        IDataLayer dataLayer = dataLayerManager.getDataLayer();
        IWareDao wareDao = dataLayer.getWareDao();
        wareDao.create(ware);

    }

    public static IWare createWare() throws IOException {
        BufferedReader inputBuffer = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Geben sie die Bezeichnung der Ware ein:\t");
        String bezeichnung = inputBuffer.readLine();
        System.out.println("Geben sie eine Beschreibung der Ware ein:\t");
        String beschreibung = inputBuffer.readLine();
        System.out.println("Geben sie den Preis ein:\t");
        int preis = Integer.parseInt(inputBuffer.readLine());
        System.out.println("Geben sie Besonderheiten ein:\t");
        String besonderheit = inputBuffer.readLine();
        List<String> besonderheiten = List.of(new String[]{besonderheit});
        System.out.println("Geben sie Mängel ein:\t");
        String macken = inputBuffer.readLine();
        List<String> maengel = List.of(new String[]{macken});

        IWare ware = new Ware(1, bezeichnung, beschreibung, preis, besonderheiten, maengel);
        return ware;
    }
}

