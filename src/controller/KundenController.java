/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.dal.DALFactory;
import model.dal.IDAL;
import view.KundenView;

/**
 *
 * @author Goran-Goggy
 */
public class KundenController extends AbstractController{
    private KundenView view;
    private IDAL dal;
    
    public KundenController () {
        this.dal = DALFactory.getDAL();
        this.view = new KundenView(this);
        MainController.mainGUI.addTabPanel(view, "Kunden");
    }
    
}
