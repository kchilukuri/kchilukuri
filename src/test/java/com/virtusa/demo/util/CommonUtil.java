package com.virtusa.demo.util;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;

public class CommonUtil {

	public static void inputData(WebDriver driver, WebElement element, String text) throws InterruptedException {
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		element.clear();
		element.sendKeys(text);
		Thread.sleep(2000);
	}

	public static void clickElement(WebDriver driver, WebElement element) throws InterruptedException {
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(element));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		element.click();
	}

	public static void takeScreenshot(WebDriver driver, Scenario scn, String fileName) throws IOException {
		TakesScreenshot sc = (TakesScreenshot) driver;
		byte[] screenshotAs = sc.getScreenshotAs(OutputType.BYTES);
		// FileUtils.copyFile(screenshotAs, new
		// File("C:\\Users\\padhu\\eclipse-workspace\\demo\\src\\test\\java\\com\\virtusa\\demo\\screenshots\\"+fileName+".png"));
		scn.embed(screenshotAs, "image/png");
	}

}
