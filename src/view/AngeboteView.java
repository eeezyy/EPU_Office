/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Angebote.java
 *
 * Created on 09.04.2011, 17:52:20
 */
package view;

import view.dialog.AngebotAddForm;

/**
 *
 * @author Goran-Goggy
 */
public class AngeboteView extends javax.swing.JPanel {

    /** Creates new form Angebote */
    public AngeboteView() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        kontaktListeLabel = new javax.swing.JLabel();
        kontaktInfoLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        kontaktListe = new javax.swing.JList();
        angebotGueltigBisLabel = new javax.swing.JLabel();
        kontaktTelLabel = new javax.swing.JLabel();
        kontaktEmailLabel = new javax.swing.JLabel();
        kontaktBankInstLabel = new javax.swing.JLabel();
        kontaktBLZNrLabel = new javax.swing.JLabel();
        kontaktNameFeld = new javax.swing.JTextField();
        kontaktTelFeld = new javax.swing.JTextField();
        kontaktBankInstFeld = new javax.swing.JTextField();
        angebotErstellen = new javax.swing.JButton();
        angebotLoeschen = new javax.swing.JButton();
        angebotGueltigBisFeld = new javax.swing.JTextField();
        kundeZuweisen = new javax.swing.JButton();
        kontaktStrasseLabel = new javax.swing.JLabel();
        angebotGueltigAbLabel = new javax.swing.JLabel();
        angebotGueltigAbFeld = new javax.swing.JTextField();
        angebotAendern = new javax.swing.JButton();
        kontaktBankInstFeld1 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setMaximumSize(new java.awt.Dimension(572, 380));
        setMinimumSize(new java.awt.Dimension(572, 380));
        setName("angebotPanel"); // NOI18N
        setPreferredSize(new java.awt.Dimension(572, 380));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kontaktListeLabel.setFont(new java.awt.Font("Arial", 1, 18));
        kontaktListeLabel.setText("Angebotliste");
        add(kontaktListeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        kontaktInfoLabel.setFont(new java.awt.Font("Arial", 1, 18));
        kontaktInfoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kontaktInfoLabel.setText("Angebotinformation");
        kontaktInfoLabel.setAlignmentX(0.5F);
        add(kontaktInfoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, -1, -1));

        kontaktListe.setFont(new java.awt.Font("Tahoma", 2, 12));
        kontaktListe.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Wien Energie", "FH Technikum-Wien", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(kontaktListe);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 200, 190));

        angebotGueltigBisLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        angebotGueltigBisLabel.setText("Gültig bis");
        add(angebotGueltigBisLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 40, -1, -1));

        kontaktTelLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        kontaktTelLabel.setText("Name");
        add(kontaktTelLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, -1, -1));

        kontaktEmailLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        kontaktEmailLabel.setText("Preis");
        add(kontaktEmailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, -1, -1));

        kontaktBankInstLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        kontaktBankInstLabel.setText("Dauer");
        add(kontaktBankInstLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, -1, -1));

        kontaktBLZNrLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        kontaktBLZNrLabel.setText("Chance");
        add(kontaktBLZNrLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 80, -1, -1));

        kontaktNameFeld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kontaktNameFeldActionPerformed(evt);
            }
        });
        add(kontaktNameFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 150, -1));
        add(kontaktTelFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 150, -1));
        add(kontaktBankInstFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, 150, -1));

        angebotErstellen.setText("Angebot erstellen");
        angebotErstellen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                angebotErstellenActionPerformed(evt);
            }
        });
        add(angebotErstellen, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, 230, -1));

        angebotLoeschen.setText("Angebot löschen");
        add(angebotLoeschen, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, 230, -1));

        angebotGueltigBisFeld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                angebotGueltigBisFeldActionPerformed(evt);
            }
        });
        add(angebotGueltigBisFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 40, 150, -1));

        kundeZuweisen.setText("Kunden zuweisen");
        add(kundeZuweisen, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 200, -1));

        kontaktStrasseLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        kontaktStrasseLabel.setText("Beschreibung");
        add(kontaktStrasseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, -1, -1));

        angebotGueltigAbLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        angebotGueltigAbLabel.setText("Gültig ab");
        add(angebotGueltigAbLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, -1, -1));

        angebotGueltigAbFeld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                angebotGueltigAbFeldActionPerformed(evt);
            }
        });
        add(angebotGueltigAbFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, 150, -1));

        angebotAendern.setText("Angebot ändern");
        angebotAendern.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                angebotAendernActionPerformed(evt);
            }
        });
        add(angebotAendern, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 240, 230, -1));
        add(kontaktBankInstFeld1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 80, 150, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 770, 90));
    }// </editor-fold>//GEN-END:initComponents

    private void kontaktNameFeldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kontaktNameFeldActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_kontaktNameFeldActionPerformed

    private void angebotErstellenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_angebotErstellenActionPerformed
        AngebotAddForm af = new AngebotAddForm(null, true);
        af.setVisible(true);
}//GEN-LAST:event_angebotErstellenActionPerformed

    private void angebotGueltigBisFeldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_angebotGueltigBisFeldActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_angebotGueltigBisFeldActionPerformed

    private void angebotAendernActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_angebotAendernActionPerformed
        // TODO add your handling code here:
        //modelPropertyChange(null);
}//GEN-LAST:event_angebotAendernActionPerformed

    private void angebotGueltigAbFeldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_angebotGueltigAbFeldActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_angebotGueltigAbFeldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton angebotAendern;
    private javax.swing.JButton angebotErstellen;
    private javax.swing.JTextField angebotGueltigAbFeld;
    private javax.swing.JLabel angebotGueltigAbLabel;
    private javax.swing.JTextField angebotGueltigBisFeld;
    private javax.swing.JLabel angebotGueltigBisLabel;
    private javax.swing.JButton angebotLoeschen;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel kontaktBLZNrLabel;
    private javax.swing.JTextField kontaktBankInstFeld;
    private javax.swing.JTextField kontaktBankInstFeld1;
    private javax.swing.JLabel kontaktBankInstLabel;
    private javax.swing.JLabel kontaktEmailLabel;
    private javax.swing.JLabel kontaktInfoLabel;
    private javax.swing.JList kontaktListe;
    private javax.swing.JLabel kontaktListeLabel;
    private javax.swing.JTextField kontaktNameFeld;
    private javax.swing.JLabel kontaktStrasseLabel;
    private javax.swing.JTextField kontaktTelFeld;
    private javax.swing.JLabel kontaktTelLabel;
    private javax.swing.JButton kundeZuweisen;
    // End of variables declaration//GEN-END:variables
}
