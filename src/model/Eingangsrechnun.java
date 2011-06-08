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
public class Eingangsrechnun extends AbstractObject {

    private Kontakt kontakt;
    private String scanPfad;
    private Date datum;
    private Integer preis;

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

    public int getPreis() {
        return preis;
    }

    public void setPreis(int preis) {
        this.preis = preis;
    }

    public String getScanPfad() {
        return scanPfad;
    }

    public void setScanPfad(String scanPfad) {
        this.scanPfad = scanPfad;
    }
}
