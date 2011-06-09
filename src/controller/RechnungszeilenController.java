/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.dal.DALFactory;
import model.dal.IDAL;
import view.ProjektView;
import view.Rechnungszeilen;

/**
 *
 * @author Goran-Goggy
 */
public class RechnungszeilenController {

    private Rechnungszeilen view;
    private IDAL dal;

    public RechnungszeilenController() {
        this.dal = DALFactory.getDAL();
        this.view = new Rechnungszeilen(this);
        MainController.mainGUI.addTabPanel(view, "Rechnungszeilen");
    }
}
