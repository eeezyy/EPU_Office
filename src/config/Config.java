package config;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

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

    public Config() {
        config = new Properties();
        try {
            config.load(new FileInputStream("config.properties"));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void save() {
        try {
            config.store(new FileOutputStream("config.properties"), null);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public Properties getProperties() {
        return config;
    }
}
