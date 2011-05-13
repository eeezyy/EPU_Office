/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.AbstractViewPanel;
import view.KontakteView;
import view.MainView;

/**
 *
 * @author MAS
 */
public class MainController extends AbstractController {
    
    public MainController() {
        MainView mainGUI = new MainView();
        // View kann nicht auf controller zugreifen, umbauen
        AbstractViewPanel tempView;
        tempView = new KontakteView(new ModelObservable());
        tempView.setController(new KontaktController());
        mainGUI.addTabPanel(tempView, "Kontakte");
        
        /*mainGUI.addTabPanel(new KundenView(), "Kunden");
        mainGUI.addTabPanel(new AngeboteView(), "Angebote");
        mainGUI.addTabPanel(new StatistikView(), "Statistik");
        mainGUI.addTabPanel(new ProjektView(), "Projekte");
        */
        
        
        mainGUI.setVisible(true);
    }
    
}
