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
public class ProjektLogic extends AbstractLogic {

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
            } else if (property.getProperty().equals("Angebot")) {
                if (!isValidId(property.getValue())) {
                    errorList.add(property.getProperty());
                }
            } else if (property.getProperty().equals("Von")) {
                if (after != null) {
                    if (!isValidDateBefore(property.getValue(), after)) {
                        errorList.add(property.getProperty());
                    }
                } else if (!isValidDate(property.getValue())) {
                    errorList.add(property.getProperty());
                } else {
                    before = property.getValue();
                }
            } else if (property.getProperty().equals("Bis")) {
                if (before != null) {
                    if (!isValidDateAfter(property.getValue(), before)) {
                        errorList.add(property.getProperty());
                    }
                } else if (!isValidDate(property.getValue())) {
                    errorList.add(property.getProperty());
                } else {
                    after = property.getValue();
                }
            } else if (property.getProperty().equals("Name")) {
                if (!isValidStringNotEmpty(property.getValue())) {
                    errorList.add(property.getProperty());
                }
            } else if (property.getProperty().equals("Aufwand")) {
                if (!isValidInteger(property.getValue())) {
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
