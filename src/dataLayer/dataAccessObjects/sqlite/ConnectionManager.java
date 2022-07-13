package dataLayer.dataAccessObjects.sqlite;

import dataLayer.businessObjects.Adresse;
import dataLayer.businessObjects.Vertragspartner;

import java.sql.*;

public class ConnectionManager {
    private String CLASSNAME;
    private String CONNECTIONSTRING;
    private Connection existingConnection = null;
    private boolean classLoaded;

    public static void main(String[] args) {
        DataLayerSqlite a = new DataLayerSqlite();
        Vertragspartner ver = new Vertragspartner(0);

        ver.setVorname("benno");
        ver.setNachname("stiebeiner");
        ver.setAusweisNr("A");
        ver.setAdresse(new Adresse("grenz","1","2332","hude"));

        a.getVertragspartnerDao().create(ver);
    }

    public Connection getNewConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            existingConnection = DriverManager.getConnection("jdbc:sqlite:datenbank.db");
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Opened database successfully");

        return existingConnection;
    }

    public Connection getExistingConnection() {
        return existingConnection;
    }

    public Connection getConnection() {
        Connection con = getExistingConnection();
        if (con == null) {
            return getNewConnection();
        } else {
            return con;
        }
    }

    public void query(String sql) {
        try {
            Statement stmt = getConnection().createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
        } catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    public ResultSet queryRes(String sql) {
        try {
            Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            stmt.close();
            return rs;
        } catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
            return null;
        }
    }

    public void close(ResultSet resultSet, Statement statement, Connection connection) {

    }
}
