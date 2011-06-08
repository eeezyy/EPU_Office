/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Goran-Goggy
 */
public class Kategorie extends AbstractObject {

    private String bezeichnung;
    
    @Override
    public String toString() {
        if(bezeichnung != null) 
            return this.bezeichnung;
        else
            return "<Neue Kategorie>";
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }
    
}
