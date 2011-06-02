/**
 * 
 */
package model.dal;

import controller.Binder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import utils.log.Logger;

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
    public void saveKontakt(AbstractObject ao) throws DALException {
        if (!(ao instanceof Kontakt)) {
            return;
        }
        Kontakt k = (Kontakt) ao;
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
                        + "Firmenname = ?, Strasse = ?, Hausnr = ?, PLZ = ?, Ort = ?, isKunde = ? WHERE id = ?",
                        PreparedStatement.RETURN_GENERATED_KEYS);
                cmd.setString(1, k.getVorname());
                cmd.setString(2, k.getNachname());
                cmd.setString(3, k.getEmail());
                cmd.setString(4, k.getTelefon());
                cmd.setInt(5, k.getBlz());
                cmd.setString(6, k.getBankinstitut());
                cmd.setLong(7, k.getKonto());
                cmd.setString(8, k.getFirmenname());
                cmd.setString(9, k.getStrasse());
                cmd.setInt(10, k.getHausnr());
                cmd.setInt(11, k.getPlz());
                cmd.setString(12, k.getOrt());
                cmd.setBoolean(13, k.getIsKunde());
                cmd.setInt(14, k.getId());
                Logger.log(Level.INFO, DALDatabase.class.getClass(), "Kontakt upgedated");

            } else {
                cmd = db.prepareStatement(
                        "INSERT INTO Kontakt (Vorname, Nachname, Email, Telefon, BLZ, Bankinstitut, Konto, Firmenname, Strasse, Hausnr, PLZ, Ort, isKunde) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
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
                cmd.setString(9, k.getStrasse());
                cmd.setInt(10, k.getHausnr());
                cmd.setInt(11, k.getPlz());
                cmd.setString(12, k.getOrt());
                cmd.setBoolean(13, k.getIsKunde());
                Logger.log(Level.INFO, DALDatabase.class.getClass(), "Kontakt hinzugefügt");
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
            Binder.notify(Kontakt.class);

        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

    public ArrayList<Kontakt> getKontaktListe() {
        ArrayList<Kontakt> kontakte = new ArrayList<Kontakt>();
        // Datenbankverbindung �ffnen
        Connection db;
        PreparedStatement cmd;
        ResultSet rd;
        try {
            db = DALDatabase.getConnection();
            cmd = db.prepareStatement("SELECT id, Vorname, Nachname, Email, Telefon, BLZ, Bankinstitut, Konto, "
                    + "Firmenname, Strasse, Hausnr, PLZ, Ort, isKunde FROM kontakt");
            rd = cmd.executeQuery();
            // Daten holen
            while (rd.next()) {
                Kontakt k = new Kontakt();
                k.setId(rd.getInt(1));
                k.setVorname(rd.getString(2));
                k.setNachname(rd.getString(3));
                k.setEmail(rd.getString(4));
                k.setTelefon(rd.getString(5));
                k.setBlz(rd.getInt(6));
                k.setBankinstitut(rd.getString(7));
                k.setKonto(rd.getLong(8));
                k.setFirmenname(rd.getString(9));
                k.setStrasse(rd.getString(10));
                k.setHausnr(rd.getInt(11));
                k.setPlz(rd.getInt(12));
                k.setOrt(rd.getString(13));
                k.setIsKunde(rd.getBoolean(14));
                kontakte.add(k);
            }
            rd.close();
            cmd.close();
            db.close();
        } catch (SQLException ex) {
            Logger.log(Level.SEVERE, DALDatabase.class.getClass(), ex.getMessage());
        }

        return kontakte;
    }

    public void deleteKontakt(Kontakt k) throws DALException {
        try {
            // Datenbankverbindung öffnen
            Connection db = DALDatabase.getConnection();

            // SQL STMT vorbereiten
            PreparedStatement cmd = db.prepareStatement("DELETE FROM kontakt WHERE id = ?");
            // Parameter setzen
            cmd.setInt(1, k.getId());
            // Ausf�hren
            int result = cmd.executeUpdate();

            // was deleted?
            if (result != 0) {
                // successful
                Logger.log(Level.INFO, DALDatabase.class.getClass(), "Kontakt gelöscht");
            }
            cmd.close();
            db.close();
            Binder.notify(Kontakt.class);
        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

    public void addAngebotToKontakt(Kontakt k, Angebot a) {
        try {
            Connection db = DALDatabase.getConnection();

            // SQL STMT vorbereiten
            PreparedStatement cmdSelect = db.prepareStatement("SELECT COUNT(id) FROM ANGEBOT WHERE id = ? GROUP BY id");
            // Parameter setzen
            cmdSelect.setInt(1, a.getId());
            // Ausführen
            ResultSet rd = cmdSelect.executeQuery();
            // Update/Insert cmd
            PreparedStatement cmd;
            cmd = db.prepareStatement(
                    "INSERT INTO Kontakt_has_Angebot (Kontakt_ID, Angebot_ID"
                    + "VALUES (?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            cmd.setInt(1, k.getId());
            cmd.setInt(2, a.getId());
            
            cmd = db.prepareStatement(
                    "UPDAT Kontakt SET isKunde = ?", PreparedStatement.RETURN_GENERATED_KEYS);
            cmd.setBoolean(1, k.getIsKunde());
            Logger.log(Level.INFO, DALDatabase.class.getClass(), "Angebot einem Kunden hinzugefügt");
        } catch (SQLException ex) {
            Logger.log(Level.SEVERE, DALDatabase.class.getClass(), ex.getMessage());
        }
    }

    public void saveAngebot(AbstractObject ao) throws DALException {
        java.util.Date today = new java.util.Date();
        if (!(ao instanceof Angebot)) {
            return;
        }
        Angebot a = (Angebot) ao;
        try {
            // Datenbankverbindung öffnen
            Connection db = DALDatabase.getConnection();

            // SQL STMT vorbereiten
            PreparedStatement cmdSelect = db.prepareStatement("SELECT COUNT(id) FROM ANGEBOT WHERE id = ? GROUP BY id");
            // Parameter setzen
            cmdSelect.setInt(1, a.getId());
            // Ausführen
            ResultSet rd = cmdSelect.executeQuery();
            // Update/Insert cmd
            PreparedStatement cmd;
            // Daten holen
            if (rd.next() && rd.getInt(1) == 1) {
                cmd = db.prepareStatement(
                        "UPDATE Angebot SET Impl_Dauer = ?, GueltigAb = ?, GueltigBis = ?, Impl_Chance = ?, Aenderungsdatum = ?, Beschreibung = ?, Preis = ?, "
                        + "WHERE id = ?",
                        PreparedStatement.RETURN_GENERATED_KEYS);
                cmd.setInt(1, a.getImplDauer());
                cmd.setDate(2, (java.sql.Date) a.getGueltigAb());
                cmd.setDate(3, (java.sql.Date) a.getGueltigBis());
                cmd.setInt(4, a.getImplChance());
                cmd.setDate(5, (java.sql.Date) today);
                cmd.setString(6, a.getBeschreibung());
                cmd.setLong(7, a.getImplPreis());
                cmd.setInt(8, a.getId());
                Logger.log(Level.INFO, DALDatabase.class.getClass(), "Angebot upgedated");
            } else {
                cmd = db.prepareStatement(
                        "INSERT INTO Angebot (Impl_Dauer, GueltigAb, GueltigBis, Impl_Chance, Aenderungsdatum, Beschreibung, Preis"
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                        PreparedStatement.RETURN_GENERATED_KEYS);
                cmd.setInt(1, a.getImplDauer());
                cmd.setDate(2, (java.sql.Date) a.getGueltigAb());
                cmd.setDate(3, (java.sql.Date) a.getGueltigBis());
                cmd.setInt(4, a.getImplChance());
                cmd.setDate(5, (java.sql.Date) today);
                cmd.setString(6, a.getBeschreibung());
                cmd.setLong(7, a.getImplPreis());
                Logger.log(Level.INFO, DALDatabase.class.getClass(), "Angebot hinzugefügt");
            }
            // execute insert/update
            int result = cmd.executeUpdate();
            // get generated id
            ResultSet generatedKeys = cmd.getGeneratedKeys();
            if (result != 0 && generatedKeys.next()) {
                a.setId(generatedKeys.getInt(1));
            }
            cmd.close();

            rd.close();
            cmdSelect.close();
            db.close();
            Binder.notify(Angebot.class);

        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }

    }

    public void deleteAngebot(Angebot a) throws DALException {
        try {
            // Datenbankverbindung öffnen
            Connection db = DALDatabase.getConnection();

            // SQL STMT vorbereiten
            PreparedStatement cmd = db.prepareStatement("DELETE FROM Angebot WHERE id = ?");
            // Parameter setzen
            cmd.setInt(1, a.getId());
            // Ausf�hren
            int result = cmd.executeUpdate();

            // was deleted?
            if (result != 0) {
                // successful
                Logger.log(Level.INFO, DALDatabase.class.getClass(), "Angebot gelöscht");
            }
            cmd.close();
            db.close();
            Binder.notify(Kontakt.class);

        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

    public ArrayList<Angebot> getAngebotListe() throws DALException {
        ArrayList<Angebot> angebote = new ArrayList<Angebot>();
// Datenbankverbindung �ffnen
        Connection db;
        PreparedStatement cmd;
        ResultSet rd;
        try {
            db = DALDatabase.getConnection();
            cmd = db.prepareStatement("SELECT id, Impl_Dauer, GueltigAb, GueltigBis, Impl_Chance, Aenderungsdatum, Beschreibung, Preis "
                    + "FROM Angebot");
            rd = cmd.executeQuery();
            // Daten holen
            while (rd.next()) {
                Angebot a = new Angebot();
                a.setId(rd.getInt(1));
                a.setImplDauer(rd.getInt(2));
                a.setGueltigAb((Date) rd.getDate(3));
                a.setGueltigBis((Date) rd.getDate(4));
                a.setImplChance(rd.getInt(5));
                a.setAenderungsDatum((Date) rd.getDate(6));
                a.setBeschreibung(rd.getString(7));
                a.setImplPreis(rd.getLong(8));
                angebote.add(a);
            }
            rd.close();
            cmd.close();
            db.close();
        } catch (SQLException ex) {
            Logger.log(Level.SEVERE, DALDatabase.class.getClass(), ex.getMessage());
        }
        return angebote;
    }

    public ArrayList<Kontakt> getKundenListe() throws DALException {
        ArrayList<Kontakt> kontakte = new ArrayList<Kontakt>();
        // Datenbankverbindung �ffnen
        Connection db;
        PreparedStatement cmd;
        ResultSet rd;
        try {
            db = DALDatabase.getConnection();
            cmd = db.prepareStatement("SELECT id, Vorname, Nachname, Email, Telefon, BLZ, Bankinstitut, Konto, "
                    + "Firmenname, Strasse, Hausnr, PLZ, Ort, isKunde FROM kontakt WHERE isKunde = 1;");
            rd = cmd.executeQuery();
            // Daten holen
            while (rd.next()) {
                Kontakt k = new Kontakt();
                k.setId(rd.getInt(1));
                k.setVorname(rd.getString(2));
                k.setNachname(rd.getString(3));
                k.setEmail(rd.getString(4));
                k.setTelefon(rd.getString(5));
                k.setBlz(rd.getInt(6));
                k.setBankinstitut(rd.getString(7));
                k.setKonto(rd.getLong(8));
                k.setFirmenname(rd.getString(9));
                k.setStrasse(rd.getString(10));
                k.setHausnr(rd.getInt(11));
                k.setPlz(rd.getInt(12));
                k.setOrt(rd.getString(13));
                k.setIsKunde(rd.getBoolean(14));
                kontakte.add(k);
            }
            rd.close();
            cmd.close();
            db.close();
        } catch (SQLException ex) {
            Logger.log(Level.SEVERE, DALDatabase.class.getClass(), ex.getMessage());
        }
        return kontakte;
    }
}
