/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.log;

import java.util.HashSet;
import java.util.Iterator;
import java.util.logging.Level;

/**
 *  @author Alexander Kumbeiz & Goran Janosevic
 */
public class AppenderManager {

    private static AppenderManager instance;
    private HashSet<Appender> appenderList;

    protected AppenderManager() {
        appenderList = new HashSet<Appender>();
        if (!(addAppender(new ConsoleAppender()))) {
            System.out.println("ConsoleAppender konnte nicht hinzugefügt werden.");

        }
        if (!(addAppender(new FileAppender()))) {
            System.out.println("FileAppender konnte nicht hinzugefügt werden.");
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

    void log(Level level, Class c, String message) {
        Iterator<Appender> it = appenderList.iterator();
        while (it.hasNext()) {
            it.next().log(level, c, message);
        }
    }

    static {
        instance = new AppenderManager();
    }
}
