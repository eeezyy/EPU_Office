/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;

/**
 *  @author Alexander Kumbeiz & Goran Janosevic
 */
public class FileAppender implements Appender {

    private Date now;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd");
    private StringBuilder date;
    private String dateOutput;
    private FileWriter fstream;
    private BufferedWriter out;
    private File file;

    public FileAppender() {
        now = new Date();
    }

    public void configure() {
        //System.out.println("Fileappender gestartet");
        date = new StringBuilder(dateFormat.format(now));
        dateOutput = date.toString();
        this.file = new File("ErrorLog_YMD_" + dateOutput);
    }

    public void log(Level level, String message) {
        Date yet = new Date();
        SimpleDateFormat yetFormat = new SimpleDateFormat("EE dd.MM.yyyy @ HH:mm:ss");
        StringBuilder combine = new StringBuilder(yetFormat.format(yet));
        try {
            fstream = new FileWriter(file, file.exists());
        } catch (IOException ex) {
            //Logger.getLogger(FileAppender.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error: " + ex.getMessage());
            return;
        }
        out = new BufferedWriter(fstream);
        try {
            out.write(level.toString() + ": " + combine.toString() + " | " + message + "\r\n");
        } catch (IOException ex) {
            //Logger.getLogger(FileAppender.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error: " + ex.getMessage());
            return;
        }
        try {
            out.close();
        } catch (IOException ex) {
            //Logger.getLogger(FileAppender.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error: " + ex.getMessage());
            return;
        }

    }
}
