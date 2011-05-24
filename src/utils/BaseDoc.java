/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexander Kumbeiz
 * @author Goran Janosevic
 */
public abstract class BaseDoc {

    protected String fileName;
    private Date now = new Date();
    protected SimpleDateFormat dateFormat;
    protected PdfWriter pdfWrite;
    protected StringBuilder printedDate;
    //Header 
    /* ----------------
     * | TL | TC | TR |
     * | BL | BC | BR |
     * ----------------
     */
    private String hTopLeft = "HEAD: TOP LEFT";
    private String hTopCenter = "HEAD: TOP CENTER";
    private String hTopRight = "HEAD: TOP RIGHT";
    private String hBottomLeft = "HEAD: BOTTOM LEFT";
    private String hBottomCenter = "HEAD: BOTTOM CENTER";
    private String hBottomRight = "HEAD: BOTTOM RIGHT";
    //Footer
    /* ----------------
     * | TL | TC | TR |
     * | BL | BC | BR |
     * ----------------
     */
    private String fTopLeft = "FOOT: TOP LEFT";
    private String fTopCenter = "FOOT: TOP CENTER";
    private String fTopRight = "FOOT: TOP RIGHT";
    private String fBottomLeft = "FOOT: BOTTOM LEFT";
    private String fBottomCenter = "FOOT: BOTTOM CENTER";
    private String fBottomRight = "FOOT: BOTTOM RIGHT";
    //private Rectangle box = new Rectangle(50, 500, 690, 150);
    // Create a reader
    private PdfReader reader;
    // Create a stamper
    PdfStamper stamper;

    public void createPDF(String fileName) {
        dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Document doc = new Document(PageSize.A4, 36, 36, 54, 36);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {
            pdfWrite = PdfWriter.getInstance(doc, baos);
        } catch (DocumentException ex) {
            //Logger.getLogger(BaseDoc.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace(System.err);
        }
        doc.open();
        writePDF(doc);
        doc.close();

        printHeaderFooter(baos, fileName);
    }

    private void printHeaderFooter(ByteArrayOutputStream baos, String fileName) {
        try {
            reader = new PdfReader(baos.toByteArray());
        } catch (IOException ex) {
            Logger.getLogger(BaseDoc.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            stamper = new PdfStamper(reader, new FileOutputStream(fileName));
        } catch (DocumentException ex) {
            Logger.getLogger(BaseDoc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BaseDoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Loop over the pages and add a header to each page
        int n = reader.getNumberOfPages();
        for (int i = 1; i <= n; i++) {
            getHeaderTable().writeSelectedRows(
                    0, -1, 34, 825, stamper.getOverContent(i));
            getFooterTable(i).writeSelectedRows(
                    0, -1, 34, 50, stamper.getOverContent(i));
        }
        try {
            // Close the stamper
            stamper.close();
        } catch (DocumentException ex) {
            Logger.getLogger(BaseDoc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BaseDoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private PdfPTable getHeaderTable() {
        PdfPTable table = new PdfPTable(3);
        printedDate = new StringBuilder(dateFormat.format(now));
        hTopRight = printedDate.toString();
        table.setTotalWidth(528);
        table.setLockedWidth(true);
        table.getDefaultCell().setFixedHeight(80);
        table.setHorizontalAlignment(Element.ALIGN_CENTER);


        PdfPCell topLeft = new PdfPCell(new Paragraph(hTopLeft));
        topLeft.setBorder(0);
        topLeft.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(topLeft);

        PdfPCell topCenter = new PdfPCell(new Paragraph(hTopCenter));
        topCenter.setBorder(0);
        topCenter.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(topCenter);

        PdfPCell topRight = new PdfPCell(new Paragraph(hTopRight));
        topRight.setBorder(0);
        topRight.setHorizontalAlignment(Element.ALIGN_RIGHT);
        table.addCell(topRight);

        PdfPCell bottomLeft = new PdfPCell(new Paragraph(hBottomLeft));
        bottomLeft.setBorder(0);
        bottomLeft.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(bottomLeft);

        PdfPCell bottomCenter = new PdfPCell(new Paragraph(hBottomCenter));
        bottomCenter.setBorder(0);
        bottomCenter.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(bottomCenter);

        PdfPCell bottomRight = new PdfPCell(new Paragraph(hBottomRight));
        bottomRight.setBorder(0);
        bottomRight.setHorizontalAlignment(Element.ALIGN_RIGHT);
        table.addCell(bottomRight);

        return table;
    }

    private PdfPTable getFooterTable(int x) {
        PdfPTable table = new PdfPTable(3);
        table.setTotalWidth(528);
        table.setLockedWidth(true);
        table.getDefaultCell().setFixedHeight(80);
        table.setHorizontalAlignment(Element.ALIGN_CENTER);

        PdfPCell topLeft = new PdfPCell(new Paragraph(fTopLeft));
        topLeft.setBorder(0);
        topLeft.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(topLeft);

        PdfPCell topCenter = new PdfPCell(new Paragraph(fTopCenter));
        topCenter.setBorder(0);
        topCenter.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(topCenter);

        PdfPCell topRight = new PdfPCell(new Paragraph(fTopRight));
        topRight.setBorder(0);
        topRight.setHorizontalAlignment(Element.ALIGN_RIGHT);
        table.addCell(topRight);

        PdfPCell bottomLeft = new PdfPCell(new Paragraph(fBottomLeft));
        bottomLeft.setBorder(0);
        bottomLeft.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(bottomLeft);

        PdfPCell bottomCenter = new PdfPCell(new Paragraph(fBottomCenter));
        bottomCenter.setBorder(0);
        bottomCenter.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(bottomCenter);

        PdfPCell bottomRight = new PdfPCell(new Paragraph(String.format("%d", x)));
        bottomRight.setBorder(0);
        bottomRight.setHorizontalAlignment(Element.ALIGN_RIGHT);
        table.addCell(bottomRight);
        return table;
    }

    protected abstract void writePDF(Document doc);

    public void setfBottomCenter(String fBottomCenter) {
        this.fBottomCenter = fBottomCenter;
    }

    public void setfBottomLeft(String fBottomLeft) {
        this.fBottomLeft = fBottomLeft;
    }

    public void setfTopCenter(String fTopCenter) {
        this.fTopCenter = fTopCenter;
    }

    public void setfTopLeft(String fTopLeft) {
        this.fTopLeft = fTopLeft;
    }

    public void setfTopRight(String fTopRight) {
        this.fTopRight = fTopRight;
    }

    public void sethBottomCenter(String hBottomCenter) {
        this.hBottomCenter = hBottomCenter;
    }

    public void sethBottomLeft(String hBottomLeft) {
        this.hBottomLeft = hBottomLeft;
    }

    public void sethBottomRight(String hBottomRight) {
        this.hBottomRight = hBottomRight;
    }

    public void sethTopCenter(String hTopCenter) {
        this.hTopCenter = hTopCenter;
    }

    public void sethTopLeft(String hTopLeft) {
        this.hTopLeft = hTopLeft;
    }
    
    
}
