/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ProjektView.java
 *
 * Created on 10.05.2011, 16:16:07
 */
package view;

/**
 *
 * @author Goran-Goggy
 */
public class ProjektView extends javax.swing.JPanel {

    /** Creates new form ProjektView */
    public ProjektView() {
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

        kundenListeLabel = new javax.swing.JLabel();
        kundenInfoLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        projektListe = new javax.swing.JList();
        projektAuftragLabel = new javax.swing.JLabel();
        projektImplementierungVonLabel = new javax.swing.JLabel();
        projektImplementierungBisLabel = new javax.swing.JLabel();
        projektStundenGesamt = new javax.swing.JTextField();
        projektImplVon = new javax.swing.JTextField();
        projektExport = new javax.swing.JButton();
        projektAuftragFeld = new javax.swing.JTextField();
        projektImport = new javax.swing.JButton();
        projektNameLabel = new javax.swing.JLabel();
        projektNameFeld = new javax.swing.JTextField();
        projektImplementierungVonLabel1 = new javax.swing.JLabel();
        projektArbeitsstundenGesamt = new javax.swing.JLabel();
        projektCheckBox = new javax.swing.JCheckBox();
        projektImplBis = new javax.swing.JTextField();
        projektHinzufuegen = new javax.swing.JButton();
        projektLoeschen = new javax.swing.JButton();
        projektAendern = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kundenListeLabel.setFont(new java.awt.Font("Arial", 1, 14));
        kundenListeLabel.setText("Projektliste");
        add(kundenListeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        kundenInfoLabel.setFont(new java.awt.Font("Arial", 1, 14));
        kundenInfoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kundenInfoLabel.setText("Projektinformationen");
        kundenInfoLabel.setAlignmentX(0.5F);
        add(kundenInfoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, -1, -1));

        projektListe.setFont(new java.awt.Font("Tahoma", 2, 12));
        projektListe.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Projekt 1  |  Auftrag 1", "Projekt 2", "Projekt 3", "Projekt 4", "Projekt 5", "Projekt 6", "Projekt 7" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        projektListe.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(projektListe);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 200, 190));

        projektAuftragLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        projektAuftragLabel.setText("Auftrag");
        add(projektAuftragLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, -1, -1));

        projektImplementierungVonLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        projektImplementierungVonLabel.setText("Impl. (von)");
        add(projektImplementierungVonLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, -1, -1));

        projektImplementierungBisLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        projektImplementierungBisLabel.setText("Impl. (bis)");
        add(projektImplementierungBisLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, -1, -1));

        projektStundenGesamt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projektStundenGesamtActionPerformed(evt);
            }
        });
        add(projektStundenGesamt, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 60, -1));
        add(projektImplVon, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 140, -1));

        projektExport.setText("Datensätze exportieren");
        add(projektExport, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 80, 230, -1));

        projektAuftragFeld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projektAuftragFeldActionPerformed(evt);
            }
        });
        add(projektAuftragFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, 150, -1));

        projektImport.setText("Datensätze Importieren");
        add(projektImport, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 40, 230, -1));

        projektNameLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        projektNameLabel.setText("Name");
        add(projektNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, -1, -1));

        projektNameFeld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projektNameFeldActionPerformed(evt);
            }
        });
        add(projektNameFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 140, -1));

        projektImplementierungVonLabel1.setFont(new java.awt.Font("Tahoma", 0, 15));
        projektImplementierungVonLabel1.setText("Abgeschlossen");
        add(projektImplementierungVonLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, -1, -1));

        projektArbeitsstundenGesamt.setFont(new java.awt.Font("Tahoma", 0, 15));
        projektArbeitsstundenGesamt.setText("Arbeitsstunden (gesamt)");
        add(projektArbeitsstundenGesamt, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, -1, -1));
        add(projektCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, -1, -1));

        projektImplBis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projektImplBisActionPerformed(evt);
            }
        });
        add(projektImplBis, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, 150, -1));

        projektHinzufuegen.setText("Projekt hinzufügen");
        add(projektHinzufuegen, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 200, -1));

        projektLoeschen.setText("Projekt löschen");
        add(projektLoeschen, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 230, -1));

        projektAendern.setText("Projektdaten ändern");
        projektAendern.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projektAendernActionPerformed(evt);
            }
        });
        add(projektAendern, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, 230, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void projektStundenGesamtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projektStundenGesamtActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_projektStundenGesamtActionPerformed

    private void projektAuftragFeldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projektAuftragFeldActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_projektAuftragFeldActionPerformed

    private void projektNameFeldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projektNameFeldActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_projektNameFeldActionPerformed

    private void projektImplBisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projektImplBisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_projektImplBisActionPerformed

    private void projektAendernActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projektAendernActionPerformed
        //KontaktAddForm af = new KontaktAddForm(null, true);
        //af.setVisible(true);
}//GEN-LAST:event_projektAendernActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel kundenInfoLabel;
    private javax.swing.JLabel kundenListeLabel;
    private javax.swing.JButton projektAendern;
    private javax.swing.JLabel projektArbeitsstundenGesamt;
    private javax.swing.JTextField projektAuftragFeld;
    private javax.swing.JLabel projektAuftragLabel;
    private javax.swing.JCheckBox projektCheckBox;
    private javax.swing.JButton projektExport;
    private javax.swing.JButton projektHinzufuegen;
    private javax.swing.JTextField projektImplBis;
    private javax.swing.JTextField projektImplVon;
    private javax.swing.JLabel projektImplementierungBisLabel;
    private javax.swing.JLabel projektImplementierungVonLabel;
    private javax.swing.JLabel projektImplementierungVonLabel1;
    private javax.swing.JButton projektImport;
    private javax.swing.JList projektListe;
    private javax.swing.JButton projektLoeschen;
    private javax.swing.JTextField projektNameFeld;
    private javax.swing.JLabel projektNameLabel;
    private javax.swing.JTextField projektStundenGesamt;
    // End of variables declaration//GEN-END:variables
}
