/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.dal.DALFactory;
import model.dal.IDAL;
import view.KundenView;
import view.StatistikView;

/**
 *
 * @author Goran-Goggy
 */
public class StatistikController {
    private StatistikView view;
    private IDAL dal;
    
    public StatistikController () {
        this.dal = DALFactory.getDAL();
        this.view = new StatistikView(this);
        MainController.mainGUI.addTabPanel(view, "Statistik");
    }
}
