/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.MainView;

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
        
        mainGUI.setVisible(true);
    }
    
}
