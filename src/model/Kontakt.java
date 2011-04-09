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
public class Kontakt extends AbstractModel{

    private int id;
    private String name;
    private String email;
    private String telefon;
    private long kto;
    private int blz;
    private String bank;

    public Kontakt() {

    }
    
    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        if(bank != null){
            this.bank = bank;
        }
    }

    public int getBlz() {
        return blz;
    }

    public void setBlz(int blz) {
        // blz fünfstellig
        if(blz >= 10000 && blz <= 99999) {
            this.blz = blz;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        // implementation of RFC 2822
        // http://www.regular-expressions.info/email.html

        Pattern p = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?");
        Matcher m = p.matcher(email.toLowerCase());
        if(m.matches()) {
            this.email = email;
        }
    }

    public int getId() {
        return id;
    }

    /*
    public void setId(int id) {
        this.id = id;
    }*/

    public long getKto() {
        return kto;
    }

    public void setKto(long kto) {
        // elfstellige kto
        if(kto < 100000000000L) {
            this.kto = kto;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }




}
