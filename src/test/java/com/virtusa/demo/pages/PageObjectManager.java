package com.virtusa.demo.pages;

import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;

public class PageObjectManager {
	HomePage homePage;
	ResultsPage resultsPage;
	WebDriver driver;
	Scenario scn;

	public PageObjectManager(WebDriver driver, Scenario scn) {
		this.driver = driver;
		this.scn = scn;
	}

	public HomePage getHomePage() {
		if (homePage == null) {
			return homePage = new HomePage(driver, scn);
		} else {
			return homePage;
		}
	}

	public ResultsPage getResultsPage() {
		if (resultsPage == null) {
			return resultsPage = new ResultsPage(driver, scn);
		} else {
			return resultsPage;
		}
	}
}

