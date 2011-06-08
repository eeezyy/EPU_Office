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
public class Mitarbeiter extends AbstractObject {

    private String vorname;
    private String nachname;
    private Double stundensatz;
    private Date geburtsdatum;

    @Override
    public String toString() {
        if (nachname != null && vorname != null) {
            return this.nachname + ", " + this.vorname;
        } else {
            return "<Neuer Mitarbeiter>";
        }
    }

    public Date getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setGeburtsdatum(Date geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public Double getStundensatz() {
        return stundensatz;
    }

    public void setStundensatz(Double stundensatz) {
        this.stundensatz = stundensatz;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
}
