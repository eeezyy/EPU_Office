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
public class Projekt {
    private String name;
    private Angebot zugewiesenesAngebot;
    private boolean abgeschlossen;
    private Date dauerVon;
    private Date dauerBis;

    public boolean isAbgeschlossen() {
        return abgeschlossen;
    }

    public void setAbgeschlossen(boolean abgeschlossen) {
        this.abgeschlossen = abgeschlossen;
    }

    public Date getDauerBis() {
        return dauerBis;
    }

    public void setDauerBis(Date dauerBis) {
        this.dauerBis = dauerBis;
    }

    public Date getDauerVon() {
        return dauerVon;
    }

    public void setDauerVon(Date dauerVon) {
        this.dauerVon = dauerVon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Angebot getZugewiesenesAngebot() {
        return zugewiesenesAngebot;
    }

    public void setZugewiesenesAngebot(Angebot zugewiesenesAngebot) {
        this.zugewiesenesAngebot = zugewiesenesAngebot;
    }
    
    
}
