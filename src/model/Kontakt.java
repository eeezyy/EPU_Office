/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author if09b505
 */
public class Kontakt extends AbstractObject {

    private String firmenname;
    private String vorname;
    private String nachname;
    private String strasse;
    private int hausnr;
    private int plz;
    private String ort;
    private String email;
    private String telefon;
    private long konto;
    private int blz;
    private String bankinstitut;
    private boolean isKunde;
    
    @Override
    public String toString(){
        return this.nachname + ", " + this.vorname;
    }

    public boolean getIsKunde() {
        return isKunde;
    }

    public void setIsKunde(boolean isKunde) {
        this.isKunde = isKunde;
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

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
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
    
    public int getHausnr() {
        return hausnr;
    }

    public void setHausnr(int hausnr) {
        this.hausnr = hausnr;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public int getPlz() {
        return plz;
    }

    public void setPlz(int plz) {
        this.plz = plz;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }
}
