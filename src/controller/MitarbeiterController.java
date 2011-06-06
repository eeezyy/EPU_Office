/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.dal.DALFactory;
import model.dal.IDAL;
import view.MitarbeiterView;

/**
 *
 * @author Goran-Goggy
 */
public class MitarbeiterController {

    private MitarbeiterView view;
    private IDAL dal;

    public MitarbeiterController() {
        this.dal = DALFactory.getDAL();
        this.view = new MitarbeiterView(this);
        MainController.mainGUI.addTabPanel(view, "Mitarbeiter");
    }
}
