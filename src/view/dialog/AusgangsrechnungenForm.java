/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EingangsrechnungenForm.java
 *
 * Created on 09.06.2011, 00:55:50
 */
package view.dialog;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import utils.log.Logger;
import utils.documents.PdfAusgangsrechnung;
import view.StatistikView;

/**
 *
 * @author Goran-Goggy
 */
public class AusgangsrechnungenForm extends javax.swing.JDialog {

    /** Creates new form EingangsrechnungenForm */
    public AusgangsrechnungenForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        eingangLabel = new javax.swing.JLabel();
        dialogKontaktDatumLabel = new javax.swing.JLabel();
        dialogKontaktPreisLabel = new javax.swing.JLabel();
        dialogEingangPreisLabel = new javax.swing.JTextField();
        dialogAusgangAngebotLabel = new javax.swing.JLabel();
        dialogKontaktNameLabel = new javax.swing.JLabel();
        dialogPdfErstellen = new javax.swing.JButton();
        dialogEingangHinzufuegen = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        dialogAusgabeNameCheckbox = new javax.swing.JComboBox();
        dialogAusgangDatumFeld = new com.toedter.calendar.JDateChooser();
        dialogAusgangAngebotCheckbox = new javax.swing.JComboBox();
        dialogAbbrechen1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        eingangLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        eingangLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eingangLabel.setText("Ausgangsrechnung erstellen");
        eingangLabel.setAlignmentX(0.5F);
        jPanel1.add(eingangLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        dialogKontaktDatumLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        dialogKontaktDatumLabel.setText("Datum");
        jPanel1.add(dialogKontaktDatumLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        dialogKontaktPreisLabel.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        dialogKontaktPreisLabel.setText("Preis");
        jPanel1.add(dialogKontaktPreisLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, -1, -1));

        dialogEingangPreisLabel.setName("Bankinstitut"); // NOI18N
        jPanel1.add(dialogEingangPreisLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 150, -1));

        dialogAusgangAngebotLabel.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        dialogAusgangAngebotLabel.setText("Angebot");
        jPanel1.add(dialogAusgangAngebotLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, -1, -1));

        dialogKontaktNameLabel.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        dialogKontaktNameLabel.setText("Kunde");
        jPanel1.add(dialogKontaktNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        dialogPdfErstellen.setText("PDF erstellen");
        dialogPdfErstellen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dialogPdfErstellenActionPerformed(evt);
            }
        });
        jPanel1.add(dialogPdfErstellen, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 160, -1));

        dialogEingangHinzufuegen.setText("Rechnung erstellen");
        dialogEingangHinzufuegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dialogEingangHinzufuegenActionPerformed(evt);
            }
        });
        jPanel1.add(dialogEingangHinzufuegen, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 160, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 500, 10));

        dialogAusgabeNameCheckbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(dialogAusgabeNameCheckbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 150, -1));
        jPanel1.add(dialogAusgangDatumFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 150, -1));

        dialogAusgangAngebotCheckbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(dialogAusgangAngebotCheckbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 150, -1));

        dialogAbbrechen1.setText("Abbrechen");
        dialogAbbrechen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dialogAbbrechen1ActionPerformed(evt);
            }
        });
        jPanel1.add(dialogAbbrechen1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 160, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 180));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dialogPdfErstellenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialogPdfErstellenActionPerformed
        // TODO add your handling code here:
        ArrayList<String> cellHeader = new ArrayList<String>();
        cellHeader.add("Bestellungsdatum");
        cellHeader.add("Angebot");
        cellHeader.add("Implementierungsdauer");
        
        ArrayList<String> spalte1 = new ArrayList<String>();
        spalte1.add("2006-05-31");
        
        ArrayList<String> spalte2 = new ArrayList<String>();
        spalte2.add("Angebot XXL");
        
        ArrayList<String> spalte3 = new ArrayList<String>();
        spalte3.add("400 Tage");
        
        String kunde = "Max Mustermann";
        String preisAngabe = "3000 €";
        
        String fileName = "Ausgangsrechnung.pdf";
        PdfAusgangsrechnung pdfAusgangsrechnung = new PdfAusgangsrechnung(cellHeader, spalte1, spalte2, spalte3, kunde, preisAngabe);
        pdfAusgangsrechnung.createPDF(fileName);
        
        Desktop d = Desktop.getDesktop();
        try {
            d.open(new File(pdfAusgangsrechnung.getPfad()+fileName));
        } catch (IOException ex) {
            Logger.log(Level.SEVERE, AusgangsrechnungenForm.class, ex);
        }
}//GEN-LAST:event_dialogPdfErstellenActionPerformed

    private void dialogEingangHinzufuegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialogEingangHinzufuegenActionPerformed
}//GEN-LAST:event_dialogEingangHinzufuegenActionPerformed

    private void dialogAbbrechen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialogAbbrechen1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_dialogAbbrechen1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                AusgangsrechnungenForm dialog = new AusgangsrechnungenForm(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dialogAbbrechen1;
    private javax.swing.JComboBox dialogAusgabeNameCheckbox;
    private javax.swing.JComboBox dialogAusgangAngebotCheckbox;
    private javax.swing.JLabel dialogAusgangAngebotLabel;
    private com.toedter.calendar.JDateChooser dialogAusgangDatumFeld;
    private javax.swing.JButton dialogEingangHinzufuegen;
    private javax.swing.JTextField dialogEingangPreisLabel;
    private javax.swing.JLabel dialogKontaktDatumLabel;
    private javax.swing.JLabel dialogKontaktNameLabel;
    private javax.swing.JLabel dialogKontaktPreisLabel;
    private javax.swing.JButton dialogPdfErstellen;
    private javax.swing.JLabel eingangLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
