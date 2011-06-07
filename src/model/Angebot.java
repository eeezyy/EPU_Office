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
public class Angebot extends AbstractObject {

    private String name;
    private Date gueltigAb;
    private Date gueltigBis;
    private Double preis;
    private Integer dauer;
    private Integer chance;
    private String beschreibung;
    private Date aenderungsDatum;
    private SimpleDateFormat sDF = new SimpleDateFormat("dd.MM.yyyy");

    @Override
    public String toString() {
        if (this.name != null || this.gueltigBis != null)
            return this.name + ", " + this.sDF.format(gueltigBis);
        else
            return "<Neues Angebot>";
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

    public Integer getChance() {
        return chance;
    }

    public void setChance(Integer chance) {
        this.chance = chance;
    }

    public Integer getDauer() {
        return dauer;
    }

    public void setDauer(Integer dauer) {
        this.dauer = dauer;
    }

    public Double getPreis() {
        return preis;
    }

    public void setPreis(Double preis) {
        this.preis = preis;
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
