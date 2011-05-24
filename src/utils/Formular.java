/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Goran-Goggy
 */
public class Formular extends BaseDoc {

    @Override
    protected void writePDF(Document doc) {
        int x = 0;
        while (x < 100) {
            try {
                doc.add(new Paragraph("Hello Goggy."));
                x++;
            } catch (DocumentException ex) {
                //Logger.getLogger(Formular.class.getName()).log(Level.SEVERE, null, ex);
            }
            //inserting specific data
            this.sethTopLeft("PDF-PREVIEW");
            this.sethTopCenter("Goran'se best!");
        }
        System.out.println("Fertig");
    }
}
