/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.documents;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.DefaultFontMapper;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import utils.log.Logger;
import org.jfree.chart.JFreeChart;

/**
 *  Hier wird das Grundlayout der zu erstellenden PDF-Dokumente erstellt.
 *  @author Alexander Kumbeiz & Goran Janosevic
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
    // Leseobjekt (PDF)
    private PdfReader reader;
    // Stempelobjekt (PDF)
    PdfStamper stamper;

    public void createPDF(String fileName) {
        String newFileName = "docs\\" +fileName;
        dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Document doc = new Document(PageSize.A4, 36, 36, 54, 36);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            pdfWrite = PdfWriter.getInstance(doc, baos);
        } catch (DocumentException ex) {
            Logger.log(Level.SEVERE, BaseDoc.class, ex);
        }
        doc.open();
        writePDF(doc, pdfWrite);
        doc.close();
        printHeaderFooter(baos, fileName);
    }

    private void printHeaderFooter(ByteArrayOutputStream baos, String fileName) {
        try {
            reader = new PdfReader(baos.toByteArray());
        } catch (IOException ex) {
            Logger.log(Level.SEVERE, BaseDoc.class, ex);
        }

        try {
            stamper = new PdfStamper(reader, new FileOutputStream(fileName));
        } catch (DocumentException ex) {
            Logger.log(Level.SEVERE, BaseDoc.class, ex);
        } catch (IOException ex) {
            Logger.log(Level.SEVERE, BaseDoc.class, ex);
        }
        // Loop over the pages and add a header to each page
        int n = reader.getNumberOfPages();
        for (int i = 1; i <= n; i++) {
            getHeaderTable().writeSelectedRows(0, -1, 34, 835, stamper.getOverContent(i));
            getFooterTable(i).writeSelectedRows(0, -1, 34, 50, stamper.getOverContent(i));
        }
        try {
            // Close the stamper
            stamper.close();
        } catch (DocumentException ex) {
            Logger.log(Level.SEVERE, BaseDoc.class, ex);
        } catch (IOException ex) {
            Logger.log(Level.SEVERE, BaseDoc.class, ex);
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

    protected abstract void writePDF(Document doc, PdfWriter pdfWrite);

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

    public void writeHeader1(String text, Document doc) {
        try {
            //doc.add(Chunk.NEWLINE);
            doc.add(Chunk.NEWLINE);
        } catch (DocumentException ex) {
            Logger.log(Level.SEVERE, BaseDoc.class, ex);
        }
        Paragraph paragraph = new Paragraph("");
        Chunk chunk = new Chunk(text,
                FontFactory.getFont(FontFactory.HELVETICA, 16, Font.UNDERLINE | Font.BOLD)); //| Font.ITALIC
        try {
            //doc.add(chunk
            paragraph.add(chunk);
            paragraph.setAlignment(Element.ALIGN_JUSTIFIED);
            doc.add(paragraph);
            //doc.add(Chunk.NEWLINE);
        } catch (DocumentException ex) {
            Logger.log(Level.SEVERE, BaseDoc.class, ex);
        }
    }

    public void writeHeader2(String text, Document doc) {
        try {
            //doc.add(Chunk.NEWLINE);
            doc.add(Chunk.NEWLINE);
        } catch (DocumentException ex) {
            Logger.log(Level.SEVERE, BaseDoc.class, ex);
        }
        Paragraph paragraph = new Paragraph("");
        Chunk chunk = new Chunk(text,
                FontFactory.getFont(FontFactory.HELVETICA, 14, Font.UNDERLINE | Font.BOLD)); //| Font.ITALIC
        try {
            //doc.add(chunk
            paragraph.add(chunk);
            paragraph.setAlignment(Element.ALIGN_JUSTIFIED);
            doc.add(paragraph);
            //doc.add(Chunk.NEWLINE);
        } catch (DocumentException ex) {
            Logger.log(Level.SEVERE, BaseDoc.class, ex);
        }
    }

    public void drawChart(Document doc, JFreeChart chart, int height, int width) {
        // get the direct pdf content
        PdfContentByte dc = pdfWrite.getDirectContent();
        // get a pdf template from the direct content
        PdfTemplate tp = dc.createTemplate(width, height);

        Image chartPic = null;
        try {
            chartPic = Image.getInstance(tp);
            chartPic.setAlignment(Element.ALIGN_CENTER);
        } catch (BadElementException ex) {
            Logger.log(Level.SEVERE, BaseDoc.class, ex);
        }

        // AWT Renderer erzeugen (aud dem PdfTemplate)
        Graphics2D g2 = tp.createGraphics(width, height, new DefaultFontMapper());
        Rectangle2D r2D = new Rectangle2D.Double(0, 0, width, height);
        chart.draw(g2, r2D);
        g2.dispose();
        try {
            doc.add(chartPic);
        } catch (DocumentException ex) {
            Logger.log(Level.SEVERE, BaseDoc.class, ex);
        }


    }

    public void drawTable(Document doc,String month, ArrayList<String> out, ArrayList<String> in, String outcome) {
        //http://www.java-examples.com/java-stringtokenizer---specify-delimiter-example
        //http://www.geek-tutorials.com/java/itext/itext_table.php
        PdfPTable table = new PdfPTable(2);
        PdfPCell cell = new PdfPCell();
        cell.setBorder(0);
        table.setSpacingBefore(20);
        table.setSpacingAfter(20);
        table.setWidthPercentage(100);
        table.getDefaultCell().setBackgroundColor(BaseColor.LIGHT_GRAY);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell("Ausgangsrechnungen");
        table.addCell("Eingangsrechnungen");
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_BASELINE);
        table.getDefaultCell().setBackgroundColor(null);
        //System.out.println("Size beraegt jetzt noch: " + out.size() + " und " + in.size());
        if(!(out.size() == in.size())){
            if(out.size() > in.size()){
                while(!(out.size() == in.size())){
                    in.add(" ");
                }
            } else {
                while(!(out.size() == in.size())){
                    out.add(" ");
                }
            }
        }
        //System.out.println("Size beraegt: " + out.size() + " und " + in.size());

        for(int i = 0; i < out.size(); i++){
            table.addCell(out.get(i));
            table.addCell(in.get(i));
        }
//        for (String s : row) {
//            st = new StringTokenizer(s, ";");
//            while (st.hasMoreTokens()) {
//                table.addCell(st.nextToken());
//                //System.out.println(st.nextToken());
//            }
//        }
        try {
            doc.add(table);
            System.out.println("Done");
        } catch (DocumentException ex) {
            Logger.log(Level.SEVERE, BaseDoc.class, ex);
        }
    }
    
}
