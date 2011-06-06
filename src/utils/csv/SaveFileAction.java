/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.csv;

import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

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
    }
}
