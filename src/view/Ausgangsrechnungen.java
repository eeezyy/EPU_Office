/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Eingangsrechnungen.java
 *
 * Created on 08.06.2011, 19:03:47
 */
package view;

import controller.AusgangsrechnungenController;

/**
 *
 * @author Goran-Goggy
 */
public class Ausgangsrechnungen extends javax.swing.JPanel {
    private AusgangsrechnungenController controller; 
    /** Creates new form Eingangsrechnungen */
    public Ausgangsrechnungen(AusgangsrechnungenController controller) {
        this.controller = controller;
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

        jPanel1 = new javax.swing.JPanel();
        kundenListeLabel = new javax.swing.JLabel();
        kundenInfoLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        eingangsrechnungenRechnungenListe = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        eingangsrechnungenBuchungszeilenListe = new javax.swing.JList();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kundenListeLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        kundenListeLabel.setText("Buchungszeilen (Ausgangsrechnungen)");
        jPanel1.add(kundenListeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        kundenInfoLabel.setFont(new java.awt.Font("Arial", 1, 14));
        kundenInfoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kundenInfoLabel.setText("Rechnungen");
        kundenInfoLabel.setAlignmentX(0.5F);
        jPanel1.add(kundenInfoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, -1, -1));

        eingangsrechnungenRechnungenListe.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(eingangsrechnungenRechnungenListe);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, 400, 160));

        eingangsrechnungenBuchungszeilenListe.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(eingangsrechnungenBuchungszeilenListe);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 420, 160));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 250));
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList eingangsrechnungenBuchungszeilenListe;
    private javax.swing.JList eingangsrechnungenRechnungenListe;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel kundenInfoLabel;
    private javax.swing.JLabel kundenListeLabel;
    // End of variables declaration//GEN-END:variables
}
