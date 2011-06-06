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

/**
 *
 * @author Goran-Goggy
 */
public class AngebotToKundeForm extends javax.swing.JDialog {

    /** Creates new form AngebotToKundeForm */
    public AngebotToKundeForm(java.awt.Frame parent, boolean modal) {
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
        jSeparator1 = new javax.swing.JSeparator();
        dialogAngebotToKundeProjektComboBox = new javax.swing.JComboBox();
        dialogAngebotToKundeProjekttLabel = new javax.swing.JLabel();
        dialogAngebotToKundeAngebotLabel = new javax.swing.JLabel();
        dialogAngebotToKundeNameLabel = new javax.swing.JLabel();
        configMenueLabel = new javax.swing.JLabel();
        dialogAngebotToKundeNameFeld = new javax.swing.JTextField();
        dialogAngebotToKundeAngebotComboBox = new javax.swing.JComboBox();
        dialogAngebotToKundeAbbrechen = new javax.swing.JButton();
        dialogAngebotToKundeUebernehmen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 280, 10));

        dialogAngebotToKundeProjektComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4", "Item 3", "Item 4", "Item 3", "Item 4", "Item 3", "Item 4", "Item 3", "Item 4", "Item 3", "Item 4", "Item 3", "Item 4", "Item 3", "Item 4", "Item 3", "Item 4", "Item 3", "Item 4", "Item 3", "Item 4", "Item 3", "Item 4", "Item 3", "Item 4", "Item 3", "Item 4", "Item 3", "Item 4", "Item 3", "Item 4", "Item 3", "Item 4", "Item 3", "Item 4", "Item 3", "Item 4", "Item 3", "Item 4", "Item 3", "Item 4", "Item 3", "Item 4", "Item 3", "Item 4", "Item 3", "Item 4", "Item 3", "Item 4" }));
        jPanel1.add(dialogAngebotToKundeProjektComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 150, -1));

        dialogAngebotToKundeProjekttLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        dialogAngebotToKundeProjekttLabel.setText("Projekt");
        jPanel1.add(dialogAngebotToKundeProjekttLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        dialogAngebotToKundeAngebotLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        dialogAngebotToKundeAngebotLabel.setText("Angebot");
        jPanel1.add(dialogAngebotToKundeAngebotLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        dialogAngebotToKundeNameLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        dialogAngebotToKundeNameLabel.setText("Kunde");
        jPanel1.add(dialogAngebotToKundeNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        configMenueLabel.setFont(new java.awt.Font("Arial", 1, 14));
        configMenueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        configMenueLabel.setText("Angebotzuweisung");
        configMenueLabel.setAlignmentX(0.5F);
        jPanel1.add(configMenueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        dialogAngebotToKundeNameFeld.setEditable(false);
        jPanel1.add(dialogAngebotToKundeNameFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 150, -1));

        dialogAngebotToKundeAngebotComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4", "Item 3", "Item 4", "Item 3", "Item 4", "Item 3", "Item 4", "Item 3", "Item 4", "Item 3", "Item 4", "Item 3", "Item 4", "Item 3", "Item 4", "Item 3", "Item 4", "Item 3", "Item 4", "Item 3", "Item 4", "Item 3", "Item 4", "Item 3", "Item 4", "Item 3", "Item 4", "Item 3", "Item 4", "Item 3", "Item 4", "Item 3", "Item 4", "Item 3", "Item 4", "Item 3", "Item 4", "Item 3", "Item 4", "Item 3", "Item 4", "Item 3", "Item 4", "Item 3", "Item 4", "Item 3", "Item 4", "Item 3", "Item 4" }));
        jPanel1.add(dialogAngebotToKundeAngebotComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 150, -1));

        dialogAngebotToKundeAbbrechen.setText("Abbrechen");
        dialogAngebotToKundeAbbrechen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dialogAngebotToKundeAbbrechenActionPerformed(evt);
            }
        });
        jPanel1.add(dialogAngebotToKundeAbbrechen, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 110, -1));

        dialogAngebotToKundeUebernehmen.setText("Übernehmen");
        dialogAngebotToKundeUebernehmen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dialogAngebotToKundeUebernehmenActionPerformed(evt);
            }
        });
        jPanel1.add(dialogAngebotToKundeUebernehmen, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 110, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 220));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dialogAngebotToKundeUebernehmenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialogAngebotToKundeUebernehmenActionPerformed
}//GEN-LAST:event_dialogAngebotToKundeUebernehmenActionPerformed

    private void dialogAngebotToKundeAbbrechenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialogAngebotToKundeAbbrechenActionPerformed
        // TODO add your handling code here:
        dispose();
}//GEN-LAST:event_dialogAngebotToKundeAbbrechenActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                AngebotToKundeForm dialog = new AngebotToKundeForm(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel configMenueLabel;
    private javax.swing.JButton dialogAngebotToKundeAbbrechen;
    private javax.swing.JComboBox dialogAngebotToKundeAngebotComboBox;
    private javax.swing.JLabel dialogAngebotToKundeAngebotLabel;
    private javax.swing.JTextField dialogAngebotToKundeNameFeld;
    private javax.swing.JLabel dialogAngebotToKundeNameLabel;
    private javax.swing.JComboBox dialogAngebotToKundeProjektComboBox;
    private javax.swing.JLabel dialogAngebotToKundeProjekttLabel;
    private javax.swing.JButton dialogAngebotToKundeUebernehmen;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
