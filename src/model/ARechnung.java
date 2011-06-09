/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Goran-Goggy
 */
public class ARechnung extends AbstractObject {

    private Kontakt kontakt;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    @Override
    public String toString() {
        if (datum != null && preis != null) {
            return sdf.format(datum) + ": " + this.preis + " €";
        } else {
            return "<Neue Ausgangsrechnung>";
        }
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Kontakt getKontakt() {
        return kontakt;
    }

    public void setKontakt(Kontakt kontakt) {
        this.kontakt = kontakt;
    }

    public Double getPreis() {
        return preis;
    }

    public void setPreis(Double preis) {
        this.preis = preis;
    }
    private Date datum;
    private Double preis;

}
