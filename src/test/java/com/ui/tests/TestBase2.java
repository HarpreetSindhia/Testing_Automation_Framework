package com.ui.tests;

import java.lang.reflect.Method;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserStackUtility;
import com.utility.BrowserUtility;

public class TestBase2 {
	
	protected HomePage homePage;
	
	private Boolean isBrowserStackTest;
	
	@Parameters({"browser" , "isBrowserStackTest" , "isHeadless"})

	@BeforeMethod(description= "Loads the homepage of the website")
	public void setUp(
			
			@Optional("chrome")String browser , 
			@Optional("true") Boolean isBrowserStackTest, 
			@Optional("true") Boolean isHeadless, Method method)
	{
		String testName =	method.getName();
		
		this.isBrowserStackTest = isBrowserStackTest;
		
		if(isBrowserStackTest)
		{
			WebDriver browserStackDriver;
			browserStackDriver =	BrowserStackUtility.initializeBrowserStackSession(Browser.valueOf(browser.toUpperCase()), testName);
			homePage = new HomePage(browserStackDriver);
			
		}
		else
		{
					
			homePage = new HomePage(Browser.valueOf(browser.toUpperCase()),false);
		}
	}
	
	public BrowserUtility getInstance()
	{
		return homePage;
	}

	
	@AfterMethod
	public void tearDown2(ITestResult result)
	{
		if(isBrowserStackTest)
		{
			WebDriver driver =	BrowserStackUtility.getDriver();
			
			if(driver!= null)
			{
				String testName =	result.getName();
				if(result.isSuccess())
				{
					((JavascriptExecutor)driver).executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Test'"+ testName + "'Passed Successfully!\"}}");
				}
				else
				{
					((JavascriptExecutor)driver).executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Test '"+ testName +"' Failed\"}}");
					
				}
				
				BrowserStackUtility.quitSession();
				
			}
			
			else
			{
				homePage.quit();
			}
		}
	}
	
	


	
	
}
