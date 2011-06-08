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
    private Boolean abgeschlossen;
    private Date von;
    private Date bis;

    @Override
    public String toString() {
        if(name != null) 
            return this.name;
        else
            return "<Neues Projekt>";
    }

    public Boolean getIsAbgeschlossen() {
        return abgeschlossen;
    }

    public void setIsAbgeschlossen(Boolean abgeschlossen) {
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
