/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.csv;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import model.AbstractObject;
import utils.log.Logger;
import model.Arbeitsstunden;

/**
 *
 * @author Goran-Goggy
 */
public class CSVWriter {

    private ArrayList<AbstractObject> log;
    private PrintWriter writer;
    private DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    public CSVWriter(File selectedFile, ArrayList<AbstractObject> log) {
        this.log = log;
        
        try {
            // int dotPos = filenameExtension.lastIndexOf(".");
            //extension = filenameExtension.substring(dotPos);
            String extension = selectedFile.toString();
            if (extension.contains(".")) {
                int dotPos = extension.lastIndexOf(".");
                String type = extension.substring(dotPos);
                if (!(type.equals(".csv"))) {
                    this.writer = new PrintWriter(selectedFile + ".csv");
                } else {
                    this.writer = new PrintWriter(selectedFile);
                }
            } else {
                this.writer = new PrintWriter(selectedFile + ".csv");
            }
            //System.out.println("selected File: " + selectedFile);
        } catch (IOException ex) {
            Logger.log(Level.SEVERE, CSVWriter.class, ex);
        }
        writer.append("Projekt_ID");
        writer.append(";");
        writer.append("Mitarbeiter_ID");
        writer.append(";");
        writer.append("Datum");
        writer.append(";");
        writer.append("Stunden");
        writer.append(";");
        writer.append("Taetigkeit");
        writer.println();

        Iterator i = log.iterator();
        while(i.hasNext()) {
            Object logA = i.next();
            Arbeitsstunden a;
            if(!(logA instanceof Arbeitsstunden))
                continue;
            else
                a = (Arbeitsstunden)logA;
            writer.append(a.getProjekt().getId().toString());
            writer.append(";");
            writer.append(a.getMitarbeiter().getId().toString());
            writer.append(";");
            writer.append(df.format(a.getDatum()).toString());
            writer.append(";");
            writer.append(a.getStunden().toString());
            writer.append(";");
            writer.append(a.getTaetigkeit());
            writer.println();
        }
        writer.flush();
        writer.close();
    }
}
