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

import controller.Binder;
import controller.BinderProperty;
import model.dal.DALFactory;
import model.dal.IDAL;
import controller.ProjektController;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import javax.swing.DefaultListModel;
import model.AbstractObject;
import model.Angebot;
import model.Arbeitsstunden;
import model.Projekt;
import model.dal.DALException;
import utils.log.Logger;

/**
 *
 * @author Goran-Goggy
 */
public class ProjektView extends AbstractViewPanel {

    private ProjektController controller;
    private IDAL db = DALFactory.getDAL();

    /** Creates new form ProjektView */
    public ProjektView(ProjektController controller) {
        this.controller = controller;
        initComponents();
        initialize();
    }

    private void initialize() {
        Binder.bind(Projekt.class, projektListe);

        Binder.bind(projektListe, projektNameFeld);
        Binder.bind(projektListe, projektVonFeld);
        Binder.bind(projektListe, projektBisFeld);
        Binder.bind(projektListe, projektAbgeschlossenCheckBox);
        Binder.bind(projektListe, projektAngebotComboBox);
        Binder.bind(projektListe, projektStundenGesamtFeld);
        Binder.bind(projektListe, projektMitarbeiterListe);
        Binder.bind(projektListe, projektAendern);
        Binder.bind(projektListe, projektLoeschen);

        Binder.bind(Angebot.class, projektAngebotComboBox);
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
        projektStundenGesamtFeld = new javax.swing.JTextField();
        projektNameLabel = new javax.swing.JLabel();
        projektNameFeld = new javax.swing.JTextField();
        projektImplementierungVonLabel1 = new javax.swing.JLabel();
        projektArbeitsstundenGesamt = new javax.swing.JLabel();
        projektAbgeschlossenCheckBox = new javax.swing.JCheckBox();
        projektHinzufuegen = new javax.swing.JButton();
        projektLoeschen = new javax.swing.JButton();
        projektAendern = new javax.swing.JButton();
        projektAngebotComboBox = new javax.swing.JComboBox();
        projektBisFeld = new com.toedter.calendar.JDateChooser();
        projektVonFeld = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        projektMitarbeiterListe = new javax.swing.JList();
        mitarbeiterListeLabel1 = new javax.swing.JLabel();

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
        projektListe.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        projektListe.setName("ProjektListe"); // NOI18N
        jScrollPane1.setViewportView(projektListe);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 200, 190));

        projektAuftragLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        projektAuftragLabel.setText("Angebot");
        add(projektAuftragLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, -1, -1));

        projektImplementierungVonLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        projektImplementierungVonLabel.setText("Von");
        add(projektImplementierungVonLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, -1, -1));

        projektImplementierungBisLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        projektImplementierungBisLabel.setText("Bis");
        add(projektImplementierungBisLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, -1, -1));

        projektStundenGesamtFeld.setEditable(false);
        projektStundenGesamtFeld.setEnabled(false);
        projektStundenGesamtFeld.setName("ProjektStundenGesamt"); // NOI18N
        projektStundenGesamtFeld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projektStundenGesamtFeldActionPerformed(evt);
            }
        });
        add(projektStundenGesamtFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, 80, -1));

        projektNameLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        projektNameLabel.setText("Name");
        add(projektNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, -1, -1));

        projektNameFeld.setEnabled(false);
        projektNameFeld.setName("Name"); // NOI18N
        projektNameFeld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projektNameFeldActionPerformed(evt);
            }
        });
        add(projektNameFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 180, -1));

        projektImplementierungVonLabel1.setFont(new java.awt.Font("Tahoma", 0, 15));
        projektImplementierungVonLabel1.setText("Abgeschlossen");
        add(projektImplementierungVonLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, -1, -1));

        projektArbeitsstundenGesamt.setFont(new java.awt.Font("Tahoma", 0, 15));
        projektArbeitsstundenGesamt.setText("bisheriger Aufwand (h)");
        add(projektArbeitsstundenGesamt, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, -1, -1));

        projektAbgeschlossenCheckBox.setEnabled(false);
        projektAbgeschlossenCheckBox.setName("IsAbgeschlossen"); // NOI18N
        add(projektAbgeschlossenCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, -1, -1));

        projektHinzufuegen.setText("Projekt hinzufügen");
        projektHinzufuegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projektHinzufuegenActionPerformed(evt);
            }
        });
        add(projektHinzufuegen, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 240, -1));

        projektLoeschen.setText("Projekt löschen");
        projektLoeschen.setEnabled(false);
        projektLoeschen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projektLoeschenActionPerformed(evt);
            }
        });
        add(projektLoeschen, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 240, 230, -1));

        projektAendern.setText("Projektdaten sichern");
        projektAendern.setEnabled(false);
        projektAendern.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projektAendernActionPerformed(evt);
            }
        });
        add(projektAendern, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 240, 230, -1));

        projektAngebotComboBox.setEnabled(false);
        projektAngebotComboBox.setName("Angebot"); // NOI18N
        add(projektAngebotComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 180, -1));

        projektBisFeld.setEnabled(false);
        projektBisFeld.setName("Bis"); // NOI18N
        add(projektBisFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 100, -1));

        projektVonFeld.setEnabled(false);
        projektVonFeld.setName("Von"); // NOI18N
        add(projektVonFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 100, -1));

        projektMitarbeiterListe.setFont(new java.awt.Font("Tahoma", 2, 12));
        projektMitarbeiterListe.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        projektMitarbeiterListe.setName("MitarbeiterFromProjekt"); // NOI18N
        jScrollPane2.setViewportView(projektMitarbeiterListe);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, 200, 190));

        mitarbeiterListeLabel1.setFont(new java.awt.Font("Arial", 1, 14));
        mitarbeiterListeLabel1.setText("Mitarbeiter im Projekt");
        add(mitarbeiterListeLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void projektStundenGesamtFeldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projektStundenGesamtFeldActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_projektStundenGesamtFeldActionPerformed

    private void projektNameFeldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projektNameFeldActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_projektNameFeldActionPerformed

    private void projektAendernActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projektAendernActionPerformed
        if (this.projektListe.isSelectionEmpty()) {
            return;
        }

        ArrayList<String> errorList;
        errorList = Binder.save(Projekt.class, createBinderPropertiesFromFields());
        showErrors(errorList);
}//GEN-LAST:event_projektAendernActionPerformed

    private ArrayList<BinderProperty> createBinderPropertiesFromFields() {
        ArrayList list = new ArrayList<BinderProperty>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        list.add(new BinderProperty(projektNameFeld.getName(), projektNameFeld.getText(), String.class));
        list.add(new BinderProperty(projektVonFeld.getName(), projektVonFeld.getDate() != null ? sdf.format(projektVonFeld.getDate()) : "", Date.class));
        list.add(new BinderProperty(projektBisFeld.getName(), projektBisFeld.getDate() != null ? sdf.format(projektBisFeld.getDate()) : "", Date.class));
        list.add(new BinderProperty(projektAbgeschlossenCheckBox.getName(), ((Boolean) projektAbgeschlossenCheckBox.isSelected()).toString(), Boolean.class));
        if (projektAngebotComboBox.getSelectedItem() instanceof Angebot) {
            list.add(new BinderProperty("Angebot", ((Angebot) projektAngebotComboBox.getSelectedItem()).getId().toString(), AbstractObject.class));
        } else {
            list.add(new BinderProperty("Angebot", "", AbstractObject.class));
        }
        Projekt p = (Projekt) projektListe.getSelectedValue();
        if (p != null) {
            list.add(new BinderProperty("Id", p.getId().toString(), Integer.class));
        } else {
            list.add(new BinderProperty("Id", "0", Integer.class));
        }
        return list;
    }

    private void projektHinzufuegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projektHinzufuegenActionPerformed
        DefaultListModel model = (DefaultListModel) projektListe.getModel();
        // solange ein nicht gespeicherter Kontakt, kein neuer Kontakt
        if (model.getSize() > 0 && ((Projekt) model.getElementAt(model.getSize() - 1)).getId() == 0) {
            return;
        }
        Projekt p = new Projekt();
        p.setId(0);
        model.addElement(p);
        projektListe.setSelectedIndex(model.getSize() - 1);
        this.resetFields();
    }//GEN-LAST:event_projektHinzufuegenActionPerformed

    private void projektLoeschenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projektLoeschenActionPerformed
        Projekt p = (Projekt) this.projektListe.getSelectedValue();
        try {
            if (!(projektListe.isSelectionEmpty())) {
                db.deleteProjekt(p);
            }
        } catch (DALException ex) {
            Logger.log(Level.SEVERE, KontakteView.class, ex);
        }
    }//GEN-LAST:event_projektLoeschenActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel kundenInfoLabel;
    private javax.swing.JLabel kundenListeLabel;
    private javax.swing.JLabel mitarbeiterListeLabel1;
    private javax.swing.JCheckBox projektAbgeschlossenCheckBox;
    private javax.swing.JButton projektAendern;
    private javax.swing.JComboBox projektAngebotComboBox;
    private javax.swing.JLabel projektArbeitsstundenGesamt;
    private javax.swing.JLabel projektAuftragLabel;
    private com.toedter.calendar.JDateChooser projektBisFeld;
    private javax.swing.JButton projektHinzufuegen;
    private javax.swing.JLabel projektImplementierungBisLabel;
    private javax.swing.JLabel projektImplementierungVonLabel;
    private javax.swing.JLabel projektImplementierungVonLabel1;
    private javax.swing.JList projektListe;
    private javax.swing.JButton projektLoeschen;
    private javax.swing.JList projektMitarbeiterListe;
    private javax.swing.JTextField projektNameFeld;
    private javax.swing.JLabel projektNameLabel;
    private javax.swing.JTextField projektStundenGesamtFeld;
    private com.toedter.calendar.JDateChooser projektVonFeld;
    // End of variables declaration//GEN-END:variables
}
