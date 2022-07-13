package dataLayer.businessObjects;

import Kaufvertrag.businessObjects.IVertragspartner;
import Kaufvertrag.businessObjects.IWare;

public class Kaufvertrag {

    public IVertragspartner verkaeufer;
    public IVertragspartner kaeufer;
    public IWare ware;
    public String zahlungsmodalitaeten;

    public Kaufvertrag(IVertragspartner kaeufer, IVertragspartner verkaeufer, IWare ware) {
        this.kaeufer = kaeufer;
        this.verkaeufer = verkaeufer;
        this.ware = ware;
    }

    public IVertragspartner getVerkaeufer() {
        return verkaeufer;
    }

    public void setVerkaeufer(IVertragspartner verkaeufer) {
        this.verkaeufer = verkaeufer;
    }

    public IVertragspartner getKaeufer() {
        return kaeufer;
    }

    public void setKaeufer(IVertragspartner kaeufer) {
        this.kaeufer = kaeufer;
    }

    public IWare getWare() {
        return ware;
    }

    public void setWare(IWare ware) {
        this.ware = ware;
    }

    public String getZahlungsmodalitaeten() {
        return zahlungsmodalitaeten;
    }

    public void setZahlungsmodalitaeten(String zahlungsmodalitaeten) {
        this.zahlungsmodalitaeten = zahlungsmodalitaeten;
    }

    @Override
    public String toString() {
        return "Kaufvertrag{" +
                "kaeufer='" + kaeufer + '\'' +
                ", verkaeufer='" + verkaeufer + '\'' +
                ", ware=" + ware +
                '}';
    }

}
