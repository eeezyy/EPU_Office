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
public class Angebot {
    private String name;
    private Date gueltigAb;
    private Date gueltigBis;
    private int implPreis;
    private int implDauer;
    private int implChance;
    private String beschreibung;
    private Date aenderungsDatum;

    public Date getGueltigAb() {
        return gueltigAb;
    }

    public void setGueltigAb(Date gueltigAb) {
        this.gueltigAb = gueltigAb;
    }

    public Date getGueltigBis() {
        return gueltigBis;
    }

    public void setGueltigBis(Date gueltigBis) {
        this.gueltigBis = gueltigBis;
    }

    public int getImplChance() {
        return implChance;
    }

    public void setImplChance(int implChance) {
        this.implChance = implChance;
    }

    public int getImplDauer() {
        return implDauer;
    }

    public void setImplDauer(int implDauer) {
        this.implDauer = implDauer;
    }

    public int getImplPreis() {
        return implPreis;
    }

    public void setImplPreis(int implPreis) {
        this.implPreis = implPreis;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getAenderungsDatum() {
        return aenderungsDatum;
    }

    public void setAenderungsDatum(Date aenderungsDatum) {
        this.aenderungsDatum = aenderungsDatum;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }
    
    
}
