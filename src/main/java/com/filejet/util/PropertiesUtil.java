package com.filejet.util;

import java.io.*;
import java.util.Properties;

public class PropertiesUtil {
    private Properties properties;

    public PropertiesUtil(String propertiesFileName) throws IOException {
        properties = new Properties();
        String fileSeparator = File.separator;
        String testDataFilePath = "src" + fileSeparator + "main" + fileSeparator + "resources" + fileSeparator
                + "TestData" + fileSeparator + propertiesFileName;
        FileReader reader = new FileReader(testDataFilePath);
        properties.load(reader);
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
