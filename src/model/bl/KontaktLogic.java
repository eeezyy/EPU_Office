/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bl;

import controller.BinderProperty;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.AbstractObject;
import model.Kontakt;

/**
 *
 * @author MAS
 */
public class KontaktLogic extends AbstractLogic {

    public ArrayList<String> check(ArrayList<BinderProperty> propertyList) {
        ArrayList<String> errorList = new ArrayList<String>();

        BinderProperty property = null;
        for (Iterator i = propertyList.iterator(); i.hasNext(); property = (BinderProperty) i.next()) {
            if (property == null) {
                System.out.println("property null");
                return null;
            }
            if (property.getProperty().equals("Blz")) {
                if (!isValidString(property.getValue())) {
                    errorList.add(property.getProperty());
                }
            } else if (property.getProperty().equals("Email")) {
                if (!isValidEmail(property.getValue())) {
                    errorList.add(property.getProperty());
                }
            } else if (property.getProperty().equals("Konto")) {
                if (!isValidEmail(property.getValue())) {
                    errorList.add(property.getProperty());
                }
            } else if (property.getProperty().equals("Hausnr")) {
                if (!isValidHausnr(property.getValue())) {
                    errorList.add(property.getProperty());
                }
            } else if (property.getProperty().equals("Plz")) {
                if (!isValidPlz(property.getValue())) {
                    errorList.add(property.getProperty());
                }
            } else if (property.getProperty().equals("Vorname")) {
                if (!isValidStringNotEmpty(property.getValue())) {
                    errorList.add(property.getProperty());
                }
            } else if (property.getProperty().equals("Nachname")) {
                if (!isValidStringNotEmpty(property.getValue())) {
                    errorList.add(property.getProperty());
                }
            } else if (property.getClasstype() == String.class) {
                if (!isValidString(property.getValue())) {
                    errorList.add(property.getProperty());
                }
            } else if (property.getClasstype() == Integer.class) {
                if (!isValidInteger(property.getValue())) {
                    errorList.add(property.getProperty());
                }
            } else if (property.getClasstype() == Long.class) {
                if (!isValidLong(property.getValue())) {
                    errorList.add(property.getProperty());
                }
            }
        }

        return errorList;
    }

    @Override
    public ArrayList<String> check(AbstractObject k) {
        // Bank

        ArrayList<String> errorList = new ArrayList<String>();

        Kontakt kontakt = (Kontakt) k;
        if (kontakt.getBankinstitut() == null || kontakt.getBankinstitut().length() == 0) {
            // Bank darf nicht leer sein
            errorList.add("Bankinstitut");
        }
        // BLZ
        if (kontakt.getBlz() != null && !(kontakt.getBlz() >= 10000 && kontakt.getBlz() <= 99999)) {
            // BLZ im Bereich von 10.000 bis 99.999 oder null (=leer)
            errorList.add("Blz");
        }
        // Email
        // implementation of RFC 2822
        // http://www.regular-expressions.info/email.html        
        Pattern p = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?");
        //Pattern p = Pattern.compile("^([\\w\\-\\.]+)@((\\[([0-9]{1,3}\\.){3}[0-9]{1,3}\\])|(([\\w\\-]+\\.)+)([a-zA-Z]{2,4}))$");
        //Pattern p = Pattern.compile("^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$", Pattern.CASE_INSENSITIVE);
        //Pattern p = Pattern.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        System.out.println("email@gmail.com".length());
        System.out.println(kontakt.getEmail().length() + " " + kontakt.getEmail());
        Matcher m = p.matcher("email@gmail.com"); //kontakt.getEmail());
        if (!m.matches()) {
            // keine gültige Email-Adresse
            errorList.add("Email");
        }
        // Kto
        if (kontakt.getKonto() != null && kontakt.getKonto() < 10000000000L) {
            // Kto muss Elfstellig sein oder null (=leer)
            errorList.add("Konto");
        }
        // Name
        if (kontakt.getNachname() == null || kontakt.getNachname() == "") {
            // Name darf nicht leer sein
            errorList.add("Nachname");
        }
        if (kontakt.getTelefon() == null) {
            // Telefonnr darf nicht null sein
            errorList.add("Telefon");
        }

        return errorList;
    }
}
