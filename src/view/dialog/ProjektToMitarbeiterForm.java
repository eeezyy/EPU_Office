/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AngebotToKundeForm.java
 *
 * Created on 05.06.2011, 22:22:20
 */
package view.dialog;

import controller.Binder;
import java.util.logging.Level;
import model.Kontakt;
import model.Mitarbeiter;
import model.Projekt;
import model.dal.DALException;
import model.dal.DALFactory;
import utils.log.Logger;
import view.AbstractViewDialog;

/**
 *
 * @author Goran-Goggy
 */
public class ProjektToMitarbeiterForm extends AbstractViewDialog {

    private final Mitarbeiter mitarbeiter;

    /** Creates new form AngebotToKundeForm */
    public ProjektToMitarbeiterForm(java.awt.Frame parent, boolean modal, Mitarbeiter mitarbeiter) {
        super(parent, modal);
        this.mitarbeiter = mitarbeiter;
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        initialize();
    }

    private void initialize() {
        dialogProjektToMitarbeiterMitarbeiterFeld.setText(mitarbeiter.toString());

        Binder.bind(Projekt.class, dialogProjektToMitarbeiterProjektComboBox);
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
        jSeparator1 = new javax.swing.JSeparator();
        dialogProjektToMitarbeiterProjektLabel = new javax.swing.JLabel();
        dialogProjektToMitarbeiterMitarbeiterLabel = new javax.swing.JLabel();
        dialogLabel = new javax.swing.JLabel();
        dialogProjektToMitarbeiterMitarbeiterFeld = new javax.swing.JTextField();
        dialogProjektToMitarbeiterProjektComboBox = new javax.swing.JComboBox();
        dialogKundeToAngebotAbbrechen = new javax.swing.JButton();
        dialogKundeToAngebotUebernehmen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 280, 10));

        dialogProjektToMitarbeiterProjektLabel.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        dialogProjektToMitarbeiterProjektLabel.setText("Projekt");
        jPanel1.add(dialogProjektToMitarbeiterProjektLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        dialogProjektToMitarbeiterMitarbeiterLabel.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        dialogProjektToMitarbeiterMitarbeiterLabel.setText("Mitarbeiter");
        jPanel1.add(dialogProjektToMitarbeiterMitarbeiterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        dialogLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        dialogLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dialogLabel.setText("Projektzuweisung");
        dialogLabel.setAlignmentX(0.5F);
        jPanel1.add(dialogLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        dialogProjektToMitarbeiterMitarbeiterFeld.setEditable(false);
        dialogProjektToMitarbeiterMitarbeiterFeld.setName("Kunde"); // NOI18N
        jPanel1.add(dialogProjektToMitarbeiterMitarbeiterFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 150, -1));

        dialogProjektToMitarbeiterProjektComboBox.setName("ProjektListe"); // NOI18N
        jPanel1.add(dialogProjektToMitarbeiterProjektComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 150, -1));

        dialogKundeToAngebotAbbrechen.setText("Abbrechen");
        dialogKundeToAngebotAbbrechen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dialogKundeToAngebotAbbrechenActionPerformed(evt);
            }
        });
        jPanel1.add(dialogKundeToAngebotAbbrechen, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 110, -1));

        dialogKundeToAngebotUebernehmen.setText("Übernehmen");
        dialogKundeToAngebotUebernehmen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dialogKundeToAngebotUebernehmenActionPerformed(evt);
            }
        });
        jPanel1.add(dialogKundeToAngebotUebernehmen, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 110, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 180));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dialogKundeToAngebotUebernehmenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialogKundeToAngebotUebernehmenActionPerformed
        Object o = dialogProjektToMitarbeiterProjektComboBox.getSelectedItem();

        if (o != null && o instanceof Projekt) {
            try {
                DALFactory.getDAL().addProjektToMitarbeiter((Projekt) o, mitarbeiter);
            } catch (DALException ex) {
                Logger.log(Level.SEVERE, ProjektToMitarbeiterForm.class, ex);
            }
            this.dispose();
        }
}//GEN-LAST:event_dialogKundeToAngebotUebernehmenActionPerformed

    private void dialogKundeToAngebotAbbrechenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialogKundeToAngebotAbbrechenActionPerformed
        // TODO add your handling code here:
        dispose();
}//GEN-LAST:event_dialogKundeToAngebotAbbrechenActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dialogKundeToAngebotAbbrechen;
    private javax.swing.JButton dialogKundeToAngebotUebernehmen;
    private javax.swing.JLabel dialogLabel;
    private javax.swing.JTextField dialogProjektToMitarbeiterMitarbeiterFeld;
    private javax.swing.JLabel dialogProjektToMitarbeiterMitarbeiterLabel;
    private javax.swing.JComboBox dialogProjektToMitarbeiterProjektComboBox;
    private javax.swing.JLabel dialogProjektToMitarbeiterProjektLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}