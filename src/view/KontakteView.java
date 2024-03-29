/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Kontakte.java
 *
 * Created on 09.04.2011, 15:11:42
 */
package view;

import controller.Binder;
import controller.BinderProperty;
import controller.KontaktController;
import java.util.logging.Level;
import utils.log.Logger;
import model.dal.DALException;
import view.dialog.KontaktAddForm;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import model.Kontakt;
import model.dal.DALFactory;
import model.dal.IDAL;
import view.dialog.AngebotToKundeForm;

/**
 *
 * @author Goran-Goggy
 */
public final class KontakteView extends AbstractViewPanel {

    private KontaktController controller;
    private IDAL db = DALFactory.getDAL();

    /** Creates new form Kontakte */
    public KontakteView(KontaktController controller) {
        initComponents();
        this.controller = controller;
        this.initialize();
    }

    public void initialize() {

        kontaktIdFeld.setVisible(false);

        Binder.bind(kontaktListe, kontaktFirmennameFeld);
        Binder.bind(kontaktListe, kontaktVornameFeld);
        Binder.bind(kontaktListe, kontaktNachnameFeld);
        Binder.bind(kontaktListe, kontaktTelefonFeld);
        Binder.bind(kontaktListe, kontaktEmailFeld);
        Binder.bind(kontaktListe, kontaktBankinstitutFeld);
        Binder.bind(kontaktListe, kontaktBlzFeld);
        Binder.bind(kontaktListe, kontaktKontoFeld);
        Binder.bind(kontaktListe, kontaktStrasseFeld);
        Binder.bind(kontaktListe, kontaktHausnrFeld);
        Binder.bind(kontaktListe, kontaktPlzFeld);
        Binder.bind(kontaktListe, kontaktOrtFeld);
        Binder.bind(kontaktListe, kontaktIsKundeFeld);
        Binder.bind(kontaktListe, kontaktIdFeld);
        
        Binder.bind(kontaktListe, kontaktAendern);
        Binder.bind(kontaktListe, kontaktLoeschen);

        Binder.bind(Kontakt.class, kontaktListe);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kontaktNameFeld1 = new javax.swing.JTextField();
        kontaktListeLabel = new javax.swing.JLabel();
        kontaktInfoLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        kontaktListe = new javax.swing.JList();
        kontaktKontoNrLabel = new javax.swing.JLabel();
        kontakVorNameLabel = new javax.swing.JLabel();
        kontaktTelLabel = new javax.swing.JLabel();
        kontaktEmailLabel = new javax.swing.JLabel();
        kontaktBankInstLabel = new javax.swing.JLabel();
        kontaktBLZNrLabel = new javax.swing.JLabel();
        kontaktEmailFeld = new javax.swing.JTextField();
        kontaktTelefonFeld = new javax.swing.JTextField();
        kontaktBankinstitutFeld = new javax.swing.JTextField();
        kontaktHinzufuegen = new javax.swing.JButton();
        kontaktLoeschen = new javax.swing.JButton();
        kontaktVornameFeld = new javax.swing.JTextField();
        KontaktangebotZuweisen = new javax.swing.JButton();
        kontaktNachNameLabel = new javax.swing.JLabel();
        kontaktNachnameFeld = new javax.swing.JTextField();
        kontaktStrasseLabel = new javax.swing.JLabel();
        kontaktStrasseFeld = new javax.swing.JTextField();
        kontaktTuerNrLabel = new javax.swing.JLabel();
        kontaktPLZLabel = new javax.swing.JLabel();
        kontakOrtLabel = new javax.swing.JLabel();
        kontaktOrtFeld = new javax.swing.JTextField();
        kontaktFirmaLabel = new javax.swing.JLabel();
        kontaktFirmennameFeld = new javax.swing.JTextField();
        kontaktAendern = new javax.swing.JButton();
        kontaktPlzFeld = new javax.swing.JTextField();
        kontaktHausnrFeld = new javax.swing.JTextField();
        kontaktKontoFeld = new javax.swing.JTextField();
        kontaktBlzFeld = new javax.swing.JTextField();
        kontaktIsKundeFeld = new javax.swing.JCheckBox();
        kontaktIdFeld = new javax.swing.JTextField();

        kontaktNameFeld1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kontaktNameFeld1ActionPerformed(evt);
            }
        });

        setEnabled(false);
        setMaximumSize(new java.awt.Dimension(800, 380));
        setMinimumSize(new java.awt.Dimension(800, 380));
        setPreferredSize(new java.awt.Dimension(800, 380));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kontaktListeLabel.setFont(new java.awt.Font("Arial", 1, 14));
        kontaktListeLabel.setText("Kontaktliste");
        add(kontaktListeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        kontaktInfoLabel.setFont(new java.awt.Font("Arial", 1, 14));
        kontaktInfoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kontaktInfoLabel.setText("Kontaktinformation");
        kontaktInfoLabel.setAlignmentX(0.5F);
        add(kontaktInfoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, -1, -1));

        kontaktListe.setFont(new java.awt.Font("Tahoma", 2, 12));
        kontaktListe.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        kontaktListe.setName("KontaktListe"); // NOI18N
        kontaktListe.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                kontaktListeValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(kontaktListe);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 200, 190));

        kontaktKontoNrLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        kontaktKontoNrLabel.setText("Konto-Nr.");
        add(kontaktKontoNrLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 120, -1, -1));

        kontakVorNameLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        kontakVorNameLabel.setText("Vorname");
        add(kontakVorNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, -1, -1));

        kontaktTelLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        kontaktTelLabel.setText("Telefon-Nr.");
        add(kontaktTelLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, -1, -1));

        kontaktEmailLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        kontaktEmailLabel.setText("Email");
        add(kontaktEmailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, -1, -1));

        kontaktBankInstLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        kontaktBankInstLabel.setText("Bankinst.");
        add(kontaktBankInstLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, -1, -1));

        kontaktBLZNrLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        kontaktBLZNrLabel.setText("BLZ");
        add(kontaktBLZNrLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, -1, -1));

        kontaktEmailFeld.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        kontaktEmailFeld.setEnabled(false);
        kontaktEmailFeld.setName("Email"); // NOI18N
        add(kontaktEmailFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, 150, -1));

        kontaktTelefonFeld.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        kontaktTelefonFeld.setEnabled(false);
        kontaktTelefonFeld.setName("Telefon"); // NOI18N
        add(kontaktTelefonFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 150, -1));

        kontaktBankinstitutFeld.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        kontaktBankinstitutFeld.setEnabled(false);
        kontaktBankinstitutFeld.setName("Bankinstitut"); // NOI18N
        add(kontaktBankinstitutFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 150, -1));

        kontaktHinzufuegen.setText("Kontakt hinzufügen");
        kontaktHinzufuegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kontaktHinzufuegenActionPerformed(evt);
            }
        });
        add(kontaktHinzufuegen, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 200, -1));

        kontaktLoeschen.setText("Kontakt löschen");
        kontaktLoeschen.setEnabled(false);
        kontaktLoeschen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kontaktLoeschenActionPerformed(evt);
            }
        });
        add(kontaktLoeschen, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 240, 230, -1));

        kontaktVornameFeld.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        kontaktVornameFeld.setEnabled(false);
        kontaktVornameFeld.setName("Vorname"); // NOI18N
        add(kontaktVornameFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, 150, -1));

        KontaktangebotZuweisen.setText("Angebot zuweisen");
        KontaktangebotZuweisen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KontaktangebotZuweisenActionPerformed(evt);
            }
        });
        add(KontaktangebotZuweisen, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 230, -1));

        kontaktNachNameLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        kontaktNachNameLabel.setText("Nachname");
        add(kontaktNachNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 40, -1, -1));

        kontaktNachnameFeld.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        kontaktNachnameFeld.setEnabled(false);
        kontaktNachnameFeld.setName("Nachname"); // NOI18N
        add(kontaktNachnameFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 40, 150, -1));

        kontaktStrasseLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        kontaktStrasseLabel.setText("Straße");
        add(kontaktStrasseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, -1, -1));

        kontaktStrasseFeld.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        kontaktStrasseFeld.setEnabled(false);
        kontaktStrasseFeld.setName("Strasse"); // NOI18N
        add(kontaktStrasseFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 150, -1));

        kontaktTuerNrLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        kontaktTuerNrLabel.setText("Haus-Nr.");
        add(kontaktTuerNrLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, -1, -1));

        kontaktPLZLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        kontaktPLZLabel.setText("PLZ");
        add(kontaktPLZLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 160, -1, -1));

        kontakOrtLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        kontakOrtLabel.setText("Ort");
        add(kontakOrtLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, -1, -1));

        kontaktOrtFeld.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        kontaktOrtFeld.setEnabled(false);
        kontaktOrtFeld.setName("Ort"); // NOI18N
        add(kontaktOrtFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 150, -1));

        kontaktFirmaLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        kontaktFirmaLabel.setText("Firma");
        add(kontaktFirmaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, -1, -1));

        kontaktFirmennameFeld.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        kontaktFirmennameFeld.setEnabled(false);
        kontaktFirmennameFeld.setName("Firmenname"); // NOI18N
        add(kontaktFirmennameFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 150, -1));

        kontaktAendern.setText("Kontakt sichern");
        kontaktAendern.setEnabled(false);
        kontaktAendern.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kontaktAendernActionPerformed(evt);
            }
        });
        add(kontaktAendern, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, 230, -1));

        kontaktPlzFeld.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        kontaktPlzFeld.setEnabled(false);
        kontaktPlzFeld.setName("Plz"); // NOI18N
        add(kontaktPlzFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 160, 150, -1));

        kontaktHausnrFeld.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        kontaktHausnrFeld.setEnabled(false);
        kontaktHausnrFeld.setName("Hausnr"); // NOI18N
        add(kontaktHausnrFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 160, 150, -1));

        kontaktKontoFeld.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        kontaktKontoFeld.setEnabled(false);
        kontaktKontoFeld.setName("Konto"); // NOI18N
        add(kontaktKontoFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 120, 150, -1));

        kontaktBlzFeld.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        kontaktBlzFeld.setEnabled(false);
        kontaktBlzFeld.setName("Blz"); // NOI18N
        add(kontaktBlzFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 120, 150, -1));

        kontaktIsKundeFeld.setFont(new java.awt.Font("Tahoma", 0, 15));
        kontaktIsKundeFeld.setText("Kunde");
        kontaktIsKundeFeld.setEnabled(false);
        kontaktIsKundeFeld.setName("IsKunde"); // NOI18N
        kontaktIsKundeFeld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kontaktIsKundeFeldActionPerformed(evt);
            }
        });
        add(kontaktIsKundeFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 187, -1, 40));
        kontaktIsKundeFeld.getAccessibleContext().setAccessibleName(null);

        kontaktIdFeld.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        kontaktIdFeld.setEnabled(false);
        kontaktIdFeld.setName("Id"); // NOI18N
        add(kontaktIdFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 30, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void kontaktHinzufuegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kontaktHinzufuegenActionPerformed
        DefaultListModel model = (DefaultListModel) kontaktListe.getModel();
        // solange ein nicht gespeicherter Kontakt, kein neuer Kontakt
        if(model.getSize() > 0 && ((Kontakt)model.getElementAt(model.getSize()-1)).getId() == 0)
            return;
        Kontakt k = new Kontakt();
        k.setId(0);
        model.addElement(k);
        kontaktListe.setSelectedIndex(model.getSize()-1);
        this.resetFields();
    }//GEN-LAST:event_kontaktHinzufuegenActionPerformed

    private void kontaktNameFeld1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kontaktNameFeld1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kontaktNameFeld1ActionPerformed

    private void kontaktAendernActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kontaktAendernActionPerformed
        if (this.kontaktListe.isSelectionEmpty()) {
            return;
        }

        ArrayList<String> errorList;
        errorList = Binder.save(Kontakt.class, createBinderPropertiesFromFields());
        showErrors(errorList);

    }//GEN-LAST:event_kontaktAendernActionPerformed

    private ArrayList<BinderProperty> createBinderPropertiesFromFields() {
        ArrayList list = new ArrayList<BinderProperty>();

        list.add(new BinderProperty(kontaktStrasseFeld.getName(), kontaktStrasseFeld.getText(), String.class));
        list.add(new BinderProperty(kontaktHausnrFeld.getName(), kontaktHausnrFeld.getText(), Integer.class));
        list.add(new BinderProperty(kontaktPlzFeld.getName(), kontaktPlzFeld.getText(), Integer.class));
        list.add(new BinderProperty(kontaktOrtFeld.getName(), kontaktOrtFeld.getText(), String.class));
        list.add(new BinderProperty(kontaktBankinstitutFeld.getName(), kontaktBankinstitutFeld.getText(), String.class));
        list.add(new BinderProperty(kontaktBlzFeld.getName(), kontaktBlzFeld.getText(), Integer.class));
        list.add(new BinderProperty(kontaktEmailFeld.getName(), kontaktEmailFeld.getText(), String.class));
        list.add(new BinderProperty(kontaktFirmennameFeld.getName(), kontaktFirmennameFeld.getText(), String.class));
        list.add(new BinderProperty(kontaktIsKundeFeld.getName(), ((Boolean) kontaktIsKundeFeld.isSelected()).toString(), Boolean.class));
        list.add(new BinderProperty(kontaktKontoFeld.getName(), kontaktKontoFeld.getText(), Long.class));
        list.add(new BinderProperty(kontaktNachnameFeld.getName(), kontaktNachnameFeld.getText(), String.class));
        list.add(new BinderProperty(kontaktVornameFeld.getName(), kontaktVornameFeld.getText(), String.class));
        list.add(new BinderProperty(kontaktTelefonFeld.getName(), kontaktTelefonFeld.getText(), String.class));
        list.add(new BinderProperty(kontaktIdFeld.getName(), kontaktIdFeld.getText(), Integer.class));
        return list;
    }

    private void kontaktLoeschenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kontaktLoeschenActionPerformed
        Kontakt k = (Kontakt) this.kontaktListe.getSelectedValue();
        try {
            if(!(kontaktListe.isSelectionEmpty())){
            db.deleteKontakt(k);
            }
        } catch (DALException ex) {
            Logger.log(Level.SEVERE, KontakteView.class, ex);
        }
    }//GEN-LAST:event_kontaktLoeschenActionPerformed

    private void kontaktListeValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_kontaktListeValueChanged
    }//GEN-LAST:event_kontaktListeValueChanged

    private void kontaktIsKundeFeldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kontaktIsKundeFeldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kontaktIsKundeFeldActionPerformed

    private void KontaktangebotZuweisenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KontaktangebotZuweisenActionPerformed
        // TODO add your handling code here:
        if (kontaktListe.getSelectedValue() != null) {
            AngebotToKundeForm aTK = new AngebotToKundeForm(null, true, (Kontakt) kontaktListe.getSelectedValue());
            aTK.setVisible(true);
        }
    }//GEN-LAST:event_KontaktangebotZuweisenActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton KontaktangebotZuweisen;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel kontakOrtLabel;
    private javax.swing.JLabel kontakVorNameLabel;
    private javax.swing.JButton kontaktAendern;
    private javax.swing.JLabel kontaktBLZNrLabel;
    private javax.swing.JLabel kontaktBankInstLabel;
    private javax.swing.JTextField kontaktBankinstitutFeld;
    private javax.swing.JTextField kontaktBlzFeld;
    private javax.swing.JTextField kontaktEmailFeld;
    private javax.swing.JLabel kontaktEmailLabel;
    private javax.swing.JLabel kontaktFirmaLabel;
    private javax.swing.JTextField kontaktFirmennameFeld;
    private javax.swing.JTextField kontaktHausnrFeld;
    private javax.swing.JButton kontaktHinzufuegen;
    private javax.swing.JTextField kontaktIdFeld;
    private javax.swing.JLabel kontaktInfoLabel;
    private javax.swing.JCheckBox kontaktIsKundeFeld;
    private javax.swing.JTextField kontaktKontoFeld;
    private javax.swing.JLabel kontaktKontoNrLabel;
    private javax.swing.JList kontaktListe;
    private javax.swing.JLabel kontaktListeLabel;
    private javax.swing.JButton kontaktLoeschen;
    private javax.swing.JLabel kontaktNachNameLabel;
    private javax.swing.JTextField kontaktNachnameFeld;
    private javax.swing.JTextField kontaktNameFeld1;
    private javax.swing.JTextField kontaktOrtFeld;
    private javax.swing.JLabel kontaktPLZLabel;
    private javax.swing.JTextField kontaktPlzFeld;
    private javax.swing.JTextField kontaktStrasseFeld;
    private javax.swing.JLabel kontaktStrasseLabel;
    private javax.swing.JLabel kontaktTelLabel;
    private javax.swing.JTextField kontaktTelefonFeld;
    private javax.swing.JLabel kontaktTuerNrLabel;
    private javax.swing.JTextField kontaktVornameFeld;
    // End of variables declaration//GEN-END:variables

    private void setKontaktListe(ArrayList<Kontakt> kontakte) {
        DefaultListModel list = new DefaultListModel();
        for (Kontakt k : kontakte) {
            list.addElement(k);
        }

        this.kontaktListe.setModel(list);
    }
}
