package com.ui.tests;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserStackUtility;
import com.utility.BrowserUtility;

public class Test_Base {

	protected HomePage homePage;
	
	private static Boolean isBrowserStackTest;
	
	@Parameters({"browser" , "isBrowserStackTest" , "isHeadless"})
	
	@BeforeMethod(description= "Loads the homepage of the website")
	public void setup(@Optional("chrome") String browser,
			@Optional("false") Boolean isBrowserStackTest,
			@Optional("false") Boolean isHeadless,
			Method method)
	{
		String testName =	method.getName();
		
		WebDriver browserStackDriver;
		
		if(isBrowserStackTest)
		{
			browserStackDriver =	BrowserStackUtility.initializeBrowserStackSession(Browser.valueOf(browser.toUpperCase()), testName);
			homePage = new HomePage(browserStackDriver);
		}
		else
		{
			homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), false);
		}
	}
	
	public BrowserUtility getInstance()
	{
		return homePage;
	}
	
	
	@AfterMethod(description="Closes the driver session")
	public void quit()
	{
		if(isBrowserStackTest)
		{
			BrowserStackUtility.quitSession();
		}
		else
		{
			homePage.quit();
		}
	}
	
	
}
