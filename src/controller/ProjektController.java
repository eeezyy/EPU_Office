/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.dal.DALFactory;
import model.dal.IDAL;
import view.ProjektView;
import view.StatistikView;

/**
 *
 * @author Goran-Goggy
 */
public class ProjektController {
    private ProjektView view;
    private IDAL dal;
    
    public ProjektController () {
        this.dal = DALFactory.getDAL();
        this.view = new ProjektView(this);
        MainController.mainGUI.addTabPanel(view, "Projekte");
    }
}
