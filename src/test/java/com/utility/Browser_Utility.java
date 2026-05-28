package com.utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser_Utility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	private WebDriverWait wait;
	
	public void setDriver(WebDriver driverInstance)
	{
		driver.set(driverInstance);
	}
	
	public WebDriver getDriver()
	{
		return driver.get();
	}
	
	public Browser_Utility(WebDriver driverInstance)
	{
		driver.set(driverInstance);
		wait = new WebDriverWait(driverInstance , Duration.ofSeconds(30L));
	}
	
	public Browser_Utility(Browser browser , Boolean isHeadless)
	{
		if(browser == Browser.CHROME)
		{
			WebDriverManager.chromedriver().setup();
			
			if(isHeadless)
			{
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless='new'");
				options.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}
			else
			{
				driver.set(new ChromeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}
		}
		else if(browser == Browser.EDGE)
		{
			WebDriverManager.edgedriver().setup();
			
			if(isHeadless)
			{
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=new");
				options.addArguments("--disable-gpu");
				driver.set(new EdgeDriver(options));
				wait = new WebDriverWait(driver.get() , Duration.ofSeconds(30L));
			}
			else
			{
				driver.set(new EdgeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}
		}
		else if(browser == Browser.FIREFOX)
		{
			WebDriverManager.firefoxdriver().setup();
			
			if(isHeadless)
			{
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=new");
				options.addArguments("--disable-gpu");
				driver.set(new FirefoxDriver(options));
				wait = new WebDriverWait(driver.get() , Duration.ofSeconds(30L));
				
			}
			else
			{
				driver.set(new FirefoxDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}
		}
	}
	
	public void clickOn(By locator)
	{
		WebElement element =	wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}
	
	
	
	
}
