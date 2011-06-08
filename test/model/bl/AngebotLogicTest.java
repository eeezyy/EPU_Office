/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bl;

import controller.BinderProperty;
import java.util.ArrayList;
import java.util.Date;
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
public class AngebotLogicTest {

    static ArrayList<BinderProperty> checklist;
    static AngebotLogic logic;

    /**
     * AngebotLogic.
     * 
     * Testen der Business-Logik.
     * funktion <ModelName>Logic.check(BinderProperty)
     * BinderProperty(PropertyName, PropertyValue, ValueClass)
     * ValueClass hat keine Auswirkung auf die Business-Logik.
     */
    public AngebotLogicTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Id mit Wert 0.
     * Gültig.
     */
    @Test
    public void testIsValidId0() {
        ArrayList<String> errorList;
        checklist.add(new BinderProperty("Id", "0", Integer.class));
        errorList = logic.check(checklist);
        assertTrue(errorList.isEmpty());
    }

    /**
     * Id mit Wert 1.
     * Gültig.
     */
    @Test
    public void testIsValidId1() {
        ArrayList<String> errorList;
        checklist.add(new BinderProperty("Id", "1", Integer.class));
        errorList = logic.check(checklist);
        assertTrue(errorList.isEmpty());
    }

    /**
     * Id mit Wert null.
     * Gültig.
     */
    @Test
    public void testIsValidIdIsNull() {
        ArrayList<String> errorList;
        checklist.add(new BinderProperty("Id", null, Integer.class));
        errorList = logic.check(checklist);
        assertTrue(errorList.isEmpty());
    }

    /**
     * Angebot_Id mit Wert null.
     * Ungültig.
     */
    @Test
    public void testIsValidAngebot_IdNull() {
        ArrayList<String> errorList;
        checklist.add(new BinderProperty("Angebot_Id", null, Integer.class));
        errorList = logic.check(checklist);
        assertFalse(errorList.isEmpty());
        assertEquals(errorList.size(), 1);
        assertEquals(errorList.get(0), "Angebot_Id");
    }
    
    /**
     * Angebot_Id mit Wert 0.
     * Ungültig.
     */
    @Test
    public void testIsValidAngebot_Id0() {
        ArrayList<String> errorList;
        checklist.add(new BinderProperty("Angebot_Id", "0", Integer.class));
        errorList = logic.check(checklist);
        assertFalse(errorList.isEmpty());
        assertEquals(errorList.size(), 1);
        assertEquals(errorList.get(0), "Angebot_Id");
    }
    
    /**
     * Angebot_Id mit Wert 1.
     * Gültig.
     */
    @Test
    public void testIsValidAngebot_Id1() {
        ArrayList<String> errorList;
        checklist.add(new BinderProperty("Angebot_Id", "1", Integer.class));
        errorList = logic.check(checklist);
        assertTrue(errorList.isEmpty());
    }
    
    /**
     * GueltigAb mit korrektem Datum. Ohne GültigBis.
     * Gültig.
     */
    @Test
    public void testIsValidGueltigAb() {
        ArrayList<String> errorList;
        checklist.add(new BinderProperty("GueltigAb", "1.1.1980", Date.class));
        errorList = logic.check(checklist);
        assertTrue(errorList.isEmpty());
    }
    
    /**
     * GültigBis mit korrektem Datum. Ohne GültigAb.
     * Gültig.
     */
    @Test
    public void testIsValidGueltigBis() {
        ArrayList<String> errorList;
        checklist.add(new BinderProperty("GueltigBis", "1.1.1980", Date.class));
        errorList = logic.check(checklist);
        assertTrue(errorList.isEmpty());
    }
    
    /**
     * GültigAb und GültigBis mit gleichem Datum.
     * Ungültig.
     */
    @Test
    public void testIsValidGueltigAbBisSame() {
        ArrayList<String> errorList;
        checklist.add(new BinderProperty("GueltigAb", "1.1.1980", Date.class));
        checklist.add(new BinderProperty("GueltigBis", "1.1.1980", Date.class));
        errorList = logic.check(checklist);
        assertFalse(errorList.isEmpty());
        assertEquals(errorList.size(), 1);
        assertEquals(errorList.get(0), "GueltigBis");
    }
    
    /**
     * GültigAb und GültigBis mit gleichem Datum. In verkehrter Reihenfolge befüllt.
     * Ungültig.
     */
    @Test
    public void testIsValidGueltigBisAbSame() {
        ArrayList<String> errorList;
        checklist.add(new BinderProperty("GueltigBis", "1.1.1980", Date.class));
        checklist.add(new BinderProperty("GueltigAb", "1.1.1980", Date.class));
        errorList = logic.check(checklist);
        assertFalse(errorList.isEmpty());
        assertEquals(errorList.size(), 1);
        assertEquals(errorList.get(0), "GueltigAb");
    }
    
    /**
     * GültigAb kleiner als GültigBis.
     * Gültig.
     */
    @Test
    public void testIsValidGueltigAbSmallerBis() {
        ArrayList<String> errorList;
        checklist.add(new BinderProperty("GueltigAb", "1.1.1980", Date.class));
        checklist.add(new BinderProperty("GueltigBis", "2.1.1980", Date.class));
        errorList = logic.check(checklist);
        assertTrue(errorList.isEmpty());
    }
    
    /**
     * GültigAb kleiner als GültigBis. In verkehrter Reihenfolge befühlt.
     * Gültig.
     */
    @Test
    public void testIsValidGueltigBisAbSmaller() {
        ArrayList<String> errorList;
        checklist.add(new BinderProperty("GueltigAb", "1.1.1980", Date.class));
        checklist.add(new BinderProperty("GueltigBis", "2.1.1980", Date.class));
        errorList = logic.check(checklist);
        assertTrue(errorList.isEmpty());
    }
    
    /**
     * GültigAb größer als GültigBis.
     * Ungültig.
     */
    @Test
    public void testIsValidGueltigAbBiggerBis() {
        ArrayList<String> errorList;
        checklist.add(new BinderProperty("GueltigAb", "2.1.1980", Date.class));
        checklist.add(new BinderProperty("GueltigBis", "1.1.1980", Date.class));
        errorList = logic.check(checklist);
        assertFalse(errorList.isEmpty());
        assertEquals(errorList.size(), 1);
        assertEquals(errorList.get(0), "GueltigBis");
    }
    
    /**
     * GültigAb größer als GültigBis. In verkehrter Reihenfolge befüllt.
     * Ungültig.
     */
    @Test
    public void testIsValidGueltigBisAbBigger() {
        ArrayList<String> errorList;
        checklist.add(new BinderProperty("GueltigBis", "1.1.1980", Date.class));
        checklist.add(new BinderProperty("GueltigAb", "2.1.1980", Date.class));
        errorList = logic.check(checklist);
        assertFalse(errorList.isEmpty());
        assertEquals(errorList.size(), 1);
        assertEquals(errorList.get(0), "GueltigAb");
    }
    
    /**
     * GültigAb ungültig GültigBis gültig. In verkehrter Reihenfolge befüllt.
     * errorList Inhalt: "GueltigAb"
     * Ungültig.
     */
    @Test
    public void testIsValidGueltigAbUngueltigBis() {
        ArrayList<String> errorList;
        checklist.add(new BinderProperty("GueltigBis", "1.1.1980", Date.class));
        checklist.add(new BinderProperty("GueltigAb", "", Date.class));
        errorList = logic.check(checklist);
        assertFalse(errorList.isEmpty());
        assertEquals(errorList.size(), 1);
        assertEquals(errorList.get(0), "GueltigAb");
    }
    
    /**
     * GültigAb gültig GültigBis ungültig. In verkehrter Reihenfolge befüllt.
     * errorList Inhalt: "GueltigBis"
     * Ungültig.
     */
    @Test
    public void testIsValidGueltigBisUngueltigAb() {
        ArrayList<String> errorList;
        checklist.add(new BinderProperty("GueltigBis", "", Date.class));
        checklist.add(new BinderProperty("GueltigAb", "1.1.1980", Date.class));
        errorList = logic.check(checklist);
        assertFalse(errorList.isEmpty());
        assertEquals(errorList.size(), 1);
        assertEquals(errorList.get(0), "GueltigBis");
    }
    
    /**
     * GültigAb und GültigBis ungültig. In verkehrter Reihenfolge befüllt.
     * errorList Inhalt: "GueltigAb","GueltigBis"
     * Ungültig.
     */
    @Test
    public void testIsValidGueltigBisAbUngültig() {
        ArrayList<String> errorList;
        checklist.add(new BinderProperty("GueltigBis", "", Date.class));
        checklist.add(new BinderProperty("GueltigAb", "", Date.class));
        errorList = logic.check(checklist);
        assertFalse(errorList.isEmpty());
        assertEquals(errorList.size(), 2);
        assertEquals(errorList.get(0), "GueltigBis");
        assertEquals(errorList.get(1), "GueltigAb");
    }
    
    /**
     * Name mit Wert null.
     * Ungültig.
     */
    @Test
    public void testIsValidNameNull() {
        ArrayList<String> errorList;
        checklist.add(new BinderProperty("Name", null, String.class));
        errorList = logic.check(checklist);
        assertFalse(errorList.isEmpty());
        assertEquals(errorList.size(), 1);
        assertEquals(errorList.get(0), "Name");
    }
    
    /**
     * Name mit leerem Wert ("").
     * Ungültig.
     */
    @Test
    public void testIsValidNameEmpty() {
        ArrayList<String> errorList;
        checklist.add(new BinderProperty("Name", "", String.class));
        errorList = logic.check(checklist);
        assertFalse(errorList.isEmpty());
        assertEquals(errorList.size(), 1);
        assertEquals(errorList.get(0), "Name");
    }
    
    /**
     * Name mit beliebigem Text als Wert ("test").
     * Gültig.
     */
    @Test
    public void testIsValidNameText() {
        ArrayList<String> errorList;
        checklist.add(new BinderProperty("Name", "test", String.class));
        errorList = logic.check(checklist);
        assertTrue(errorList.isEmpty());
    }
    
    /**
     * Chance (Prozent) mit Wert -1.
     * Ungültig.
     */
    @Test
    public void testIsValidChanceNeg1() {
        ArrayList<String> errorList;
        checklist.add(new BinderProperty("Chance", "-1", Integer.class));
        errorList = logic.check(checklist);
        assertFalse(errorList.isEmpty());
        assertEquals(errorList.size(), 1);
        assertEquals(errorList.get(0), "Chance");
    }
    
    /**
     * Chance (Prozent) mit Wert 101.
     * Ungültig.
     */
    @Test
    public void testIsValidChance101() {
        ArrayList<String> errorList;
        checklist.add(new BinderProperty("Chance", "101", Integer.class));
        errorList = logic.check(checklist);
        assertFalse(errorList.isEmpty());
        assertEquals(errorList.size(), 1);
        assertEquals(errorList.get(0), "Chance");
    }

    /**
     * Chance (Prozent) mit Wert -1.
     * Gültig.
     */
    @Test
    public void testIsValidChance1() {
        ArrayList<String> errorList;
        checklist.add(new BinderProperty("Chance", "1", Integer.class));
        errorList = logic.check(checklist);
        assertTrue(errorList.isEmpty());
    }
    
    /**
     * Chance (Prozent) mit Wert 100.
     * Gültig.
     */
    @Test
    public void testIsValidChanceNeg100() {
        ArrayList<String> errorList;
        checklist.add(new BinderProperty("Chance", "100", Integer.class));
        errorList = logic.check(checklist);
        assertTrue(errorList.isEmpty());
    }
    
    /**
     * Dauer (Zahl) mit Wert -1.
     * Ungültig.
     */
    @Test
    public void testIsValidDauerNeg1() {
        ArrayList<String> errorList;
        checklist.add(new BinderProperty("Dauer", "-1", Integer.class));
        errorList = logic.check(checklist);
        assertFalse(errorList.isEmpty());
        assertEquals(errorList.size(), 1);
        assertEquals(errorList.get(0), "Dauer");
    }
    
    /**
     * Dauer (Zahl) mit Wert 0.
     * Gültig.
     */
    @Test
    public void testIsValidDauer0() {
        ArrayList<String> errorList;
        checklist.add(new BinderProperty("Dauer", "0", Integer.class));
        errorList = logic.check(checklist);
        assertTrue(errorList.isEmpty());
    }
    
    /**
     * Preis (Zahl) mit Wert -1.
     * Ungültig.
     */
    @Test
    public void testIsValidPreisNeg1() {
        ArrayList<String> errorList;
        checklist.add(new BinderProperty("Preis", "-1", Double.class));
        errorList = logic.check(checklist);
        assertFalse(errorList.isEmpty());
        assertEquals(errorList.size(), 1);
        assertEquals(errorList.get(0), "Preis");
    }
    
    
    /**
     * Preis (Zahl) mit Wert 0.
     * Gültig.
     */
    @Test
    public void testIsValidPreis0() {
        ArrayList<String> errorList;
        checklist.add(new BinderProperty("Preis", "0", Integer.class));
        errorList = logic.check(checklist);
        assertTrue(errorList.isEmpty());
    }
    
    /**
     * Preis (Zahl) mit Wert 0.5.
     * Gültig.
     */
    @Test
    public void testIsValidPreis0_5() {
        ArrayList<String> errorList;
        checklist.add(new BinderProperty("Preis", "0.5", Integer.class));
        errorList = logic.check(checklist);
        assertTrue(errorList.isEmpty());
    }
    
    /**
     * Preis (Zahl) mit Wert 0,5.
     * Ungültig.
     */
    @Test
    public void testIsValidPreis0comma5() {
        ArrayList<String> errorList;
        checklist.add(new BinderProperty("Preis", "0,5", Integer.class));
        errorList = logic.check(checklist);
        assertFalse(errorList.isEmpty());
        assertEquals(errorList.size(), 1);
        assertEquals(errorList.get(0), "Preis");
    }
    
    @Before
    public void setUp() {
        checklist = new ArrayList<BinderProperty>();
        logic = new AngebotLogic();
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
