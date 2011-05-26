package controller;

// Binder.java
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.AbstractObject;
import model.Kontakt;
import model.dal.DALException;
import model.dal.DALFactory;
import model.dal.IDAL;

public class Binder {
    private static Map observer = new HashMap<Class, ArrayList<JComponent>>();
    private static IDAL db = DALFactory.getDAL();
    
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
                                    Object result = method.invoke(am);
                                    if (result instanceof String) {
                                        text = (String) result;
                                    } else if (result instanceof Integer) {
                                        text = Integer.toString((Integer)result);
                                    } else if (result instanceof Long) {
                                        text = Long.toString((Long)result);
                                    }
                                } catch (IllegalAccessException ex) {
                                    Logger.getLogger(Binder.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (IllegalArgumentException ex) {
                                    Logger.getLogger(Binder.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (InvocationTargetException ex) {
                                    Logger.getLogger(Binder.class.getName()).log(Level.SEVERE, null, ex);
                                }
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
    
    public static void bind(Class c, JComponent jc) {
        if(!observer.containsKey(c)) {
            observer.put(c, new ArrayList<JComponent>());
        }
        if(jc instanceof JList) {
            // insert component into arraylist to class
            JList jl = (JList)jc;
            ((ArrayList<JComponent>)observer.get(c)).add(jl);
            
            
        }
    }
    
    public static void notify(Class c) {
        Iterator it = ((ArrayList<JComponent>)observer.get(c)).iterator();
        while(it.hasNext()) {
            JComponent jc = (JComponent)it.next();
            if (jc instanceof JList) {
                pushList(c, (JList)jc);
            }
        }
    }
    
    private static void pushList(Class c, JList jl) {
        DefaultListModel list = new DefaultListModel();
        
        try {
            for(Kontakt k: db.getKontaktListe()) {
                list.addElement(k);
            }
            jl.setModel(list);
            
        } catch (DALException ex) {
            Logger.getLogger(Binder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
