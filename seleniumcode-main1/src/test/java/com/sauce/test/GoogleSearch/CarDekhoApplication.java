package com.sauce.test.GoogleSearch;

import org.testng.annotations.Test;

import com.sauce.test.GoogleSearch.CommonComponents;

public class CarDekhoApplication extends CommonComponents {
  
	
@Test
  public void testScenario1() throws Exception {
	test = extent.createTest("GoogleSearch", "");
	launchDriver();
	//driver.quit();
	//productListPage();
  }
}

