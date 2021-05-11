/**
* @description Defined for generating the Report using extent reports 
* @author Kanakaiah Challa
* @date 09/05/2021
*
*/
package com.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

    static ExtentReports report;

    public static ExtentReports extentReportConfig() {

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String path = System.getProperty("user.dir") + "\\Reports\\index " + dateFormat.format(date) + ".html";

        /**
         * To Create Report of type extent report--ExtentSparkReporter
         *
         */

        ExtentSparkReporter reporter = new ExtentSparkReporter(path);

        reporter.config().setReportName("WebAutomation");

        reporter.config().setDocumentTitle("UrbintTestReport");

        /**
         * Now we created reporter, create now report
         *
         */
        report = new ExtentReports();
        report.attachReporter(reporter);
        report.setSystemInfo("Tester", "Kanakaiah challa");
        return report;

    }



}
