 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JahresUeberblickForm.java
 *
 * Created on 10.05.2011, 16:45:03
 */
package view.dialog;

import utils.charts.LineChart;

/**
 *
 * @author Goran-Goggy
 */
public class JahresUeberblickForm extends javax.swing.JDialog {

    /** Creates new form JahresUeberblickForm */
    public JahresUeberblickForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        LineChart chart = new LineChart("");
        chartView.add(chart.getPanel());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        kontaktInfoLabel1 = new javax.swing.JLabel();
        dialogUeberblickBeenden = new javax.swing.JButton();
        chartView = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dialogUeberblickJahrListe = new javax.swing.JList();
        dialogUeberblickPdfErstellen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kontaktInfoLabel1.setFont(new java.awt.Font("Arial", 1, 14));
        kontaktInfoLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kontaktInfoLabel1.setText("Jahresüberblick");
        kontaktInfoLabel1.setAlignmentX(0.5F);
        jPanel2.add(kontaktInfoLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        dialogUeberblickBeenden.setText("Schließen");
        dialogUeberblickBeenden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dialogUeberblickBeendenActionPerformed(evt);
            }
        });
        jPanel2.add(dialogUeberblickBeenden, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 230, -1));

        chartView.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        chartView.setLayout(new java.awt.BorderLayout());
        jPanel2.add(chartView, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 360, 160));

        dialogUeberblickJahrListe.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "..." };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        dialogUeberblickJahrListe.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(dialogUeberblickJahrListe);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 350, 160));

        dialogUeberblickPdfErstellen.setText("Jahresbilanz-PDF erstellen");
        dialogUeberblickPdfErstellen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dialogUeberblickPdfErstellenActionPerformed(evt);
            }
        });
        jPanel2.add(dialogUeberblickPdfErstellen, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, 230, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 760, 240));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dialogUeberblickBeendenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialogUeberblickBeendenActionPerformed
        // TODO add your handling code here:
        this.dispose();
}//GEN-LAST:event_dialogUeberblickBeendenActionPerformed

    private void dialogUeberblickPdfErstellenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialogUeberblickPdfErstellenActionPerformed
        // TODO add your handling code here:
        //modelPropertyChange(null);
}//GEN-LAST:event_dialogUeberblickPdfErstellenActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                JahresUeberblickForm dialog = new JahresUeberblickForm(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel chartView;
    private javax.swing.JButton dialogUeberblickBeenden;
    private javax.swing.JList dialogUeberblickJahrListe;
    private javax.swing.JButton dialogUeberblickPdfErstellen;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel kontaktInfoLabel1;
    // End of variables declaration//GEN-END:variables
}
