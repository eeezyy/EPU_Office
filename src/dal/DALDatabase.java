/**
 * 
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

import model.*;

/**
 * @author Alex
 *
 */
public class DALDatabase implements IDAL {

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(epu_office.Main.config.getProperties().getProperty("db"),
                epu_office.Main.config.getProperties().getProperty("db_user"),
                epu_office.Main.config.getProperties().getProperty("db_pwd"));
    }

    /* (non-Javadoc)
     * @see DAL.IDAL#initialize()
     */
    @Override
    public void initialize() throws DALException {

        // load mysql driver
        try {
            Class.forName(epu_office.Main.config.getProperties().getProperty("db_driver"));
        } catch (ClassNotFoundException ex) {
            throw new DALException(ex.getMessage());
        }

    }

}
