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

import controller.Binder;
import controller.BinderProperty;
import java.awt.Frame;
import java.util.ArrayList;
import model.Kontakt;
import view.AbstractViewDialog;

/**
 *
 * @author Goran-Goggy
 */
public class KontaktAddForm extends AbstractViewDialog {

    /** Creates new form KontaktAddForm */
    public KontaktAddForm(Frame parent, boolean modal) {
        super(parent, modal);
        //this.observer = new ModelObserver();
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
        kontaktAddLabel = new javax.swing.JLabel();
        dialogKontaktKontoNrLabel = new javax.swing.JLabel();
        dialogKontakVorNameLabel = new javax.swing.JLabel();
        dialogKdialogK = new javax.swing.JLabel();
        dialogKontaktEmailLabel = new javax.swing.JLabel();
        dialogKontaktBankInstLabel = new javax.swing.JLabel();
        dialogKontaktBLZNrLabel = new javax.swing.JLabel();
        dialogKontaktEmailFeld = new javax.swing.JTextField();
        dialogKontaktTelefonFeld = new javax.swing.JTextField();
        dialogKontaktBankinstitutFeld = new javax.swing.JTextField();
        dialogKontaktVornameFeld = new javax.swing.JTextField();
        dialogKontaktNachNameLabel = new javax.swing.JLabel();
        dialogKontaktNachnameFeld = new javax.swing.JTextField();
        dialogKontaktStrasseLabel = new javax.swing.JLabel();
        dialogKontaktStrasseFeld = new javax.swing.JTextField();
        dialogKontaktPLZLabel = new javax.swing.JLabel();
        dialogKontakOrtLabel = new javax.swing.JLabel();
        dialogKontaktOrtFeld = new javax.swing.JTextField();
        dialogKontaktFirmaLabel = new javax.swing.JLabel();
        dialogKontaktFirmennameFeld = new javax.swing.JTextField();
        dialogAbbrechen = new javax.swing.JButton();
        dialogKontaktHinzufuegen = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        dialogKontaktStrasseLabel1 = new javax.swing.JLabel();
        dialogKontaktHausnrFeld = new javax.swing.JTextField();
        dialogKontaktBlzFeld = new javax.swing.JTextField();
        dialogKontaktKontoFeld = new javax.swing.JTextField();
        dialogKontaktPlzFeld = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kontaktAddLabel.setFont(new java.awt.Font("Arial", 1, 14));
        kontaktAddLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kontaktAddLabel.setText("Kontakt hinzufügen");
        kontaktAddLabel.setAlignmentX(0.5F);
        jPanel1.add(kontaktAddLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        dialogKontaktKontoNrLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        dialogKontaktKontoNrLabel.setText("Konto-Nr.");
        jPanel1.add(dialogKontaktKontoNrLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, -1, -1));

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
        jPanel1.add(dialogKontaktBankInstLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        dialogKontaktBLZNrLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        dialogKontaktBLZNrLabel.setText("BLZ");
        jPanel1.add(dialogKontaktBLZNrLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, -1, -1));

        dialogKontaktEmailFeld.setName("Email"); // NOI18N
        dialogKontaktEmailFeld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dialogKontaktEmailFeldActionPerformed(evt);
            }
        });
        jPanel1.add(dialogKontaktEmailFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 150, -1));

        dialogKontaktTelefonFeld.setName("Telefon"); // NOI18N
        jPanel1.add(dialogKontaktTelefonFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 150, -1));

        dialogKontaktBankinstitutFeld.setName("Bankinstitut"); // NOI18N
        jPanel1.add(dialogKontaktBankinstitutFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 150, -1));

        dialogKontaktVornameFeld.setName("Vorname"); // NOI18N
        dialogKontaktVornameFeld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dialogKontaktVornameFeldActionPerformed(evt);
            }
        });
        jPanel1.add(dialogKontaktVornameFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 150, -1));

        dialogKontaktNachNameLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        dialogKontaktNachNameLabel.setText("Nachname");
        jPanel1.add(dialogKontaktNachNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, -1, -1));

        dialogKontaktNachnameFeld.setName("Nachname"); // NOI18N
        dialogKontaktNachnameFeld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dialogKontaktNachnameFeldActionPerformed(evt);
            }
        });
        jPanel1.add(dialogKontaktNachnameFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 50, 150, -1));

        dialogKontaktStrasseLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        dialogKontaktStrasseLabel.setText("Straße");
        jPanel1.add(dialogKontaktStrasseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        dialogKontaktStrasseFeld.setName("Strasse"); // NOI18N
        jPanel1.add(dialogKontaktStrasseFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 150, -1));

        dialogKontaktPLZLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        dialogKontaktPLZLabel.setText("PLZ");
        jPanel1.add(dialogKontaktPLZLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 170, -1, -1));

        dialogKontakOrtLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        dialogKontakOrtLabel.setText("Ort");
        jPanel1.add(dialogKontakOrtLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        dialogKontaktOrtFeld.setName("Ort"); // NOI18N
        dialogKontaktOrtFeld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dialogKontaktOrtFeldActionPerformed(evt);
            }
        });
        jPanel1.add(dialogKontaktOrtFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 150, -1));

        dialogKontaktFirmaLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        dialogKontaktFirmaLabel.setText("Firma");
        jPanel1.add(dialogKontaktFirmaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        dialogKontaktFirmennameFeld.setName("Firmenname"); // NOI18N
        dialogKontaktFirmennameFeld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dialogKontaktFirmennameFeldActionPerformed(evt);
            }
        });
        jPanel1.add(dialogKontaktFirmennameFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 150, -1));

        dialogAbbrechen.setText("Abbrechen");
        dialogAbbrechen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dialogAbbrechenActionPerformed(evt);
            }
        });
        jPanel1.add(dialogAbbrechen, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 250, 230, -1));

        dialogKontaktHinzufuegen.setText("Kontakt hinzufügen");
        dialogKontaktHinzufuegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dialogKontaktHinzufuegenActionPerformed(evt);
            }
        });
        jPanel1.add(dialogKontaktHinzufuegen, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 230, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 770, 10));

        dialogKontaktStrasseLabel1.setFont(new java.awt.Font("Tahoma", 0, 15));
        dialogKontaktStrasseLabel1.setText("Hausnr.");
        jPanel1.add(dialogKontaktStrasseLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, -1, -1));

        dialogKontaktHausnrFeld.setName("Hausnr"); // NOI18N
        jPanel1.add(dialogKontaktHausnrFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, 150, -1));

        dialogKontaktBlzFeld.setName("Blz"); // NOI18N
        jPanel1.add(dialogKontaktBlzFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, 150, -1));

        dialogKontaktKontoFeld.setName("Konto"); // NOI18N
        jPanel1.add(dialogKontaktKontoFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 130, 150, -1));

        dialogKontaktPlzFeld.setName("Plz"); // NOI18N
        jPanel1.add(dialogKontaktPlzFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 170, 150, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 290));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dialogKontaktEmailFeldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialogKontaktEmailFeldActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_dialogKontaktEmailFeldActionPerformed

    private void dialogKontaktVornameFeldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialogKontaktVornameFeldActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_dialogKontaktVornameFeldActionPerformed

    private void dialogKontaktNachnameFeldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialogKontaktNachnameFeldActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_dialogKontaktNachnameFeldActionPerformed

    private void dialogKontaktOrtFeldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialogKontaktOrtFeldActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_dialogKontaktOrtFeldActionPerformed

    private void dialogKontaktFirmennameFeldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialogKontaktFirmennameFeldActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_dialogKontaktFirmennameFeldActionPerformed

    private void dialogAbbrechenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialogAbbrechenActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_dialogAbbrechenActionPerformed

    private void dialogKontaktHinzufuegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialogKontaktHinzufuegenActionPerformed
        ArrayList<String> errorList;
        errorList = Binder.save(Kontakt.class, createBinderPropertiesFromFields());
        showErrors(errorList);
    }//GEN-LAST:event_dialogKontaktHinzufuegenActionPerformed

    private ArrayList<BinderProperty> createBinderPropertiesFromFields() {
        ArrayList list = new ArrayList<BinderProperty>();

        list.add(new BinderProperty(dialogKontaktStrasseFeld.getName(), dialogKontaktStrasseFeld.getText(), String.class));
        list.add(new BinderProperty(dialogKontaktHausnrFeld.getName(), dialogKontaktHausnrFeld.getText(), Integer.class));
        list.add(new BinderProperty(dialogKontaktPlzFeld.getName(), dialogKontaktPlzFeld.getText(), Integer.class));
        list.add(new BinderProperty(dialogKontaktOrtFeld.getName(), dialogKontaktOrtFeld.getText(), String.class));
        list.add(new BinderProperty(dialogKontaktBankinstitutFeld.getName(), dialogKontaktBankinstitutFeld.getText(), String.class));
        list.add(new BinderProperty(dialogKontaktBlzFeld.getName(), dialogKontaktBlzFeld.getText(), Integer.class));
        list.add(new BinderProperty(dialogKontaktEmailFeld.getName(), dialogKontaktEmailFeld.getText(), String.class));
        list.add(new BinderProperty(dialogKontaktFirmennameFeld.getName(), dialogKontaktFirmennameFeld.getText(), String.class));
        list.add(new BinderProperty("IsKunde", null, Boolean.class));
        list.add(new BinderProperty(dialogKontaktKontoFeld.getName(), dialogKontaktKontoFeld.getText(), Long.class));
        list.add(new BinderProperty(dialogKontaktNachnameFeld.getName(), dialogKontaktNachnameFeld.getText(), String.class));
        list.add(new BinderProperty(dialogKontaktVornameFeld.getName(), dialogKontaktVornameFeld.getText(), String.class));
        list.add(new BinderProperty(dialogKontaktTelefonFeld.getName(), dialogKontaktTelefonFeld.getText(), String.class));
        list.add(new BinderProperty("Id", null, Integer.class));
        return list;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dialogAbbrechen;
    private javax.swing.JLabel dialogKdialogK;
    private javax.swing.JLabel dialogKontakOrtLabel;
    private javax.swing.JLabel dialogKontakVorNameLabel;
    private javax.swing.JLabel dialogKontaktBLZNrLabel;
    private javax.swing.JLabel dialogKontaktBankInstLabel;
    private javax.swing.JTextField dialogKontaktBankinstitutFeld;
    private javax.swing.JTextField dialogKontaktBlzFeld;
    private javax.swing.JTextField dialogKontaktEmailFeld;
    private javax.swing.JLabel dialogKontaktEmailLabel;
    private javax.swing.JLabel dialogKontaktFirmaLabel;
    private javax.swing.JTextField dialogKontaktFirmennameFeld;
    private javax.swing.JTextField dialogKontaktHausnrFeld;
    private javax.swing.JButton dialogKontaktHinzufuegen;
    private javax.swing.JTextField dialogKontaktKontoFeld;
    private javax.swing.JLabel dialogKontaktKontoNrLabel;
    private javax.swing.JLabel dialogKontaktNachNameLabel;
    private javax.swing.JTextField dialogKontaktNachnameFeld;
    private javax.swing.JTextField dialogKontaktOrtFeld;
    private javax.swing.JLabel dialogKontaktPLZLabel;
    private javax.swing.JTextField dialogKontaktPlzFeld;
    private javax.swing.JTextField dialogKontaktStrasseFeld;
    private javax.swing.JLabel dialogKontaktStrasseLabel;
    private javax.swing.JLabel dialogKontaktStrasseLabel1;
    private javax.swing.JTextField dialogKontaktTelefonFeld;
    private javax.swing.JTextField dialogKontaktVornameFeld;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel kontaktAddLabel;
    // End of variables declaration//GEN-END:variables
}
