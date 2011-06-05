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
    private Integer hausnr;
    private Integer plz;
    private String ort;
    private String email;
    private String telefon;
    private Long konto;
    private Integer blz;
    private String bankinstitut;
    private Boolean isKunde;
    
    @Override
    public String toString(){
        return this.nachname + ", " + this.vorname;
    }

    public Boolean getIsKunde() {
        return isKunde;
    }

    public void setIsKunde(Boolean isKunde) {
        this.isKunde = isKunde;
    }

    public Integer getBlz() {
        return blz;
    }

    public void setBlz(Integer blz) {
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

    public Long getKonto() {
        return konto;
    }

    public void setKonto(Long konto) {
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
    
    public Integer getHausnr() {
        return hausnr;
    }

    public void setHausnr(Integer hausnr) {
        this.hausnr = hausnr;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public Integer getPlz() {
        return plz;
    }

    public void setPlz(Integer plz) {
        this.plz = plz;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }
}
