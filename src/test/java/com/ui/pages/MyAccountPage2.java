package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class MyAccountPage2 extends BrowserUtility {

	public MyAccountPage2(WebDriver driver)
	{
		super(driver);
	}
	
	private static final By ADD_MY_FIRST_ADDRESS_LOCATOR = By.xpath("//a[@title='Add my first address']");
	
	
	public AddressPage2 goToAddressPage()
	{
		clickOn(ADD_MY_FIRST_ADDRESS_LOCATOR);
		AddressPage2 addressPage2 = new AddressPage2(getDriver());
		return addressPage2;
	}
}
