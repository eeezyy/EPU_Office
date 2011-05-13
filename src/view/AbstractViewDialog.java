/*
 * AbstractViewPanel.java
 *
 * Created on January 22, 2007, 9:06 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package view;

import controller.AbstractController;
import controller.ModelObservable;
import java.awt.Frame;
import java.util.List;
import javax.swing.JDialog;

/**
 * This class provides the base level abstraction for views in this example. All
 * views that extend this class also extend JPanel (which is useful for performing
 * GUI manipulations on the view in NetBeans Matisse), as well as providing the 
 * modelPropertyChange() method that controllers can use to propogate model 
 * property changes.
 *
 * @author Robert Eckstein
 */
public abstract class AbstractViewDialog extends JDialog {

    private AbstractController controller;

    public AbstractController getController() {
        return controller;
    }

    public ModelObservable getObservable() {
        return observable;
    }
    private ModelObservable observable;

    public AbstractViewDialog(ModelObservable observable, Frame owner, boolean modal) {
        super(owner, modal);
        this.observable = observable;
    }

    public void setController(AbstractController controller) {
        this.controller = controller;
    }

    /**
     * Called by the controller when it needs to pass along a property change 
     * from a model.
     *
     * @param evt The property change event from the model
     */
    public abstract void modelPropertyChange(List<?> properties);
}
