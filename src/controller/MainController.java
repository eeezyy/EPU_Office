/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.MainView;
import view.ProjektView;
import view.StatistikView;

/**
 *
 * @author MAS
 */
public class MainController extends AbstractController {
    
    public static final MainView mainGUI;
    
    static {
        mainGUI = new MainView();
    }
    
    public MainController() {

        new KontaktController();
        new KundenController();
        new AngebotController();
        new ProjektController();
        new StatistikController();
        new ZeitErfassungController();
        new BankKontoController();
        mainGUI.setVisible(true);
    }
    
}
