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
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
public abstract class AbstractViewPanel extends JPanel {

    protected void resetTextFields() {
        this.cleanErrors();
        for (Component c : this.getComponents()) {
            if (c instanceof JScrollPane) {
                for (Component sc : ((JScrollPane)c).getViewport().getComponents()) {
                    if (sc.getClass() == JTextArea.class) {
                        ((JTextArea) sc).setText("");
                    }
                }
            }
            if (c.getName() != null) {
                //c.setEnabled(false);
                if (c.getClass() == JTextField.class) {
                    ((JTextField) c).setText("");
                } else if (c.getClass() == JCheckBox.class) {
                    ((JCheckBox) c).setSelected(false);
                } else if (c.getClass() == JDateChooser.class) {
                    ((JDateChooser) c).setDate(null);
                } else if (c.getClass() == JTextArea.class) {
                    ((JTextArea) c).setText("");
                }
            }
        }
    }

    protected void showErrors(ArrayList<String> errorList) {
        cleanErrors();
        if (errorList != null && !errorList.isEmpty()) {
            for (String error : errorList) {
                for (Component c : this.getComponents()) {
                    if (c.getClass() == JTextField.class && c.getName() != null && c.getName().equals(error)) {
                        ((JTextField) c).setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
                        break;

                    }
                }
            }
        } else {
            resetTextFields();
        }
    }

    protected void cleanErrors() {
        for (Component c : this.getComponents()) {
            if (c.getClass() == JTextField.class && c.getName() != null) {
                ((JTextField) c).setBorder(BorderFactory.createEtchedBorder());//BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
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
