/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.Kontakt;

/**
 *
 * @author MAS
 */
public class KontaktLogic {

    void save(Kontakt kontakt) {
        // Bank
        if (kontakt.getBank() == null || kontakt.getBank() == "") {
            // Bank darf nicht leer sein
        }
        // BLZ
        if (!(kontakt.getBlz() >= 10000 && kontakt.getBlz() <= 99999)) {
            // BLZ im Bereich von 10.000 bis 99.999
        }
        // Email
        // implementation of RFC 2822
        // http://www.regular-expressions.info/email.html        
        Pattern p = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?");
        Matcher m = p.matcher(kontakt.getEmail().toLowerCase());
        if (!m.matches()) {
            // keine gültige Email-Adresse
        }
        // Kto
        if (kontakt.getKto() < 100000000000L) {
            // Kto muss Elfstellig sein
        }
        // Name
        if (kontakt.getName() == null || kontakt.getName() == "") {
            // Name darf nicht leer sein
        }
        if (kontakt.getTelefon() == null) {
            // Telefonnr darf nicht null sein
        }
    }
}
