package com.virtusa.demo.runner;
import org.junit.runner.RunWith;

import com.virtusa.demo.stepDefinitions.BaseSteps;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class) 
@CucumberOptions(features="src/test/resources/features/",
				dryRun=false,
				glue="com.virtusa.demo.stepDefinitions",
				tags= "@test",
				plugin = {"pretty", "html:target/html/","json:target/json/file.json",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
				monochrome=true) 
public class TestRunner extends BaseSteps {
	
}
