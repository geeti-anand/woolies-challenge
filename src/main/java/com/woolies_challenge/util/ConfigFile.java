package com.woolies_challenge.util;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigFile {

    public static Properties configProperties() {

        Properties properties = new Properties();
        String fileName = null;
        String env = System.getProperty("env"); // default env is PROD

        if (env == null || env.equals("prod")) {
            fileName = "src/main/resources/config.properties";
        }else {
            fileName = "src/main/resources/config.properties";
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            properties.load(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }
}


