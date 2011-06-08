package config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.logging.Level;
import utils.log.Appender;
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
    private static ArrayList<String> appenderList;
    private static String defaultDbName = "swe_epu_office";
    private String dbPfad;
    private String defaultAppender = "Console";
    private String defaultTraceLevel = "SEVERE";
    private Integer defaultPort = 3306;
    private String defaultDriver = "com.mysql.jdbc.Driver";
    private String defaultUser = " ";
    private String defaultDb = "mySQL";
    private String defaultIp = "localhost";
    private String defaultPwd = " ";

    // block-ende
    public Config() {
        config = new Properties();
        try {
            config.load(new FileInputStream("config.properties"));
            if (config == null) {
                ArrayList<String> defaultSetting = new ArrayList<String>();
                defaultSetting.add(defaultDbName);
                defaultSetting.add(defaultAppender);
                defaultSetting.add(defaultTraceLevel);
                defaultSetting.add(defaultPort.toString());
                defaultSetting.add(defaultDriver);
                defaultSetting.add(defaultUser);
                defaultSetting.add(defaultDb);
                defaultSetting.add(defaultIp);
                defaultSetting.add(defaultPwd);
            }
            if (config.getProperty("db").equals("mySQL")) {
                dbPfad = "jdbc:mysql://";
                dbPfad += ((config.getProperty("db_ip")) + ":");
                dbPfad += (config.getProperty("db_port") + "/");
                dbPfad += (config.getProperty("db_name"));

                //localhost\:3306/swe_epu_office"
            } else {
                dbPfad = "jdbc:mysql://";
                dbPfad += ((config.getProperty("db_ip")) + ":");
                dbPfad += (config.getProperty("db_port") + "/");
                dbPfad += (config.getProperty("db_name"));
            }
            traceLevel = TracingLevel.valueOf(config.getProperty("traceLevel").toUpperCase());
            //System.out.println("WERT VON TRACELEVEL: " + traceLevel.toString());
            stackTrace = Boolean.parseBoolean(config.getProperty("stackTrace"));
            appenderList = loadAppender(config.getProperty("appender"));


        } catch (IOException ex) {
            Logger.log(Level.SEVERE, Config.class, ex);
        }
    }

    public void save(ArrayList<String> newValue) {
        try {
            int counter = 0;
            config.setProperty("db", newValue.get(0));
            config.setProperty("db_user", newValue.get(1));
            config.setProperty("db_pwd", newValue.get(2));
            config.setProperty("db_ip", newValue.get(3));
            config.setProperty("db_port", newValue.get(4));

            String appender = "";
            for (String a : appenderList) {
                if (counter == 0) {
                    appender += a;
                    counter = 1;
                } else {
                    appender += ";" + a;
                }
            }
            config.setProperty("appender", appender);
            
            /*
             *                 defaultSetting.add(defaultDbName);
                defaultSetting.add(defaultAppender);
                defaultSetting.add(defaultTraceLevel);
                defaultSetting.add(defaultPort.toString());
                defaultSetting.add(defaultDriver);
                defaultSetting.add(defaultUser);
                defaultSetting.add(defaultDb);
                defaultSetting.add(defaultIp);
                defaultSetting.add(defaultPwd);
             */
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
        return dbPfad;
    }

    private ArrayList<String> loadAppender(String property) {
        ArrayList<String> appenderList = new ArrayList<String>();
        StringTokenizer tok = new StringTokenizer(property, ";");
        while (tok.hasMoreTokens()) {
            appenderList.add(tok.nextToken());
        }
        return appenderList;
    }

    public static ArrayList<String> getAppenderList() {
        return appenderList;
    }
}
