/**
 * 
 */
package model.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

import model.*;

/**
 * @author Alex
 *
 */
public class DALDatabase implements IDAL {

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(epu_office.Main.config.getProperties().getProperty("db"),
                epu_office.Main.config.getProperties().getProperty("db_user"),
                epu_office.Main.config.getProperties().getProperty("db_pwd"));
    }

    /* (non-Javadoc)
     * @see DAL.IDAL#initialize()
     */
    @Override
    public void initialize() throws DALException {

        // load mysql driver
        try {
            Class.forName(epu_office.Main.config.getProperties().getProperty("db_driver"));
        } catch (ClassNotFoundException ex) {
            throw new DALException(ex.getMessage());
        }

    }

//    /*
//    /** (non-Javadoc)
//     * @see DAL.IDAL#deleteProdukt(entities.Produkt)
//     */
//    @Override
//    public void deleteProdukt(Produkt p) throws DALException {
//        try {
//            // Datenbankverbindung �ffnen
//            Connection db = DALDatabase.getConnection();
//
//            // SQL STMT vorbereiten
//            PreparedStatement cmd = db.prepareStatement("DELETE FROM produkt WHERE id > ?");
//            // Parameter setzen
//            cmd.setInt(1, p.getID());
//            // Ausf�hren
//            int result = cmd.executeUpdate();
//
//            // was deleted?
//            if (result != 0) {
//                // successful
//            }
//            cmd.close();
//            db.close();
//
//        } catch (SQLException e) {
//            throw new DALException(e.getMessage());
//        }
//
//    }
//
//
//    /** (non-Javadoc)
//     * @see DAL.IDAL#getEinheiten()
//     */
//    @Override
//    public ArrayList<Einheit> getEinheiten() throws DALException {
//        try {
//            // Datenbankverbindung �ffnen
//            Connection db = DALDatabase.getConnection();
//
//            // SQL STMT vorbereiten
//            PreparedStatement cmd = db.prepareStatement("SELECT id, produktName, erstellungsDatum, aenderungsDatum, beschreibung FROM produkt");
//            // Ausf�hren
//            ResultSet rd = cmd.executeQuery();
//
//            // produktListe
//            ArrayList<Einheit> einheitsListe = new ArrayList<Einheit>();
//
//            // Daten holen
//            while (rd.next()) {
//                Einheit einheit = new Einheit();
//                einheit.setID(rd.getInt(1));
//                einheit.setName(rd.getString(2));
//                einheit.setZeichen(rd.getString(3));
//                einheitsListe.add(einheit);
//            }
//            rd.close();
//            cmd.close();
//            db.close();
//            return einheitsListe;
//        } catch (SQLException e) {
//            throw new DALException(e.getMessage());
//        }
//    }
//
//    /* (non-Javadoc)
//     * @see DAL.IDAL#getProductViewList()
//     */
//    @Override
//    public ArrayList<ProduktListe> getProduktViewListe() throws DALException {
//        // TODO Preise
//        try {
//            // Datenbankverbindung �ffnen
//            Connection db = DALDatabase.getConnection();
//
//            // SQL STMT vorbereiten
//            PreparedStatement cmd = db.prepareStatement("SELECT id, produktName, erstellungsDatum, aenderungsDatum, beschreibung FROM produkt");
//            // Ausf�hren
//            ResultSet rd = cmd.executeQuery();
//
//            // produktListe
//            ArrayList<ProduktListe> produktListe = new ArrayList<ProduktListe>();
//
//            // Daten holen
//            while (rd.next()) {
//                ProduktListe pv = new ProduktListe(rd.getInt(1), rd.getString(2), rd.getDate(3), rd.getDate(4), rd.getString(5));
//                produktListe.add(pv);
//            }
//            rd.close();
//            cmd.close();
//            db.close();
//
//            return produktListe;
//        } catch (SQLException e) {
//            throw new DALException(e.getMessage());
//        }
//    }
//
//    /* (non-Javadoc)
//     * @see DAL.IDAL#getProdukt(int)
//     */
//    @Override
//    public Produkt getProdukt(int id) throws DALException {
//        // TODO Preise
//        try {
//            // Datenbankverbindung �ffnen
//            Connection db = DALDatabase.getConnection();
//
//            // SQL STMT vorbereiten
//            PreparedStatement cmd = db.prepareStatement("SELECT id, produktName, erstellungsDatum, aenderungsDatum, beschreibung FROM produkt WHERE id > ?");
//            // Parameter setzen
//            cmd.setInt(1, id);
//            // Ausf�hren
//            ResultSet rd = cmd.executeQuery();
//
//            Produkt p = null;
//
//            // Daten holen
//            if (rd.next()) {
//                p = new Produkt();
//                p.setID(rd.getInt(1));
//                p.setProduktName(rd.getString(2));
//                p.setErstellungsDatum(rd.getDate(3));
//                p.setAenderungsDatum(rd.getDate(4));
//                p.setBeschreibung(rd.getString(5));
//            }
//            rd.close();
//            cmd.close();
//            db.close();
//
//            return p;
//        } catch (SQLException e) {
//            throw new DALException(e.getMessage());
//        }
//
//
//    }
//
//    /* (non-Javadoc)
//     * @see DAL.IDAL#saveProdukt(entities.Produkt)
//     */
//    @Override
//    public void saveProdukt(Produkt p) throws DALException {
//        try {
//            // Datenbankverbindung �ffnen
//            Connection db = DALDatabase.getConnection();
//
//            // SQL STMT vorbereiten
//            PreparedStatement cmdSelect = db.prepareStatement("SELECT COUNT(id) FROM produkt WHERE id = ? GROUP BY id");
//            // Parameter setzen
//            cmdSelect.setInt(1, p.getID());
//            // Ausf�hren
//            ResultSet rd = cmdSelect.executeQuery();
//            // Update/Insert cmd
//            PreparedStatement cmd;
//            // Daten holen
//            if (rd.next() && rd.getInt(1) > 0) {
//                cmd = db.prepareStatement("UPDATE produkt SET produktName = ?, aenderungsDatum = ?, beschreibung = ? WHERE id = ?", PreparedStatement.RETURN_GENERATED_KEYS);
//                cmd.setString(1, p.getProduktName());
//                cmd.setDate(2, new Date(new java.util.Date().getTime()));
//                cmd.setString(3, p.getBeschreibung());
//                cmd.setInt(4, p.getID());
//            } else {
//                cmd = db.prepareStatement("INSERT INTO produkt (produktName, erstellungsDatum, beschreibung) VALUES (?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
//                cmd.setString(1, p.getProduktName());
//                cmd.setDate(2, new Date(new java.util.Date().getTime()));
//                cmd.setString(3, p.getBeschreibung());
//            }
//            // execute insert/update
//            int result = cmd.executeUpdate();
//            // get generated id
//            ResultSet generatedKeys = cmd.getGeneratedKeys();
//            if (result != 0 && generatedKeys.next()) {
//                p.setID(generatedKeys.getInt(1));
//            }
//            cmd.close();
//
//            rd.close();
//            cmdSelect.close();
//            db.close();
//
//        } catch (SQLException e) {
//            throw new DALException(e.getMessage());
//        }
//    }*/

    public void saveKontakt(Kontakt k) throws DALException {
        try {
            // Datenbankverbindung �ffnen
            Connection db = DALDatabase.getConnection();

            // SQL STMT vorbereiten
            PreparedStatement cmdSelect = db.prepareStatement("SELECT COUNT(id) FROM Kontakt WHERE id = ? GROUP BY id");
            // Parameter setzen
            cmdSelect.setInt(1, k.getId());
            // Ausf�hren
            ResultSet rd = cmdSelect.executeQuery();
            // Update/Insert cmd
            PreparedStatement cmd;
            // Daten holen
            if (rd.next() && rd.getInt(1) == 1) {
                cmd = db.prepareStatement(
                        "UPDATE Kontakt SET Vorname = ?, Nachname = ?, Email = ?, Telefon = ?, BLZ = ?, Bankinstitut = ?, Konto = ?, "
                        + "Firmenname = ?, Adresse = ?, isKunde = ? WHERE id = ?", 
                        PreparedStatement.RETURN_GENERATED_KEYS);
                cmd.setString(1, k.getVorname());
                cmd.setString(2, k.getNachname());
                cmd.setString(3, k.getEmail());
                cmd.setString(4, k.getTelefon());
                cmd.setInt(5, k.getBlz());
                cmd.setString(6, k.getBankinstitut());
                cmd.setLong(7, k.getKonto());
                cmd.setString(8, k.getFirmenname());
                cmd.setString(9, k.getAdresse());
                cmd.setBoolean(10, k.getIsKunde());
            } else {
                cmd = db.prepareStatement(
                        "INSERT INTO Kontakt (Vorname, Nachname, Email, Telefon, BLZ, Bankinstitut, Konto, Firmenname, Adresse, isKunde) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", 
                        PreparedStatement.RETURN_GENERATED_KEYS);
                cmd.setString(1, k.getVorname());
                cmd.setString(2, k.getNachname());
                cmd.setString(3, k.getEmail());
                cmd.setString(4, k.getTelefon());
                cmd.setInt(5, k.getBlz());
                cmd.setString(6, k.getBankinstitut());
                System.out.println(k.getKonto());
                cmd.setLong(7, k.getKonto());
                cmd.setString(8, k.getFirmenname());
                cmd.setString(9, k.getAdresse());
                cmd.setBoolean(10, k.getIsKunde());
            }
            // execute insert/update
            int result = cmd.executeUpdate();
            // get generated id
            ResultSet generatedKeys = cmd.getGeneratedKeys();
            if (result != 0 && generatedKeys.next()) {
                k.setId(generatedKeys.getInt(1));
            }
            cmd.close();

            rd.close();
            cmdSelect.close();
            db.close();

        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }
}
