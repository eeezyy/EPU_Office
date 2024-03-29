/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ConfigForm.java
 *
 * Created on 29.05.2011, 13:36:37
 */
package view.dialog;

import config.Config;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author Goran-Goggy
 */
public class ConfigForm extends javax.swing.JDialog {
    
    private Config c = epu_office.Main.config;

    /** Creates new form ConfigForm */
    public ConfigForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        initialize();
        
    }
    
    private void initialize() {
        //this.dialogConfigQuelleDropDown.
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("Datenbank (mySQL)");
        model.addElement("Mock");
        //model.setSelectedItem(c.getProperties().getProperty("db"));
        String choice = c.getProperties().getProperty("db");
        if(choice.equals("mock")){
            model.setSelectedItem(model.getElementAt(1));
        } else {
            model.setSelectedItem(model.getElementAt(0));
        }
        dialogConfigQuelleDropDown.setModel(model);
        dialogConfigNameFeld.setText(c.getProperties().getProperty("db_user"));
        dialogConfigPasswortFeld.setText(c.getProperties().getProperty("db_pwd"));
        dialogConfigIPFeld.setText(c.getProperties().getProperty("db_ip"));
        dialogConfigPortFeld.setText(c.getProperties().getProperty("db_port"));

        /*db=mySQL
        db_ip=localhost
        db_port=3306
        db_name=swe_epu_office
        db_pwd=epuOffice
        db_user=epuOffice
        db_driver=com.mysql.jdbc.Driver*/
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
        configMenueLabel = new javax.swing.JLabel();
        dialogConfigPasswortLabel = new javax.swing.JLabel();
        dialogUebernehmen = new javax.swing.JButton();
        dialogAbbrechen = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        dialogConfigQuelleDropDown = new javax.swing.JComboBox();
        dialogConfigQuelleLabel = new javax.swing.JLabel();
        dialogConfigNameLabel = new javax.swing.JLabel();
        dialogConfigNameFeld = new javax.swing.JTextField();
        dialogConfigPasswortFeld = new javax.swing.JPasswordField();
        dialogConfigIPLabel = new javax.swing.JLabel();
        dialogConfigPortFeld = new javax.swing.JTextField();
        dialogConfigPortLabel = new javax.swing.JLabel();
        dialogConfigIPFeld = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        configMenueLabel.setFont(new java.awt.Font("Arial", 1, 14));
        configMenueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        configMenueLabel.setText("Konfigurationsmenü");
        configMenueLabel.setAlignmentX(0.5F);
        jPanel1.add(configMenueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        dialogConfigPasswortLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        dialogConfigPasswortLabel.setText("Passwort");
        jPanel1.add(dialogConfigPasswortLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        dialogUebernehmen.setText("Übernehmen");
        dialogUebernehmen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dialogUebernehmenActionPerformed(evt);
            }
        });
        jPanel1.add(dialogUebernehmen, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 110, -1));

        dialogAbbrechen.setText("Abbrechen");
        dialogAbbrechen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dialogAbbrechenActionPerformed(evt);
            }
        });
        jPanel1.add(dialogAbbrechen, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 110, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 290, 10));

        dialogConfigQuelleDropDown.setName("dialogConfigQuelleDropDown"); // NOI18N
        jPanel1.add(dialogConfigQuelleDropDown, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 150, -1));

        dialogConfigQuelleLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        dialogConfigQuelleLabel.setText("Datenquelle ");
        jPanel1.add(dialogConfigQuelleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        dialogConfigNameLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        dialogConfigNameLabel.setText("Username");
        jPanel1.add(dialogConfigNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        dialogConfigNameFeld.setName("dialogConfigNameFeld"); // NOI18N
        jPanel1.add(dialogConfigNameFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 150, -1));

        dialogConfigPasswortFeld.setName("dialogConfigPasswortFeld"); // NOI18N
        jPanel1.add(dialogConfigPasswortFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 150, -1));

        dialogConfigIPLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        dialogConfigIPLabel.setText("IP-Adresse");
        jPanel1.add(dialogConfigIPLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        dialogConfigPortFeld.setName("dialogConfigPortFeld"); // NOI18N
        jPanel1.add(dialogConfigPortFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 150, -1));

        dialogConfigPortLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        dialogConfigPortLabel.setText("Port");
        jPanel1.add(dialogConfigPortLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        dialogConfigIPFeld.setName("dialogConfigIPFeld"); // NOI18N
        jPanel1.add(dialogConfigIPFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 150, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dialogUebernehmenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialogUebernehmenActionPerformed
        ArrayList<String> changes = new ArrayList<String>();
        if (dialogConfigQuelleDropDown.getSelectedIndex() == 0) {
            changes.add("mySQL");
        } else {
            changes.add("mock");
        }
        changes.add(dialogConfigNameFeld.getText());
        changes.add((String.valueOf(dialogConfigPasswortFeld.getPassword())));
        
        //System.out.println("pasworrrrrrt:   "+ (String.valueOf(dialogConfigPasswortFeld.getPassword())));
        changes.add(dialogConfigIPFeld.getText());
        changes.add(dialogConfigPortFeld.getText());
        c.save(changes);
        dispose();
}//GEN-LAST:event_dialogUebernehmenActionPerformed
    
    private void dialogAbbrechenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialogAbbrechenActionPerformed
        // TODO add your handling code here:
        dispose();
}//GEN-LAST:event_dialogAbbrechenActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                ConfigForm dialog = new ConfigForm(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton dialogAbbrechen;
    private javax.swing.JTextField dialogConfigIPFeld;
    private javax.swing.JLabel dialogConfigIPLabel;
    private javax.swing.JTextField dialogConfigNameFeld;
    private javax.swing.JLabel dialogConfigNameLabel;
    private javax.swing.JPasswordField dialogConfigPasswortFeld;
    private javax.swing.JLabel dialogConfigPasswortLabel;
    private javax.swing.JTextField dialogConfigPortFeld;
    private javax.swing.JLabel dialogConfigPortLabel;
    private javax.swing.JComboBox dialogConfigQuelleDropDown;
    private javax.swing.JLabel dialogConfigQuelleLabel;
    private javax.swing.JButton dialogUebernehmen;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
