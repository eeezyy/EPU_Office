/*
 * AbstractViewPanel.java
 *
 * Created on January 22, 2007, 9:06 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package view;

import controller.AbstractController;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
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

    protected abstract void resetTextFields();

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
