/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package epu_office;

import config.Config;
import controller.MainController;
import java.util.logging.Level;
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
       
        Logger.log(Level.INFO, "Hallo, das ist ein Test!");

        //BaseDoc test = new BaseDoc();
        Formular formular = new Formular();
        formular.createPDF("TestPDFDOKUMENT____2011.pdf");
        //System.out.println("Dokument gespeichert");
        //test.createPDF("TestPDFDOKUMENT____2011.pdf");
        controller = new MainController();
    }
}
