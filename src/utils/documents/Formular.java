/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.documents;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.DefaultFontMapper;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.JFreeChart;
import utils.charts.LineChart;

/**
 *  @author Alexander Kumbeiz & Goran Janosevic
 */
public class Formular extends BaseDoc {

    @Override
    protected void writePDF(Document doc, PdfWriter pdfWrite) {
        try {
            writeHeader1("Testzeile: Header 1", doc);
            writeHeader2("Testzeile: Header 2", doc);

            //http://www.wirelust.com/2008/03/17/creating-an-itext-pdf-with-embedded-jfreechart/
            doc.add(new Paragraph("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));
        } catch (DocumentException ex) {
            //Logger.getLogger(Formular.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*
        // build up the dataset for the char
        XYSeriesCollection dataset = new XYSeriesCollection();
        
        XYSeries series = new XYSeries("XYGraph");
        series.add(1, 1);
        series.add(2, 3);
        series.add(3, 9);
        series.add(4, 11);
        
        dataset.addSeries(series);
        
        // set up the chart
        JFreeChart chart = ChartFactory.createXYLineChart("XY Chart Sample, non default font", // chart title
        "x-axis", // domain axis label
        "y-axis", // range axis label
        dataset, // data
        PlotOrientation.VERTICAL, // orientation
        true, // include legend
        true, // tooltips
        false // urls
        );
        
        // trick to change the default font of the chart
        chart.setTitle(new TextTitle("XY Chart Sample, non default font", new java.awt.Font("Serif", Font.BOLD, 12)));
        chart.setBackgroundPaint(Color.white);
        chart.setBorderPaint(Color.black);
        chart.setBorderStroke(new BasicStroke(1));
        chart.setBorderVisible(true);
         */
        ArrayList<String> xList = new ArrayList<String>();
        ArrayList<Double> yList = new ArrayList<Double>();
        
        xList.add("Null");
        xList.add("Eins");
        xList.add("Zwei");
        xList.add("Drei");
        xList.add("Vier");
        xList.add("Fünf");
        
        
        yList.add(1.0);
        yList.add(1.1);
        yList.add(1.2);
        yList.add(1.3);
        yList.add(1.4);
        yList.add(1.5);
        
        LineChart chart = new LineChart("TestTitel", "Worte", xList, "Werte", yList);
        //JFreeChart realChart = (JFreeChart) chart.getChart();
        
        drawChart(doc, (JFreeChart) chart.getChart(), 210, 350);
        //int width = 300;
        //int height = 160;
        try {
            doc.add(new Paragraph("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));
            doc.add(new Phrase("Test test test Test"));
        } catch (DocumentException ex) {
            //Logger.getLogger(Formular.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("FERTIG; BRUDDAAAAA!");

    }
}
