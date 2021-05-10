/**
* @description Base Class where defined mostly resuable methods
* @author Kanakaiah Challa
* @date 09/05/2021
*
*/


package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.utils.ConfigReader;

public class base {
    public WebDriver driver;
    public WebDriverWait wait;

    public Actions action;

    public WebDriver intilaizeBrowser() {

        try {
            ConfigReader.getProperties();
            String browserName = ConfigReader.prop.getProperty("browser");

            if (browserName.equals("Chrome")) {
                System.setProperty("webdriver.chrome.driver", "./Utilities/chromedriver.exe");
                driver = new ChromeDriver();

            } else if (browserName.equals("chrome")) {
                System.setProperty("webdriver.gecko.driver", "./Utilities/geckodriver.exe");
                driver = new FirefoxDriver();

            }

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return driver;
    }

    public void click(WebElement Element)

    {
        Element.click();
    }

    public void sendKeys(WebElement Element, String keys) {
        Element.sendKeys(keys);
    }

    public void waitForElementPresent(By locator) {
        try {
            wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            System.out.println("some exception/error occurred while waiting for the element " + locator.toString());
        }
    }

    public int isElementPresent(By by) {
        try {

            return driver.findElements(by).size();

        } catch (Exception e) {
            return 0;
        }
    }

    public void verifyMessagePrompted(WebElement element, String expected) {
        String message = element.getText();
        Assert.assertTrue(message.contains(expected), "Message Provided not matched with the Actual Result");
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getPageHeader(By locator) {
        return getElement(locator).getText();
    }

    public WebElement getElement(By locator) {
        WebElement element = null;
        try {
            waitForElementPresent(locator);
            element = driver.findElement(locator);
            return element;
        } catch (Exception e) {
            System.out.println("some error occurred while creating element " + locator.toString());
            e.printStackTrace();
        }

        return element;
    }

    public void waitForPageTitle(String title) {
        try {
            wait.until(ExpectedConditions.titleContains(title));
        } catch (Exception e) {
            System.out.println("some exception/error occurred while waiting for the element " + title);
        }
    }
    public boolean VerifyElementChecked(WebElement element)
    {
      return element.isSelected();
    }


}
