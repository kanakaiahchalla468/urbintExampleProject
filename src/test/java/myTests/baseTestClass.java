/**
* @description BaseTestClass where defined all the test cases
* @author Kanakaiah Challa
* @date 09/05/2021
*
*/
package myTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mypages.DiscussionPage;
import com.mypages.LoginPage;
import com.mypages.base;
import com.utils.ConfigReader;
import com.utils.ExcelReader;

public class baseTestClass extends base {
    public WebDriver driver;
/**
 *Before Method Initializes all the times when ever any test case Executed with @test Annotation
 *calls the "intilaizeBrowser" method defined in Base class which will intilaize the Browser of our selection
 *Using Properties file to declare Project URL
 */
    @BeforeMethod(alwaysRun = true)
    public void sample() {
        driver = intilaizeBrowser();
        driver.get(ConfigReader.prop.getProperty("projectURL"));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    /**
     * Uisng the Data Provider and Excel Utils Class passing the required information to the test case
     * @param username
     * @param password
     * @param keyword
     * Verifies the Login Funtionlaity, once Login Verifies the No Login button Dipslayed in the Page
     */

    @Test(dataProvider = "ValidLoginCredentialsWithKeyWordSearch")
    public void ValidLogin(String username, String password, String keyword) {
        LoginPage login = new LoginPage(driver);

        login.LoginCrdentails(username, password);
        login.verifyLoginButtonIsntVisible();
    }

    /**
     *
     * @throws InterruptedException
     * Verifies list of elements Present in the Login page.
     */

    @Test
    public void VerifyElementsPresentInLoginPage() throws InterruptedException {
        LoginPage login = new LoginPage(driver);

        login.verifyLearnButtonisVisible();
        login.verifyChatIconButtonisVisible();
        login.verifyContributeButtonisVisible();
        login.verifyEventsButtonisVisible();
        login.verifyJoinNowButtonisVisible();
        login.verifySupportButtonisVisible();
        login.verifyDropDownValuesUnderSupportButton();

    }

/**
 *
 * @param username
 * @param password
 * method verifies the Invalid login Funtionlaity and verifies the error message prompted.
 * With the help of data provider and Excel Util class, Passing the required Test Data to the class
 * Can be exceuted multiple time with number of Data added to the Excel
 */
    @Test(dataProvider = "inValidLoginCredentials")
    public void InValidLogin(String username, String password) {
        LoginPage login = new LoginPage(driver);
        login.LoginCrdentails(username, password);
        verifyMessagePrompted(login.ErrorMessage(), "Invalid Login or password.");
    }
/**
 *
 * @param keyword
 * @throws InterruptedException
 *
 * Passing the Required information using the Parameter Keyword defined in Testng Xml file.
 * Verifies the Number of Keyword Results displayed for mabl and also verifies the results are related to keyword.
 */
    @Test
    @Parameters({ "keyword" })
    public void verifySearchResults(String keyword) throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        click(login.getDiscussion());
        DiscussionPage disc = new DiscussionPage(driver);

        disc.VerifySearchResults(keyword);
    }
/**
 * Data Provider with name "ValidLoginCredentialsWithKeyWordSearch" Looks for the Data from Excel from sheet 0
 * @return
 */
    @DataProvider(name = "ValidLoginCredentialsWithKeyWordSearch")
    public Object[][] testData() {
        ExcelReader excel = new ExcelReader("./Utilities/urbintTestData.xlsx");

        int rows = excel.getRowCount(0);
        int column = excel.getColoumCount(0);
        System.out.println(column);
        System.out.println(rows);
        Object[][] data = new Object[rows - 1][column];
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                data[i - 1][j] = excel.getDatafromExcel(0, i, j);

            }

        }

        return data;
    }
    /**
     * Data Provider with name "inValidLoginCredentials" Looks for the Data from Excel from sheet 0
     * @return
     */

    @DataProvider(name = "inValidLoginCredentials")
    public Object[][] invalidLoginCred() {
        ExcelReader excel = new ExcelReader("./Utilities/urbintTestData.xlsx");

        int rows = excel.getRowCount(1);
        int column = excel.getColoumCount(1);
        System.out.println(column);
        System.out.println(rows);
        Object[][] data = new Object[rows - 1][column];
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                data[i - 1][j] = excel.getDatafromExcel(1, i, j);

            }

        }

        return data;
    }

    /**
     * Runs after Every method Executed and closes the window and session.
     */

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

}
