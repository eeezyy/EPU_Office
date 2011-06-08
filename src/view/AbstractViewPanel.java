
package view;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public abstract class AbstractViewPanel extends JPanel {

    protected void resetFieldsNotComboBox() {
        //this.cleanErrors();
        for (Component c : this.getComponents()) {
            if (c instanceof JScrollPane) {
                for (Component sc : ((JScrollPane) c).getViewport().getComponents()) {
                    if (sc.getClass() == JTextArea.class) {
                        ((JTextArea) sc).setBorder(BorderFactory.createEtchedBorder());
                        ((JTextArea) sc).setText("");
                    }
                }
            }
            if (c.getName() != null) {
                //c.setEnabled(false);
                if (c.getClass() == JTextField.class) {
                    ((JTextField) c).setBorder(BorderFactory.createEtchedBorder());
                    ((JTextField) c).setText("");
                } else if (c.getClass() == JCheckBox.class) {
                    ((JCheckBox) c).setSelected(false);
                } else if (c.getClass() == JDateChooser.class) {
                    ((JDateChooser) c).setBorder(BorderFactory.createEtchedBorder());
                    ((JDateChooser) c).setDate(null);
                } else if (c.getClass() == JTextArea.class) {
                    ((JTextArea) c).setBorder(BorderFactory.createEtchedBorder());
                    ((JTextArea) c).setText("");
                }
            }
        }
    }
    
    protected void resetFields() {
        //this.cleanErrors();
        for (Component c : this.getComponents()) {
            if (c instanceof JScrollPane) {
                for (Component sc : ((JScrollPane) c).getViewport().getComponents()) {
                    if (sc.getClass() == JTextArea.class) {
                        ((JTextArea) sc).setBorder(BorderFactory.createEtchedBorder());
                        ((JTextArea) sc).setText("");
                    }
                }
            }
            if (c.getName() != null) {
                //c.setEnabled(false);
                if (c.getClass() == JTextField.class) {
                    ((JTextField) c).setBorder(BorderFactory.createEtchedBorder());
                    ((JTextField) c).setText("");
                } else if (c.getClass() == JCheckBox.class) {
                    ((JCheckBox) c).setSelected(false);
                } else if (c.getClass() == JDateChooser.class) {
                    ((JDateChooser) c).setBorder(BorderFactory.createEtchedBorder());
                    ((JDateChooser) c).setDate(null);
                } else if (c.getClass() == JTextArea.class) {
                    ((JTextArea) c).setBorder(BorderFactory.createEtchedBorder());
                    ((JTextArea) c).setText("");
                } else if (c.getClass() == JComboBox.class) {
                    ((JComboBox) c).setBorder(BorderFactory.createEtchedBorder());
                    if (((JComboBox) c).getModel().getSize() > 0)
                        ((JComboBox) c).setSelectedIndex(0);
                }
            }
        }
    }

    protected void showErrors(ArrayList<String> errorList) {
        //cleanErrors();
        if (errorList != null && !errorList.isEmpty()) {
            for (String error : errorList) {
                for (Component c : this.getComponents()) {
                    if (c.getClass() == JTextField.class && c.getName() != null && c.getName().equals(error)) {
                        ((JTextField) c).setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
                        break;

                    } else if (c.getClass() == JDateChooser.class && c.getName() != null && c.getName().equals(error)) {
                        ((JDateChooser) c).setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
                        break;
                    } else if (c.getClass() == JComboBox.class && c.getName() != null && c.getName().equals(error)) {
                        ((JComboBox) c).setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
                        break;
                    }
                }
            }
        } else {
            resetFields();
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
