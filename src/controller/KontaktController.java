/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.util.ArrayList;
import model.Kontakt;
import model.bl.KontaktLogic;
import model.dal.DALException;
import model.dal.DALFactory;
import model.dal.IDAL;
import view.KontakteView;

/**
 *
 * @author if09b505
 */
public class KontaktController extends AbstractController {
    
    private KontakteView view;
    private IDAL db;
    
    public KontaktController() {
        this.db = DALFactory.getDAL();
        this.view = new KontakteView(this);
        //this.initialize();
        MainController.mainGUI.addTabPanel(view, "Kontakte");
    }
    
//    private void initialize() {
//        ArrayList<Kontakt> kontakte = db.getKontaktListe();
//        view.setKontaktListe(kontakte);
//    }
    
    public ArrayList<Kontakt> getKontaktListe() throws DALException {
        return db.getKontaktListe();
    }

    public void add(Kontakt kontakt) {
        /*if (errorList == null || errorList.isEmpty()) {
            try {
                DALFactory.getDAL().saveKontakt(k);
                System.out.println(k.getId() + " ID haha");
            } catch (DALException ex) {
                Logger.getLogger(KontaktAddForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        list.add(object);*/
    }

    public void change(Kontakt kontakt) throws DALException {
        if(KontaktLogic.check(kontakt).isEmpty()){
            DALFactory.getDAL().saveKontakt(kontakt);
        } else {
            //arraylist to view
        }
        /*for (AbstractObject i : list) {
            if (i.getId() == object.getId()) {
                //i = notifyObject.getObject();
            }
        }*/
    }

    public void delete(Kontakt kontakt) {
        //DALFactory.getDAL().
    }    

}
