/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.log;

import java.util.logging.Level;

/**
 *
 * @author Goran-Goggy
 */
public class Logger {
    public static void log(Level level, String message) {
        AppenderManager.getInstance().log(level, message);
    }
}
