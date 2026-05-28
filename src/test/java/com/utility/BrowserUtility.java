package com.utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;
import com.constants.Size;
import com.constants.Size1;
import com.constants.SizePro;

public abstract class BrowserUtility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();//Declare instance variable -> driver
	
	private WebDriverWait wait;
	
	private JavascriptExecutor js;
	
	public WebDriver getDriver()
	{
		return driver.get();
	}
	
	public void setDriver(WebDriver driverInstance)
	{
		driver.set(driverInstance);
	}
	
	public BrowserUtility(WebDriver driverInstance)
	{
		driver.set(driverInstance);	//Initialize instance variable driver
		wait = new WebDriverWait(driverInstance , Duration.ofSeconds(30L));
	}
	
	public BrowserUtility(Browser browserName , Boolean isHeadless)
	{
		if(browserName == Browser.CHROME)
		{
			
			if(isHeadless)
			{
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=Old");
				options.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(options));
				wait = new WebDriverWait(driver.get() , Duration.ofSeconds(30L));
			}
			else
			{
				driver.set(new ChromeDriver());
				wait = new WebDriverWait(driver.get() , Duration.ofSeconds(30L));
			}
			
		}
		else if(browserName == Browser.EDGE)
		{
			
			if(isHeadless)
			{
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=Old");
				options.addArguments("disable-gpu");
				driver.set(new EdgeDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}
			else
			{
				driver.set(new EdgeDriver());
				wait = new WebDriverWait(driver.get() , Duration.ofSeconds(30L));
			}
			
		}
		else if(browserName == Browser.FIREFOX)
		{
			
			if(isHeadless)
			{
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=Old");
				options.addArguments("--disable-gpu");
				driver.set(new FirefoxDriver(options));
				wait = new WebDriverWait(driver.get() , Duration.ofSeconds(30L));
			}
			driver.set(new FirefoxDriver());
			wait = new WebDriverWait(driver.get() , Duration.ofSeconds(30L));
		}
	}
	
	public void javascriptClick(WebElement element)
	{
		
		JavascriptExecutor js = (JavascriptExecutor)driver.get();
		js.executeScript("arguments[0].click();", element);
	}
	
	public void goToWebsite(String url)//Wrapper method
	{
		driver.get().get(url);//Calling selenium method internally
	}
	
	public void maximizeWindow()
	{
		driver.get().manage().window().maximize();
	}
	
	public void clickOn(By locator)
	{
		WebElement element =	wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}
	
	public void enterText(By locator , String text)
	{
		WebElement element =	wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.sendKeys(text);
	}
	
	public String visibleText(By locator)
	{
		WebElement element =	wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element.getText();
	}
	
	public void enterSpecialKey(By locator , Keys keyToEnter)
	{
		WebElement element =	wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.sendKeys(keyToEnter);
	}
	
	public String getVisibleText(WebElement element)
	{
		return element.getText();
	}
	
	public List<String> getAllVisibleText1(By locator)
	{
		List<WebElement> elementList =	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		
		List<String> visibleTextList =	new ArrayList<>();
		
		for(WebElement element : elementList)
		{
			visibleTextList.add(getVisibleText(element));
		}
		
		return visibleTextList;
	}
	
	public List<String> getAllVisibleText3(By locator)
	{
		List<WebElement> elementList =	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		
		List<String> visibleTextList =	new ArrayList<>();
		
		for(WebElement element : elementList)
		{
			visibleTextList.add(getVisibleText(element));
		}
		
		return visibleTextList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public List<String> getAllVisibleText(By locator)
	{
		
		List<WebElement> elementList =	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		
		List<String> visibleTextList =	new ArrayList<>();
		
		for(WebElement element : elementList)
		{
			visibleTextList.add(getVisibleText(element));
		}
		
		return visibleTextList;
	}
	
	public List<WebElement> getAllProductList(By locator)
	{
		List<WebElement> elementList =	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		return elementList;
		
	}
	
	public void clickOnWebElement(WebElement element)
	{
		element.click();
	}
	
	public void clearText(By locator)
	{
		WebElement element =	driver.get().findElement(locator);
		
		element.clear();
	}

	public List<WebElement> getAllProductList2(By locator)
	{
		List<WebElement> elementList =	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		
		return elementList;
	}
	
	
	public void selectFromDropDownEnumValue(By locator , SizePro pro)
	{
		WebElement element =	driver.get().findElement(locator);
		Select dropDown = new Select(element);
		dropDown.selectByValue(pro.getValue());
	}
	
	public void selectFromDropDown(By locator, String option)
	{
		
		WebElement element = driver.get().findElement(locator);
		Select dropDown = new Select(element);
		dropDown.selectByValue(option);
	}
	
	
	
	public void selectFromDropDownEnumValue(By locator , Size1 size1)
	{
		WebElement element =	wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
		Select dropDown = new Select(element);
		
		dropDown.selectByValue(size1.getValue());
		
	}
	
	
	public void selectFromDropDownNew(By locator, Size size)
	{
		WebElement element =	driver.get().findElement(locator);
		Select dropDown = new Select(element);
		dropDown.selectByValue(size.getValue());;
		
	}
	
	
	public String getScreenshot(String name)
	{
		File src = ((TakesScreenshot)driver.get()).getScreenshotAs(OutputType.FILE);
		String path =	"./Screenshots/"+name+".png";
		File dest = new File(path);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	
	}
	
		public void quit()
		{
			driver.get().quit();
	}
}
