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

    public void configure() {
        System.out.println("Fehlerausgabe (Konsole) aktiviert.");
    }

    public void log(Level level, Class c, String message) {
        System.out.println(level.toString() + ": " + c.getName() + " -> " + message);
    }
}
