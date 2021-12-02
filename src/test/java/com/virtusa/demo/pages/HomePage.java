package com.virtusa.demo.pages;

import static com.virtusa.demo.util.CommonUtil.*;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;

public class HomePage {

	WebDriver driver;

	@FindBy(how=How.XPATH, using = "//input[@name='q']")
	private WebElement searchBox;

	//@FindBy(how = How.XPATH, using = "//div[@class='FPdoLc lJ9FBc' or @class='sbox ']//*[contains(@for,'sb_form_go') or contains(@value,'Google Search')]")
	@FindBy(how = How.XPATH, using = "//div[@class='FPdoLc lJ9FBc']//input[@value='Google Search'] | //*[@for='sb_form_go']")
	private WebElement searchBtn;

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSearchBox() {
		return searchBox;
	}

	public void enterSearchWord(String searchWord) throws InterruptedException {
		inputData(driver, searchBox, searchWord);
	}

	public void clickSearch() throws InterruptedException {
		searchBox.sendKeys(Keys.ESCAPE);
		clickElement(driver, searchBtn);
	}

	public void navigateTo(String url) {
		driver.get(url);
	}

	public HomePage(WebDriver driver, Scenario scn) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		scn.write("User is on Google home page");
	}

	public void isLoaded() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("return document.readyState").equals("complete");
		new WebDriverWait(this.driver, 10).until(ExpectedConditions.visibilityOf(searchBox));
	}
}
