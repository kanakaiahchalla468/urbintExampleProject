/**
* @description LoginPageTest Class Defined all the Elements, Methods related Login Page
* @author Kanakaiah Challa
* @date 09/05/2021
*
*/

package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class LoginPage extends base {

    /**
     *
     * Intialiaze the constructor with Paramater driver so that driver defined has Life
     */
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By userNameInput = By.xpath("//input[@id='user_login']");
    private By passwordInput = By.xpath("//input[@id='user_password']");
    private By signIn = By.xpath("//input[@value='Sign In']");
    private By Login = By
            .xpath("//button[@class='widget-button btn btn-primary btn-small login-button btn-icon-text']");
    private By ErrorMessage = By.xpath("//div[@class='mt-3 mx-3 alert alert-danger alert-dismissible fade show']");
    private By discussion = By.xpath("//a[text()[contains(.,'Discussions')]]");
    private By learn = By.xpath("//a[text()[contains(.,'Learn')]]");
    private By events = By.xpath("//a[@id='eventNav']");
    private By contribute = By.xpath("//a[@id='contributeNav']");
    private By joinNow = By.xpath("//a[@id='nav-join-now']");
    private By support = By.xpath("//a[@id='supportDropdown']");
    private By loginLabelMessage = By.xpath("//label[@for='user_remember_me']");
    private By userRemeberMeCheckBox = By.xpath("//input[@class='form-check-input boolean optional']");
    private By chatIcon = By.xpath("//div[@class='gist-chat-icon is-loaded']");
    private By knowledge = By.xpath("//a[@id='knowledgebase']");
    private By contactUs = By.xpath("//a[@id='contactus']");

    public WebElement getUserRemeberMeCheckBox()
    {
        return driver.findElement(userRemeberMeCheckBox);
    }
    public WebElement getLoginLabelMessage()
    {
       return driver.findElement(loginLabelMessage);
    }

    public WebElement getUserName() {
        return driver.findElement(userNameInput);
    }

    public WebElement getPassword() {
        return driver.findElement(passwordInput);
    }

    public WebElement getSignIn() {
        return driver.findElement(signIn);
    }

    public WebElement ErrorMessage() {
        return driver.findElement(ErrorMessage);
    }

    public WebElement getDiscussion() {
        return driver.findElement(discussion);
    }

    public WebElement getLogIn() {
        return driver.findElement(Login);
    }

    public void LoginCrdentails(String username, String password) {
        getUserName().sendKeys(username);
        getPassword().sendKeys(password);
        getSignIn().click();
    }

    public void verifyLoginButtonIsntVisible() {
        try {
            Assert.assertEquals(0, driver.findElements(Login).size());
            System.out.println("Login button isn't visisble after user logged in successfully");
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }

    public void verifyEventsButtonisVisible() {

        try {
            Assert.assertEquals(0, isElementPresent(events));
            System.out.println("Verified Events Button is visible on the Login page");
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    public void verifyContributeButtonisVisible() {
        try {
            Assert.assertEquals(0, isElementPresent(contribute));
            System.out.println("Verified Contribute Button is visible on the Login page");
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    public void verifyJoinNowButtonisVisible() {
        try {
            Assert.assertEquals(0, isElementPresent(joinNow));
            System.out.println("Verified JoinNow Button is visible on the Login page");
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    public void verifyChatIconButtonisVisible() {
        try {
            Assert.assertEquals(0, isElementPresent(chatIcon));
            System.out.println("Verified ChatIcon Button is visible on the Login page");
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    public void verifyLearnButtonisVisible() {
        try {
            Assert.assertEquals(0, isElementPresent(learn));
            System.out.println("Verified Learn Button is visible on the Login page");
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    public void verifySupportButtonisVisible() {
        try {
            Assert.assertEquals(0, isElementPresent(support));
            System.out.println("Verified Support Button is visible on the Login page");
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    public void verifyDropDownValuesUnderSupportButton() {
        new Actions(driver).moveToElement(driver.findElement(support)).build().perform();
        try {
            Assert.assertEquals(0, isElementPresent(knowledge));
            System.out.println("Verified knowledge Link is visible on the Login page");
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        try {
            Assert.assertEquals(0, isElementPresent(contactUs));
            System.out.println("Verified ContactUs Link is visible on the Login page");
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }
    public void verifyUserRemeberMeCheckBoxisntSelected()
    {
        try
        {
            Assert.assertFalse(VerifyElementChecked(getUserRemeberMeCheckBox()));
            System.out.println("UserRemeberMeCheckBox isnt Selected by default");
        }
        catch (Exception e)
        {
            System.out.println("UserRemeberMeCheckBox is Selected by Default" + e.getMessage());

        }
    }
public void verifyTextDisplayedAtRemeberMeCheckBox()
{
    verifyMessagePrompted(getLoginLabelMessage(), "Keep me signed in for 14 days");
}
}
