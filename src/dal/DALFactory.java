/**
 * 
 */
package dal;

/**
 * @author Alex
 *
 */
public class DALFactory {
	public static IDAL getDAL() {
		// TODO: lt. Konfiguration einen anderen DAL zurück geben
		return new DALDatabase();
	}
}
