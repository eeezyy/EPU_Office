/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.dal.DALFactory;
import model.dal.IDAL;
import view.ProjektView;
import view.OffeneAusgangsrechnungen;

/**
 *
 * @author Goran-Goggy
 */
public class OffeneAusgangsrechnungenController {
    private OffeneAusgangsrechnungen view;
    private IDAL dal;
    
    public OffeneAusgangsrechnungenController () {
        this.dal = DALFactory.getDAL();
        this.view = new OffeneAusgangsrechnungen(this);
        RechnungsUeberblickController.view.addTabPanel(view, "Offene Ausgangsrechnungen");
    }
}
