package dataLayer.businessObjects;

import Kaufvertrag.businessObjects.IAdresse;
import Kaufvertrag.businessObjects.IVertragspartner;

public class Vertragspartner implements IVertragspartner {
    private int id;
    private String vorname;
    private String nachname;
    private String ausweisNr;
    private IAdresse adresse;

    public Vertragspartner(int id) {
        this.id = id;
    }

    public Vertragspartner(int id, String vorname, String nachname, String ausweisNr, IAdresse adresse) {
        this.id        = id;
        this.vorname   = vorname;
        this.nachname  = nachname;
        this.ausweisNr = ausweisNr;
        this.adresse   = adresse;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getVorname() {
        return vorname;
    }

    @Override
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    @Override
    public String getNachname() {
        return nachname;
    }

    @Override
    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    @Override
    public String getAusweisNr() {
        return ausweisNr;
    }

    @Override
    public void setAusweisNr(String ausweisNr) {
        this.ausweisNr = ausweisNr;
    }

    @Override
    public IAdresse getAdresse() {
        return adresse;
    }

    @Override
    public void setAdresse(IAdresse adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Vertragspartner{" +
                "id=" + id +
                ", vorname='" + vorname + '\'' +
                ", nachname='" + nachname + '\'' +
                ", ausweisNr='" + ausweisNr + '\'' +
                ", adresse=" + adresse +
                '}';
    }
}
