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
    
    private AbstractObject changedObject;
    
    @Override
    public void notifyObservers(Object arg) {
        this.changedObject = (AbstractObject)arg;
    }
    
    public AbstractObject getChangedObject() {
        return this.changedObject;
    }
    
}
