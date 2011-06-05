/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.documents;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import utils.log.Logger;

/**
 *
 * @author Goran-Goggy
 */
public class StatistikPDF extends BaseDoc {

    private ArrayList<String> ausgang;
    private ArrayList<String> eingang;
    private String monat;
    private String erloes;

    public StatistikPDF(String month, ArrayList<String> out, ArrayList<String> in, String outcome) {
        this.ausgang = out;
        this.eingang = in;
        this.monat = month;
        this.erloes = outcome;
    }

    @Override
    protected void writePDF(Document doc, PdfWriter pdfWrite) {
        sethTopLeft("Statistikauszug");
        setfBottomLeft("Erstellt mit EPU_Office 2011");
        writeHeader1("Betroffener Monat: " + monat, doc);
        try {
            doc.add(new Paragraph("Auflistung aller Ausgangs- bzw. Eingangsrechnungen"));
        } catch (DocumentException ex) {
            Logger.log(Level.SEVERE, StatistikPDF.class, ex);
        }
        drawTable(doc, monat, ausgang, eingang, erloes);
        writeHeader2("Erwirtschafter Erlös dieses Monats: " + erloes + "€", doc);
    }
}
