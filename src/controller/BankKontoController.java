/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.dal.DALFactory;
import model.dal.IDAL;
import view.BankKontoView;

/**
 *
 * @author Goran-Goggy
 */
public class BankKontoController {
        
    private BankKontoView view;
    private IDAL db;
    
    public BankKontoController() {
        this.db = DALFactory.getDAL();
        this.view = new BankKontoView(this);
        //this.initialize();
        MainController.mainGUI.addTabPanel(view, "Bankkonto");
    }
}
