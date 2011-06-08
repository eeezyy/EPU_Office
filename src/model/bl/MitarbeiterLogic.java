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
public class MitarbeiterLogic extends AbstractLogic {

    @Override
    public ArrayList<String> check(ArrayList<BinderProperty> propertyList) {
        ArrayList<String> errorList = new ArrayList<String>();
        String before = null;
        String after = null;

        BinderProperty property = null;
        Iterator i = propertyList.iterator();
        while (i.hasNext()) {
            property = (BinderProperty) i.next();
            if (property.getProperty().equals("Id")) {
                if (!isValidIdNull(property.getValue())) {
                    errorList.add(property.getProperty());
                }
            } else if (property.getProperty().equals("Geburtsdatum")) {
                if (!isValidDate(property.getValue())) {
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
            } else if (property.getProperty().equals("Stundensatz")) {
                if (!isValidDouble(property.getValue())) {
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
