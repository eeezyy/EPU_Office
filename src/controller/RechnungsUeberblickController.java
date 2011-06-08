package controller;

import model.dal.DALFactory;
import model.dal.IDAL;
import view.Rechnungsueberblick;

/**
 *
 * @author Goran-Goggy
 */
public class RechnungsUeberblickController {

    public static final Rechnungsueberblick view;

    static {
        view = new Rechnungsueberblick();
    }

    public RechnungsUeberblickController() {
        new OffeneAusgangsrechnungenController();
        new OffeneEingangsrechnungenController();
        new AusgangsrechnungenController();
        new EingangsrechnungenController();
        MainController.mainGUI.addTabPanel(view, "Rechnungsüberblick");
        view.setVisible(true);
    }
}
