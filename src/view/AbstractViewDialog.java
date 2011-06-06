/*
 * AbstractViewPanel.java
 *
 * Created on January 22, 2007, 9:06 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package view;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * This class provides the base level abstraction for views in this example. All
 * views that extend this class also extend JPanel (which is useful for performing
 * GUI manipulations on the view in NetBeans Matisse), as well as providing the 
 * modelPropertyChange() method that controllers can use to propogate model 
 * property changes.
 *
 * @author Robert Eckstein
 */
public abstract class AbstractViewDialog extends JDialog {

    public AbstractViewDialog(Frame owner, boolean modal) {
        super(owner, modal);
    }

    protected void resetTextFields() {
        this.cleanErrors();
        for (Component c : this.getRootPane().getComponents()) {
            if (c instanceof JLayeredPane) {
                for (Component lpc : ((JLayeredPane) c).getComponents()) {
                    if (lpc instanceof JPanel) {
                        for (Component ppc : ((JPanel) lpc).getComponents()) {
                            if (ppc instanceof JPanel) {
                                for (Component pc : ((JPanel) ppc).getComponents()) {
                                    if (pc.getName() != null) {
                                        if (pc.getClass() == JTextField.class) {
                                            ((JTextField) pc).setText("");
                                        } else if (pc.getClass() == JCheckBox.class) {
                                            ((JCheckBox) pc).setSelected(false);
                                        } else if (pc.getClass() == JDateChooser.class) {
                                            ((JDateChooser) pc).setDate(null);
                                        } else if (pc.getClass() == JTextArea.class) {
                                            ((JTextArea) pc).setText("");
                                        }
                                    }
                                }
                            }
                        }
                    }

                }
            }
        }
    }

    protected void showErrors(ArrayList<String> errorList) {
        cleanErrors();
        if (errorList != null && !errorList.isEmpty()) {
            for (String error : errorList) {
                for (Component c : this.getRootPane().getComponents()) {
                    if (c instanceof JLayeredPane) {
                        for (Component lpc : ((JLayeredPane) c).getComponents()) {
                            if (lpc instanceof JPanel) {
                                for (Component ppc : ((JPanel) lpc).getComponents()) {
                                    if (ppc instanceof JPanel) {
                                        for (Component pc : ((JPanel) ppc).getComponents()) {
                                            if (pc.getClass() == JTextField.class && pc.getName() != null && pc.getName().equals(error)) {
                                                ((JTextField) pc).setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
                                                break;
                                            }
                                        }
                                    }
                                }
                            }

                        }
                    }
                }
            }
        } else {
            resetTextFields();
        }
    }

    protected void cleanErrors() {
        for (Component c : this.getRootPane().getComponents()) {
            if (c instanceof JLayeredPane) {
                for (Component lpc : ((JLayeredPane) c).getComponents()) {
                    if (lpc instanceof JPanel) {
                        for (Component ppc : ((JPanel) lpc).getComponents()) {
                            if (ppc instanceof JPanel) {
                                for (Component pc : ((JPanel) ppc).getComponents()) {
                                    if (pc.getClass() == JTextField.class && pc.getName() != null) {
                                        ((JTextField) pc).setBorder(BorderFactory.createEtchedBorder());//BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
                                    }
                                }
                            }
                        }
                    }

                }
            }
        }
    }

    protected Integer toInt(String text) {
        if (text.length() != 0) {
            return Integer.parseInt(text);
        } else {
            return null;
        }
    }

    protected Long toLong(String text) {
        if (text.length() != 0) {
            return Long.parseLong(text);
        } else {
            return null;
        }
    }
}
