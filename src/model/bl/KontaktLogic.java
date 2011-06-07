/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bl;

import controller.BinderProperty;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author MAS
 */
public class KontaktLogic extends AbstractLogic {

    @Override
    public ArrayList<String> check(ArrayList<BinderProperty> propertyList) {
        ArrayList<String> errorList = new ArrayList<String>();

        BinderProperty property = null;
        Iterator i = propertyList.iterator();
        while (i.hasNext()) {
            property = (BinderProperty) i.next();
            if (property.getProperty().equals("Id")) {
                if (!isValidIdNull(property.getValue())) {
                    errorList.add(property.getProperty());
                }
            } else if (property.getProperty().equals("Email")) {
                if (!isValidEmail(property.getValue())) {
                    errorList.add(property.getProperty());
                }
            } else if (property.getProperty().equals("Konto")) {
                if (!isValidKonto(property.getValue())) {
                    errorList.add(property.getProperty());
                }
            } else if (property.getProperty().equals("Blz")) {
                if (!isValidBlz(property.getValue())) {
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
}
