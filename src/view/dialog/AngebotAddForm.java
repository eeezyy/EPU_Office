/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AngebotAddForm.java
 *
 * Created on 14.04.2011, 16:43:58
 */
package view.dialog;

import java.util.Date;
import java.util.logging.Level;
import model.Angebot;
import model.dal.DALException;
import model.dal.DALFactory;
import utils.log.Logger;
import view.AbstractViewDialog;

/**
 *
 * @author Goran-Goggy
 */
public class AngebotAddForm extends AbstractViewDialog {

    /** Creates new form AngebotAddForm */
    public AngebotAddForm(java.awt.Frame parent, boolean modal) {
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
        angebotAddLabel = new javax.swing.JLabel();
        dialogAngebotAbbrechen = new javax.swing.JButton();
        dialogAngebotHinzufuegen = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        dialogAngebotGueltigBisLabel = new javax.swing.JLabel();
        dialogAngebotNameLabel = new javax.swing.JLabel();
        dialogAngebotPreisLabel = new javax.swing.JLabel();
        dialogAngebotDauerLabel = new javax.swing.JLabel();
        dialogAngebotChanceLabel = new javax.swing.JLabel();
        dialogAngebotImplPreisFeld = new javax.swing.JTextField();
        dialogAngebotNameFeld = new javax.swing.JTextField();
        dialogAngebotImplDauerFeld = new javax.swing.JTextField();
        dialogAngebotBeschreibungLabel = new javax.swing.JLabel();
        dialogAngebotGueltigAbLabel = new javax.swing.JLabel();
        dialogAngebotImplChanceFeld = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        dialogAngebotBeschreibungFeld = new javax.swing.JTextArea();
        dialogAngebotGueltigAbFeld = new com.toedter.calendar.JDateChooser();
        dialogAngebotGueltigBisFeld = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        angebotAddLabel.setFont(new java.awt.Font("Arial", 1, 14));
        angebotAddLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        angebotAddLabel.setText("Angebot erstellen");
        angebotAddLabel.setAlignmentX(0.5F);
        jPanel1.add(angebotAddLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        dialogAngebotAbbrechen.setText("Abbrechen");
        dialogAngebotAbbrechen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dialogAngebotAbbrechenActionPerformed(evt);
            }
        });
        jPanel1.add(dialogAngebotAbbrechen, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, 230, -1));

        dialogAngebotHinzufuegen.setText("Angebot erstellen");
        dialogAngebotHinzufuegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dialogAngebotHinzufuegenActionPerformed(evt);
            }
        });
        jPanel1.add(dialogAngebotHinzufuegen, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 230, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 263, 770, 10));

        dialogAngebotGueltigBisLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        dialogAngebotGueltigBisLabel.setText("Gültig bis");
        jPanel1.add(dialogAngebotGueltigBisLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 51, -1, -1));

        dialogAngebotNameLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        dialogAngebotNameLabel.setText("Name");
        jPanel1.add(dialogAngebotNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 51, -1, -1));

        dialogAngebotPreisLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        dialogAngebotPreisLabel.setText("Preis (€)");
        jPanel1.add(dialogAngebotPreisLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 92, -1, -1));

        dialogAngebotDauerLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        dialogAngebotDauerLabel.setText("Dauer (Tage)");
        jPanel1.add(dialogAngebotDauerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 92, -1, -1));

        dialogAngebotChanceLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        dialogAngebotChanceLabel.setText("Chance (%)");
        jPanel1.add(dialogAngebotChanceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 92, -1, -1));

        dialogAngebotImplPreisFeld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dialogAngebotImplPreisFeldActionPerformed(evt);
            }
        });
        jPanel1.add(dialogAngebotImplPreisFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 150, -1));
        jPanel1.add(dialogAngebotNameFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 150, -1));
        jPanel1.add(dialogAngebotImplDauerFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 150, -1));

        dialogAngebotBeschreibungLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        dialogAngebotBeschreibungLabel.setText("Beschreibung");
        jPanel1.add(dialogAngebotBeschreibungLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 133, -1, -1));

        dialogAngebotGueltigAbLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        dialogAngebotGueltigAbLabel.setText("Gültig ab");
        jPanel1.add(dialogAngebotGueltigAbLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 51, -1, -1));
        jPanel1.add(dialogAngebotImplChanceFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 90, 140, -1));

        dialogAngebotBeschreibungFeld.setColumns(20);
        dialogAngebotBeschreibungFeld.setRows(5);
        jScrollPane3.setViewportView(dialogAngebotBeschreibungFeld);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 153, 770, 90));
        jPanel1.add(dialogAngebotGueltigAbFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 140, -1));
        jPanel1.add(dialogAngebotGueltigBisFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 50, 140, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dialogAngebotImplPreisFeldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialogAngebotImplPreisFeldActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_dialogAngebotImplPreisFeldActionPerformed

    private void dialogAngebotHinzufuegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialogAngebotHinzufuegenActionPerformed
        // TODO add your handling code here:
        Date d = new Date();
        Angebot a = new Angebot();
        a.setName(dialogAngebotNameFeld.getText());
        a.setAenderungsDatum(d);
        a.setBeschreibung(dialogAngebotBeschreibungFeld.getText());
        a.setGueltigAb(dialogAngebotGueltigAbFeld.getDate());
        a.setGueltigBis(dialogAngebotGueltigBisFeld.getDate());
        a.setChance(Integer.parseInt(dialogAngebotImplChanceFeld.getText()));
        a.setDauer(Integer.parseInt(dialogAngebotImplDauerFeld.getText()));
        a.setPreis(Double.parseDouble(dialogAngebotImplPreisFeld.getText()));
        try {
            // Test
            DALFactory.getDAL().saveAngebot(a);
            // --> controller add
            //this.getObservable().notifyObservers(new NotifyObject(k, State.ADDED));
            this.dispose();
        } catch (DALException ex) {
            Logger.log(Level.SEVERE, AngebotAddForm.class, ex);
        }
}//GEN-LAST:event_dialogAngebotHinzufuegenActionPerformed

    private void dialogAngebotAbbrechenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialogAngebotAbbrechenActionPerformed
        // TODO add your handling code here:
        dispose();
}//GEN-LAST:event_dialogAngebotAbbrechenActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                AngebotAddForm dialog = new AngebotAddForm(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel angebotAddLabel;
    private javax.swing.JButton dialogAngebotAbbrechen;
    private javax.swing.JTextArea dialogAngebotBeschreibungFeld;
    private javax.swing.JLabel dialogAngebotBeschreibungLabel;
    private javax.swing.JLabel dialogAngebotChanceLabel;
    private javax.swing.JLabel dialogAngebotDauerLabel;
    private com.toedter.calendar.JDateChooser dialogAngebotGueltigAbFeld;
    private javax.swing.JLabel dialogAngebotGueltigAbLabel;
    private com.toedter.calendar.JDateChooser dialogAngebotGueltigBisFeld;
    private javax.swing.JLabel dialogAngebotGueltigBisLabel;
    private javax.swing.JButton dialogAngebotHinzufuegen;
    private javax.swing.JTextField dialogAngebotImplChanceFeld;
    private javax.swing.JTextField dialogAngebotImplDauerFeld;
    private javax.swing.JTextField dialogAngebotImplPreisFeld;
    private javax.swing.JTextField dialogAngebotNameFeld;
    private javax.swing.JLabel dialogAngebotNameLabel;
    private javax.swing.JLabel dialogAngebotPreisLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

    @Override
    protected void resetTextFields() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
