package controller;

// Binder.java
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import utils.log.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;

import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.AbstractObject;
import model.Kontakt;
import model.bl.AbstractLogic;
import model.dal.DALException;
import model.dal.DALFactory;
import model.dal.IDAL;

public class Binder {

    private static Map observer = new HashMap<Class, ArrayList<JComponent>>();
    private static IDAL db = DALFactory.getDAL();

    public static void bind(JComponent jc1, JComponent jc2, final String propertyName) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (jc1 instanceof JList) {
            final JList jlist = (JList) jc1;
            
            if (jc2 instanceof JCheckBox) {
                final JCheckBox jcb = (JCheckBox) jc2;
                
                ListSelectionListener lsl;
                lsl = new ListSelectionListener() {

                    public void valueChanged(ListSelectionEvent e) {
                        Runnable r = new Runnable() {

                            public void run() {
                                AbstractObject am = (AbstractObject) jlist.getSelectedValue();
                                Method method = null;
                                if (am != null) {
                                    try {
                                        method = am.getClass().getMethod("get" + propertyName, new Class[]{});
                                    } catch (NoSuchMethodException ex) {
                                        Logger.log(Level.SEVERE, this.getClass(),ex.getMessage());
                                    } catch (SecurityException ex) {
                                        Logger.log(Level.SEVERE, this.getClass(),ex.getMessage());
                                    }
                                }
                                boolean value = false;
                                if (method != null) {
                                    try {
                                        Object result = method.invoke(am);
                                        if (result instanceof Boolean) {
                                            value = (Boolean) result;
                                        } else {
                                            // Error
                                            
                                        } 
                                    } catch (IllegalAccessException ex) {
                                        Logger.log(Level.SEVERE, this.getClass(),ex.getMessage());
                                    } catch (IllegalArgumentException ex) {
                                        Logger.log(Level.SEVERE, this.getClass(),ex.getMessage());
                                    } catch (InvocationTargetException ex) {
                                        Logger.log(Level.SEVERE, this.getClass(),ex.getMessage());
                                    }
                                }
                                jcb.setSelected(value);
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

                    public void valueChanged(ListSelectionEvent e) {
                        Runnable r = new Runnable() {

                            public void run() {
                                AbstractObject am = (AbstractObject) jlist.getSelectedValue();
                                Method method = null;
                                if (am != null) {
                                    try {
                                        method = am.getClass().getMethod("get" + propertyName, new Class[]{});
                                    } catch (NoSuchMethodException ex) {
                                        Logger.log(Level.SEVERE, this.getClass(),ex.getMessage());
                                    } catch (SecurityException ex) {
                                        Logger.log(Level.SEVERE, this.getClass(),ex.getMessage());
                                    }
                                }
                                String text = null;
                                if (method != null) {
                                    try {
                                        Object result = method.invoke(am);
                                        if (result instanceof String) {
                                            text = (String) result;
                                        } else if (result instanceof Integer) {
                                            text = Integer.toString((Integer) result);
                                        } else if (result instanceof Long) {
                                            text = Long.toString((Long) result);
                                        }
                                    } catch (IllegalAccessException ex) {
                                        Logger.log(Level.SEVERE, this.getClass(),ex.getMessage());
                                    } catch (IllegalArgumentException ex) {
                                        Logger.log(Level.SEVERE, this.getClass(),ex.getMessage());
                                    } catch (InvocationTargetException ex) {
                                        Logger.log(Level.SEVERE, this.getClass(),ex.getMessage());
                                    }
                                }
                                if (text != null) {
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
        if (!observer.containsKey(c)) {
            observer.put(c, new ArrayList<JComponent>());
        }
        if (jc instanceof JList) {
            // insert component into arraylist to class
            JList jl = (JList) jc;
            ((ArrayList<JComponent>) observer.get(c)).add(jl);


        }
    }

    public static void notify(Class c) {
        Iterator it = ((ArrayList<JComponent>) observer.get(c)).iterator();
        while (it.hasNext()) {
            JComponent jc = (JComponent) it.next();
            if (jc instanceof JList) {
                pushList(c, (JList) jc);
            }
        }
    }

    private static void pushList(Class c, JList jl) {
        DefaultListModel list = new DefaultListModel();

        try {
            for (Kontakt k : db.getKontaktListe()) {
                list.addElement(k);
            }
            jl.setModel(list);

        } catch (DALException ex) {
            Logger.log(Level.SEVERE, Binder.class,ex.getMessage());
        }
    }

    public static ArrayList<String> save(AbstractObject object) {
        ArrayList<String> errorList = null;
        AbstractLogic logic = null;
        try {
            try {
                logic = (AbstractLogic) Class.forName("model.bl." + getClassName(object.getClass()) + "Logic").newInstance();
                errorList = logic.check(object);
            } catch (InstantiationException ex) {
                Logger.log(Level.SEVERE, Binder.class,ex.getMessage());
            } catch (IllegalAccessException ex) {
                Logger.log(Level.SEVERE, Binder.class,ex.getMessage());
            }
        } catch (ClassNotFoundException ex) {
            Logger.log(Level.SEVERE, Binder.class,ex.getMessage());
        }
        if(errorList.isEmpty())
        try {
            Method m = db.getClass().getMethod("save" + getClassName(object.getClass()), new Class[]{AbstractObject.class});
            if(logic != null)
            try {
                m.invoke(db, object);
            } catch (IllegalAccessException ex) {
                Logger.log(Level.SEVERE, Binder.class,ex.getMessage());
            } catch (IllegalArgumentException ex) {
                Logger.log(Level.SEVERE, Binder.class,ex.getMessage());
            } catch (InvocationTargetException ex) {
                Logger.log(Level.SEVERE, Binder.class,ex.getMessage());
            }
        } catch (NoSuchMethodException ex) {
            Logger.log(Level.SEVERE, Binder.class,ex.getMessage());
        } catch (SecurityException ex) {
            Logger.log(Level.SEVERE, Binder.class,ex.getMessage());
        }

        return errorList;
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
