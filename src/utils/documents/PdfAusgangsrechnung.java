/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.documents;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.ArrayList;

/**
 *
 * @author Goran-Goggy
 */
public class PdfAusgangsrechnung extends BaseDoc {
    
    private ArrayList<String> spalte1 = null;
    private ArrayList<String> spalte2 = null;
    private ArrayList<String> spalte3 = null;
    private ArrayList<String> cellHeader = null;
    private String kundenHeader = "";
    private String preisAngabe = "";
    
    public PdfAusgangsrechnung(ArrayList<String> cellHeader, ArrayList<String> spalte1, ArrayList<String> spalte2, ArrayList<String> spalte3, String header, String preis) {
        this.spalte1 = spalte1;
        this.spalte2 = spalte2;
        this.spalte3 = spalte3;
        this.cellHeader = cellHeader;
        
        this.kundenHeader = header;
        this.preisAngabe = preis;
        
    }
    
    @Override
    protected void writePDF(Document doc, PdfWriter pdfWrite) {
        writeHeader1("Ausgangsrechnung, betreffend " + kundenHeader, doc);
        drawTable(doc, cellHeader, spalte1, spalte2, spalte3);
        writeHeader2("Preis: " + preisAngabe, doc);
    }
}
