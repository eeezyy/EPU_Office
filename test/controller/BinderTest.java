/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.*;
import java.util.Date;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MAS
 */
public class BinderTest {
    
    ArrayList<BinderProperty> list;
    
    public BinderTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    /**
     * Binder create Kontakt Object.
     */
    @Test
    public void binderTestCreateKontakt() throws InstantiationException, IllegalAccessException {
        list.add(new BinderProperty("Vorname", "Test", String.class));
        list.add(new BinderProperty("Nachname", "TestNachname", String.class));
        list.add(new BinderProperty("Firmenname", "TestFirma", String.class));
        list.add(new BinderProperty("Strasse", "STr", String.class));
        list.add(new BinderProperty("Hausnr", "123", Integer.class));
        list.add(new BinderProperty("Plz", "1234", Integer.class));
        list.add(new BinderProperty("Ort", "HierundDa", String.class));
        list.add(new BinderProperty("Email", "test@mail.com", String.class));
        list.add(new BinderProperty("Telefon", "123", String.class));
        list.add(new BinderProperty("Konto", "123", Long.class));
        list.add(new BinderProperty("Blz", "123", Integer.class));
        list.add(new BinderProperty("Bankinstitut", "123", String.class));
        list.add(new BinderProperty("IsKunde", "123", Boolean.class));
        Object created = Binder.createObject(Kontakt.class, list);
        assertTrue(created instanceof Kontakt);
    }
    
    /**
     * Binder create Projekt Object.
     * Besonderheit: Angebot (benötigt Datenbank, ID muss vorhanden sein).
     */
    @Test
    public void binderTestCreateProjekt() throws InstantiationException, IllegalAccessException {
        list.add(new BinderProperty("Name", "Test", String.class));
        list.add(new BinderProperty("Angebot", "1", Angebot.class));
        list.add(new BinderProperty("IsAbgeschlossen", "true", Boolean.class));
        list.add(new BinderProperty("Von", "1.1.2000", Date.class));
        list.add(new BinderProperty("Bis", "2.1.2000", Date.class));
        Object created = Binder.createObject(Projekt.class, list);
        assertTrue(created instanceof Projekt);
    }
    
    
    /**
     * Binder create Mitarbeiter Object.
     */
    @Test
    public void binderTestCreateMitarbeiter() throws InstantiationException, IllegalAccessException {
        list.add(new BinderProperty("Vorname", "Test", String.class));
        list.add(new BinderProperty("Nachname", "Name", String.class));
        list.add(new BinderProperty("Stundensatz", "10.50", Double.class));
        list.add(new BinderProperty("Geburtsdatum", "1.1.2000", Date.class));
        Object created = Binder.createObject(Mitarbeiter.class, list);
        assertTrue(created instanceof Mitarbeiter);
    }
    
    /**
     * Binder create Kategorie Object.
     */
    @Test
    public void binderTestCreateKategorie() throws InstantiationException, IllegalAccessException {
        list.add(new BinderProperty("Bezeichnung", "Test", String.class));
        Object created = Binder.createObject(Kategorie.class, list);
        assertTrue(created instanceof Kategorie);
    }
    
    /**
     * Binder create ERechnung Object.
     */
    @Test
    public void binderTestCreateERechnung() throws InstantiationException, IllegalAccessException {
        list.add(new BinderProperty("Kontakt", "1", Kontakt.class));
        list.add(new BinderProperty("ScanPfad", "C:/Pfad", String.class));
        list.add(new BinderProperty("Datum", "1.1.2000", Date.class));
        list.add(new BinderProperty("Preis", "1.50", Double.class));
        Object created = Binder.createObject(ERechnung.class, list);
        assertTrue(created instanceof ERechnung);
    }
    
    /**
     * Binder create Arbeitsstunden Object.
     * Besonderheit: Projekt, Mitarbeiter (benötigen Datenbank, IDs muss vorhanden sein).
     */
    @Test
    public void binderTestCreateArbeitsstunden() throws InstantiationException, IllegalAccessException {
        list.add(new BinderProperty("Projekt", "1", Projekt.class));
        list.add(new BinderProperty("Mitarbeiter", "1", Mitarbeiter.class));
        list.add(new BinderProperty("Datum", "1.1.2000", Date.class));
        list.add(new BinderProperty("Stunden", "15", Integer.class));
        list.add(new BinderProperty("Stunden", "15", Integer.class));
        list.add(new BinderProperty("Taetigkeit", "TätigkeitTätigkeit", String.class));
        Object created = Binder.createObject(Arbeitsstunden.class, list);
        assertTrue(created instanceof Arbeitsstunden);
    }
        
    /**
     * Binder create Angebot Object.
     */
    @Test
    public void binderTestCreateAngebot() throws InstantiationException, IllegalAccessException {
        list.add(new BinderProperty("Name", "angebotName", String.class));
        list.add(new BinderProperty("GueltigAb", "1.1.2000", Date.class));
        list.add(new BinderProperty("GueltigBis", "1.1.2001", Date.class));
        list.add(new BinderProperty("Preis", "1.5", Double.class));
        list.add(new BinderProperty("Dauer", "15", Integer.class));
        list.add(new BinderProperty("Chance", "99", Integer.class));
        list.add(new BinderProperty("Beschreibung", "Beschreibung.....", String.class));
        list.add(new BinderProperty("AenderungsDatum", "1.1.2000", Date.class));
        Object created = Binder.createObject(Angebot.class, list);
        assertTrue(created instanceof Angebot);
    }
    
    /**
     * Binder create ARechnung Object.
     * Besonderheit: Kontakt (benötigt Datenbank, ID muss vorhanden sein).
     */
    @Test
    public void binderTestCreateARechnung() throws InstantiationException, IllegalAccessException {
        list.add(new BinderProperty("Kontakt", "1", Kontakt.class));
        list.add(new BinderProperty("Datum", "1.1.2000", Date.class));
        list.add(new BinderProperty("Preis", "1.5", Double.class));
        Object created = Binder.createObject(ARechnung.class, list);
        assertTrue(created instanceof ARechnung);
    }
    
    @Before
    public void setUp() {
        list = new ArrayList<BinderProperty>();
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
