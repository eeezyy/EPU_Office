package config;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
    private static TracingLevel traceLevel = TracingLevel.SEVERE;
    private static boolean stackTrace = true;
    // block-ende
    
    public Config() {
        config = new Properties();
        try {
            config.load(new FileInputStream("config.properties"));
        } catch (IOException ex) {
            Logger.log(Level.SEVERE, Config.class,ex);
        }
    }

    public void save() {
        try {
            config.store(new FileOutputStream("config.properties"), null);
        } catch (IOException ex) {
            Logger.log(Level.SEVERE, Config.class,ex);
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
    
}
