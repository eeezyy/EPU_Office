package config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import utils.log.Logger;
import utils.log.TracingLevel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Alex
 */
public class Config {

    private Properties config;
    // block-anfang: aus config auslesen!
    private static TracingLevel traceLevel;// = TracingLevel.SEVERE;
    private static boolean stackTrace;// = true;
    private String dbPath;
    // block-ende

    public Config() {
        config = new Properties();
        try {
            config.load(new FileInputStream("config.properties"));
            if (config.getProperty("db").equals("mySQL")) {
                dbPath = "jdbc:mysql://";
                dbPath += ((config.getProperty("db_ip")) + ":");
                dbPath += (config.getProperty("db_port") + "/");
                dbPath += (config.getProperty("db_name"));

                //localhost\:3306/swe_epu_office"
            }
            traceLevel = TracingLevel.valueOf(config.getProperty("traceLevel"));
            stackTrace = Boolean.parseBoolean(config.getProperty("stackTrace"));
        } catch (IOException ex) {
            Logger.log(Level.SEVERE, Config.class, ex);
        }
    }

    public void save(ArrayList<String> newValue) {
        try {
            config.setProperty("db", newValue.get(0));
            config.setProperty("db_user", newValue.get(1));
            config.setProperty("db_pwd", newValue.get(2));
            config.setProperty("db_ip", newValue.get(3));
            config.setProperty("db_port", newValue.get(4));
            config.store(new FileOutputStream("config.properties"), null);
        } catch (IOException ex) {
            Logger.log(Level.SEVERE, Config.class, ex);
        }
    }

    public Properties getProperties() {
        return config;
    }

    public static TracingLevel getTraceLevel() {
        return traceLevel;
    }

    public static boolean getStackTrace() {
        return stackTrace;
    }

    public String getDbPath() {
        return dbPath;
    }
}
