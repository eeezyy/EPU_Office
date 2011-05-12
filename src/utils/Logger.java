/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.logging.Level;

/**
 *
 * @author Goran-Goggy
 */
public interface Logger{
    public void configure();
    public void log(Level level, String message);
}
