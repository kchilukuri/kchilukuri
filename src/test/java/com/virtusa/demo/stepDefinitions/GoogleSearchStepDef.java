package com.virtusa.demo.stepDefinitions;

import static com.virtusa.demo.util.CommonUtil.*;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;

import com.virtusa.demo.context.TestContext;
import com.virtusa.demo.pages.HomePage;
import com.virtusa.demo.pages.PageObjectManager;
import com.virtusa.demo.pages.ResultsPage;

import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleSearchStepDef extends BaseSteps {

	public GoogleSearchStepDef(TestContext testContext) {
		super();
		this.testContext = testContext;
	}

	static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(GoogleSearchStepDef.class.getName());

	TestContext testContext;
	HomePage homePage;
	ResultsPage resultsPage;
	PageObjectManager pom;
	Scenario scn;

	@Before
	public void setupData(Scenario scn) {
		loadProperties();
		launchDriver();
		this.scn = scn;
		// pom = new PageObjectManager(driver, scn);
		testContext.setDriver(driver);
		testContext.setScenario(scn);
		pom = testContext.getPageObjectManager();
		logger.info("Driver initialized and test context is set");
	}

	@Given("User is on google home page")
	public void user_is_on_google_home_page() {
		homePage = pom.getHomePage();
		homePage.navigateTo(properties.getProperty("url"));
		homePage.isLoaded();
		scn.write("User is on home page");
		logger.info("User is on home page");
	}

	@Given("User is on {string} home page")
	public void user_is_on_home_page(String searchEngine) {
		testContext.getSharedMap().put("searchEngine", searchEngine);
		homePage = pom.getHomePage();
		switch (searchEngine) {
		case "bing":
			homePage.navigateTo(properties.getProperty("bingUrl"));
			homePage.isLoaded();
			scn.write(String.format("User is on %s page", searchEngine));
			logger.info(String.format("User is on %s page", searchEngine));
			break;
		case "google":
			homePage.navigateTo(properties.getProperty("googUrl"));
			homePage.isLoaded();
			scn.write(String.format("User is on %s page", searchEngine));
			logger.info(String.format("User is on %s page", searchEngine));
			break;
		default:
			homePage.navigateTo(properties.getProperty("googUrl"));
			homePage.isLoaded();
			break;
		}
	}

	@When("User perform search with {string}")
	public void user_perform_search_with(String searchKey) throws InterruptedException {
		testContext.getSharedMap().put("searchKey", searchKey);
		homePage.enterSearchWord(searchKey);
		homePage.clickSearch();
		scn.write("User click search button");
		logger.info("User click search button");
	}

	@Then("User see all the valid search results")
	public void user_see_all_the_valid_search_results() throws InterruptedException {
		resultsPage = pom.getResultsPage();
		resultsPage.isLoaded();
		logger.info("Validate search results present");
		resultsPage.validateSearchResults();
		logger.info("Validate search result by index");
		resultsPage.validateSearchResultsByIndex(0, testContext.getSharedMap().get("searchKey"));
		logger.info("Validate all search results");
		resultsPage.validateAllSearchResults(testContext.getSharedMap().get("searchKey"));
	}

	@AfterStep
	public void afterEachStep(Scenario scn) throws IOException {
		if ("true".equals(properties.getProperty("isDebug"))) {
			// takeScreenshot(driver, scn, scn.getName().replaceAll(" ", "_"));
			takeScreenshot(testContext.getDriver(), scn, scn.getName().replaceAll(" ", "_"));
		}
	}

	@After
	public void tearDown(Scenario scn) throws IOException {
		logger.info("Scenario execution status: " + scn.getStatus());
		if (scn.isFailed()) {
			// takeScreenshot(driver, scn, scn.getName().replaceAll(" ", "_"));
			logger.info("Scenario failed: " + scn.getName());
			takeScreenshot(testContext.getDriver(), scn, scn.getName().replaceAll(" ", "_"));
		}
		if (driver != null) {
			logger.info("Before closing the browser");
			driver.close();
			logger.info("Browser closed");
		}
	}
}
