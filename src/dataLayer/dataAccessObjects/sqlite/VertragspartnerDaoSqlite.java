package dataLayer.dataAccessObjects.sqlite;

import Kaufvertrag.businessObjects.IAdresse;
import Kaufvertrag.businessObjects.IVertragspartner;
import dataLayer.businessObjects.Adresse;
import dataLayer.businessObjects.Vertragspartner;
import dataLayer.dataAccessObjects.IVertragspartnerDao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VertragspartnerDaoSqlite implements IVertragspartnerDao {
    ConnectionManager conManager;

    public VertragspartnerDaoSqlite(ConnectionManager conManager) {
        this.conManager = conManager;
    }

    @Override
    public IVertragspartner create() {
        try {
            Statement stmt = conManager.getConnection().createStatement();

            stmt.executeUpdate( "INSERT INTO vertragspartner DEFAULT VALUES;" );
            ResultSet rs = stmt.executeQuery( "SELECT last_insert_rowid() as id;" );

            rs.next();
            IVertragspartner person = new Vertragspartner(rs.getInt("id"));

            stmt.close();

            return person;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public IVertragspartner create(IVertragspartner vertragspartner) {
        try {
            Statement stmt = conManager.getConnection().createStatement();

            stmt.executeUpdate( "INSERT INTO vertragspartner DEFAULT VALUES;" );
            ResultSet rs = stmt.executeQuery( "SELECT last_insert_rowid() as id;" );

            rs.next();
            vertragspartner.setId(rs.getInt("id"));

            stmt.close();

            update(vertragspartner);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return vertragspartner;
    }

    public IVertragspartner VertragspartnerFromResultSet(ResultSet rs) throws Exception {
        IVertragspartner person = new Vertragspartner(rs.getInt("id"));
        person.setAdresse(new Adresse(rs.getString("strasse"), rs.getString("hausNr"), rs.getString("plz"), rs.getString("ort")));
        person.setVorname(rs.getString("vorname"));
        person.setNachname(rs.getString("nachname"));
        person.setAusweisNr(rs.getString("ausweisNr"));
        return person;
    }

    @Override
    public List<IVertragspartner> read() {
        List<IVertragspartner> list = new ArrayList<>();
        
        try {
            Statement stmt = conManager.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM vertragspartner;" );

            while (rs.next()) {
                list.add(VertragspartnerFromResultSet(rs));
            }

            rs.close();
            stmt.close();
        } catch ( Exception e ) { }

        return list;
    }

    @Override
    public IVertragspartner read(int id) {
        try {
            Statement stmt = conManager.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM vertragspartner WHERE id = "+id+";" );

            rs.next();
            IVertragspartner person = VertragspartnerFromResultSet(rs);

            rs.close();
            stmt.close();

            return person;
        } catch ( Exception e ) {
            return null;
        }
    }

    @Override
    public void update(IVertragspartner vertragspartner) {
        try {
            Statement stmt = conManager.getConnection().createStatement();
            IAdresse addr = vertragspartner.getAdresse();
            stmt.executeUpdate("UPDATE vertragspartner SET vorname = '"+vertragspartner.getVorname()+"', nachname = '"+vertragspartner.getNachname()+"', ausweisNr = '"+vertragspartner.getAusweisNr()+"', strasse = '"+addr.getStrasse()+"', hausNr = '"+addr.getHausNr()+"', plz = '"+ addr.getPlz()+"', ort = '"+ addr.getOrt()+"' WHERE id = " + vertragspartner.getId() + ";");
            stmt.close();
        } catch (Exception e) {}
    }

    @Override
    public void delete(int id) {
        try {
            Statement stmt = conManager.getConnection().createStatement();
            stmt.executeUpdate( "DELETE FROM vertragspartner WHERE id = "+id+";" );
            stmt.close();
        } catch ( Exception e ) { }
    }
}
