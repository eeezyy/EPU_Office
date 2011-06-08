/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bl;

import controller.BinderProperty;
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
public class KontaktLogicTest {

    static ArrayList<BinderProperty> checklist;
    static KontaktLogic logic;

    /**
     * KontaktLogic.
     * 
     * Testen der Business-Logik.
     * funktion <ModelName>Logic.check(BinderProperty)
     * BinderProperty(PropertyName, PropertyValue, ValueClass)
     * ValueClass hat keine Auswirkung auf die Business-Logik.
     */
    public KontaktLogicTest() {
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

    // Bis hier, ähnlich zur AngebotLogicTest
    /**
     * Vorname mit Wert null.
     * Ungültig.
     */
    @Test
    public void testIsValidVornameNull() {
        ArrayList<String> errorList;
        checklist.add(new BinderProperty("Vorname", null, String.class));
        errorList = logic.check(checklist);
        assertFalse(errorList.isEmpty());
        assertEquals(errorList.size(), 1);
        assertEquals(errorList.get(0), "Vorname");
    }

    /**
     * Name mit leerem Wert ("").
     * Ungültig.
     */
    @Test
    public void testIsValidVornameEmpty() {
        ArrayList<String> errorList;
        checklist.add(new BinderProperty("Vorname", "", String.class));
        errorList = logic.check(checklist);
        assertFalse(errorList.isEmpty());
        assertEquals(errorList.size(), 1);
        assertEquals(errorList.get(0), "Vorname");
    }

    /**
     * Name mit beliebigem Text als Wert ("test").
     * Gültig.
     */
    @Test
    public void testIsValidVornameText() {
        ArrayList<String> errorList;
        checklist.add(new BinderProperty("Vorname", "test", String.class));
        errorList = logic.check(checklist);
        assertTrue(errorList.isEmpty());
    }

    // Bis hier ähnlich zu AngebotLogicTest, Name
    // Nachname ist nach den selben Regeln
    /**
     * Konto mit 10 Stellen: 9999999999
     * Ungültig.
     */
    @Test
    public void testIsValidKonto10Stellen() {
        ArrayList<String> errorList;
        checklist.add(new BinderProperty("Konto", "9999999999", Long.class));
        errorList = logic.check(checklist);
        assertFalse(errorList.isEmpty());
        assertEquals(errorList.size(), 1);
        assertEquals(errorList.get(0), "Konto");
    }

    /**
     * Konto mit 12 Stellen: 1000000000000
     * Ungültig.
     */
    @Test
    public void testIsValidKonto12Stellen() {
        ArrayList<String> errorList;
        checklist.add(new BinderProperty("Konto", "100000000000", Long.class));
        errorList = logic.check(checklist);
        assertFalse(errorList.isEmpty());
        assertEquals(errorList.size(), 1);
        assertEquals(errorList.get(0), "Konto");
    }

    /**
     * Konto mit 11 Stellen: 100000000000
     * Gültig.
     */
    @Test
    public void testIsValidKonto11StellenLowest() {
        ArrayList<String> errorList;
        checklist.add(new BinderProperty("Konto", "10000000000", Long.class));
        errorList = logic.check(checklist);
        assertTrue(errorList.isEmpty());
    }

    /**
     * Konto mit 11 Stellen: 99999999999
     * Gültig.
     */
    @Test
    public void testIsValidKonto10StellenHighest() {
        ArrayList<String> errorList;
        checklist.add(new BinderProperty("Konto", "99999999999", Long.class));
        errorList = logic.check(checklist);
        assertTrue(errorList.isEmpty());
    }

    /**
     * Blz mit 4 Stellen: 9999
     * Ungültig.
     */
    @Test
    public void testIsValidBlz4Stellen() {
        ArrayList<String> errorList;
        checklist.add(new BinderProperty("Blz", "9999", Integer.class));
        errorList = logic.check(checklist);
        assertFalse(errorList.isEmpty());
        assertEquals(errorList.size(), 1);
        assertEquals(errorList.get(0), "Blz");
    }

    /**
     * Blz mit 6 Stellen: 100000
     * Ungültig.
     */
    @Test
    public void testIsValidBlz6Stellen() {
        ArrayList<String> errorList;
        checklist.add(new BinderProperty("Blz", "100000", Integer.class));
        errorList = logic.check(checklist);
        assertFalse(errorList.isEmpty());
        assertEquals(errorList.size(), 1);
        assertEquals(errorList.get(0), "Blz");
    }

    /**
     * Blz mit 5 Stellen: 10000
     * Gültig.
     */
    @Test
    public void testIsValidBlz5StellenLowest() {
        ArrayList<String> errorList;
        checklist.add(new BinderProperty("Blz", "10000", Integer.class));
        errorList = logic.check(checklist);
        assertTrue(errorList.isEmpty());
    }

    /**
     * Blz mit 11 Stellen: 99999
     * Gültig.
     */
    @Test
    public void testIsValidBlz5StellenHighest() {
        ArrayList<String> errorList;
        checklist.add(new BinderProperty("Blz", "99999", Integer.class));
        errorList = logic.check(checklist);
        assertTrue(errorList.isEmpty());
    }
    
    // Plz ähnlich wie Blz nur 4 Stellen.

    /**
     * Hausnr mit 1 Stelle: 0
     * Ungültig.
     */
    @Test
    public void testIsValidHausnr1Stelle0() {
        ArrayList<String> errorList;
        checklist.add(new BinderProperty("Hausnr", "0", Integer.class));
        errorList = logic.check(checklist);
        assertFalse(errorList.isEmpty());
        assertEquals(errorList.size(), 1);
        assertEquals(errorList.get(0), "Hausnr");
    }

    /**
     * Hausnr mit 1 Stelle, negativ: -1
     * Ungültig.
     */
    @Test
    public void testIsValidHausnr1Stelle1neg() {
        ArrayList<String> errorList;
        checklist.add(new BinderProperty("Hausnr", "-1", Integer.class));
        errorList = logic.check(checklist);
        assertFalse(errorList.isEmpty());
        assertEquals(errorList.size(), 1);
        assertEquals(errorList.get(0), "Hausnr");
    }

    /**
     * Hausnr mit 1 Stelle: 1
     * Gültig.
     */
    @Test
    public void testIsValidHausnr1Stelle1() {
        ArrayList<String> errorList;
        checklist.add(new BinderProperty("Hausnr", "1", Integer.class));
        errorList = logic.check(checklist);
        assertTrue(errorList.isEmpty());
    }

    /**
     * Blz mit 3 Stellen: 999
     * Gültig.
     */
    @Test
    public void testIsValidHausnr3Stellen999() {
        ArrayList<String> errorList;
        checklist.add(new BinderProperty("Hausnr", "999", Integer.class));
        errorList = logic.check(checklist);
        assertTrue(errorList.isEmpty());
    }

    /**
     * Hausnr mit 4 Stellen: 1000
     * Ungültig.
     */
    @Test
    public void testIsValidHausnr4Stellen1000() {
        ArrayList<String> errorList;
        checklist.add(new BinderProperty("Hausnr", "1000", Integer.class));
        errorList = logic.check(checklist);
        assertFalse(errorList.isEmpty());
        assertEquals(errorList.size(), 1);
        assertEquals(errorList.get(0), "Hausnr");
    }
    
    /**
     * Email mit Wert null.
     * Ungültig.
     */
    @Test
    public void testIsValidEmailNull() {
        ArrayList<String> errorList;
        checklist.add(new BinderProperty("Email", null, String.class));
        errorList = logic.check(checklist);
        assertFalse(errorList.isEmpty());
        assertEquals(errorList.size(), 1);
        assertEquals(errorList.get(0), "Email");
    }

    /**
     * Email mit leerem Wert ("").
     * Ungültig.
     */
    @Test
    public void testIsValidEmailEmpty() {
        ArrayList<String> errorList;
        checklist.add(new BinderProperty("Email", "", String.class));
        errorList = logic.check(checklist);
        assertFalse(errorList.isEmpty());
        assertEquals(errorList.size(), 1);
        assertEquals(errorList.get(0), "Email");
    }
    
    /**
     * Email mit Wert ("@.").
     * Ungültig.
     */
    @Test
    public void testIsValidEmailAtDot() {
        ArrayList<String> errorList;
        checklist.add(new BinderProperty("Email", "@.", String.class));
        errorList = logic.check(checklist);
        assertFalse(errorList.isEmpty());
        assertEquals(errorList.size(), 1);
        assertEquals(errorList.get(0), "Email");
    }
    
    /**
     * Email mit leerem Wert ("1@2.3").
     * Gültig. (Theoretisch)
     */
    @Test
    public void testIsValidEmailAtDotNumbers() {
        ArrayList<String> errorList;
        checklist.add(new BinderProperty("Email", "1@2.3", String.class));
        errorList = logic.check(checklist);
        assertTrue(errorList.isEmpty());
    }
    
    /**
     * Email mit leerem Wert ("k.o_mli@z.ier.t").
     * Gültig. (Theoretisch)
     */
    @Test
    public void testIsValidEmailKompliziert() {
        ArrayList<String> errorList;
        checklist.add(new BinderProperty("Email", "k.o_mli@z.i-er.t", String.class));
        errorList = logic.check(checklist);
        assertTrue(errorList.isEmpty());
    }

    @Before
    public void setUp() {
        checklist = new ArrayList<BinderProperty>();
        logic = new KontaktLogic();
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
