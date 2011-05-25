package controller;

// Binder.java
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import javax.swing.text.Document;
import model.AbstractObject;
import model.Kontakt;

public class Binder {

    private static Map<String, Entry> map = new HashMap<String, Entry>();

    // Bind jc2 to jc1.
    public static void bind(JComponent jc1, JComponent jc2) {
        if (isBound(jc1, jc2)) {
            return;
        }

        if (jc1 instanceof JTextField) {
            final JTextField jtf1 = (JTextField) jc1;

            if (jc2 instanceof JTextField) {
                final JTextField jtf2 = (JTextField) jc2;
                Document doc = jtf1.getDocument();
                DocumentListener dl;
                dl = new DocumentListener() {

                    public void changedUpdate(DocumentEvent de) {
                        Runnable r = new Runnable() {

                            public void run() {
                                String text = jtf1.getText();
                                if (jtf2.getText().equals(text)) {
                                    return;
                                }
                                jtf2.setText(text);
                            }
                        };
                        SwingUtilities.invokeLater(r);
                    }

                    public void insertUpdate(DocumentEvent de) {
                        Runnable r = new Runnable() {

                            public void run() {
                                String text = jtf1.getText();
                                if (jtf2.getText().equals(text)) {
                                    return;
                                }
                                jtf2.setText(text);
                            }
                        };
                        SwingUtilities.invokeLater(r);
                    }

                    public void removeUpdate(DocumentEvent de) {
                        Runnable r = new Runnable() {

                            public void run() {
                                String text = jtf1.getText();
                                if (jtf2.getText().equals(text)) {
                                    return;
                                }
                                jtf2.setText(text);
                            }
                        };
                        SwingUtilities.invokeLater(r);
                    }
                };
                doc.addDocumentListener(dl);

                Entry entry = new Entry(jc1, dl);
                String key = jc1.getName() + jc2.getName();
                map.put(key, entry);
            }
        }
    }

    public static void bind(JComponent jc1, JComponent jc2, final String propertyName) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (jc1 instanceof JList) {
            final JList jlist = (JList) jc1;

            if (jc2 instanceof JTextField) {
                final JTextField jtf = (JTextField) jc2;
                
                ListSelectionListener lsl;
                lsl = new ListSelectionListener() {

                    public void valueChanged(ListSelectionEvent e) {
                        Runnable r = new Runnable() {

                            public void run() {
                                AbstractObject am = (AbstractObject) jlist.getSelectedValue();
                                Method method = null;
                                System.out.println(am);
                                if (am != null)
                                try {
                                    method = am.getClass().getMethod("get" + propertyName, new Class[]{});
                                } catch (NoSuchMethodException ex) {
                                    Logger.getLogger(Binder.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (SecurityException ex) {
                                    Logger.getLogger(Binder.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                String text = null;
                                if(method != null)
                                try {
                                    text = (String) method.invoke(jlist.getSelectedValue());
                                } catch (IllegalAccessException ex) {
                                    Logger.getLogger(Binder.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (IllegalArgumentException ex) {
                                    Logger.getLogger(Binder.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (InvocationTargetException ex) {
                                    Logger.getLogger(Binder.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                System.out.println(text);
                                if(text != null) {
                                    jtf.setText(text);
                                }
                            }
                        };
                        SwingUtilities.invokeLater(r);
                    }


                };
                
                jlist.addListSelectionListener(lsl);
            }
        }
    }

    // Return true if jc2 is bound to jc1.
    public static boolean isBound(JComponent jc1, JComponent jc2) {
        String key = jc1.getName() + jc2.getName();
        return (map.get(key) != null) ? true : false;
    }

    // Unbind jc2 from jc1.
    public static void unbind(JComponent jc1, JComponent jc2) {
        String key = jc1.getName() + jc2.getName();
        Entry entry = map.get(key);
        if (entry != null) {
            if (entry.jc instanceof JTextField) {
                JTextField jtf = (JTextField) entry.jc;
                Document doc = jtf.getDocument();
                doc.removeDocumentListener((DocumentListener) entry.o);
            }
            map.remove(key);
        }
    }

    private static class Entry {

        JComponent jc;
        Object o;

        Entry(JComponent jc, Object o) {
            this.jc = jc;
            this.o = o;
        }
    }
}
