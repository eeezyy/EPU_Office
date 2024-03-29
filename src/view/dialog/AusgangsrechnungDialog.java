/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AusgangsrechnungDialog.java
 *
 * Created on 09.05.2011, 18:47:22
 */
package view.dialog;

/**
 *
 * @author Goran-Goggy
 */
public class AusgangsrechnungDialog extends javax.swing.JDialog {

    /** Creates new form AusgangsrechnungDialog */
    public AusgangsrechnungDialog(java.awt.Frame parent, boolean modal) {
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
        kontaktInfoLabel1 = new javax.swing.JLabel();
        kundenTelLabel4 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        dialogAusgangPreisFeld = new javax.swing.JTextPane();
        kundenTelLabel5 = new javax.swing.JLabel();
        kundenTelLabel6 = new javax.swing.JLabel();
        kundenTelLabel7 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        dialogAusgangDatumFeld = new javax.swing.JTextPane();
        jScrollPane9 = new javax.swing.JScrollPane();
        dialogAusgangKundeFeld = new javax.swing.JTextPane();
        jScrollPane10 = new javax.swing.JScrollPane();
        dialogAusgangAngebotFeld = new javax.swing.JTextPane();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kontaktInfoLabel1.setFont(new java.awt.Font("Arial", 1, 14));
        kontaktInfoLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kontaktInfoLabel1.setText("Ausgangsrechnung");
        kontaktInfoLabel1.setAlignmentX(0.5F);
        jPanel1.add(kontaktInfoLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        kundenTelLabel4.setFont(new java.awt.Font("Tahoma", 0, 15));
        kundenTelLabel4.setText("Preis (€)");
        jPanel1.add(kundenTelLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        dialogAusgangPreisFeld.setBorder(null);
        dialogAusgangPreisFeld.setEditable(false);
        dialogAusgangPreisFeld.setFont(new java.awt.Font("Tahoma", 0, 15));
        dialogAusgangPreisFeld.setText("3000");
        dialogAusgangPreisFeld.setName("result"); // NOI18N
        jScrollPane7.setViewportView(dialogAusgangPreisFeld);

        jPanel1.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 310, -1));

        kundenTelLabel5.setFont(new java.awt.Font("Tahoma", 0, 15));
        kundenTelLabel5.setText("Rechnung erstellt, am ");
        jPanel1.add(kundenTelLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        kundenTelLabel6.setFont(new java.awt.Font("Tahoma", 0, 15));
        kundenTelLabel6.setText("Kunde");
        jPanel1.add(kundenTelLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        kundenTelLabel7.setFont(new java.awt.Font("Tahoma", 0, 15));
        kundenTelLabel7.setText("Angebot");
        jPanel1.add(kundenTelLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        dialogAusgangDatumFeld.setBorder(null);
        dialogAusgangDatumFeld.setEditable(false);
        dialogAusgangDatumFeld.setFont(new java.awt.Font("Tahoma", 0, 15));
        dialogAusgangDatumFeld.setText("9.5.2011");
        dialogAusgangDatumFeld.setName("result"); // NOI18N
        jScrollPane8.setViewportView(dialogAusgangDatumFeld);

        jPanel1.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 80, -1));

        dialogAusgangKundeFeld.setBorder(null);
        dialogAusgangKundeFeld.setEditable(false);
        dialogAusgangKundeFeld.setFont(new java.awt.Font("Tahoma", 0, 15));
        dialogAusgangKundeFeld.setText("FH Technikum-Wien");
        dialogAusgangKundeFeld.setName("result"); // NOI18N
        jScrollPane9.setViewportView(dialogAusgangKundeFeld);

        jPanel1.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 310, -1));

        dialogAusgangAngebotFeld.setBorder(null);
        dialogAusgangAngebotFeld.setEditable(false);
        dialogAusgangAngebotFeld.setFont(new java.awt.Font("Tahoma", 0, 15));
        dialogAusgangAngebotFeld.setText("Schuhe putzen");
        dialogAusgangAngebotFeld.setName("result"); // NOI18N
        jScrollPane10.setViewportView(dialogAusgangAngebotFeld);

        jPanel1.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 310, -1));

        jButton2.setText("Schließen");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 210));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                AusgangsrechnungDialog dialog = new AusgangsrechnungDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextPane dialogAusgangAngebotFeld;
    private javax.swing.JTextPane dialogAusgangDatumFeld;
    private javax.swing.JTextPane dialogAusgangKundeFeld;
    private javax.swing.JTextPane dialogAusgangPreisFeld;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel kontaktInfoLabel1;
    private javax.swing.JLabel kundenTelLabel4;
    private javax.swing.JLabel kundenTelLabel5;
    private javax.swing.JLabel kundenTelLabel6;
    private javax.swing.JLabel kundenTelLabel7;
    // End of variables declaration//GEN-END:variables
}
