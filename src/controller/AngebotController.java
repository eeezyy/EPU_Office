/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.dal.DALFactory;
import model.dal.IDAL;
import view.AngeboteView;

/**
 *
 * @author Goran-Goggy
 */
public class AngebotController {

    private AngeboteView view;
    private IDAL db;

    public AngebotController() {
        this.db = DALFactory.getDAL();
        this.view = new AngeboteView(this);
        //this.initialize();
        MainController.mainGUI.addTabPanel(view, "Angebote");
    }
}
