package com.utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.constants.Browser;

public class BrowserStackUtility {

	public static final String USERNAME = "harpreetkaur_5UINzJ";
	public static final String ACCESS_KEY = "6RWhyKtdv8X7eC7WLqWx";
	
	public static final String HUB_URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	
	private static ThreadLocal<WebDriver> driverLocal = new ThreadLocal<>();
	
	private static ThreadLocal<MutableCapabilities> capabilitiesLocal = new ThreadLocal<>();
	
	public static WebDriver initializeBrowserStackSession(Browser browser , String testName)
	{
		MutableCapabilities capabilities = new MutableCapabilities();
		HashMap<String, Object> bstackOptions = new HashMap<String, Object>();
		capabilities.setCapability("browserName", browser.name().toUpperCase());
		bstackOptions.put("os", "Windows");
		bstackOptions.put("osVersion", "11");
		bstackOptions.put("browserVersion", "148.0");
		bstackOptions.put("consoleLogs", "info");
		bstackOptions.put("seleniumVersion", "4.43.0");
		bstackOptions.put("buildName", "Selenium 4");
		bstackOptions.put("sessionName", testName);
		HashMap<String, Object> chromeOptions = new HashMap<String, Object>();
		chromeOptions.put("driver", "148.0.7778.97");
		bstackOptions.put("chrome", chromeOptions);
		capabilities.setCapability("bstack:options", bstackOptions);
		capabilitiesLocal.set(capabilities);
		
		WebDriver driver = null;
		try {
				driver = new RemoteWebDriver(	new URL(HUB_URL) , capabilitiesLocal.get());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driverLocal.set(driver);
		
		return driverLocal.get();

	}
	
	public static WebDriver getDriver() {
        return driverLocal.get();
    }
	
	public static void quitSession()
	{
		if(driverLocal.get()!= null)
		{
			driverLocal.get().quit();
		}
	}

}
