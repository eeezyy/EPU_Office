/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package epu_office;

import config.Config;
import controller.MainController;
import java.util.logging.Level;
import model.dal.DALModelModified;
import utils.documents.Formular;
import utils.log.Logger;

/**
 *
 * @author Goran-Goggy
 */
public class Main {

    public static Config config;
    private static MainController controller;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        config = new Config();
//        Logger.log(Level.INFO, Main.class, "Main gestartet.");
//        Logger.log(Level.FINEST, Main.class, "TEST");
        //Logger.log(Level.SEVERE, Main.class, new DALModelModified("test"));
        //new Formular().createPDF("test.pdf");
        //formular.createPDF("TestPDFDOKUMENT____2011.pdf");
        
        controller = new MainController();
        
    }
}
