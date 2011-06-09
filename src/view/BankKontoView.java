/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BankKontoView.java
 *
 * Created on 02.06.2011, 13:20:48
 */
package view;

import controller.BankKontoController;
import model.dal.DALFactory;
import model.dal.IDAL;

/**
 *
 * @author Goran-Goggy
 */
public class BankKontoView extends javax.swing.JPanel {

    private BankKontoController controller;
    private IDAL db = DALFactory.getDAL();

    /** Creates new form BankKontoView */
    public BankKontoView(BankKontoController controller) {
        this.controller = controller;
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

        BankOffeneRechnungenListeLabel = new javax.swing.JLabel();
        BankkontoLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        BankOffeneRechnungenListe = new javax.swing.JList();
        BankBLZLabel = new javax.swing.JLabel();
        kontaktTelLabel = new javax.swing.JLabel();
        bankBetragBruttoLabel = new javax.swing.JLabel();
        bankBetragUstLabel = new javax.swing.JLabel();
        bankBetragBruttoFeld = new javax.swing.JTextField();
        angebotNameFeld = new javax.swing.JTextField();
        BankKontoStandFeld = new javax.swing.JTextField();
        BankBLZFeld = new javax.swing.JTextField();
        BankKategorieLabel = new javax.swing.JLabel();
        BankBankInstitutLabel = new javax.swing.JLabel();
        BankBankInstitutFeld = new javax.swing.JTextField();
        bankBetragUstFeld = new javax.swing.JTextField();
        BankKategorieDropDown = new javax.swing.JComboBox();
        bankBetragNettoLabel = new javax.swing.JLabel();
        BankKontoStandLabel = new javax.swing.JLabel();
        bankBetragNettoFeld1 = new javax.swing.JTextField();
        bankRechnungKontoAuszug = new javax.swing.JButton();
        bankRechnungHistory = new javax.swing.JButton();
        bankBetragNettoLabel1 = new javax.swing.JLabel();
        bankBetragNettoFeld2 = new javax.swing.JTextField();
        bankRechnungZahlen2 = new javax.swing.JButton();
        BankOffeneRechnungenListeLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        BankOffeneRechnungenListe1 = new javax.swing.JList();
        bankRechnungZahlen3 = new javax.swing.JButton();
        bankBetragNettoLabel2 = new javax.swing.JLabel();
        bankBetragNettoFeld3 = new javax.swing.JTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BankOffeneRechnungenListeLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        BankOffeneRechnungenListeLabel.setText("Eingangsrechnungen");
        add(BankOffeneRechnungenListeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        BankkontoLabel.setFont(new java.awt.Font("Arial", 1, 14));
        BankkontoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BankkontoLabel.setText("Bankkontoübersicht");
        BankkontoLabel.setAlignmentX(0.5F);
        add(BankkontoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, -1, -1));

        BankOffeneRechnungenListe.setFont(new java.awt.Font("Tahoma", 2, 12));
        BankOffeneRechnungenListe.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Wien Energie", "FH Technikum-Wien", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(BankOffeneRechnungenListe);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 200, 160));

        BankBLZLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        BankBLZLabel.setText("BLZ");
        add(BankBLZLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, -1, -1));

        kontaktTelLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        kontaktTelLabel.setText("Rechnungs-ID");
        add(kontaktTelLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, -1, -1));

        bankBetragBruttoLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        bankBetragBruttoLabel.setText("Betrag (br.)");
        add(bankBetragBruttoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, -1, -1));

        bankBetragUstLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        bankBetragUstLabel.setText("UST.-Satz");
        add(bankBetragUstLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, -1, -1));

        bankBetragBruttoFeld.setEditable(false);
        bankBetragBruttoFeld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bankBetragBruttoFeldActionPerformed(evt);
            }
        });
        add(bankBetragBruttoFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 150, -1));

        angebotNameFeld.setEditable(false);
        add(angebotNameFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 150, -1));

        BankKontoStandFeld.setEditable(false);
        add(BankKontoStandFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 210, 150, -1));

        BankBLZFeld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BankBLZFeldActionPerformed(evt);
            }
        });
        add(BankBLZFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 80, 150, -1));

        BankKategorieLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        BankKategorieLabel.setText("Kategorie");
        add(BankKategorieLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, -1, -1));

        BankBankInstitutLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        BankBankInstitutLabel.setText("Bankinst.");
        add(BankBankInstitutLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, -1, -1));

        BankBankInstitutFeld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BankBankInstitutFeldActionPerformed(evt);
            }
        });
        add(BankBankInstitutFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 150, -1));

        bankBetragUstFeld.setEditable(false);
        add(bankBetragUstFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, 150, -1));

        BankKategorieDropDown.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(BankKategorieDropDown, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, 150, -1));

        bankBetragNettoLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        bankBetragNettoLabel.setText("Betrag (n.)");
        add(bankBetragNettoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, -1, -1));

        BankKontoStandLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        BankKontoStandLabel.setText("Kontostand");
        add(BankKontoStandLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, -1, -1));

        bankBetragNettoFeld1.setEditable(false);
        bankBetragNettoFeld1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bankBetragNettoFeld1ActionPerformed(evt);
            }
        });
        add(bankBetragNettoFeld1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, 150, -1));

        bankRechnungKontoAuszug.setText("Kontoauszug erstellen");
        add(bankRechnungKontoAuszug, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 240, 230, -1));

        bankRechnungHistory.setText("Bezahlte Rechnungen einsehen");
        add(bankRechnungHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, 230, -1));

        bankBetragNettoLabel1.setFont(new java.awt.Font("Tahoma", 0, 15));
        bankBetragNettoLabel1.setText("Off. Rechnungen");
        add(bankBetragNettoLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        bankBetragNettoFeld2.setEditable(false);
        add(bankBetragNettoFeld2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 80, -1));

        bankRechnungZahlen2.setText("Rechnung einzahlen");
        add(bankRechnungZahlen2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 200, -1));

        BankOffeneRechnungenListeLabel1.setFont(new java.awt.Font("Arial", 1, 14));
        BankOffeneRechnungenListeLabel1.setText("Ausgangsrechnungen");
        add(BankOffeneRechnungenListeLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 10, -1, -1));

        BankOffeneRechnungenListe1.setFont(new java.awt.Font("Tahoma", 2, 12));
        BankOffeneRechnungenListe1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Wien Energie", "FH Technikum-Wien", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(BankOffeneRechnungenListe1);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 40, 200, 160));

        bankRechnungZahlen3.setText("Rechnung abbuchen");
        add(bankRechnungZahlen3, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 240, 200, -1));

        bankBetragNettoLabel2.setFont(new java.awt.Font("Tahoma", 0, 15));
        bankBetragNettoLabel2.setText("Off. Rechnungen");
        add(bankBetragNettoLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 210, -1, -1));

        bankBetragNettoFeld3.setEditable(false);
        add(bankBetragNettoFeld3, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 210, 80, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void bankBetragBruttoFeldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bankBetragBruttoFeldActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_bankBetragBruttoFeldActionPerformed

    private void BankBLZFeldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BankBLZFeldActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_BankBLZFeldActionPerformed

    private void BankBankInstitutFeldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BankBankInstitutFeldActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_BankBankInstitutFeldActionPerformed

    private void bankBetragNettoFeld1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bankBetragNettoFeld1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bankBetragNettoFeld1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BankBLZFeld;
    private javax.swing.JLabel BankBLZLabel;
    private javax.swing.JTextField BankBankInstitutFeld;
    private javax.swing.JLabel BankBankInstitutLabel;
    private javax.swing.JComboBox BankKategorieDropDown;
    private javax.swing.JLabel BankKategorieLabel;
    private javax.swing.JTextField BankKontoStandFeld;
    private javax.swing.JLabel BankKontoStandLabel;
    private javax.swing.JList BankOffeneRechnungenListe;
    private javax.swing.JList BankOffeneRechnungenListe1;
    private javax.swing.JLabel BankOffeneRechnungenListeLabel;
    private javax.swing.JLabel BankOffeneRechnungenListeLabel1;
    private javax.swing.JLabel BankkontoLabel;
    private javax.swing.JTextField angebotNameFeld;
    private javax.swing.JTextField bankBetragBruttoFeld;
    private javax.swing.JLabel bankBetragBruttoLabel;
    private javax.swing.JTextField bankBetragNettoFeld1;
    private javax.swing.JTextField bankBetragNettoFeld2;
    private javax.swing.JTextField bankBetragNettoFeld3;
    private javax.swing.JLabel bankBetragNettoLabel;
    private javax.swing.JLabel bankBetragNettoLabel1;
    private javax.swing.JLabel bankBetragNettoLabel2;
    private javax.swing.JTextField bankBetragUstFeld;
    private javax.swing.JLabel bankBetragUstLabel;
    private javax.swing.JButton bankRechnungHistory;
    private javax.swing.JButton bankRechnungKontoAuszug;
    private javax.swing.JButton bankRechnungZahlen2;
    private javax.swing.JButton bankRechnungZahlen3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel kontaktTelLabel;
    // End of variables declaration//GEN-END:variables
}
