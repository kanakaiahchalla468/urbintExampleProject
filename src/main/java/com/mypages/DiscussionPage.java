/**
* @description Discussion page Class  where defined all methods and elements related to Discussion page
* @author Kanakaiah Challa
* @date 09/05/2021
*
*/

package com.mypages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class DiscussionPage extends base {

	private WebDriver driver;

	public DiscussionPage(WebDriver driver) {
		this.driver = driver;
	}

	By searchButton = By.xpath("//a[@id='search-button']");

	By searchTerm = By.xpath("//input[@id='search-term']");

	By textRelatedToTopic = By.xpath("//div[@class='topic']/following-sibling::div//span[@class='ember-view']");

	public WebElement getSearchButton() {
		return driver.findElement(searchButton);
	}

	public WebElement getSearchTerm() {
		return driver.findElement(searchTerm);
	}

	public WebElement textRelatedToTopic() {
		return driver.findElement(textRelatedToTopic);
	}

	/**
	 * Verifies the search results displayed search page and the count.
	 * 
	 * @param keyword
	 */
	public void VerifySearchResults(String keyword) {
		getSearchButton().click();
		getSearchTerm().sendKeys(keyword);
		getSearchTerm().sendKeys(Keys.ENTER);
		List<WebElement> results = driver.findElements(textRelatedToTopic);

		int numberOfResults = results.size();

		for (int i = 0; i < numberOfResults; i++) {

			Assert.assertTrue(results.get(i).getText().toLowerCase().contains("mabl"),
					"Search result validation failed at instance" + i);

		}
		String expectedMessage = driver.findElement(By.xpath("//div[@id='search-result-count']/span")).getText();

		String actualMessage = numberOfResults + " results for";
		Assert.assertEquals(actualMessage, expectedMessage);
	}

	public void waitForSearchIconDisplayed() {
		waitForElementPresent(searchButton);
	}

}
