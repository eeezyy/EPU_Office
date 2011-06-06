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

    @Override
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
                if (k.getBlz() != null) {
                    cmd.setInt(5, k.getBlz());
                } else {
                    cmd.setNull(5, java.sql.Types.INTEGER);
                }
                cmd.setString(6, k.getBankinstitut());
                if (k.getKonto() != null) {
                    cmd.setLong(7, k.getKonto());
                } else {
                    cmd.setNull(7, java.sql.Types.BIGINT);
                }
                cmd.setString(8, k.getFirmenname());
                cmd.setString(9, k.getStrasse());
                if (k.getHausnr() != null) {
                    cmd.setInt(10, k.getHausnr());
                } else {
                    cmd.setNull(10, java.sql.Types.INTEGER);
                }
                if (k.getPlz() != null) {
                    cmd.setInt(11, k.getPlz());
                } else {
                    cmd.setNull(11, java.sql.Types.INTEGER);
                }
                cmd.setString(12, k.getOrt());
                cmd.setBoolean(13, k.getIsKunde());
                cmd.setInt(14, k.getId());

            } else {
                cmd = db.prepareStatement(
                        "INSERT INTO Kontakt (Vorname, Nachname, Email, Telefon, BLZ, Bankinstitut, Konto, Firmenname, Strasse, Hausnr, PLZ, Ort, isKunde) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                        PreparedStatement.RETURN_GENERATED_KEYS);
                cmd.setString(1, k.getVorname());
                cmd.setString(2, k.getNachname());
                cmd.setString(3, k.getEmail());
                cmd.setString(4, k.getTelefon());
                if (k.getBlz() != null) {
                    cmd.setInt(5, k.getBlz());
                } else {
                    cmd.setNull(5, java.sql.Types.INTEGER);
                }
                cmd.setString(6, k.getBankinstitut());
                if (k.getKonto() != null) {
                    cmd.setLong(7, k.getKonto());
                } else {
                    cmd.setNull(7, java.sql.Types.BIGINT);
                }
                cmd.setString(8, k.getFirmenname());
                cmd.setString(9, k.getStrasse());
                if (k.getHausnr() != null) {
                    cmd.setInt(10, k.getHausnr());
                } else {
                    cmd.setNull(10, java.sql.Types.INTEGER);
                }
                if (k.getPlz() != null) {
                    cmd.setInt(11, k.getPlz());
                } else {
                    cmd.setNull(11, java.sql.Types.INTEGER);
                }
                cmd.setString(12, k.getOrt());
                cmd.setBoolean(13, k.getIsKunde());

            }
            // execute insert/update
            int result = cmd.executeUpdate();
            Logger.log(Level.INFO, DALDatabase.class, new DALModelModified("saveKontakt"));
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

    @Override
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
                Integer intResult = null;

                Kontakt k = new Kontakt();
                k.setId(rd.getInt(1));
                k.setVorname(rd.getString(2));
                k.setNachname(rd.getString(3));
                k.setEmail(rd.getString(4));
                k.setTelefon(rd.getString(5));
                intResult = rd.getInt(6);
                k.setBlz((!rd.wasNull()) ? intResult : null);
                k.setBankinstitut(rd.getString(7));
                rd.wasNull();
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
            Logger.log(Level.SEVERE, DALDatabase.class, ex);
        }

        return kontakte;
    }

    @Override
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
                Logger.log(Level.INFO, DALDatabase.class, new DALModelModified("deleteKontakt"));
            }
            cmd.close();
            db.close();
            Binder.notify(Kontakt.class);
        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

    @Override
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
            Logger.log(Level.SEVERE, DALDatabase.class, new DALModelModified("addAngebotToKontakt"));
        } catch (SQLException ex) {
            Logger.log(Level.SEVERE, DALDatabase.class, ex);
        }
    }

    @Override
    public void saveAngebot(AbstractObject ao) throws DALException {
        java.util.Date today = new java.util.Date();
        if (!(ao instanceof Angebot)) {
            return;
        }
        Angebot a = (Angebot) ao;
        java.sql.Date gueltigkeitAb = new java.sql.Date(a.getGueltigAb().getTime());
        java.sql.Date gueltigkeitBis = new java.sql.Date(a.getGueltigBis().getTime());
        java.sql.Date now = new java.sql.Date(today.getTime());

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
                        "UPDATE Angebot SET Dauer = ?, GueltigAb = ?, GueltigBis = ?, Chance = ?, Aenderungsdatum = ?, Beschreibung = ?, Preis = ?, Name = ?"
                        + "WHERE id = ?",
                        PreparedStatement.RETURN_GENERATED_KEYS);
                cmd.setInt(1, a.getDauer());
                cmd.setDate(2, gueltigkeitAb);
                cmd.setDate(3, gueltigkeitBis);
                cmd.setInt(4, a.getChance());
                cmd.setDate(5, now);
                cmd.setString(6, a.getBeschreibung());
                cmd.setLong(7, a.getPreis());
                cmd.setString(8, a.getName());
                cmd.setInt(9, a.getId());
                Logger.log(Level.INFO, DALDatabase.class, new DALModelModified("saveAngebot"));
            } else {
                cmd = db.prepareStatement(
                        "INSERT INTO Angebot (Name, Dauer, GueltigAb, GueltigBis, Chance, Aenderungsdatum, Beschreibung, Preis)"
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                        PreparedStatement.RETURN_GENERATED_KEYS);
                cmd.setString(1, a.getName());
                cmd.setInt(2, a.getDauer());
                cmd.setDate(3, gueltigkeitAb);
                cmd.setDate(4, gueltigkeitBis);
                cmd.setInt(5, a.getChance());
                cmd.setDate(6, now);
                cmd.setString(7, a.getBeschreibung());
                cmd.setLong(8, a.getPreis());


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
            Logger.log(Level.INFO, DALDatabase.class, new DALModelModified("saveAngebot"));
            Binder.notify(Angebot.class);
        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }

    }

    @Override
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
                Logger.log(Level.INFO, DALDatabase.class, new DALModelModified("deleteAngebot"));
            }
            cmd.close();
            db.close();
            Binder.notify(Kontakt.class);

        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

    @Override
    public ArrayList<Angebot> getAngebotListe() throws DALException {
        ArrayList<Angebot> angebote = new ArrayList<Angebot>();
// Datenbankverbindung �ffnen
        Connection db;
        PreparedStatement cmd;
        ResultSet rd;
        try {
            db = DALDatabase.getConnection();
            cmd = db.prepareStatement("SELECT id, Dauer, GueltigAb, GueltigBis, Chance, Aenderungsdatum, Beschreibung, Preis, Name "
                    + "FROM Angebot");
            rd = cmd.executeQuery();
            // Daten holen
            while (rd.next()) {
                Angebot a = new Angebot();
                a.setId(rd.getInt(1));
                a.setDauer(rd.getInt(2));
                a.setGueltigAb((Date) rd.getDate(3));
                a.setGueltigBis((Date) rd.getDate(4));
                a.setChance(rd.getInt(5));
                a.setAenderungsDatum((Date) rd.getDate(6));
                a.setBeschreibung(rd.getString(7));
                a.setPreis(rd.getLong(8));
                a.setName(rd.getString(9));
                angebote.add(a);
            }
            rd.close();
            cmd.close();
            db.close();
        } catch (SQLException ex) {
            Logger.log(Level.SEVERE, DALDatabase.class, ex);
        }
        return angebote;
    }

    @Override
    public Angebot getAngebot(int id) throws DALException {
        Angebot angebot = new Angebot();
// Datenbankverbindung �ffnen
        Connection db;
        PreparedStatement cmd;
        ResultSet rd;
        try {
            db = DALDatabase.getConnection();
            cmd = db.prepareStatement("SELECT id, Dauer, GueltigAb, GueltigBis, Chance, Aenderungsdatum, Beschreibung, Preis, Name "
                    + "FROM Angebot WHERE id = ?");
            cmd.setInt(1, id);
            rd = cmd.executeQuery();
            // Daten holen
            while (rd.next()) {
                Angebot a = new Angebot();
                a.setId(rd.getInt(1));
                a.setDauer(rd.getInt(2));
                a.setGueltigAb((Date) rd.getDate(3));
                a.setGueltigBis((Date) rd.getDate(4));
                a.setChance(rd.getInt(5));
                a.setAenderungsDatum((Date) rd.getDate(6));
                a.setBeschreibung(rd.getString(7));
                a.setPreis(rd.getLong(8));
                a.setName(rd.getString(9));
                angebot = a;
                break;
            }
            rd.close();
            cmd.close();
            db.close();
        } catch (SQLException ex) {
            Logger.log(Level.SEVERE, DALDatabase.class, ex);
        }
        return angebot;
    }
    
    @Override
    public ArrayList<Projekt> getProjektListe() throws DALException {
        ArrayList<Projekt> projekte = new ArrayList<Projekt>();
// Datenbankverbindung �ffnen
        Connection db;
        PreparedStatement cmd;
        ResultSet rd;
        try {
            db = DALDatabase.getConnection();
            cmd = db.prepareStatement("SELECT id, Angebot_ID, Name, Abgeschlossen, Von, Bis "
                    + "FROM Projekt");
            rd = cmd.executeQuery();
            // Daten holen
            while (rd.next()) {
                Projekt a = new Projekt();
                a.setId(rd.getInt(1));
                // Angebot Objekt zuweisen
                a.setAngebot(this.getAngebot(rd.getInt(2)));
                a.setName(rd.getString(3));
                a.setAbgeschlossen(rd.getBoolean(4));
                a.setVon((Date)rd.getDate(5));
                a.setBis((Date) rd.getDate(6));
                projekte.add(a);
            }
            rd.close();
            cmd.close();
            db.close();
        } catch (SQLException ex) {
            Logger.log(Level.SEVERE, DALDatabase.class, ex);
        }
        return projekte;
    }

    @Override
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
            Logger.log(Level.SEVERE, DALDatabase.class, ex);
        }
        return kontakte;
    }
//    private static Date StringToSQLDate(String s) {
//        Date sqlDate = null;
//        try {
//            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
//            sqlDate = new Date(sdf.parse(s).getTime());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return sqlDate;
//    }
}
