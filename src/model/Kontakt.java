/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author if09b505
 */
public class Kontakt extends AbstractObject {

    private int id;
    private String firmenname;
    private String vorname;
    private String nachname;
    private String adresse;
    private String email;
    private String telefon;
    private long konto;
    private int blz;
    private String bankinstitut;
    private boolean isKunde;

    public boolean getIsKunde() {
        return isKunde;
    }

    public void setIsKunde(boolean isKunde) {
        this.isKunde = isKunde;
    }

    public Kontakt() {
    }

    public int getBlz() {
        return blz;
    }

    public void setBlz(int blz) {
        this.blz = blz;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    
    public void setId(int id) {
    this.id = id;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    
    
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getBankinstitut() {
        return bankinstitut;
    }

    public void setBankinstitut(String bankinstitut) {
        this.bankinstitut = bankinstitut;
    }

    public String getFirmenname() {
        return firmenname;
    }

    public void setFirmenname(String firmenname) {
        this.firmenname = firmenname;
    }

    public long getKonto() {
        return konto;
    }

    public void setKonto(long konto) {
        this.konto = konto;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
}
