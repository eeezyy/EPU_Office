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
public class Angebot extends AbstractObject {
    private int Id;
    private String name;
    private Date gueltigAb;
    private Date gueltigBis;
    private long implPreis;
    private int implDauer;
    private int implChance;
    private String beschreibung;
    private Date aenderungsDatum;

    @Override
    public String toString(){
        return this.name + ", " + this.gueltigBis;
    }
        
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

    public long getImplPreis() {
        return implPreis;
    }

    public void setImplPreis(long implPreis) {
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
