# urbintExampleProject Automation Using Selenium With Java 
Getting Started

Prerequisities:
Maven: Apache Maven 3.8.1 Can be downloaded from "https://maven.apache.org/download.cgi" 
Java: JDK 1.11 and can be downloaded from https://www.oracle.com/ca-en/java/technologies/javase-downloads.html

Project is based Project management Tool Maven, Added following dependencies in Pom.xml file, so no need add any additional dependicies.
selenium-java
testng
poi & Poi-ooxml
commons-io
Extent Reports

Java Selenium Page Objects
All Selenium Page Objects Exis in "C:\kanakaiah\Automation\Selenium\PracticeWorkspace\urbintExample\src\main\java\com\mypages"
Page Class name Should reflect the page name.

Page Object without Page Factory.
1.All selenium based actions are performed in Base Class
2. The class name should reflect the page name 
     . All functions are public 
3. All Page Clases extends the Base class.

Test Classes:
1. All Test Classes exist in "src\test\java\myTests" folder.
2. All test are defined with @Test Annotation leveraging Testng Annotations.

How To Run:

From command Propmt navigate to Project Folder location.

execute Below commnds:
mvn clean
mvn Test

After the Test Execution , Navigate to the project folder, look for the Subfolder "report" and open the report created.
you can verify the test cases status with screen shot attached.

Below Are the Utilities used in the project and Available at "\src\main\java\com\utils"

Properties File: Browser and Project URL information are retrieved from Properties File.
Excel Utils: Test Data for login funtionalities are retried from Excel Page.
Extent Reports: To generate the reports related to Test Execution.
Screen Shot: Takes screen shot on test Pass and fail.

Chrome Browser --version 90 ,Fire Fox Browser,  Excel file, Properties file are available at "Project\Utilities"
