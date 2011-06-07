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
public class AngebotLogic extends AbstractLogic {

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
                if (!isValidId(property.getValue())) {
                    errorList.add(property.getProperty());
                }
            } else if (property.getProperty().equals("GueltigAb")) {
                if(after != null) {
                    if(!isValidDateBefore(property.getValue(), after)) {
                        errorList.add(property.getProperty());
                    }
                }
                else if (!isValidDate(property.getValue())) {
                    errorList.add(property.getProperty());
                } else {
                    before = property.getValue();
                }
            } else if (property.getProperty().equals("GueltigBis")) {
                if(before != null) {
                    if(!isValidDateAfter(property.getValue(), before)) {
                        errorList.add(property.getProperty());
                    }
                }
                else if (!isValidDate(property.getValue())) {
                    errorList.add(property.getProperty());
                } else {
                    after = property.getValue();
                }
            } else if (property.getProperty().equals("Name")) {
                if (!isValidStringNotEmpty(property.getValue())) {
                    errorList.add(property.getProperty());
                }
            } else if (property.getProperty().equals("Chance")) {
                if (!isValidPercent(property.getValue())) {
                    errorList.add(property.getProperty());
                }
            } else if (property.getProperty().equals("Dauer")) {
                if (!isValidInteger(property.getValue())) {
                    errorList.add(property.getProperty());
                }
            } else if (property.getProperty().equals("Preis")) {
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
