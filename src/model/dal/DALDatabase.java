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
import java.util.logging.Level;
import utils.log.Logger;

import model.*;

/**
 * @author Alex
 *
 */
public class DALDatabase implements IDAL {

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(epu_office.Main.config.getDbPath(),
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
            Integer result = cmd.executeUpdate();
            Logger.log(Level.INFO, DALDatabase.class, new InfoMessage("saveKontakt"));
            // get generated id
            ResultSet generatedKeys = cmd.getGeneratedKeys();
            if (result != null && result != 0 && generatedKeys.next()) {
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
    public ArrayList<AbstractObject> getKontaktListe() throws DALException {
        ArrayList<AbstractObject> kontakte = new ArrayList<AbstractObject>();
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
            throw new DALException(ex.getMessage());
        }

        return kontakte;
    }

    @Override
    public Kontakt getKontakt(Integer id) throws DALException {
        Kontakt kontakt = null;
        // Datenbankverbindung �ffnen
        Connection db;
        PreparedStatement cmd;
        ResultSet rd;
        try {
            db = DALDatabase.getConnection();
            cmd = db.prepareStatement("SELECT id, Vorname, Nachname, Email, Telefon, BLZ, Bankinstitut, Konto, "
                    + "Firmenname, Strasse, Hausnr, PLZ, Ort, isKunde FROM kontakt WHERE id = ? ");
            cmd.setInt(1, id);
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
                kontakt = k;
                break;
            }
            rd.close();
            cmd.close();
            db.close();
        } catch (SQLException ex) {
            throw new DALException(ex.getMessage());
        }

        return kontakt;
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
            Integer result = cmd.executeUpdate();

            // was deleted?
            if (result != null && result != 0) {
                // successful
                Logger.log(Level.INFO, DALDatabase.class, new InfoMessage("deleteKontakt"));
            }
            cmd.close();
            db.close();
            Binder.notify(Kontakt.class);
        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

    @Override
    public void addAngebotToKontakt(Kontakt k, Angebot a) throws DALException {
        try {
            Connection db = DALDatabase.getConnection();

            // SQL STMT vorbereiten
            PreparedStatement cmdSelect = db.prepareStatement("SELECT COUNT(KONTAKT_ID) FROM KONTAKT_HAS_ANGEBOT WHERE (KONTAKT_ID = ? AND ANGEBOT_ID = ?) GROUP BY KONTAKT_ID");
            // Parameter setzen
            cmdSelect.setInt(1, k.getId());
            cmdSelect.setInt(2, a.getId());
            // Ausführen
            ResultSet rd = cmdSelect.executeQuery();
            // Update/Insert cmd
            PreparedStatement cmd;
            Integer result;
            if (!rd.next() || rd.getInt(1) == 0) {
                cmd = db.prepareStatement(
                        "INSERT INTO Kontakt_has_Angebot (Kontakt_ID, Angebot_ID) VALUES (?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
                cmd.setInt(1, k.getId());
                cmd.setInt(2, a.getId());
                result = cmd.executeUpdate();
                if (result != null) {
                    Logger.log(Level.INFO, DALDatabase.class, new InfoMessage("addAngebotToKontakt"));
                }
                cmd = db.prepareStatement("UPDATE Kontakt SET isKunde = ? WHERE id = ?", PreparedStatement.RETURN_GENERATED_KEYS);
                cmd.setBoolean(1, true);
                cmd.setInt(2, k.getId());
                result = cmd.executeUpdate();
                if (result != null) {
                    Logger.log(Level.INFO, DALDatabase.class, new InfoMessage("addAngebotToKontakt"));
                }
            }
            Binder.notify(Angebot.class);
            Binder.notify(Kontakt.class);
        } catch (SQLException ex) {
            throw new DALException(ex.getMessage());
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
                cmd.setDouble(7, a.getPreis());
                cmd.setString(8, a.getName());
                cmd.setInt(9, a.getId());
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
                cmd.setDouble(8, a.getPreis());
            }
            // execute insert/update
            Integer result = cmd.executeUpdate();
            // get generated id
            ResultSet generatedKeys = cmd.getGeneratedKeys();
            if (result != null && result != 0 && generatedKeys.next()) {
                a.setId(generatedKeys.getInt(1));
            }
            cmd.close();
            rd.close();
            cmdSelect.close();
            db.close();
            Logger.log(Level.INFO, DALDatabase.class, new InfoMessage("saveAngebot"));
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
            Integer result = cmd.executeUpdate();

            // was deleted?
            if (result != null && result != 0) {
                // successful
                Logger.log(Level.INFO, DALDatabase.class, new InfoMessage("deleteAngebot"));
            }
            cmd.close();
            db.close();
            Binder.notify(Angebot.class);

        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

    @Override
    public ArrayList<AbstractObject> getAngebotListe() throws DALException {
        ArrayList<AbstractObject> angebote = new ArrayList<AbstractObject>();
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
                a.setGueltigAb(new java.util.Date(rd.getDate(3).getTime()));
                a.setGueltigBis(new java.util.Date(rd.getDate(4).getTime()));
                a.setChance(rd.getInt(5));
                a.setAenderungsDatum(new java.util.Date(rd.getDate(6).getTime()));
                a.setBeschreibung(rd.getString(7));
                a.setPreis(rd.getDouble(8));
                a.setName(rd.getString(9));
                angebote.add(a);
            }
            rd.close();
            cmd.close();
            db.close();
        } catch (SQLException ex) {
            throw new DALException(ex.getMessage());
        }
        return angebote;
    }

    @Override
    public ArrayList<AbstractObject> getAngebot() throws DALException {
        return getAngebotListe();
    }

    @Override
    public Angebot getAngebot(Integer id) throws DALException {
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
                a.setGueltigAb(new java.util.Date(rd.getDate(3).getTime()));
                a.setGueltigBis(new java.util.Date(rd.getDate(4).getTime()));
                a.setChance(rd.getInt(5));
                a.setAenderungsDatum(new java.util.Date(rd.getDate(6).getTime()));
                a.setBeschreibung(rd.getString(7));
                a.setPreis(rd.getDouble(8));
                a.setName(rd.getString(9));
                angebot = a;
                break;
            }
            rd.close();
            cmd.close();
            db.close();
        } catch (SQLException ex) {
            throw new DALException(ex.getMessage());
        }
        return angebot;
    }

    @Override
    public ArrayList<AbstractObject> getProjekt() throws DALException {
        return getProjektListe();
    }

    @Override
    public ArrayList<AbstractObject> getProjektListe() throws DALException {
        ArrayList<AbstractObject> projekte = new ArrayList<AbstractObject>();
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
                a.setIsAbgeschlossen(rd.getBoolean(4));
                a.setVon(new java.util.Date(rd.getDate(5).getTime()));
                a.setBis(new java.util.Date(rd.getDate(6).getTime()));
                projekte.add(a);
            }
            rd.close();
            cmd.close();
            db.close();
        } catch (SQLException ex) {
            throw new DALException(ex.getMessage());
        }
        return projekte;
    }

    @Override
    public ArrayList<AbstractObject> getKundenListe() throws DALException {
        ArrayList<AbstractObject> kontakte = new ArrayList<AbstractObject>();
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
            throw new DALException(ex.getMessage());
        }
        return kontakte;
    }

    @Override
    public void saveProjekt(AbstractObject aO) throws DALException {
        java.util.Date today = new java.util.Date();
        if (!(aO instanceof Projekt)) {
            return;
        }
        Projekt p = (Projekt) aO;
        java.sql.Date von = new java.sql.Date(p.getVon().getTime());
        java.sql.Date bis = new java.sql.Date(p.getBis().getTime());

        try {
            // Datenbankverbindung öffnen
            Connection db = DALDatabase.getConnection();

            // SQL STMT vorbereiten
            PreparedStatement cmdSelect = db.prepareStatement("SELECT COUNT(id) FROM Projekt WHERE id = ? GROUP BY id");
            // Parameter setzen
            cmdSelect.setInt(1, p.getId());
            // Ausführen
            ResultSet rd = cmdSelect.executeQuery();
            // Update/Insert cmd
            PreparedStatement cmd;
            // Daten holen
            if (rd.next() && rd.getInt(1) == 1) {
                cmd = db.prepareStatement(
                        "UPDATE PROJEKT SET ANGEBOT_ID = ?, NAME = ?, ABGESCHLOSSEN = ?, VON = ?, BIS = ? WHERE id = ?",
                        PreparedStatement.RETURN_GENERATED_KEYS);
                cmd.setInt(1, p.getAngebot().getId());
                cmd.setString(2, p.getName());
                cmd.setBoolean(3, p.getIsAbgeschlossen());
                cmd.setDate(4, von);
                cmd.setDate(5, bis);
                cmd.setInt(6, p.getId());
            } else {
                cmd = db.prepareStatement(
                        "INSERT INTO PROJEKT (ANGEBOT_ID, NAME, ABGESCHLOSSEN, VON, BIS) VALUES (?, ?, ?, ?, ?)",
                        PreparedStatement.RETURN_GENERATED_KEYS);
                if (p.getAngebot() != null) {
                    cmd.setInt(1, p.getAngebot().getId());
                } else {
                    throw new DALException("Angebot muss angegeben werden");
                }
                cmd.setString(2, p.getName());
                cmd.setBoolean(3, p.getIsAbgeschlossen());
                cmd.setDate(4, von);
                cmd.setDate(5, bis);
            }
            // execute insert/update
            Integer result = cmd.executeUpdate();
            // get generated id
            ResultSet generatedKeys = cmd.getGeneratedKeys();
            if (result != null && result != 0 && generatedKeys.next()) {
                p.setId(generatedKeys.getInt(1));
            }
            cmd.close();
            rd.close();
            cmdSelect.close();
            db.close();
            Logger.log(Level.INFO, DALDatabase.class, new InfoMessage("saveProjekt"));
            Binder.notify(Projekt.class);
        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

    @Override
    public void deleteProjekt(Projekt p) throws DALException {
        try {
            // Datenbankverbindung öffnen
            Connection db = DALDatabase.getConnection();

            // SQL STMT vorbereiten
            PreparedStatement cmd = db.prepareStatement("DELETE FROM Projekt WHERE id = ?");
            // Parameter setzen
            cmd.setInt(1, p.getId());
            // Ausf�hren
            Integer result = cmd.executeUpdate();

            // was deleted?
            if (result != null && result != 0) {
                // successful
                Logger.log(Level.INFO, DALDatabase.class, new InfoMessage("deleteProjekt"));
            }
            cmd.close();
            db.close();
            Binder.notify(Projekt.class);

        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

    @Override
    public Projekt getProjekt(Integer id) throws DALException {
        Projekt projekt = new Projekt();
// Datenbankverbindung öffnen
        Connection db;
        PreparedStatement cmd;
        ResultSet rd;
        try {
            db = DALDatabase.getConnection();
            cmd = db.prepareStatement("SELECT ID, ANGEBOT_ID, NAME, ABGESCHLOSSEN, VON, BIS FROM PROJEKT WHERE id = ?");
            cmd.setInt(1, id);
            rd = cmd.executeQuery();
            // Daten holen
            if (rd.next()) {
                projekt.setId(rd.getInt(1));
                projekt.setAngebot(this.getAngebot(rd.getInt(2)));
                projekt.setName(rd.getString(3));
                projekt.setIsAbgeschlossen(rd.getBoolean(4));
                projekt.setVon(new java.util.Date(rd.getDate(5).getTime()));
                projekt.setBis(new java.util.Date(rd.getDate(6).getTime()));
            }
            rd.close();
            cmd.close();
            db.close();
        } catch (SQLException ex) {
            throw new DALException(ex.getMessage());
        }
        return projekt;
    }

    @Override
    public Mitarbeiter getMitarbeiter(Integer id) throws DALException {
        Mitarbeiter mitarbeiter = new Mitarbeiter();
// Datenbankverbindung öffnen
        Connection db;
        PreparedStatement cmd;
        ResultSet rd;
        try {
            db = DALDatabase.getConnection();
            cmd = db.prepareStatement("SELECT ID, Vorname, Nachname, GeburtsDatum, StundenSatz FROM Mitarbeiter WHERE id = ?");
            cmd.setInt(1, id);
            rd = cmd.executeQuery();
            // Daten holen
            if (rd.next()) {
                mitarbeiter.setId(rd.getInt(1));
                mitarbeiter.setVorname(rd.getString(2));
                mitarbeiter.setNachname(rd.getString(3));
                mitarbeiter.setGeburtsdatum(new java.util.Date(rd.getDate(4).getTime()));
                mitarbeiter.setStundensatz(rd.getDouble(5));
            }
            rd.close();
            cmd.close();
            db.close();
        } catch (SQLException ex) {
            throw new DALException(ex.getMessage());
        }
        return mitarbeiter;
    }

    @Override
    public ArrayList<AbstractObject> getMitarbeiter() throws DALException {
        return getMitarbeiterListe();
    }

    @Override
    public ArrayList<AbstractObject> getMitarbeiterListe() throws DALException {
        ArrayList<AbstractObject> mitarbeiterListe = new ArrayList<AbstractObject>();
        // Datenbankverbindung �ffnen
        Connection db;
        PreparedStatement cmd;
        ResultSet rd;
        try {
            db = DALDatabase.getConnection();
            cmd = db.prepareStatement("SELECT ID, VORNAME, NACHNAME, STUNDENSATZ, GEBURTSDATUM FROM MITARBEITER");
            rd = cmd.executeQuery();
            // Daten holen
            while (rd.next()) {
                Mitarbeiter m = new Mitarbeiter();
                m.setId(rd.getInt(1));
                m.setVorname(rd.getString(2));
                m.setNachname(rd.getString(3));
                m.setStundensatz(rd.getDouble(4));
                m.setGeburtsdatum(new java.util.Date(rd.getDate(5).getTime()));
                mitarbeiterListe.add(m);
            }
            rd.close();
            cmd.close();
            db.close();
        } catch (SQLException ex) {
            throw new DALException(ex.getMessage());
        }
        return mitarbeiterListe;
    }

    @Override
    public ArrayList<AbstractObject> getProjektFromMitarbeiter(Integer id) throws DALException {
        ArrayList<AbstractObject> projekte = new ArrayList<AbstractObject>();
        // Datenbankverbindung �ffnen
        Connection db;
        PreparedStatement cmd;
        ResultSet rd;
        try {
            db = DALDatabase.getConnection();
            String prepare = "SELECT DISTINCT p.id, p.name, p.abgeschlossen, p.von, p.bis FROM "
                    + "mitarbeiter m inner join projekt_has_mitarbeiter phm on m.id = phm.mitarbeiter_id "
                    + "inner join projekt p on phm.projekt_id = p.id";
            if (id != 0) {
                prepare += " WHERE m.id = ?";
            }
            cmd = db.prepareStatement(prepare);
            if (id != 0) {
                cmd.setInt(1, id);
            }
            rd = cmd.executeQuery();
            // Daten holen
            while (rd.next()) {
                Projekt p = new Projekt();
                p.setId(rd.getInt(1));
                p.setName(rd.getString(2));
                p.setIsAbgeschlossen(rd.getBoolean(3));
                p.setVon(new java.util.Date(rd.getDate(4).getTime()));
                p.setBis(new java.util.Date(rd.getDate(5).getTime()));
                projekte.add(p);
            }
            rd.close();
            cmd.close();
            db.close();
        } catch (SQLException ex) {
            throw new DALException(ex.getMessage());
        }
        return projekte;
    }

    @Override
    public ArrayList<AbstractObject> getMitarbeiterFromProjekt(Integer id) throws DALException {
        ArrayList<AbstractObject> mitarbeiter = new ArrayList<AbstractObject>();
        // Datenbankverbindung �ffnen
        Connection db;
        PreparedStatement cmd;
        ResultSet rd;
        try {
            db = DALDatabase.getConnection();
            String prepare = "SELECT DISTINCT m.id, m.vorname, m.nachname, m.geburtsdatum, m.stundensatz FROM "
                    + "projekt p inner join projekt_has_mitarbeiter phm on p.id = phm.projekt_id "
                    + "inner join mitarbeiter m on phm.mitarbeiter_id = m.id";
            if (id != 0) {
                prepare += " WHERE p.id = ?";
            }
            cmd = db.prepareStatement(prepare);
            if (id != 0) {
                cmd.setInt(1, id);
            }
            rd = cmd.executeQuery();
            // Daten holen
            while (rd.next()) {
                Mitarbeiter m = new Mitarbeiter();
                m.setId(rd.getInt(1));
                m.setVorname(rd.getString(2));
                m.setNachname(rd.getString(3));
                m.setGeburtsdatum(new java.util.Date(rd.getDate(4).getTime()));
                m.setStundensatz(rd.getDouble(5));
                mitarbeiter.add(m);
            }
            rd.close();
            cmd.close();
            db.close();
        } catch (SQLException ex) {
            throw new DALException(ex.getMessage());
        }
        return mitarbeiter;
    }

    @Override
    public void addProjektToMitarbeiter(Projekt projekt, Mitarbeiter mitarbeiter) throws DALException {
        try {
            Connection db = DALDatabase.getConnection();

            // SQL STMT vorbereiten
            PreparedStatement cmdSelect = db.prepareStatement("SELECT COUNT(Mitarbeiter_ID) FROM Projekt_HAS_Mitarbeiter WHERE (Mitarbeiter_ID = ? AND Projekt_ID = ?) GROUP BY Mitarbeiter_ID");
            // Parameter setzen
            cmdSelect.setInt(1, mitarbeiter.getId());
            cmdSelect.setInt(2, projekt.getId());
            // Ausführen
            ResultSet rd = cmdSelect.executeQuery();
            // Update/Insert cmd
            PreparedStatement cmd;
            Integer result;
            if (!rd.next() || rd.getInt(1) == 0) {
                cmd = db.prepareStatement(
                        "INSERT INTO Projekt_has_Mitarbeiter (Mitarbeiter_ID, Projekt_ID) VALUES (?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
                cmd.setInt(1, mitarbeiter.getId());
                cmd.setInt(2, projekt.getId());
                result = cmd.executeUpdate();
                if (result != null) {
                    Logger.log(Level.INFO, DALDatabase.class, new InfoMessage("addProjektToMitarbeiter"));
                }
                /*cmd = db.prepareStatement("UPDATE Kontakt SET isKunde = ? WHERE id = ?", PreparedStatement.RETURN_GENERATED_KEYS);
                cmd.setBoolean(1, true);
                cmd.setInt(2, k.getId());
                result = cmd.executeUpdate();
                if (result != null) {
                Logger.log(Level.INFO, DALDatabase.class, new InfoMessage("addAngebotToKontakt"));
                }*/
            }
            Binder.notify(Mitarbeiter.class);
            Binder.notify(Projekt.class);
        } catch (SQLException ex) {
            throw new DALException(ex.getMessage());
        }
    }

    @Override
    public void deleteMitarbeiter(Mitarbeiter m) throws DALException {
        try {
            // Datenbankverbindung öffnen
            Connection db = DALDatabase.getConnection();

            // SQL STMT vorbereiten
            PreparedStatement cmd = db.prepareStatement("DELETE FROM MITARBEITER WHERE id = ?");
            // Parameter setzen
            cmd.setInt(1, m.getId());
            // Ausf�hren
            Integer result = cmd.executeUpdate();

            // was deleted?
            if (result != null && result != 0) {
                // successful
                Logger.log(Level.INFO, DALDatabase.class, new InfoMessage("deleteMitarbeiter"));
            }
            cmd.close();
            db.close();
            Binder.notify(Mitarbeiter.class);
        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

    @Override
    public void saveMitarbeiter(AbstractObject aO) throws DALException {
        if (!(aO instanceof Mitarbeiter)) {
            return;
        }
        Mitarbeiter m = (Mitarbeiter) aO;
        java.sql.Date gebDat = new java.sql.Date(m.getGeburtsdatum().getTime());
        try {
            // Datenbankverbindung öffnen
            Connection db = DALDatabase.getConnection();

            // SQL STMT vorbereiten
            PreparedStatement cmdSelect = db.prepareStatement("SELECT COUNT(id) FROM Mitarbeiter WHERE id = ? GROUP BY id");
            // Parameter setzen
            cmdSelect.setInt(1, m.getId());
            // Ausführen
            ResultSet rd = cmdSelect.executeQuery();
            // Update/Insert cmd
            PreparedStatement cmd;
            // Daten holen
            if (rd.next() && rd.getInt(1) == 1) {
                cmd = db.prepareStatement(
                        "UPDATE Mitarbeiter SET VORNAME = ?, NACHNAME = ?, STUNDENSATZ = ?, GEBURTSDATUM = ? WHERE id = ?",
                        PreparedStatement.RETURN_GENERATED_KEYS);
                cmd.setString(1, m.getVorname());
                cmd.setString(2, m.getNachname());
                cmd.setDouble(3, m.getStundensatz());
                cmd.setDate(4, gebDat);
                cmd.setInt(5, m.getId());
            } else {
                cmd = db.prepareStatement(
                        "INSERT INTO MITARBEITER (VORNAME, NACHNAME, STUNDENSATZ, GEBURTSDATUM) VALUES (?, ?, ?, ?)",
                        PreparedStatement.RETURN_GENERATED_KEYS);
                cmd.setString(1, m.getVorname());
                cmd.setString(2, m.getNachname());
                cmd.setDouble(3, m.getStundensatz());
                cmd.setDate(4, gebDat);
            }
            // execute insert/update
            Integer result = cmd.executeUpdate();
            // get generated id
            ResultSet generatedKeys = cmd.getGeneratedKeys();
            if (result != null && result != 0 && generatedKeys.next()) {
                m.setId(generatedKeys.getInt(1));
            }
            cmd.close();
            rd.close();
            cmdSelect.close();
            db.close();
            Logger.log(Level.INFO, DALDatabase.class, new InfoMessage("saveMitarbeiter"));
            Binder.notify(Projekt.class);
        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

    @Override
    public ArrayList<AbstractObject> getEingangsrechnungListe() throws DALException {
        ArrayList<AbstractObject> eRListe = new ArrayList<AbstractObject>();
        // Datenbankverbindung �ffnen
        Connection db;
        PreparedStatement cmd;
        ResultSet rd;
        try {
            db = DALDatabase.getConnection();
            String prepare = "SELECT DISTINCT E.ID, E.KONTAKT_ID, E.SCANPFAD, E.DATUM, E.PREIS "
                    + "FROM EINGANGSRECHNUNG E INNER JOIN RECHNUNG R ON E.ID = R.EINGANGSRECHNUNG_ID "
                    + "WHERE R.AUSGANGSRECHNUNGEN_ID = ?";

            cmd = db.prepareStatement(prepare);

            cmd.setNull(1, java.sql.Types.NULL);

            rd = cmd.executeQuery();
            // Daten holen
            while (rd.next()) {
                ERechnung eR = new ERechnung();
                eR.setId(rd.getInt(1));
                eR.setKontakt(this.getKontakt(rd.getInt(2)));
                eR.setScanPfad(rd.getString(3));
                eR.setDatum(new java.util.Date(rd.getDate(4).getTime()));
                eR.setPreis(rd.getDouble(5));
                eRListe.add(eR);
            }
            rd.close();
            cmd.close();
            db.close();
        } catch (SQLException ex) {
            throw new DALException(ex.getMessage());
        }
        return eRListe;
    }

    @Override
    public ERechnung getEingangsrechnung(Integer id) throws DALException {
        ERechnung eR = null;
        // Datenbankverbindung �ffnen
        Connection db;
        PreparedStatement cmd;
        ResultSet rd;
        try {
            db = DALDatabase.getConnection();
            cmd = db.prepareStatement("SELECT ID, KONTAKT_ID, SCANPFAD, DATUM, PREIS FROM AUSGANGSRECHNUNGEN WHERE id = ? ");
            cmd.setInt(1, id);
            rd = cmd.executeQuery();
            // Daten holen
            while (rd.next()) {
                Integer intResult = null;
                eR.setId(rd.getInt(1));
                eR.setKontakt(this.getKontakt(rd.getInt(2)));
                eR.setScanPfad(rd.getString(3));
                eR.setDatum(new java.util.Date(rd.getDate(4).getTime()));
                eR.setPreis(rd.getDouble(5));
            }
            rd.close();
            cmd.close();
            db.close();
        } catch (SQLException ex) {
            throw new DALException(ex.getMessage());
        }

        return eR;
    }

    @Override
    public void saveEingangsrechnung(AbstractObject eR) throws DALException {
        if (!(eR instanceof ERechnung)) {
            return;
        }
        ERechnung e = (ERechnung) eR;
        java.sql.Date datum = new java.sql.Date(e.getDatum().getTime());
        try {
            // Datenbankverbindung öffnen
            Connection db = DALDatabase.getConnection();

            // SQL STMT vorbereiten
            PreparedStatement cmdSelect = db.prepareStatement("SELECT COUNT(id) FROM EINGANGSRECHNUNG WHERE id = ? GROUP BY id");
            // Parameter setzen
            cmdSelect.setInt(1, e.getId());
            // Ausführen
            ResultSet rd = cmdSelect.executeQuery();
            // Update/Insert cmd
            PreparedStatement cmd;
            // Daten holen
            if (rd.next() && rd.getInt(1) == 1) {
                cmd = db.prepareStatement(
                        "UPDATE EINGANGSRECHNUNG SET KONTAKT_ID = ?, SCANPFAD = ?, DATUM = ?, PREIS = ? WHERE id = ?",
                        PreparedStatement.RETURN_GENERATED_KEYS);
                cmd.setInt(1, e.getKontakt().getId());
                cmd.setString(2, e.getScanPfad());
                cmd.setDate(3, datum);
                cmd.setDouble(4, e.getPreis());
                cmd.setInt(5, e.getId());


                // execute insert/update
                Integer result = cmd.executeUpdate();
                // get generated id
                ResultSet generatedKeys = cmd.getGeneratedKeys();
                if (result != null && result != 0 && generatedKeys.next()) {
                    e.setId(generatedKeys.getInt(1));
                    Logger.log(Level.INFO, DALDatabase.class, new InfoMessage("saveEingangsrechnung"));
                }
            } else {
                cmd = db.prepareStatement(
                        "INSERT INTO EINGANGSRECHNUNG (KONTAKT_ID, SCANPFAD, DATUM, PREIS) VALUES (?, ?, ?, ?)",
                        PreparedStatement.RETURN_GENERATED_KEYS);
                cmd.setInt(1, e.getKontakt().getId());
                cmd.setString(2, e.getScanPfad());
                cmd.setDate(3, datum);
                cmd.setDouble(4, e.getPreis());

                // execute insert/update
                Integer result = cmd.executeUpdate();
                // get generated id
                ResultSet generatedKeys = cmd.getGeneratedKeys();
                if (result != null && result != 0 && generatedKeys.next()) {
                    e.setId(generatedKeys.getInt(1));

                    cmd = db.prepareStatement(
                            "INSERT INTO RECHNUNG (AUSGANGSRECHNUNGEN_ID, EINGANGSRECHNUNG_ID, DATUM) VALUES (?, ?, ?)",
                            PreparedStatement.RETURN_GENERATED_KEYS);

                    cmd.setNull(1, java.sql.Types.NULL);
                    cmd.setInt(2, e.getId());
                    cmd.setDate(3, datum);

                    result = cmd.executeUpdate();
                    // get generated id
                    if (result != null && result != 0) {
                        Logger.log(Level.INFO, DALDatabase.class, new InfoMessage("saveEingangsrechnung"));
                    }
                }
            }

            cmd.close();
            rd.close();
            cmdSelect.close();
            db.close();

            Binder.notify(Projekt.class);
        } catch (SQLException ex) {
            throw new DALException(ex.getMessage());
        }
    }

    @Override
    public void deleteEingangsrechnung(ERechnung eR) throws DALException {
        try {
            // Datenbankverbindung öffnen
            Connection db = DALDatabase.getConnection();

            // SQL STMT vorbereiten
            PreparedStatement cmd = db.prepareStatement("DELETE FROM RECHNUNG WHERE EINGANGSRECHNUNG_ID = ? "
                    + " AND AUSGANGSRECHNUNGEN_ID = ?");
            // Parameter setzen
            cmd.setInt(1, eR.getId());
            cmd.setInt(2, java.sql.Types.NULL);
            // Ausf�hren
            Integer result = cmd.executeUpdate();

            // was deleted?
            if (result != null && result != 0) {
                // successful
                cmd = db.prepareStatement("DELETE FROM EINGANGSRECHNUNG WHERE ID = ?");
                cmd.setInt(1, eR.getId());
                result = cmd.executeUpdate();
                if (result != null && result != 0) {
                    Logger.log(Level.INFO, DALDatabase.class, new InfoMessage("deleteEingangsrechnung"));
                }
            }
            cmd.close();
            db.close();
            Binder.notify(Mitarbeiter.class);
        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

    @Override
    public ArrayList<AbstractObject> getAusgangsrechnungListe() throws DALException {
        ArrayList<AbstractObject> aRListe = new ArrayList<AbstractObject>();
        // Datenbankverbindung �ffnen
        Connection db;
        PreparedStatement cmd;
        ResultSet rd;
        try {
            db = DALDatabase.getConnection();
            String prepare = "SELECT DISTINCT A.ID, A.KONTAKT_ID, A.DATUM, A.PREIS "
                    + "FROM AUSGANGSRECHNUNGEN A INNER JOIN RECHNUNG R ON A.ID = R.AUSGANGSRECHNUNGEN_ID "
                    + "WHERE R.EINGANGSRECHNUNG_ID = ?";

            cmd = db.prepareStatement(prepare);

            cmd.setNull(1, java.sql.Types.NULL);

            rd = cmd.executeQuery();
            // Daten holen
            while (rd.next()) {
                ARechnung aR = new ARechnung();
                aR.setId(rd.getInt(1));
                aR.setKontakt(this.getKontakt(rd.getInt(2)));
                aR.setDatum(new java.util.Date(rd.getDate(3).getTime()));
                aR.setPreis(rd.getDouble(4));
                aRListe.add(aR);
            }
            rd.close();
            cmd.close();
            db.close();
        } catch (SQLException ex) {
            throw new DALException(ex.getMessage());
        }
        return aRListe;
    }

    @Override
    public ARechnung getAusgangsrechnung(Integer id) throws DALException {
        ARechnung aR = null;
        // Datenbankverbindung �ffnen
        Connection db;
        PreparedStatement cmd;
        ResultSet rd;
        try {
            db = DALDatabase.getConnection();
            cmd = db.prepareStatement("SELECT ID, KONTAKT_ID, DATUM, PREIS FROM AUSGANGSRECHNUNGEN WHERE id = ? ");
            cmd.setInt(1, id);
            rd = cmd.executeQuery();
            // Daten holen
            while (rd.next()) {
                Integer intResult = null;
                aR.setId(rd.getInt(1));
                aR.setKontakt(this.getKontakt(rd.getInt(2)));
                aR.setDatum(new java.util.Date(rd.getDate(3).getTime()));
                aR.setPreis(rd.getDouble(4));
            }
            rd.close();
            cmd.close();
            db.close();
        } catch (SQLException ex) {
            throw new DALException(ex.getMessage());
        }

        return aR;
    }

    @Override
    public void saveAusgangsrechnung(AbstractObject eR) throws DALException {
        if (!(eR instanceof ARechnung)) {
            return;
        }
        ARechnung a = (ARechnung) eR;
        java.sql.Date datum = new java.sql.Date(a.getDatum().getTime());
        try {
            // Datenbankverbindung öffnen
            Connection db = DALDatabase.getConnection();

            // SQL STMT vorbereiten
            PreparedStatement cmdSelect = db.prepareStatement("SELECT COUNT(id) FROM AUSGANGSRECHNUNGEN WHERE id = ? GROUP BY id");
            // Parameter setzen
            cmdSelect.setInt(1, a.getId());
            // Ausführen
            ResultSet rd = cmdSelect.executeQuery();
            // Update/Insert cmd
            PreparedStatement cmd;
            // Daten holen
            if (rd.next() && rd.getInt(1) == 1) {
                cmd = db.prepareStatement(
                        "UPDATE AUSGANGSRECHNUNGEN SET KONTAKT_ID = ?, DATUM = ?, PREIS = ? WHERE id = ?",
                        PreparedStatement.RETURN_GENERATED_KEYS);
                cmd.setInt(1, a.getKontakt().getId());
                cmd.setDate(2, datum);
                cmd.setDouble(3, a.getPreis());
                cmd.setInt(4, a.getId());


                // execute insert/update
                Integer result = cmd.executeUpdate();
                // get generated id
                ResultSet generatedKeys = cmd.getGeneratedKeys();
                if (result != null && result != 0 && generatedKeys.next()) {
                    a.setId(generatedKeys.getInt(1));
                    Logger.log(Level.INFO, DALDatabase.class, new InfoMessage("saveAusgangsrechnung"));
                }
            } else {
                cmd = db.prepareStatement(
                        "INSERT INTO AUSGANGSRECHNUNGEN (KONTAKT_ID, DATUM, PREIS) VALUES (?, ?, ?)",
                        PreparedStatement.RETURN_GENERATED_KEYS);
                cmd.setInt(1, a.getKontakt().getId());
                cmd.setDate(2, datum);
                cmd.setDouble(3, a.getPreis());

                // execute insert/update
                Integer result = cmd.executeUpdate();
                // get generated id
                ResultSet generatedKeys = cmd.getGeneratedKeys();
                if (result != null && result != 0 && generatedKeys.next()) {
                    a.setId(generatedKeys.getInt(1));

                    cmd = db.prepareStatement(
                            "INSERT INTO RECHNUNG (AUSGANGSRECHNUNGEN_ID, EINGANGSRECHNUNG_ID, DATUM) VALUES (?, ?, ?)",
                            PreparedStatement.RETURN_GENERATED_KEYS);

                    
                    cmd.setInt(1, a.getId());
                    cmd.setNull(2, java.sql.Types.NULL);
                    cmd.setDate(3, datum);

                    result = cmd.executeUpdate();
                    // get generated id
                    if (result != null && result != 0) {
                        Logger.log(Level.INFO, DALDatabase.class, new InfoMessage("saveAusgangsrechnung"));
                    }
                }
            }

            cmd.close();
            rd.close();
            cmdSelect.close();
            db.close();

            Binder.notify(Projekt.class);
        } catch (SQLException ex) {
            throw new DALException(ex.getMessage());
        }
    }

    @Override
    public void deleteAusgangsrechnung(ARechnung aR) throws DALException {
        try {
            // Datenbankverbindung öffnen
            Connection db = DALDatabase.getConnection();

            // SQL STMT vorbereiten
            PreparedStatement cmd = db.prepareStatement("DELETE FROM RECHNUNG WHERE AUSGANGSRECHNUNGEN_ID = ? "
                    + " AND EINGANGSRECHNUNG_ID = ?");
            // Parameter setzen
            cmd.setInt(1, aR.getId());
            cmd.setInt(2, java.sql.Types.NULL);
            // Ausf�hren
            Integer result = cmd.executeUpdate();

            // was deleted?
            if (result != null && result != 0) {
                // successful
                cmd = db.prepareStatement("DELETE FROM AUSGANGSRECHNUNGEN WHERE ID = ?");
                cmd.setInt(1, aR.getId());
                result = cmd.executeUpdate();
                if (result != null && result != 0) {
                    Logger.log(Level.INFO, DALDatabase.class, new InfoMessage("deleteAusgangsrechnung"));
                }
            }
            cmd.close();
            db.close();
            Binder.notify(Mitarbeiter.class);
        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

    @Override
    public ArrayList<AbstractObject> getKategorieListe() throws DALException {
        ArrayList<AbstractObject> kategorieListe = new ArrayList<AbstractObject>();
        // Datenbankverbindung �ffnen
        Connection db;
        PreparedStatement cmd;
        ResultSet rd;
        String[] kategorien = {"Ausgabe", "Einnahme", "Steuer", "SVA"};
        try {
            db = DALDatabase.getConnection();
            cmd = db.prepareStatement("SELECT id, bezeichnung FROM kategorie");
            rd = cmd.executeQuery();
            // Daten holen
            if (rd.wasNull()) {
                for (int i = 0; i < kategorien.length; i++) {
                    Kategorie k = new Kategorie();
                    cmd = db.prepareStatement("INSERT INTO KATEGORIE (BEZEICHNUNG) VALUES (?)", PreparedStatement.RETURN_GENERATED_KEYS);
                    cmd.setString(1, kategorien[i]);
                    k.setBezeichnung(kategorien[i]);
                    Integer result = cmd.executeUpdate();
                    // get generated id
                    ResultSet generatedKeys = cmd.getGeneratedKeys();
                    if (result != null && result != 0 && generatedKeys.next()) {
                        k.setId(generatedKeys.getInt(1));
                        kategorieListe.add(k);
                    }
                }
            } else {
                while (rd.next()) {
                    Kategorie k = new Kategorie();
                    k.setId(rd.getInt(1));
                    k.setBezeichnung(rd.getString(2));
                    kategorieListe.add(k);
                }
            }
            rd.close();
            cmd.close();
            db.close();
        } catch (SQLException ex) {
            throw new DALException(ex.getMessage());
        }
        return kategorieListe;
    }

    @Override
    public Kategorie getKategorie(Integer id) throws DALException {
        Kategorie kategorie = new Kategorie();
// Datenbankverbindung �ffnen
        Connection db;
        PreparedStatement cmd;
        ResultSet rd;
        try {
            db = DALDatabase.getConnection();
            cmd = db.prepareStatement("SELECT id, bezeichnung FROM kategorie WHERE id = ?");
            cmd.setInt(1, id);
            rd = cmd.executeQuery();
            // Daten holen
            if (rd.next()) {
                kategorie.setId(rd.getInt(1));
                kategorie.setBezeichnung(rd.getString(2));
            }
            rd.close();
            cmd.close();
            db.close();
        } catch (SQLException ex) {
            throw new DALException(ex.getMessage());
        }
        return kategorie;
    }

    @Override
    public ArrayList<AbstractObject> getAngebotFromKontakt() throws DALException {
        return getAngebotListe();
    }

    @Override
    public ArrayList<AbstractObject> getAngebotFromKontakt(Integer id) throws DALException {
        ArrayList<AbstractObject> angebote = new ArrayList<AbstractObject>();
        // Datenbankverbindung �ffnen
        Connection db;
        PreparedStatement cmd;
        ResultSet rd;
        try {
            db = DALDatabase.getConnection();
            String prepare = "SELECT DISTINCT a.id, a.name, a.beschreibung, a.GueltigAb, a.GueltigBis, a.Preis, a.Dauer, a.Chance, a.AenderungsDatum FROM "
                    + "kontakt k inner join kontakt_has_angebot kha on k.id = kha.kontakt_id " + ""
                    + "inner join angebot a on kha.angebot_id = a.id";
            if (id != 0) {
                prepare += " WHERE k.id = ?";
            }
            cmd = db.prepareStatement(prepare);
            if (id != 0) {
                cmd.setInt(1, id);
            }
            rd = cmd.executeQuery();
            // Daten holen
            while (rd.next()) {
                Angebot a = new Angebot();
                a.setId(rd.getInt(1));
                a.setName(rd.getString(2));
                a.setBeschreibung(rd.getString(3));
                a.setGueltigAb(new java.util.Date(rd.getDate(4).getTime()));
                a.setGueltigBis(new java.util.Date(rd.getDate(5).getTime()));
                a.setPreis(rd.getDouble(6));
                a.setDauer(rd.getInt(7));
                a.setChance(rd.getInt(8));
                a.setAenderungsDatum(new java.util.Date(rd.getDate(9).getTime()));
                angebote.add(a);
            }
            rd.close();
            cmd.close();
            db.close();
        } catch (SQLException ex) {
            throw new DALException(ex.getMessage());
        }
        return angebote;
    }

    @Override
    public Integer getProjektStundenGesamt(Integer pId) throws DALException {
        Integer summe = null;
        Connection db;
        PreparedStatement cmd;
        ResultSet rd;
        try {

            db = DALDatabase.getConnection();
            cmd = db.prepareStatement("SELECT SUM(STUNDEN) FROM ARBEITSSTUNDEN WHERE PROJEKT_ID = ? GROUP BY PROJEKT_ID");
            cmd.setInt(1, pId);
            rd = cmd.executeQuery();
            if (rd.next()) {
                summe = (Integer) rd.getInt(1);
            }
            rd.close();
            cmd.close();
            db.close();
        } catch (SQLException ex) {
            throw new DALException(ex.getMessage());
        }

        return summe;
    }

    @Override
    public void saveArbeitsstunden(ArrayList<Arbeitsstunden> logListe) throws DALException {
        for (Arbeitsstunden log : logListe) {
            this.saveArbeitsstunden(log);
        }
    }

    @Override
    public void saveArbeitsstunden(AbstractObject oa) throws DALException {
        Arbeitsstunden log;
        if (!(oa instanceof Arbeitsstunden)) {
            throw new DALException("Übergabeobjekt nicht vom Typ 'Arbeitsstunden'");
        } else {
            log = (Arbeitsstunden) oa;
        }

        Connection db;
        PreparedStatement cmd;
        ResultSet rd;

        java.sql.Date datum = new java.sql.Date(log.getDatum().getTime());
        try {
            db = DALDatabase.getConnection();

            PreparedStatement cmdSelect = db.prepareStatement("SELECT COUNT(Projekt_id) FROM ARBEITSSTUNDEN WHERE ID = ? GROUP BY PROJEKT_ID");
            // Parameter setzen
            cmdSelect.setInt(1, log.getId());/*
            cmdSelect.setInt(1, log.getProjekt().getId());
            cmdSelect.setInt(2, log.getMitarbeiter().getId());
            cmdSelect.setDate(3, datum);
            cmdSelect.setInt(4, log.getStunden());
            cmdSelect.setString(5, log.getTaetigkeit());
            cmdSelect.setInt(6, log.getId());*/
            // Ausführen
            rd = cmdSelect.executeQuery();
            // Update/Insert cmd

            // Daten holen
            if (rd.next() && rd.getInt(1) == 1) {
                cmd = db.prepareStatement(
                        "UPDATE ARBEITSSTUNDEN SET PROJEKT_ID = ?, MITARBEITER_ID = ?, DATUM = ?,"
                        + "STUNDEN = ?, TAETIGKEIT = ? WHERE ID = ?", PreparedStatement.RETURN_GENERATED_KEYS);
                cmd.setInt(1, log.getProjekt().getId());
                cmd.setInt(2, log.getMitarbeiter().getId());
                cmd.setDate(3, datum);
                cmd.setInt(4, log.getStunden());
                cmd.setString(5, log.getTaetigkeit());
                cmd.setInt(6, log.getId());
            } else {

                cmd = db.prepareStatement("INSERT INTO ARBEITSSTUNDEN (PROJEKT_ID, MITARBEITER_ID, DATUM, STUNDEN, TAETIGKEIT) VALUES (?, ?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
                cmd.setInt(1, log.getProjekt().getId());
                cmd.setInt(2, log.getMitarbeiter().getId());
                cmd.setDate(3, datum);
                cmd.setInt(4, log.getStunden());
                cmd.setString(5, log.getTaetigkeit());
            }

            // execute insert/update
            Integer result = cmd.executeUpdate();
            ResultSet generatedKeys = cmd.getGeneratedKeys();
            if (result != null && result != 0 && generatedKeys.next()) {
                log.setId(generatedKeys.getInt(1));
                Logger.log(Level.INFO, DALDatabase.class, new InfoMessage("saveProjekt"));
            }
            cmd.close();
            rd.close();
            cmdSelect.close();
            db.close();

            Binder.notify(Projekt.class);
            Binder.notify(Arbeitsstunden.class);
            Binder.notify(Mitarbeiter.class);
        } catch (SQLException ex) {
            throw new DALException(ex.getMessage());
        }
    }

    @Override
    public void deleteArbeitsstunden(Arbeitsstunden log) throws DALException {
        try {
            // Datenbankverbindung öffnen
            Connection db = DALDatabase.getConnection();

            // SQL STMT vorbereiten
            PreparedStatement cmd = db.prepareStatement("DELETE FROM Arbeitsstunden WHERE id = ?");
            // Parameter setzen
            cmd.setInt(1, log.getId());
            // Ausf�hren
            Integer result = cmd.executeUpdate();

            // was deleted?
            if (result != null && result != 0) {
                // successful
                Logger.log(Level.INFO, DALDatabase.class, new InfoMessage("deleteErfassung"));
            }
            cmd.close();
            db.close();
            Binder.notify(Arbeitsstunden.class);
            Binder.notify(Mitarbeiter.class);
            Binder.notify(Projekt.class);

        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

    @Override
    public ArrayList<AbstractObject> getArbeitsstundenListe() throws DALException {
        ArrayList<AbstractObject> logListe = new ArrayList<AbstractObject>();
        // Datenbankverbindung �ffnen
        Connection db;
        PreparedStatement cmd;
        ResultSet rd;
        try {
            db = DALDatabase.getConnection();
            cmd = db.prepareStatement("SELECT id, PROJEKT_ID, MITARBEITER_ID, DATUM, STUNDEN, TAETIGKEIT "
                    + "FROM ARBEITSSTUNDEN");
            rd = cmd.executeQuery();
            // Daten holen
            while (rd.next()) {
                Arbeitsstunden log = new Arbeitsstunden();
                log.setId(rd.getInt(1));
                log.setProjekt(this.getProjekt(rd.getInt(2)));
                log.setMitarbeiter(this.getMitarbeiter(rd.getInt(3)));
                log.setDatum(new java.util.Date(rd.getDate(4).getTime()));
                log.setStunden(rd.getInt(5));
                log.setTaetigkeit(rd.getString(6));
                logListe.add(log);
            }
            rd.close();
            cmd.close();
            db.close();
        } catch (SQLException ex) {
            throw new DALException(ex.getMessage());
        }
        return logListe;
    }
}
