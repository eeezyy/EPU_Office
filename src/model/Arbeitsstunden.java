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
public class Arbeitsstunden extends AbstractObject {

    private Projekt projekt;
    private Mitarbeiter mitarbeiter;
    private Date datum;
    private Integer stunden;
    private String taetigkeit;
    private SimpleDateFormat sDF = new SimpleDateFormat("dd.MM.yyyy");

    @Override
    public String toString() {
        if (datum != null && mitarbeiter != null) {
            return this.sDF.format(this.datum) + ": " + this.mitarbeiter;
        } else {
            return "<Neue Arbeitsstunden>";
        }
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Mitarbeiter getMitarbeiter() {
        return mitarbeiter;
    }

    public void setMitarbeiter(Mitarbeiter mitarbeiter) {
        this.mitarbeiter = mitarbeiter;
    }

    public Projekt getProjekt() {
        return projekt;
    }

    public void setProjekt(Projekt projekt) {
        this.projekt = projekt;
    }

    public Integer getStunden() {
        return stunden;
    }

    public void setStunden(Integer stunden) {
        this.stunden = stunden;
    }

    public String getTaetigkeit() {
        return taetigkeit;
    }

    public void setTaetigkeit(String taetigkeit) {
        this.taetigkeit = taetigkeit;
    }
}
