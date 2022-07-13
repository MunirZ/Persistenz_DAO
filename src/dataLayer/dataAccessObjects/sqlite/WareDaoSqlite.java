package dataLayer.dataAccessObjects.sqlite;

import Kaufvertrag.businessObjects.IAdresse;
import Kaufvertrag.businessObjects.IVertragspartner;
import Kaufvertrag.businessObjects.IWare;
import dataLayer.businessObjects.Adresse;
import dataLayer.businessObjects.Vertragspartner;
import dataLayer.businessObjects.Ware;
import dataLayer.dataAccessObjects.IWareDao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WareDaoSqlite implements IWareDao {
    ConnectionManager conManager;
    public WareDaoSqlite(ConnectionManager conManager) {
        this.conManager = conManager;
    }

    @Override
    public IWare create() {
        try {
            Statement stmt = conManager.getConnection().createStatement();

            stmt.executeUpdate( "INSERT INTO ware DEFAULT VALUES;" );
            ResultSet rs = stmt.executeQuery( "SELECT last_insert_rowid() as id;" );

            rs.next();
            IWare ware = new Ware();
            ware.setId(rs.getInt("id"));

            stmt.close();

            return ware;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public IWare create(IWare ware) {
        try {
            Statement stmt = conManager.getConnection().createStatement();

            StringBuilder besonderheitenListe = new StringBuilder();
            for (String str: ware.getBesonderheiten()) {
                besonderheitenListe.append(str);
            }

            StringBuilder maengelListe = new StringBuilder();
            for (String str: ware.getMaengel()) {
                maengelListe.append(str);
            }

            stmt.executeUpdate( "INSERT INTO ware (bezeichnung, beschreibung, preis, besonderheiten, maengel) VALUES ('"+ware.getBezeichnung()+"','"+ware.getBeschreibung()+"','"+ware.getPreis()+"','"+besonderheitenListe.toString()+"','"+maengelListe.toString()+"');" );
            ResultSet rs = stmt.executeQuery( "SELECT last_insert_rowid() as id;" );

            rs.next();
            ware.setId(rs.getInt("id"));

            stmt.close();

            return ware;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public IWare WareFromResultSet(ResultSet rs) throws Exception {
        List<String> besonderheiten = new ArrayList<>();
        for (String str: rs.getString("besonderheiten").split(";")) {
            besonderheiten.add(str);
        }

        List<String> maengel = new ArrayList<>();
        for (String str: rs.getString("maengel").split(";")) {
            maengel.add(str);
        }

        IWare ware = new Ware(rs.getInt("id"), rs.getString("bezeichnung"), rs.getString("beschreibung"), rs.getDouble("preis"), besonderheiten, maengel);

        return ware;
    }

    @Override
    public List<IWare> read() {
        List<IWare> list = new ArrayList<>();

        try {
            Statement stmt = conManager.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM ware;" );

            while (rs.next()) {
                list.add(WareFromResultSet(rs));
            }

            rs.close();
            stmt.close();
        } catch ( Exception e ) { }

        return list;
    }

    @Override
    public IWare read(int id) {
        try {
            Statement stmt = conManager.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM ware WHERE id = "+id+";" );

            rs.next();
            IWare ware = WareFromResultSet(rs);

            rs.close();
            stmt.close();

            return ware;
        } catch ( Exception e ) {
            return null;
        }
    }

    @Override
    public void update(IWare ware) {
        try {
            Statement stmt = conManager.getConnection().createStatement();

            StringBuilder besonderheitenListe = new StringBuilder();
            for (String str: ware.getBesonderheiten()) {
                besonderheitenListe.append(str);
            }

            StringBuilder maengelListe = new StringBuilder();
            for (String str: ware.getMaengel()) {
                maengelListe.append(str);
            }

            stmt.executeUpdate("UPDATE ware SET bezeichnung = '"+ware.getBezeichnung()+"', beschreibung = '"+ware.getBeschreibung()+"', preis = "+ware.getPreis()+", besonderheiten = '"+besonderheitenListe.toString()+"', maengel = '"+maengelListe.toString()+"' WHERE id = " + ware.getId() + ";");
            stmt.close();
        } catch (Exception e) {}
    }

    @Override
    public void delete(int id) {
        try {
            Statement stmt = conManager.getConnection().createStatement();
            stmt.executeUpdate( "DELETE FROM ware WHERE id = "+id+";" );
            stmt.close();
        } catch ( Exception e ) { }
    }
}
