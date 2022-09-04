package com.sauce.test.GoogleSearch;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Util extends BaseClass {
	public static WebElement getWebElementByID(WebDriver driver, String ID) {
		WebElement element = (new WebDriverWait(driver, 50)).until(ExpectedConditions.elementToBeClickable(By.id(ID)));
		return element;
	}

	public static WebElement getWebElementByClass(WebDriver driver, String className) {
		WebElement element = (new WebDriverWait(driver, 50))
				.until(ExpectedConditions.presenceOfElementLocated(By.className(className)));
		return element;
	}

	public static WebElement getWebElementByXpath(WebDriver driver, String xpath) {
		WebElement element = (new WebDriverWait(driver, 50))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		return element;

	}

	public static WebElement getWebElementByName(WebDriver driver, String Name) {
		WebElement element = (new WebDriverWait(driver, 50))
				.until(ExpectedConditions.elementToBeClickable(By.name(Name)));
		return element;

	}

	public static WebElement enterTextByID(WebDriver driver, String path, String value, String elementName) {
		try {
			WebElement element = driver.findElement(By.id(path));
			element.clear();
			element.sendKeys(value);
			return element;

		} catch (Exception e) {
			takeScreenshotWithPath(UserDir + "/Reports/Screenshots/", elementName);
		}
		return null;

	}

	public static WebElement enterTextByXPath(WebDriver driver, String path, String value, String elementName) {
		try {
			WebElement element = driver.findElement(By.xpath(path));
			element.clear();
			element.sendKeys(value);
			return element;

		} catch (Exception e) {
			takeScreenshotWithPath(UserDir + "/Reports/Screenshots/", elementName);
		}
		return null;

	}

	public static WebElement clickWebElementByXpath(WebDriver driver, String xpath) {
		WebElement element = (new WebDriverWait(driver, 50))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		element.click();
		return element;

	}

	public static boolean scrollToElement(WebDriver driver, WebElement webElement) {
		Boolean valid = false;
		try {

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", webElement);
			valid = true;

		} catch (Exception e) {

			valid = false;
		}
		return valid;
	}

	public static WebElement waitelementToBeClickable(WebDriver driver, By xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement wiatingelement = wait.until(ExpectedConditions.elementToBeClickable(xpath));
		return wiatingelement;

	}

}
