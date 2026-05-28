package com.ui.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.utility.BrowserStackUtility;

public class Flipkart_Test2 extends TestBase2{

	
	@Test
	public void FlipkartTest() {
	    WebDriver driver =	BrowserStackUtility.getDriver();
	    driver.get("https://www.flipkart.com/");
	    System.out.println(driver.getTitle());
	    
	}
	
}
