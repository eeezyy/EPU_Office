/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.csv;

import java.io.File;

/**
 *
 * @author Goran-Goggy
 */
public class CSVFilter extends javax.swing.filechooser.FileFilter {

    @Override
    public boolean accept(File file) {
        String filename = file.getName();
        return filename.endsWith(".csv");
    }

    @Override
    public String getDescription() {
        return "*.csv";
    }
}
