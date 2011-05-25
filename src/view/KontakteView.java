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
import controller.KontaktController;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dal.DALException;
import view.dialog.KontaktAddForm;
import controller.ModelObservable;
import controller.ModelObserver;
import controller.NotifyObject;
import controller.State;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import model.Kontakt;
import model.dal.DALDatabase;
import model.dal.DALFactory;

/**
 *
 * @author Goran-Goggy
 */
public class KontakteView extends AbstractViewPanel {

    private KontaktController controller;
    private ModelObservable observable;
    private ModelObserver observer;

    /** Creates new form Kontakte */
    public KontakteView(ModelObservable observable, KontaktController controller) {
        super(observable);
        initComponents();
        this.controller = controller;
        this.observable = observable;
        this.observer = new ModelObserver(this);
        this.observable.addObserver(this.observer);
        System.out.println("count observers " + this.observable.countObservers());
        this.initialize();
    }
    
    public void initialize() {
        try {
            // TODO direkt vom model holen, darf nichts vom controll wissen
            System.out.println("initialize");
            this.setKontaktListe(controller.getKontaktListe());
        } catch (DALException ex) {
            Logger.getLogger(KontakteView.class.getName()).log(Level.SEVERE, null, ex);
        }
        Binder binder = new Binder();
        try {
            binder.bind(kontaktListe, kontaktVorNameFeld, "Vorname");
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(KontakteView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(KontakteView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(KontakteView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(KontakteView.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        kontaktNameFeld = new javax.swing.JTextField();
        kontaktTelFeld = new javax.swing.JTextField();
        kontaktBankInstFeld = new javax.swing.JTextField();
        kontaktHinzufuegen = new javax.swing.JButton();
        kontaktLoeschen = new javax.swing.JButton();
        kontaktBLZNrFeld = new javax.swing.JFormattedTextField();
        kontaktKontoNrFeld = new javax.swing.JFormattedTextField();
        kontaktVorNameFeld = new javax.swing.JTextField();
        KontaktangebotZuweisen = new javax.swing.JButton();
        kontaktNachNameLabel = new javax.swing.JLabel();
        kontaktNachNameFeld1 = new javax.swing.JTextField();
        kontaktStrasseLabel = new javax.swing.JLabel();
        kontaktStrasseFeld = new javax.swing.JTextField();
        kontaktTuerNrLabel = new javax.swing.JLabel();
        kontaktPLZLabel = new javax.swing.JLabel();
        kontaktPLZFeld = new javax.swing.JFormattedTextField();
        kontakOrtLabel = new javax.swing.JLabel();
        kontaktOrtFeld = new javax.swing.JTextField();
        kontaktBLZNrFeld1 = new javax.swing.JFormattedTextField();
        kontaktFirmaLabel = new javax.swing.JLabel();
        kontaktFirmaFeld = new javax.swing.JTextField();
        kontaktAendern = new javax.swing.JButton();

        kontaktNameFeld1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kontaktNameFeld1ActionPerformed(evt);
            }
        });

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

        kontaktListe.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        kontaktListe.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
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
        kontaktBLZNrLabel.setText("BLZ-Nr.");
        add(kontaktBLZNrLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, -1, -1));

        kontaktNameFeld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kontaktNameFeldActionPerformed(evt);
            }
        });
        add(kontaktNameFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, 150, -1));
        add(kontaktTelFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 150, -1));
        add(kontaktBankInstFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 150, -1));

        kontaktHinzufuegen.setText("Kontakt hinzufügen");
        kontaktHinzufuegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kontaktHinzufuegenActionPerformed(evt);
            }
        });
        add(kontaktHinzufuegen, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, 230, -1));

        kontaktLoeschen.setText("Kontakt löschen");
        kontaktLoeschen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kontaktLoeschenActionPerformed(evt);
            }
        });
        add(kontaktLoeschen, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 230, -1));

        try {
            kontaktBLZNrFeld.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        add(kontaktBLZNrFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 160, 150, -1));

        try {
            kontaktKontoNrFeld.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        add(kontaktKontoNrFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 120, 150, -1));

        kontaktVorNameFeld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kontaktVorNameFeldActionPerformed(evt);
            }
        });
        add(kontaktVorNameFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, 150, -1));

        KontaktangebotZuweisen.setText("Angebot zuweisen");
        add(KontaktangebotZuweisen, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 200, -1));

        kontaktNachNameLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        kontaktNachNameLabel.setText("Nachname");
        add(kontaktNachNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 40, -1, -1));

        kontaktNachNameFeld1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kontaktNachNameFeld1ActionPerformed(evt);
            }
        });
        add(kontaktNachNameFeld1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 40, 150, -1));

        kontaktStrasseLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        kontaktStrasseLabel.setText("Straße");
        add(kontaktStrasseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, -1, -1));
        add(kontaktStrasseFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 150, -1));

        kontaktTuerNrLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        kontaktTuerNrLabel.setText("Tür-Nr.");
        add(kontaktTuerNrLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, -1, -1));

        kontaktPLZLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        kontaktPLZLabel.setText("PLZ");
        add(kontaktPLZLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 160, -1, -1));

        try {
            kontaktPLZFeld.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        add(kontaktPLZFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 160, 150, -1));

        kontakOrtLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        kontakOrtLabel.setText("Ort");
        add(kontakOrtLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, -1, -1));

        kontaktOrtFeld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kontaktOrtFeldActionPerformed(evt);
            }
        });
        add(kontaktOrtFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 150, -1));

        try {
            kontaktBLZNrFeld1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        add(kontaktBLZNrFeld1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 120, 150, -1));

        kontaktFirmaLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        kontaktFirmaLabel.setText("Firma");
        add(kontaktFirmaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, -1, -1));

        kontaktFirmaFeld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kontaktFirmaFeldActionPerformed(evt);
            }
        });
        add(kontaktFirmaFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 150, -1));

        kontaktAendern.setText("Kontakt ändern");
        kontaktAendern.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kontaktAendernActionPerformed(evt);
            }
        });
        add(kontaktAendern, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 240, 230, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void kontaktHinzufuegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kontaktHinzufuegenActionPerformed
        KontaktAddForm af = new KontaktAddForm(this.getObservable(), null, true);
        af.setVisible(true);
    }//GEN-LAST:event_kontaktHinzufuegenActionPerformed

    private void kontaktNameFeldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kontaktNameFeldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kontaktNameFeldActionPerformed

    private void kontaktNameFeld1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kontaktNameFeld1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kontaktNameFeld1ActionPerformed

    private void kontaktVorNameFeldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kontaktVorNameFeldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kontaktVorNameFeldActionPerformed

    private void kontaktNachNameFeld1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kontaktNachNameFeld1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kontaktNachNameFeld1ActionPerformed

    private void kontaktOrtFeldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kontaktOrtFeldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kontaktOrtFeldActionPerformed

    private void kontaktFirmaFeldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kontaktFirmaFeldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kontaktFirmaFeldActionPerformed

    private void kontaktAendernActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kontaktAendernActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kontaktAendernActionPerformed

    private void kontaktLoeschenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kontaktLoeschenActionPerformed
        Kontakt k = (Kontakt)this.kontaktListe.getSelectedValue();
        try {
            DALFactory.getDAL().deleteKontakt(k);
        } catch (DALException ex) {
            Logger.getLogger(KontakteView.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("kontakt deleted");
        //observable.notifyObservers(new NotifyObject(k, State.DELETED));
        observable.notifyObservers();
        System.out.println("after notify");
        observer.update(observable, k);
    }//GEN-LAST:event_kontaktLoeschenActionPerformed

    private void kontaktListeValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_kontaktListeValueChanged
        
    }//GEN-LAST:event_kontaktListeValueChanged

    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new KontakteView(this.getObservable()).setVisible(true);
            }
        });
    }*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton KontaktangebotZuweisen;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel kontakOrtLabel;
    private javax.swing.JLabel kontakVorNameLabel;
    private javax.swing.JButton kontaktAendern;
    private javax.swing.JFormattedTextField kontaktBLZNrFeld;
    private javax.swing.JFormattedTextField kontaktBLZNrFeld1;
    private javax.swing.JLabel kontaktBLZNrLabel;
    private javax.swing.JTextField kontaktBankInstFeld;
    private javax.swing.JLabel kontaktBankInstLabel;
    private javax.swing.JLabel kontaktEmailLabel;
    private javax.swing.JTextField kontaktFirmaFeld;
    private javax.swing.JLabel kontaktFirmaLabel;
    private javax.swing.JButton kontaktHinzufuegen;
    private javax.swing.JLabel kontaktInfoLabel;
    private javax.swing.JFormattedTextField kontaktKontoNrFeld;
    private javax.swing.JLabel kontaktKontoNrLabel;
    private javax.swing.JList kontaktListe;
    private javax.swing.JLabel kontaktListeLabel;
    private javax.swing.JButton kontaktLoeschen;
    private javax.swing.JTextField kontaktNachNameFeld1;
    private javax.swing.JLabel kontaktNachNameLabel;
    private javax.swing.JTextField kontaktNameFeld;
    private javax.swing.JTextField kontaktNameFeld1;
    private javax.swing.JTextField kontaktOrtFeld;
    private javax.swing.JFormattedTextField kontaktPLZFeld;
    private javax.swing.JLabel kontaktPLZLabel;
    private javax.swing.JTextField kontaktStrasseFeld;
    private javax.swing.JLabel kontaktStrasseLabel;
    private javax.swing.JTextField kontaktTelFeld;
    private javax.swing.JLabel kontaktTelLabel;
    private javax.swing.JLabel kontaktTuerNrLabel;
    private javax.swing.JTextField kontaktVorNameFeld;
    // End of variables declaration//GEN-END:variables

    private void setKontaktListe(ArrayList<Kontakt> kontakte) {
        DefaultListModel list = new DefaultListModel();
        for(Kontakt k: kontakte) {
            list.addElement(k);
        }
        
        this.kontaktListe.setModel(list);
    }
}
