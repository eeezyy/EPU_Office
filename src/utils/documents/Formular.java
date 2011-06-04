/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.documents;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import utils.log.Logger;
import org.jfree.chart.JFreeChart;
import utils.charts.LineChart;

/**
 *  @author Alexander Kumbeiz & Goran Janosevic
 */
public class Formular extends BaseDoc {

    private ArrayList<String> text;

    public Formular(ArrayList<String> t) {
        this.text = t;
    }

    @Override
    protected void writePDF(Document doc, PdfWriter pdfWrite) {
        try {
            writeHeader1("Testzeile: Header 1", doc);
            writeHeader2("Testzeile: Header 2", doc);

            //http://www.wirelust.com/2008/03/17/creating-an-itext-pdf-with-embedded-jfreechart/
            doc.add(new Paragraph("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));
        } catch (DocumentException ex) {
            Logger.log(Level.SEVERE, Formular.class, ex);
        }
        ArrayList<String> xList = new ArrayList<String>();
        ArrayList<Double> yList = new ArrayList<Double>();

        xList.add("Null");
        xList.add("Eins");
        xList.add("Zwei");
        xList.add("Drei");
        xList.add("Vier");
        xList.add("Fünf");
        //setfTopCenter("test");

        yList.add(1.0);
        yList.add(1.1);
        yList.add(1.2);
        yList.add(1.3);
        yList.add(1.4);
        yList.add(1.5);

        //Hier könnte man auch eine Table erstellen --> wäre dann für Jahresüberblick->PDF drucken geeignet.

        LineChart chart = new LineChart("TestTitel", "Worte", xList, "Werte", yList);
        drawChart(doc, (JFreeChart) chart.getChart(), 210, 350);
        try {
            doc.add(new Paragraph("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));
            doc.add(new Phrase("Test test test Test"));

            writeHeader1("Mehr als nur 1 Seite?", doc);
            for (String a : text) {
                doc.add(new Chunk(a));
                doc.add(new Chunk(" "));
            }
            //doc.add(new Paragraph("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));
            //doc.add(new Paragraph("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));
            writeHeader2("Überschrift 2", doc);
            doc.add(new Paragraph("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));
        } catch (DocumentException ex) {
            Logger.log(Level.SEVERE, Formular.class, ex);
        }
    }
}
