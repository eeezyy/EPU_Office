/**
 * 
 */
package model.dal;

import java.util.ArrayList;
import model.*;

/**
 * @author Alex
 *
 */
public interface IDAL {

    public void initialize() throws DALException;

    public void saveKontakt(AbstractObject k) throws DALException;

    public void deleteKontakt(Kontakt k) throws DALException;

    public ArrayList<Kontakt> getKontaktListe() throws DALException;
}
