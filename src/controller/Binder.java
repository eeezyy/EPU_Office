package controller;

// Binder.java
import com.toedter.calendar.JDateChooser;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import utils.log.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.AbstractObject;
import model.bl.AbstractLogic;
import model.dal.DALFactory;
import model.dal.IDAL;

public class Binder {

    private static Map observer = new HashMap<Class, ArrayList<JComponent>>();
    private static IDAL db = DALFactory.getDAL();

    public static void bind(JComponent jc1, JComponent jc2) {
        if (jc1 instanceof JList) {
            final JList jlist = (JList) jc1;

            if (jc2 instanceof JDateChooser) {
                final JDateChooser jdc = (JDateChooser) jc2;

                ListSelectionListener lsl;
                lsl = new ListSelectionListener() {

                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        // verhindert das deselectieren eines neuen Kontaktes
                        if (jlist.getModel().getSize() > e.getLastIndex() && e.getValueIsAdjusting() && ((AbstractObject) jlist.getModel().getElementAt(e.getLastIndex())).getId() == 0) {
                            jlist.setSelectedIndex(e.getLastIndex());
                            return;
                        }
                        // bereits eingetragene textfelder gehen nicht verloren
                        if (e.getLastIndex() == jlist.getSelectedIndex() && e.getFirstIndex() != e.getLastIndex() && ((AbstractObject) jlist.getModel().getElementAt(e.getLastIndex())).getId() == 0) {
                            return;
                        }

                        Runnable r = new Runnable() {

                            @Override
                            public void run() {
                                AbstractObject am = (AbstractObject) jlist.getSelectedValue();
                                Method method = null;
                                Date value = null;

                                if (am != null) {
                                    if (jdc.getName() == null || jdc.getName().isEmpty()) {
                                        System.out.println("Binding: Componente enthält keinen property:name");
                                        return;
                                    }
                                    try {
                                        method = am.getClass().getMethod("get" + jdc.getName(), new Class[]{});
                                    } catch (NoSuchMethodException ex) {
                                        Logger.log(Level.SEVERE, Binder.class, ex);
                                    } catch (SecurityException ex) {
                                        Logger.log(Level.SEVERE, Binder.class, ex);
                                    }
                                } else {
                                    jdc.setDate(null);
                                    jdc.setEnabled(false);
                                }

                                if (method != null) {
                                    try {
                                        Object result = method.invoke(am);
                                        if (result instanceof Date) {
                                            value = (Date) result;
                                        } else {
                                            // Error
                                        }
                                    } catch (IllegalAccessException ex) {
                                        Logger.log(Level.SEVERE, Binder.class, ex);
                                    } catch (IllegalArgumentException ex) {
                                        Logger.log(Level.SEVERE, Binder.class, ex);
                                    } catch (InvocationTargetException ex) {
                                        Logger.log(Level.SEVERE, Binder.class, ex);
                                    }
                                }
                                if (value != null || am != null && am.getId().equals(0)) {
                                    jdc.setDate(value);
                                    jdc.setEnabled(true);
                                }
                                jdc.setBorder(BorderFactory.createEtchedBorder());
                            }
                        };
                        SwingUtilities.invokeLater(r);
                    }
                };
                jlist.addListSelectionListener(lsl);
            }
            
            
            if (jc2 instanceof JButton) {
                final JButton jb = (JButton) jc2;

                ListSelectionListener lsl;
                lsl = new ListSelectionListener() {

                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        // verhindert das deselectieren eines neuen Kontaktes
                        if (jlist.getModel().getSize() > e.getLastIndex() && e.getValueIsAdjusting() && ((AbstractObject) jlist.getModel().getElementAt(e.getLastIndex())).getId() == 0) {
                            jlist.setSelectedIndex(e.getLastIndex());
                            return;
                        }
                        // bereits eingetragene textfelder gehen nicht verloren
                        if (e.getLastIndex() == jlist.getSelectedIndex() && e.getFirstIndex() != e.getLastIndex() && ((AbstractObject) jlist.getModel().getElementAt(e.getLastIndex())).getId() == 0) {
                            return;
                        }

                        Runnable r = new Runnable() {

                            @Override
                            public void run() {
                                AbstractObject am = (AbstractObject) jlist.getSelectedValue();

                                if (am != null) {
                                    jb.setEnabled(true);
                                } else {
                                    jb.setEnabled(false);
                                }

                            }
                        };
                        SwingUtilities.invokeLater(r);
                    }
                };
                jlist.addListSelectionListener(lsl);
            }


            if (jc2 instanceof JCheckBox) {
                final JCheckBox jcb = (JCheckBox) jc2;

                ListSelectionListener lsl;
                lsl = new ListSelectionListener() {

                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        // verhindert das deselectieren eines neuen Kontaktes
                        if (jlist.getModel().getSize() > e.getLastIndex() && e.getValueIsAdjusting() && ((AbstractObject) jlist.getModel().getElementAt(e.getLastIndex())).getId() == 0) {
                            jlist.setSelectedIndex(e.getLastIndex());
                            return;
                        }
                        // bereits eingetragene textfelder gehen nicht verloren
                        if (e.getLastIndex() == jlist.getSelectedIndex() && e.getFirstIndex() != e.getLastIndex() && ((AbstractObject) jlist.getModel().getElementAt(e.getLastIndex())).getId() == 0) {
                            return;
                        }
                        Runnable r = new Runnable() {

                            @Override
                            public void run() {
                                AbstractObject am = (AbstractObject) jlist.getSelectedValue();
                                Method method = null;
                                Boolean value = null;
                                if (am != null) {
                                    if (jcb.getName() == null || jcb.getName().isEmpty()) {
                                        System.out.println("Binding: Componente enthält keinen property:name");
                                        return;
                                    }
                                    try {
                                        method = am.getClass().getMethod("get" + jcb.getName(), new Class[]{});
                                    } catch (NoSuchMethodException ex) {
                                        Logger.log(Level.SEVERE, Binder.class, ex);
                                    } catch (SecurityException ex) {
                                        Logger.log(Level.SEVERE, Binder.class, ex);
                                    }
                                } else {
                                    jcb.setEnabled(false);
                                    jcb.setSelected(false);
                                }
                                if (method != null) {
                                    try {
                                        Object result = method.invoke(am);
                                        if (result instanceof Boolean) {
                                            value = (Boolean) result;
                                        } else {
                                            // Error
                                        }
                                    } catch (IllegalAccessException ex) {
                                        Logger.log(Level.SEVERE, Binder.class, ex);
                                    } catch (IllegalArgumentException ex) {
                                        Logger.log(Level.SEVERE, Binder.class, ex);
                                    } catch (InvocationTargetException ex) {
                                        Logger.log(Level.SEVERE, Binder.class, ex);
                                    }
                                }
                                if (value != null || am != null && am.getId().equals(0)) {
                                    if (value != null) {
                                        jcb.setSelected(value.booleanValue());
                                    } else {
                                        jcb.setSelected(false);
                                    }
                                    jcb.setEnabled(true);
                                }
                            }
                        };
                        SwingUtilities.invokeLater(r);
                    }
                };
                jlist.addListSelectionListener(lsl);
            }

            if (jc2 instanceof JTextField) {
                final JTextField jtf = (JTextField) jc2;

                ListSelectionListener lsl;
                lsl = new ListSelectionListener() {

                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        // verhindert das deselectieren eines neuen Kontaktes
                        if (jlist.getModel().getSize() > e.getLastIndex() && e.getValueIsAdjusting() && ((AbstractObject) jlist.getModel().getElementAt(e.getLastIndex())).getId() == 0) {
                            jlist.setSelectedIndex(e.getLastIndex());
                            return;
                        }
                        // bereits eingetragene textfelder gehen nicht verloren
                        if (e.getLastIndex() == jlist.getSelectedIndex() && e.getFirstIndex() != e.getLastIndex() && ((AbstractObject) jlist.getModel().getElementAt(e.getLastIndex())).getId() == 0) {
                            return;
                        }
                        Runnable r = new Runnable() {

                            @Override
                            public void run() {
                                AbstractObject am = (AbstractObject) jlist.getSelectedValue();
                                Method method = null;
                                String text = null;
                                if (am != null) {
                                    if (jtf.getName() == null || jtf.getName().isEmpty()) {
                                        System.out.println("Binding: Componente enthält keinen property:name");
                                        return;
                                    }
                                    try {
                                        method = am.getClass().getMethod("get" + jtf.getName(), new Class[]{});
                                    } catch (NoSuchMethodException ex) {
                                        Logger.log(Level.SEVERE, Binder.class, ex);
                                    } catch (SecurityException ex) {
                                        Logger.log(Level.SEVERE, Binder.class, ex);
                                    }
                                } else {
                                    jtf.setText("");
                                    jtf.setEnabled(false);
                                }
                                if (method != null) {
                                    try {
                                        Object result = method.invoke(am);
                                        if (result instanceof String) {
                                            text = (String) result;
                                        } else if (result instanceof Integer) {
                                            if (result != null) {
                                                text = Integer.toString((Integer) result);
                                            } else {
                                                text = "";
                                            }
                                        } else if (result instanceof Long) {
                                            if (result != null) {
                                                text = Long.toString((Long) result);
                                            } else {
                                                text = "";
                                            }
                                        } else if (result instanceof Double) {
                                            if (result != null) {
                                                text = Double.toString((Double) result);
                                            } else {
                                                text = "";
                                            }
                                        }
                                    } catch (IllegalAccessException ex) {
                                        Logger.log(Level.SEVERE, Binder.class, ex);
                                    } catch (IllegalArgumentException ex) {
                                        Logger.log(Level.SEVERE, Binder.class, ex);
                                    } catch (InvocationTargetException ex) {
                                        Logger.log(Level.SEVERE, Binder.class, ex);
                                    }
                                }
                                if (text != null || am != null && am.getId().equals(0)) {
                                    jtf.setText(text);
                                    jtf.setEnabled(true);
                                }
                                jtf.setBorder(BorderFactory.createEtchedBorder());
                            }
                        };
                        SwingUtilities.invokeLater(r);
                    }
                };

                jlist.addListSelectionListener(lsl);
            }

            if (jc2 instanceof JTextArea) {
                final JTextArea jta = (JTextArea) jc2;

                ListSelectionListener lsl;
                lsl = new ListSelectionListener() {

                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        // verhindert das deselectieren eines neuen Kontaktes
                        if (jlist.getModel().getSize() > e.getLastIndex() && e.getValueIsAdjusting() && ((AbstractObject) jlist.getModel().getElementAt(e.getLastIndex())).getId() == 0) {
                            jlist.setSelectedIndex(e.getLastIndex());
                            return;
                        }
                        // bereits eingetragene textfelder gehen nicht verloren
                        if (e.getLastIndex() == jlist.getSelectedIndex() && e.getFirstIndex() != e.getLastIndex() && ((AbstractObject) jlist.getModel().getElementAt(e.getLastIndex())).getId() == 0) {
                            return;
                        }
                        Runnable r = new Runnable() {

                            @Override
                            public void run() {
                                AbstractObject am = (AbstractObject) jlist.getSelectedValue();
                                Method method = null;
                                String text = null;
                                if (am != null) {
                                    if (jta.getName() == null || jta.getName().isEmpty()) {
                                        System.out.println("Binding: Componente enthält keinen property:name");
                                        return;
                                    }
                                    try {
                                        method = am.getClass().getMethod("get" + jta.getName(), new Class[]{});
                                    } catch (NoSuchMethodException ex) {
                                        Logger.log(Level.SEVERE, Binder.class, ex);
                                    } catch (SecurityException ex) {
                                        Logger.log(Level.SEVERE, Binder.class, ex);
                                    }
                                } else {
                                    jta.setText("");
                                    jta.setEnabled(false);
                                }
                                if (method != null) {
                                    try {
                                        Object result = method.invoke(am);
                                        if (result instanceof String) {
                                            text = (String) result;
                                        }
                                    } catch (IllegalAccessException ex) {
                                        Logger.log(Level.SEVERE, Binder.class, ex);
                                    } catch (IllegalArgumentException ex) {
                                        Logger.log(Level.SEVERE, Binder.class, ex);
                                    } catch (InvocationTargetException ex) {
                                        Logger.log(Level.SEVERE, Binder.class, ex);
                                    }
                                }
                                if (text != null || am != null && am.getId().equals(0)) {
                                    jta.setText(text);
                                    jta.setEnabled(true);
                                }
                                jta.setBorder(BorderFactory.createEtchedBorder());
                            }
                        };
                        SwingUtilities.invokeLater(r);
                    }
                };

                jlist.addListSelectionListener(lsl);
            }

            if (jc2 instanceof JComboBox) {
                final JComboBox jcb2 = (JComboBox) jc2;

                ListSelectionListener lsl;
                lsl = new ListSelectionListener() {

                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        // verhindert das deselectieren eines neuen Kontaktes
                        if (jlist.getModel().getSize() > e.getLastIndex() && e.getValueIsAdjusting() && ((AbstractObject) jlist.getModel().getElementAt(e.getLastIndex())).getId() == 0) {
                            jlist.setSelectedIndex(e.getLastIndex());
                            return;
                        }
                        // bereits eingetragene textfelder gehen nicht verloren
                        if (e.getLastIndex() == jlist.getSelectedIndex() && e.getFirstIndex() != e.getLastIndex() && ((AbstractObject) jlist.getModel().getElementAt(e.getLastIndex())).getId() == 0) {
                            return;
                        }

                        Runnable r = new Runnable() {

                            @Override
                            public void run() {
                                AbstractObject am = (AbstractObject) jlist.getSelectedValue();
                                Method method = null;
                                AbstractObject object = null;
                                if (am != null) {
                                    if (jcb2.getName() == null || jcb2.getName().isEmpty()) {
                                        System.out.println("Binding: Componente enthält keinen property:name");
                                        return;
                                    }
                                    try {
                                        method = am.getClass().getMethod("get" + jcb2.getName(), new Class[]{});
                                    } catch (NoSuchMethodException ex) {
                                        Logger.log(Level.SEVERE, Binder.class, ex);
                                    } catch (SecurityException ex) {
                                        Logger.log(Level.SEVERE, Binder.class, ex);
                                    }
                                } else {
                                    if(jcb2.getModel().getSize() > 0)
                                        jcb2.setSelectedIndex(0);
                                    jcb2.setEnabled(false);
                                }
                                if (method != null) {
                                    try {
                                        Object result = method.invoke(am);
                                        if (result instanceof AbstractObject) {
                                            object = (AbstractObject) result;
                                        }
                                    } catch (IllegalAccessException ex) {
                                        Logger.log(Level.SEVERE, Binder.class, ex);
                                    } catch (IllegalArgumentException ex) {
                                        Logger.log(Level.SEVERE, Binder.class, ex);
                                    } catch (InvocationTargetException ex) {
                                        Logger.log(Level.SEVERE, Binder.class, ex);
                                    }
                                }
                                if (object != null || am != null && am.getId().equals(0)) {
                                    jcb2.setEnabled(true);
                                    for (int i = 0; i < jcb2.getModel().getSize(); i++) {
                                        Object o = jcb2.getModel().getElementAt(i);
                                        if (o instanceof AbstractObject && object != null) {
                                            if (((AbstractObject) o).getId() == object.getId()) {
                                                jcb2.setSelectedIndex(i);
                                            }
                                        }
                                        jcb2.setSelectedItem(object);
                                    }
                                    jcb2.setSelectedItem(object);
                                }
                                jcb2.setBorder(BorderFactory.createEtchedBorder());
                            }
                        };
                        SwingUtilities.invokeLater(r);
                    }
                };
                jlist.addListSelectionListener(lsl);
            }
            
            if (jc2 instanceof JList) {
                final JList jl2 = (JList) jc2;

                ListSelectionListener lsl;
                lsl = new ListSelectionListener() {

                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        // verhindert das deselectieren eines neuen Kontaktes
                        /*
                        if (jlist.getModel().getSize() > e.getLastIndex() && e.getValueIsAdjusting() && ((AbstractObject) jlist.getModel().getElementAt(e.getLastIndex())).getId() == 0) {
                            jlist.setSelectedIndex(e.getLastIndex());
                            return;
                        }
                        // bereits eingetragene textfelder gehen nicht verloren
                        if (e.getLastIndex() == jlist.getSelectedIndex() && e.getFirstIndex() != e.getLastIndex() && ((AbstractObject) jlist.getModel().getElementAt(e.getLastIndex())).getId() == 0) {
                            return;
                        }*/

                        Runnable r = new Runnable() {

                            @Override
                            public void run() {
                                System.out.println(jl2.getName());
                                AbstractObject am = (AbstractObject) jlist.getSelectedValue();
                                Method method = null;
                                ArrayList<AbstractObject> objects = null;
                                System.out.println(am);
                                if (am != null && am.getId() != 0) {
                                    if (jl2.getName() == null || jl2.getName().isEmpty()) {
                                        System.out.println("Binding: Componente enthält keinen property:name");
                                        return;
                                    }
                                    try {
                                        method = db.getClass().getMethod("get" + jl2.getName(), new Class[]{Integer.class});
                                    } catch (NoSuchMethodException ex) {
                                        Logger.log(Level.SEVERE, Binder.class, ex);
                                    } catch (SecurityException ex) {
                                        Logger.log(Level.SEVERE, Binder.class, ex);
                                    }
                                } else {
                                    jl2.setModel(new DefaultListModel());
                                    jl2.setEnabled(false);
                                }
                                if (method != null) {
                                    try {
                                        Object result = method.invoke(db, am.getId());
                                        if (result instanceof ArrayList) {
                                            objects = (ArrayList<AbstractObject>) result;
                                        }
                                    } catch (IllegalAccessException ex) {
                                        Logger.log(Level.SEVERE, Binder.class, ex);
                                    } catch (IllegalArgumentException ex) {
                                        Logger.log(Level.SEVERE, Binder.class, ex);
                                    } catch (InvocationTargetException ex) {
                                        Logger.log(Level.SEVERE, Binder.class, ex);
                                    }
                                }
                                if (objects != null || am != null && am.getId().equals(0)) {
                                    jl2.setEnabled(true);
                                    DefaultListModel model = new DefaultListModel();
                                    Iterator i = objects.iterator();
                                    while(i.hasNext()) {
                                        model.addElement(i.next());
                                    }
                                    jl2.setModel(model);
                                }
                            }
                        };
                        SwingUtilities.invokeLater(r);
                    }
                };
                jlist.addListSelectionListener(lsl);
            }


        }

        if (jc1 instanceof JComboBox) {
            final JComboBox jcb1 = (JComboBox) jc1;
            if (jc2 instanceof JComboBox) {
                final JComboBox jcb2 = (JComboBox) jc2;

                ItemListener lsl;
                lsl = new ItemListener() {

                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        // verhindert das deselectieren eines neuen Kontaktes
                        /*if (jcb1.getModel().getSize() > e.getLastIndex() && e.getValueIsAdjusting() && ((AbstractObject) jcb1.getModel().getElementAt(e.getLastIndex())).getId() == 0) {
                        jcb1.setSelectedIndex(e.getLastIndex());
                        return;
                        }
                        // bereits eingetragene textfelder gehen nicht verloren
                        if (e.getLastIndex() == jcb1.getSelectedIndex() && e.getFirstIndex() != e.getLastIndex() && ((AbstractObject) jcb1.getModel().getElementAt(e.getLastIndex())).getId() == 0) {
                        return;
                        }*/

                        Runnable r = new Runnable() {

                            @Override
                            public void run() {
                                AbstractObject am = (AbstractObject) jcb1.getSelectedItem();
                                Method method = null;
                                ArrayList<AbstractObject> list = null;
                                if (am != null) {
                                    if (jcb2.getName() == null || jcb2.getName().isEmpty()) {
                                        System.out.println("Binding: Componente enthält keinen property:name");
                                        return;
                                    }
                                    try {
                                        method = am.getClass().getMethod("get" + jcb2.getName(), new Class[]{});
                                    } catch (NoSuchMethodException ex) {
                                        Logger.log(Level.SEVERE, Binder.class, ex);
                                    } catch (SecurityException ex) {
                                        Logger.log(Level.SEVERE, Binder.class, ex);
                                    }
                                } else {
                                    jcb2.setModel(null);
                                    jcb2.setEnabled(false);
                                }
                                if (method != null) {
                                    try {
                                        Object result = method.invoke(am);
                                        if (result instanceof ArrayList) {
                                            list = (ArrayList<AbstractObject>) result;
                                        }
                                    } catch (IllegalAccessException ex) {
                                        Logger.log(Level.SEVERE, Binder.class, ex);
                                    } catch (IllegalArgumentException ex) {
                                        Logger.log(Level.SEVERE, Binder.class, ex);
                                    } catch (InvocationTargetException ex) {
                                        Logger.log(Level.SEVERE, Binder.class, ex);
                                    }
                                }
                                if (list != null || am != null && am.getId().equals(0)) {
                                    DefaultComboBoxModel model = new DefaultComboBoxModel();
                                    Iterator i = list.iterator();
                                    while (i.hasNext()) {
                                        model.addElement(i.next());
                                    }
                                    jcb2.setModel(model);
                                    jcb2.setEnabled(true);
                                }
                                jcb2.setBorder(BorderFactory.createEtchedBorder());
                            }
                        };
                        SwingUtilities.invokeLater(r);
                    }
                };
                jcb1.addItemListener(lsl);
            }
        }

        if (jc1 instanceof JComboBox) {
            final JComboBox jcb1 = (JComboBox) jc1;
            if (jc2 instanceof JList) {
                final JList jl = (JList) jc2;

                ItemListener lsl;
                lsl = new ItemListener() {

                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        // verhindert das deselectieren eines neuen Kontaktes
                        /*if (jcb1.getModel().getSize() > e.getLastIndex() && e.getValueIsAdjusting() && ((AbstractObject) jcb1.getModel().getElementAt(e.getLastIndex())).getId() == 0) {
                        jcb1.setSelectedIndex(e.getLastIndex());
                        return;
                        }
                        // bereits eingetragene textfelder gehen nicht verloren
                        if (e.getLastIndex() == jcb1.getSelectedIndex() && e.getFirstIndex() != e.getLastIndex() && ((AbstractObject) jcb1.getModel().getElementAt(e.getLastIndex())).getId() == 0) {
                        return;
                        }*/

                        Runnable r = new Runnable() {

                            @Override
                            public void run() {
                                Object am = null;
                                am = jcb1.getSelectedItem();
                                Method method = null;
                                ArrayList<AbstractObject> list = null;
                                if (am != null) {
                                    if (jl.getName() == null || jl.getName().isEmpty()) {
                                        System.out.println("Binding: Componente enthält keinen property:name");
                                        return;
                                    }
                                    try {
                                        if (am instanceof AbstractObject) {
                                            method = db.getClass().getMethod("get" + jl.getName(), new Class[]{Integer.class});
                                        }
                                        if (am instanceof String && ((String) am).isEmpty()) {
                                            method = db.getClass().getMethod("get" + jl.getName(), new Class[]{});
                                        }
                                    } catch (NoSuchMethodException ex) {
                                        Logger.log(Level.SEVERE, Binder.class, ex);
                                    } catch (SecurityException ex) {
                                        Logger.log(Level.SEVERE, Binder.class, ex);
                                    }
                                } else {
                                    jl.setModel(new DefaultListModel());
                                    jl.setEnabled(false);
                                }
                                if (method != null) {
                                    try {
                                        Object result = null;
                                        if (am instanceof AbstractObject) {
                                            result = method.invoke(db, ((AbstractObject) am).getId());
                                        } else if (am instanceof String && ((String) am).isEmpty()) {
                                            result = method.invoke(db);
                                        }
                                        if (result instanceof ArrayList) {
                                            list = (ArrayList<AbstractObject>) result;
                                        }
                                    } catch (IllegalAccessException ex) {
                                        Logger.log(Level.SEVERE, Binder.class, ex);
                                    } catch (IllegalArgumentException ex) {
                                        Logger.log(Level.SEVERE, Binder.class, ex);
                                    } catch (InvocationTargetException ex) {
                                        Logger.log(Level.SEVERE, Binder.class, ex);
                                    }
                                }
                                if (list != null || am != null && ((AbstractObject) am).getId().equals(0)) {
                                    DefaultListModel model = new DefaultListModel();
                                    Iterator i = list.iterator();
                                    while (i.hasNext()) {
                                        model.addElement(i.next());
                                    }
                                    jl.setModel(model);
                                    jl.setEnabled(true);
                                }
                                jl.setBorder(BorderFactory.createEtchedBorder());
                            }
                        };
                        SwingUtilities.invokeLater(r);
                    }
                };
                jcb1.addItemListener(lsl);
            }
        }

    }

    public static void bind(Class c, JComponent jc) {
        if (!observer.containsKey(c)) {
            observer.put(c, new ArrayList<JComponent>());
        }
        if (jc instanceof JList) {
            // insert component into arraylist to class
            JList jl = (JList) jc;
            ((ArrayList<JComponent>) observer.get(c)).add(jl);
        } else if (jc instanceof JComboBox) {
            JComboBox jcb = (JComboBox) jc;
            ((ArrayList<JComponent>) observer.get(c)).add(jcb);
        }
        notify(c);
    }

    public static void notify(Class c) {
        if(observer.isEmpty() || observer.get(c) == null)
            return;
        Iterator it = ((ArrayList<JComponent>) observer.get(c)).iterator();
        while (it.hasNext()) {
            JComponent jc = (JComponent) it.next();
            if (jc instanceof JList) {
                pushList(c, (JList) jc);
            } else if (jc instanceof JComboBox) {
                pushList(c, (JComboBox) jc);
            }
        }
    }

    private static void pushList(Class c, JComboBox jcb) {
        if(jcb == null)
            return;
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        ArrayList<AbstractObject> resultList = null;
        String function = null;
        if (jcb.getName() == null || jcb.getName().isEmpty()) {
            System.out.println("pushList: funktion nicht definiert");
            return;
        }
        if (jcb.getName() == null || jcb.getName().isEmpty()) {
            System.out.println("pushList: jlist hat keinen funktionsnamen. property name.");
            return;
        }
        try {
            Method m = db.getClass().getMethod("get" + jcb.getName(), new Class[]{});
            try {
                resultList = (ArrayList<AbstractObject>) m.invoke(db);
            } catch (IllegalAccessException ex) {
                Logger.log(Level.SEVERE, Binder.class, ex);
            } catch (IllegalArgumentException ex) {
                Logger.log(Level.SEVERE, Binder.class, ex);
            } catch (InvocationTargetException ex) {
                Logger.log(Level.SEVERE, Binder.class, ex);
            }
        } catch (NoSuchMethodException ex) {
            Logger.log(Level.SEVERE, Binder.class, ex);
        } catch (SecurityException ex) {
            Logger.log(Level.SEVERE, Binder.class, ex);
        }

        model.addElement("");
        for (AbstractObject k : resultList) {
            model.addElement(k);
        }
        jcb.setModel(model);
    }

    private static void pushList(Class c, JList jl) {
        if(jl == null)
            return;
        DefaultListModel list = new DefaultListModel();
        ArrayList<AbstractObject> resultList = null;
        String function = null;
        if (jl.getName() == null || jl.getName().isEmpty()) {
            System.out.println("pushList: funktion nicht definiert");
            return;
        }
        if (jl.getName() == null || jl.getName().isEmpty()) {
            System.out.println("pushList: jlist hat keinen funktionsnamen. property name.");
            return;
        }
        try {
            Method m = db.getClass().getMethod("get" + jl.getName(), new Class[]{});
            try {
                resultList = (ArrayList<AbstractObject>) m.invoke(db);
            } catch (IllegalAccessException ex) {
                Logger.log(Level.SEVERE, Binder.class, ex);
            } catch (IllegalArgumentException ex) {
                Logger.log(Level.SEVERE, Binder.class, ex);
            } catch (InvocationTargetException ex) {
                Logger.log(Level.SEVERE, Binder.class, ex);
            }
        } catch (NoSuchMethodException ex) {
            Logger.log(Level.SEVERE, Binder.class, ex);
        } catch (SecurityException ex) {
            Logger.log(Level.SEVERE, Binder.class, ex);
        }

        for (AbstractObject k : resultList) {
            list.addElement(k);
        }
        jl.setModel(list);
    }

    public static ArrayList<String> save(Class classtype, ArrayList<BinderProperty> propertyList) {
        ArrayList<String> errorList = null;

        AbstractLogic logic = null;
        try {
            try {
                logic = (AbstractLogic) Class.forName("model.bl." + getClassName(classtype) + "Logic").newInstance();
                errorList = logic.check(propertyList);
            } catch (InstantiationException ex) {
                Logger.log(Level.SEVERE, Binder.class, ex);
            } catch (IllegalAccessException ex) {
                Logger.log(Level.SEVERE, Binder.class, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.log(Level.SEVERE, Binder.class, ex);
        }
        if (errorList == null || errorList.isEmpty()) {
            try {
                Method m = db.getClass().getMethod("save" + getClassName(classtype), new Class[]{AbstractObject.class});
                if (logic != null) {
                    AbstractObject object = null;
                    try {
                        object = createObject(classtype, propertyList);
                    } catch (InstantiationException ex) {
                        Logger.log(Level.SEVERE, Binder.class, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.log(Level.SEVERE, Binder.class, ex);
                    }
                    try {
                        m.invoke(db, object);
                    } catch (IllegalAccessException ex) {
                        Logger.log(Level.SEVERE, Binder.class, ex);
                    } catch (IllegalArgumentException ex) {
                        Logger.log(Level.SEVERE, Binder.class, ex);
                    } catch (InvocationTargetException ex) {
                        Logger.log(Level.SEVERE, Binder.class, ex);
                    }
                }
            } catch (NoSuchMethodException ex) {
                Logger.log(Level.SEVERE, Binder.class, ex);
            } catch (SecurityException ex) {
                Logger.log(Level.SEVERE, Binder.class, ex);
            }
        }

        if (errorList == null || errorList.isEmpty()) {
            notify(classtype);
        }

        return errorList;
    }

    protected static AbstractObject createObject(Class classtype, ArrayList<BinderProperty> propertyList) throws InstantiationException, IllegalAccessException {
        AbstractObject object = (AbstractObject) classtype.newInstance();
        BinderProperty property = null;
        Iterator i = propertyList.iterator();
        while (i.hasNext()) {
            property = (BinderProperty) i.next();
            try {
                Method m = null;
                if (!property.getClasstype().equals(AbstractObject.class)) {
                    m = classtype.getMethod("set" + property.getProperty(), property.getClasstype());
                } else {
                    try {
                        m = classtype.getMethod("set" + property.getProperty(), Class.forName("model." + property.getProperty()));
                    } catch (ClassNotFoundException ex) {
                        Logger.log(Level.SEVERE, Binder.class, ex);
                        return null;
                    }
                }
                try {
                    if (property.getClasstype().equals(String.class)) {
                        m.invoke(object, property.getValue());
                    } else if (property.getClasstype().equals(Integer.class)) {
                        if (property.getValue() != null) {
                            m.invoke(object, Integer.parseInt(property.getValue()));
                        } else {
                            m.invoke(object, property.getValue());
                        }
                    } else if (property.getClasstype().equals(Long.class)) {
                        m.invoke(object, Long.parseLong(property.getValue()));
                    } else if (property.getClasstype().equals(Boolean.class)) {
                        m.invoke(object, Boolean.parseBoolean(property.getValue()));
                    } else if (property.getClasstype().equals(Double.class)) {
                        m.invoke(object, Double.parseDouble(property.getValue()));
                    } else if (property.getClasstype().equals(Date.class)) {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyy");
                        try {
                            m.invoke(object, sdf.parse(property.getValue()));
                        } catch (ParseException ex) {
                            Logger.log(Level.SEVERE, Binder.class, ex);
                        }
                    } else if (property.getClasstype().equals(AbstractObject.class)) {
                        Method dbm = db.getClass().getMethod("get" + property.getProperty(), Integer.class);
                        AbstractObject attachedObject = (AbstractObject) dbm.invoke(db, (Integer)Integer.parseInt(property.getValue()));
                        try {
                            m.invoke(object, Class.forName("model." + property.getProperty()).cast(attachedObject));
                        } catch (ClassNotFoundException ex) {
                            Logger.log(Level.SEVERE, Binder.class, ex);
                        }
                    }
                } catch (IllegalAccessException ex) {
                    Logger.log(Level.SEVERE, Binder.class, ex);
                } catch (IllegalArgumentException ex) {
                    Logger.log(Level.SEVERE, Binder.class, ex);
                } catch (InvocationTargetException ex) {
                    Logger.log(Level.SEVERE, Binder.class, ex);
                }
            } catch (NoSuchMethodException ex) {
                Logger.log(Level.SEVERE, Binder.class, ex);
            } catch (SecurityException ex) {
                Logger.log(Level.SEVERE, Binder.class, ex);
            }
        }
        return object;
    }

    private static String getClassName(Class c) {
        String className = c.getName();
        int firstChar;
        firstChar = className.lastIndexOf('.') + 1;
        if (firstChar > 0) {
            className = className.substring(firstChar);
        }
        return className;
    }
}
