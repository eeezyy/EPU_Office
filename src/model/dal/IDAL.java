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

    public void saveKontakt(AbstractObject k) throws DALException;

    public void deleteKontakt(Kontakt k) throws DALException;

    public ArrayList<Kontakt> getKontaktListe() throws DALException;

    public Kontakt getKontakt(int id) throws DALException;

    public ArrayList<Kontakt> getKundenListe() throws DALException;

    public void addAngebotToKontakt(Kontakt k, Angebot a);

    public void saveAngebot(AbstractObject a) throws DALException;

    public void deleteAngebot(Angebot a) throws DALException;

    public Angebot getAngebot(int id) throws DALException;

    public ArrayList<Angebot> getAngebotListe() throws DALException;

    public ArrayList<Projekt> getProjektListe() throws DALException;

    public void saveProjekt(AbstractObject p) throws DALException;

    public void deleteProjekt(Projekt p) throws DALException;

    public Projekt getProjekt(int id) throws DALException;

    public Mitarbeiter getMitarbeiter(int id) throws DALException;

    public ArrayList<Mitarbeiter> getMitarbeiterListe() throws DALException;

    public void addMitarbeiterToProjekt(Mitarbeiter m, Projekt p) throws DALException;

    public void deleteMitarbeiter(Mitarbeiter m) throws DALException;

    public void saveMitarbeiter(AbstractObject m) throws DALException;

    public ArrayList<EingangsRechnung> getEingangsrechnungListe() throws DALException;

    public EingangsRechnung getEingangsrechnung(int id) throws DALException;

    public void saveEingangsrechnung(AbstractObject eR) throws DALException;

    public void deleteEingangsrechnung(EingangsRechnung eR) throws DALException;

    public ArrayList<AusgangsRechnung> getAusgangsrechnungListe() throws DALException;

    public AusgangsRechnung getAusgangsrechnung(int id) throws DALException;

    public void saveAusgangsrechnung(AbstractObject eR) throws DALException;

    public void deleteAusgangsrechnung(AusgangsRechnung aR) throws DALException;
    
    public ArrayList<Kategorie> getKategorieListe() throws DALException;
    
    public Kategorie getKategorie(int id) throws DALException;
    
    
    
}
