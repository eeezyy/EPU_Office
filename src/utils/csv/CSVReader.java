/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import model.Angebot;
import model.Projekt;
import utils.log.Logger;

/**
 *
 * @author Goran-Goggy
 */
public class CSVReader {
    //   String name; Angebot zugewiesenesAngebot; boolean abgeschlossen; Date dauerVon; Date dauerBis;

    private File selectedFile;
    private BufferedReader bufReader;
    private String line = null;
    private int counter = 0;
    private Angebot angebot;
    private DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    private boolean headerFlag = true;
    private StringTokenizer st;

    public CSVReader(File selectedFile) {
        this.selectedFile = selectedFile;
        try {
            bufReader = new BufferedReader(new FileReader(selectedFile));
        } catch (FileNotFoundException ex) {
            Logger.log(Level.SEVERE, CSVReader.class, ex);
        }
    }

    public ArrayList<Projekt> parse() {
        ArrayList<Projekt> projektListe = new ArrayList<Projekt>();
        try {
            if ((line = bufReader.readLine()) != null) {
                st = new StringTokenizer(line, ";");
                if (st.hasMoreTokens()) {
                    if (headerFlag) {
                        Object dump = st.nextToken();
                        System.out.println(dump.toString());
                        dump = st.nextToken();
                        System.out.println(dump.toString());
                        dump = st.nextToken();
                        System.out.println(dump.toString());
                        dump = st.nextToken();
                        System.out.println(dump.toString());
                        dump = st.nextToken();
                        System.out.println(dump.toString());
                        dump = st.nextToken();
                        System.out.println(dump.toString());
                        dump = st.nextToken();
                        System.out.println(dump.toString());
                        dump = null;
                        headerFlag = false;
                    }
                }
                while ((line = bufReader.readLine()) != null) {
                    st = new StringTokenizer(line, ";");

                    Projekt projekt = new Projekt();
                    st = new StringTokenizer(line, ";");
                    if (counter == 0) {
                        
                        projekt.setId(Integer.parseInt(st.nextToken()));
                        System.out.println(counter + " ID  " + projekt.getId());
                        counter++;
                    }
                    if (counter == 1) {
                        angebot = new Angebot();
                        angebot.setId(Integer.parseInt(st.nextToken()));
                        projekt.setZugewiesenesAngebot(angebot);
                        System.out.println(counter + "  Angebot " + projekt.getZugewiesenesAngebot().getId());
                        counter++;
                    }
                    if (counter == 2) {
                        projekt.setName(st.nextToken());
                        System.out.println(counter + " Name  " + projekt.getName());
                        counter++;
                    }
                    if (counter == 3) {
                        projekt.setAbgeschlossen(Boolean.parseBoolean(st.nextToken()));
                        System.out.println(counter + " boolean  " + projekt.isAbgeschlossen());
                        counter++;
                    }
                    if (counter == 4) {
                        try {
                            projekt.setDauerVon(df.parse(st.nextToken()));
                            System.out.println(counter + " dauerVon  " + df.format(projekt.getDauerVon()));
                        } catch (ParseException ex) {
                            Logger.log(Level.SEVERE, CSVReader.class, ex);
                        }
                        counter++;
                    }
                    if (counter == 5) {
                        try {
                            projekt.setDauerBis(df.parse(st.nextToken()));
                            System.out.println(counter + " dauerBis  " + df.format(projekt.getDauerBis()));
                        } catch (ParseException ex) {
                            Logger.log(Level.SEVERE, CSVReader.class, ex);
                        }
                        counter++;
                    }
                    if (counter == 6) {
                        projekt.setArbeitsStunden(Long.parseLong(st.nextToken()));
                        System.out.println(counter + " Arbeitsstunden  " + projekt.getArbeitsStunden());
                        counter = 0;
                    }
                    projektListe.add(projekt);
                }
                return projektListe;
            }
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(CSVReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return projektListe;
    }
}
