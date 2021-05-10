package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    // make property as static
    public static Properties prop;

    // make method as static
    public static void getProperties() {
        try
        {
            String projectPath = System.getProperty("user.dir");
            File src = new File(projectPath+"/Utilities/Data.properties");
            FileInputStream fis = new FileInputStream(src);
            prop = new Properties();
            prop.load(fis);

        }
        catch (Exception e)
        {
            System.out.println("Exception is" + e.getMessage());
        }
    }
}
