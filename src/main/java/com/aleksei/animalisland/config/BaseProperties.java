package com.aleksei.animalisland.config;

import java.io.InputStream;
import java.util.Properties;

public class BaseProperties {
    private final String propsFolder;

    public BaseProperties(String propsFolder) {
        this.propsFolder = propsFolder;
    }

    public Properties loadProperties(String propertiesName) {
        Properties properties = new Properties();
        try {
            String FILE_EXTENSION = ".properties";
            InputStream inputStream = this.getClass()
                    .getClassLoader()
                    .getResourceAsStream(propsFolder + "/" + propertiesName + FILE_EXTENSION);
            properties.load(inputStream);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return properties;
    }
}
