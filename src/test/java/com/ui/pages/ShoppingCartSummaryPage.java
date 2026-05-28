package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ShoppingCartSummaryPage extends BrowserUtility
{
	public ShoppingCartSummaryPage(WebDriver driver)
	{
		super(driver);
	}
	
	private static final By PROCEED_TO_CHECKOUT_LOCATOR = By.xpath("//p/a[@title='Proceed to checkout']");
	
	public AddressPage3 goToAddressPage()
	{
		clickOn(PROCEED_TO_CHECKOUT_LOCATOR);
		AddressPage3 addressPage3 = new AddressPage3(getDriver());
		return addressPage3;
	}
}
