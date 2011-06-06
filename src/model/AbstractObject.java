/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author if09b505
 */
public class AbstractObject {
    
    private Integer id;

    public Integer getId() {
        if(this.id == null) {
            return 0;
        }
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
