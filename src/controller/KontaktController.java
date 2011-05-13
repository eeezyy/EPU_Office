/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import model.Kontakt;
import model.bl.KontaktLogic;
import model.dal.DALException;
import model.dal.DALFactory;
import view.KontakteView;

/**
 *
 * @author if09b505
 */
public class KontaktController extends AbstractController {

    public static final String KONTAKT_NAME_PROPERTY = "Name";
    public static final String KONTAKT_TELEFON_PROPERTY = "Telefon";
    public static final String KONTAKT_EMAIL_PROPERTY = "Email";
    public static final String KONTAKT_BANK_PROPERTY = "Bank";
    public static final String KONTAKT_BLZ_PROPERTY = "Blz";
    public static final String KONTAKT_KTO_PROPERTY = "Kto";

    public void changeKontakt(Kontakt kontakt) throws DALException {
        if(KontaktLogic.check(kontakt).isEmpty()){
            DALFactory.getDAL().saveKontakt(kontakt);
        } else {
            //arraylist to view
        }
        
        setModelProperty(KONTAKT_NAME_PROPERTY, kontakt);
    }

    

}
