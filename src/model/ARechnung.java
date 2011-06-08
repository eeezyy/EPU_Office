/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Goran-Goggy
 */
public class ARechnung {

    private Kontakt kontakt;
    private Date datum;
    private Double preis;
    
    @Override
    public String toString() {
        if(datum != null && preis != null) 
            return this.datum + ": " + this.preis;
        else
            return "<Neue Ausgangsrechnung>";
    }
}
