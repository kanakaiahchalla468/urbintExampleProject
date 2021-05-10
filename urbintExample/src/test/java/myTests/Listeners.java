package myTests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.mypages.base;
import com.utils.ExtentReport;
import com.utils.ScreenShot;

public class Listeners extends base implements ITestListener {
    ExtentTest test;
    ExtentReports extent = ExtentReport.extentReportConfig();
    /**
     * To Be in Thread safe When executing the test cases parallelly
     * Intiating the Threadlocal class
     */
    ThreadLocal<ExtentTest> local = new ThreadLocal<ExtentTest>();

    @Override
    public void onTestStart(ITestResult result) {

        System.out.println("**********Test Started********* " + result.getMethod().getMethodName());

        test = extent.createTest(result.getMethod().getMethodName());
        local.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("**********Test Success********* " + result.getMethod().getMethodName());
        local.get().log(Status.PASS, "Test Case Passed");
        WebDriver driver =null;
        try {
            driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch(Exception e)
        {

        }

        String testMethodName = result.getMethod().getMethodName();
        try {
            local.get().addScreenCaptureFromPath(ScreenShot.takeScreenShotOnSuccess(testMethodName, driver), testMethodName);


        } catch (Exception e) {
            System.out.println("Error related to GetScreenshotMethod" + e.getMessage());
        }

    }

    @Override
    public void onTestFailure(ITestResult result) {
        local.get().fail(result.getThrowable());

        WebDriver driver =null;
        try {
            driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch(Exception e)
        {

        }

        String testMethodName = result.getMethod().getMethodName();
        try {
            local.get().addScreenCaptureFromPath(ScreenShot.takeScreenShotOnFailure(testMethodName, driver), testMethodName);


        } catch (Exception e) {
            System.out.println("Error related to GetScreenshotMethod" + e.getMessage());
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

}
