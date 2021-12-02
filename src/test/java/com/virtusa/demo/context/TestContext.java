package com.virtusa.demo.context;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.virtusa.demo.pages.PageObjectManager;

import cucumber.api.Scenario;

public class TestContext {

	PageObjectManager pageObjectManager;
	WebDriver driver;
	Scenario scenario;
	Map<String, String> sharedMap = new HashMap<>();

	public Scenario getScenario() {
		return scenario;
	}

	public void setScenario(Scenario scenario) {
		this.scenario = scenario;
	}

	public Map<String, String> getSharedMap() {
		return sharedMap;
	}

	public void setSharedMap(Map<String, String> sharedMap) {
		this.sharedMap = sharedMap;
	}

	public PageObjectManager getPageObjectManager() {
		return new PageObjectManager(driver, scenario);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

}
