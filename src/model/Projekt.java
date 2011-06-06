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
public class Projekt extends AbstractObject {
    private String name;
    private Angebot angebot;
    private boolean abgeschlossen;
    private Date von;
    private Date bis;
    private Long arbeitsStunden;

    public Long getArbeitsStunden() {
        return arbeitsStunden;
    }

    public void setArbeitsStunden(Long arbeitsStunden) {
        this.arbeitsStunden = arbeitsStunden;
    }

    public boolean isAbgeschlossen() {
        return abgeschlossen;
    }

    public void setAbgeschlossen(boolean abgeschlossen) {
        this.abgeschlossen = abgeschlossen;
    }

    public Date getBis() {
        return bis;
    }

    public void setBis(Date bis) {
        this.bis = bis;
    }

    public Date getVon() {
        return von;
    }

    public void setVon(Date von) {
        this.von = von;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Angebot getAngebot() {
        return angebot;
    }

    public void setAngebot(Angebot angebot) {
        this.angebot = angebot;
    }
    
    
}
