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
import model.Mitarbeiter;
import model.Projekt;
import model.ZeitErfassung;
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

    public ArrayList<ZeitErfassung> parse() {
        ArrayList<ZeitErfassung> log = new ArrayList<ZeitErfassung>();
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
                        dump = null;
                        headerFlag = false;
                    }
                }
                while ((line = bufReader.readLine()) != null) {
                    st = new StringTokenizer(line, ";");

                    ZeitErfassung logEintrag = new ZeitErfassung();
                    st = new StringTokenizer(line, ";");
                    if (counter == 0) {
                        Projekt projekt = new Projekt();
                        projekt.setId(Integer.parseInt(st.nextToken()));
                        logEintrag.setProjekt(projekt);
                        System.out.println(counter + " Projekt_ID  " + logEintrag.getProjekt().getId());
                        counter++;
                    }

                    if (counter == 1) {
                        Mitarbeiter mitarbeiter = new Mitarbeiter();
                        mitarbeiter.setId(Integer.parseInt(st.nextToken()));
                        logEintrag.setMitarbeiter(mitarbeiter);

                        System.out.println(counter + " Mitarbeiter_ID  " + logEintrag.getMitarbeiter().getId());
                        counter++;
                    }
                    if (counter == 2) {
                        try {

                            logEintrag.setDatum(df.parse(st.nextToken()));
                            System.out.println(counter + " Datum  " + df.format(logEintrag.getDatum()));
                        } catch (ParseException ex) {
                            Logger.log(Level.SEVERE, CSVReader.class, ex);
                        }
                        counter++;
                    }
                    if (counter == 3) {
                        logEintrag.setStunden((Integer)Integer.parseInt(st.nextToken()));
                        System.out.println(counter + " Stunden  " + logEintrag.getStunden());
                        counter++;
                    }
                    if (counter == 4) {
                        logEintrag.setTaetigkeit(st.nextToken());
                        System.out.println(counter + " Taetigkeit  " + logEintrag.getTaetigkeit());
                        counter = 0;
                    }
                    log.add(logEintrag);
                }
            }
        } catch (IOException ex) {
            Logger.log(Level.SEVERE, CSVReader.class, ex);
        }
        return log;
    }
}
