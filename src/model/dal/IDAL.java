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

    public ArrayList<AbstractObject> getAngebotListe() throws DALException;

    public ArrayList<AbstractObject> getAngebotFromKontakt() throws DALException;
    
    public ArrayList<AbstractObject> getAngebotFromKontakt(Integer id) throws DALException;

    public ArrayList<AbstractObject> getProjektListe() throws DALException;

    public void saveProjekt(AbstractObject aO) throws DALException;

    public void deleteProjekt(Projekt p) throws DALException;

    public Projekt getProjekt(Integer id) throws DALException;

    public Mitarbeiter getMitarbeiter(Integer id) throws DALException;

    public ArrayList<AbstractObject> getMitarbeiterListe() throws DALException;

    public void addMitarbeiterToProjekt(Integer p, Integer m) throws DALException;

    public void deleteMitarbeiter(Mitarbeiter m) throws DALException;

    public void saveMitarbeiter(AbstractObject aO) throws DALException;

    public ArrayList<AbstractObject> getEingangsrechnungListe() throws DALException;

    public EingangsRechnung getEingangsrechnung(Integer id) throws DALException;

    public void saveEingangsrechnung(AbstractObject aO) throws DALException;

    public void deleteEingangsrechnung(EingangsRechnung eR) throws DALException;

    public ArrayList<AbstractObject> getAusgangsrechnungListe() throws DALException;

    public AusgangsRechnung getAusgangsrechnung(Integer id) throws DALException;

    public void saveAusgangsrechnung(AbstractObject aO) throws DALException;

    public void deleteAusgangsrechnung(AusgangsRechnung aR) throws DALException;

    public ArrayList<AbstractObject> getKategorieListe() throws DALException;

    public Kategorie getKategorie(Integer id) throws DALException;
    
    public Integer getProjektStundenGesamt(Integer pId) throws DALException;
    
    public void saveZeitErfassung(ArrayList<ZeitErfassung> logListe) throws DALException;
    
    public void saveZeitErfassung(ZeitErfassung log) throws DALException;
}
