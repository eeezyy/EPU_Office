/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.csv;

import java.awt.event.ActionEvent;
import java.io.File;
import java.util.logging.Level;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.dal.DALException;
import model.dal.DALFactory;
import utils.log.Logger;

/**
 *
 * @author Goran-Goggy
 */
public class OpenFileAction extends AbstractAction {

    private JPanel panel;
    private JFileChooser chooser;
    private File file;

    public OpenFileAction(JPanel panel, JFileChooser chooser) {
        super("Open...");
        this.chooser = chooser;
        this.panel = panel;
    }

    public void actionPerformed(ActionEvent evt) {
        // Show dialog; this method does not return until dialog is closed
        chooser.showOpenDialog(panel);
        // Get the selected file
        file = chooser.getSelectedFile();
        if (file != null) {
            System.out.println(file.toString() + "geparst");
            //CSVReader reader = new CSVReader();
            CSVReader reader = new CSVReader(file);
            try {
                DALFactory.getDAL().saveArbeitsstunden(reader.parse());
                
                System.out.println("Fertig! Datensätze gespeichert.");
            } catch (DALException ex) {
                Logger.log(Level.SEVERE, OpenFileAction.class, ex);
            }
        }
    }
}
