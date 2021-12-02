package com.virtusa.demo.stepDefinitions;

import com.virtusa.demo.context.TestContext;

public class GoogleSearchStepDef2 extends BaseSteps {

	TestContext testContext;

	public GoogleSearchStepDef2(TestContext testContext) {
		super();
		this.testContext = testContext;
	}

	/*
	 * @When("User perform search with {string}") public void
	 * user_perform_search_with(String searchKey) throws InterruptedException { //
	 * sharedMap.put("searchKey", searchKey);
	 * testContext.getSharedMap().put("searchKey", searchKey);
	 * testContext.getPageObjectManager().getHomePage().enterSearchWord(searchKey);
	 * testContext.getPageObjectManager().getHomePage().clickSearch();
	 * testContext.getScenario().write("User click search button"); }
	 */
}
