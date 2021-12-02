package com.virtusa.demo.pages;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;

public class ResultsPage {

	WebDriver driver;
	Actions actions;

	@FindBy(how = How.XPATH, using ="//*[@id='b_results']/li | //*[@id='search']//div[@class='hlcw0c' or @class='ULSxyf']")
	private List<WebElement> resultsList;

	@FindBy(how = How.XPATH, using = "//*[@id='result-stats' or @aria-label='Search Results']")
	private WebElement resultStats;

	@FindBy(how = How.XPATH, using = "//div[@id='search']//a")
	private List<WebElement> searchLinks;

	public List<WebElement> getSearchLinks() {
		return searchLinks;
	}

	public WebElement getResultStats() {
		return resultStats;
	}

	public List<WebElement> getResultsList() {
		return resultsList;
	}

	public int getResultsListSize() {
		return resultsList.size();
	}

	public void navigateBack() {
		driver.navigate().back();
	}

	public ResultsPage(WebDriver driver, Scenario scn) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		scn.write("User is on google search results page");
	}

	public void validateSearchResults() {
		assertTrue("No search results found", this.getResultsListSize() > 0);
	}

	public void isLoaded() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("return document.readyState").equals("complete");
		new WebDriverWait(this.driver, 20).until(ExpectedConditions.visibilityOfAllElements(resultsList));
	}

	public void validateSearchResultsByIndex(int index, String searchKey) throws InterruptedException {
		if (actions == null) {
			actions = new Actions(driver);
		}
		actions.moveToElement(resultsList.get(index)).perform();
		String text = resultsList.get(index).getText();
		assertTrue(
				"Google search results NOT correct, expected is: " + searchKey + " and actual is: "
						+ text,
				text.toLowerCase().contains(searchKey));
	}

	public void validateAllSearchResults(String searchKey) {
		if (actions == null) {
			actions = new Actions(driver);
			for (WebElement ele : resultsList) {
				actions.moveToElement(ele).perform();
				assertTrue("Google search results NOT correct, expected is: " + searchKey + " and actual is: "
						+ ele.getText(), ele.getText().toLowerCase().contains(searchKey));
			}
		}
	}

}
