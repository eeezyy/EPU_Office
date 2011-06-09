/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author MAS
 */
public class BuchungszeilenEintrag {
    
    private Integer rechnung_id;
    private Kategorie kategorie;
    private Double betrag;
    private Boolean isBezahlt;

    @Override
    public String toString() {
        String bezahlt = "";
        if(isBezahlt)
            bezahlt = " (komplett)";
        return "Rechnungsnr: " + rechnung_id + "; Betrag: " + betrag + bezahlt;
    }

    
    
    public Boolean getIsBezahlt() {
        return isBezahlt;
    }

    public void setIsBezahlt(Boolean isBezahlt) {
        this.isBezahlt = isBezahlt;
    }
    
    public Double getBetrag() {
        return betrag;
    }

    public void setBetrag(Double betrag) {
        this.betrag = betrag;
    }

    public Kategorie getKategorie() {
        return kategorie;
    }

    public void setKategorie(Kategorie kategorie) {
        this.kategorie = kategorie;
    }

    public Integer getRechnung_id() {
        return rechnung_id;
    }

    public void setRechnung_id(Integer rechnung_id) {
        this.rechnung_id = rechnung_id;
    }
    
}
