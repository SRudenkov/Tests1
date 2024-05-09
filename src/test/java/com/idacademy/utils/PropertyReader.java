package com.idacademy.utils;

import com.idacademy.Propertyfile;
import com.idacademy.enums.Capability;
import org.apache.commons.lang3.StringUtils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    public static String getProperty(Propertyfile propertyfile, Capability capability) {
        Properties properties = new Properties();
        FileReader fileReader;
        try {
            fileReader = new FileReader("src/main/resources/" + propertyfile.getPathToFile());
            properties.load(fileReader);
        } catch (IOException e) {
            System.out.println(" Properties are not loaded, use default value... chrome ");
        }
        for (Object key : properties.keySet()) {
            String systemValue = System.getProperty((String) key);
            if (!StringUtils.isEmpty(systemValue)) {
                properties.put(key, systemValue);
            }
        }
        return properties.getProperty(capability.getKey(), capability.getDefaultValue());
    }

    public static String getConfigProperty(Capability capability) {
        return getProperty(Propertyfile.CONFIG, capability);

    }
}
