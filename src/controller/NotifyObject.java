/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.AbstractObject;

/**
 *
 * @author MAS
 */
public class NotifyObject {
    private AbstractObject object;
    
    public NotifyObject(AbstractObject object, State state) {
        this.object = object;
        this.state = state;
    }

    public AbstractObject getObject() {
        return object;
    }

    public State getState() {
        return state;
    }
    private State state;
    
    
    
}
