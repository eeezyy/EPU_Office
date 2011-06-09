/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.dal.DALFactory;
import model.dal.IDAL;
import view.ProjektView;
import view.Ausgangsrechnungen;

/**
 *
 * @author Goran-Goggy
 */
public class AusgangsrechnungenController {
    private Ausgangsrechnungen view;
    private IDAL dal;
    
    public AusgangsrechnungenController () {
        this.dal = DALFactory.getDAL();
        this.view = new Ausgangsrechnungen(this);
        //RechnungsUeberblickController.view.addTabPanel(view, "Ausgangsrechnungen");
        MainController.mainGUI.addTabPanel(view, "Offene Ausgangsrechnungen");
    }
}
