/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * KontaktAddForm.java
 *
 * Created on 13.04.2011, 03:42:56
 */
package view.dialog;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Kontakt;
import model.bl.KontaktLogic;
import model.dal.DALException;
import model.dal.DALFactory;

/**
 *
 * @author Goran-Goggy
 */
public class KontaktAddForm extends javax.swing.JDialog {

    /** Creates new form KontaktAddForm */
    public KontaktAddForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
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
        kontaktAddLabel = new javax.swing.JLabel();
        dialogKontaktKontoNrLabel = new javax.swing.JLabel();
        dialogKontakVorNameLabel = new javax.swing.JLabel();
        dialogKdialogK = new javax.swing.JLabel();
        dialogKontaktEmailLabel = new javax.swing.JLabel();
        dialogKontaktBankInstLabel = new javax.swing.JLabel();
        dialogKontaktBLZNrLabel = new javax.swing.JLabel();
        dialogKontaktNameFeld = new javax.swing.JTextField();
        dialogKontaktTelFeld = new javax.swing.JTextField();
        dialogKontaktBankInstFeld = new javax.swing.JTextField();
        dialogKontaktBLZNrFeld = new javax.swing.JFormattedTextField();
        dialogKontaktKontoNrFeld = new javax.swing.JFormattedTextField();
        dialogKontaktVorNameFeld = new javax.swing.JTextField();
        dialogKontaktNachNameLabel = new javax.swing.JLabel();
        dialogKontaktNachNameFeld = new javax.swing.JTextField();
        dialogKontaktStrasseLabel = new javax.swing.JLabel();
        dialogKontaktAdresseFeld = new javax.swing.JTextField();
        dialogKontaktTuerNrLabel = new javax.swing.JLabel();
        dialogKontaktPLZLabel = new javax.swing.JLabel();
        dialogKontaktPLZFeld = new javax.swing.JFormattedTextField();
        dialogKontakOrtLabel = new javax.swing.JLabel();
        dialogKontaktOrtFeld = new javax.swing.JTextField();
        dialogKontaktBlzFeld = new javax.swing.JFormattedTextField();
        dialogKontaktFirmaLabel = new javax.swing.JLabel();
        dialogKontaktFirmaFeld = new javax.swing.JTextField();
        dialogAbbrechen = new javax.swing.JButton();
        dialogKontaktHinzufuegen = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kontaktAddLabel.setFont(new java.awt.Font("Arial", 1, 18));
        kontaktAddLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kontaktAddLabel.setText("Kontakt hinzufügen");
        kontaktAddLabel.setAlignmentX(0.5F);
        jPanel1.add(kontaktAddLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

        dialogKontaktKontoNrLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        dialogKontaktKontoNrLabel.setText("Konto-Nr.");
        jPanel1.add(dialogKontaktKontoNrLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 140, -1, -1));

        dialogKontakVorNameLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        dialogKontakVorNameLabel.setText("Vorname");
        jPanel1.add(dialogKontakVorNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, -1, -1));

        dialogKdialogK.setFont(new java.awt.Font("Tahoma", 0, 15));
        dialogKdialogK.setText("Telefon-Nr.");
        jPanel1.add(dialogKdialogK, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        dialogKontaktEmailLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        dialogKontaktEmailLabel.setText("Email");
        jPanel1.add(dialogKontaktEmailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, -1, -1));

        dialogKontaktBankInstLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        dialogKontaktBankInstLabel.setText("Bankinst.");
        jPanel1.add(dialogKontaktBankInstLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        dialogKontaktBLZNrLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        dialogKontaktBLZNrLabel.setText("BLZ-Nr.");
        jPanel1.add(dialogKontaktBLZNrLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, -1, -1));

        dialogKontaktNameFeld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dialogKontaktNameFeldActionPerformed(evt);
            }
        });
        jPanel1.add(dialogKontaktNameFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 150, -1));
        jPanel1.add(dialogKontaktTelFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 150, -1));
        jPanel1.add(dialogKontaktBankInstFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 150, -1));

        try {
            dialogKontaktBLZNrFeld.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(dialogKontaktBLZNrFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, 150, -1));

        try {
            dialogKontaktKontoNrFeld.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(dialogKontaktKontoNrFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 140, 150, -1));

        dialogKontaktVorNameFeld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dialogKontaktVorNameFeldActionPerformed(evt);
            }
        });
        jPanel1.add(dialogKontaktVorNameFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 150, -1));

        dialogKontaktNachNameLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        dialogKontaktNachNameLabel.setText("Nachname");
        jPanel1.add(dialogKontaktNachNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, -1, -1));

        dialogKontaktNachNameFeld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dialogKontaktNachNameFeldActionPerformed(evt);
            }
        });
        jPanel1.add(dialogKontaktNachNameFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 50, 150, -1));

        dialogKontaktStrasseLabel.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        dialogKontaktStrasseLabel.setText("Straße");
        jPanel1.add(dialogKontaktStrasseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));
        jPanel1.add(dialogKontaktAdresseFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 150, -1));

        dialogKontaktTuerNrLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        dialogKontaktTuerNrLabel.setText("Tür-Nr.");
        jPanel1.add(dialogKontaktTuerNrLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, -1, -1));

        dialogKontaktPLZLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        dialogKontaktPLZLabel.setText("PLZ");
        jPanel1.add(dialogKontaktPLZLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 190, -1, -1));

        try {
            dialogKontaktPLZFeld.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(dialogKontaktPLZFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 190, 150, -1));

        dialogKontakOrtLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        dialogKontakOrtLabel.setText("Ort");
        jPanel1.add(dialogKontakOrtLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        dialogKontaktOrtFeld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dialogKontaktOrtFeldActionPerformed(evt);
            }
        });
        jPanel1.add(dialogKontaktOrtFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 150, -1));

        try {
            dialogKontaktBlzFeld.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(dialogKontaktBlzFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 150, -1));

        dialogKontaktFirmaLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        dialogKontaktFirmaLabel.setText("Firma");
        jPanel1.add(dialogKontaktFirmaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        dialogKontaktFirmaFeld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dialogKontaktFirmaFeldActionPerformed(evt);
            }
        });
        jPanel1.add(dialogKontaktFirmaFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 150, -1));

        dialogAbbrechen.setText("Abbrechen");
        dialogAbbrechen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dialogAbbrechenActionPerformed(evt);
            }
        });
        jPanel1.add(dialogAbbrechen, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 270, 230, -1));

        dialogKontaktHinzufuegen.setText("Kontakt hinzufügen");
        dialogKontaktHinzufuegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dialogKontaktHinzufuegenActionPerformed(evt);
            }
        });
        jPanel1.add(dialogKontaktHinzufuegen, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 230, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 262, 770, 10));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dialogKontaktNameFeldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialogKontaktNameFeldActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_dialogKontaktNameFeldActionPerformed

    private void dialogKontaktVorNameFeldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialogKontaktVorNameFeldActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_dialogKontaktVorNameFeldActionPerformed

    private void dialogKontaktNachNameFeldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialogKontaktNachNameFeldActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_dialogKontaktNachNameFeldActionPerformed

    private void dialogKontaktOrtFeldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialogKontaktOrtFeldActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_dialogKontaktOrtFeldActionPerformed

    private void dialogKontaktFirmaFeldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialogKontaktFirmaFeldActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_dialogKontaktFirmaFeldActionPerformed

    private void dialogAbbrechenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialogAbbrechenActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_dialogAbbrechenActionPerformed

    private void dialogKontaktHinzufuegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialogKontaktHinzufuegenActionPerformed
        Kontakt k = new Kontakt();
        k.setAdresse(dialogKontaktAdresseFeld.getText());
        k.setBankinstitut(dialogKontaktBankInstFeld.getText());
        //k.setBlz(Integer.getInteger(dialogKontaktBlzFeld.getText()));
        k.setEmail(dialogKontaktEmailLabel.getText());
        k.setFirmenname(dialogKontaktFirmaFeld.getText());
        k.setIsKunde(false);
        //k.setKonto(Long.getLong(dialogKontaktKontoNrFeld.getText()));
        k.setNachname(dialogKontaktNachNameFeld.getText());
        k.setTelefon(dialogKontaktTelFeld.getText());
        k.setVorname(dialogKontaktVorNameFeld.getText());
        ArrayList<String> errorList = KontaktLogic.check(k);
        if(errorList == null || errorList.size() == 0) {
            try {
                DALFactory.getDAL().saveKontakt(k);
                System.out.println(k.getId() + " ID haha");
            } catch (DALException ex) {
                Logger.getLogger(KontaktAddForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_dialogKontaktHinzufuegenActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                KontaktAddForm dialog = new KontaktAddForm(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton dialogAbbrechen;
    private javax.swing.JLabel dialogKdialogK;
    private javax.swing.JLabel dialogKontakOrtLabel;
    private javax.swing.JLabel dialogKontakVorNameLabel;
    private javax.swing.JTextField dialogKontaktAdresseFeld;
    private javax.swing.JFormattedTextField dialogKontaktBLZNrFeld;
    private javax.swing.JLabel dialogKontaktBLZNrLabel;
    private javax.swing.JTextField dialogKontaktBankInstFeld;
    private javax.swing.JLabel dialogKontaktBankInstLabel;
    private javax.swing.JFormattedTextField dialogKontaktBlzFeld;
    private javax.swing.JLabel dialogKontaktEmailLabel;
    private javax.swing.JTextField dialogKontaktFirmaFeld;
    private javax.swing.JLabel dialogKontaktFirmaLabel;
    private javax.swing.JButton dialogKontaktHinzufuegen;
    private javax.swing.JFormattedTextField dialogKontaktKontoNrFeld;
    private javax.swing.JLabel dialogKontaktKontoNrLabel;
    private javax.swing.JTextField dialogKontaktNachNameFeld;
    private javax.swing.JLabel dialogKontaktNachNameLabel;
    private javax.swing.JTextField dialogKontaktNameFeld;
    private javax.swing.JTextField dialogKontaktOrtFeld;
    private javax.swing.JFormattedTextField dialogKontaktPLZFeld;
    private javax.swing.JLabel dialogKontaktPLZLabel;
    private javax.swing.JLabel dialogKontaktStrasseLabel;
    private javax.swing.JTextField dialogKontaktTelFeld;
    private javax.swing.JLabel dialogKontaktTuerNrLabel;
    private javax.swing.JTextField dialogKontaktVorNameFeld;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel kontaktAddLabel;
    // End of variables declaration//GEN-END:variables
}
