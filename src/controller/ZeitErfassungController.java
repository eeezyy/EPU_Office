/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.dal.DALFactory;
import model.dal.IDAL;
import view.ZeitErfassungView;

/**
 *
 * @author Goran-Goggy
 */
public class ZeitErfassungController {
        
    private ZeitErfassungView view;
    private IDAL db;
    
    public ZeitErfassungController() {
        this.db = DALFactory.getDAL();
        this.view = new ZeitErfassungView(this);
        //this.initialize();
        MainController.mainGUI.addTabPanel(view, "Zeiterfassung");
    }
}
