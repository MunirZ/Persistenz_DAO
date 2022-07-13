package Commands;


import Kaufvertrag.businessObjects.IAdresse;
import Kaufvertrag.businessObjects.IVertragspartner;
import dataLayer.businessObjects.Adresse;
import dataLayer.businessObjects.Vertragspartner;
import dataLayer.dataAccessObjects.DataLayerManager;
import dataLayer.dataAccessObjects.IDataLayer;
import dataLayer.dataAccessObjects.IVertragspartnerDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandCreateVertragspartner implements ICommand {
    @Override
    public void execute() {
        try{
            IVertragspartner vertragspartner = createVertragspartner();
            DataLayerManager dataLayerManager = DataLayerManager.getInstance();
            IDataLayer dataLayer = dataLayerManager.getDataLayer();
            IVertragspartnerDao vertragspartnerDao = dataLayer.getVertragspartnerDao();
            vertragspartnerDao.create(vertragspartner);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static IVertragspartner createVertragspartner() throws IOException {
        BufferedReader input = new BufferedReader((new InputStreamReader(System.in)));
        System.out.println("Geben Sie ihren Vornamen ein");
        String vorname = input.readLine();
        System.out.println("Geben Sie ihren Nachnamen ein");
        String nachname = input.readLine();
        System.out.println("Geben Sie ihre AusweisNummer ein");
        String ausweisNr = input.readLine();

        System.out.println("Geben Sie ihre Straße ein");
        String strasse = input.readLine();
        System.out.println("Geben Sie ihre Hausnummer ein");
        String hausNr = input.readLine();
        System.out.println("Geben Sie ihre Postleitzahl ein");
        String plz = input.readLine();
        System.out.println("Geben Sie ihren Wohnort ein");
        String ort = input.readLine();
        IAdresse adresse = new Adresse(strasse,hausNr, plz, ort);
        Vertragspartner vertragspartner = new Vertragspartner(1, vorname, nachname, ausweisNr, adresse);
        return vertragspartner;
    }
}