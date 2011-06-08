/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.dal.DALFactory;
import model.dal.IDAL;
import view.ProjektView;
import view.OffeneEingangsrechnungen;

/**
 *
 * @author Goran-Goggy
 */
public class OffeneEingangsrechnungenController {
    private OffeneEingangsrechnungen view;
    private IDAL dal;
    
    public OffeneEingangsrechnungenController () {
        this.dal = DALFactory.getDAL();
        this.view = new OffeneEingangsrechnungen(this);
        RechnungsUeberblickController.view.addTabPanel(view, "Offene Eingangsrechnungen");
    }
}
