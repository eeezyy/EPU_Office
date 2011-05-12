/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Alexander Kumbeiz
 * @author Goran Janosevic
 */
public  class BaseDoc {

    protected String filename;
    private Date now;
    protected SimpleDateFormat dateFormat;
    protected Document doc;
    protected PdfWriter pdfWrite;
    protected StringBuilder printedDate;

    public void createPDF(String fileName) {
        dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        doc = new Document(PageSize.A4);
        try {
            try {
                pdfWrite.getInstance(doc, new FileOutputStream(fileName));
            } catch (DocumentException ex) {
                //Logger.getLogger(BaseDoc.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace(System.err);
            }
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(BaseDoc.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace(System.err);
        }
        doc.open();
        now = new Date();
        printedDate = new StringBuilder(dateFormat.format(now));
        try {
            doc.add(new Paragraph(printedDate.toString()));
            doc.add(new LineSeparator(0.5f, 100, null, 0, -5));
        } catch (DocumentException ex) {
            //Logger.getLogger(BaseDoc.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace(System.err);
        }
        doc.close();
    }

    //protected abstract void writePDF();
}
