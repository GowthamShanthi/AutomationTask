package com.sauce.test.GoogleSearch;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import com.aventstack.extentreports.Status;

public class CommonComponents extends BaseClass {

	public static void launchDriver() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", UserDir + "/Resources/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		
		// This is used to disable Notification Popup
		
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();

		
		test.log(Status.PASS, "URL launched successfully");
		System.out.println("URL Launched Successfully");

		// This is used to Locate the Used Car element
		WebElement usedCar1 = driver.findElement(By.xpath("//span[text()='USED CAR ']"));
		String text = driver.findElement(By.xpath("//span[text()='USED CAR ']")).getText();
		System.out.println("" + text);

		// This is used to locate the Cars in City Element
		WebElement carInCity = driver.findElement(By.xpath("//a[@title='Cars In Your City']"));
		String text1 = driver.findElement(By.xpath("//a[@title='Cars In Your City']")).getText();
		System.out.println("" + text1);

		// This is used to locate the Chennai - Location Element
		WebElement location = driver.findElement(By.xpath("//a[@title='Used Cars In Chennai']/span"));

		// This is used to Hover the Menu Items
		Actions act1 = new Actions(driver);
		act1.moveToElement(usedCar1).build().perform();
		act1.moveToElement(carInCity).build().perform();
		act1.moveToElement(location).click().build().perform();

		WebElement budget = driver.findElement(By.xpath("//h3[text()='Budget']"));
		act1.moveToElement(budget).build().perform();
		String budgetText = driver.findElement(By.xpath("//h3[text()='Budget']")).getText();
		System.out.println("" + budgetText);

		// This is used to Validate the Budget Filter Pane
		
		try {
			if (budgetText.equalsIgnoreCase("budget"))
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", budget);
			System.out.println("Navigated to Budget Filter Pane");
		} catch (Exception e) {
			System.out.println("Budget Filter Pane Not Found");
			test.log(Status.FAIL, "Budget Filter Pane Not Found");
			takeScreenshotWithPath(UserDir + "/Reports/Screenshots", "filterPage");
		}

		// This is used to select the Price Filter
		
		WebElement ele = Util.getWebElementByXpath(driver, "//label[@title='2 - 5 Lakh']");
		ele.click();

		// This is used to Click the Fifth Car in the Result
		Util.clickWebElementByXpath(driver, "//div[@class='rowSpace marginTop20 gsc_row']/child::div[6]");

		// This is used to Click the Report tab
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		
		
		//WebElement report = driver.findElement(By.xpath("//div[contains(text(),'Report')]"));
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", report);
		//Util.clickWebElementByXpath(driver,"//div[contains(text(),'Report')]");
				
		//	"//*[@class='tabbingLpanel']//child::div[2]");
	}

	public static void productListPage() {
		System.out.println("Test Product List Page");
	}

}
