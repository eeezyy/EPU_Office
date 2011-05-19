/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package epu_office;

import config.Config;
import controller.MainController;
import utils.BaseDoc;

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

        //BaseDoc test = new BaseDoc();
        //System.out.println("Dokuemnt gespeichert");
        //test.createPDF("TestPDFDOKUMENT____2011.pdf");
        controller = new MainController();
    }
}
