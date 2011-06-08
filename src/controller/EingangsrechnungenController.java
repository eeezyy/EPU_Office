/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.dal.DALFactory;
import model.dal.IDAL;
import view.ProjektView;
import view.Eingangsrechnungen;

/**
 *
 * @author Goran-Goggy
 */
public class EingangsrechnungenController {
    private Eingangsrechnungen view;
    private IDAL dal;
    
    public EingangsrechnungenController () {
        this.dal = DALFactory.getDAL();
        this.view = new Eingangsrechnungen(this);
        RechnungsUeberblickController.view.addTabPanel(view, "Eingangsrechnungen");
    }
}
