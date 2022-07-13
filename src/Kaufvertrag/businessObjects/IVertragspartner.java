package Kaufvertrag.businessObjects;

import java.util.List;

public interface IVertragspartner {
    public int getId();
    public void setId(int id);
    public String getVorname();
    public void setVorname(String vorname);
    public String getNachname();
    public void setNachname(String nachname);
    public String getAusweisNr();
    public void setAusweisNr(String ausweisNr);
    public IAdresse getAdresse();
    public void setAdresse(IAdresse adresse);
}
