/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bl;

import controller.BinderProperty;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author MAS
 */
public abstract class AbstractLogic {

    public abstract ArrayList<String> check(ArrayList<BinderProperty> list);
    private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    protected boolean isValidDate(String text) {
        if (!isValidString(text)) {
            return false;
        }


        try {
            sdf.parse(text);
        } catch (ParseException ex) {
            return false;
        }

        return true;
    }

    protected boolean isValidDateAfter(String current, String before) {
        try {
            if (!sdf.parse(before).before(sdf.parse(current))) {
                return false;
            }
        } catch (ParseException ex) {
            return false;
        }

        return true;
    }

    protected boolean isValidDateBefore(String current, String after) {
        try {
            if (!sdf.parse(after).after(sdf.parse(current))) {
                return false;
            }
        } catch (ParseException ex) {
            return false;
        }

        return true;
    }

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

        if (text.isEmpty() || text.length() == 0) {
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
    
    protected boolean isValidIntegerNotNeg(String text) {
        try {
            if(Integer.parseInt(text) < 0)
                return false;
        } catch (NumberFormatException nfex) {
            return false;
        }
        return true;
    }

    protected boolean isValidPercent(String text) {
        int intValue;

        if (!isValidInteger(text)) {
            return false;
        }

        intValue = Integer.parseInt(text);

        // gültig nur prozentbereich von 0 bis 100
        if (intValue < 0 || intValue > 100) {
            return false;
        }

        return true;
    }

    protected boolean isValidDouble(String text) {
        try {
            Double.parseDouble(text);
        } catch (NumberFormatException nfex) {
            return false;
        }

        return true;
    }
    
    protected boolean isValidDoubleNotNeg(String text) {
        try {
            if(Double.parseDouble(text) < 0 )
                return false;
        } catch (NumberFormatException nfex) {
            return false;
        }

        return true;
    }

    protected boolean isValidId(String text) {
        if (!isValidInteger(text)) {
            return false;
        }
        int intValue = Integer.parseInt(text);
        
        if(intValue == 0) {
            return false;
        }

        return true;
    }

    protected boolean isValidIdNull(String text) {
        if (text == null || text.isEmpty()) {
            return true;
        }

        if (!isValidInteger(text)) {
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
        if (text == null)
            return false;
        Pattern p = Pattern.compile("[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?");
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

        if (!isValidString(text)) {
            return false;
        }

        if (!isValidInteger(text)) {
            return false;
        }

        intValue = Integer.parseInt(text);
        // Hausnr soll nicht länger als 3 stellen haben. 
        // Und nicht kleiner als sein
        if (intValue > 999 || intValue < 1) {
            return false;
        }

        return true;
    }

    protected boolean isValidPlz(String text) {
        int intValue;

        if (!isValidString(text)) {
            return false;
        }

        if (!isValidInteger(text)) {
            return false;
        }

        intValue = Integer.parseInt(text);
        // PLZ ist vierstellig
        if (intValue < 1000 || intValue > 9999) {
            return false;
        }

        return true;
    }
}
