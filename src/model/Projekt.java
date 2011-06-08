/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dal.DALException;
import model.dal.DALFactory;

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
    
    public Integer getProjektStundenGesamt() {
        if(this.getId() != null)
        try {
            return DALFactory.getDAL().getProjektStundenGesamt(this.getId());
        } catch (DALException ex) {
            Logger.getLogger(Projekt.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        else
            return null;
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
