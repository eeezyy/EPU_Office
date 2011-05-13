/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author MAS
 */
public class ModelObserver implements Observer {

    public void update(Observable o, Object arg) {
        // Dieser Beobachter (Observer) ruft v
        o.notifyObservers(arg);
    }
    
}
