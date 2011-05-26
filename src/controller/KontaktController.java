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

}
