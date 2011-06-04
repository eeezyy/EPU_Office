/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bl;

import controller.BinderProperty;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.AbstractObject;

/**
 *
 * @author MAS
 */
public abstract class AbstractLogic {

    public abstract ArrayList<String> check(AbstractObject object);
    public abstract ArrayList<String> check(ArrayList<BinderProperty> list);

    protected boolean isValidString(String text) {
        if (text == null) {
            return false;
        }

        return true;
    }

    protected boolean isValidStringNotEmpty(String text) {
        if (text == null) {
            return false;
        }

        if (text.length() == 0) {
            return false;
        }

        return true;
    }

    protected boolean isValidBlz(String text) {
        int intValue;

        if (!isValidStringNotEmpty(text)) {
            return false;
        }

        if (!isValidInteger(text)) {
            return false;
        }

        intValue = Integer.parseInt(text);

        // Blz soll im Bereich von 10.000 bis 99.999 sein
        if (intValue < 10000 || intValue > 99999) {
            return false;
        }

        return true;
    }

    protected boolean isValidInteger(String text) {
        try {
            Integer.parseInt(text);
        } catch (NumberFormatException nfex) {
            return false;
        }
        return true;
    }

    protected boolean isValidLong(String text) {
        try {
            Long.parseLong(text);
        } catch (NumberFormatException nfex) {
            return false;
        }
        return true;
    }

    protected boolean isValidEmail(String text) {
        Pattern p = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?");
        //Pattern p = Pattern.compile("^([\\w\\-\\.]+)@((\\[([0-9]{1,3}\\.){3}[0-9]{1,3}\\])|(([\\w\\-]+\\.)+)([a-zA-Z]{2,4}))$");
        //Pattern p = Pattern.compile("^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$", Pattern.CASE_INSENSITIVE);
        //Pattern p = Pattern.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher m = p.matcher(text);
        if (!m.matches()) {
            // keine gültige Email-Adresse
            return false;
        }

        return true;
    }

    protected boolean isValidKonto(String text) {
        long longValue;

        if (!isValidString(text)) {
            return false;
        }

        if (!isValidLong(text)) {
            return false;
        }

        longValue = Long.parseLong(text);
        // Konto muss 11-stellig sein
        if (longValue < 10000000000L || longValue > 99999999999L) {
            return false;
        }
        
        return true;
    }
    
    protected boolean isValidHausnr(String text) {
        int intValue;
        
        if(!isValidString(text)) {
            return false;
        }
        
        if (!isValidInteger(text)) {
            return false;
        }
        
        intValue = Integer.parseInt(text);
        // Hausnr soll nicht länger als 3 stellen haben.
        if(intValue > 999) {
            return false;
        }
        
        return true;
    }
    
    protected boolean isValidPlz(String text) {
        int intValue;
        
        if(!isValidString(text)) {
            return false;
        }
        
        if (!isValidInteger(text)) {
            return false;
        }
        
        intValue = Integer.parseInt(text);
        // PLZ ist vierstellig
        if(intValue < 1000 || intValue > 9999) {
            return false;
        }
        
        return true;
    }
}
