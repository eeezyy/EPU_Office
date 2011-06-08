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
public class Rechnung extends AbstractObject{
    private ARechnung ausgangsrechnung;
    private ERechnung eingangsrechnung;
    private Date datum;

    public ARechnung getAusgangsrechnung() {
        return ausgangsrechnung;
    }

    public void setAusgangsrechnung(ARechnung ausgangsrechnung) {
        this.ausgangsrechnung = ausgangsrechnung;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public ERechnung getEingangsrechnung() {
        return eingangsrechnung;
    }

    public void setEingangsrechnung(ERechnung eingangsrechnung) {
        this.eingangsrechnung = eingangsrechnung;
    }
    
    
}
