/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.log;

import java.util.logging.Level;

/**
 *  @author Alexander Kumbeiz & Goran Janosevic
 */
public class ConsoleAppender implements Appender {
    //nur info erlaubt <-- config?

    public void configure() {
         System.out.println("Fehlerausgabe (Konsole) aktiviert.");
    }

    public void log(Level level, Class c, Exception exception) {
        if(config.Config.getStackTrace()){
            //System.out.println(level.toString() + ": " + c.getName() + " -> " + exception.getStackTrace().toString());
            exception.printStackTrace();
        } else {
            System.out.println(level.toString() + ": " + c.getName() + " -> " +  exception.getMessage());
        }
        
    }
}
