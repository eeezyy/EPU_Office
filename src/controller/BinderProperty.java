/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author MAS
 */
public class BinderProperty {
    
    private final String property;
    private final String value;

    public Class getClasstype() {
        return classtype;
    }

    public String getProperty() {
        return property;
    }

    public String getValue() {
        return value;
    }
    private final Class classtype;
    
    public BinderProperty(String property, String value, Class classtype) {
        this.property = property;
        this.value = value;
        this.classtype = classtype;
        
    }
    
}
