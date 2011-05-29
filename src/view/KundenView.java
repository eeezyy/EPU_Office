/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Kunden.java
 *
 * Created on 09.04.2011, 16:39:26
 */
package view;

import controller.KundenController;
import model.dal.DALFactory;
import model.dal.IDAL;

/**
 *
 * @author Goran-Goggy
 */
public class KundenView extends javax.swing.JPanel {

    private KundenController controller;
    private IDAL db = DALFactory.getDAL();

    /** Creates new form Kunden */
    public KundenView(KundenController controller) {
        initComponents();
        this.controller = controller;

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kundenListeLabel = new javax.swing.JLabel();
        kundenInfoLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        kundenListe = new javax.swing.JList();
        kundenVorNameLabel = new javax.swing.JLabel();
        kundenTelLabel = new javax.swing.JLabel();
        kundenEmailLabel = new javax.swing.JLabel();
        kundenEmailFeld = new javax.swing.JTextField();
        kundenTelFeld = new javax.swing.JTextField();
        kundenLoeschen = new javax.swing.JButton();
        kundenVorNameFeld = new javax.swing.JTextField();
        kundenangebotZuweisen = new javax.swing.JButton();
        kundenNachNameLabel = new javax.swing.JLabel();
        kundenNachNameFeld = new javax.swing.JTextField();
        kundenStrasseLabel = new javax.swing.JLabel();
        kundenStrasseFeld = new javax.swing.JTextField();
        kundenTuerNrLabel = new javax.swing.JLabel();
        kundenPLZLabel = new javax.swing.JLabel();
        kundenOrtLabel = new javax.swing.JLabel();
        kundenOrtFeld = new javax.swing.JTextField();
        kundenFirmaLabel = new javax.swing.JLabel();
        kundenFirmaFeld = new javax.swing.JTextField();
        kundenAendern = new javax.swing.JButton();
        kundenPlzFeld = new javax.swing.JTextField();
        kundenBlzNrFeld = new javax.swing.JTextField();

        setMaximumSize(new java.awt.Dimension(572, 380));
        setMinimumSize(new java.awt.Dimension(572, 380));
        setPreferredSize(new java.awt.Dimension(572, 380));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kundenListeLabel.setFont(new java.awt.Font("Arial", 1, 14));
        kundenListeLabel.setText("Kundenliste");
        add(kundenListeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        kundenInfoLabel.setFont(new java.awt.Font("Arial", 1, 14));
        kundenInfoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kundenInfoLabel.setText("Kundeninformation");
        kundenInfoLabel.setAlignmentX(0.5F);
        add(kundenInfoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, -1, -1));

        kundenListe.setFont(new java.awt.Font("Tahoma", 2, 12));
        kundenListe.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Wien Energie", "FH Technikum-Wien", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        kundenListe.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(kundenListe);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 200, 190));

        kundenVorNameLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        kundenVorNameLabel.setText("Vorname");
        add(kundenVorNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, -1, -1));

        kundenTelLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        kundenTelLabel.setText("Telefon-Nr.");
        add(kundenTelLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, -1, -1));

        kundenEmailLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        kundenEmailLabel.setText("Email");
        add(kundenEmailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, -1, -1));

        kundenEmailFeld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kundenEmailFeldActionPerformed(evt);
            }
        });
        add(kundenEmailFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, 150, -1));
        add(kundenTelFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 150, -1));

        kundenLoeschen.setText("Kunden löschen");
        add(kundenLoeschen, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 230, -1));

        kundenVorNameFeld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kundenVorNameFeldActionPerformed(evt);
            }
        });
        add(kundenVorNameFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, 150, -1));

        kundenangebotZuweisen.setText("Angebot zuweisen");
        add(kundenangebotZuweisen, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 200, -1));

        kundenNachNameLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        kundenNachNameLabel.setText("Nachname");
        add(kundenNachNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 40, -1, -1));

        kundenNachNameFeld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kundenNachNameFeldActionPerformed(evt);
            }
        });
        add(kundenNachNameFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 40, 150, -1));

        kundenStrasseLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        kundenStrasseLabel.setText("Straße");
        add(kundenStrasseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, -1, -1));
        add(kundenStrasseFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 150, -1));

        kundenTuerNrLabel.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        kundenTuerNrLabel.setText("Haus-Nr.");
        add(kundenTuerNrLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, -1, -1));

        kundenPLZLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        kundenPLZLabel.setText("PLZ");
        add(kundenPLZLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 120, -1, -1));

        kundenOrtLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        kundenOrtLabel.setText("Ort");
        add(kundenOrtLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, -1, -1));

        kundenOrtFeld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kundenOrtFeldActionPerformed(evt);
            }
        });
        add(kundenOrtFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 150, -1));

        kundenFirmaLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        kundenFirmaLabel.setText("Firma");
        add(kundenFirmaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, -1, -1));

        kundenFirmaFeld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kundenFirmaFeldActionPerformed(evt);
            }
        });
        add(kundenFirmaFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 150, -1));

        kundenAendern.setText("Kunden ändern");
        kundenAendern.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kundenAendernActionPerformed(evt);
            }
        });
        add(kundenAendern, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, 230, -1));
        add(kundenPlzFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 120, 150, -1));
        add(kundenBlzNrFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 120, 150, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void kundenEmailFeldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kundenEmailFeldActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_kundenEmailFeldActionPerformed

    private void kundenVorNameFeldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kundenVorNameFeldActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_kundenVorNameFeldActionPerformed

    private void kundenNachNameFeldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kundenNachNameFeldActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_kundenNachNameFeldActionPerformed

    private void kundenOrtFeldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kundenOrtFeldActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_kundenOrtFeldActionPerformed

    private void kundenFirmaFeldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kundenFirmaFeldActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_kundenFirmaFeldActionPerformed

    private void kundenAendernActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kundenAendernActionPerformed
        // TODO add your handling code here:
        //modelPropertyChange(null);
}//GEN-LAST:event_kundenAendernActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton kundenAendern;
    private javax.swing.JTextField kundenBlzNrFeld;
    private javax.swing.JTextField kundenEmailFeld;
    private javax.swing.JLabel kundenEmailLabel;
    private javax.swing.JTextField kundenFirmaFeld;
    private javax.swing.JLabel kundenFirmaLabel;
    private javax.swing.JLabel kundenInfoLabel;
    private javax.swing.JList kundenListe;
    private javax.swing.JLabel kundenListeLabel;
    private javax.swing.JButton kundenLoeschen;
    private javax.swing.JTextField kundenNachNameFeld;
    private javax.swing.JLabel kundenNachNameLabel;
    private javax.swing.JTextField kundenOrtFeld;
    private javax.swing.JLabel kundenOrtLabel;
    private javax.swing.JLabel kundenPLZLabel;
    private javax.swing.JTextField kundenPlzFeld;
    private javax.swing.JTextField kundenStrasseFeld;
    private javax.swing.JLabel kundenStrasseLabel;
    private javax.swing.JTextField kundenTelFeld;
    private javax.swing.JLabel kundenTelLabel;
    private javax.swing.JLabel kundenTuerNrLabel;
    private javax.swing.JTextField kundenVorNameFeld;
    private javax.swing.JLabel kundenVorNameLabel;
    private javax.swing.JButton kundenangebotZuweisen;
    // End of variables declaration//GEN-END:variables
}
