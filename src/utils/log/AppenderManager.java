/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.log;

import config.Config;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *  @author Alexander Kumbeiz & Goran Janosevic
 */
public class AppenderManager {

    private TracingLevel allowedLevel = Config.getTraceLevel();
    private int tracingLvl = allowedLevel.ordinal();
    private boolean stackTrace = Config.getStackTrace();
    private static AppenderManager instance;
    private HashSet<Appender> appenderList;
    private ArrayList<String> loadAppender;

    protected AppenderManager() {
        appenderList = new HashSet<Appender>();
        this.loadAppender = Config.getAppenderList();
        /*if (!(addAppender(new ConsoleAppender()))) {
        System.out.println("ConsoleAppender konnte nicht hinzugefügt werden.");
        
        }
        if (!(addAppender(new FileAppender()))) {
        System.out.println("FileAppender konnte nicht hinzugefügt werden.");
        }*/
        for (int i = 0; i < loadAppender.size(); i++) {
            try {
                try {
                    if (!(addAppender((Appender) Class.forName("utils.log." + loadAppender.get(i) + "Appender").newInstance()))) {
                        System.out.println("Folgender Appender konnte nicht hinzugefügt werden: " + loadAppender.get(i));
                    }
                } catch (InstantiationException ex) {
                    System.out.println("hier komm ich vor");
                } catch (IllegalAccessException ex) {
                    System.out.println("oder hier");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AppenderManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static AppenderManager getInstance() {
        return instance;
    }

    public boolean addAppender(Appender appender) {
        if ((appender != null)) {
            if (appenderList.add(appender)) {
                appender.configure();
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean removeAppender(Appender appender) {
        return appenderList.remove(appender);
    }

    void log(Level level, Class c, Exception ex) {
        String aktivesLevel = "";
        boolean flag = false;
        int i = 0;

        if (TracingLevel.valueOf(level.toString()).ordinal() <= allowedLevel.ordinal()) {
            if (!(aktivesLevel.equals(level.toString()))) {
                aktivesLevel = level.toString();
                if (aktivesLevel.equalsIgnoreCase("SEVERE")) {
                    Config.setStackTrace(true);
                    Iterator<Appender> it = appenderList.iterator();
                    while (it.hasNext()) {
                        it.next().log(level, c, ex);
                    }
                } else if (aktivesLevel.equalsIgnoreCase("INFO")) {
                    Iterator<Appender> it = appenderList.iterator();
                    Config.setStackTrace(false);
                    while (it.hasNext()) {
                        it.next().log(level, c, ex);
                    }

                } else {
                    Iterator<Appender> it = appenderList.iterator();
                    Config.setStackTrace(stackTrace);
                    while (it.hasNext()) {
                        it.next().log(level, c, ex);
                    }
                }
            }
        }
    }
//        while (i < (TracingLevel.valueOf(level.toString())).ordinal()) {
//            if (!(aktivesLevel.equals(level.toString()))) {
//                aktivesLevel = level.toString();
//                Iterator<Appender> it = appenderList.iterator();
//                while (it.hasNext()) {
//                    it.next().log(level, c, ex);
//                }
//            }
//            i++;
//            System.out.println("Counter: " + i + "und dessen Level: " + TracingLevel.values()[i].toString());
//        }
        /*
    for (int i = 0; i < TracingLevel.values().length; i++) {
    if (((i == tracingLvl) && (!(aktivesLevel.equals(level.toString())))) && (flag != true)) {
    aktivesLevel = level.toString();
    Iterator<Appender> it = appenderList.iterator();
    while (it.hasNext()) {
    it.next().log(level, c, ex);
    }
    flag = true;
    } else if (((i != tracingLvl) && (!(aktivesLevel.equals(level.toString())))) && (flag != true)) {
    aktivesLevel = level.toString();
    Iterator<Appender> it = appenderList.iterator();
    while (it.hasNext()) {
    it.next().log(level, c, ex);
    }
    }
     */

    static {
        instance = new AppenderManager();
    }
}
