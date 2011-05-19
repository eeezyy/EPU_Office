/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Observable;
import model.AbstractObject;

/**
 *
 * @author MAS
 */
public class ModelObservable extends Observable {
    
    private NotifyObject notifyObject;
    private State state;
    /*
    @Override
    public void notifyObservers(Object arg) {
        this.notifyObject = (NotifyObject)arg;
        
    }*/
    
    public NotifyObject getChangedObject() {
        return this.notifyObject;
    }
    
    public void setState(State state) {
        this.state = state;
    }
    
    public State getState() {
        return this.state;
    }
    
}
