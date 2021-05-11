/**
* @description Defined for taking Screen shot
* @author Kanakaiah Challa
* @date 09/05/2021
*
*/
package com.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
    static Date date;
    static SimpleDateFormat dateFormat;

    public static String takeScreenShotOnFailure(String testName, WebDriver driver) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        date = new Date();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        // To Store the screen shot in out put file
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir") + "\\ScreenShot\\Failure\\" + dateFormat.format(date)
                + testName + ".png";
        // Screenshot is in Virtual location and to copy the file in th our system
        // Apacheio
        try {
            FileUtils.copyFile(source, new File(destinationFile));
        } catch (Exception e) {

            System.out.println("Destination File Not created" + e.getMessage());
        }

        return destinationFile;
    }

    public static String takeScreenShotOnSuccess(String testName, WebDriver driver) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        date = new Date();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        // To Store the screen shot in out put file
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir") + "\\ScreenShot\\Success\\" + dateFormat.format(date)
                + testName + ".png";
        // Screenshot is in Virtual location and to copy the file in th our system

        try {
            FileUtils.copyFile(source, new File(destinationFile));
        } catch (Exception e) {

            System.out.println("Destination File Not created" + e.getMessage());
        }
        return destinationFile;
    }
}
