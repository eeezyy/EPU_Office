/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.csv;

import java.awt.event.ActionEvent;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import model.Mitarbeiter;
import model.ZeitErfassung;
import model.Projekt;

/**
 *
 * @author Goran-Goggy
 */
public class SaveFileAction extends AbstractAction {

    JFileChooser chooser;
    JPanel panel;
    
    public SaveFileAction(JPanel panel, JFileChooser chooser) {
        super("Save As...");
        this.chooser = chooser;
        this.panel = panel;
    }
    
    public void actionPerformed(ActionEvent evt) {
        // Show dialog; this method does not return until dialog is closed
        chooser.showSaveDialog(panel);

        // Get the selected file
        File file = chooser.getSelectedFile();
        //System.out.println("File " + file + " gefunden");
        
        ArrayList<ZeitErfassung> dummyList = new ArrayList<ZeitErfassung>();
        ZeitErfassung logEintrag = new ZeitErfassung();
        Date now = new Date();
        Projekt p = new Projekt();
        p.setId(1);
        Mitarbeiter m = new Mitarbeiter();
        m.setId(5);
        logEintrag.setProjekt(p);
        logEintrag.setMitarbeiter(m);
        logEintrag.setDatum(now);
        logEintrag.setStunden(6);
        logEintrag.setTaetigkeit("CSV Export implementieren");
        
        dummyList.add(logEintrag);
        CSVWriter writer = new CSVWriter(file, dummyList);
    }
}
