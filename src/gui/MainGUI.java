/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainGUI.java
 *
 * Created on 09.04.2011, 14:55:05
 */
package gui;

/**
 *
 * @author Goran-Goggy
 */
public class MainGUI extends javax.swing.JFrame {

    /** Creates new form MainGUI */
    public MainGUI() {
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        beendenButton = new javax.swing.JButton();
        konfigButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        beendenButton.setText("Beenden");
        beendenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beendenButtonActionPerformed(evt);
            }
        });

        konfigButton.setText("Konfiguration");
        konfigButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                konfigButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(528, 528, 528)
                        .addComponent(konfigButton)
                        .addGap(18, 18, 18)
                        .addComponent(beendenButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(beendenButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(konfigButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void beendenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beendenButtonActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_beendenButtonActionPerformed

    private void konfigButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_konfigButtonActionPerformed
        // TODO add your handling code here:
        //ConfigView conf = new ConfigView(this, true);
        //conf.setLocationRelativeTo(this);
        //conf.setVisible(true);
        System.out.println("Konfiguration pressed");
    }//GEN-LAST:event_konfigButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MainGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton beendenButton;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton konfigButton;
    // End of variables declaration//GEN-END:variables
}
