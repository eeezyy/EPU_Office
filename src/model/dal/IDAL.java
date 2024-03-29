/**
 * 
 */
package model.dal;

import java.util.ArrayList;
import model.*;

/**
 * @author Alex
 *
 */
public interface IDAL {

    public void initialize() throws DALException;

    public void saveKontakt(AbstractObject aO) throws DALException;

    public void deleteKontakt(Kontakt k) throws DALException;

    public ArrayList<AbstractObject> getKontaktListe() throws DALException;

    public Kontakt getKontakt(Integer id) throws DALException;

    public ArrayList<AbstractObject> getKundenListe() throws DALException;

    public void addAngebotToKontakt(Kontakt k, Angebot a) throws DALException;

    public void saveAngebot(AbstractObject aO) throws DALException;

    public void deleteAngebot(Angebot a) throws DALException;

    public Angebot getAngebot(Integer id) throws DALException;
    
    public ArrayList<AbstractObject> getAngebot() throws DALException;

    public ArrayList<AbstractObject> getAngebotListe() throws DALException;

    public ArrayList<AbstractObject> getAngebotFromKontakt() throws DALException;
    
    public ArrayList<AbstractObject> getAngebotFromKontakt(Integer id) throws DALException;

    public ArrayList<AbstractObject> getProjekt() throws DALException;
    
    public ArrayList<AbstractObject> getProjektListe() throws DALException;

    public void saveProjekt(AbstractObject aO) throws DALException;

    public void deleteProjekt(Projekt p) throws DALException;

    public Projekt getProjekt(Integer id) throws DALException;

    public Mitarbeiter getMitarbeiter(Integer id) throws DALException;
    
    public ArrayList<AbstractObject> getMitarbeiter() throws DALException;

    public ArrayList<AbstractObject> getMitarbeiterListe() throws DALException;

    public ArrayList<AbstractObject> getProjektFromMitarbeiter(Integer id) throws DALException;
    
    public ArrayList<AbstractObject> getMitarbeiterFromProjekt(Integer id) throws DALException;
    
    public void addProjektToMitarbeiter(Projekt projekt, Mitarbeiter mitarbeiter) throws DALException;

    public void deleteMitarbeiter(Mitarbeiter m) throws DALException;

    public void saveMitarbeiter(AbstractObject aO) throws DALException;

    public ArrayList<AbstractObject> getEingangsrechnungListe() throws DALException;
    
    public ArrayList<AbstractObject> getOffeneEingangsrechnungListe() throws DALException;

    public ERechnung getEingangsrechnung(Integer id) throws DALException;

    public void saveEingangsrechnung(AbstractObject aO) throws DALException;

    public void deleteEingangsrechnung(ERechnung eR) throws DALException;

    public ArrayList<AbstractObject> getAusgangsrechnungListe() throws DALException;
    
    public ArrayList<AbstractObject> getOffeneAusgangsrechnungListe() throws DALException;

    public ARechnung getAusgangsrechnung(Integer id) throws DALException;

    public void saveAusgangsrechnung(AbstractObject aO) throws DALException;

    public void deleteAusgangsrechnung(ARechnung aR) throws DALException;

    public ArrayList<AbstractObject> getKategorieListe() throws DALException;

    public Kategorie getKategorie(Integer id) throws DALException;
    
    public Integer getProjektStundenGesamt(Integer pId) throws DALException;
    
    public void saveArbeitsstunden(ArrayList<Arbeitsstunden> logListe) throws DALException;
    
    public void saveArbeitsstunden(AbstractObject oa) throws DALException;
    
    public void deleteArbeitsstunden(Arbeitsstunden log) throws DALException;
    
    public ArrayList<AbstractObject>getArbeitsstundenListe() throws DALException;

    public void addRechnungToBuchungszeile(Integer rechnung_id, Integer kategorien_id, Double betrag, Integer buchungszeile_id) throws DALException;
    
    public Buchungszeile saveBuchungszeile(Buchungszeile b) throws DALException;
    
    public ArrayList<AbstractObject> getBuchungszeilenList() throws DALException;
    
    public ArrayList<AbstractObject> getBuchungszeilenEingangList() throws DALException;
    
    public Rechnung saveRechnung(AbstractObject aO) throws DALException;
    
    public ArrayList<AbstractObject> getBuchungszeilenAusgangList() throws DALException;
}
