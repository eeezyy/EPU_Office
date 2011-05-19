/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Comparator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import model.AbstractObject;
import view.AbstractViewPanel;

/**
 *
 * @author MAS
 */
public class ModelObserver implements Observer {

    private List<AbstractObject> list;
    private Comparator<AbstractObject> cmp;
    private NotifyObject notifyObject;
    
    private AbstractViewPanel view;

    public ModelObserver(AbstractViewPanel view) {
        this.view = view;
    }

    public void update(Observable o, Object arg) {
        System.out.println("update observer");
        view.initialize();
        /*
        notifyObject = (NotifyObject) arg;
        switch (notifyObject.getState()) {
            case ADDED:
                controller.add(notifyObject.getObject());
                break;
            case CHANGED:
                controller.change(notifyObject.getObject());
                break;
            case DELETED:
                controller.delete(notifyObject.getObject());
                break;
            default:
                System.out.println("state not reachable");
                break;
         
        }*/
        
        

        //Collections.sort(list, cmp);
    }


}
